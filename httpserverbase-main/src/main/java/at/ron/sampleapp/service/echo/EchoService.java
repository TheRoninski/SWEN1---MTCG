package at.ron.sampleapp.service.echo;

import at.ron.httpserver.http.ContentType;
import at.ron.httpserver.http.HttpStatus;
import at.ron.httpserver.server.Request;
import at.ron.httpserver.server.Response;
import at.ron.httpserver.server.Service;

public class EchoService implements Service {
    @Override
    public Response handleRequest(Request request) {
        return new Response(HttpStatus.OK,
                            ContentType.PLAIN_TEXT,
                     "Echo-" + request.getBody());
    }
}
