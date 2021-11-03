package com.example.codefellowship.model;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


public class ApplicationUserModel implements UserDetails {
    UserDataModel userDataModel;




    public ApplicationUserModel(){
    }

    public ApplicationUserModel(UserDataModel userDataModel) {
        this.userDataModel = userDataModel;
    }

    public int getId() {
        return userDataModel.getId();
    }

    public String getUsername() {
        return userDataModel.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return userDataModel.getPassword();
    }


    public UserDataModel getDbUserData() {
        return userDataModel;
    }

    public void setDbUserData(UserDataModel userDataModel) {
        this.userDataModel = userDataModel;
    }
}