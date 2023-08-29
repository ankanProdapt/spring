package com.learning.learningSpring.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentList {
	public List<Student> students;
	public StudentList() {
		students = new ArrayList<>();
	}
	
	public void addStudent(Student s) {
		s.setId(getNextId());
		students.add(s);
		sort();
	}
	
	public void remove(int id) {
		for(Student s: students) {
			if(s.getId() == id) {
				students.remove(s);
				break;
			}
		}
		sort();
	}
	
	
	public void update(int id, String name, int score) {
		for(Student s: students) {
			if(s.getId() == id) {
				s.setName(name);
				s.setScore(score);
			}
		}
		sort();
	}
	
	public int getNextId() {
		int maxxId = 0;
		for(Student s: students) {
			maxxId = Math.max(maxxId, s.getId());
		}
		return maxxId + 1;
	}
	
	public void sort() {
		Collections.sort(students);
		int prevScore = Integer.MAX_VALUE;
		int prevRank = 0;
		int i = 0;
		for(Student student: students) {
			i++;
			if(student.getScore() != prevScore) {
				prevRank = i;
				prevScore = student.getScore();
			}
			student.setRank(prevRank);
			
		}
	}
}
