import org.eclipse.jetty.server.handler.AbstractHandler;

public class HTTPHandler extends AbstractHandler {
    @Override
    public void handle(String target, org.eclipse.jetty.server.Request baseRequest, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.io.IOException, javax.servlet.ServletException {
        // make sure it's a post request

        if (!request.getMethod().equals("POST")) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(javax.servlet.http.HttpServletResponse.SC_OK);
            baseRequest.setHandled(true);
            response.getWriter().println("Wrong request method");
            return;
        }

        String from = request.getParameter("From");
        String body = request.getParameter("Body");
        System.out.println("From: " + from);
        System.out.println("Body: " + body);

        response.setContentType("text/html;charset=utf-8");
        response.setStatus(javax.servlet.http.HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);
        String msg = OpenAI.chatGPT(body);
        System.out.println("Response: " + msg);
        SMSSender.sendSMS(msg, from);
    }

}
