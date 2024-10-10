package at.ron.mtcg.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Controller {
    private ObjectMapper mapper = new ObjectMapper();
    public Controller() {}
    public ObjectMapper getMapper(){
        return mapper;
    };
}
