package com.demo.spring.boot.assignment.service;

import java.util.List;
import java.util.Optional;

import com.demo.spring.boot.assignment.document.Student;

public interface IStudentService {

	public Student createStudentRec (Student s);
	public void update (Student s);
	public List<Student> getRecordByAgeAndGrade (int age, String grade);
	public Optional<Student> getRecordById (int id);

}
