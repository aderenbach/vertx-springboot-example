package de.aderenbach.vertxspringbootexample;

import de.aderenbach.vertxspringbootexample.model.User;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Verticle;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by kinggrass on 29.06.15.
 */
@Component
@Profile("user2")
public class User2LoadVerticle extends AbstractVerticle implements Verticle {

    @Override
    public void start() throws Exception {

        vertx.eventBus().consumer("user",m -> {
            User r = new User(UUID.randomUUID().toString(),"User 2");
            m.reply(r);
        });

    }

}
