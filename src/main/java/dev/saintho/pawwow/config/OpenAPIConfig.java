package dev.saintho.pawwow.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Pawwow Rest API Documentation",
                description = "강아지 인기투표 서비스 Pawwow API 명세",
                version = "v1.0"
        )
)
@Configuration
public class OpenAPIConfig {
    private final String version = "v1";
    private final String[] paths = {String.format("/api/%s/**", version)};

    @Bean
    public GroupedOpenApi openApi() {
        return GroupedOpenApi.builder()
                .group("v1")
                .pathsToMatch(paths)
                .build();
    }
}
