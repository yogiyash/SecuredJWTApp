package com.example.SecuredJWTApp.business;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
@RequiredArgsConstructor
public class BasicController {

    @GetMapping
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Hello secured endpoint");
    }
}
