package com.kove.pcstore.model.form;

import com.kove.pcstore.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;

public class RegistrationForm  {

    private String username;
    private String password;

    public User toUser(PasswordEncoder passwordEncoder){
        return new User(username, passwordEncoder.encode(password));
    }

    public RegistrationForm() {
    }

    public RegistrationForm(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}
