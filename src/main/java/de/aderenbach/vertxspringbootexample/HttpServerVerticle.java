package de.aderenbach.vertxspringbootexample;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import org.springframework.stereotype.Component;

/**
 * Created by kinggrass on 01.07.15.
 */
@Component
public class HttpServerVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {

        HttpServer httpServer = vertx.createHttpServer();

        Router router = Router.router(vertx);

        router.route().produces("application/json").handler(routingContext -> {
            final HttpServerResponse response = routingContext.response();
            response.putHeader("content-type", "text/plain");
            vertx.eventBus().send("user", "hello", reply -> response.end(Json.encode(reply.result().body())));

        });

        httpServer.requestHandler(router::accept).listen(8111);

    }
}
