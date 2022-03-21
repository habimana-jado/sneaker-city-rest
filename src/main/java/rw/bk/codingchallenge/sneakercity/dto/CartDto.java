package rw.bk.codingchallenge.sneakercity.dto;

import rw.bk.codingchallenge.sneakercity.domain.ProductSize;
import rw.bk.codingchallenge.sneakercity.enums.EPaymentStatus;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.UUID;

public class CartDto {

    @Temporal(TemporalType.DATE)
    private Date purchaseDate;
    private double quantity;
    @Enumerated(EnumType.STRING)
    private EPaymentStatus paymentStatus;
    private String orderNo;
    private UUID productSizeId;

    private ProductSize productSize;

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public EPaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(EPaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public ProductSize getProductSize() {
        return productSize;
    }

    public void setProductSize(ProductSize productSize) {
        this.productSize = productSize;
    }

    public UUID getProductSizeId() {
        return productSizeId;
    }

    public void setProductSizeId(UUID productSizeId) {
        this.productSizeId = productSizeId;
    }
}
