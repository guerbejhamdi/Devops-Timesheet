package tn.esprit.spring.mapper;



import tn.esprit.spring.dto.EmployeDTO;
import tn.esprit.spring.dto.MissionDTO;
import tn.esprit.spring.dto.TimesheetDTO;
import tn.esprit.spring.dto.TimesheetPKDTO;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.entities.TimesheetPK;


public class TimesheetMapper {


private TimesheetMapper() {
		
	}

	public static Timesheet toEntity(TimesheetDTO timesheetDto) {
		
		Employe employe = EmployeMapper.toEntity(timesheetDto.getEmploye());
		 Mission mission = MissionMapper.toEntity(timesheetDto.getMission());
		 TimesheetPK  timesheetPkDto = TimesheetPKMapper.toEntity(timesheetDto.getTimesheetPK());
		
		Timesheet timesheet = new Timesheet();
		
		
		timesheet.setEmploye(employe);
		 timesheet.setMission(mission);
		 timesheet.setTimesheetPK(timesheetPkDto);
		 timesheet.setValide(timesheetDto.isValide());
		
				return timesheet;
	
	}
	
	
	public static TimesheetDTO toDto(Timesheet timesheet) {
		 EmployeDTO employe = EmployeMapper.toDto(timesheet.getEmploye());
		 MissionDTO  mission = MissionMapper.toDto(timesheet.getMission());
		 TimesheetPKDTO  timesheetPkDto = TimesheetPKMapper.toDto(timesheet.getTimesheetPK());
		
		 TimesheetDTO timesheetDTO = new TimesheetDTO();
			
		 timesheetDTO.setEmploye(employe);
		 timesheetDTO.setMission(mission);
		 timesheetDTO.setTimesheetPK(timesheetPkDto);
		 timesheetDTO.setValide(timesheet.isValide());

		       return timesheetDTO;
		
	}
	
	
	
	
	


	
	
	
}
