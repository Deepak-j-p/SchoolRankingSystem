package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.example.entity.StudentEntity;
import com.example.model.Student;

@Repository
public class SchoolDAOImpl implements SchoolDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Student> getAllStudentDetails() {
		
		Query query = entityManager.createQuery("Select s from StudentEntity s");
		List <StudentEntity> result = query.getResultList(); 
		Student s = null;
		List<Student> list = new ArrayList<>();
		
		for(StudentEntity se : result)
		{
			s = new Student();
			s.setId(se.getId());
			s.setName(se.getName());
			s.setMathMarks(se.getMathMarks());
			s.setChemMarks(se.getChemMarks());
			s.setPhyMarks(se.getPhyMarks());
			list.add(s);
		}
		
		return list;
	}

}
