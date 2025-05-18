
ackage com.personal.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.personal.manager")
public class PersonalManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonalManagerApplication.class, args);
    }
} 