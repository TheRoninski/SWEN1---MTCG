package at.ron.httpserver.server;

public interface Service {
    Response handleRequest(Request request);
}
