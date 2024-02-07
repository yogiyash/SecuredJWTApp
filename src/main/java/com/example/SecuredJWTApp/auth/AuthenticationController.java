package com.example.SecuredJWTApp.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.InvalidParameterException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@ControllerAdvice
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody @Validated RegisterRequest request){
            return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody @Validated AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @ExceptionHandler(value = { MethodArgumentNotValidException.class})
    public ResponseEntity<AuthenticationResponse> handleExceptions(Exception ex){
        return ResponseEntity.badRequest().body(AuthenticationResponse.builder().message(ex.getMessage()).build());
    }
}
