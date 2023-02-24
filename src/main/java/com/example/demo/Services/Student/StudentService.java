package com.example.demo.Services.Student;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Classes.ClassEntity;
import com.example.demo.Entities.Student.StudentEntity;
import com.example.demo.Exceptions.Null_IDException;
import com.example.demo.Repositories.Class.ClassRepo;
import com.example.demo.Repositories.Student.StudentRepo;
import com.example.demo.Services.Classes.ClassService;
import com.example.demo.Services.Classes.ClassServiceInterface;
import com.example.demo.Services.StudentDetail.StudentDetailClass;
import com.example.demo.adapter.student.StudentAdapter;
import com.example.demo.dto.ClassDTO;
import com.example.demo.dto.StudentDTO;

import jakarta.transaction.Transactional;

@Service
public class StudentService implements StudentServiceInterface {
	
	@Autowired
	private StudentRepo repo;
	
	@Autowired
	private ClassRepo classrepo;
	
	public StudentDTO save(StudentDTO dto) {
		StudentAdapter adapter = new StudentAdapter();
		if(dto.getAge()<0) {
			throw new IllegalArgumentException("Should not be less than 0");
		}
		//extracting all the ids and saving it in list of integer bcs findallbyId takes iteratable list of id integers
		List<Integer> classIds=new ArrayList<>();
		if(dto.getJoinedClasses() != null) {
			for (ClassDTO classdto : dto.getJoinedClasses()) {
				classIds.add(classdto.getClassID());
			}
		}
		//the object of those ids is in the below list
		List<ClassEntity> classEntityList = classrepo.findAllById(classIds);
		StudentEntity entity = adapter.DTOToDAO(dto,classEntityList);
		StudentEntity s = repo.save(entity);
		return adapter.DAOToDTO(s);
	}

	@Override
	public List<StudentDTO> display() {
		StudentAdapter adapter = new StudentAdapter();
		List<StudentEntity> s = repo.findAll(); //saving in dao list
		return adapter.DAOListToDTOList(s); //converting dao list to dto list
	}

	@Override
	public StudentDTO displaybyID(int ID) {
		StudentAdapter adapter = new StudentAdapter();
		Optional<StudentEntity> s = repo.findById(ID);
		if(s.isPresent()) {
			return adapter.DAOToDTO(s.get());
		}
		return null;
	}

	@Override 
	public List<StudentDTO> delete(StudentDTO dto) {
		StudentAdapter adapter = new StudentAdapter();
		repo.delete(adapter.DTOToDAO(dto));
		List<StudentEntity> s = repo.findAll();
		return adapter.DAOListToDTOList(s);
	}
	
	@Override
	public List<StudentDTO> updatebyPUT(StudentDTO dto){
		StudentAdapter adapter = new StudentAdapter();
		Optional<StudentEntity> s = repo.findById(dto.getUserID());
		
		if(s.isPresent()) {
			StudentEntity student = adapter.DTOToDAO(dto, s.get(),"PUT");
			repo.save(student);
		}
		List<StudentEntity> list = repo.findAll();
		return adapter.DAOListToDTOList(list);
	}

	//used transactional here to update by patch. no more need to repo.save
	//bcs it will itself flush in the end if all goes successful
	//we can use transactional here coz the data findbyID is in EMF
	
	@Override
	@Transactional(rollbackOn = {IllegalArgumentException.class})
	public List<StudentDTO> updatebyPatch(StudentDTO dto){
		StudentAdapter adapter = new StudentAdapter();
		Optional<StudentEntity> s = repo.findById(dto.getUserID());
		
		if(s.isPresent()) {
		StudentEntity student = adapter.DTOToDAO(dto, s.get(),"PATCH"); 
		//repo.save(student); //commented it bcs we're using transactional, no need
		
		//used this exception below to see if there's an exception transaction rolls back or saves the data
		//throw new IllegalArgumentException("Transactional test");
		}
		List<StudentEntity> list = repo.findAll();
		return adapter.DAOListToDTOList(list);
	}
	
	
	
	
}
