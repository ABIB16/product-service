package productMicroService.productService.service;


import productMicroService.productService.model.Product;
import productMicroService.productService.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sound.midi.Soundbank;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class ProductServiceTest {

    @InjectMocks
    ProductService productService;

    @Mock
    ProductRepository productRepository;

    @Test
    void findByNameNotFound(){
        Optional<Product> product= productService.findByName("Produit inconnu");
        assertEquals (false,product.isPresent());
    }

    @Test
    void findByNameFound(){
        Optional<Product> product= productService.findByName("Produit 3");
        System.out.println("eeeeeeeeeeeeee "+product.get().getName());
        assertEquals ("Produit 3",product.get().getName());
    }



    @Test
    public void findByNameTest() {
        Optional<Product> autherParam = Optional.of(new Product(1L,"Nouveau Produit", 4000, 2));
        Mockito.when(productRepository.findByName(Mockito.anyString())).thenReturn(autherParam);
        Optional<Product> auther = productService.findByName("test");
        assertEquals(true, auther.isPresent());
        assertEquals("Nouveau Produit", auther.get().getName());
    }
}
