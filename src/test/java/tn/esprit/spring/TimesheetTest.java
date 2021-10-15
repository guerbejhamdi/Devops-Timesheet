package tn.esprit.spring;


import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import love.cq.util.ObjectBean;
import tn.esprit.spring.controller.RestControlTimesheet;
import tn.esprit.spring.entities.Mission;


@ExtendWith(SpringExtension.class)
@WebMvcTest(RestControlTimesheet.class)
public class TimesheetTest {
	//TODO Code clean up
	@Autowired
	private MockMvc mvc;
	
	public static String asJsonString(final Object obj) {
	    try {
	        final ObjectMapper mapper = new ObjectMapper();
	        final String jsonContent = mapper.writeValueAsString(obj);
	        return jsonContent;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}  
	
		
		/*@Test
		public void test() throws Exception{
				System.out.print(asJsonString(new Mission("my mission", "desc")));
			  this.mvc.perform(post("/ajouterMission")
			            .contentType(MediaType.APPLICATION_JSON)
			            .content(asJsonString(new Mission("my mission", "desc"))))
			            .andDo(print())
			            .andExpect(status().isOk());
		}*/
	
	
	@Test
	public void createRecord_success() throws Exception {
	

	    Mission myMission = new Mission("my mission", "desc");

	    //Mockito.when(patientRecordRepository.save(record)).thenReturn(record);
	    
	    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
	    String json = ow.writeValueAsString(myMission);
		System.out.print(json);
	    MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/ajouterMission")
	            .contentType(MediaType.APPLICATION_JSON)
	            .accept(MediaType.APPLICATION_JSON)
	            .content(json);

	    mvc.perform(mockRequest)
	            .andExpect(status().is2xxSuccessful())	           ;
	    }


}
