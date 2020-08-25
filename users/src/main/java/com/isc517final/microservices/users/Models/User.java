package com.isc517final.microservices.users.Models;

import javax.persistence.*;
import org.json.simple.JSONObject;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean active;

    @Column(nullable = false)
    private String role;

    public User() {
    }

    public User(String name, String email, String password, boolean active, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.active = active;
        this.role = role;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return this.active;
    }

    public boolean getActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String toJson() {

        JSONObject json = new JSONObject();

        json.put("id", this.id);
        json.put("name", this.name);
        json.put("email", this.email);
        json.put("password", this.password);
        json.put("active", this.active);
        json.put("role", this.role);

        return json.toJSONString();
    }
}
