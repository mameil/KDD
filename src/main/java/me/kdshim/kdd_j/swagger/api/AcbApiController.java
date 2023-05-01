package me.kdshim.kdd_j.swagger.api;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class AcbApiController implements AcbApi {

    private final AcbApiDelegate delegate;

    @org.springframework.beans.factory.annotation.Autowired
    public AcbApiController(AcbApiDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public AcbApiDelegate getDelegate() {
        return delegate;
    }
}
