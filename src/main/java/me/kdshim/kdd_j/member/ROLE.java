package me.kdshim.kdd_j.member;

import lombok.Getter;
import me.kdshim.kdd_j.swagger.model.GetMemberDto;

@Getter
public enum ROLE {
    ADMIN("ADMIN", "어드민전용"),
    USER("USER", "일반 사용자");

    private String name;
    private String memo;
    ROLE(String name, String memo) {
        this.name = name;
        this.memo = memo;
    }

    public static GetMemberDto.RoleEnum toDto(ROLE role){
        return GetMemberDto.RoleEnum.fromValue(role.toString());
    }

}
