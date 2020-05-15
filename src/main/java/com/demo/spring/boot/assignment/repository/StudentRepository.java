package com.demo.spring.boot.assignment.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.demo.spring.boot.assignment.document.Student;

/*
 *****************************************************************************
 * Repository interface 
 * extends MongoRepository interface which exposes method for CRUD operations
 * 
 *****************************************************************************
 */

@Repository
public interface StudentRepository extends MongoRepository<Student, Integer>{
	
    @Query("{'$and':[ {'age':?0}, {'grade':?1} ]}")
	List<Student> findStudentsByAgeAndGrade (int age, String grade);
}  
