package tn.tekup.tekbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TekbookApplication {

    public static void main(String[] args) {
        SpringApplication.run(TekbookApplication.class, args);
    }

    @GetMapping("/")
    public String home() {
        return "OK";
    }
}
