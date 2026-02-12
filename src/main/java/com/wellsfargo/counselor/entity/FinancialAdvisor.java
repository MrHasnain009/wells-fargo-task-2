package com.wellsfargo.demo.entities; // Aapka jo bhi package path ho wo likhein

import javax.persistence.*; // Agar error aaye toh 'jakarta.persistence' try karein
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "financial_advisor")
public class FinancialAdvisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer advisor_id;

    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    // Relationship: Ek advisor ke many clients ho sakte hain
    @OneToMany(mappedBy = "advisor", cascade = CascadeType.ALL)
    private List<Client> clients;

    // 1. Default Constructor (Zaroori hai Hibernate ke liye)
    public FinancialAdvisor() {}

    // 2. Constructor for all variables (Task ki requirement hai)
    public FinancialAdvisor(String first_name, String last_name, String email, 
                            String phone_number, LocalDateTime created_at, 
                            LocalDateTime updated_at, List<Client> clients) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone_number = phone_number;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.clients = clients;
    }

    // 3. Getters and Setters (ID ka setter nahi banana)
    public Integer getAdvisor_id() { return advisor_id; }

    public String getFirst_name() { return first_name; }
    public void setFirst_name(String first_name) { this.first_name = first_name; }

    public String getLast_name() { return last_name; }
    public void setLast_name(String last_name) { this.last_name = last_name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone_number() { return phone_number; }
    public void setPhone_number(String phone_number) { this.phone_number = phone_number; }

    public LocalDateTime getCreated_at() { return created_at; }
    public void setCreated_at(LocalDateTime created_at) { this.created_at = created_at; }

    public LocalDateTime getUpdated_at() { return updated_at; }
    public void setUpdated_at(LocalDateTime updated_at) { this.updated_at = updated_at; }

    public List<Client> getClients() { return clients; }
    public void setClients(List<Client> clients) { this.clients = clients; }
}