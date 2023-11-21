package ro.itschool.project.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.itschool.project.services.GreetingService;

@RestController
public class GreeingController {

    // autowired is no longer needed in newer versions of spring
    GreetingService greetingService;

    public GreeingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/api/greet/{name}")
    public String Greet(@PathVariable String name){
        return greetingService.getGreeting(name);
    }
}
