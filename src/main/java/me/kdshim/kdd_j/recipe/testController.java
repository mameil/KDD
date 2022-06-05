package me.kdshim.kdd_j.recipe;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    @GetMapping("/test")
    public ResponseEntity<?> checking(){

        System.out.println("==============================================");
        System.out.println("check this sample TEST");
        System.out.println("==============================================");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
