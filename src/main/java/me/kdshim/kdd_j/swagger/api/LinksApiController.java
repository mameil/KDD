package me.kdshim.kdd_j.swagger.api;

import me.kdshim.kdd_j.swagger.model.ErrorResponseDto;
import me.kdshim.kdd_j.swagger.model.GetLinkDto;
import me.kdshim.kdd_j.swagger.model.PostLinkDto;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
public class LinksApiController implements LinksApi {

    private final LinksApiDelegate delegate;

    @org.springframework.beans.factory.annotation.Autowired
    public LinksApiController(LinksApiDelegate delegate) {
        this.delegate = delegate;
    }
    public ResponseEntity<List<GetLinkDto>> getAllLinks() {
        return delegate.getAllLinks();
    }

    public ResponseEntity<GetLinkDto> saveSingleLink(@ApiParam(value = "" ) @Valid @RequestBody PostLinkDto body) {
        return delegate.saveSingleLink(body);
    }

}
