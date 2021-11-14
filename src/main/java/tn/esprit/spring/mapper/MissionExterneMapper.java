package tn.esprit.spring.mapper;



import tn.esprit.spring.dto.MissionExterneDTO;
import tn.esprit.spring.entities.MissionExterne;



public class MissionExterneMapper {

private MissionExterneMapper() {
		
	}

	public static MissionExterne toEntity(MissionExterneDTO missionDto) {
		
		
		MissionExterne mission = new MissionExterne();
		
		 mission.setEmailFacturation(missionDto.getEmailFacturation());
		 mission.setTauxJournalierMoyen(missionDto.getTauxJournalierMoyen());
		
				return mission;
	
	}
	
	
	public static MissionExterneDTO toDto(MissionExterne mission) {
	
		 MissionExterneDTO missionDTO = new MissionExterneDTO();
			
		 missionDTO.setEmailFacturation(mission.getEmailFacturation());
		 missionDTO.setTauxJournalierMoyen(mission.getTauxJournalierMoyen());
	
		       return missionDTO;
		
	}
	
	
	

	
    
    
}
