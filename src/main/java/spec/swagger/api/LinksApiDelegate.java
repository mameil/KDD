package spec.swagger.api;

import spec.swagger.model.ErrorResponseDto;
import spec.swagger.model.MyLinkDto;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * A delegate to be called by the {@link LinksApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */

public interface LinksApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * @see LinksApi#linksGet
     */
    default ResponseEntity<MyLinkDto> linksGet() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"name\" : \"Java Stream API는 왜 for-loop보다 느릴까?\",  \"category\" : \"JAVA\",  \"url\" : \"https://jypthemiracle.medium.com/java-stream-api는-왜-for-loop보다-느릴까-50dec4b9974b\",  \"desc\" : \"실제 예시를 통한 비교 해둔 글\"}");
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
