package com.ellection.models;

import org.springframework.security.core.authority.AuthorityUtils;

import java.util.List;
import java.util.Set;

/**
 * Created by faos7 on 02.04.17.
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User{

    private User user;

    public CurrentUser(User user) {
        super(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getAuthorities().toString()));
        this.user = user;
    }

    public User getUser(){
        return user;
    }

    public Long getId(){
        return user.getId();
    }

    public Set<Authority> getRole() {
        return user.getAuthorities();
    }

}