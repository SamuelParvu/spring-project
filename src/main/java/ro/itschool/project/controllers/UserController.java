package ro.itschool.project.controllers;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.itschool.project.models.User;
import ro.itschool.project.services.UserService;

@RestController
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/user")
    ResponseEntity<User> createUser(@RequestParam String firstName,@RequestParam String secondName,@RequestParam String email){
        return  ResponseEntity.ok(userService.createUser(firstName, secondName, email));
    }

    @GetMapping("/api/user/{id}")
    ResponseEntity<User> getUser(@PathVariable long id){
        return ResponseEntity.ok(userService.getUser(id));
    }
}
