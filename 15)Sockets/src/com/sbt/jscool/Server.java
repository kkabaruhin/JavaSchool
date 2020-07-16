package com.sbt.jscool;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.TreeMap;

public class Server {

    public static final int PORT = 4004;
    public static TreeMap<String, Client> serverList = new TreeMap<>(); // список всех клиентов-потоков

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Сервер запущен");
        try {
            while (true) {
                // Блокируется до возникновения нового соединения:
                Socket socket = server.accept();
                try {

                    System.out.println("Новое соединение.");
                    String newLogin;

                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    out.write("Вы успешно подключились к серверу. Введите логин:");
                    out.flush();
                    System.out.println("Отправил сообщение и вытолкнул.");
                    while (true) {
                        newLogin =  in.readLine();
                        if (!Server.serverList.containsKey(newLogin)) {
                            out.write("Вы зашли в чат под логином: " + newLogin + "\n");
                            out.flush();
                            break;
                        }

                        out.write("Пользователь с таким логином уже подключен. Введите другой логин:");
                    }
                    serverList.put(newLogin, new Client(socket, newLogin)); // добавить новое соединенние в список
                } catch (IOException e) {
                    // Если завершится неудачей, закрывается сокет,
                    // в противном случае, нить закроет его при завершении работы:
                    socket.close();
                }
            }
        } finally {
            server.close();
        }
    }
}