package rw.bk.codingchallenge.sneakercity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rw.bk.codingchallenge.sneakercity.domain.Product;
import rw.bk.codingchallenge.sneakercity.domain.ProductSize;
import rw.bk.codingchallenge.sneakercity.dto.ProductDto;
import rw.bk.codingchallenge.sneakercity.service.ProductService;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/register-product")
    public ResponseEntity<?> registerProduct(@RequestBody ProductDto productDto) throws InvocationTargetException, IllegalAccessException {
        return new ResponseEntity<ProductDto>(this.productService.createOne(productDto), HttpStatus.CREATED);
    }

    @GetMapping("/find-available-products")
    public ResponseEntity<?> findAvailableProducts(){
        return new ResponseEntity<List<Product>>(this.productService.allAvailableProducts(), HttpStatus.OK);
    }

    @GetMapping("/find-available-size/{productId}")
    public ResponseEntity<?> findAvailableSizeByProduct(@PathVariable UUID productId){
        return new ResponseEntity<List<ProductSize>>(this.productService.allAvailableSizeByProduct(productId), HttpStatus.OK);
    }
}
