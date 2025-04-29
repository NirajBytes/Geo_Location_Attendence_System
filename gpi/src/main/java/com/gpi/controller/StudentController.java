package com.gpi.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gpi.entity.Student;
import com.gpi.repository.StudentRepository;
@CrossOrigin(origins = "http://localhost:3000") 
@RestController
public class StudentController {
	@Autowired 
	private StudentRepository studentRepository;

	@PostMapping("path")
	public ResponseEntity<Student> postMethodName(@RequestBody Student student ) {
		 Student savedStudent = studentRepository.save(student);
		return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
	}
	
	@GetMapping("getAll")
	public List<Student> getMethodName() {
		List<Student> savedStudent= studentRepository.findAll();
		return savedStudent;
	}
	
	
}
