package com.xworkz.firsthibernate.onetomany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "question_info")
public class OneQuestion {
	@Id
	@Column(name = "q_id")
	private int questionId;

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", question=" + question + ", answers=" + answers + "]";
	}

	public OneQuestion(int questionId, String question, List<ManyAnswer> answers) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.answers = answers;
	}

	public OneQuestion() {
		super();
		// TODO Auto-generated constructor stub
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

	public List<ManyAnswer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<ManyAnswer> answers) {
		this.answers = answers;
	}

	private String question;
	@OneToMany(fetch = FetchType.EAGER)
	private List<ManyAnswer> answers;
}
