package uz.pdp.clickuzautopayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ClickUzAutopaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClickUzAutopaymentApplication.class, args);
    }

}
