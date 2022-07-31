package me.kdshim.kdd_j.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web
//                .ignoring()
//                .antMatchers("/css/**", "/fonts/**", "/images/**", "/jpg/**", "/js/**", "/vender/**")
//        ;
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/css/**", "/fonts/**", "/images/**", "/jpg/**", "/js/**", "/vendor/**").permitAll()
                .antMatchers("/home").permitAll().anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll().and()
                .logout()
        ;
    }


}
