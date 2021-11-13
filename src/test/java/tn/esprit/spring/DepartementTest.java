package tn.esprit.spring;



import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.services.DepartementServiceImpl;

import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@AutoConfigureWebTestClient
 class DepartementTest {
	
	@Autowired
	DepartementServiceImpl departSer ;
	
	/*@Test
	public void testGetDepartement() {
		assertEquals(0, departSer.getAllDepartements().size());

	}*/




}
