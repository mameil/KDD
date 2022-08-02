package me.kdshim.kdd_j.common;

import org.springframework.http.HttpStatus;

public class CoreExceptionData {
    String returnCode;
    String returnMsg;
    HttpStatus httpStatus;

    public CoreExceptionData(String returnCode, String returnMsg, HttpStatus status){
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
        this.httpStatus = status;
    }
}
