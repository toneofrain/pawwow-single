package dev.saintho.pawwow.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"dev.saintho.pawwow.infrastructure.repository.jpa"})
@EnableJpaAuditing
@Configuration
public class JpaConfig {
}
