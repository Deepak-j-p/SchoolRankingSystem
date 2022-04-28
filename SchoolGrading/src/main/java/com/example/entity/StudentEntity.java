package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "School")
public class StudentEntity {
	
	@Id
	private int id;
	@Column(name = "student_name")
	private String name;
	private int mathMarks;
	private int chemMarks;
	private int phyMarks;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMathMarks() {
		return mathMarks;
	}
	public void setMathMarks(int mathMarks) {
		this.mathMarks = mathMarks;
	}
	public int getChemMarks() {
		return chemMarks;
	}
	public void setChemMarks(int chemMarks) {
		this.chemMarks = chemMarks;
	}
	public int getPhyMarks() {
		return phyMarks;
	}
	public void setPhyMarks(int phyMarks) {
		this.phyMarks = phyMarks;
	}
	
	

}
