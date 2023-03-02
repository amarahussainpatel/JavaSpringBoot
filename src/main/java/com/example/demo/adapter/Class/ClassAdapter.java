package com.example.demo.adapter.Class;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.demo.Entities.Classes.ClassEntity;
import com.example.demo.Entities.Student.StudentEntity;
import com.example.demo.adapter.student.StudentAdapter;
import com.example.demo.dto.ClassDTO;
import com.example.demo.dto.ClassDTO_withoutStudent;
import com.example.demo.dto.StudentDTO;
import com.example.demo.dto.StudentDTO_withoutClass;
import com.example.demo.dto.StudentDetailDTO;

public class ClassAdapter {

	public ClassEntity DTOtoDAO(ClassDTO dto) {
		StudentAdapter adapterstudent = new StudentAdapter();
		if(null!=dto) {
			ClassEntity entity = new ClassEntity();
			if(null!=dto.getClassID()) {
				entity.setClassID(dto.getClassID());
			}
			entity.setRoomNo(dto.getRoomNo());
			entity.setSubjectName(dto.getSubjectName());
//			if(null!=dto.getJoinedstudents()) {
//				Set<StudentEntity> studentSet = new HashSet<>();
//				dto.getJoinedstudents().stream().forEach(StudentDTO->{
//					studentSet.add(adapterstudent.DTOToDAO(StudentDTO));
//				});
//				entity.setJoinedstudents(studentSet);
//			}
			return entity;
		}
		else {
			return null;
		}
	}
	
	public ClassDTO DAOtoDTO(ClassEntity entity) {
		StudentAdapter adapterstudent = new StudentAdapter();
		if(null!=entity) {
			ClassDTO dto = new ClassDTO();
			dto.setClassID(entity.getClassID());
			dto.setRoomNo(entity.getRoomNo());
			dto.setSubjectName(entity.getSubjectName());
//			for students
			if(!entity.getJoinedstudents().isEmpty()) {
				List<StudentDTO> studentList= new ArrayList<>();
				entity.getJoinedstudents().stream().forEach(StudentEntity->{
					studentList.add(adapterstudent.DAOToDTO(StudentEntity));
				});
				dto.setJoinedstudents(studentList);
			}
			return dto;
		}
		else {
			return null;
		}
	}
	
	public ClassDTO DAOtoDTO_withoutStudents(ClassEntity entity) {
		StudentAdapter adapterstudent = new StudentAdapter();
		if(null!=entity) {
			ClassDTO dto = new ClassDTO();
			dto.setClassID(entity.getClassID());
			dto.setRoomNo(entity.getRoomNo());
			dto.setSubjectName(entity.getSubjectName());
			//for students
//			if(!entity.getJoinedstudents().isEmpty()) {
//				List<StudentDTO> studentList= new ArrayList<>();
//				entity.getJoinedstudents().stream().forEach(StudentEntity->{
//					studentList.add(adapterstudent.DAOToDTO(StudentEntity));
//				});
//				dto.setJoinedstudents(studentList);
//			}
			return dto;
		}
		else {
			return null;
		}
	}
	
	public List<ClassDTO> DAOListToDTOList(List<ClassEntity> list) { //daotodto
		StudentAdapter adapterstudent = new StudentAdapter();
		List<ClassDTO> newDto = new ArrayList<>();
		for(ClassEntity entity: list ) {
			ClassDTO newDtoObj = new ClassDTO();
			newDtoObj.setClassID(entity.getClassID());
			newDtoObj.setRoomNo(entity.getRoomNo());
			newDtoObj.setSubjectName(entity.getSubjectName());
			//for student
			if(entity.getJoinedstudents() !=null) {
				List<StudentDTO> studentList= new ArrayList<>();
				entity.getJoinedstudents().stream().forEach(StudentEntity->{
					StudentEntity.addClass(entity);
					studentList.add(adapterstudent.DAOToDTO_forClass(StudentEntity));
				});
				newDtoObj.setJoinedstudents(studentList);
			}
			newDto.add(newDtoObj);
		}
		return newDto;
	}
}
