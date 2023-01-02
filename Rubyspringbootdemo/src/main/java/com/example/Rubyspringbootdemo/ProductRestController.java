package com.example.Rubyspringbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductRestController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public List<Product> getProduct(){
        return productService.getProducts();
    }

    @PostMapping
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

    @GetMapping("/byname")
    public List<Product> getProductByName(@RequestParam(value = "keyword",required = true) String keyword)
    {
        return productService.getProductsByName(keyword);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable(value = "id") Integer id){
        return productService.getProductsById(id);
    }

    @GetMapping("/menu")
    public String getMenu(){
        return "menu.html";
    }
}
