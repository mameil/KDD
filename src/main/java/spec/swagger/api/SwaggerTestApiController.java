package spec.swagger.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;

@Controller
@RequestMapping("${openapi.kDDProject.base-path:/}")
public class SwaggerTestApiController implements SwaggerTestApi {

    private final SwaggerTestApiDelegate delegate;

    public SwaggerTestApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) SwaggerTestApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new SwaggerTestApiDelegate() {});
    }

    @Override
    public SwaggerTestApiDelegate getDelegate() {
        return delegate;
    }

}
