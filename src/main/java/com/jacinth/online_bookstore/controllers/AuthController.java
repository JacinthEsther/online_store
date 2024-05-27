package com.jacinth.online_bookstore.controllers;

import com.jacinth.online_bookstore.dtos.AuthenticationResponse;
import com.jacinth.online_bookstore.dtos.LoginDto;
import com.jacinth.online_bookstore.services.serviceInterfaces.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")

public class AuthController {
    private final AuthService authService;
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid LoginDto loginDto)  {
        return ResponseEntity.ok(authService.login(loginDto));
    }

}
