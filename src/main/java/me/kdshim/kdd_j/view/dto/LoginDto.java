package me.kdshim.kdd_j.view.dto;

import lombok.*;
import me.kdshim.kdd_j.member.ROLE;

@Data

//builder 쓸때는 3개를 세트로 사용하자
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    private String id;
    private String password;
    private ROLE role;
    @Builder.Default
    private boolean success = false;

}
