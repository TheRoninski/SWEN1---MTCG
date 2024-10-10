
public class SessionService implements Service {
    private SessionController controller = new SessionController();

    public SessionService() {

    }

    @Override
    public Response handleRequest(Request request) {
        if (request.getMethod() == Method.POST) {
            return controller.login(request);
        }
        return new Response(HttpStatus.BAD_REQUEST, ContentType.PLAIN_TEXT, "");
    }
}