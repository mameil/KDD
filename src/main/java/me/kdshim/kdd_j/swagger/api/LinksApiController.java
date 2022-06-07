package me.kdshim.kdd_j.swagger.api;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinksApiController implements LinksApi {

    private final LinksApiDelegate delegate;

    @org.springframework.beans.factory.annotation.Autowired
    public LinksApiController(LinksApiDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public LinksApiDelegate getDelegate() {
        return delegate;
    }
}
