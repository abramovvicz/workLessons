package webSocketTests.server;

import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns="/toUpper")
public class ToUpperWebSocketServlet  extends WebSocketServlet {

    @Override
    public void configure(WebSocketServletFactory factory) {

        factory.register(ToUpperWebSocket.class);

    }

}
