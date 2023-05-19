package com.ecommerce.commercial.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class ProductBeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    private String name;

    private Long price;

    private String image;

    private String description;

    @Column(name = "category_id")
    private Long categoryId;

    @ManyToOne
    @JoinColumn(name = "discount_id")
    private DiscountBeta discountBeta;

    @Column(name="discount_price")
    private Long discountedPrice;
    // constructeurs, getters, setters, etc.

    public ProductBeta(Long productId, String name, Long price, String description, Long categoryId, String image, DiscountBeta discountBeta, Long discountedPrice) {
      this.productId = productId;
      this.name = name;
      this.price = price;
      this.description = description;
      this.categoryId = categoryId;
      this.image = image;
      this.discountBeta = discountBeta;
      this.discountedPrice = discountedPrice;
    }

    public ProductBeta(String name, Long price, String description, Long categoryId, String image, DiscountBeta discountBeta, Long discountedPrice) {
      this.name = name;
      this.price = price;
      this.description = description;
      this.categoryId = categoryId;
      this.image = image;
      this.discountBeta = discountBeta;
      this.discountedPrice = discountedPrice;
    }

    public ProductBeta() {
      //
    }

    public Long getProductId() {
      return productId;
    }
  
    public void setproductId(Long productId){
      this.productId = productId;
    }
  
    public String getName() {
      return name;
    }
  
    public void setName(String name) {
      this.name = name;
    }
  
    public Long getPrice() {
      return price;
    }
  
    public void setPrice(Long price) {
      this.price = price;
    }
  
    public String getDescription() {
      return description;
    }
  
  public void setDescription(String description) {
    this.description = description;
  }
  
    public Long getCategoryId() {
      return categoryId;
    }
  
    public void setCategoryId(Long categoryId) {
      this.categoryId = categoryId;
    }
  
    public String getImage() {
      return image;
    }
  
    public void setImage(String image) {
      this.image = image;
    }
  
    public String getPhotosImagePath() {
      if (image == null || productId == null) return null;
       
      return "/photo/" + productId + "/" + image;
    }
  
    public DiscountBeta getDiscount() {
      return discountBeta;
    }
  
    public void setDiscountBeta(DiscountBeta discountBeta) {
      this.discountBeta = discountBeta;
    }
  
    public Long getDiscountedPrice() {
      return discountedPrice;
    }
  
    public void setDiscountedPrice(Long discountedPrice) {
      this.discountedPrice = discountedPrice;
    }
}
