package com.kove.pcstore.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Entity
public class Manafacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "{validation.manafacturer.company.notEmpty}")
    @Size(min = 2, max = 20, message = "{validation.manafacturer.company.size}")
    private String company;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @PrePersist
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    void createdAt() {
        this.createdAt = new Date();
    }

    public Manafacturer() {
    }

    public Manafacturer(String company) {
        this.company = company;
    }

    public Manafacturer(Long id, String company, Date createdAt) {
        this.id = id;
        this.company = company;
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manafacturer manafacturer = (Manafacturer) o;
        return Objects.equals(id, manafacturer.id) &&
                Objects.equals(company, manafacturer.company) &&
                Objects.equals(createdAt, manafacturer.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, createdAt);
    }

    @Override
    public String toString() {
        return "Manafacturer{" +
                "id=" + id +
                ", name='" + company + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String firstname) {
        this.company = firstname;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
