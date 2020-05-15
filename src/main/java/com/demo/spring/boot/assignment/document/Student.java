package com.demo.spring.boot.assignment.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*
 ****************************************************************
 * Student Model class 
 * 
 ****************************************************************
 */
@Document(collection ="Student")
public class Student {

	@Id
	int id;
	int age;
	String grade;
	public Student(int id, int age, String grade) {
		super();
		this.id = id;
		this.age = age;
		this.grade = grade;
	}
	
	public Student() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
