package main.com.politrivia.politrivia.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.com.politrivia.politrivia.domain.Answer;
import main.com.politrivia.politrivia.domain.Question;

class QuestionServiceTest {
	
	private Question question;
	private Answer rightAnswer;
	private QuestionService questionService;

	@BeforeEach
	void setUp() throws Exception {
		ArrayList<Answer> answers = new ArrayList<>();
		this.rightAnswer = new Answer("First Answer", true);
		answers.add(this.rightAnswer);
		answers.add(new Answer("Second Answer", false));
		
		this.question = new Question("Question", answers);
		this.questionService = new QuestionService(this.question);
	}

	@Test
	void getStatement() {
		assertEquals(this.question.getStatement(), questionService.getStatement());
	}
	
	@Test
	void getAnswers() {
		assertEquals(this.question.getAnswers(), this.question.getAnswers());
	}
	
	@Test
	void getRightAnswer() {
		assertEquals(this.rightAnswer, this.questionService.getRightAnswer());
	}

}
