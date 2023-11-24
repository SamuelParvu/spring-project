package ro.itschool.project.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.itschool.project.models.entities.Client;
import ro.itschool.project.services.ClientService;

@RestController
public class ClientController {

    ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/api/client")
    ResponseEntity<Client> createUser(@RequestParam String firstName, @RequestParam String secondName, @RequestParam String email){
        return  ResponseEntity.ok(clientService.createUser(firstName, secondName, email));
    }

    @GetMapping("/api/client/{id}")
    ResponseEntity<Client> getUser(@PathVariable long id){
        return ResponseEntity.ok(clientService.getUser(id));
    }
}
