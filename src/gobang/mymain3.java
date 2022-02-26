package gobang;

import javazoom.jl.decoder.JavaLayerException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;




public class mymain3 extends JFrame{
	MyMouseListener3 mml = new MyMouseListener3(this);
	protected chess[][] chess = new chess[15][15];
	JLabel label1=new JLabel();//黑方落棋
	JLabel label2=new JLabel();//白方落棋
	JButton restartButton=new JButton("再来一局");
	ArrayList<chess> list=new ArrayList<>();
	Graphics graphics;
	int count=0;
	JButton endButton=new JButton("和棋");
	JComboBox backgroundBox=new JComboBox(new MycomboBox());
	JLabel label3=new JLabel("更换背景");
	JButton okButton=new JButton("ok");
	int isdraw=0;
	Timer endTimer;
	TextField  endtimeArea;
	JLabel endtimeJLabel ;
	long nowtime;
	long endtime;
	JLabel blackscoreJLabel;
	JLabel whitescoreJLabel;
	JTextField blackscoreField;
	JTextField whitescoreField;
	int blackscore=0;
	int whitescore=0;
	int backcount=0;
	Socket socket=null;
	 ObjectInputStream messageInputStream;
	ObjectOutputStream messageOutputStream;
	Socket socket2=null;
	ObjectOutputStream takemessageOutputStream;
	ObjectInputStream takemessageInputStream;
	talkmessage talkmessage=new talkmessage();
	message message=new message();
	TextArea talkArea;
	TextField talkField;
	JButton talkButton;
	JButton exitButton;
	audioplay audioplay;
	JLabel backgroundJLabel;
	JLabel nowplayingJLabel;
	File music;
	List<String> musics=new ArrayList<String>();
	int playing=0;
	int isplay=-1;
	JButton stopOrstartButton;
	JButton nextButton;
	JButton prevButton;
	musicPlay musicplayer;
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIsblack() {
		return isblack;
	}

	public void setIsblack(int isblack) {
		this.isblack = isblack;
	}
	private  int isblack=0;//游戏发起端
	//***************************************************************************************
		public void UI() throws IOException {
			music=new File("music");
			for(File file:music.listFiles()){
				musics.add(file.getName());
			}
			for(int i=0;i<15;i++) {
				for(int j=0;j<15;j++) {
					chess[i][j]=new chess(i, j);
				}
			}
			message.setChess(chess);
			
		this.setTitle("五子棋");
		this.setSize(1000,1000);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);
		Container container=this.getContentPane();
		container.setBackground(new Color(240, 233, 217));
		container.setLayout(null);
		this.setVisible(true);
		
		
		
