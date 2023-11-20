package main.com.politrivia.politrivia.service;

import main.com.politrivia.politrivia.domain.Answer;

/**
 * Clase que proporciona servicios relacionados con una respuesta en un juego de trivia.
 */
public class AnswerService {
    private final Answer answer;  // La respuesta a la que se asocian los servicios.

    /**
     * Constructor de la clase AnswerService.
     *
     * @param answer La respuesta a la que se asocian los servicios.
     */
    public AnswerService(Answer answer) {
        this.answer = answer;
    }

    /**
     * Obtiene el texto de la respuesta.
     *
     * @return El texto de la respuesta.
     */
    public String getStatement() {
        return answer.getStatement();
    }

    /**
     * Verifica si la respuesta es la respuesta correcta.
     *
     * @return true si la respuesta es correcta, false en caso contrario.
     */
    public boolean isRight() {
        return answer.isRight();
    }
}

