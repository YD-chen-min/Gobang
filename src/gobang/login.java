package gobang;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField roomField;
	InetAddress ip;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public login() {
		this.setSize(500,500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel label = new JLabel("房间号:");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(69, 111, 79, 31);
		contentPane.add(label);
		
		roomField = new JTextField();
		roomField.setBounds(160, 117, 168, 21);
		contentPane.add(roomField);
		roomField.setColumns(10);
		
		JButton okButton = new JButton("进入");
		okButton.setFont(new Font("宋体", Font.PLAIN, 15));
		okButton.setBounds(199, 222, 69, 50);
		contentPane.add(okButton);
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent agr0) {
				// TODO Auto-generated method stub
				try {
					ip=InetAddress.getByName(roomField.getText().trim());
					mymain3 playermain=new mymain3();
					playermain.setName("白方：");
					playerThread player=new playerThread(ip,playermain);
					player.playerThread.start();
//					Scanner input =new Scanner(System.in);
					
					playermain.setIsblack(1);
					while (player.playerThread.isAlive()){

					}
//					int i=input.nextInt();
					playermain.UI();
					playermain.repaint();
					ReadThread reader=new ReadThread(playermain);
					reader.readtThread.start();
					reader.readtThread2.start();
					
					
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		JLabel label_1 = new JLabel("双人联机对决");
		label_1.setFont(new Font("电影海报字体", Font.PLAIN, 30));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.GRAY);
		label_1.setBounds(131, 26, 229, 42);
		contentPane.add(label_1);
		
	}
}
