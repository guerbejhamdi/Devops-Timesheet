package tn.esprit.spring;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.services.ITimesheetService;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.MOCK, classes={ TimesheetApplication.class })
public class TimesheetTest {
	//TODO Code clean up
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	@MockBean 
	private ITimesheetService timesheetServiceMock;
	
	@Before
	public void setUp() {
		 this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void should_CreateMission_When_ValidRequest() throws Exception {
		
		when(timesheetServiceMock.ajouterMission(any(Mission.class))).thenReturn(10);
	    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
	    Mission myMission = new Mission("my mission", "desc");
	   
	    String json = ow.writeValueAsString(myMission);
		System.out.print(json);
		mockMvc.perform(post("/ajouterMission")
			   .contentType(MediaType.APPLICATION_JSON)
			   .content(json)						
			   .accept(MediaType.APPLICATION_JSON))
			   .andExpect(status().isOk());	
  	
	}
	
	

}
