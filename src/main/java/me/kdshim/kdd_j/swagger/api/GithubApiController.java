package me.kdshim.kdd_j.swagger.api;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class GithubApiController implements GithubApi {

    private final GithubApiDelegate delegate;

    @org.springframework.beans.factory.annotation.Autowired
    public GithubApiController(GithubApiDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public GithubApiDelegate getDelegate() {
        return delegate;
    }
}
