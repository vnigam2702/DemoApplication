package com.demo.spring.boot.assignment.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.demo.spring.boot.assignment.document.Student;
import com.demo.spring.boot.assignment.service.IStudentService;
import com.demo.spring.boot.assignment.service.StudentServiceImpl;

/*
 ****************************************************************
 * Controller class 
 * exposes services to insert, update and search student records
 * 
 ****************************************************************
 */

@RestController
public class StudentRecordController {
	private Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
	
	@Autowired
	IStudentService studentImpl;

    //service to insert student record.
	@PostMapping (value = "/insert/student")
	public ResponseEntity<String> createStudent (@RequestBody Student obj) { 
		logger.info ("Entered StudentRecordController::createStudent");
		studentImpl.createStudentRec (obj);
	    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                 .path("/{id}")
                 .buildAndExpand(obj.getId())
                 .toUri();
		return ResponseEntity.created(location).build();
}

	//service to update student record
	@PutMapping (value = "/update/student/{id}")
	public  ResponseEntity<Student> updateStudent (@PathVariable int id, @RequestBody Student s) {
		logger.info ("Entered StudentRecordController::updateStudent");
		Optional<Student> student = studentImpl.getRecordById(id);
		if(!student.isPresent())
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		Student student_ref = student.get();
		student_ref.setAge(s.getAge());
		student_ref.setGrade(s.getGrade());
		studentImpl.update(student_ref);
		return new ResponseEntity<Student>(HttpStatus.OK);
	}

	//service to get the student record by age and grade
	@GetMapping ("/get/students/{age}/{grade}")
	public List<Student> searchStudent (@PathVariable int age, @PathVariable String grade) {
		logger.info ("Entered StudentRecordController::searchStudent");
		return studentImpl.getRecordByAgeAndGrade (age, grade);
	}

}
