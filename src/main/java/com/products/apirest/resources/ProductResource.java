package com.products.apirest.resources;

import com.products.apirest.models.Product;
import com.products.apirest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ProductResource {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public Product listarProdutById(@PathVariable(value = "id")  long id){
        return productRepository.findById(id);
    }

}
