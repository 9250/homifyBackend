package homifyBackend.homifyBackendService.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import homifyBackend.homifyBackendService.model.Professional;

@Service("professionalService")
public class ProfessionalServiceImpl implements ProfessionalService {

	private static final AtomicLong counter = new AtomicLong();

	private static List<Professional> professionals;

	static {
		professionals = populateDummyProfessionals();
	}

	@Override
	public List<Professional> findAllProfessional() {
		return professionals;
	}

	@Override
	public Professional findById(long id) {
		for (Professional professional : professionals) {
			if (professional.getId() == id) {
				return professional;
			}
		}
		return null;
	}

	@Override
	public Professional findByName(String name) {
		for (Professional professional : professionals) {
			if (professional.getFirstName().equalsIgnoreCase(name)) {
				return professional;
			}
		}
		return null;
	}

	@Override
	public void saveProfessional(Professional professional) {
//		professional.setId(counter.incrementAndGet());
//		professionals.add(professional);
	}

	@Override
	public void updateProfessional(Professional professional) {
		int index = professionals.indexOf(professional);
		professionals.set(index, professional);
	}

	@Override
	public void deleteProfessionalById(long id) {
		for (Iterator<Professional> iterator = professionals.iterator(); iterator.hasNext();) {
			Professional professional = iterator.next();
			if (professional.getId() == id) {
				iterator.remove();
			}
		}
	}

	@Override
	public boolean isProfessionalExist(Professional professional) {
		return findByName(professional.getFirstName()) != null;
	}

	@Override
	public void deleteAllProfessional() {
		professionals.clear();
	}

	private static List<Professional> populateDummyProfessionals() {
		List<Professional> professionals = new ArrayList<Professional>();

		Professional p = Professional.builder()
				.website("dfda")
				.city("asdas")
				.country("sadsa")
				.lastUpdated(1l)
				.email("sdas")
				.build();

		professionals.add(p);
		return professionals;
	}

}
