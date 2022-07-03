package me.kdshim.kdd_j.member;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ROLE {
    ADMIN("ROLE_ADMIN", "바로 이몸이지!"),
    USER("ROLE_USER", "나는야 선량한 유저");

    private final String key;
    private final String comment;
}
