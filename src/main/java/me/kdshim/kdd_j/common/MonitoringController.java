package me.kdshim.kdd_j.common;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/monitoring")
@RequiredArgsConstructor
public class MonitoringController {
    private final RequestMappingHandlerMapping requestMappingHandlerMapping;

    @GetMapping("endpoints")
    public ResponseEntity<List<String>> getEndPoints(){
        List<String> endpoints = requestMappingHandlerMapping
                .getHandlerMethods()
                .keySet()
                .stream()
                .map(RequestMappingInfo::toString)
                .collect(Collectors.toList());

//        StringBuilder sb = new StringBuilder();
//        endpoints.forEach(parts -> {
//            sb.append(parts).append("\n");
//        });
        return new ResponseEntity<>(endpoints, HttpStatus.OK);
    }
}
