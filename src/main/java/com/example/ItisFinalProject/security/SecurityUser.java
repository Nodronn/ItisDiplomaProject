package com.example.ItisFinalProject.security;

import com.example.ItisFinalProject.entity.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Data
public class SecurityUser implements UserDetails {

    private User user;

    public SecurityUser(User user) {
        this.user = user;
    }

    //private String username;
    //private String password;
    //private Set<SimpleGrantedAuthority> authorities;
//
    //public SecurityUser(String username, String password, Set<SimpleGrantedAuthority> authorities) {
    //    this.username = username;
    //    this.password = password;
    //    this.authorities = authorities;
    //}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.user.getUserRole().getAuthorities();
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getEmail();
    }

    public Long getId () {
        return this.user.getId();
    }

    public void setUsername(String username) {
        this.user.setEmail(username);
    }
    public String getFirstName() {
        return this.user.getFirstName();
    }

    public String getLastName() {
        return this.user.getLastName();
    }

    public String getCountry(){return this.user.getCountry();}

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

    //public static UserDetails fromUser(User user) {
    //    return new SecurityUser(                             //org.springframework.security.core.userdetails.User(
    //            user.getEmail(),
    //            user.getPassword(),
    //            user.getUserRole().getAuthorities()
    //    );
    //}
}