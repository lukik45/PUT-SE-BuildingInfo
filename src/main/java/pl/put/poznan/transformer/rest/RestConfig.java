package pl.put.poznan.transformer.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Representation of a REST config allowing cross origin requests to connect
 * with GUI on locally served API
 * 
 * @since 0.2
 */
@Configuration
public class RestConfig {
    /**
     * Default cross origin configuration method. It allows user to use OPTIONS,
     * GET, POST, PUT and DELETE methods on any orogin with any header
     * 
     * @since 0.2
     * @return A CorsFilter containing defined config.
     */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}