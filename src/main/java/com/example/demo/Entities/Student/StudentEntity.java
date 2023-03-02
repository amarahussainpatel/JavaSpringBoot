package com.example.demo.Entities.Student;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.demo.Entities.Classes.ClassEntity;
import com.example.demo.Entities.StudentDetails.StudentDetailsEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name="Student")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "userID")
public class StudentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userID;
	
	@Column
	private String studentName;
	
	@Column
	private Integer age;
	
	@OneToOne
	(mappedBy = "entityStudent",
	
	cascade = CascadeType.ALL,
	orphanRemoval=true
	)
	private StudentDetailsEntity entityStudentDetails;
	
	@ManyToMany //in mappedby we write that reference variable in the joined entity
	(mappedBy = "Joinedstudents",
	fetch = FetchType.LAZY,
	cascade = CascadeType.MERGE
	)
	private Set<ClassEntity> JoinedClasses;
	
	public Set<ClassEntity> getJoinedClasses() {
		return JoinedClasses;
	}

	public void setJoinedClasses(Set<ClassEntity> joinedClasses) {
		JoinedClasses = joinedClasses;
	}

	public StudentDetailsEntity getEntityStudentDetails() {
		return entityStudentDetails;
	}

	public void setEntityStudentDetails(StudentDetailsEntity entityStudentDetails) {
		this.entityStudentDetails = entityStudentDetails;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}	
	
	public void addClass(ClassEntity classEntity) {
		if (this.JoinedClasses == null) {
			this.JoinedClasses = new HashSet<>();
		}
		this.JoinedClasses.add(classEntity);
	}
}
