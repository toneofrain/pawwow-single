package dev.saintho.pawwow.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"dev.saintho.pawwow.repository.jpa"})
@EnableJpaAuditing
@Configuration
public class JpaConfig {
}
