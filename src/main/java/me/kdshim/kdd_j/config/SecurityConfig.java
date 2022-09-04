package me.kdshim.kdd_j.config;

import lombok.RequiredArgsConstructor;
import me.kdshim.kdd_j.member.MemberService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final MemberService memberService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //기본적으로 spring security에서는 기본적으로 csrf 을 체크하기 떄문에 post가 이루어지지 않는다! 아래로
        http.csrf().disable();

        http
                .authorizeRequests()
                .antMatchers("/login/**").permitAll()
                .antMatchers("/css/**", "/fonts/**", "/images/**", "/jpg/**", "/js/**", "/vendor/**").permitAll()
//                .antMatchers("/home").permitAll().anyRequest().authenticated()
//                .antMatchers("/swagger-ui").permitAll()

                .and()
                    .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/main")
                    .permitAll()
        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }
}
