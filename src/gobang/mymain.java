package gobang;

import javazoom.jl.decoder.JavaLayerException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;





public class mymain extends JFrame{
	MyMouseListener mml = new MyMouseListener(this);
	protected chess[][] chess = new chess[15][15];
	JLabel label1=new JLabel("黑方落棋");
	JLabel label2=new JLabel("白方落棋");
	JButton restartButton=new JButton("再来一局");
	ArrayList<chess> list=new ArrayList<>();
	JButton backButton=new JButton("悔棋");
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
	//***************************************************************************************
		public void UI() throws MalformedURLException, FileNotFoundException {
			music=new File("music");
			for(File file:music.listFiles()){
				musics.add(file.getName());
			}
			for(int i=0;i<15;i++) {
				for(int j=0;j<15;j++) {
					chess[i][j]=new chess(i, j);
				}
			}
		this.setTitle("五子棋");
		this.setSize(1000,1000);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);
		Container container=this.getContentPane();
		container.setBackground(new Color(240, 233, 217));
		container.setLayout(null);
		this.addMouseListener(mml);
		this.setVisible(true);
		
		
		//label.setSize(80, 700);
		label1.setBounds(800, 20, 200, 80);
		label1.setVisible(true);
		label1.setFont(new Font("宋体", Font.PLAIN, 20));
		container.add(label1);
		
		
		//label.setSize(80, 700);
		label2.setBounds(800, 20, 200 ,80);
		label2.setVisible(false );
		label2.setFont(new Font("宋体", Font.PLAIN, 20));
		container.add(label2);
		
		restartButton.setBounds(800, 360, 120, 60);
		restartButton.setFont(new Font("宋体", Font.BOLD, 18));
		restartButton.setVisible(false);
		restartButton.setEnabled(false);
		container.add(restartButton);
		restartButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			new clear(chess);addMouseListener(mml);
			restartButton.setVisible(false);
			restartButton.setEnabled(false);
			if(mml.chessol==-1) {label1.setVisible(true);label2.setVisible(false);}
			if(mml.chessol==1) {label1.setVisible(false);label2.setVisible(true);}
			endTimer.cancel();
			endtime();
			repaint();
			}
		});
		
		backButton.setBounds(800, 200, 120, 60);
		backButton.setFont(new Font("宋体", Font.BOLD, 18));
		backButton.setVisible(true);
		container.add(backButton);
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			
			if(list.size()>1) {
				list.get(list.size()-1).color=0;
				list.get(list.size()-2).color=0;
				list.remove(list.size()-1);
				list.remove(list.size()-1);
				endTimer.cancel();
				endtime();
			}
			else {JOptionPane.showMessageDialog(null, "已经无棋可悔");}
			if(mml.chessol==-1) {label1.setVisible(true);label2.setVisible(false);}
			if(mml.chessol==1) {label1.setVisible(false);label2.setVisible(true);}
				repaint();
				count--;
			}
		});
		
		endButton.setBounds(800, 280, 120, 60);
		endButton.setFont(new Font("宋体", Font.BOLD, 18));
		endButton.setVisible(true);
		container.add(endButton);
		endButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new clear(chess);
				mml.chessol=-1;
				if(mml.chessol==-1) {label1.setVisible(true);label2.setVisible(false);}
				if(mml.chessol==1) {label1.setVisible(false);label2.setVisible(true);}
				endTimer.cancel();
				endtime();
				repaint();
				JOptionPane.showMessageDialog(null, "和棋成功，新的一局已经开始");
			}
		});
		
		backgroundBox .setBounds(870, 5, 50, 20);
		backgroundBox.setMaximumRowCount(3);
		container.add(backgroundBox);
		
		label3.setBounds(820, 5, 50, 20);
		container.add(label3);
		
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
		blackscoreJLabel.setBounds(800,450,80,50);
		container.add(blackscoreJLabel);
		
		whitescoreJLabel=new JLabel("白方得分：");
		whitescoreJLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		whitescoreJLabel.setBounds(800,520,80,50);
		container.add(whitescoreJLabel);
		
		blackscoreField=new JTextField();
		blackscoreField.setFont(new Font("宋体", Font.PLAIN, 15));
		blackscoreField.setBounds(880, 465, 20, 20);
		blackscoreField.setText(""+blackscore);
		blackscoreField.setBackground(container.getBackground());
		container.add(blackscoreField);
		
		whitescoreField=new JTextField();
		whitescoreField.setFont(new Font("宋体", Font.PLAIN, 15));
		whitescoreField.setBounds(880, 535,20 , 20);
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
			
			@Override
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
					musicplayer.musicThread.sleep(1);musicplayer.player.close();musicplayer.musicThread=null;
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
				isplay=1;
				try {
					stopOrstartButton.setIcon(new ImageIcon("暂停.png"));
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
				isplay=1;
				stopOrstartButton.setIcon(new ImageIcon("暂停.png"));
				try {
					musicplayer.musicThread.sleep(1);
					musicplayer.player.close();
					musicplayer.musicThread=null;
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
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
		
		
		audioplay=new audioplay();
		
		endtime();
		//**********************************************************
		backgroundJLabel=new JLabel();
		backgroundJLabel.setBounds(0,0,1000,1000);
		container.add(backgroundJLabel);
		//**********************************************************
		}
		//***************************************************************************
		
		public void paint(Graphics g) {
			super.paint(g);
			drawChessTable(g);
		}
		public void drawChessTable(Graphics g) {
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
					
				}
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
					
			}
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
					if(mml.chessol==-1) {JOptionPane.showMessageDialog(null, "落棋超时，白方胜利");whitescore++;whitescoreField.setText(""+whitescore);whitescoreField.repaint();endTimer.cancel();mml.chessol=-1;removeMouseListener(mml);}
					if(mml.chessol==1) {JOptionPane.showMessageDialog(null, "落棋超时，黑方胜利");blackscore++;blackscoreField.setText(""+blackscore);blackscoreField.repaint();endTimer.cancel();mml.chessol=-1;removeMouseListener(mml);}
				}
			}
		};
		endTimer.schedule(task, 0,1000);
	}		
		/**public static void main(String[] args){
			new mymain().UI();
		}**/
		
}