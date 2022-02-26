package gobang;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;


public class playerThread extends Thread {
	InetAddress  ip;
	private ServerSocket chatServerSocket;
	
	Thread playerThread;
	
	public playerThread(InetAddress ipAddress,mymain3 mymain) throws IOException {
		super();
		this.ip=ipAddress;
		playerThread=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					mymain.socket=new Socket(ip,9527);
					mymain.socket2=new Socket(ip,9527);
					
					mymain.messageOutputStream=new ObjectOutputStream(mymain.socket.getOutputStream());
					mymain.messageInputStream=new ObjectInputStream(mymain.socket.getInputStream());
					mymain.takemessageOutputStream=new ObjectOutputStream(mymain.socket2.getOutputStream());
					mymain.takemessageInputStream=new ObjectInputStream(mymain.socket2.getInputStream());
					System.out.println("流创建成功");
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	
	}

	


	
	

}
