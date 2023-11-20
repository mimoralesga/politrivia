package main.com.politrivia.politrivia.service;

import java.util.ArrayList;
import java.util.Random;

import main.com.politrivia.politrivia.domain.Question;
import main.com.politrivia.politrivia.domain.Topic;
import main.com.politrivia.politrivia.domain.Trivia;

/**
 * Clase que proporciona servicios relacionados con el manejo de un juego de trivia.
 */
public class TriviaService {
    private Trivia trivia;           // El juego de trivia actual.
    private final LoaderService loaderService;  // Servicio de carga de preguntas.

    /**
     * Constructor de la clase TriviaService.
     *
     * @param loaderService El servicio de carga de preguntas utilizado para cargar las preguntas del juego.
     */
    public TriviaService(LoaderService loaderService) {
        this.loaderService = loaderService;
    }

    /**
     * Inicializa el juego de trivia con un tema especifico.
     *
     * @param topic El tema seleccionado para el juego de trivia.
     */
    public void initialize(Topic topic) {
        String fileName = "";

        switch (topic) {
            case HTML -> fileName = "html-questions.xml";  // Asigna el nombre del archivo XML para el tema de HTML.
            case MATH -> fileName = "math-questions.xml";  // Asigna el nombre del archivo XML para el tema de Matematicas.
            case ENGLISH -> fileName = "english-questions.xml";  // Asigna el nombre del archivo XML para el tema de Ingles.
            case CSS -> fileName = "css-questions.xml";  // Asigna el nombre del archivo XML para el tema de CSS.
            case MOCK -> fileName = "mock-questions.xml";  // Asigna el nombre del archivo XML mock.
        }

        // Carga las preguntas desde el archivo XML y crea una nueva instancia de Trivia.
        ArrayList<Question> questions = loaderService.loadQuestions(fileName);
        this.trivia = new Trivia(questions, 0, 3);
    }

    /**
     * Crea una pregunta aleatoria del juego de trivia.
     *
     * @return Una pregunta aleatoria del juego o null si no quedan preguntas.
     */
    public Question createQuestion() {
        ArrayList<Question> questions = this.trivia.getQuestions();
        Random random = new Random();

        if (!questions.isEmpty()) {
            int randomIndex = random.nextInt(questions.size());
            Question question = questions.remove(randomIndex);

            return question;
        }

        return null;  // Retorna null si no quedan preguntas.
    }
    
    /**
     * Obtiene la puntuacion actual del jugador en el juego de trivia.
     *
     * @return La puntuacion actual del jugador.
     */
    public int getScore() {
    	return this.trivia.getScore();
    }
    
    /**
     * Incrementa la puntuacion del jugador en una unidad.
     */
    public void goal() {
    	int actualScore = this.trivia.getScore();
    	
    	// Incrementa la puntuacion en una unidad.
    	this.trivia.setScore(actualScore + 1);
    }
    
    /**
     * Obtiene el numero de intentos actualmente disponibles para el jugador en el juego de trivia.
     *
     * @return El numero de intentos disponibles.
     */
    public int getAttempts() {
        return this.trivia.getAttempts();
    }

    /**
     * Reduce en uno el numero de intentos disponibles para el jugador.
     */
    public void fail() {
        int actualAttempts = this.trivia.getAttempts();
        
        // Reduce el número de intentos en uno.
        this.trivia.setAttempts(actualAttempts - 1);
    }

}

