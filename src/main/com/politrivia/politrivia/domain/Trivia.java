package main.com.politrivia.politrivia.domain;

import java.util.ArrayList;

/**
 * Clase que representa un conjunto de preguntas para un juego de trivia.
 */
public class Trivia {

	private int score; // Numero de respuestas correctamente resueltas
	private int attempts;
	private ArrayList<Question> questions; // Lista de preguntas en la trivia.
	
	/**
	 * Constructor de la clase Trivia que permite crear una instancia de juego de trivia personalizada
	 * con una lista de preguntas, puntuacion inicial y número de intentos inicial.
	 *
	 * @param questions La lista de preguntas para el juego de trivia.
	 * @param score     La puntuación inicial del jugador en el juego.
	 * @param attempts  El número de intentos iniciales disponibles para el jugador.
	 */
	public Trivia(ArrayList<Question> questions, int score, int attempts) {
	    this.score = score;
	    this.attempts = attempts;
	    this.questions = questions;
	}
	
	/**
     * Obtiene la lista de preguntas que forman parte de la trivia.
     *
     * @return La lista de preguntas de la trivia.
     */
	public ArrayList<Question> getQuestions() {
		return questions;
	}
	
	/**
     * Establece la lista de preguntas que forman parte de la trivia.
     *
     * @param questions La lista de preguntas de la trivia.
     */
	public void setQuestion(ArrayList<Question> questions) {
		this.questions = questions;
	}
	
	/**
	 * Obtiene la puntuacion actual del jugador.
	 *
	 * @return La puntuacion actual del jugador.
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * Establece la puntuacion del jugador.
	 *
	 * @param score La nueva puntuacion del jugador.
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	/**
	 * Obtiene el numero de intentos realizados por el jugador.
	 *
	 * @return El numero de intentos realizados por el jugador.
	 */
	public int getAttempts() {
		return attempts;
	}
	
	/**
	 * Establece el numero de intentos realizados por el jugador.
	 *
	 * @param attempts El nuevo numero de intentos realizados por el jugador.
	 */
	public void setAttempts(int attempts) {
	    this.attempts = attempts;
	}
}
