package com.example.demo.adapter.student;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;

import com.example.demo.Entities.Classes.ClassEntity;
import com.example.demo.Entities.Student.StudentEntity;
import com.example.demo.Entities.StudentDetails.StudentDetailsEntity;
import com.example.demo.Repositories.Class.ClassRepo;
import com.example.demo.adapter.Class.ClassAdapter;
import com.example.demo.adapter.studentdetail.StudentDetailAdapter;
import com.example.demo.dto.ClassDTO;
import com.example.demo.dto.ClassDTO_withoutStudent;
import com.example.demo.dto.StudentDTO;
import com.example.demo.dto.StudentDTO_withoutClass;
import com.example.demo.dto.StudentDetailDTO;

public class StudentAdapter {
	private StudentDetailAdapter adapterdetail=new StudentDetailAdapter();
	
	@Autowired
	ClassRepo repo;
	
	public StudentDTO DAOToDTO(StudentEntity s) { //daotodto
		ClassAdapter adapterclass = new ClassAdapter();
		if(s!=null) {
			StudentDTO newDto = new StudentDTO();
			newDto.setUserID(s.getUserID());
			newDto.setStudentName(s.getStudentName());
			newDto.setAge(s.getAge());
			if(s.getEntityStudentDetails()!=null) {
				StudentDetailDTO detailDTO = adapterdetail.DAOToDTO(s.getEntityStudentDetails());
				newDto.setEntityStudentDetails(detailDTO);
			}
			if(null!=s.getJoinedClasses()) {
				List<ClassDTO> classes = new ArrayList<>();
				s.getJoinedClasses().stream().forEach(ClassEntity ->{
					s.addClass(ClassEntity);
					ClassEntity.addStudent(s);
					classes.add(adapterclass.DAOtoDTO_withoutStudents(ClassEntity));
				});
				newDto.setJoinedClasses(classes);
			}
			
			return newDto;
		}
		return null;
	}
	
	public StudentDTO DAOToDTO_forClass(StudentEntity s) { //daotodto
		ClassAdapter adapterclass = new ClassAdapter();
		if(s!=null) {
			StudentDTO newDto = new StudentDTO();
			newDto.setUserID(s.getUserID());
			newDto.setStudentName(s.getStudentName());
			newDto.setAge(s.getAge());
			if(s.getEntityStudentDetails()!=null) {
				StudentDetailDTO detailDTO = adapterdetail.DAOToDTO(s.getEntityStudentDetails());
				newDto.setEntityStudentDetails(detailDTO);
			}
			return newDto;
		}
		return null;
	}
	
//	public StudentEntity DTOToDAOwithClasses(StudentDTO dto){
//		StudentEntity s = DTOToDAO(dto);
//		ClassAdapter adapterclass = new ClassAdapter();
//		if(null!=dto.getJoinedClasses()) {
//			Set<ClassEntity> classSet = new HashSet<>();
//			dto.getJoinedClasses().stream().forEach(ClassDTO->{
//				classSet.add(adapterclass.DTOtoDAO(ClassDTO));
//			});
//			s.setJoinedClasses(classSet);
//		}
//		
//		return s;
//	}
	
	public StudentEntity DTOToDAO(StudentDTO dto){
		StudentEntity s = new StudentEntity(); //DAO
		if(null!=dto) {
			if(null !=dto.getUserID()) {
				s.setUserID(dto.getUserID());
			}
			s.setStudentName(dto.getStudentName());
			s.setAge(dto.getAge());
			
			if(null!=dto.getEntityStudentDetails()) {
				StudentDetailsEntity detail = adapterdetail.DTOToDAO(dto.getEntityStudentDetails());
				detail.setEntityStudent(s);
				s.setEntityStudentDetails(detail);
			}
			
			return s;
		}
		return null;
	}
	
