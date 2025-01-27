package com.empresa.EcoMerch.Controller;

import com.empresa.EcoMerch.Controller.DTO.ProductDTO;
import com.empresa.EcoMerch.Entities.Product;
import com.empresa.EcoMerch.Service.Impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        Optional<Product> productOptional = Optional.ofNullable(productServiceImpl.findById(id));

        if (productOptional.isPresent()){
            Product product = productOptional.get();

            ProductDTO productDTO = ProductDTO.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .description(product.getDescription())
                    .price(product.getPrice())
                    .stock(product.getStock())
                    .build();
            return ResponseEntity.ok(productDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {

        ProductDTO productDTO = ProductDTO.builder()
                .id(productServiceImpl.findAll().get(0).getId())
                .name(productServiceImpl.findAll().get(0).getName())
                .description(productServiceImpl.findAll().get(0).getDescription())
                .price(productServiceImpl.findAll().get(0).getPrice())
                .stock(productServiceImpl.findAll().get(0).getStock())
                .build();
        return ResponseEntity.ok(productDTO);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ProductDTO productDTO) {

        Product product = Product.builder()
                .id(productDTO.getId())
                .name(productDTO.getName())
                .description(productDTO.getDescription())
                .price(productDTO.getPrice())
                .stock(productDTO.getStock())
                .build();

        return ResponseEntity.ok(productServiceImpl.save(product));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {

        productServiceImpl.deleteById(id);
        return ResponseEntity.ok().build();
    }
}