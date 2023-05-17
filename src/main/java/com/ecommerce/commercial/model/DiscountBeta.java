package com.ecommerce.commercial.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "discount")
public class DiscountBeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discount_id")
    private Long discountId;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "pourcent")
    private Integer percentage;

    @OneToMany(mappedBy = "discountBeta")
    private List<ProductBeta> productBeta;

    // constructeurs, getters, setters, etc.

    public DiscountBeta(Long discountId, LocalDate startDate, LocalDate endDate, Integer percentage, List<ProductBeta> productBeta) {
      this.discountId = discountId;
      this.startDate = startDate;
      this.endDate = endDate;
      this.percentage = percentage;
      this.productBeta = productBeta;
    
    }
    public DiscountBeta(LocalDate startDate, LocalDate endDate, Integer percentage, List<ProductBeta> productBeta) {
      this.startDate = startDate;
      this.endDate = endDate;
      this.percentage = percentage;
      this.productBeta = productBeta;
    
    }

    public DiscountBeta() {
      //Needed Hibernate
    }
  
    public Long getDiscountId() {
      return discountId;
    }
  
    public void setDiscountId(Long discountId) {
      this.discountId = discountId;
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
  
    public Integer getPercentage() {
      return percentage;
    }
  
    public void setPercentage(Integer percentage) {
      this.percentage = percentage;
    }
  
    public List<ProductBeta> getProductBeta() {
      return productBeta;
    }
  
    public void setProductBeta(List<ProductBeta> productBeta) {
      this.productBeta = productBeta;
    }
  

}
