package me.kdshim.kdd_j.swagger.api;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinkApiController implements LinkApi {

    private final LinkApiDelegate delegate;

    @org.springframework.beans.factory.annotation.Autowired
    public LinkApiController(LinkApiDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public LinkApiDelegate getDelegate() {
        return delegate;
    }
}
