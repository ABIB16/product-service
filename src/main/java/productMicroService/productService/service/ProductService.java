package productMicroService.productService.service;


import productMicroService.productService.exceptions.EntityNotFoundExecption;
import productMicroService.productService.model.Product;
import productMicroService.productService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if(!product.isPresent()){
            throw new EntityNotFoundExecption("Product not found");
        }
        return product;
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product entity) {
        Product product = findById(entity.getId()).orElse(null);
        product.setQuantityInStock(entity.getQuantityInStock());
        product.setPrice(entity.getPrice());
        product.setName(entity.getName());
        return productRepository.save(product);
    }


    public List<Product> insertAll(List<Product> entity) {
        return productRepository.saveAll(entity);
    }

    public Optional<Product> findByName(String name){
        return  productRepository.findByName(name);
    }
}
