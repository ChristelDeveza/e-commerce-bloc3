package com.ecommerce.commercial.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {

  @Id
  @Column(name = "category_id")
  private Long id;

  private String libelle;
  
  
  @OneToMany(mappedBy = "category")
  @JsonBackReference
  private List<Product> product;

  public Category(String libelle) {
    this.libelle = libelle;
  }

  public Category(Long id, String libelle) {
    this.id = id;
    this.libelle = libelle;
  }

  public Category() {
    //Needed Hibernate
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public List<Product> getProduct() {
    return product;
  }

  public void setProduct(List<Product> product) {
    this.product = product;
  }
}
