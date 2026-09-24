package com.detrox.Product_Service.service;


import com.detrox.Product_Service.dto.ProductRequest;
import com.detrox.Product_Service.dto.ProductResponse;

import java.util.List;

public interface ProductService {

    public void createProduct(ProductRequest productRequest);

    public List<ProductResponse> getAllProducts();
}
