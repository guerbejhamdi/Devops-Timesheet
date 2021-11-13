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
		l.info("add successful ");
	}
	
	@After("execution(* tn.esprit.spring.service.*.*(..))")
	public void logMethodExit(JoinPoint joinPoint){
		String name= joinPoint.getSignature().getName();
		String msg="Out of method : " +name;
		l.info(msg);
	}
	
	@Around("execution(* tn.esprit.spring.service.*.*(..))")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
	long start = System.currentTimeMillis();
	Object obj = pjp.proceed();
	long elapsedTime = System.currentTimeMillis() - start;
	if (elapsedTime > 3000) {
		l.fatal("This process takes more than 3sec to execute");
	}
	
	String msg="Method execution time: " + elapsedTime + " milliseconds.";
	l.info(msg);
		return obj;
	}

}