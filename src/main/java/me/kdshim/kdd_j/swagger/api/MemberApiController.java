package me.kdshim.kdd_j.swagger.api;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberApiController implements MemberApi {

    private final MemberApiDelegate delegate;

    @org.springframework.beans.factory.annotation.Autowired
    public MemberApiController(MemberApiDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public MemberApiDelegate getDelegate() {
        return delegate;
    }
}
