package com.nishassoni.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

}
