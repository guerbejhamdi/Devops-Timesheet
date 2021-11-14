package tn.esprit.spring.dto;

import java.util.Date;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TimesheetPKDTO {

	
    private int idMission;
	
	private int idEmploye;
	
	private Date dateDebut;
	
	private Date dateFin;
	
	
	
	
	
	
}
