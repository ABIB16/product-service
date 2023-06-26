package productMicroService.productService.controller;

import productMicroService.productService.model.Product;
import productMicroService.productService.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping("/{productId}")
    public Product updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
        return product;
    }


    @GetMapping("/name/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name) {
        Product product = productService.findByName(name).get();
        return ResponseEntity.ok(product);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<?> findById(@PathVariable Long productId) {
      Optional<Product> product = productService.findById(productId);
        return ResponseEntity.ok(product);
    }
}
