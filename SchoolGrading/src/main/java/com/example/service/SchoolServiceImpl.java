package com.example.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.SchoolDAO;
import com.example.model.Student;

@Transactional
@Service
public class SchoolServiceImpl implements SchoolService {
	
	@Autowired
	private SchoolDAO schoolDao;

	@Override
	public List<Student> getTopThreeStudents() {
		
		List <Student> list = schoolDao.getAllStudentDetails();
		int maxScore1 = Integer.MIN_VALUE, maxScore2 = Integer.MIN_VALUE, maxScore3 = Integer.MIN_VALUE;
		Student maxScorer1 = null, maxScorer2 = null, maxScorer3 = null;
		int totalScore = 0;
		
		for(Student s:list)
		{
			totalScore = s.getChemMarks() + s.getMathMarks() + s.getPhyMarks();
			if(totalScore>maxScore1)
			{
				maxScore3 = maxScore2;
				maxScore2 = maxScore1;
				maxScore1 = totalScore;
				
				maxScorer3 = maxScorer2;
				maxScorer2 = maxScorer1;
				maxScorer1 = s;
			}
			else if(totalScore>maxScore2)
			{
				maxScore3 = maxScore2;
				maxScore2 = totalScore;
				
				maxScorer3 = maxScorer2;
				maxScorer2 = s;
			}
			else if(totalScore>maxScore3)
			{
				maxScore3 = totalScore;
				maxScorer3 = s;
			}
		}
		
		List <Student> result = new ArrayList<>();
		result.add(maxScorer1);
		result.add(maxScorer2);
		result.add(maxScorer3);
		return result;
	}

	@Override
	public Student subjectTopper(String subject) throws Exception {
		
		if(!(subject.equalsIgnoreCase("Physics") || subject.equalsIgnoreCase("Chemistry") || subject.equalsIgnoreCase("Maths")))
			throw new Exception("SchoolService.INVALID_SUBJECT");
		
		List <Student> list = schoolDao.getAllStudentDetails();
		int maxScore = Integer.MIN_VALUE;
		Student maxScorer = null;
		int marks = 0;
		for(Student s:list)
		{
			if(subject.equalsIgnoreCase("Physics"))
				marks = s.getPhyMarks();
			else if(subject.equalsIgnoreCase("Chemistry"))
				marks = s.getChemMarks();
			else
				marks = s.getMathMarks();
			
			if(marks>maxScore)
			{
				maxScore = marks;
				maxScorer = s;
			}
		}
		
		return maxScorer;
	}

}
