package at.ron.sampleapp.service.weather;

import at.ron.httpserver.http.ContentType;
import at.ron.httpserver.http.HttpStatus;
import at.ron.httpserver.http.Method;
import at.ron.httpserver.server.Request;
import at.ron.httpserver.server.Response;
import at.ron.httpserver.server.Service;

public class WeatherService implements Service {
    private final WeatherController weatherController;

    public WeatherService() {
        this.weatherController = new WeatherController();
    }

    @Override
    public Response handleRequest(Request request) {
        if (request.getMethod() == Method.GET &&
            request.getPathParts().size() > 1) {
            return this.weatherController.getWeather(request.getPathParts().get(1));
        } else if (request.getMethod() == Method.GET) {
            return this.weatherController.getWeatherPerRepository();
            //return this.weatherController.getWeatherPerRepository();
        } else if (request.getMethod() == Method.POST) {
            return this.weatherController.addWeather(request);
        }

        return new Response(
                HttpStatus.BAD_REQUEST,
                ContentType.JSON,
                "[]"
        );
    }
}
