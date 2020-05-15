package com.demo.spring.boot.assignment.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.spring.boot.assignment.repository.StudentRepository;
import com.demo.spring.boot.assignment.service.IStudentService;
import com.demo.spring.boot.assignment.document.Student;

/*
 ***********************************************************
 * Service class 
 * calls DAO layer methods to perform CRUD operations.
 * 
 ***********************************************************
 */
@Service 
public class StudentServiceImpl implements IStudentService{

	private Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
	@Autowired
	StudentRepository studentRepository;
	
	//method to insert student record.
	public Student createStudentRec (Student obj) { 
		logger.info("Entered StudentServiceImpl::createStudentRec");
	    Student s = studentRepository.insert (obj);
	    if (s != null)
	       logger.info("student record created with id: {}", s.getId());
	    return s;
	  }

	//method to update student record
	public void update (Student s) {
		logger.info("Entered StudentServiceImpl::update");
		logger.info("updating student id: {}", s.getId());
		studentRepository.save (s);	
		logger.info("Student record updated");
	}

	//method to get the student record by age and grade
	public List<Student> getRecordByAgeAndGrade (int age, String grade) {
		logger.info("Entered StudentServiceImpl::getRecordByAgeAndGrade");
		logger.info("fetching students of {} years old and got {} grade",age,grade);
		return studentRepository.findStudentsByAgeAndGrade (age, grade);
	}

	//method to get the student record by id
	public Optional<Student> getRecordById(int id) {
		return studentRepository.findById(id);
	}
	
}
