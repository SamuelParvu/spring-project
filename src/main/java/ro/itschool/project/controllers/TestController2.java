package ro.itschool.project.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class TestController2 {

//    @GetMapping("/test")
    public ResponseEntity<List<Double>> testingTwoControllersSimultaneously(){
        // doesn't work
//        List<Double> numList = Arrays.asList(42,3.141,1.414,2.718,1.618);
        List<Double> numList = new ArrayList<>();
        numList.add(42d);
        numList.add(3.141);
        numList.add(1.414);
        numList.add(2.718);
        numList.add(1.618);
        return ResponseEntity.ok().body(numList);
        // if you know what all these numbers are, you are a nerd! and i like you <3
    }
}