		backgroundBox .setBounds(870, 5, 50, 20);
		backgroundBox.setMaximumRowCount(3);
		container.add(backgroundBox);
		
		
		okButton.setBounds(925, 5, 50, 20);
		okButton.setVisible(true);
		container.add(okButton);
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String selectString=(String )backgroundBox.getSelectedItem();
				backgroundJLabel.setIcon(new ImageIcon("background/"+selectString));
				repaint();
			}
		});
		
		endtimeJLabel =new JLabel("倒计时：");
		endtimeJLabel .setBounds(800,120,100,80);
		endtimeJLabel .setFont(new Font("宋体", Font.PLAIN, 20));
		container.add(endtimeJLabel);
		
		endtimeArea=new TextField();
		endtimeArea.setBounds(900,120,100,80);
		endtimeArea.setFont(new Font("宋体", Font.PLAIN, 60));
		endtimeArea.setForeground(Color.red);
		endtimeArea.setBackground(new Color(240, 233, 217));
		endtimeArea.setEditable(false);
		container .add(endtimeArea);
		
				
		blackscoreJLabel=new JLabel("黑方得分：");
		blackscoreJLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		blackscoreJLabel.setBounds(800,220,80,50);
		container.add(blackscoreJLabel);
		
		whitescoreJLabel=new JLabel("白方得分：");
		whitescoreJLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		whitescoreJLabel.setBounds(800,290,80,50);
		container.add(whitescoreJLabel);
		
		blackscoreField=new JTextField();
		blackscoreField.setFont(new Font("宋体", Font.PLAIN, 15));
		blackscoreField.setBounds(880, 235, 20, 20);
		blackscoreField.setText(""+blackscore);
		blackscoreField.setBackground(container.getBackground());
		container.add(blackscoreField);
		
		whitescoreField=new JTextField();
		whitescoreField.setFont(new Font("宋体", Font.PLAIN, 15));
		whitescoreField.setBounds(880, 305,20 , 20);
		whitescoreField.setText(""+whitescore);
		whitescoreField.setBackground(container.getBackground());
		container.add(whitescoreField);
		
		nowplayingJLabel=new JLabel();
		nowplayingJLabel.setText(musics.get(playing));
		nowplayingJLabel.setBounds(425,725,300,30);
		container.add(nowplayingJLabel);
		
		stopOrstartButton=new JButton();
		stopOrstartButton.setIcon(new ImageIcon("播放.png"));
		stopOrstartButton.setBounds(425,750,50,50);
		stopOrstartButton.setContentAreaFilled(false);
		container.add(stopOrstartButton);
		stopOrstartButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				isplay=-isplay;
				if(isplay==1) {stopOrstartButton.setIcon(new ImageIcon("暂停.png"));try {
					musicplayer=new musicPlay("music/"+musics.get(playing));musicplayer.musicThread.start();
				} catch (FileNotFoundException | JavaLayerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}
				else {stopOrstartButton.setIcon(new ImageIcon("播放.png"));try {
					musicplayer.musicThread.sleep(1);musicplayer.player.close();;musicplayer.musicThread=null;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}}
			}
		});
		
		nextButton=new JButton();
		nextButton.setIcon(new ImageIcon("下一曲.png"));
		nextButton.setBounds(500,750,50,50);
		nextButton.setContentAreaFilled(false);
		container.add(nextButton);
		nextButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				stopOrstartButton.setIcon(new ImageIcon("暂停.png"));
				isplay=1;
				try {
					musicplayer.musicThread.sleep(1);
					musicplayer.player.close();
					musicplayer.musicThread=null;
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(playing<(musics.size()-1)) {
					playing++;
					try {
						musicplayer=new musicPlay("music/"+musics.get(playing));
						musicplayer.musicThread.start();
						nowplayingJLabel.setText(musics.get(playing));
					} catch (FileNotFoundException | JavaLayerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					playing=0;
					try {
						musicplayer=new musicPlay("music/"+musics.get(playing));
						musicplayer.musicThread.start();
						nowplayingJLabel.setText(musics.get(playing));
					} catch (FileNotFoundException | JavaLayerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		prevButton=new JButton();
		prevButton.setIcon(new ImageIcon("上一曲.png"));
		prevButton.setBounds(350,750,50,50);
		prevButton.setContentAreaFilled(false);
		container.add(prevButton);
		prevButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				stopOrstartButton.setIcon(new ImageIcon("暂停.png"));
				isplay=1;
				try {
					musicplayer.musicThread.sleep(1);
					musicplayer.player.close();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				musicplayer.musicThread=null;
				if(playing>0) {
					playing--;
					try {
						musicplayer=new musicPlay("music/"+musics.get(playing));
						musicplayer.musicThread.start();
						nowplayingJLabel.setText(musics.get(playing));
					} catch (FileNotFoundException | JavaLayerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					playing=(musics.size()-1);
					try {
						musicplayer=new musicPlay("music/"+musics.get(playing));
						musicplayer.musicThread.start();
						nowplayingJLabel.setText(musics.get(playing));
					} catch (FileNotFoundException | JavaLayerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		
		label1.setText("黑方落棋");
		label1.setBounds(800, 260, 80, 50);
		label1.setFont(new Font("宋体", Font.PLAIN, 20));
		container.add(label1);
		
		label2.setText("白方落棋");
		label2.setBounds(800, 260, 80, 50);
		label2.setFont(new Font("宋体", Font.PLAIN, 20));
		container.add(label2);
		
		talkArea=new  TextArea();
		talkArea.setBounds(800,320,200,200);
		talkArea.setEditable(false);
		container.add(talkArea);
		
		talkField=new TextField();
		talkField.setBounds(800,530,200,50);
		//talkField.setText("请在此处输入聊天内容");
		container.add(talkField);
		
		talkButton=new JButton();
		talkButton.setText("提交");
		talkButton.setFont(new Font("宋体", Font.PLAIN, 18));
		talkButton.setBounds(850,600,80,60);
		container.add(talkButton);
		talkButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			talkmessage.setTalkArrayList(talkField.getText());
			talkmessage.setName(getName());
			try {
				takemessageOutputStream.writeObject(talkmessage);
				messageOutputStream.flush();
				talkField.setText("");
				if(talkmessage.getTalkArrayList().size()!=0) {
					talkArea.append("\n");
					talkArea.append(getName()+talkmessage.getTalkArrayList().get(talkmessage.getTalkArrayList().size()-1));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
		});
		
		exitButton=new JButton();
		exitButton.setText("退出游戏");
		exitButton.setFont(new Font("宋体", Font.PLAIN, 18));
		exitButton.setBounds(850,680,80,60);
		container.add(exitButton);
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					messageInputStream.close();
					messageOutputStream.close();
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		//----------------------------------------------------------------------------
		backgroundJLabel=new JLabel();
		backgroundJLabel.setBounds(0,0,1000,1000);
		backgroundJLabel.setIcon(new ImageIcon("p1.png"));
		container.add(backgroundJLabel);
		
		audioplay=new audioplay();
	
		endtime();
		}
		//***************************************************************************
		
		public void paint(Graphics g) {
			super.paint(g);
			try {
				drawChessTable(g);
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public void drawChessTable(Graphics g) throws ClassNotFoundException, IOException {
			//判断是否轮到自己落棋
			System.out.println(getIsblack()+" "+message.getChessol());
			if(message.getChessol()==getIsblack()) {
				this.addMouseListener(mml);System.out.println("添加鼠标控件");
				
			}
			else {
				this.removeMouseListener(mml);System.out.println("移除鼠标控件");
			}
			//获取聊天记录
			/**if(message.getTalk().size()==0) {}
			else if(message.getTalk().get(message.getTalk().size()-1)!=null) {
				talkArea.append(message.getTalk().get(message.getTalk().size()-1));
			}**/
			//刷新标签
			if(message.getChessol()==-1) {label1.setVisible(true);label2.setVisible(false);}
			if(message.getChessol()==1) {label1.setVisible(false);label2.setVisible(true);}
			//判断棋盘是否满了;
			if(count==225) {JOptionPane.showMessageDialog(null, "游戏结束，该盘为平局");removeMouseListener(mml);}
		
					
				//绘制棋盘线条
				for(int i=0;i<15;i++) {
					g.drawLine(75, 50+i*50, 775, 50+(i)*50);
					g.drawLine(75+i*50, 50, 75+(i)*50, 750);
				}
				
				//绘制棋盘5个定位黑点
				for(int i=0;i<15;i++) {
					for(int j=0;j<15;j++) {
						if(i==3&&j==3) {g.setColor(Color.black);g.fillOval(chess[i][j].x-5, chess[i][j].y-5, 10, 10);}
						if(i==3&&j==11) {g.setColor(Color.black);g.fillOval(chess[i][j].x-5, chess[i][j].y-5, 10, 10);}
						if(i==7&&j==7) {g.setColor(Color.black);g.fillOval(chess[i][j].x-5, chess[i][j].y-5, 10, 10);}
						if(i==11&&j==3) {g.setColor(Color.black);g.fillOval(chess[i][j].x-5, chess[i][j].y-5, 10, 10);}
						if(i==11&&j==11) {g.setColor(Color.black);g.fillOval(chess[i][j].x-5, chess[i][j].y-5, 10, 10);}
					
			}
					
				}System.out.println("绘制棋盘");
			this.isdraw=1;
			
					for(int i=0;i<15;i++) {
						for(int j=0;j<15;j++) {
							//绘制棋子
							
							switch (chess[i][j].color) {
							case -1:
								g.setColor(Color.black);
								g.fillOval(chess[i][j].x-20, chess[i][j].y-20, 40, 40);break;
							case 1:
								g.setColor(Color.white);
								g.fillOval(chess[i][j].x-20, chess[i][j].y-20, 40, 40);
								break;

							default:
								break;
							}
						}
					
			}System.out.println("绘制棋子");
			new win().winOne(chess,this);new win().winTwo(chess,this);new win().winThree(chess,this);new win().winFour(chess,this);
		}
		
	public void endtime() {
		nowtime=System.currentTimeMillis();
		endtime=nowtime+30*1000;
		endTimer=new Timer();
		TimerTask task=new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(endtime>=nowtime) {
					
					endtimeArea.setText(""+(endtime-nowtime)/1000);
					nowtime+=1000;
				}else {
					restartButton.setVisible(true);restartButton.setEnabled(true);
					if(message.getChessol()==-1) {JOptionPane.showMessageDialog(null, "落棋超时，白方胜利");whitescore++;whitescoreField.setText(""+whitescore);whitescoreField.repaint();endTimer.cancel();message.setChessol(-1);;removeMouseListener(mml);}
					if(message.getChessol()==1) {JOptionPane.showMessageDialog(null, "落棋超时，黑方胜利");blackscore++;blackscoreField.setText(""+blackscore);blackscoreField.repaint();endTimer.cancel();message.setChessol(-1);;removeMouseListener(mml);}
				}
			}
		};
		endTimer.schedule(task, 0,1000);
	}		
	/**public void showTalkMessage() {
		Timer timer=new Timer();
		TimerTask task=new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if(message.getTalk().size()>0) {
					talkArea.append(message.getTalk().get(message.getTalk().size()-1)+"\n");
					
				}
			}
		};
		timer.schedule(task, 0,2000);
	}**/
		
		
}