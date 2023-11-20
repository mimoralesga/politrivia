package main.com.politrivia.politrivia.service;

import java.util.ArrayList;

import main.com.politrivia.politrivia.domain.Answer;
import main.com.politrivia.politrivia.domain.Question;


/**
 * Clase que proporciona servicios relacionados con una pregunta en un juego de trivia.
 */
public class QuestionService {
    private final Question question;  // La pregunta a la que se asocian los servicios.

    /**
     * Constructor de la clase QuestionService.
     *
     * @param question La pregunta a la que se asocian los servicios.
     */
    public QuestionService(Question question) {
        this.question = question;
    }

    /**
     * Obtiene el texto de la pregunta.
     *
     * @return El texto de la pregunta.
     */
    public String getStatement() {
        return question.getStatement();
    }

    /**
     * Obtiene la lista de respuestas asociadas a la pregunta.
     *
     * @return La lista de respuestas asociadas a la pregunta.
     */
    public ArrayList<Answer> getAnswers() {
        return question.getAnswers();
    }
    
    /**
     * Obtiene la respuesta correcta de la pregunta.
     *
     * @return La respuesta correcta de la pregunta.
     */
    public Answer getRightAnswer() {
        Answer rightAnswer = null;
        ArrayList<Answer> answers = this.getAnswers();
        
        for (int i = 0; i < answers.size(); i++) {
            Answer answer = answers.get(i);
            
            if (answer.isRight()) {
                rightAnswer = answer;
            }
        }
        
        return rightAnswer;
    }
}

