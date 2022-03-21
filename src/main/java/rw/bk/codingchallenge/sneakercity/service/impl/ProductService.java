package rw.bk.codingchallenge.sneakercity.service.impl;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import rw.bk.codingchallenge.sneakercity.domain.Product;
import rw.bk.codingchallenge.sneakercity.domain.ProductSize;
import rw.bk.codingchallenge.sneakercity.dto.ProductDto;
import rw.bk.codingchallenge.sneakercity.repository.ProductRepository;
import rw.bk.codingchallenge.sneakercity.repository.ProductSizeRepository;

import javax.transaction.Transactional;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ProductService implements rw.bk.codingchallenge.sneakercity.service.ProductService {

    private final ProductRepository productRepository;
    private final ProductSizeRepository productSizeRepository;

    public ProductService(ProductRepository productRepository, ProductSizeRepository productSizeRepository) {
        this.productRepository = productRepository;
        this.productSizeRepository = productSizeRepository;
    }

    @Override
    public ProductDto createOne(ProductDto productDto) throws InvocationTargetException, IllegalAccessException {

        Product product = new Product();
        BeanUtils.copyProperties(product, productDto);
        this.productRepository.save(product);

        for(ProductSize size: productDto.getProductSizes()){
            size.setProduct(product);
            this.productSizeRepository.save(size);
        }
        return productDto;
    }

    @Override
    public List<Product> allAvailableProducts() {
        Pageable pageable = PageRequest.of(0, 10, Sort.Direction.ASC, "releaseDate");
        return this.productRepository.findAvailableProductsSorted(pageable);
    }

    @Override
    public List<ProductSize> allAvailableSizeByProduct(UUID productId) {
        return this.productSizeRepository.findByProductId(productId);
    }
}
