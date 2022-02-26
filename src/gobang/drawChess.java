package gobang;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class drawChess extends JFrame{
	
	public drawChess(chess[][] chess) {
		for(int i=0;i<15;i++) {
			for(int j=0;j<15;j++) {
				//绘制棋子
				BufferedImage bi = new BufferedImage(120,120, BufferedImage.TYPE_INT_ARGB);
				Graphics2D g = bi.createGraphics();
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
	}
}
