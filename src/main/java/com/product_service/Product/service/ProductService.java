package com.product_service.Product.service;

import com.product_service.Product.entity.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;



public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product addProduct(Product product);
    Product updateProduct(Long id,Product product);
    void deleteProduct(Long id);
}
