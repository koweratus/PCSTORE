package com.kove.pcstore.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.PrePersist;
import java.util.Date;
import java.util.Objects;

public class Manafacturer{

        private Long id;


        private String firstname;


        private String lastname;

        private Date createdAt;

        @PrePersist
        @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
        void createdAt() {
            this.createdAt = new Date();
        }

        public Manafacturer() {
        }

        public Manafacturer(String firstname, String lastname) {
            this.firstname = firstname;
            this.lastname = lastname;
        }

        public Manafacturer(Long id, String firstname, String lastname, Date createdAt) {
            this.id = id;
            this.firstname = firstname;
            this.lastname = lastname;
            this.createdAt = createdAt;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Manafacturer manafacturer = (Manafacturer) o;
            return Objects.equals(id, manafacturer.id) &&
                    Objects.equals(firstname, manafacturer.firstname) &&
                    Objects.equals(lastname, manafacturer.lastname) &&
                    Objects.equals(createdAt, manafacturer.createdAt);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, firstname, lastname, createdAt);
        }

        @Override
        public String toString() {
            return "Manafacturer{" +
                    "id=" + id +
                    ", firstname='" + firstname + '\'' +
                    ", lastname='" + lastname + '\'' +
                    ", createdAt=" + createdAt +
                    '}';
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public Date getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
        }
}
