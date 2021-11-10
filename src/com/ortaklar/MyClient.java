package com.ortaklar;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class MyClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 6666);
            DataOutputStream dout=new DataOutputStream(socket.getOutputStream());
            for (int i = 0; i < 200; i++) {
                dout.writeUTF("Hello Server: "+i);
            }
            dout.close();
            socket.close();
        } catch (IOException  e) {
            e.printStackTrace();
        }
    }
}
