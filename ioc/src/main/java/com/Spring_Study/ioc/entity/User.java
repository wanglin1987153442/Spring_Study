package com.Spring_Study.ioc.entity;

import lombok.Data;

/**
 * @author wl
 * @ClassNameUser
 * @Description TODO
 * @Date 2020/3/13
 * @Version 1.0
 */
@Data
public class User {
    private String account;
   private String password;

    public User(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public User() {

    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}
