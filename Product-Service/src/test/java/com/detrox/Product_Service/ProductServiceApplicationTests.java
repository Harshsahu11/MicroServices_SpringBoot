package com.detrox.Product_Service;

import com.detrox.Product_Service.dto.ProductRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.mongodb.MongoDBContainer;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductServiceApplicationTests {

    @Container
    static MongoDBContainer mongoDBContainer =
            new MongoDBContainer("mongo:4.4.2");

    @Autowired
    private MockMvc mockMvc;

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add(
                "spring.data.mongodb.uri",
                mongoDBContainer::getReplicaSetUrl
        );
    }

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateProduct() throws Exception {

        ProductRequest productRequest = getProductRequest();

        String productRequestString =objectMapper.writeValueAsString(productRequest);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(productRequestString))
                .andExpect(status().isCreated());
    }

    private ProductRequest getProductRequest(){
        return ProductRequest.builder()
                .name("Iphone 13")
                .description("Iphone 13")
                .price(BigDecimal.valueOf(1200))
                .build();
    }
}