package dev.saintho.pawwow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan(basePackages = {"dev.saintho.pawwow.config"})
public class PawwowApplication {

    public static void main(String[] args) {
        SpringApplication.run(PawwowApplication.class, args);
    }

}
