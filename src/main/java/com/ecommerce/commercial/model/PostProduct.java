package com.ecommerce.commercial.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class PostProduct {
  
  @Id
  @SequenceGenerator(name = "product_seq", sequenceName = "product_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
  @Column(name = "product_id", updatable = false)
  private Long id;

  private String name;
  
  private Long price;

  private String description;

  private String image;

  // public Product(String name, Long price, byte[] image) {
  //   this.name = name;
  //   this.price = price;
  //   this.image = image;
  // }

  // public Product(Long id, String name, Long price, byte[] image) {
  //   this.id = id;
  //   this.name = name;
  //   this.price = price;
  //   this.image = image;
  // }
@Column(name="category_id")
  private Long categoryId;

  public PostProduct(String name, Long price, String description, Long categoryId, String image) {
    this.name = name;
    this.price = price;
    this.description = description;
    this.categoryId = categoryId;
    this.image = image;
    
  }

  public PostProduct(Long id, String name, Long price, String description, Long categoryId, String image) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.description = description;
    this.categoryId = categoryId;
    this.image = image;
   
  }
  public PostProduct() {
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
     
    return "./resources/static/photo/" + id + "/" + image;
}
}
