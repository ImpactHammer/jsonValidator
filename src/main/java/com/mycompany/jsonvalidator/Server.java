package com.mycompany.jsonvalidator;

import com.sun.net.httpserver.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class Server {

    private HttpServer httpServer;
    
    static String InputStreamToString(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
        String result = scanner.hasNext() ? scanner.next() : "";
        return result;
    }

    public void run() throws IOException {
        httpServer = HttpServer.create(new InetSocketAddress(80), 0);
        httpServer.createContext("/", new PostHandler());
        httpServer.start();
    }

    static class PostHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            InputStream isRequestBody = exchange.getRequestBody();
            String jsonString = InputStreamToString(isRequestBody);
            jsonString = Validator.validate(jsonString);
            exchange.sendResponseHeaders(200, jsonString.length());
            OutputStream os = exchange.getResponseBody();
            os.write(jsonString.getBytes());
            os.close();
        }
    }
}
