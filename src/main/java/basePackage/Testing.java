package basePackage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "basePackage")
public class Testing {
    public static void main(String[] args) {
        SpringApplication.run(
                Testing.class, args);
    }
}
