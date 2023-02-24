package com.example.demo.Repositories.StudentDetail;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.StudentDetails.StudentDetailsEntity;

public interface StudentDetailRepo extends JpaRepository<StudentDetailsEntity, Integer>  {

}
