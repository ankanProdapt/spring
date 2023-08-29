package com.learning.learningSpring.model;

import org.springframework.stereotype.Component;

@Component
public class Student implements Comparable<Student>{
	private int id;
	private int rank;
	private int score;
	private String name;
	
	public Student() {
		
	}
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}
	public int getId() {
		return id;
	}
	public int getRank() {
		return rank;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int compareTo(Student other) {
		if(this.score < other.score)
			return 1;
		if(this.score > other.score)
			return -1;
		return this.name.compareTo(other.name);
	}
}
