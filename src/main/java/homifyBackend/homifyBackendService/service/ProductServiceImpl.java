package homifyBackend.homifyBackendService.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import homifyBackend.homifyBackendService.model.Product;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    private static final AtomicLong counter = new AtomicLong();

    private static List<Product> products;

    static {
        products = populateDummyProducts();
    }

    @Override
    public List<Product> findAllProducts() {
        return products;
    }

    @Override
    public Product findById(long id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Product findByName(String productTitle) {
        for (Product product : products) {
            if (product.getTitle().equalsIgnoreCase(productTitle)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void saveProduct(Product product) {
//        product.setId(counter.incrementAndGet());
//        products.add(product);
    }

    @Override
    public void updateProduct(Product product) {
        int index = products.indexOf(product);
        products.set(index, product);
    }

    @Override
    public void deleteProductById(long id) {

        for (Iterator<Product> iterator = products.iterator(); iterator.hasNext(); ) {
            Product product = iterator.next();
            if (product.getId() == id) {
                iterator.remove();
            }
        }
    }

    @Override
    public boolean isProductExist(Product product) {
        return false;
    }

    @Override
    public void deleteAllProducts() {
        products.clear();
    }

    private static List<Product> populateDummyProducts() {
        List<Product> products = new ArrayList<Product>();

        Product p = Product.builder()
            .header("dfda")
            .title("asdas")
            .description("sadsa")
            .build();
        products.add(p);
        return products;
    }

}
