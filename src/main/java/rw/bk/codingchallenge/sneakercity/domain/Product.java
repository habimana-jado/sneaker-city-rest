package rw.bk.codingchallenge.sneakercity.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "PRODUCTS")
public class Product {
    @Id
    @GeneratedValue
    private UUID productId;
    private String brandName;
    private String model;
    private double price;
    @Temporal(TemporalType.DATE)
    private Date releaseDate;
    private String image;

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
