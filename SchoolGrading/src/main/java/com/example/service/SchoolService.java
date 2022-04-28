package com.example.service;

import java.util.List;

import com.example.model.Student;

public interface SchoolService {
	
	public List<Student> getTopThreeStudents();
	public Student subjectTopper(String subject) throws Exception;

}
