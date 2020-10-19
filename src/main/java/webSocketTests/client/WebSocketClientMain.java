package webSocketTests.client;

import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;

import java.net.URI;

public class WebSocketClientMain {

    public static void main(String[] args) {
        String dest = "ws://localhost:7070/jsr356toUpper";
        WebSocketClient client = new WebSocketClient();
        try {

            ToUpperClientSocket socket = new ToUpperClientSocket();
            client.start();
            URI echoUri = new URI(dest);
            ClientUpgradeRequest request = new ClientUpgradeRequest();
            client.connect(socket, echoUri, request);
            socket.getLatch().await();
            socket.sendMessage("echo");
            socket.sendMessage("test");
            Thread.sleep(10000l);

        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            try {
                client.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}