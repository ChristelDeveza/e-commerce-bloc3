package com.ecommerce.commercial.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
// import jakarta.persistence.Lob;
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

  // @Lob
  // @Column(columnDefinition = "bytea")
  // private byte[] image;

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

  @ManyToOne
  @JoinColumn(name = "category_id")
  @JsonManagedReference
  private Category category;

  public Product(String name, Long price, String description, Category category) {
    this.name = name;
    this.price = price;
    this.description = description;
    this.category = category;
    
  }

  public Product(Long id, String name, Long price, String description, Category category) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.description = description;
    this.category = category;
   
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

  public void setCapacitesList(Category category) {
    this.category = category;
  }

//   public byte[] getImage() {
//     return image;
// }

// public void setImage(byte[] image) {
//     this.image = image;
// }

}
