package com.example.demo.Repositories.Class;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Classes.ClassEntity;

@Repository
public interface ClassRepo extends JpaRepository<ClassEntity, Integer> {

}
