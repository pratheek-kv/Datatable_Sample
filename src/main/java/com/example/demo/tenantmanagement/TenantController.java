package com.example.demo.tenantmanagement;

import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TenantController {

    @PostMapping("tenant/{id}")
    public ResponseEntity<String> getTenantById(@PathVariable("id") String id) {
        // Replace with your actual logic
        String jwt = null;
//        Authentication auth =  SecurityContextHolder.getContext().getAuthentication();

        return ResponseEntity.ok("Tenant ID: " + id);
    }
}
