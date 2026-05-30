package com.gabkings.learning_portal.configurations;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                .title("GabKings Learning Portal")
                        .description("These are API's for managing resources for GabKings Learning Portal")
                        .summary("GabKings Learning Portal API's")
                        .version("v1"))
                .addSecurityItem(
                        new SecurityRequirement().addList("bearerAuth"))
                .components(
                        new Components()
                                .addSecuritySchemes("bearerAuth", new SecurityScheme().bearerFormat("JWT")
                                        .scheme("bearer")
                                        .type(SecurityScheme.Type.HTTP)));

    }
}
