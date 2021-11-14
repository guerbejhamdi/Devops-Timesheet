package tn.esprit.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import tn.esprit.spring.dto.EntrepriseDTO;


import tn.esprit.spring.entities.Mission;


public class TimesheetTestApp extends AbstractTest{

	
private static final Logger l = LogManager.getLogger(TimesheetTestApp.class);
	
	@Override
	   @Before
	   public void setUp() {
	      super.setUp();
   }
	
	 @Test
	   public void ajouterMission() throws Exception {
	      String uri = "/ajouterMission";
	      Mission mission = new Mission();
	      mission.setId(2);
	      mission.setName("Ginger");
	      mission.setDescription("mission description");
	      String inputJson = super.mapToJson(mission);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      if(status == 200) {
	    	  l.info("la mission a été ajouté avec succés");
	      }else if(status == 201) {
	    	  l.info("la mission a été ajouté avec succés");
	      }else if(status >= 400 && status <500) {
	    	  l.fatal("erreur coté client :  code reponse :  "+status);
	      }else if(status >= 500){
	    	  l.error("erreur coté serveur :  code reponse :  "+status);
	      }
	     
	   }
	   
	  
	  
	 /*
	   @Test
	   public void ajouterTimesheet() throws Exception {
	      String uri = "/ajouterTimesheet/1/1/12-12-2021/12-12-2022";
	      Mission mission = new Mission();
	      mission.setId(2);
	      mission.setName("Ginger");
	      mission.setDescription("mission description");
	      Employe employe = new Employe();
	      employe.setId(2);;
	      employe.setNom("Bob");
	      employe.setPrenom("DART");
	      employe.setEmail("employe@esprit.tn");
	      employe.setPassword("bobbypassword");
	      employe.setRole(Role.INGENIEUR);
	      TimesheetPK tspk = new TimesheetPK();
	      Timesheet timesheet = new Timesheet();
	      timesheet.setValide(true);
	      timesheet.setMission(mission);
	      timesheet.setTimesheetPK(tspk);
	      timesheet.setEmploye(employe);
	 
	      String inputJson = super.mapToJson(timesheet);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      if(status == 200) {
	    	  l.info("le timesheet a été ajouté avec succés");
		      }else if(status >= 400 && status <500) {
		    	  l.fatal("erreur coté client :  code reponse :  "+status);
		      }else if(status >= 500){
		    	  l.error("erreur coté serveur :  code reponse :  "+status);
		      }
	   }
	   */
	   
	 
	   @Test
	   public void getAllEmployeByMission() throws Exception {
	      String uri = "/getAllEmployeByMission/2";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      EntrepriseDTO entreprise = super.mapFromJson(content, EntrepriseDTO.class);
	      assertTrue(entreprise != null);
	          if(status == 200) {
		    	  l.info("les employés de la mission ont  été recupérées avec succés");
		      }else if(status >= 400 && status <500) {
		    	  l.fatal("erreur coté client :  code reponse :  "+status);
		      }else if(status >= 500){
		    	  l.error("erreur coté serveur :  code reponse :  "+status);
		      }
	   }
	   
	   
	   @Test
	   public void findAllMissionByEmployeJPQL() throws Exception {
	      String uri = "/findAllMissionByEmployeJPQL/1";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	     
	      if(status == 200) {
	    	  l.info("les missions de l'employé ont été recupérées avec succés");
	      }else if(status >= 400 && status <500) {
	    	  l.fatal("erreur coté client :  code reponse :  "+status);
	      }else if(status >= 500){
	    	  l.error("erreur coté serveur :  code reponse :  "+status);
	      }
	   }
	
	
	   @Test
	   public void affecterMissionADepartement() throws Exception {
	      String uri = "/affecterMissionADepartement/1/1";
	   
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	        ).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      if(status == 200) {
	    	  l.info("la mission a été affecté avec succés");
	      }else if(status >= 400 && status <500) {
	    	  l.fatal("erreur coté client :  code reponse :  "+status);
	      }else if(status >= 500){
	    	  l.error("erreur coté serveur :  code reponse :  "+status);
	      }
	   }
	   
	   
	  /* @Test
	   public void validerTimesheet() throws Exception {
	      String uri = "/validerTimesheet/1/1/12/10/2021/12/10/2021/5";
	   
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	        ).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      if(status == 200) {
	    	  l.info("timesheet a été validé  avec succés");
	      }else if(status >= 400 && status <500) {
	    	  l.fatal("erreur coté client :  code reponse :  "+status);
	      }else if(status >= 500){
	    	  l.error("erreur coté serveur :  code reponse :  "+status);
	      }
	   }
	  
 */
	 
	   
	  
	
	
}
