package com.example.demo.dto;


public class StudentDetailDTO {
	private Integer studentdetailID;
	
	private String firstname;
	 
	private String lastname;
	
	private int enrolment;
	
	//private StudentDTO entityStudent;
	
	public String getFirstname() {
		return firstname;
	}

//	public StudentDTO getEntityStudent() {
//		return entityStudent;
//	}
//
//
//	public void setEntityStudent(StudentDTO entityStudent) {
//		this.entityStudent = entityStudent;
//	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getEnrolment() {
		return enrolment;
	}

	public void setEnrolment(int enrolment) {
		this.enrolment = enrolment;
	}

	public Integer getStudentdetailID() {
		return studentdetailID;
	}

	public void setStudentdetailID(Integer studentdetailID) {
		this.studentdetailID = studentdetailID;
	}

	

}
