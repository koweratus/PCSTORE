package com.kove.pcstore.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Component{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;


        private String manafacturer;

        private String title;

        private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
        private Type type;


    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;


    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }

public static enum Type {
    GPU,
    CPU,
    MOBO,
    RAM,
    PSU
}

    public Component() {
    }

    public Component(String manafacturer, String title, String description, Type type) {
        this.manafacturer = manafacturer;
        this.title = title;
        this.description = description;
        this.type = type;
    }

    public Component(Long id, String manafacturer, String title, String description, Type type, Date createdAt) {
        this.id = id;
        this.manafacturer = manafacturer;
        this.title = title;
        this.description = description;
        this.type = type;
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Component component= (Component) o;
        return Objects.equals(id, component.id) &&
                Objects.equals(manafacturer, component.manafacturer) &&
                Objects.equals(title, component.title) &&
                Objects.equals(description, component.description) &&
                type == component.type &&
                Objects.equals(createdAt, component.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, manafacturer, title, description, type, createdAt);
    }

    @Override
    public String toString() {
        return "Component{" +
                "id=" + id +
                ", manafacturer=" + manafacturer +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", createdAt=" + createdAt +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManafacturer() {
        return manafacturer;
    }

    public void setManafacturer(String manafacturer) {
        this.manafacturer = manafacturer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
