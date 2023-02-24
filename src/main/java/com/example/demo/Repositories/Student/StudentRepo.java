package com.example.demo.Repositories.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Student.StudentEntity;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity, Integer> {
	
}
