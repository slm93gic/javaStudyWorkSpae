package com.shenlimin.rpc01;

import com.shenlimin.common.User;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 8888);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeInt(123);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(baos.toByteArray());
        outputStream.flush();

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        int i = dis.readInt();
        String name = dis.readUTF();
        User user = new User(i, name);
        System.out.println(user);

    }

}
