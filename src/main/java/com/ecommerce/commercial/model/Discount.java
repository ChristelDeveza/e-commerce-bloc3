package com.ecommerce.commercial.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Discount {
  
  @Id
  @SequenceGenerator(name = "discount_seq", sequenceName = "discount_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discount_seq")
  @Column(name = "discount_id", updatable = false)
  private Long id;

  @Column(name="start_date")
  private LocalDate startDate;

  @Column(name="end_date")
  private LocalDate endDate;

  @Column(name="pourcent")
  private Long percentage;

  
  @OneToMany(mappedBy = "discount")
  @JsonBackReference
  private List<Product> product;

  public Discount(LocalDate startDate, LocalDate endDate, Long percentage) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.percentage = percentage;
  }

  public Discount(Long id, LocalDate startDate, LocalDate endDate, Long percentage) {
    this.id = id;
    this.startDate = startDate;
    this.endDate = endDate;
    this.percentage = percentage;
  }

  public Discount() {
    //Needed Hibernate
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public Long getPercentage() {
    return percentage;
  }

  public void setPercentage(Long percentage) {
    this.percentage = percentage;
  }

  public List<Product> getProduct() {
    return product;
  }

  public void setProduct(List<Product> product) {
    this.product = product;
  }

  

}
