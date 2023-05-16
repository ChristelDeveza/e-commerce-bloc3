package com.ecommerce.commercial.model;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class UpdateProduct {

  @Id
  @Column(name = "product_id", updatable = false)
  private Long id;

  private String name;
  
  private Long price;

  private String description;

  private String image;

  @Column(name="category_id")
  private Long categoryId;

  @OneToMany(mappedBy = "updateProduct")
  private List<PutDiscount> putDiscount;

  @Column(name="discount_price")
  private Long discountedPrice;

  public UpdateProduct(String name, Long price, String description, Long categoryId, String image, List<PutDiscount> putDiscount, Long discountedPrice) {
    this.name = name;
    this.price = price;
    this.description = description;
    this.categoryId = categoryId;
    this.image = image;
    this.putDiscount = putDiscount;
    this.discountedPrice = discountedPrice;
  }

  public UpdateProduct(Long id, String name, Long price, String description, Long categoryId, String image, List<PutDiscount> putDiscount, Long discountedPrice) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.description = description;
    this.categoryId = categoryId;
    this.image = image;
    this.putDiscount = putDiscount;
    this.discountedPrice = discountedPrice;
  }

  public UpdateProduct() {
    //Needed Hibernate
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id){
    this.id = id;
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
    if (image == null || id == null) return null;
     
    return "/photo/" + id + "/" + image;
  }

  public List<PutDiscount> getPutDiscount() {
    return putDiscount;
  }
  
  public void setPutDiscount(List<PutDiscount> putDiscount) {
    this.putDiscount = putDiscount;
  }
  
  public Long getDiscountedPrice() {
    return discountedPrice;
  }

  public void setDiscountedPrice(Long discountedPrice) {
    this.discountedPrice = discountedPrice;
  }
}
