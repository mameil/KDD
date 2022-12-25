package me.kdshim.kdd_j.member;

import com.google.gson.Gson;
import lombok.*;
import me.kdshim.kdd_j.common.BaseEntity;
import me.kdshim.kdd_j.swagger.model.GetMemberDto;
import me.kdshim.kdd_j.swagger.model.PostMemberDto;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Member extends BaseEntity implements Serializable {
    //LoginInfo
    @Id
    private String loginId;

    private String password;

    @Enumerated(EnumType.STRING)
    private ROLE role;

    //UserInfo
    private String name;

    private String birthDateYYYYMMDD;

    private boolean married;

    private String email;

    @Embedded
    private Address address;

    public String toString(){
        return new Gson().toJson(this);
    }

    public static Member fromDto(PostMemberDto dto){
        return Member.builder()
                .loginId(dto.getLoginId())
                .password(dto.getPassword())
                .role(ROLE.valueOf(dto.getRole().toString()))
                .name(dto.getName())
                .birthDateYYYYMMDD(dto.getBirthDateYYYYMMDD())
                .married(dto.isMarried())
                .email(dto.getEmail())
                .address(new Address(dto.getOldAddr(), dto.getAddr(), dto.getAddrDetail(), dto.getZipCode()))
                .build();
    }

    public static GetMemberDto toDto(Member member){
        GetMemberDto dto = new GetMemberDto();
        dto.setLoginId(member.getLoginId());
        dto.setPassword(member.getPassword());
        dto.setRole(ROLE.toDto(member.getRole()));
        dto.setName(member.getName());
        dto.setBirthDateYYYYMMDD(member.getBirthDateYYYYMMDD());
        dto.setMarried(member.isMarried());
        dto.setEmail(member.getEmail());
        dto.setAddr(member.getAddress().getAddr());
        dto.setOldAddr(member.getAddress().getOldAddr());
        dto.setAddrDetail(member.getAddress().getAddrDetail());
        dto.setZipCode(member.getAddress().getZipCode());
        return dto;
    }
}
