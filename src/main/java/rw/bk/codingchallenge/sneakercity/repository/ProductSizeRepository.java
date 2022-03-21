package rw.bk.codingchallenge.sneakercity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import rw.bk.codingchallenge.sneakercity.domain.ProductSize;

import java.util.List;
import java.util.UUID;

public interface ProductSizeRepository extends JpaRepository<ProductSize, UUID> {

    @Query("Select p from ProductSize p where p.product.productId = :productId and p.quantity > 0 ")
    List<ProductSize> findByProductId(@Param("productId") UUID productId);
}
