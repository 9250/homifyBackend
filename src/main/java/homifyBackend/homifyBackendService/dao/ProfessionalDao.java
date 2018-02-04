package homifyBackend.homifyBackendService.dao;

import homifyBackend.homifyBackendService.model.Professional;

public interface ProfessionalDao {
    Professional create(Object json);

    Professional update(long id);

    Professional delete(long id);
}
