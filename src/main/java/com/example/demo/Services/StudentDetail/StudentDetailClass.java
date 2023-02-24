package com.example.demo.Services.StudentDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Student.StudentEntity;
import com.example.demo.Entities.StudentDetails.StudentDetailsEntity;
import com.example.demo.Repositories.StudentDetail.StudentDetailRepo;
import com.example.demo.adapter.student.StudentAdapter;
import com.example.demo.adapter.studentdetail.StudentDetailAdapter;
import com.example.demo.dto.StudentDTO;
import com.example.demo.dto.StudentDetailDTO;

@Service
public class StudentDetailClass implements StudentDetailInterface {
	@Autowired
	StudentDetailRepo repo;
	
	public StudentDetailDTO save(StudentDetailDTO dto,StudentEntity st) {
		StudentDetailAdapter adapter = new StudentDetailAdapter();
		StudentDetailsEntity s = repo.save(adapter.DTOToDAO(dto,st));
		return adapter.DAOToDTO(s);
	}
}
