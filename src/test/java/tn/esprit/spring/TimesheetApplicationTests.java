package tn.esprit.spring;

import static org.junit.Assert.assertEquals;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.services.DepartementServiceImpl;

@SpringBootTest
class TimesheetApplicationTests {

	@Autowired
	DepartementServiceImpl departSer ;

	@Test
	void contextLoads() {
	}



}
