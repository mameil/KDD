package me.kdshim.kdd_j.swagger.api;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoApiController implements TodoApi {

    private final TodoApiDelegate delegate;

    @org.springframework.beans.factory.annotation.Autowired
    public TodoApiController(TodoApiDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public TodoApiDelegate getDelegate() {
        return delegate;
    }
}
