package com.ortaklar;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6666);
            Socket socket=serverSocket.accept();//establishes connection

            DataInputStream dis=new DataInputStream(socket.getInputStream());
            int counter = 0;
            boolean inStream = true;
            while (inStream){
                counter++;
                String  str=(String)dis.readUTF();
                System.out.println("message= "+str);
                if (counter >199)
                {
                    inStream = false;
                }
            }

            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
