package com.mycompany.jsonvalidator;

import com.sun.net.httpserver.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class Server {

    private HttpServer httpServer;
    private int requestID;
    
    /**
     * Converts inputStream object to String object
     * 
     * @param inputStream inputStream object to be converted to String object
     * @return resulting String object
     */
    
    static String InputStreamToString(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
        String result = scanner.hasNext() ? scanner.next() : "";
        return result;
    }
    
    /**
     * Returns string containing filename from uri
     * 
     * @param uri full path containing filename
     * @return filename
     */
    
    static String GetFileNameFromURI(String uri) {
        int getBeginningFrom = uri.lastIndexOf('/') + 1;
        return uri.substring(getBeginningFrom);
    }
    
    /**
     * Starts the HTTP server
     * 
     * @throws IOException 
     */

    public void run() throws IOException {
        httpServer = HttpServer.create(new InetSocketAddress(80), 0);
        httpServer.createContext("/", new PostHandler());
        httpServer.start();
        requestID = 0;
    }
    
    /**
     * Subclass providing request handler
     */

    class PostHandler implements HttpHandler {
        
        /**
         * Request handler
         * 
         * @param exchange current http exchange
         * @throws IOException 
         */

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            InputStream isRequestBody = exchange.getRequestBody();
            String jsonString = InputStreamToString(isRequestBody);
            String filename = GetFileNameFromURI(exchange.getRequestURI().getPath());
            
            jsonString = Validator.validate(jsonString, filename, requestID++);
            exchange.sendResponseHeaders(200, jsonString.length());
            OutputStream os = exchange.getResponseBody();
            os.write(jsonString.getBytes());
            os.close();
        }
    }
}
