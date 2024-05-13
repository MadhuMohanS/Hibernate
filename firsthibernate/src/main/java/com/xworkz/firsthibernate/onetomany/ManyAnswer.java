package com.xworkz.firsthibernate.onetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class ManyAnswer {
	@Id
	@Column(name = "a_id")
	private int answerId;

	public ManyAnswer(int answerId, String answer) {
		super();
		this.answerId = answerId;
		this.answer = answer;
	}
	
	@ManyToOne
	@JoinColumn(name="q_id")
	private OneQuestion question;

	public OneQuestion getQuestion() {
		return question;
	}

	public void setQuestion(OneQuestion question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", answer=" + answer + "]";
	}

	public ManyAnswer() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String answer;

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
