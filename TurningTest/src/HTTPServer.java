// jetty server

import org.eclipse.jetty.server.Server;

public class HTTPServer {
    public static void main(String[] args) {
        Server server = new Server(8080);
        server.setHandler(new HTTPHandler());
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}