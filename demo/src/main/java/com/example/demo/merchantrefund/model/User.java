package com.example.demo.merchantrefund.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "SA_User")
public class User {
    @Column(name = "userID")
    @Id
    private int userID;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "full_name")
    private String full_name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "fail_login_count")
    private int fail_login_count;

    @Column(name = "last_login")
    private Date last_login;

    @Column(name = "roleID")
    private int roleId;

    @Column(name = "status")
    private int status;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getFail_login_count() {
        return fail_login_count;
    }

    public void setFail_login_count(int fail_login_count) {
        this.fail_login_count = fail_login_count;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
