package tn.esprit.spring;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.services.EmployeServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeTest {

	@Autowired
	private EmployeServiceImpl service;

	@MockBean
	private EmployeRepository repository;

	private static final Logger l= LogManager.getLogger(EmployeTest.class);

	@Test
	public void shouldUpdateEmailByEmployeId() {
		l.info("Testing update Email by employe Id ");
		int employeId = 1;
		String email="letaief.sofiene4@gmail.com";
		
		Employe emp = new Employe("Test", "Test", "Test@test.tn", "root", true, Role.INGENIEUR);
		Optional<Employe> empOptional = Optional.of(emp);
		l.info("mocking repository.findbyId() ");
		when(repository.findById(employeId)).thenReturn(empOptional);
		service.mettreAjourEmailByEmployeId(email,employeId);
		l.info("Testing result from service.mettreAJourEmail");
		assertEquals(email, empOptional.get().getEmail());
		l.info("Test shouldUpdateEmailByEmployeId Success ");
	}
	
	@Test
	public void shouldReturnListEmployes() {
		l.info("Testing return of list employes ");
		l.info("mochking repo.findAll() ");
		when(repository.findAll()).thenReturn(Stream
				.of(new Employe("Esprit", "tn", "sofiene@test.tn", "root", true, Role.INGENIEUR),
					new Employe("Sofienee", "Letaief", "letaief@test.tn", "root", true, Role.INGENIEUR))
				.collect(Collectors.toList()));
		l.info("Testing result from service.gettAllEmloyes");
		assertEquals(2, service.getAllEmployes().size());
		l.info("Test shouldReturnListEmployes Success ");
	}


	@Test
	public void shouldReturnEmployePrenomById() {
		
		l.info("Testing shouldReturnEmployePrenomById ");
		int employeId = 1;		
		Employe emp = new Employe("Letaief", "Sofiene", "Test@test.tn", "root", true, Role.INGENIEUR);
		Optional<Employe> empOptional = Optional.of(emp);
		l.info("mocking repository.findbyId() ");
		when(repository.findById(employeId)).thenReturn(empOptional);;	
		assertEquals("Sofiene", service.getEmployePrenomById(employeId));
		l.info("Test shouldReturnEmployePrenomById Success ");
	}
	

	

}
