package webSocketTests.client;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

@WebSocket
public class ToUpperClientSocket {

    private Session session;

    CountDownLatch latch= new CountDownLatch(1);

    @OnWebSocketMessage
    public void onText(Session session, String message) throws IOException {
        System.out.println("Message received from server:" + message);
    }

    @OnWebSocketConnect
    public void onSLF4JConnect(Session session) {
        System.out.println("Connected to server");
        this.session=session;
        latch.countDown();
    }

    public void sendMessage(String str) {
        try {
            session.getRemote().sendString(str);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}