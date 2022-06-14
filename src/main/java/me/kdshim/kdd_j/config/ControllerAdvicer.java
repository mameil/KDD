package me.kdshim.kdd_j.config;

import io.undertow.util.BadRequestException;
import lombok.extern.slf4j.Slf4j;
import me.kdshim.kdd_j.swagger.model.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@Slf4j
@RestControllerAdvice
public class ControllerAdvicer {

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ErrorResponseDto> kddError(HttpClientErrorException e){
        log.error(e.getMessage());
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }
}
