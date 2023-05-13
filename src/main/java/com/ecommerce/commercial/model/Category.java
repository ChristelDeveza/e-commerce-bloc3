package com.ecommerce.commercial.model;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Category {

  @Id
  private Long id;

  private String libelle;
  
  
  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

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
}
