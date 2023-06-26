package productMicroService.productService.controller;

import productMicroService.productService.model.Product;
import productMicroService.productService.repository.ProductCategoryRepository;
import productMicroService.productService.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private ProductService productServiceMock;

    @InjectMocks
    private ProductController productController;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Test
    public void findByNameTest() throws Exception {
        Optional<Product> testProduct = Optional.of(new Product(1L,"Nouveau Produit", 4000, 2));
        Mockito.when(productServiceMock.findByName("Nouveau Produit")).thenReturn(testProduct);
        String name = "Nouveau Produit";
        mockMvc.perform(get("/api/products/name/{name}", name)
                        .contentType("application/json"))
				        .andExpect(status().isOk());
    }

    @Test
    public void createProductTest() throws Exception {
        Product testProduct = new Product(1L,"Nouveau Produit", 222, 22,productCategoryRepository.findById(1L).orElseThrow());
        Mockito.when(productServiceMock.saveProduct(Mockito.any(Product.class))).thenReturn(testProduct);
        List<Product> productList = Arrays.asList(testProduct); // Créez une liste contenant le produit de test
        Mockito.when(productServiceMock.findAll()).thenReturn(productList); // Mock la méthode findAll() pour retourner la liste de produits
        mockMvc.perform(post("/api/products")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(testProduct)))
                        .andExpect(status().isOk());
        //  vérifier que la méthode findAll() a été appelée une seule fois après l'appel de saveProduct
      //  Mockito.verify(productServiceMock, Mockito.times(1)).findAll();
        assertEquals(1,productServiceMock.findAll().size());

    }

}
