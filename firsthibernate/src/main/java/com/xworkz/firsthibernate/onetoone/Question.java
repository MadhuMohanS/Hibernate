package com.xworkz.firsthibernate.onetoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class Question {
	@Id
	@Column(name = "q_id")
	private int questionId;
	private String question;

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	@OneToOne
	@JoinColumn(name = "a_id")
	private Answer answer;

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", question=" + question + "]";
	}

	public Question() {
		System.out.println("running no-arg constructor of question");
	}

	public Question(int questionId, String question) {
		super();
		this.questionId = questionId;
		this.question = question;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
}
