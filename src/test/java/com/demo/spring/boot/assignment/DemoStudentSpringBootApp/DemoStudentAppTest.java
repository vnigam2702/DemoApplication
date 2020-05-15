package com.demo.spring.boot.assignment.DemoStudentSpringBootApp;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import com.demo.spring.boot.assignment.document.Student;

/*
 *****************************************************************************
 * JUnit Test class
 * includes test cases for testing exposed REST services.
 * 
 *****************************************************************************
 */


@RunWith (SpringRunner.class)
@SpringBootTest (classes = DemoStudentSpringBootAppApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
class DemoStudentAppTest {

	@LocalServerPort
    private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;

	//test method for insert service
	@Test
	public void testStudentRecInsert() {
		Student s = new Student(1002, 23, "A");
		ResponseEntity<String> responseEntity = this.restTemplate
		            .postForEntity("http://localhost:" + port + "/insert/student", s, String.class);
		assertEquals(201, responseEntity.getStatusCodeValue());
	}
	
	//test method for retrieve operation
	@Test
	public void testGetStudentByAgeGrade () {
	    Student s = new Student(1003, 23, "A");
		this.restTemplate
	            .postForEntity("http://localhost:" + port + "/insert/student", s, String.class);
		
		int age = 23;
        String grade = "A";
        String url = "http://localhost:" +port+ "/get/students/" +age+ "/" +grade;
        ResponseEntity<String> responseEntity = restTemplate.exchange (
                url,
                HttpMethod.GET,
                null,
                String.class
        );
        assertEquals (200, responseEntity.getStatusCodeValue());
    }
	
	//test method for update operation
	@Test
	public void testStudentRecUpdate () {
       	Student s = new Student (1001, 24, "B");
       	this.restTemplate.postForEntity ("http://localhost:" + port + "/insert/student", s, String.class);
       	
        s.setAge (25);
       	s.setGrade ("A");
        HttpHeaders headers = new HttpHeaders ();
        headers.setContentType (MediaType.APPLICATION_JSON);
       	HttpEntity<Student> request = new HttpEntity<Student> (s, headers);
       	ResponseEntity<String> responseEntity =  restTemplate.exchange ("http://localhost:" +port+ "/update/student/"+s.getId(), HttpMethod.PUT, request, String.class);
        assertEquals (200, responseEntity.getStatusCodeValue ());
      }
}
