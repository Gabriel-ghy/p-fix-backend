package pioneer.pfix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class PFixApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(PFixApplication.class, args);
    }
}
