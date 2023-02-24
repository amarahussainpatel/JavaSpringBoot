package com.example.demo.Services.Classes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Exceptions.EmptyRequestException;
import com.example.demo.Exceptions.Null_IDException;
import com.example.demo.dto.ClassDTO;
import com.example.demo.dto.StudentDTO;

@Service
public interface ClassServiceInterface {
	public ClassDTO save(ClassDTO dto) throws Null_IDException , EmptyRequestException;
	public List<ClassDTO> display();
	public ClassDTO displaybyID(int ID);
	public List<ClassDTO> delete(ClassDTO dto);
	public List<ClassDTO> updatebyPUT(ClassDTO dto);
	public List<ClassDTO> updatebyPatch(ClassDTO dto);
}
