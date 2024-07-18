package com.product_service.Product.controller;


import com.product_service.Product.entity.Product;
import com.product_service.Product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")

public class ProductController extends BaseController<Product> {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        try {
            List<Product> products = productService.getAllProducts();
            return createOkResponse(products);
        } catch (Exception e) {
            return createInternalServerErrorResponse((List<Product>) null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        try{
            Product product = productService.getProductById(id);
            if(product!=null){
                return createOkResponse(product);
            }else{
                return createNotFoundResponse(null);
            }
        }catch (Exception e){
            return createInternalServerErrorResponse((Product) null);
        }
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        try {
            Product createProduct = productService.addProduct(product);
            return createCreatedResponse(createProduct);
        }catch (Exception e){
            return createBadRequestResponse(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product){
        try{
            Product updatedProduct= productService.updateProduct(id, product);
            if(updatedProduct !=null){
                return createOkResponse(updatedProduct);
            }else {
                return createNotFoundResponse(null);
            }
        }catch (Exception e){
            return createInternalServerErrorResponse((Product)null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        try{
            productService.deleteProduct(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return createInternalServerErrorResponse();
        }
    }
}
