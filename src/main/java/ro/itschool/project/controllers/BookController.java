package ro.itschool.project.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.itschool.project.models.entities.Book;
import ro.itschool.project.services.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/books") // default mapping for get and post
public class BookController {

    //create REST APIs for CRUD operations for Book

    //@Autowired // not used a lot
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //create
    @PostMapping()
    public ResponseEntity<Book> createBook(@RequestBody Book book){ // serialization
        return ResponseEntity.ok(bookService.createBook(book));
    }


    //read
    @GetMapping()
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

}
