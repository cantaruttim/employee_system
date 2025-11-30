package br.com.cantarutti.config.openapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.yaml.snakeyaml.Yaml;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Configuration
public class SwaggerExternalConfig {

    @Bean
    public OpenAPI openAPI() throws IOException {
        Yaml yaml = new Yaml();
        InputStream IS = this.getClass()
                .getClassLoader()
                .getResourceAsStream("openapi/openapi.yml");

        Map<String, Object> yamlMap = yaml.load(IS);
        String json = new ObjectMapper().writeValueAsString(yamlMap);

        return new ObjectMapper().readValue(json, OpenAPI.class);

    }
}
