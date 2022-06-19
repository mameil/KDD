package me.kdshim.kdd_j.swagger.api;

import me.kdshim.kdd_j.swagger.model.ErrorResponseDto;
import me.kdshim.kdd_j.swagger.model.GetLinkDto;
import me.kdshim.kdd_j.swagger.model.PostLinkDto;
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
 * A delegate to be called by the {@link LinksApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
public interface LinksApiDelegate {

    Logger log = LoggerFactory.getLogger(LinksApi.class);

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
     * @see LinksApi#deleteAllLinks
     */
    default ResponseEntity<Void> deleteAllLinks() {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default LinksApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * @see LinksApi#getAllLinks
     */
    default ResponseEntity<List<GetLinkDto>> getAllLinks() {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("[ {\n  \"created\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"name\" : \"Java Stream API는 왜 for-loop보다 느릴까?\",\n  \"memo\" : \"실제 예시를 통한 비교 해둔 글\",\n  \"update\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"category\" : \"JAVA\",\n  \"url\" : \"https://jypthemiracle.medium.com/java-stream-api는-왜-for-loop보다-느릴까-50dec4b9974b\"\n}, {\n  \"created\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"name\" : \"Java Stream API는 왜 for-loop보다 느릴까?\",\n  \"memo\" : \"실제 예시를 통한 비교 해둔 글\",\n  \"update\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"category\" : \"JAVA\",\n  \"url\" : \"https://jypthemiracle.medium.com/java-stream-api는-왜-for-loop보다-느릴까-50dec4b9974b\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default LinksApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * @see LinksApi#saveLinkList
     */
    default ResponseEntity<Void> saveLinkList( List<PostLinkDto>  body) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default LinksApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
