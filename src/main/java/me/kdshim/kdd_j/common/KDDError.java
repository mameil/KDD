package me.kdshim.kdd_j.common;

import org.springframework.http.HttpStatus;

public enum KDDError {
    //link - ***_000_***
    LINK_NOT_FOUND("KDD_000_001", "링크를 찾지 못했습니다", 400),

    //member - ***_001_***
    MEMBER_NOT_FOUND("KDD_001_001", "해당하는 아이디의 유저를 찾지 못했습니다", 400),
    LOGIN_ID_EXISTS("KDD_001_002", "로그인에 사용할 아이디가 이미 존재합니다!", 400),
    PASSWORD_MATCHED_ERROR("KDD_001_003", "패스워드 확인하는 도중에 에러가 발생했습니다", 400),

    //t_o_d_o - ***_002_***
    UNDONE_TODO_NOT_FOUND("KDD_002_001", "미완료된 TODO가 없습니다", 400),
    ;

    private final String code;
    private final String msg;
    private final int status;

    KDDError(String code, String msg, int status){
        this.code = code;
        this.msg = msg;
        this.status = status;
    }

    public String getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }

//    public HttpClientErrorException getThrow(){
//        throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, msg);
//    }

    public CoreException doThrow(){
        throw new CoreException(new CoreExceptionData(code, msg, HttpStatus.BAD_REQUEST));
    }
}
