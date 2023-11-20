package main.com.politrivia.politrivia.domain;

import java.util.ArrayList;

/**
 * Representa una pregunta en un juego de trivia.
 */
public class Question {
    private final String statement; // El texto de la pregunta.
    private final ArrayList<Answer> answers; // Lista de respuestas asociadas a la pregunta.

    /**
     * Constructor de la clase Question.
     *
     * @param statement El texto de la pregunta.
     * @param answers   La lista de respuestas asociadas a la pregunta.
     */
    public Question(String statement, ArrayList<Answer> answers) {
        this.statement = statement;
        this.answers = answers;
    }

    /**
     * Obtiene el texto de la pregunta.
     *
     * @return El texto de la pregunta.
     */
    public String getStatement() {
        return statement;
    }

    /**
     * Obtiene la lista de respuestas asociadas a la pregunta.
     *
     * @return La lista de respuestas asociadas a la pregunta.
     */
    public ArrayList<Answer> getAnswers() {
        return answers;
    }
}
