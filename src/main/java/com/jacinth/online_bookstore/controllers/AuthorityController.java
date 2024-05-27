package com.jacinth.online_bookstore.controllers;

import com.jacinth.online_bookstore.dtos.AddAuthoritiesDTO;
import com.jacinth.online_bookstore.dtos.AuthorityDTO;
import com.jacinth.online_bookstore.services.serviceInterfaces.AuthorityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/authorities")
public class AuthorityController {

    @Autowired
    private AuthorityService authorityService;

    @PostMapping("/add")
    public ResponseEntity<String> addAuthority(@Valid @RequestBody AuthorityDTO authorityDTO) {
        authorityService.addAuthority(authorityDTO.getUserId(), authorityDTO.getRole());
        return ResponseEntity.ok("Authority added successfully.");
    }

    @PostMapping("/add/authorities")
    public ResponseEntity<String> addAuthorities(@RequestBody AddAuthoritiesDTO addAuthoritiesDTO) {
        try {
            Long userId = addAuthoritiesDTO.getUserId();
            Set<String> roles = addAuthoritiesDTO.getRoles();
            authorityService.addAuthorities(userId, roles);
            return ResponseEntity.ok("Authorities added successfully for user with ID: " + userId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to add authorities: " + e.getMessage());
        }
    }
}

