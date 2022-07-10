package me.kdshim.kdd_j.swagger.api;

import me.kdshim.kdd_j.swagger.model.ErrorResponseDto;
import me.kdshim.kdd_j.swagger.model.GetMemberDto;
import me.kdshim.kdd_j.swagger.model.PostMemberDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * A delegate to be called by the {@link MemberApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
public interface MemberApiDelegate {

    Logger log = LoggerFactory.getLogger(MemberApi.class);

    default Optional<ObjectMapper> getObjectMapper(){
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest(){
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    /**
     * @see MemberApi#postMember
     */
    default ResponseEntity<GetMemberDto> postMember( PostMemberDto  body) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\n  \"zipCode\" : \"10365\",\n  \"loginId\" : \"playggg\",\n  \"role\" : \"USER\",\n  \"created\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"oldAddr\" : \"경기도 고양시 일산서구 주엽동 84\",\n  \"birthDateYYYYMMDD\" : \"19970329\",\n  \"update\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"password\" : \"rbeh!234\",\n  \"name\" : \"kdshim\",\n  \"addrDetail\" : \"1504동 1501호\",\n  \"addr\" : \"경기도 고양시 일산서구 강선로 30\",\n  \"married\" : false,\n  \"email\" : \"kyudo97@naver.com\"\n}", GetMemberDto.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default MemberApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
