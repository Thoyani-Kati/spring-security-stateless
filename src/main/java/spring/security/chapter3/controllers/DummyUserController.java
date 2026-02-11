package spring.security.chapter3.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DummyUserController {

    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.accepted().body("Hello from DummyUser!");
    }
    
}
