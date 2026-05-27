package se.iths.ellinor.emailmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"se.iths.ellinor.emailmicroservice", "se.iths.johan.springmessenger"})
public class EmailMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailMicroserviceApplication.class, args);
    }

}
