package de.aderenbach.vertxspringbootexample;

import de.aderenbach.vertxspringbootexample.model.User;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Verticle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by kinggrass on 29.06.15.
 */
@Component
public class User1LoadVerticle extends AbstractVerticle implements Verticle {

    @Value("${user1.name}")
    private String username;

    @Override
    public void start() throws Exception {

        vertx.eventBus().consumer("user",m -> {
            User r = new User(UUID.randomUUID().toString(),username);
            m.reply(r);
        });

    }

}
