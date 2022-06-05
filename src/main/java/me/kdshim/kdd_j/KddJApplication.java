package me.kdshim.kdd_j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class KddJApplication {

    public static void main(String[] args) {
        SpringApplication.run(KddJApplication.class, args);
    }

}
