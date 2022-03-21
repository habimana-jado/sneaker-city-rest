package rw.bk.codingchallenge.sneakercity.dto;

import rw.bk.codingchallenge.sneakercity.domain.ProductSize;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

public class ProductDto {

    private String brandName;
    private String model;
    private double price;
    @Temporal(TemporalType.DATE)
    private Date releaseDate;
    private String image;

    private List<ProductSize> productSizes;

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

    public List<ProductSize> getProductSizes() {
        return productSizes;
    }

    public void setProductSizes(List<ProductSize> productSizes) {
        this.productSizes = productSizes;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
