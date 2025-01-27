package com.empresa.EcoMerch.Service.Inter;

import com.empresa.EcoMerch.Entities.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();
    Product findById(Long id);
    Product save(Product product);
    void deleteById(Long id);
}
