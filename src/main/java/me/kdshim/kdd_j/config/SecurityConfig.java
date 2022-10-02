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
    private final CustomSuccessHandler successHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //기본적으로 spring security에서는 기본적으로 csrf 을 체크하기 떄문에 post가 이루어지지 않는다! 아래로
        http.csrf().disable();

        //이걸 적용하기 위해서는 -> userDetailService 구현해야하는데 -> member에 security의 user객체를 상속받는놈으로 재구성해줘야함..
        http
                .authorizeRequests()
                    .antMatchers("/login/**").permitAll()
                    .antMatchers("/css/**", "/fonts/**", "/images/**", "/jpg/**", "/js/**", "/vendor/**").permitAll()
//                    .antMatchers("/home").permitAll().anyRequest().authenticated()
//                    .antMatchers("/swagger-ui").permitAll()

                //security 에서 제공해주는 로그인 서비스를 사용하려면 POST-/login 이렇게 보내줘야함
                //밑에 세팅은 모든 부분에서 다 security 적용해준다는 의미임 -> 이거 걸면 모든 request에서 302(redirect)가 나옴, 대충 권한없어서 로그인으로 넘어갔다는 뜻
//                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/main")
//                .successHandler(successHandler)
                .permitAll()
        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }
}
