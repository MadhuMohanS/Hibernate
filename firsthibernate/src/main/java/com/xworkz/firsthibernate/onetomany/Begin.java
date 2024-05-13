package com.xworkz.firsthibernate.onetomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;





public class Begin {
public static void main(String[] args) {
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	OneQuestion question=new OneQuestion();
	question.setQuestionId(101);
	question.setQuestion("what is java");
	
	ManyAnswer answer=new ManyAnswer();
	answer.setAnswerId(112);
	answer.setAnswer("java is an object oriented programming language");
    answer.setQuestion(question);
	
	ManyAnswer answer2=new ManyAnswer();
	answer2.setAnswerId(113);
	answer2.setAnswer("it is used to build web application");
	answer2.setQuestion(question);
	
	ManyAnswer answer3=new ManyAnswer();
	answer3.setAnswerId(114);
	answer3.setAnswer("invented by james goslin");
	answer3.setQuestion(question);
	
	List<ManyAnswer> answers=new ArrayList<ManyAnswer>();
	answers.add(answer);
	answers.add(answer2);
	answers.add(answer3);
	
	question.setAnswers(answers);
	Session session= factory.openSession();
	
	OneQuestion q= session.get(OneQuestion.class,101 );
	System.out.println(q.getQuestion());
	System.out.println(q.getQuestionId());
//	System.out.println(q.getAnswers().size());
	
//	Transaction tx= session.beginTransaction();
//	session.save(question);
//	session.save(answer);
//	session.save(answer2);
//	session.save(answer3);
//	System.out.println("data successfully inserted");
//	tx.commit();
	factory.close();
}
}
