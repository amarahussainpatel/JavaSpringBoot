package com.example.demo.Entities.StudentDetails;



import com.example.demo.Entities.Student.StudentEntity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity(name="StudentDetail")
public class StudentDetailsEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int studentdetailID;
	
	@Column
	private String firstname;
	
	@Column 
	private String lastname;
	
	@Column
	private int enrolment;
	
	@OneToOne
	@JoinColumn(name="userID")
	private StudentEntity entityStudent;
	
	public String getFirstname() {
		return firstname;
	}

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

	public StudentEntity getEntityStudent() {
		return entityStudent;
	}

	public void setEntityStudent(StudentEntity entityStudent) {
		this.entityStudent = entityStudent;
	}

	public int getStudentdetailID() {
		return studentdetailID;
	}

	public void setStudentdetailID(int studentdetailID) {
		this.studentdetailID = studentdetailID;
	}

}
