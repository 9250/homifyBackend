package homifyBackend.homifyBackendService.service;


import java.util.List;

import homifyBackend.homifyBackendService.model.Professional;

public interface ProfessionalService {
	
	Professional findById(long id);
	
	Professional findByName(String name);
	
	void saveProfessional(Professional professional);
	
	void updateProfessional(Professional professional);
	
	void deleteProfessionalById(long id);

	List<Professional> findAllProfessional();
	
	void deleteAllProfessional();
	
	boolean isProfessionalExist(Professional professional);
	
}
