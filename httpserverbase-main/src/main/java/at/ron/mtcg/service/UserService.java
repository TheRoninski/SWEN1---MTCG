package at.ron.mtcg.service;
import at.ron.httpserver.http.ContentType;
import at.ron.httpserver.http.HttpStatus;
import at.ron.httpserver.http.Method;
import at.ron.httpserver.server.Request;
import at.ron.httpserver.server.Response;
import at.ron.httpserver.server.Service;
import at.ron.mtcg.controller.UserController;

public class UserService implements Service {
    private UserController controller;
    public UserService() {}

    @Override
    public Response handleRequest(Request request) {
        if (request.getMethod() == Method.POST) {
            return controller.registerUser(request);
        }
        return new Response(HttpStatus.BAD_REQUEST, ContentType.PLAIN_TEXT, "");
    };
}
