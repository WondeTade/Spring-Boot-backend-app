package com.wonde.celebritiesofficialpageinfoservice.security;

import com.wonde.celebritiesofficialpageinfoservice.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.wonde.celebritiesofficialpageinfoservice.security.AppUserRoles.ADMIN;
import static com.wonde.celebritiesofficialpageinfoservice.security.AppUserRoles.USER;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("**/admmin/**").hasRole(ADMIN.name())
                .antMatchers("/secure/admin/**").hasRole(ADMIN.name())
                .antMatchers("/secure/user").hasAnyRole(USER.name(), ADMIN.name())
                .antMatchers("/secure/user/**").hasAnyRole(USER.name(), ADMIN.name())
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .and()
                .formLogin();
//                .loginPage("/login");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {

        return NoOpPasswordEncoder.getInstance();
    }
}
