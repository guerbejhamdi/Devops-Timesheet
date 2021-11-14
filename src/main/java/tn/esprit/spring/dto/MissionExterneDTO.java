package tn.esprit.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MissionExterneDTO {

    private String emailFacturation;
	
	private float tauxJournalierMoyen;
	
	
	
	
	
}
