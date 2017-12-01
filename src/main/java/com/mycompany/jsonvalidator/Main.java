package com.mycompany.jsonvalidator;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.run();
        System.out.println("Server is running");
    }
}
