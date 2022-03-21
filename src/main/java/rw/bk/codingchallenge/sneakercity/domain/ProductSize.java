package rw.bk.codingchallenge.sneakercity.domain;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "PRODUCTS_SIZE")
public class ProductSize {
    @Id
    @GeneratedValue
    private UUID productSizeId;
    private String description;
    private int quantity;
    private double size;

    @ManyToOne
    private Product product;

    public UUID getProductSizeId() {
        return productSizeId;
    }

    public void setProductSizeId(UUID productSizeId) {
        this.productSizeId = productSizeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
