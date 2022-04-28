package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.model.Student;
import com.example.service.SchoolService;

@RestController
@RequestMapping(value = "/School")
public class SchoolController {
	
	@Autowired
	private SchoolService schoolService;

	@Autowired
	private Environment environment;
	
	@GetMapping(value = "/topThreeRanks")
	public ResponseEntity<List<Student>> getTopThreeRanks()
	{
		List <Student> list = schoolService.getTopThreeStudents();
		return new ResponseEntity<List<Student>>(list,HttpStatus.OK);
	}
	
	@GetMapping(value = "/subjectTopper/{subject}")
	public ResponseEntity<Student> getSubjectTopper(@PathVariable String subject) throws Exception
	{
		try 
		{
			Student s = schoolService.subjectTopper(subject);
			return new ResponseEntity<Student>(s,HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()));
		}
	}
}
