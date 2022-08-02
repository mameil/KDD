package me.kdshim.kdd_j.common;

import lombok.extern.slf4j.Slf4j;
import me.kdshim.kdd_j.swagger.model.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(CoreException.class)
    public ResponseEntity<ErrorResponseDto> kddError(CoreException e){
        String msg = e.getMessage();
        log.error(msg);
        ErrorResponseDto dto = new ErrorResponseDto();
        String parsed = msg.substring(1, msg.indexOf("]"));
        dto.setCode(parsed);
        String parsedMsg = msg.substring(msg.indexOf("]")+2, msg.length());
        dto.setMessage(parsedMsg);
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }
}
