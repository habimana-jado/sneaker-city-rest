package rw.bk.codingchallenge.sneakercity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import rw.bk.codingchallenge.sneakercity.domain.Cart;
import rw.bk.codingchallenge.sneakercity.enums.EPaymentStatus;

import java.util.List;
import java.util.UUID;

public interface CartRepository extends JpaRepository<Cart, UUID> {

    @Query("Select a from Cart a where a.paymentStatus = :status")
    List<Cart> findByStatus(@Param("status")EPaymentStatus status);
}
