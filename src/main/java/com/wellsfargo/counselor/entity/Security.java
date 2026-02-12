package com.wellsfargo.demo.entities;

import javax.persistence.*; // Agar error aaye toh jakarta.persistence use karein
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "security")
public class Security {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer security_id;

    // Relationship: Many securities belong to one portfolio
    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;

    private String name;
    private String category;
    private LocalDate purchase_date;
    private BigDecimal purchase_price;
    private int quantity;

    // 1. Default Constructor
    public Security() {}

    // 2. Full Constructor (Task requirement)
    public Security(Portfolio portfolio, String name, String category, 
                    LocalDate purchase_date, BigDecimal purchase_price, int quantity) {
        this.portfolio = portfolio;
        this.name = name;
        this.category = category;
        this.purchase_date = purchase_date;
        this.purchase_price = purchase_price;
        this.quantity = quantity;
    }

    // 3. Getters and Setters
    public Integer getSecurity_id() { return security_id; }

    public Portfolio getPortfolio() { return portfolio; }
    public void setPortfolio(Portfolio portfolio) { this.portfolio = portfolio; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public LocalDate getPurchase_date() { return purchase_date; }
    public void setPurchase_date(LocalDate purchase_date) { this.purchase_date = purchase_date; }

    public BigDecimal getPurchase_price() { return purchase_price; }
    public void setPurchase_price(BigDecimal purchase_price) { this.purchase_price = purchase_price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}