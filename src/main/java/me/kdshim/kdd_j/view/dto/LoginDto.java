package me.kdshim.kdd_j.view.dto;

import lombok.*;
import me.kdshim.kdd_j.member.ROLE;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data

//builder 쓸때는 3개를 세트로 사용하자
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto implements UserDetails {
    private String id;
    private String password;
    private ROLE role;
    @Builder.Default
    private boolean success = false;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //계정 잠금 여부?
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //계정 패스워드 만료 여부
        return true;
    }

    @Override
    public boolean isEnabled() {
        //계정 활성화 여부
        return true;
    }
}
