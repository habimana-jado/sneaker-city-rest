package rw.bk.codingchallenge.sneakercity.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rw.bk.codingchallenge.sneakercity.domain.Product;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Query("Select a from Product a, ProductSize p where a.productId =  p.product.id and p.quantity > 0 Group By a")
    List<Product> findAvailableProductsSorted(Pageable pageable);
}
