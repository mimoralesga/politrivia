package main.com.politrivia.politrivia.service;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import main.com.politrivia.politrivia.domain.Answer;
import main.com.politrivia.politrivia.domain.Question;

/**
 * Clase que carga preguntas desde un archivo XML y las convierte en objetos Question.
 */
public class LoaderService {
	
	/**
     * Carga preguntas desde un archivo XML y las convierte en objetos Question.
     *
     * @param fileName El nombre del archivo XML que contiene las preguntas.
     * @return Una lista de preguntas cargadas desde el archivo XML.
     */
    public ArrayList<Question> loadQuestions(String fileName) {
        ArrayList<Question> questions = new ArrayList<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("src/assets/" + fileName);

            doc.getDocumentElement().normalize();
            NodeList questionList = doc.getElementsByTagName("question");

            for (int i = 0; i < questionList.getLength(); i++) {
                Node questionNode = questionList.item(i);

                if (questionNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element questionElement = (Element) questionNode;
                    String questionStatement = questionElement.getElementsByTagName("statement").item(0).getTextContent();
                    NodeList answerList = questionElement.getElementsByTagName("answer");
                    ArrayList<Answer> answers = new ArrayList<>();
                    for (int j = 0; j < answerList.getLength(); j++) {
                        Element answerElement = (Element) answerList.item(j);
                        String answerStatement = answerElement.getElementsByTagName("statement").item(0).getTextContent();
                        boolean answerRight = Boolean.parseBoolean(answerElement.getElementsByTagName("right").item(0).getTextContent());
                        Answer answer = new Answer(answerStatement, answerRight);

                        answers.add(answer);
                    }

                    questions.add(new Question(questionStatement, answers));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return questions;
    }
}

