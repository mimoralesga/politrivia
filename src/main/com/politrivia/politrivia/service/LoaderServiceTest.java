package main.com.politrivia.politrivia.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.com.politrivia.politrivia.domain.Answer;
import main.com.politrivia.politrivia.domain.Question;

class LoaderServiceTest {
	
	private LoaderService loadService;

	@BeforeEach
	void setUp() throws Exception {
		this.loadService = new LoaderService();
	}

	@Test
	void loadQuestions() {
		Random random = new Random();
		ArrayList<Question> questions = this.loadService.loadQuestions("mock-questions.xml");
		
		assertEquals(questions.size(), 1);
		
		int randomIndex = random.nextInt(questions.size());
        Question question = questions.remove(randomIndex);
        
        assertEquals(question.getStatement(), "Question Statement");
        
        ArrayList<Answer> answers = question.getAnswers();
        Answer answer = answers.get(0);
        
        assertEquals(answer.getStatement(), "First Answer Statement");
        assertEquals(answer.isRight(), true);
	}

}
