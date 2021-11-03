package com.kove.pcstore.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "USERS")
public class User {
    @Id
    private final String username;

    private final String password;


    public User() {
        this.username = null;
        this.password = null;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.username);
        hash = 97 * hash + Objects.hashCode(this.password);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", password=" + password + '}';
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
