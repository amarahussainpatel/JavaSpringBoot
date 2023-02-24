package com.example.demo.Services.Student;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Exceptions.Null_IDException;
import com.example.demo.dto.StudentDTO;

@Service
public interface StudentServiceInterface {
	public StudentDTO save(StudentDTO dto);
	public List<StudentDTO> display();
	public StudentDTO displaybyID(int ID);
	public List<StudentDTO> delete(StudentDTO dto);
	public List<StudentDTO> updatebyPUT(StudentDTO dto);
	public List<StudentDTO> updatebyPatch(StudentDTO dto) ;
	
}
