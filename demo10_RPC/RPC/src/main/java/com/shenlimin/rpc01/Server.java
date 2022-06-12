package com.shenlimin.rpc01;

import com.shenlimin.common.IUserService;
import com.shenlimin.common.User;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        while (true) {
            Socket socket = serverSocket.accept();
            process(socket);
            socket.close();
        }
    }

    private static void process(Socket socket) throws Exception {
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        int id = dis.readInt();
        IUserService service = new UserServiceImpl();
        User user = service.findUserById(id);

        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeInt(user.getId());
        dos.writeUTF(user.getName());
        dos.flush();
    }

}
