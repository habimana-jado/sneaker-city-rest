package rw.bk.codingchallenge.sneakercity.service;

import rw.bk.codingchallenge.sneakercity.domain.Product;
import rw.bk.codingchallenge.sneakercity.domain.ProductSize;
import rw.bk.codingchallenge.sneakercity.dto.ProductDto;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

public interface ProductService {

    ProductDto createOne(ProductDto productDto) throws InvocationTargetException, IllegalAccessException;
    List<Product> allAvailableProducts();
    List<ProductSize> allAvailableSizeByProduct(UUID productId);
}
