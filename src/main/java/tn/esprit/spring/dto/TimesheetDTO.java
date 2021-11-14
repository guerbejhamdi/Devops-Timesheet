package tn.esprit.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TimesheetDTO {

    private TimesheetPKDTO timesheetPK;
	
	private MissionDTO mission;
	
	//idEmploye est a la fois primary key et foreign key
	
	private EmployeDTO employe;
		
	private boolean isValide;

	public TimesheetDTO(TimesheetPKDTO timesheetPK) {
		super();
		this.timesheetPK = timesheetPK;
	}

	public TimesheetDTO(TimesheetPKDTO timesheetPK, MissionDTO mission, EmployeDTO employe) {
		super();
		this.timesheetPK = timesheetPK;
		this.mission = mission;
		this.employe = employe;
	}
	
	
	
	
	
	
}
