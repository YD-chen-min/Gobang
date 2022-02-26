package gobang;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener2 implements MouseListener {
		int chessol=-1;
		private mymain2 mymain;
		
		 public MyMouseListener2(mymain2 mymain) {
			 this.mymain=mymain;
			// TODO Auto-generated constructorstub
		}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getX()>=75&&e.getX()<=775) {
			if(e.getY()>=50&&e.getY()<=750) {
				int x=e.getX();
				int y=e.getY();
				int lie=(x-50)/50;//获取鼠标位置的列数；
				int hang=(y)/50;//获取鼠标位置的行数；
			
				if(x-50*lie<25) {
					if(y-50*hang<25) {
						hang--;lie--;
					}else {
						lie--;
					}
				}else {
					if(y-50*hang<25) {
						hang--;
					}
				}
				//System.out.println(hang+"  "+ lie);
				mymain.list.add(mymain.chess[hang][lie]);
				if(mymain.chess[hang][lie].color==0) {
					mymain.chess[hang][lie].color=chessol;
				}else {
					//chessol=-chessol;
				}
				mymain.count++;
				mymain.audioplay.play();
				new AI(mymain.chess);
				mymain.repaint();
				
				mymain.endTimer.cancel();
				mymain.endtime();
				
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
