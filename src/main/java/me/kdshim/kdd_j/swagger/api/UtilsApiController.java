package me.kdshim.kdd_j.swagger.api;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtilsApiController implements UtilsApi {

    private final UtilsApiDelegate delegate;

    @org.springframework.beans.factory.annotation.Autowired
    public UtilsApiController(UtilsApiDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public UtilsApiDelegate getDelegate() {
        return delegate;
    }
}
