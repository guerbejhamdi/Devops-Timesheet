package tn.esprit.spring.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.entities.TimesheetPK;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.repository.TimesheetRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class TimesheetServiceImpl implements ITimesheetService {
	
    private static final Logger LOGGER = LogManager.getLogger(TimesheetServiceImpl.class);

	
	@Autowired
	MissionRepository missionRepository;
	@Autowired
	DepartementRepository deptRepoistory;
	@Autowired
	TimesheetRepository timesheetRepository;
	@Autowired
	EmployeRepository employeRepository;
	
	public int ajouterMission(Mission mission) {
		missionRepository.save(mission);
		return mission.getId();
	}
    
	public void affecterMissionADepartement(int missionId, int depId) {
		Mission mission;
		Optional<Mission> optMission = missionRepository.findById(missionId);
		if(optMission.isPresent()) {
			mission = optMission.get();
			Optional<Departement> optDep = deptRepoistory.findById(depId);
			if(optDep.isPresent()) {
				mission.setDepartement(optDep.get());

			}
			missionRepository.save(mission);
		}
		
		
	}

	public void ajouterTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin) {
		TimesheetPK timesheetPK = new TimesheetPK();
		timesheetPK.setDateDebut(dateDebut);
		timesheetPK.setDateFin(dateFin);
		timesheetPK.setIdEmploye(employeId);
		timesheetPK.setIdMission(missionId);
		
		Timesheet timesheet = new Timesheet();
		timesheet.setTimesheetPK(timesheetPK);
		timesheet.setValide(false); //par defaut non valide
		timesheetRepository.save(timesheet);
		
	}

	
	public void validerTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin, int validateurId) {
		LOGGER.info("In valider Timesheet");
		Employe validateur;
		Mission mission;
		boolean chefDeLaMission = false;

		Optional<Employe> optValidateur = employeRepository.findById(validateurId);
		if(optValidateur.isPresent()) {
			validateur = optValidateur.get();
			Optional<Mission> optMission = missionRepository.findById(missionId);

			if(optMission.isPresent()) {
				mission = optMission.get();				//verifier s'il est un chef de departement (interet des enum)
				if(!validateur.getRole().equals(Role.CHEF_DEPARTEMENT)){
					LOGGER.info("l'employe doit etre chef de departement pour valider une feuille de temps !");

					return;
				}
				//verifier s'il est le chef de departement de la mission en question
				for(Departement dep : validateur.getDepartements()){
					if(dep.getId() == mission.getDepartement().getId()){
						chefDeLaMission = true;
						break;
					}
				}

				
		//
			}
		
			if(!chefDeLaMission){
				LOGGER.info("l'employe doit etre chef de departement de la mission en question");

				return;
			}
			
		}
		
		
		
	
	
		TimesheetPK timesheetPK = new TimesheetPK(missionId, employeId, dateDebut, dateFin);
		Timesheet timesheet =timesheetRepository.findBytimesheetPK(timesheetPK);
		timesheet.setValide(true);
		
		//Comment Lire une date de la base de données
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		LOGGER.info("dateDebut : " + dateFormat.format(timesheet.getTimesheetPK().getDateDebut()));

	}

	
	public List<Mission> findAllMissionByEmployeJPQL(int employeId) {
		return timesheetRepository.findAllMissionByEmployeJPQL(employeId);
	}

	
	public List<Employe> getAllEmployeByMission(int missionId) {
		return timesheetRepository.getAllEmployeByMission(missionId);
	}

}
