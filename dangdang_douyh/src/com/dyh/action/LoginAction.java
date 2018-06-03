package com.dyh.action;

import com.dyh.entity.User;

public class LoginAction {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private String getEmail(){
        return "login";
    }
}
