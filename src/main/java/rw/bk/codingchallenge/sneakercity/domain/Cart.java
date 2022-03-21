package rw.bk.codingchallenge.sneakercity.domain;

import rw.bk.codingchallenge.sneakercity.enums.EPaymentStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "CARTS")
public class Cart {
    @Id
    @GeneratedValue
    private UUID cartId;
    @Temporal(TemporalType.DATE)
    private Date purchaseDate;
    private int quantity;
    @Enumerated(EnumType.STRING)
    private EPaymentStatus paymentStatus;
    private String orderNo;

    @ManyToOne
    private ProductSize productSize;

    public UUID getCartId() {
        return cartId;
    }

    public void setCartId(UUID cartId) {
        this.cartId = cartId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public EPaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(EPaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public ProductSize getProductSize() {
        return productSize;
    }

    public void setProductSize(ProductSize productSize) {
        this.productSize = productSize;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
