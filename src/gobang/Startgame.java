package gobang;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javazoom.jl.decoder.JavaLayerException;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Startgame extends JFrame {

	private JPanel contentPane;
	audioplay2 audioplay2;
	musicPlay aMusicPlay;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Startgame frame = new Startgame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws MalformedURLException 
	 * @throws JavaLayerException 
	 * @throws FileNotFoundException 
	 */
	public Startgame() throws MalformedURLException, FileNotFoundException, JavaLayerException {
		this.setSize(500,500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel backgroundJLabel=new JLabel();
		backgroundJLabel.setIcon(new ImageIcon("SGpic.png"));
		backgroundJLabel.setBounds(0, 0, 500, 500);
		
		JLabel btnNewButton = new JLabel("New button");
		btnNewButton.setBounds(121, 75, 267, 267);
		btnNewButton.setIcon(new ImageIcon("paly图标.png"));
		contentPane.add(btnNewButton);
	   backgroundJLabel.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			audioplay2.play();
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						startWindow frame = new startWindow(aMusicPlay);
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
		
		
		audioplay2=new audioplay2();
		aMusicPlay=new musicPlay("on my way1.mp3");
		aMusicPlay.musicThread.start();
		
		
		contentPane.add(backgroundJLabel);
	}
}
