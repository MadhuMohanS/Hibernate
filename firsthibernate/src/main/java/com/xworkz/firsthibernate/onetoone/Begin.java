package com.xworkz.firsthibernate.onetoone;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Begin {
public static void main(String[] args) {
	SessionFactory factory=new Configuration().configure().buildSessionFactory();
	Answer answer=new Answer();
	answer.setAnswerId(112);
	answer.setAnswer("java is an object oriented programming language");
	
	
	Answer answer1=new Answer();
	answer1.setAnswerId(113);
	answer1.setAnswer("servlet is an API");
	
	Question question=new Question();
	question.setQuestionId(101);
	question.setQuestion("what is java?");
	question.setAnswer(answer);
	
	answer.setQuestion(question);
	
	
	Question question1=new Question();
	question1.setQuestionId(102);
	question1.setQuestion("what is servlet?");
	question1.setAnswer(answer1);
	
	answer1.setQuestion(question1);
	
	Session session= factory.openSession();
//	Transaction tx =session.beginTransaction();
//	session.save(question);
//	session.save(answer);
//	session.save(question1);
//	session.save(answer1);
//	System.out.println("data successfully inserted");
//	tx.commit();
	
	
	//fetching....
	
//	Question q= session.get(Question.class, 101);
//	System.out.println(q.getQuestion());
//	System.out.println(q.getAnswer().getAnswer());
	
	String query="select q.questionId,q.question,a.answer from Question as q inner join q.answer as a";
	Query q2= session.createQuery(query);
	List<Object[]> list= q2.getResultList();
	for(Object[] o:list) {
		System.out.println(Arrays.toString(o));
	}
	
	
}
}
