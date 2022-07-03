package me.kdshim.kdd_j.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.kdshim.kdd_j.common.BaseEntity;
import me.kdshim.kdd_j.swagger.model.GetMemberDto;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseEntity {
    //LoginInfo
    @Id
    String loginId;

    String password;

    @Embedded
    ROLE role;


    //UserInfo
    String name;

    String birthDateYYYYMMDD;

    boolean married;

    String email;

    @Embedded
    Address address;

    public static Member from(GetMemberDto dto){
        return Member.builder()
                .loginId(dto.getLoginId())
                .password(dto.getPassword())
                .role(ROLE.valueOf(dto.getRole().toString()))
                .name(dto.getName())
                .birthDateYYYYMMDD(dto.getBirthDateYYYYMMDD())
                .married(dto.isMarried())
                .email(dto.getEmail())
                .build();
    }
}
