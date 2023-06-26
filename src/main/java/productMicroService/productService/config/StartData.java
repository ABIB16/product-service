package productMicroService.productService.config;

import productMicroService.productService.model.Product;
import productMicroService.productService.model.ProductCategory;
import productMicroService.productService.service.ProductCategoryService;
import productMicroService.productService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class StartData implements CommandLineRunner {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @Override
    public void run(String... args) throws Exception {

        if (productCategoryService.findAll().isEmpty()) {
            // create product category
            ProductCategory cat1 = new ProductCategory();
            cat1.setName("Produits cosmetiques");

            ProductCategory cat2 = new ProductCategory();
            cat2.setName("produit vestimentaire");

            ProductCategory cat3 = new ProductCategory();
            cat3.setName("electromenager");

            ProductCategory cat4 = new ProductCategory();
            cat4.setName("meubles");

            ProductCategory cat5 = new ProductCategory();
            cat5.setName("Fruits et légumes");

            productCategoryService.insertAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5));
        }

        if (productService.findAll().isEmpty()) {
            // create product
            Product product1 = new Product();
            product1.setName("Produit 1");
            product1.setPrice(1000);
            product1.setQuantityInStock(10);
            product1.setCategory(productCategoryService.findById(1L));

            Product product2 = new Product();
            product2.setName("Produit 2");
            product2.setPrice(2000);
            product2.setQuantityInStock(20);
            product2.setCategory(productCategoryService.findById(2L));

            Product product3 = new Product();
            product3.setName("Produit 3");
            product3.setPrice(3000);
            product3.setQuantityInStock(30);
            product3.setCategory(productCategoryService.findById(3L));
            productService.insertAll(Arrays.asList(product1,product2,product3));
        }
    }

}
