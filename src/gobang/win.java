package gobang;

import javax.swing.JButton;
import javax.swing.JOptionPane;


public class win {

		public void winOne(chess[][] chess,mymain my) {
			mymain mymain=my;
			for(int i=0;i<=14;i++) {
				for(int j=0;j<=10;j++) {
					if((chess[i][j].color==chess[i][j+1].color)&&(chess[i][j].color==chess[i][j+2].color)&&(chess[i][j].color==chess[i][j+3].color)&&(chess[i][j].color==chess[i][j+4].color)){
						if(chess[i][j].color==-1) {JOptionPane.showMessageDialog(null, "黑方胜利");mymain.blackscore++;mymain.blackscoreField.setText(""+mymain.blackscore);mymain.blackscoreField.repaint();mymain.restartButton.setEnabled(true);mymain.restartButton.setVisible(true);mymain.removeMouseListener(mymain.mml);mymain.endTimer.cancel();}
						else if (chess[i][j].color==1) {JOptionPane.showMessageDialog(null, "白方胜利");mymain.whitescore++;mymain.whitescoreField.setText(""+mymain.whitescore);mymain.whitescoreField.repaint();mymain.restartButton.setEnabled(true);mymain.restartButton.setVisible(true);mymain.removeMouseListener(mymain.mml);mymain.endTimer.cancel();}
					}
				}
			}
		}
		public void winTwo(chess[][] chess,mymain my) {
			mymain mymain=my;
			for(int i=0;i<=10;i++) {
				for(int j=0;j<=14;j++) {
					if((chess[i][j].color==chess[i+1][j].color)&&(chess[i][j].color==chess[i+2][j].color)&&(chess[i][j].color==chess[i+3][j].color)&&(chess[i][j].color==chess[i+4][j].color)) {
						if(chess[i][j].color==-1) {JOptionPane.showMessageDialog(null, "黑方胜利");mymain.blackscore++;mymain.blackscoreField.setText(""+mymain.blackscore);mymain.blackscoreField.repaint();mymain.restartButton.setEnabled(true);mymain.restartButton.setVisible(true);mymain.endTimer.cancel();mymain.removeMouseListener(mymain.mml);}
						else if (chess[i][j].color==1) {JOptionPane.showMessageDialog(null, "白方胜利");mymain.whitescore++;mymain.whitescoreField.setText(""+mymain.whitescore);mymain.whitescoreField.repaint();mymain.restartButton.setEnabled(true);mymain.restartButton.setVisible(true);mymain.endTimer.cancel();mymain.removeMouseListener(mymain.mml);}
					}
				}
			}
		}
		public void winThree(chess[][] chess,mymain my) {
			mymain mymain=my;
			for(int i=0;i<=10;i++) {
				for(int j=0;j<=10;j++) {
					if((chess[i][j].color==chess[i+1][j+1].color)&&(chess[i][j].color==chess[i+2][j+2].color)&&(chess[i][j].color==chess[i+3][j+3].color)&&(chess[i][j].color==chess[i+4][j+4].color)) {
						if(chess[i][j].color==-1) {JOptionPane.showMessageDialog(null, "黑方胜利");mymain.blackscore++;mymain.blackscoreField.setText(""+mymain.blackscore);mymain.blackscoreField.repaint();mymain.restartButton.setEnabled(true);mymain.restartButton.setVisible(true);mymain.endTimer.cancel();mymain.removeMouseListener(mymain.mml);}
						else if (chess[i][j].color==1){JOptionPane.showMessageDialog(null, "白方胜利");mymain.whitescore++;mymain.whitescoreField.setText(""+mymain.whitescore);mymain.whitescoreField.repaint();mymain.restartButton.setEnabled(true);mymain.restartButton.setVisible(true);mymain.endTimer.cancel();mymain.removeMouseListener(mymain.mml);}

					}
				}
			}
		}
		public void winFour(chess[][] chess,mymain my) {
			mymain mymain=my;
			for(int i=0;i<=10;i++) {
				for(int j=4;j<=14;j++) {
					if((chess[i][j].color==chess[i+1][j-1].color)&&(chess[i][j].color==chess[i+2][j-2].color)&&(chess[i][j].color==chess[i+3][j-3].color)&&(chess[i][j].color==chess[i+4][j-4].color)){
						if(chess[i][j].color==-1) {JOptionPane.showMessageDialog(null, "黑方胜利");mymain.blackscore++;mymain.blackscoreField.setText(""+mymain.blackscore);mymain.blackscoreField.repaint();mymain.restartButton.setEnabled(true);mymain.restartButton.setVisible(true);mymain.endTimer.cancel();mymain.removeMouseListener(mymain.mml);}
						else if (chess[i][j].color==1){JOptionPane.showMessageDialog(null, "白方胜利");mymain.whitescore++;mymain.whitescoreField.setText(""+mymain.whitescore);mymain.whitescoreField.repaint();mymain.restartButton.setEnabled(true);mymain.restartButton.setVisible(true);mymain.endTimer.cancel();mymain.removeMouseListener(mymain.mml);}
					}
				}
			}
		}
//***********************************************************************************************
		public void winOne(chess[][] chess,mymain2 my) {
			mymain2 mymain=my;
			for(int i=0;i<=14;i++) {
				for(int j=0;j<=10;j++) {
					if((chess[i][j].color==chess[i][j+1].color)&&(chess[i][j].color==chess[i][j+2].color)&&(chess[i][j].color==chess[i][j+3].color)&&(chess[i][j].color==chess[i][j+4].color)){
						if(chess[i][j].color==-1) {mymain.adAudioplay3.play();JOptionPane.showMessageDialog(null, "游戏结束，您获得了胜利");mymain.blackscore++;mymain.blackscoreField.setText(""+mymain.blackscore);mymain.blackscoreField.repaint();mymain.endTimer.cancel();mymain.restartButton.setEnabled(true);mymain.restartButton.setVisible(true);mymain.removeMouseListener(mymain.mml);}
						else if (chess[i][j].color==1) {mymain.adAudioplay4.play();JOptionPane.showMessageDialog(null, "游戏结束，您失败了>_<");mymain.whitescore++;mymain.whitescoreField.setText(""+mymain.whitescore);mymain.whitescoreField.repaint();mymain.endTimer.cancel();mymain.restartButton.setEnabled(true);mymain.restartButton.setVisible(true);mymain.removeMouseListener(mymain.mml);}
					}
				}
			}
		}
		public void winTwo(chess[][] chess,mymain2 my) {
			mymain2 mymain=my;
			for(int i=0;i<=10;i++) {
				for(int j=0;j<=14;j++) {
					if((chess[i][j].color==chess[i+1][j].color)&&(chess[i][j].color==chess[i+2][j].color)&&(chess[i][j].color==chess[i+3][j].color)&&(chess[i][j].color==chess[i+4][j].color)) {
						if(chess[i][j].color==-1) {mymain.adAudioplay3.play();JOptionPane.showMessageDialog(null, "游戏结束，您获得了胜利");mymain.blackscore++;mymain.blackscoreField.setText(""+mymain.blackscore);mymain.blackscoreField.repaint();mymain.endTimer.cancel();mymain.restartButton.setEnabled(true);mymain.restartButton.setVisible(true);mymain.removeMouseListener(mymain.mml);}
						else if (chess[i][j].color==1) {mymain.adAudioplay4.play();JOptionPane.showMessageDialog(null, "游戏结束，您失败了>_<");mymain.whitescore++;mymain.whitescoreField.setText(""+mymain.whitescore);mymain.whitescoreField.repaint();mymain.endTimer.cancel();mymain.restartButton.setEnabled(true);mymain.restartButton.setVisible(true);mymain.removeMouseListener(mymain.mml);}
					}
				}
			}
		}
		public void winThree(chess[][] chess,mymain2 my) {
			mymain2 mymain=my;
			for(int i=0;i<=10;i++) {
				for(int j=0;j<=10;j++) {
					if((chess[i][j].color==chess[i+1][j+1].color)&&(chess[i][j].color==chess[i+2][j+2].color)&&(chess[i][j].color==chess[i+3][j+3].color)&&(chess[i][j].color==chess[i+4][j+4].color)) {
						if(chess[i][j].color==-1) {mymain.adAudioplay3.play();JOptionPane.showMessageDialog(null, "游戏结束，你获得了胜利");mymain.blackscore++;mymain.blackscoreField.setText(""+mymain.blackscore);mymain.blackscoreField.repaint();mymain.endTimer.cancel();mymain.restartButton.setEnabled(true);mymain.restartButton.setVisible(true);mymain.removeMouseListener(mymain.mml);}
						else if (chess[i][j].color==1){mymain.adAudioplay4.play();JOptionPane.showMessageDialog(null, "游戏结束，您失败了>_<");mymain.whitescore++;mymain.whitescoreField.setText(""+mymain.whitescore);mymain.endTimer.cancel();mymain.whitescoreField.repaint();mymain.restartButton.setEnabled(true);mymain.restartButton.setVisible(true);mymain.removeMouseListener(mymain.mml);}

					}
				}
			}
		}
		public void winFour(chess[][] chess,mymain2 my) {
			mymain2 mymain=my;
			for(int i=0;i<=10;i++) {
				for(int j=4;j<=14;j++) {
					if((chess[i][j].color==chess[i+1][j-1].color)&&(chess[i][j].color==chess[i+2][j-2].color)&&(chess[i][j].color==chess[i+3][j-3].color)&&(chess[i][j].color==chess[i+4][j-4].color)){
						if(chess[i][j].color==-1) {mymain.adAudioplay3.play();JOptionPane.showMessageDialog(null, "游戏结束,您获得了胜利^ ^");mymain.blackscore++;mymain.blackscoreField.setText(""+mymain.blackscore);mymain.blackscoreField.repaint();mymain.endTimer.cancel();mymain.restartButton.setEnabled(true);mymain.restartButton.setVisible(true);mymain.removeMouseListener(mymain.mml);}
						else if (chess[i][j].color==1){mymain.adAudioplay4.play();JOptionPane.showMessageDialog(null, "游戏结束，您失败了>_<");mymain.whitescore++;mymain.whitescoreField.setText(""+mymain.whitescore);mymain.whitescoreField.repaint();mymain.endTimer.cancel();mymain.restartButton.setEnabled(true);mymain.restartButton.setVisible(true);mymain.removeMouseListener(mymain.mml);}
					}
				}
			}
		}
		//------------------------------------------------------------------------------------
		public void winOne(chess[][] chess,mymain3 my) {
			mymain3 mymain=my;
			for(int i=0;i<=14;i++) {
				for(int j=0;j<=10;j++) {
					if((chess[i][j].color==chess[i][j+1].color)&&(chess[i][j].color==chess[i][j+2].color)&&(chess[i][j].color==chess[i][j+3].color)&&(chess[i][j].color==chess[i][j+4].color)){
						if(chess[i][j].color==-1) {JOptionPane.showMessageDialog(null, "黑方胜利");mymain.blackscore++;mymain.blackscoreField.setText(""+mymain.blackscore);mymain.blackscoreField.repaint();mymain.restartButton.setEnabled(true);mymain.restartButton.setVisible(true);mymain.removeMouseListener(mymain.mml);mymain.endTimer.cancel();}
						else if (chess[i][j].color==1) {JOptionPane.showMessageDialog(null, "白方胜利");mymain.whitescore++;mymain.whitescoreField.setText(""+mymain.whitescore);mymain.whitescoreField.repaint();mymain.restartButton.setEnabled(true);mymain.restartButton.setVisible(true);mymain.removeMouseListener(mymain.mml);mymain.endTimer.cancel();}
					}
				}
			}
		}
		public void winTwo(chess[][] chess,mymain3 my) {
			mymain3 mymain=my;
			for(int i=0;i<=10;i++) {
				for(int j=0;j<=14;j++) {
					if((chess[i][j].color==chess[i+1][j].color)&&(chess[i][j].color==chess[i+2][j].color)&&(chess[i][j].color==chess[i+3][j].color)&&(chess[i][j].color==chess[i+4][j].color)) {
						if(chess[i][j].color==-1) {JOptionPane.showMessageDialog(null, "黑方胜利");mymain.blackscore++;mymain.blackscoreField.setText(""+mymain.blackscore);mymain.blackscoreField.repaint();mymain.restartButton.setEnabled(true);mymain.restartButton.setVisible(true);mymain.endTimer.cancel();mymain.removeMouseListener(mymain.mml);}
						else if (chess[i][j].color==1) {JOptionPane.showMessageDialog(null, "白方胜利");mymain.whitescore++;mymain.whitescoreField.setText(""+mymain.whitescore);mymain.whitescoreField.repaint();mymain.restartButton.setEnabled(true);mymain.restartButton.setVisible(true);mymain.endTimer.cancel();mymain.removeMouseListener(mymain.mml);}
					}
				}
			}
		}
		public void winThree(chess[][] chess,mymain3 my) {
			mymain3 mymain=my;
			for(int i=0;i<=10;i++) {
				for(int j=0;j<=10;j++) {
					if((chess[i][j].color==chess[i+1][j+1].color)&&(chess[i][j].color==chess[i+2][j+2].color)&&(chess[i][j].color==chess[i+3][j+3].color)&&(chess[i][j].color==chess[i+4][j+4].color)) {
						if(chess[i][j].color==-1) {JOptionPane.showMessageDialog(null, "黑方胜利");mymain.blackscore++;mymain.blackscoreField.setText(""+mymain.blackscore);mymain.blackscoreField.repaint();mymain.restartButton.setEnabled(true);mymain.restartButton.setVisible(true);mymain.endTimer.cancel();mymain.removeMouseListener(mymain.mml);}
						else if (chess[i][j].color==1){JOptionPane.showMessageDialog(null, "白方胜利");mymain.whitescore++;mymain.whitescoreField.setText(""+mymain.whitescore);mymain.whitescoreField.repaint();mymain.restartButton.setEnabled(true);mymain.restartButton.setVisible(true);mymain.endTimer.cancel();mymain.removeMouseListener(mymain.mml);}

					}
				}
			}
		}
		public void winFour(chess[][] chess,mymain3 my) {
			mymain3 mymain=my;
			for(int i=0;i<=10;i++) {
				for(int j=4;j<=14;j++) {
					if((chess[i][j].color==chess[i+1][j-1].color)&&(chess[i][j].color==chess[i+2][j-2].color)&&(chess[i][j].color==chess[i+3][j-3].color)&&(chess[i][j].color==chess[i+4][j-4].color)){
						if(chess[i][j].color==-1) {JOptionPane.showMessageDialog(null, "黑方胜利");mymain.blackscore++;mymain.blackscoreField.setText(""+mymain.blackscore);mymain.blackscoreField.repaint();mymain.restartButton.setEnabled(true);mymain.restartButton.setVisible(true);mymain.endTimer.cancel();mymain.removeMouseListener(mymain.mml);}
						else if (chess[i][j].color==1){JOptionPane.showMessageDialog(null, "白方胜利");mymain.whitescore++;mymain.whitescoreField.setText(""+mymain.whitescore);mymain.whitescoreField.repaint();mymain.restartButton.setEnabled(true);mymain.restartButton.setVisible(true);mymain.endTimer.cancel();mymain.removeMouseListener(mymain.mml);}
					}
				}
			}
		}
}
