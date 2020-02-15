package nl.han.dea.http;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.time.format.DateTimeFormatter;

public class ConnectionHandler implements Runnable {
    private String statusCode;
    private String contentLength;
    private final String HTTP_HEADER = "HTTP/1.1 " + "200" + " OK\n" +
            DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss O") + " \n" +
            "HttpServer: Simple DEA Webserver\n" +
            "Content-Length: " + contentLength + "\n" +
            "Content-Type: text/html\n";
    private Socket socket;


    public ConnectionHandler(Socket socket) {
        this.socket = socket;
    }

    public void handle() throws ResourceNotAvailableException {
        try {
            var inputStreamReader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream(), StandardCharsets.US_ASCII));
            var outputStreamWriter = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.US_ASCII));


            var startLine = parseRequest(inputStreamReader);

            if (startLine == null) {
                return;
            }

            String request = startLine.split(" ")[1];


            writeResponse(outputStreamWriter, request);

        } catch (IOException | ResourceNotAvailableException e) {
            setStatusCode("404 NOT FOUND");
        }
    }

    private String parseRequest(BufferedReader inputStreamReader) throws IOException {
        var request = inputStreamReader.readLine();
        String startLine = request;

        while (request != null && !request.isEmpty()) {
            System.out.println(request);
            request = inputStreamReader.readLine();
        }

        return startLine;
    }

    private void writeResponse(BufferedWriter outputStreamWriter, String request) throws ResourceNotAvailableException {
        var pageReader = new HtmlPageReader(request);


        setContentLength(pageReader.getLength());
        setStatusCode("200 OK");

        try {
            outputStreamWriter.write(HTTP_HEADER);
            outputStreamWriter.newLine();
            outputStreamWriter.write(pageReader.readFile());
            outputStreamWriter.newLine();
            outputStreamWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void run() {
        try {
            handle();
        } catch (ResourceNotAvailableException e) {

        }

    }

    public void setContentLength(String contentLength) {
        this.contentLength = contentLength;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
