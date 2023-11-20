package main.com.politrivia.politrivia.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.com.politrivia.politrivia.domain.Question;
import main.com.politrivia.politrivia.domain.Topic;

class TriviaServiceTest {
	
	private TriviaService triviaService;

	@BeforeEach
	void setUp() throws Exception {
		LoaderService loaderService = new LoaderService();
		this.triviaService = new TriviaService(loaderService);
	}

	@Test
	void initialize() {
		this.triviaService.initialize(Topic.MOCK);
		
		assertEquals(this.triviaService.getScore(), 0);
		assertEquals(this.triviaService.getAttempts(), 3);
	}
	
	@Test
	void createQuestion() {
		this.triviaService.initialize(Topic.MOCK);
		
		Question question = this.triviaService.createQuestion();
		
		assertEquals(question.getStatement(), "Question Statement");
	}
	
	@Test
	void goal() {
		this.triviaService.initialize(Topic.MOCK);
		
		this.triviaService.goal();
		
		assertEquals(this.triviaService.getScore(), 1);
	}
	
	void fail() {
		this.triviaService.initialize(Topic.MOCK);
		
		this.triviaService.fail();
		
		assertEquals(this.triviaService.getAttempts(), 3);
	}

}
