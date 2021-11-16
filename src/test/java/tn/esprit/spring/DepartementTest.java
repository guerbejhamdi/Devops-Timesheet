package tn.esprit.spring;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.junit.Test;
import org.junit.jupiter.api.Tag;
import org.junit.runner.RunWith;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tn.esprit.spring.services.*;
import tn.esprit.spring.entities.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)

public class DepartementTest{
	@Autowired
	public DepartementServiceImpl departementServiceImpl;
	
	@Autowired
	public IEmployeService Emps;
	
	private static final Logger l= LogManager.getLogger(DepartementTest.class);
	@SuppressWarnings("squid:S2699")
	@Test
	public void testAddDep(){
		Departement dep= new Departement("Informatique");
		departementServiceImpl.ajouterDepartement(dep);
		//Emps.getSalaireMoyenByDepartementId(dep.getId());
		l.info("added dep successfully ");
	}
	


}