package com.gpi.controller;

import com.gpi.entity.AdminForm;
import com.gpi.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:3000") 
@RestController
@RequestMapping("/admins")  // Changed from /students to /admins for better meaning
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;  

    // Create a new admin
    @PostMapping
    public ResponseEntity<AdminForm> createAdmin(@RequestBody AdminForm adminForm) {
        AdminForm savedAdminForm = adminRepository.save(adminForm);
        return new ResponseEntity<>(savedAdminForm, HttpStatus.CREATED);
    }

    // Get all admins
    @GetMapping
    public ResponseEntity<List<AdminForm>> getAllAdmins() {
        List<AdminForm> admins = adminRepository.findAll();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

    // Get an admin by adminId
    @GetMapping("/{adminId}")
    public ResponseEntity<AdminForm> getAdminById(@PathVariable String adminId) {
        Optional<AdminForm> admin = adminRepository.findById(adminId);
        return admin.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Update an admin
    @PutMapping("/{adminId}")
    public ResponseEntity<AdminForm> updateAdmin(@PathVariable String adminId, @RequestBody AdminForm adminDetails) {
        if (adminRepository.existsById(adminId)) {
            adminDetails.setAdminId(adminId);  // Make sure the id is set
            AdminForm updatedAdmin = adminRepository.save(adminDetails);
            return ResponseEntity.ok(updatedAdmin);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Delete an admin by adminId
    @DeleteMapping("/{adminId}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable String adminId) {
        if (adminRepository.existsById(adminId)) {
            adminRepository.deleteById(adminId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    @GetMapping("/code/{myCode}")
    public List<AdminForm> getClass(@PathVariable String myCode) {
    	return adminRepository.findBySubjectCode(myCode);
    }
}
