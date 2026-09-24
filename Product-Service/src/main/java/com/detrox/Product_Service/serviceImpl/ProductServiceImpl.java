package com.detrox.Product_Service.serviceImpl;

import com.detrox.Product_Service.dto.ProductRequest;
import com.detrox.Product_Service.dto.ProductResponse;
import com.detrox.Product_Service.model.Product;
import com.detrox.Product_Service.repository.ProductRepository;
import com.detrox.Product_Service.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

    productRepository.save(product);
    log.info("Product "+ product.getId()+" is Saved");
    }

    @Override
    public List<ProductResponse> getAllProducts() {

        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(this::mapToProductResponse)
                .toList();


    }

    private ProductResponse mapToProductResponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
