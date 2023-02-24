package com.example.demo.Controllers.Student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.Student.StudentService;
import com.example.demo.Services.Student.StudentServiceInterface;
import com.example.demo.dto.StudentDTO;

@RestController
public class StudentController {
	@Autowired
	StudentServiceInterface serve;
	
	
	@PostMapping("save")
	public StudentDTO postStudent(@RequestBody StudentDTO std) {
		return serve.save(std);
		
		//return ResponseEntity.ok("Student Saved");
	}
	
	@GetMapping("getall")
	public List<StudentDTO> getStudents(){
		return serve.display();
	}
	
	@GetMapping("search")
	public StudentDTO SearchStudent(@RequestBody StudentDTO std) {
		return serve.displaybyID(std.getUserID());
	}
	
	@DeleteMapping("delete")
	public List<StudentDTO> deleteStudent(@RequestBody StudentDTO std){
		return serve.delete(std);
	}
	
	@PutMapping("putupdate")
	public List<StudentDTO> updateStudentbyPut(@RequestBody StudentDTO std){
		return serve.updatebyPUT(std);
	}
	
	@PatchMapping("patchupdate")
	public List<StudentDTO> updateStudentbyPatch(@RequestBody StudentDTO std){
		return serve.updatebyPatch(std);
	}

}
