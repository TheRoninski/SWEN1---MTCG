package at.ron;

import at.ron.mtcg.service.UserService;
import at.ron.mtcg.service.SessionService;
import at.ron.httpserver.server.Server;
import at.ron.httpserver.utils.Router;
import at.ron.sampleapp.service.echo.EchoService;
import at.ron.sampleapp.service.weather.WeatherService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Server server = new Server(10001, configureRouter());
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Router configureRouter()
    {
        Router router = new Router();
        router.addService("/users", new UserService());
        router.addService("/sessions", new SessionService());

        return router;
    }
}
