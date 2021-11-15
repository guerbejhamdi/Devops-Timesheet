package tn.esprit.spring;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.Test;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.services.ITimesheetService;
import tn.esprit.spring.services.TimesheetServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimesheetUTest {
	@Autowired
	public TimesheetServiceImpl timesheetServiceImpl;
	
	@Autowired
	public ITimesheetService TimesService;
	
	private static final Logger l= LogManager.getLogger(TimesheetUTest.class);
	@Test
	public void should_AddTimesheet(){
        l.info("Create the Current Date");
        Date currentTime = new Date();
		timesheetServiceImpl.ajouterTimesheet(1, 1, currentTime, currentTime);
        l.info("Timesheet successfully added");
	}
	
	
}