	public StudentEntity DTOToDAO(StudentDTO dto,List<ClassEntity> classes){
		StudentEntity s = new StudentEntity(); //DAO
		if(null!=dto) {
			if(null !=dto.getUserID()) {
				s.setUserID(dto.getUserID());
			}
			s.setStudentName(dto.getStudentName());
			s.setAge(dto.getAge());
			
			if(null!=dto.getEntityStudentDetails()) {
				StudentDetailsEntity detail = adapterdetail.DTOToDAO(dto.getEntityStudentDetails());
				detail.setEntityStudent(s);
				s.setEntityStudentDetails(detail);
			}
			//iterating the list and 
			//mapping class entity with current student
			//mapping current student with each class in the list
			classes.stream().forEach(classEntity->{
				if(classEntity.getClassID() !=null ) {
					classEntity.addStudent(s);
					s.addClass(classEntity);
				}
			});
			return s;
		}
		return null;
	}
	
	public StudentEntity DTOToDAO(StudentDTO dto,StudentEntity s,String httpverb) {
		if(httpverb.equals("PUT")) {
			s.setUserID(dto.getUserID());
			s.setStudentName(dto.getStudentName());
			s.setAge(dto.getAge());
			return s;
		}
		else if(httpverb.equals("PATCH")) {
			if(null!=dto.getStudentName())s.setStudentName(dto.getStudentName());
			if(null!=dto.getAge())s.setAge(dto.getAge());
			return s;
		}
		return null;
	}
	
	public List<StudentDTO> DAOListToDTOList(List<StudentEntity> list) { //daotodto
		List<StudentDTO> newDto = new ArrayList<>();
		ClassAdapter adapterclass = new ClassAdapter();
		for(StudentEntity entity: list ) {
			StudentDTO newDtoObj = new StudentDTO();
			newDtoObj.setUserID(entity.getUserID());
			newDtoObj.setStudentName(entity.getStudentName());
			newDtoObj.setAge(entity.getAge());
			if(entity.getEntityStudentDetails()!=null) {
				StudentDetailDTO detailDTO = adapterdetail.DAOToDTO(entity.getEntityStudentDetails());
				//detailDTO.setEntityStudent(newDtoObj);
				newDtoObj.setEntityStudentDetails(detailDTO);
			}
			if(!entity.getJoinedClasses().isEmpty()) {
				List<ClassDTO> classEntity = new ArrayList<>();
				entity.getJoinedClasses().stream().forEach(ClassEnt->{
					classEntity.add(adapterclass.DAOtoDTO_withoutStudents(ClassEnt));
					
				});
				newDtoObj.setJoinedClasses(classEntity);
			}
			newDto.add(newDtoObj);
		}
		return newDto;
	}
	
//	public StudentDTO DAOOptionalToDTO(Optional<StudentEntity> s) { //daotodto
//		StudentDTO newDto = new StudentDTO();
//		if(s.isPresent()) {
//			StudentEntity s1=s.get();
//			newDto.setUserID(s1.getUserID());
//			newDto.setStudentName(s1.getStudentName());
//			newDto.setStudentName(s1.getStudentName());
//			newDto.setAge(s1.getAge());
//		}else {
//			throw new ConfigDataResourceNotFoundException(null);
//		}
//		return newDto;
//	}
	
//	public StudentEntity forDeleteDTOToDAO(StudentDTO dto) {
//		StudentEntity s = new StudentEntity(); //DAO
//		s.setUserID(dto.getUserID());
//		return s;
//	}
	
//	public StudentEntity forPutDTOToDAO(StudentDTO dto) {
//		StudentEntity s = new StudentEntity(); //DAO
//		s.setUserID(dto.getUserID());
//		s.setStudentName(dto.getStudentName());
//		s.setAge(dto.getAge());
//		return s;
//	}
//	
//	public StudentEntity forPatchDTOToDAO(StudentDTO dto) {
//		StudentEntity s = new StudentEntity(); //DAO
//		s.setUserID(dto.getUserID());
//		s.setStudentName(dto.getStudentName());
//		s.setAge(dto.getAge());
//		//if(dto.getStudentName()!=null)s.setStudentName(dto.getStudentName());
//		//if(dto.getAge()!=null)s.setAge(dto.getAge());
//		return s;
//	}
	
}
