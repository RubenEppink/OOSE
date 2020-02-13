package nl.han.dea.http;

import java.io.IOException;
import java.net.ServerSocket;

public class HttpServer {

    private int tcpPort;

    public HttpServer(int tcpPort) {
        this.tcpPort = tcpPort;
    }

    public static void main(String[] args) {
        new HttpServer(8383).startServer();
    }

    public void startServer() {
        try (
                var serverSocket = new ServerSocket(this.tcpPort);
        ) {
            System.out.println("Server accepting requests on port " + tcpPort);

            new ConnectionHandler(serverSocket.accept()).handle();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
