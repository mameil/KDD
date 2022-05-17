package me.kdshim.kdd_j.controllerImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.kdshim.kdd_j.book.BookService;
import me.kdshim.kdd_j.swagger.api.SwaggerTestApiDelegate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SwaggerTestControllerImpl implements SwaggerTestApiDelegate {

    @Override
    public ResponseEntity<String> swaggerTestGet() {
        log.info("LOOK AT ME!");

        return ResponseEntity.ok("Hi There!");
    }
}
