package com.example.demo.Services.Classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Classes.ClassEntity;
import com.example.demo.Entities.Student.StudentEntity;
import com.example.demo.Exceptions.EmptyRequestException;
import com.example.demo.Exceptions.Null_IDException;
import com.example.demo.Repositories.Class.ClassRepo;
import com.example.demo.adapter.Class.ClassAdapter;
import com.example.demo.adapter.student.StudentAdapter;
import com.example.demo.dto.ClassDTO;

import jakarta.transaction.Transactional;

@Service
public class ClassService implements ClassServiceInterface {
	
	@Autowired
	private ClassRepo repo;
	
	
	@Override
	public ClassDTO save(ClassDTO dto) throws Null_IDException, EmptyRequestException {
		ClassAdapter adapter = new ClassAdapter();
		if(dto==null) {
			throw new EmptyRequestException("Post request can not be empty");
		}
		if(null!=dto.getClassID()) {
			throw new Null_IDException("Class ID should be null");
		}
		ClassEntity temp = adapter.DTOtoDAO(dto);
		ClassEntity entity = repo.save(temp);
		
		return adapter.DAOtoDTO(temp);
	}

	@Override
	public List<ClassDTO> display() {
		// TODO Auto-generated method stub
		ClassAdapter adapter = new ClassAdapter();
		List<ClassEntity> entities = repo.findAll(); //saving in dao list
		return adapter.DAOListToDTOList(entities); //converting dao list to dto list
	}

	@Override
	public ClassDTO displaybyID(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClassDTO> delete(ClassDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClassDTO> updatebyPUT(ClassDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClassDTO> updatebyPatch(ClassDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
