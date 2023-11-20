package main.com.politrivia.politrivia.service;

import main.com.politrivia.politrivia.domain.Topic;

/**
 * Clase que proporciona un servicio para obtener un tema (topic) basado en una opción numerica.
 */
public class TopicService {
    /**
     * Obtiene un tema (topic) basado en una opcion numérica.
     *
     * @param option La opcion numérica que representa un tema.
     * @return El tema correspondiente o null si la opcion no es valida.
     */
    public static Topic getTopic(int option) {
        return switch (option) {
            case 1 -> Topic.MATH;  // Si la opcion es 1, devuelve el tema de Matematicas.
            case 2 -> Topic.HTML;  // Si la opcion es 2, devuelve el tema de HTML.
            case 3 -> Topic.ENGLISH;  // Si la opcion es 3, devuelve el tema de HTML.
            case 4 -> Topic.CSS;  // Si la opcion es 4, devuelve el tema de HTML.
            default -> null;       // En otros casos, devuelve null.
        };
    }
}
