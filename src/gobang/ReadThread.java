package gobang;

import java.io.IOException;
import java.net.Socket;

public class ReadThread extends Thread {
	Thread readtThread;
	Thread readtThread2;
	public ReadThread(mymain3 mymain3) {
		readtThread=new Thread(new Runnable() {
			
			@Override
		
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("读取线程已经启动");
			while(true) {
			
				try {
					message message=null;
					if((message=(message)mymain3.messageInputStream.readObject())!=null) {
						System.out.println("读取到一条信息");
					mymain3.message=message;
					mymain3.chess=message.getChess();
					mymain3.repaint();
					mymain3.endTimer.cancel();
					mymain3.endtime();
					System.out.println("棋盘已经刷新");
					}
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			}
		});
		readtThread2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("读取线程已经启动");
				while(true) {
				
					try {
						mymain3.talkmessage=(talkmessage)mymain3.takemessageInputStream.readObject();
						if(mymain3.talkmessage.getTalkArrayList().size()!=0) {
							mymain3.talkArea.append("\n");
							mymain3.talkArea.append(mymain3.talkmessage.getName()+mymain3.talkmessage.getTalkArrayList().get(mymain3.talkmessage.getTalkArrayList().size()-1));
						}
						}
					 catch (ClassNotFoundException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		});
	}
}
