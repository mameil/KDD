package me.kdshim.kdd_j.swagger.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

/**
 * A delegate to be called by the {@link SwaggerTestApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */

public interface SwaggerTestApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * @see SwaggerTestApi#swaggerTestGet
     */
    default ResponseEntity<String> swaggerTestGet() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
