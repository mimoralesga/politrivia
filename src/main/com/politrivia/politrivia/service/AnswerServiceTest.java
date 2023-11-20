package main.com.politrivia.politrivia.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.com.politrivia.politrivia.domain.Answer;

class AnswerServiceTest {
	
	private Answer answer;
	private AnswerService answerService;

	@BeforeEach
	void setUp() throws Exception {
		this.answer = new Answer("AnswerMock", false);
		this.answerService = new AnswerService(this.answer);
	}

	@Test
	void getStatement() {
		assertEquals(this.answer.getStatement(), answerService.getStatement());
	}
	
	@Test
	void isRight() {
		AnswerService answerService = new AnswerService(answer);
		
		assertEquals(this.answer.isRight(), answerService.isRight());
	}

}
