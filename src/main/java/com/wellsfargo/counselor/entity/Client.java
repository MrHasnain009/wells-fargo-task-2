package com.wellsfargo.demo.entities;

import javax.persistence.*; // Agar error aaye toh jakarta.persistence use karein
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer client_id;

    // Relationship: Many clients belong to one advisor
    @ManyToOne
    @JoinColumn(name = "advisor_id") // Ye database mein Foreign Key banayega
    private FinancialAdvisor advisor;

    private String first_name;
    private String last_name;
    private LocalDate date_of_birth; // Date ke liye LocalDate behtar hai
    private String email;
    private String phone;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    // 1. Default Constructor
    public Client() {}

    // 2. Full Constructor (Initializing all variables)
    public Client(FinancialAdvisor advisor, String first_name, String last_name, 
                  LocalDate date_of_birth, String email, String phone, 
                  LocalDateTime created_at, LocalDateTime updated_at) {
        this.advisor = advisor;
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_of_birth = date_of_birth;
        this.email = email;
        this.phone = phone;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    // 3. Getters and Setters
    public Integer getClient_id() { return client_id; }

    public FinancialAdvisor getAdvisor() { return advisor; }
    public void setAdvisor(FinancialAdvisor advisor) { this.advisor = advisor; }

    public String getFirst_name() { return first_name; }
    public void setFirst_name(String first_name) { this.first_name = first_name; }

    public String getLast_name() { return last_name; }
    public void setLast_name(String last_name) { this.last_name = last_name; }

    public LocalDate getDate_of_birth() { return date_of_birth; }
    public void setDate_of_birth(LocalDate date_of_birth) { this.date_of_birth = date_of_birth; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public LocalDateTime getCreated_at() { return created_at; }
    public void setCreated_at(LocalDateTime created_at) { this.created_at = created_at; }

    public LocalDateTime getUpdated_at() { return updated_at; }
    public void setUpdated_at(LocalDateTime updated_at) { this.updated_at = updated_at; }
}