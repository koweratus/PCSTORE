package com.kove.pcstore.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Entity
public class Component {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Valid
    @ManyToOne
    @JoinColumn(name = "MANAFACTURER_ID")
    private Manafacturer manafacturer;

   // @NotEmpty(message = "{validation.component.title.notEmpty}")
   // @Size(min = 1, max = 50, message = "{validation.component.title.size}")
    private String title;

   // @NotEmpty(message = "{validation.component.description.notEmpty}")
   // @Size(min = 1, max = 100, message = "{validation.component.description.size}")
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

    public Component(Manafacturer manafacturer, String title, String description, Type type) {
        this.manafacturer = manafacturer;
        this.title = title;
        this.description = description;
        this.type = type;
    }

    public Component(Long id, Manafacturer manafacturer, String title, String description, Type type, Date createdAt) {
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
        Component component = (Component) o;
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

    public Manafacturer getManafacturer() {
        return manafacturer;
    }

    public void setManafacturer(Manafacturer manafacturer) {
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
