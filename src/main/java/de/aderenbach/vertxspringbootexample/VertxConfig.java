package de.aderenbach.vertxspringbootexample;

import de.aderenbach.vertxspringbootexample.model.User;
import io.vertx.core.Vertx;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by aderenbach on 29.06.15.
 */
@Configuration
public class VertxConfig {

    @Bean
    public Vertx createVertex() {
        Vertx vertx = Vertx.vertx();
        vertx.eventBus().registerDefaultCodec(User.class, new UserMessageCodec());
        return vertx;
    }

}
