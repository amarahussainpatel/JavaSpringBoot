package com.example.demo.dto;

import java.util.List;

public class StudentDTO_withoutClass {
private Integer userID;
	
	private String studentName;

	private Integer age;
	
	private StudentDetailDTO entityStudentDetails;
	
	private List<ClassDTO> JoinedClasses;

//	public List<ClassDTO> getJoinedClasses() {
//		return JoinedClasses;
//	}

	public void setJoinedClasses(List<ClassDTO> joinedClasses) {
		JoinedClasses = joinedClasses;
	}

	public StudentDetailDTO getEntityStudentDetails() {
		return entityStudentDetails;
	}

	public void setEntityStudentDetails(StudentDetailDTO entityStudentDetails) {
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
}
