package com.gpi.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000") 
@RestController
public class GenerateLinkController {

    // Temporary in-memory storage of adminId and uniqueId. Consider using a DB for production
    private Map<String, String> uniqueIds = new HashMap<>();

    @GetMapping("/generate-link/{adminId}")
    public Map<String, String> generateLink(@PathVariable String adminId) {
        // Check if the adminId exists or needs further validation
        if (adminId == null || adminId.isEmpty()) {
            // Return a bad request or error if the adminId is not valid
            throw new IllegalArgumentException("Invalid adminId");
        }

        // Generate a unique ID for the class link
        String uniqueId = UUID.randomUUID().toString();

        // Store the generated link with the adminId for validation (optional in development)
        uniqueIds.put(adminId, uniqueId);

        // Construct the URL based on the given adminId and uniqueId
        String link = String.format("http://localhost:3000/student-form/%s/%s", adminId, uniqueId);

        // Log the generated link for debugging (optional)
        System.out.println("Generated link for adminId " + adminId + ": " + link);

        // Return the link wrapped in a map for the frontend
        Map<String, String> response = new HashMap<>();
        response.put("link", link);
        return response;
    }
}
