package pioneer.pfix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class PFixApplication {

    public static void main(String[] args) {
        SpringApplication.run(PFixApplication.class, args);
    }

}
