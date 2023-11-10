package ro.itschool.project.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Controller
public class TestController {
    @GetMapping("/test")
    public String testingStuff(){
        log.info("client has visited the /test endpoint");
        return "sometest";
    }
}



// @RequestParam(required = false) String name
//        return "my name: "+name;
