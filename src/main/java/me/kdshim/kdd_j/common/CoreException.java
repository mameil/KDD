package me.kdshim.kdd_j.common;

public class CoreException extends RuntimeException{

    public CoreException(String message) {
        super(message);
    }

    public CoreException(CoreExceptionData data){
        super("["+data.returnCode+"] "+data.returnMsg);
    }
}
