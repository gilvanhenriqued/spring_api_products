package com.products.apirest.resources;

import com.products.apirest.models.Product;
import com.products.apirest.repository.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/products")
@Api(value = "API REST Products")
@CrossOrigin(origins = "*")
public class ProductResource {
    @Autowired
    ProductRepository productRepository;

    @GetMapping
    @ApiOperation(value = "Return list of products")
    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Return a product")
    public Product listProductById(@PathVariable(value = "id")  long id){
        return productRepository.findById(id);
    }

    @PostMapping
    @ApiOperation(value = "Save a product")
    public Product saveProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @PutMapping
    @ApiOperation(value = "Delete a product")
    public Product updateProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @DeleteMapping
    @ApiOperation(value = "Update a product")
    public void deleteProduct(@RequestBody Product product){
        productRepository.delete(product);
    }

}
