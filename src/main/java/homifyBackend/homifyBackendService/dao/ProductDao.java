package homifyBackend.homifyBackendService.dao;

import homifyBackend.homifyBackendService.model.Product;

public interface ProductDao {
    Product create(Object json);
    Product update(long id);
    Product delete(long id);
}
