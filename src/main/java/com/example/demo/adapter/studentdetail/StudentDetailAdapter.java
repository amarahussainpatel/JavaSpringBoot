package com.example.demo.adapter.studentdetail;

import com.example.demo.Entities.Student.StudentEntity;
import com.example.demo.Entities.StudentDetails.StudentDetailsEntity;
import com.example.demo.dto.StudentDetailDTO;

public class StudentDetailAdapter {
	//uncalled
	public StudentDetailsEntity DTOToDAO(StudentDetailDTO dto,StudentEntity student) {
		StudentDetailsEntity s = new StudentDetailsEntity(); //DAO
		if(0!=dto.getStudentdetailID()) {
			s.setStudentdetailID(dto.getStudentdetailID());
		}
		s.setFirstname(dto.getFirstname());
		s.setLastname(dto.getLastname());
		s.setEnrolment(dto.getEnrolment());
		s.setEntityStudent(student);
		//s.setEntityStudent(null);
		return s;
	}
	
	public StudentDetailsEntity DTOToDAO(StudentDetailDTO dto) {
		StudentDetailsEntity s = new StudentDetailsEntity(); //DAO
		if(null!=dto.getStudentdetailID()) {
			s.setStudentdetailID(dto.getStudentdetailID());
		}
		s.setFirstname(dto.getFirstname());
		s.setLastname(dto.getLastname());
		s.setEnrolment(dto.getEnrolment());
		//s.setEntityStudent(null);
		return s;
	}
	
	public StudentDetailDTO DAOToDTO(StudentDetailsEntity studentdetail) { //daotodto
		StudentDetailDTO newDto = new StudentDetailDTO();
		newDto.setFirstname(studentdetail.getFirstname());
		newDto.setLastname(studentdetail.getLastname());
		newDto.setEnrolment(studentdetail.getEnrolment());
		newDto.setStudentdetailID(studentdetail.getStudentdetailID());
		return newDto;
	}
}
