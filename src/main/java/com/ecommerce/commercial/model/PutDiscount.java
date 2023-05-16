package com.ecommerce.commercial.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="discount")
public class PutDiscount {
  
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

  @ManyToOne
  @JoinColumn(name="discount_id", insertable=false, updatable=false)
  private UpdateProduct updateProduct;

  public PutDiscount(LocalDate startDate, LocalDate endDate, Long percentage) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.percentage = percentage;
  }

  public PutDiscount(Long id, LocalDate startDate, LocalDate endDate, Long percentage) {
    this.id = id;
    this.startDate = startDate;
    this.endDate = endDate;
    this.percentage = percentage;
  }

  public PutDiscount() {
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

  public UpdateProduct getUpdatePostProduct() {
    return updateProduct;
  }

  public void setPostProduct(UpdateProduct updateProduct) {
    this.updateProduct = updateProduct;
  }

}
