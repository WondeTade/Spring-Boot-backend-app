package com.wonde.celebritiesofficialpageinfoservice.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class AppUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer user_id;
    private String userName;
    private String password;
    private Boolean active;
    private String roles;

    public AppUsers(Integer user_id, String userName, String password, Boolean active, String roles) {
        this.user_id = user_id;
        this.userName = userName;
        this.password = password;
        this.active = active;
        this.roles = roles;
    }

    public AppUsers() {
    }

    public int getId() {
        return user_id;
    }

    public void setId(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUserName() {
        return userName;
    }

    public AppUsers setUserName(String user_name) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public AppUsers setPassword(String password) {
        this.password = password;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public AppUsers setActive(Boolean active) {
        this.active = active;
        return this;
    }

    public String getRoles() {
        return roles;
    }

    public AppUsers setRoles(String roles) {
        this.roles = roles;
        return this;
    }
}
