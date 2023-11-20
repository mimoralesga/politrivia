package main.com.politrivia.politrivia;

import java.util.ArrayList;
import java.util.Scanner;

import main.com.politrivia.politrivia.domain.Answer;
import main.com.politrivia.politrivia.domain.Question;
import main.com.politrivia.politrivia.domain.Topic;
import main.com.politrivia.politrivia.service.AnswerService;
import main.com.politrivia.politrivia.service.LoaderService;
import main.com.politrivia.politrivia.service.QuestionService;
import main.com.politrivia.politrivia.service.TopicService;
import main.com.politrivia.politrivia.service.TriviaService;

/** 
 * Clase principal que inicializara el juego.
 */
public class Politrivia {
	/**
	 * Método principal que inicia el juego de Politrivia.
	 *
	 * @param args Los argumentos de la línea de comandos (no se utilizan en este caso).
	 */
	public static void main(String[] args) {
		// Crear un objeto Scanner para la entrada del usuario.
		Scanner scanner = new Scanner(System.in);
		
		// Crear un servicio de carga de preguntas.
		LoaderService loaderService =  new LoaderService();
		
		// Crear un servicio de trivia que utiliza el servicio de carga.
		TriviaService triviaService = new TriviaService(loaderService);
		
		System.out.println("¡Bienvenido a Politrivia!");
		System.out.println("En este juego de trivia, tendrás la oportunidad de demostrar tu conocimiento en diferentes temas.");
		System.out.println("Tienes un total de tres intentos para responder correctamente las preguntas.");
		System.out.println("Al final del juego, te diremos tu puntaje final. ¡Buena suerte!");
		System.out.println("Temas disponibles:");
		System.out.println("1. Matemáticas");
		System.out.println("2. HTML");
		System.out.println("3. Ingles");
		System.out.println("4. CSS");
        
        // Obtener el tema seleccionado por el usuario.
        Topic topic = getSelectedTopic(scanner);
        
    	// Inicializar el servicio de trivia con el tema seleccionado.
        triviaService.initialize(topic);
        
    	// Iniciar el bucle principal del juego de trivia.
        runTriviaLoop(triviaService, scanner); 
	}
	
	/**
	 * Solicita al usuario que seleccione un tema y devuelve el tema seleccionado.
	 *
	 * @param scanner El objeto Scanner utilizado para la entrada del usuario.
	 * @return El tema seleccionado por el usuario.
	 */
	static Topic getSelectedTopic(Scanner scanner) {
		Topic topic = null;
		
		while (topic == null) {
        	System.out.print("Por favor, selecciona un tema: ");
        	int input = scanner.nextInt();
        	
        	// Utilizar el servicio de temas para obtener el tema seleccionado por el usuario.
        	topic = TopicService.getTopic(input);
        }
		
		return topic;
	}
	
	/**
	 * Inicia el bucle principal del juego de trivia.
	 *
	 * @param triviaService El servicio de trivia que proporciona las preguntas.
	 * @param scanner El objeto Scanner utilizado para la entrada del usuario.
	 */
	static void runTriviaLoop(TriviaService triviaService, Scanner scanner) {
		int questionNumber = 1;
        while (true) {
        	// Crear una pregunta utilizando el servicio de trivia.
            Question question = triviaService.createQuestion();
            
            // Crear un servicio de pregunta para manejar la pregunta actual.
            QuestionService questionService = new QuestionService(question);
            
            // Si no hay más preguntas disponibles, salir del bucle.
            if (question == null || triviaService.getAttempts() == 0) {
            	System.out.println("¡Se acabó el juego!");
            	break;
            }
            
            // Realizar la pregunta al jugador.
            askQuestion(triviaService, questionService, scanner, questionNumber);
            
            // Evaluar la respuesta del jugador.
            evaluateAnswer(triviaService, questionService, scanner);
            
            questionNumber++;
        }
        
        int finalScore = triviaService.getScore();
        System.out.println("Puntaje final: [" + String.valueOf(finalScore) + "/10]");
    }
	
	/**
	 * Muestra una pregunta y sus opciones de respuesta al jugador.
	 *
	 * @param questionService El servicio de pregunta que proporciona la pregunta y las respuestas.
	 * @param scanner El objeto Scanner utilizado para la entrada del jugador.
	 */
	private static void askQuestion(TriviaService triviaService, QuestionService questionService, Scanner scanner, int questionNumber) {
		// Obtener el enunciado de la pregunta y las respuestas disponibles.
        String statement = questionService.getStatement();
        ArrayList<Answer> answers = questionService.getAnswers();

        // Mostrar la pregunta al jugador.
        System.out.println("Pregunta #"+ String.valueOf(questionNumber)  +": " + statement + " [" + String.valueOf(triviaService.getAttempts()) + "/3]");
        
        // Mostrar las opciones de respuesta al jugador.
        for (int i = 0; i < answers.size(); i++) {
        	AnswerService answerService = new AnswerService(answers.get(i));

        	// Mostrar cada opción de respuesta numerada.
            System.out.println((i + 1) + ". " + answerService.getStatement());
        }
    }
	
	/**
	 * Evalúa la respuesta del jugador a una pregunta y muestra el resultado.
	 *
	 * @param questionService El servicio de pregunta que proporciona la pregunta y las respuestas.
	 * @param scanner El objeto Scanner utilizado para la entrada del jugador.
	 */
	private static void evaluateAnswer(TriviaService triviaService, QuestionService questionService, Scanner scanner) {
		// Obtener la respuesta correcta y las opciones de respuesta disponibles.
		Answer rightAnswer = questionService.getRightAnswer();
		ArrayList<Answer> answers = questionService.getAnswers();
		
		Answer selectedAnswer = null;
		
		// Solicitar al jugador que ingrese su respuesta hasta que se proporcione una respuesta válida.
	    while (selectedAnswer == null) {
	        System.out.print("Respuesta: ");
	        int selectedOption = scanner.nextInt();
	        
	        // Verificar si la opción seleccionada es válida.
	        if (selectedOption >= 1 && selectedOption <= answers.size()) {
	            selectedAnswer = answers.get(selectedOption - 1);
	        } else {
	            System.out.println("Opción no válida. Por favor, ingrese un número válido.");
	        }
	    }

		// Comprobar si la respuesta seleccionada es correcta y mostrar el resultado.
		if (selectedAnswer.isRight()) {
            System.out.println("¡Correcto!");
            triviaService.goal();
        } else {
            System.out.println("Incorrecto, la respuesta correcta es: " + rightAnswer.getStatement());
            triviaService.fail();
        }
    }

}
