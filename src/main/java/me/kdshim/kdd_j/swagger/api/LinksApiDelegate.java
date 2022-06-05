package me.kdshim.kdd_j.swagger.api;

import me.kdshim.kdd_j.swagger.model.ErrorResponseDto;
import me.kdshim.kdd_j.swagger.model.PostLinkDto;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * A delegate to be called by the {@link LinksApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
public interface LinksApiDelegate {

    /**
     * @see LinksApi#linksGet
     */
    ResponseEntity<PostLinkDto> linksGet();

    /**
     * @see LinksApi#linksPost
     */
    ResponseEntity<Void> linksPost( List<PostLinkDto>  body);

}
