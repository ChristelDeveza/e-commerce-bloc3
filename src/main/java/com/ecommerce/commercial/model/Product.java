package com.ecommerce.commercial.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Product {

  @Id
  @SequenceGenerator(name = "product_seq", sequenceName = "product_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
  @Column(name = "product_id", updatable = false)
  private Long id;

  private String name;
  
  private Long price;

  private String description;

  private String image;

  @ManyToOne
  @JoinColumn(name = "category_id")
  @JsonManagedReference
  private Category category;

  @ManyToOne
  @JoinColumn(name = "discount_id")
  @JsonManagedReference
  private Discount discount;

@Column(name="discount_price")
  private Long discountedPrice;

  public Product(String name, Long price, String description, Category category, String image, Discount discount, Long discountedPrice) {
    this.name = name;
    this.price = price;
    this.description = description;
    this.category = category;
    this.image = image;
    this.discount = discount;
    this.discountedPrice = discountedPrice;
  }

  public Product(Long id, String name, Long price, String description, Category category, String image, Discount discount, Long discountedPrice) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.description = description;
    this.category = category;
    this.image = image;
    this.discount = discount;
    this.discountedPrice = discountedPrice;
  }

  public Product() {
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

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
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

  public Discount getDiscount() {
    return discount;
  }

  public void setDiscount(Discount discount) {
    this.discount = discount;
  }

  public Long getDiscountedPrice() {
    return discountedPrice;
  }

  public void setDiscountedPrice(Long discountedPrice) {
    this.discountedPrice = discountedPrice;
  }
}
