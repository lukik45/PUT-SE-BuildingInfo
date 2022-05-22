package pl.put.poznan.transformer.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "pl.put.poznan.transformer.rest" })
public class TextTransformerApplication {

    public static final Logger logger = LoggerFactory.getLogger(TextTransformerApplication.class);

    public static void main(String[] args) {
        logger.info("Starting SpringApplication");
        SpringApplication.run(TextTransformerApplication.class, args);
        logger.info("SpringApplication is running");
    }
}