package tn.esprit.spring.mapper;


import tn.esprit.spring.dto.TimesheetPKDTO;
import tn.esprit.spring.entities.TimesheetPK;

public class TimesheetPKMapper {

private TimesheetPKMapper() {
		
	}
	
public static TimesheetPK toEntity(TimesheetPKDTO timesheetDto) {
		
		TimesheetPK timesheet = new TimesheetPK();
		
		timesheet.setIdEmploye(timesheetDto.getIdEmploye());
		timesheet.setIdMission(timesheetDto.getIdMission());
		timesheet.setDateDebut(timesheet.getDateDebut());
		timesheet.setDateFin(timesheetDto.getDateFin());
		
				return timesheet;
	
	}
	
	
	public static TimesheetPKDTO toDto(TimesheetPK timesheet) {
	
		 TimesheetPKDTO timesheetDTO = new TimesheetPKDTO();
			
		    timesheetDTO.setIdEmploye(timesheet.getIdEmploye());
			timesheetDTO.setIdMission(timesheet.getIdMission());
			timesheetDTO.setDateDebut(timesheet.getDateDebut());
			timesheetDTO.setDateFin(timesheet.getDateFin());

		       return timesheetDTO;
		
	}
	
	
	
	
	
    
    
	
}
