package tn.esprit.spring;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
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


	@Test
	public void shouldUpdateEmailByEmployeId() {
		int employeId = 1;
		String email="letaief.sofiene4@gmail.com";
		Employe emp = new Employe("Test", "Test", "Test@test.tn", "root", true, Role.INGENIEUR);
		Optional<Employe> empOptional = Optional.of(emp);
		when(repository.findById(employeId)).thenReturn(empOptional);
		service.mettreAjourEmailByEmployeId(email,employeId);	
		assertEquals(email, empOptional.get().getEmail());
	}
	
	@Test
	public void shouldReturnListEmployes() {
		when(repository.findAll()).thenReturn(Stream
				.of(new Employe("Esprit", "tn", "sofiene@test.tn", "root", true, Role.INGENIEUR),
					new Employe("Sofienee", "Letaief", "letaief@test.tn", "root", true, Role.INGENIEUR))
				.collect(Collectors.toList()));
		
		assertEquals(2, service.getAllEmployes().size());
	}


	@Test
	public void shouldReturnEmployePrenomById() {
		int employeId = 1;
		
		Employe emp = new Employe("Letaief", "Sofiene", "Test@test.tn", "root", true, Role.INGENIEUR);
		Optional<Employe> empOptional = Optional.of(emp);
		when(repository.findById(employeId)).thenReturn(empOptional);;	
		assertEquals("Sofiene", service.getEmployePrenomById(employeId));
	}
	

}
