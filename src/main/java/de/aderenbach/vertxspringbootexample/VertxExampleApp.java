package de.aderenbach.vertxspringbootexample;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * Created by aderenbach on 28.06.15.
 */
@SpringBootApplication
@Import(VertxConfig.class)
public class VertxExampleApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(VertxExampleApp.class).run(args);
    }

}
