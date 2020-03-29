package com.wonde.celebritiesofficialpageinfoservice.services;

import com.wonde.celebritiesofficialpageinfoservice.model.AppUsers;
import com.wonde.celebritiesofficialpageinfoservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String user_name) throws UsernameNotFoundException {
        Optional<AppUsers> user = userRepository.findByUserName(user_name);

        user.orElseThrow(() -> new UsernameNotFoundException("Not Found"+ user_name));

        return user.map(appUsers -> new CustomUserDetails(appUsers)).get();
    }

}
