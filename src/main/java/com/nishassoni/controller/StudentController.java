package com.nishassoni.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nishassoni.beans.Student;

@RestController
@RequestMapping("students")
public class StudentController {
	
	@GetMapping("student")
	public ResponseEntity<Student> getStudent() {
		Student student = new Student(1, "Nisha", "Soni");
		return  ResponseEntity.ok().header("custom-header", "Nisha").body(student);
	}
	
	@GetMapping
	public ResponseEntity<List<Student>> getStudents(){
		List<Student> students = new ArrayList<>();
		students.add(new Student(1,"Nisha", "Soni"));
		students.add(new Student(2,"Amit", "Soni"));
		students.add(new Student(3,"Meet", "Soni"));
		return ResponseEntity.ok(students);
	}
	
	//Springboot REST API with path variable
	@GetMapping("{id}/{first-name}/{last-name}")
	public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId, @PathVariable("first-name")String firstName, @PathVariable("last-name")String lastName) {
		Student student = new Student(studentId, null, null);
		return ResponseEntity.ok(student);
		
	}
	
	//Request Param 
	@GetMapping("query")
	public ResponseEntity<Student> studentRequestVariable(@RequestParam int id) {
		Student student =  new Student (id, "Nisha", "Soni");
		return ResponseEntity.ok(student);
	}
	
	@PostMapping("create")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		System.out.println(student.getId());
		System.out.println(student.getFirstName());
		System.out.println(student.getLasstName());
		return new ResponseEntity<>(student, HttpStatus.CREATED);
	}
	
	//Spring boot Rest API that handle Http put Request --> Update
	@PutMapping("{id}/update")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
		System.out.println(student.getFirstName());
		System.out.println(student.getLasstName());
		return ResponseEntity.ok(student);
		
	}
	//Spring boot Rest API that handle Http Delete Request --> Delete
	@DeleteMapping("{id}/delete")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
		return ResponseEntity.ok("Student Record Deleted Succussfully");
	}

}
