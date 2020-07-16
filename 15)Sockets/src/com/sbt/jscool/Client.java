package com.sbt.jscool;

import java.io.*;
import java.net.Socket;
import java.util.Map;
import java.util.TreeMap;

public class Client extends Thread {

    private  Socket socket; //сокет для общения
    private  BufferedReader reader; // нам нужен ридер читающий с консоли, иначе как
    // мы узнаем что хочет сказать клиент?
    private  BufferedReader in; // поток чтения из сокета
    private  BufferedWriter out; // поток записи в сокет
    private TreeMap<String, String> history;

    public String login;

    public Client(Socket socket, String login) throws IOException {
        this.socket = socket;
        this.login = login;

        history = new TreeMap<>();
        // если потоку ввода/вывода приведут к генерированию исключения, оно проброситься дальше
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        run(); // вызываем run()
    }

    @Override
    public void run() {
        String message;
        try {

            while (true) {
                message = in.readLine();
                if (message.equals("stop")) {
                    break;
                }
                String[] splited = message.split(" ");
                String recipientLogin = splited[0];

                if (recipientLogin == "messages") {
                    for (Map.Entry<String, String> m: this.history.entrySet()
                         ) {
                        String fromLogin = m.getKey();
                        String mes = m.getValue();
                        System.out.format("%s said: %s", fromLogin, mes);
                        System.out.println();
                    }
                }
                else {
                    if (Server.serverList.containsKey(recipientLogin)) {
                        Client recipient = Server.serverList.get(recipientLogin);
                        recipient.send(splited.toString());
                    }
                    else {
                        out.write("Пользователя с таким логином не существует. \n");
                        out.flush();
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void send(String message) {
        try {
            out.write(message + "\n");
            out.flush();
        } catch (IOException ignored) {}
    }
}
