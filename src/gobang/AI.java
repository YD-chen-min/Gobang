package gobang;


public class AI {
	public AI(chess[][] chess) {
		if(stopOne(chess)) {}
		else if(stopTwo(chess)) {}
		else if(stopThree(chess)) {}
		else if(stopFour(chess)) {}
		else play(chess);
	}
	public  boolean stopOne(chess[][] chess) {
		//横向堵截
		for(int i=0;i<=14;i++) {
			for(int j=0;j<=12;j++) {
				if((chess[i][j].color==-1)&&(chess[i][j+1].color==-1)&&(chess[i][j+2].color==-1)) {
					if((j==0)&&chess[i][j+3].color==0) {chess[i][j+3].color=1;return true;}
					else if(((j+2)==14)&&chess[i][j-1].color==0) {chess[i][j-1].color=1;return true;}
					else if((j+4<=14)&&(chess[i][j+4]).color==-1&&chess[i][j+3].color==0) {chess[i][j+3].color=1;return true;}
					else if((j-2>=0)&&(chess[i][j-2].color==-1)&&chess[i][j-1].color==0) {chess[i][j-1].color=1;return true;}
					else if((j-1>=0)&&chess[i][j-1].color==0){chess[i][j-1].color=1;return true;}
					else if((j+3<=14)&&chess[i][j+3].color==0) {chess[i][j+3].color=1;return true;}
				}
				
				 
			}
		}
		return false;
	}
	public boolean stopTwo(chess[][] chess) {
		//纵向阻截
		for(int i=0;i<=12;i++) {
			for(int j=0;j<=14;j++) {
				if((chess[i][j].color==-1)&&(chess[i+1][j].color==-1)&&(chess[i+2][j].color==-1)) {
					if((i==0)&&chess[i+3][j].color==0) {chess[i+3][j].color=1;return true;}
					else if(((i+2)==14)&&chess[i-1][j].color==0) {chess[i-1][j].color=1;return true;}
					else if((i+4<=14)&&(chess[i+4][j]).color==-1&&chess[i+3][j].color==0) {chess[i+3][j].color=1;return true;}
					else if((i-2>=0)&&(chess[i-2][j].color==-1&&chess[i-1][j].color==0)) {chess[i-1][j].color=1;return true;}
					else if((i-1>=0)&&chess[i-1][j].color==0){chess[i-1][j].color=1;return true;}
					else if((i+3<=14)&&chess[i+3][j].color==0) {chess[i+3][j].color=1;return true;}
				}
				
				 
			}
		}
		return false;
	}
	public boolean stopThree(chess[][] chess) {
		//斜下阻截
		for(int i=0;i<=12;i++) {
			for(int j=0;j<=12;j++) {
			if((chess[i][j].color==-1)&&(chess[i+1][j+1].color==-1)&&(chess[i+2][j+2].color==-1)) {
				if((i==0&&j==0)&&chess[i+3][j+3].color==0) {chess[i+3][j+3].color=1;return true;}
				else if(i==0&&j==12){return play(chess);}
				else if(i==12&&j==0) {return play(chess);}
				else if((i==12&&j==12)&&chess[i-1][j-1].color==0) {chess[i-1][j-1].color=1;return true;}
				else if((i-2>=0&&j-2>=0)&&(chess[i-2][j-2].color==-1&&chess[i-1][j-1].color==0)){chess[i-1][j-1].color=1;return true;}
				else if((i+4<=14&&j+4<=14)&&chess[i+4][j+4].color==-1&&chess[i+3][j+3].color==0) {chess[i+3][j+3].color=1;return true;}
				else if((i-1>=0&&j-1>=0)&&chess[i-1][j-1].color==0) {chess[i-1][j-1].color=1;return true;}
				else if((i+3<=14&j+3<=14)&&chess[i+3][j+3].color==0) {chess[i+3][j+3].color=1;return true;}
			}			
			
			}
		}
		return false;
	}
	public boolean stopFour(chess[][] chess) {
		//斜上阻截
		for(int i=0;i<=12;i++) {
			for(int j=2;j<=14;j++) {
				if((chess[i][j].color==-1)&&(chess[i+1][j-1].color==-1)&&(chess[i+2][j-2].color==-1)) {
					if(i==0&&j==2) {return play(chess);}
					else if(i==12&j==14) {return play(chess);}
					else if((i==0&&j==14)&&chess[i+3][j-3].color==0) {chess[i+3][j-3].color=1;return true;}
					else if((i==12&&j==2)&&chess[i-3][j+3].color==0) {chess[i-3][j+3].color=1;return true;}
					else if((i-2>=0&&j+2<=14)&&chess[i-2][j+2].color==-1&&chess[i-1][j+1].color==0) {chess[i-1][j+1].color=1;return true;}
					else if((i+4<=14&&j-4>=0)&&chess[i+4][j-4].color ==-1&&chess[i+3][j-3].color==0) {chess[i+3][j-3].color=1;return true;}
					else if((i-1>=0&&j+1<=14)&&chess[i-1][j+1].color==0) {chess[i-1][j+1].color=1;return true;}
					else if((i+3<=14&&j-3>=0)&&chess[j+3][j-3].color==0) {chess[i+3][j-3].color=1;return true;}
				}
			}
		
		}
		return false;
	}
	public boolean play(chess[][] chess) {
		for(int i=0;i<15;i++) {
			for(int j=0;j<15;j++) {
				if(chess[i][j].color==0) {chess[i][j].color=1;return true;}
			
			}
		
		}
		return false;
	}
}
