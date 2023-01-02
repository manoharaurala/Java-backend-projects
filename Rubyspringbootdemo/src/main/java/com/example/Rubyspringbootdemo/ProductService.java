package com.example.Rubyspringbootdemo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    static List<Product> productList=new ArrayList<>();
    static int nextid=1;
    public  void addProduct(Product product){
        product.setId(nextid);
        nextid++;
        productList.add(product);
    }

    public List<Product> getProducts(){
        return productList;
    }

    public List<Product> getProductsByName(String name){
        List<Product> result=new ArrayList<>();
        for(Product product:productList){
            if(name.equals(product.getName())){
                result.add(product);
            }

        }
        return result;
    }

    public Product getProductsById(Integer id){
        List<Product> result=new ArrayList<>();
        for(Product product:productList){
            if(id.equals(product.getId())){
                return product;
            }

        }
        return null;
    }

}
