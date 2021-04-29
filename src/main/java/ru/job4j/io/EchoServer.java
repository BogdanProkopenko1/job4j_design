package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9500)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    while (!(str = in.readLine()).isEmpty()) {
                        System.out.println(str);
                        if (str.startsWith("GET /?")) {
                            String[] arguments = str.split("[= ]");
                            if (arguments[2].equals("Exist")) {
                                out.write("Server close.".getBytes());
                                socket.close();
                                server.close();
                            } else if (arguments[2].equals("Hello")) {
                                out.write("HTTP/1.1 200 HELLO\r\n".getBytes());
                            } else {
                                out.write("HTTP/1.1 200 WHAT\r\n".getBytes());
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("SERVER exception", e);
        }
    }
}