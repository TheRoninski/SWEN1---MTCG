package at.ron.mtcg.controller;

import at.ron.httpserver.http.ContentType;
import at.ron.httpserver.http.HttpStatus;
import at.ron.httpserver.server.Response;
import at.ron.httpserver.server.Request;
import at.ron.mtcg.dal.UserRepository;
import at.ron.mtcg.model.UserCredentials;
import at.ron.mtcg.model.Users;
import com.fasterxml.jackson.core.JsonProcessingException;


public class SessionController extends Controller {
    public SessionController() {

    }

    public Response login(Request request) {
        UserCredentials credentials;
        try {
            credentials = getMapper().readValue(request.getBody(), UserCredentials.class);
        } catch (JsonProcessingException e) {
            return new Response(HttpStatus.BAD_REQUEST, ContentType.PLAIN_TEXT, "");
        }

        Users user = UserRepository.getInstance().getUser(credentials.getUsername());
        if (user.getUsername() == credentials.getUsername() && user.getPassword() == credentials.getPassword()) {
            String token = user.getUsername() + "-mtcgToken";

            user.setToken(token);
            UserRepository.getInstance().updateUser(user);

            return new Response(HttpStatus.OK, ContentType.PLAIN_TEXT, "");
        }
        return new Response(HttpStatus.UNAUTHORIZED, ContentType.PLAIN_TEXT, "");
    }
}