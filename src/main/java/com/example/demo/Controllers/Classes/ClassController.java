package com.example.demo.Controllers.Classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.Classes.ClassEntity;
import com.example.demo.Exceptions.EmptyRequestException;
import com.example.demo.Exceptions.Null_IDException;
import com.example.demo.Services.Classes.ClassServiceInterface;
import com.example.demo.dto.ClassDTO;
import com.example.demo.dto.StudentDTO;

@RestController
@RequestMapping("api/courses")
public class ClassController {
	@Autowired
	ClassServiceInterface service;
	
	@PostMapping
	public ResponseEntity<?> addCourse(@RequestBody ClassDTO dto){
	
		try {
			service.save(dto);
			return ResponseEntity.ok("Course saved");
		} 
		catch (Null_IDException | EmptyRequestException e) {
			return ResponseEntity.ok("Bad Request");
		}	
	}
	
	@GetMapping
	public List<ClassDTO> getStudents(){
		return service.display();
	}

}
