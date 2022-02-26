package gobang;

import javazoom.jl.decoder.JavaLayerException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

public class startWindow extends JFrame {

    private JPanel contentPane;
    audioplay2 audioplay2;
    /**
     * Launch the application.
     */
    /**public static void main(String[] args) {
     EventQueue.invokeLater(new Runnable() {
     public void run() {
     try {
     startWindow frame = new startWindow();
     frame.setVisible(true);
     } catch (Exception e) {
     e.printStackTrace();
     }
     }
     });
     }**/

    /**
     * Create the frame.
     *
     * @throws MalformedURLException
     */
    public startWindow(musicPlay aMusicPlay) throws MalformedURLException {
        this.setSize(500, 500);
        //this.setResizable(false);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel label = new JLabel("五子棋");
        label.setFont(new Font("电影海报字体", Font.PLAIN, 40));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(162, 10, 150, 58);
        contentPane.add(label);

        JButton button1 = new JButton("双人模式");
        button1.setFont(new Font("宋体", Font.BOLD, 16));
        button1.setForeground(Color.GRAY);
        button1.setBounds(174, 117, 122, 41);
        contentPane.add(button1);
        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                audioplay2.play();
                aMusicPlay.player.close();
                aMusicPlay.musicThread = null;
                // TODO Auto-generated method stub
                try {
                    new mymain().UI();
                } catch (MalformedURLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        });

        JButton button2 = new JButton("人机对战");
        button2.setForeground(Color.GRAY);
        button2.setFont(new Font("宋体", Font.BOLD, 16));
        button2.setBounds(174, 192, 122, 41);
        contentPane.add(button2);
        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                audioplay2.play();
                aMusicPlay.player.close();
                aMusicPlay.musicThread = null;
                try {
                    new mymain2().UI();
                } catch (MalformedURLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        JButton tipButton1 = new JButton("提示");
        tipButton1.setFont(new Font("宋体", Font.PLAIN, 10));
        tipButton1.setBounds(317, 127, 57, 23);
        contentPane.add(tipButton1);
        tipButton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                audioplay2.play();

                // TODO Auto-generated method stub
                JOptionPane.showMessageDialog(null, "双人模式：一人为黑方，另一人为白方，黑方先落棋");
            }
        });

        JButton tipButton2 = new JButton("提示");
        tipButton2.setFont(new Font("宋体", Font.PLAIN, 10));
        tipButton2.setBounds(317, 203, 57, 23);
        contentPane.add(tipButton2);
        tipButton2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                audioplay2.play();
                JOptionPane.showMessageDialog(null, "该模式不能悔棋");
            }
        });

        JButton button3 = new JButton("建立房间");
        button3.setForeground(Color.GRAY);
        button3.setFont(new Font("宋体", Font.BOLD, 16));
        button3.setBounds(174, 250, 122, 41);
        contentPane.add(button3);
        button3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                audioplay2.play();
                aMusicPlay.player.close();
                aMusicPlay.musicThread = null;
                EventQueue.invokeLater(new Runnable() {
                    public void run() {


                        try {
                            mymain3 housemian = new mymain3();
                            housemian.setName("黑方：");
                            MyReceiveThread house = new MyReceiveThread(housemian);
                            house.serverThread.start();
//                            Scanner input = new Scanner(System.in);
                            housemian.setIsblack(-1);
//                            int i = input.nextInt();
                            while (house.serverThread.isAlive()) {

                            }
                            housemian.UI();
                            housemian.repaint();
                            ReadThread reader = new ReadThread(housemian);
                            reader.readtThread.start();
                            reader.readtThread2.start();

                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }


                    }

                });

            }
        });


        JButton button4 = new JButton("进入房间");
        button4.setForeground(Color.GRAY);
        button4.setFont(new Font("宋体", Font.BOLD, 16));
        button4.setBounds(174, 314, 122, 41);
        contentPane.add(button4);
        button4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                audioplay2.play();
                aMusicPlay.player.close();
                aMusicPlay.musicThread = null;
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            login frame = new login();
                            frame.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });


        JLabel backgroundlabel_1 = new JLabel("");
        backgroundlabel_1.setIcon(new ImageIcon("12.png"));
        backgroundlabel_1.setBounds(0, 0, 496, 472);
        contentPane.add(backgroundlabel_1);

        audioplay2 = new audioplay2();
    }
}
