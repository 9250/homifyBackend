package homifyBackend.homifyBackendService.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import homifyBackend.homifyBackendService.App;
import homifyBackend.homifyBackendService.model.Product;
import homifyBackend.homifyBackendService.service.ProductService;
import homifyBackend.homifyBackendService.util.CustomErrorType;

@RestController
public class ProductController {
    public static final Logger logger = LoggerFactory.getLogger(App.class);

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public Collection<Product> listAllProducts() {
        List<Product> allProducts = productService.findAllProducts();
        if (allProducts.isEmpty()) {
            return Collections.EMPTY_LIST;
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ArrayList<Product>(allProducts);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable("id") long id) {
        logger.info("Fetching User with id {}", id);
        Product product = productService.findById(id);
        if (product == null) {
            logger.error("User with id {} not found.", id);
            return null;
        }
        return product;
    }
}
