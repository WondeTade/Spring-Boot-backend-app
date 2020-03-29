package com.wonde.celebritiesofficialpageinfoservice.services;

import com.wonde.celebritiesofficialpageinfoservice.model.AppUsers;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {

    private final String user_name;
    private final String password;
    private final boolean active;

    private List<GrantedAuthority> authorities;

    public CustomUserDetails(AppUsers appUsers) {
        this.user_name = appUsers.getUserName();
        this.password =appUsers.getPassword();
        this.active = appUsers.isActive();
        this.authorities = Arrays.stream(appUsers.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return user_name;
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
        return active;
    }
}
