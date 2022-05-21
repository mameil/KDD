package spec.swagger.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;

@Controller
@RequestMapping("${openapi.kDDProject.base-path:/}")
public class LinksApiController implements LinksApi {

    private final LinksApiDelegate delegate;

    public LinksApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) LinksApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new LinksApiDelegate() {});
    }

    @Override
    public LinksApiDelegate getDelegate() {
        return delegate;
    }

}
