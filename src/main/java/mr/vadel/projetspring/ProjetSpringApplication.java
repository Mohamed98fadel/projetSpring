package mr.vadel.projetspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"models"})  // scan JPA entities
public class ProjetSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetSpringApplication.class, args);
    }

}
