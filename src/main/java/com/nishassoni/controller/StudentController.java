package com.nishassoni.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nishassoni.beans.Student;

@RestController
public class StudentController {
	
	@GetMapping("student")
	public Student getStudent() {
		Student student = new Student(1, "Nisha", "Soni");
		return student;
	}
	
	@GetMapping("students")
	public List<Student> getStudents(){
		List<Student> students = new ArrayList<>();
		students.add(new Student(1,"Nisha", "Soni"));
		students.add(new Student(2,"Amit", "Soni"));
		students.add(new Student(3,"Meet", "Soni"));
		return students;
	}
	
	//Springboot REST API with path variable
	@GetMapping("students/{id}")
	public Student studentPathVariable(@PathVariable("id") int studentId) {
		return new Student(studentId,"Nisha", "Soni");
		
	}
	
	//Request Param 
	@GetMapping("students/query")
	public Student studentRequestVariable(@RequestParam int id) {
		return new Student (id, "Nisha", "Soni");
	}
	
	@PostMapping("students/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Student createStudent(@RequestBody Student student) {
		System.out.println(student.getId());
		System.out.println(student.getFirstName());
		System.out.println(student.getLasstName());
		return student;
	}
	
	//Spring boot Rest API that handle Http put Request --> Update
	@PutMapping("students/{id}/update")
	public Student updateStudent(Student student) {
		System.out.println(student.getFirstName());
		System.out.println(student.getLasstName());
		return student;
		
	}

}
