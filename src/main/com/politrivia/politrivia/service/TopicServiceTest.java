package main.com.politrivia.politrivia.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.com.politrivia.politrivia.domain.Topic;

class TopicServiceTest {

	@Test
	void getTopic() {
		assertEquals(Topic.MATH, TopicService.getTopic(1));
		assertEquals(Topic.HTML, TopicService.getTopic(2));	
		assertEquals(Topic.ENGLISH, TopicService.getTopic(3));	
		assertEquals(Topic.CSS, TopicService.getTopic(4));	
	}

}
