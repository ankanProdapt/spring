package com.learning.learningSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learning.learningSpring.model.Student;
import com.learning.learningSpring.model.StudentList;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentList studentList;
	
	@GetMapping
	public String page(Model model) {
		model.addAttribute("students", studentList.students);
		return "student";
	}
	
	@PostMapping("/add")
	public String handleAdd(@RequestParam(name="name", required=true) String name, 
			@RequestParam(name="score", required=true) int score) {
		Student newStudent = new Student(name, score);
		studentList.addStudent(newStudent);
		return "redirect:/student";
	}
	
	@PostMapping("/delete")
	public String handleDelete(@RequestParam(name="studentId", required=true) int id) {
		studentList.remove(id);
		return "redirect:/student";
	}
	
	
	@PostMapping("/update")
	public String handleUpdate(@RequestParam(name="studentId", required=true) int id,
			@RequestParam(name="studentEditedName", required=true) String name,
			@RequestParam(name="studentEditedScore", required=true) int score) {
		studentList.update(id, name, score);
		return "redirect:/student";
	}
}
