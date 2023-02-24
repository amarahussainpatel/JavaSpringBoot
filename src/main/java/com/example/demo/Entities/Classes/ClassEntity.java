package com.example.demo.Entities.Classes;

import java.util.HashSet;
import java.util.Set;

import com.example.demo.Entities.Student.StudentEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity(name="Class")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "ClassID")
public class ClassEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ClassID;
	
	@Column
	private String SubjectName;
	
	@Column
	private String RoomNo;
	@ManyToMany
	@JoinTable(
			name="student_course",
			joinColumns = @JoinColumn(name="ClassID"),
			inverseJoinColumns = @JoinColumn(name="userID")
			)
	private Set<StudentEntity> Joinedstudents;
	
//	@JoinColumn(name="userID")
//	private StudentEntity entityStudent;
	
	public Integer getClassID() {
		return ClassID;
	}

	public void setClassID(Integer classID) {
		ClassID = classID;
	}

	public String getSubjectName() {
		return SubjectName;
	}

	public void setSubjectName(String subjectName) {
		SubjectName = subjectName;
	}

	public String getRoomNo() {
		return RoomNo;
	}

	public void setRoomNo(String roomNo) {
		RoomNo = roomNo;
	}

	public Set<StudentEntity> getJoinedstudents() {
		return Joinedstudents;
	}

	public void setJoinedstudents(Set<StudentEntity> joinedstudents) {
		Joinedstudents = joinedstudents;
	}

	
	public void addStudent(StudentEntity student) {
		if (this.Joinedstudents == null) {
			this.Joinedstudents = new HashSet<>();
		}
		this.Joinedstudents.add(student);
	}

	
}
