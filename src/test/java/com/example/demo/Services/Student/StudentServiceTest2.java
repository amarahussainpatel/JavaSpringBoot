package com.example.demo.Services.Student;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.Entities.Student.StudentEntity;
import com.example.demo.Repositories.Student.StudentRepo;
import com.example.demo.dto.StudentDTO;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceTest2 {

	@InjectMocks
	StudentService service;
	
	@Mock
	private StudentRepo repo;
	
	@Test(expected = IllegalArgumentException.class)
	public void save_test_With_Invalid_Age() {
		StudentDTO mockdto = new StudentDTO();
		mockdto.setAge(-1);
		service.save(mockdto);
//		StudentEntity entity = new StudentEntity();
//		Mockito.when(repo.findById(1)).thenReturn(entity);
	}
	
	
	@Test()
	public void save_test_With_Valid_Age() {
		StudentDTO studentDto = new StudentDTO();
		studentDto.setAge(45);
		StudentEntity student = new StudentEntity();
		student.setAge(45);
		Mockito.when(repo.save(any())).thenReturn(student);
		StudentDTO result  = service.save(studentDto);
		assertEquals(result.getAge(), studentDto.getAge());
	}
	

}
