package homifyBackend.homifyBackendService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "homifyBackend.homifyBackendService" })
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}