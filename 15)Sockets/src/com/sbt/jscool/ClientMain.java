package com.sbt.jscool;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientMain {

    //private static Socket clientSocket; //сокет для общения
    //private static BufferedReader reader; // нам нужен ридер читающий с консоли, иначе как
    // мы узнаем что хочет сказать клиент?
    //private static BufferedReader in; // поток чтения из сокета
    //private static BufferedWriter out; // поток записи в сокет

    public static void main(String[] args) throws IOException {
        try {
            Socket socket1 = new Socket("localhost", 4004);

            System.out.println("Сокет клиента создан.");

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket1.getOutputStream()));

            while (true) {
                System.out.println("Жду запроса");
                String inMes = in.readLine();
                System.out.println(inMes);
                String mes = reader.readLine();
                out.write(mes);
                out.flush();

            }

           // reader = new BufferedReader(new InputStreamReader(System.in));
            // читать соообщения с сервера
            //in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // писать туда же
            //out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            //System.out.println("Вы что-то хотели сказать? Введите это здесь:");

            //String word = reader.readLine();

            //out.write(word + "\n"); // отправляем сообщение на сервер
            //out.flush();
            //String serverWord = in.readLine(); // ждём, что скажет сервер
            //System.out.println(serverWord); // получив - выводим на экран
        } finally { // в любом случае необходимо закрыть сокет и потоки
            System.out.println("Клиент был закрыт...");
           // clientSocket.close();
            //in.close();
            //out.close();
        }
    }
}
