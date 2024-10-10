package at.ron.mtcg.controller;

import at.ron.httpserver.http.ContentType;
import at.ron.httpserver.http.HttpStatus;
import at.ron.httpserver.server.Response;
import at.ron.mtcg.dal.UserRepository;
import at.ron.mtcg.model.UserCredentials;
import at.ron.mtcg.model.Users;
import com.fasterxml.jackson.core.JsonProcessingException;

public class UserController extends Controller {
    public UserController() {}
    public Response registerUser(Request request) {
        UserCredentials credentials;
        try{
            credentials = getMapper().readValue(request.getBody(), UserCredentials.class);
        }
        catch(JsonProcessingException e){
            return new Response(HttpStatus.BAD_REQUEST, ContentType.PLAIN_TEXT, "");
        }
        Users users = new Users(credentials);
        if (UserRepository.getInstance().register(users) == false) {
            return new Response(HttpStatus.CONFLICT, ContentType.PLAIN_TEXT, "");
        }
        return new Response(HttpStatus.CREATED, ContentType.PLAIN_TEXT, "");
    }

}
