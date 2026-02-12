package com.wellsfargo.demo.entities;

import javax.persistence.*; // Agar error aaye toh jakarta.persistence use karein
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "portfolio")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer portfolio_id;

    // Relationship: One Portfolio belongs to exactly one Client
    // unique = true lagaya hai kyunke ERD mein UNIQUE constraint hai
    @OneToOne
    @JoinColumn(name = "client_id", unique = true)
    private Client client;

    // Relationship: One portfolio contains many securities
    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL)
    private List<Security> securities;

    private LocalDateTime created_at;

    // Decimal ke liye Java mein BigDecimal best practice hai
    private BigDecimal total_value;

    // 1. Default Constructor
    public Portfolio() {}

    // 2. Full Constructor
    public Portfolio(Client client, List<Security> securities, LocalDateTime created_at, BigDecimal total_value) {
        this.client = client;
        this.securities = securities;
        this.created_at = created_at;
        this.total_value = total_value;
    }

    // 3. Getters and Setters
    public Integer getPortfolio_id() { return portfolio_id; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public List<Security> getSecurities() { return securities; }
    public void setSecurities(List<Security> securities) { this.securities = securities; }

    public LocalDateTime getCreated_at() { return created_at; }
    public void setCreated_at(LocalDateTime created_at) { this.created_at = created_at; }

    public BigDecimal getTotal_value() { return total_value; }
    public void setTotal_value(BigDecimal total_value) { this.total_value = total_value; }
}