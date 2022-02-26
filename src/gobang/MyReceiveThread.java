package gobang;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;

public class MyReceiveThread extends Thread {
    private ServerSocket chatSocketServer;

    InetAddress ip;
    InetAddress ipAddress = null;
    Thread serverThread;


    public MyReceiveThread(mymain3 mymain) {
        serverThread = new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub

                try {
                    chatSocketServer = new ServerSocket(9527);
                    ipAddress = chatSocketServer.getInetAddress();
                    System.out.println("服务器创立成功");
                    mymain.socket = chatSocketServer.accept();
                    mymain.socket2 = chatSocketServer.accept();
                    if (mymain.socket.isConnected()) System.out.println("连接成功");
                    ip = mymain.socket.getLocalAddress();
                    System.out.println("房间号为" + ip.toString());

                    mymain.messageOutputStream = new ObjectOutputStream(mymain.socket.getOutputStream());
                    mymain.messageInputStream = new ObjectInputStream(mymain.socket.getInputStream());
                    mymain.takemessageOutputStream = new ObjectOutputStream(mymain.socket2.getOutputStream());
                    mymain.takemessageInputStream = new ObjectInputStream(mymain.socket2.getInputStream());
                    System.out.println("流创建成功");


                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

    }
}
	
	
	

