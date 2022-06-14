package me.kdshim.kdd_j.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public enum KDDError {
    LINK_NOT_FOUND("KDD_000_001", "링크를 찾지 못했습니다");



    private String code;
    private String msg;

    KDDError(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }

    public HttpClientErrorException doThrow(){
        throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, msg);
    }
}
