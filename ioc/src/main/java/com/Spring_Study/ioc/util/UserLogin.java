package com.Spring_Study.ioc.util;


import com.Spring_Study.ioc.entity.User;

/**
 * @author wl
 * @ClassNameUserLogin
 * @Description TODO
 * @Date 2020/3/13
 * @Version 1.0
 */
public class UserLogin {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean userLogin(User user) {
        Boolean flag=false;
        if (user.getAccount() != null && user.getPassword() != null) {

            if (("admin").equals(user.getAccount()) && ("111").equals(user.getPassword())) {

                 flag=true;
            }
        }
        return  flag;
    }
}
