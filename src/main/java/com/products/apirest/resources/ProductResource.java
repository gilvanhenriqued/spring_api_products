package com.products.apirest.resources;

import com.products.apirest.models.Product;
import com.products.apirest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/products")
public class ProductResource {
    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product listProductById(@PathVariable(value = "id")  long id){
        return productRepository.findById(id);
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

}
