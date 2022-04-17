package com.ricardotcc.spring.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
//@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    // @Autowired
    // private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.cors()
            .and().authorizeRequests()
            .antMatchers("/salvaloginapi", "/fazerloginapi", "/salvarartigo", "/artigolista").permitAll()
            .anyRequest().authenticated()            
            .and()            
            .httpBasic()
            .and()
            .csrf().disable();
            http.headers().frameOptions().disable();
    }

    // @Autowired
    // public void configure(AuthenticationManagerBuilder auth) throws Exception {
    //     auth.userDetailsService(userDetailService).passwordEncoder(bCryptPasswordEncoder);

    // }

}