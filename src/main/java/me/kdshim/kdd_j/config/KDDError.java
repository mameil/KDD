package me.kdshim.kdd_j.config;

import org.springframework.http.HttpStatus;

public enum KDDError {
    LINK_NOT_FOUND("KDD_000_001", "링크를 찾지 못했습니다", 400);


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

//    public HttpClientErrorException doThrow(){
//        throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, msg);
//    }

    public CoreException doThrow(){
        throw new CoreException(new CoreExceptionData(code, msg, HttpStatus.BAD_REQUEST));
    }
}
