package com.example.demo.dto;

import java.util.List;
import java.util.Set;

import com.example.demo.Entities.Classes.ClassEntity;
import com.example.demo.Entities.Student.StudentEntity;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

public class ClassDTO {
	private Integer ClassID;
	private String SubjectName;
	
	private String RoomNo;

	private List<StudentDTO_withoutClass> Joinedstudents;

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
	

	public List<StudentDTO_withoutClass> getJoinedstudents() {
		return Joinedstudents;
	}

	public void setJoinedstudents(List<StudentDTO_withoutClass> joinedstudents) {
		Joinedstudents = joinedstudents;
	}

	


}
