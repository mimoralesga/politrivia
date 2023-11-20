package main.com.politrivia.politrivia.domain;

/**
 * Representa una respuesta en un juego de trivia.
 */
public class Answer {
    private final boolean right; // Indica si la respuesta es la correcta.
    private final String statement; // El texto de la respuesta.

    /**
     * Constructor de la clase Answer.
     *
     * @param statement El texto de la respuesta.
     * @param right     Indica si la respuesta es la correcta (true) o incorrecta (false).
     */
    public Answer(String statement, boolean right) {
        this.right = right;
        this.statement = statement;
    }

    /**
     * Verifica si esta respuesta es la respuesta correcta.
     *
     * @return true si la respuesta es correcta, false en caso contrario.
     */
    public boolean isRight() {
        return right;
    }

    /**
     * Obtiene el texto de la respuesta.
     *
     * @return El texto de la respuesta.
     */
    public String getStatement() {
        return statement;
    }
}
