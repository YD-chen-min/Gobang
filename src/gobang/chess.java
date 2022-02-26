package gobang;

import java.io.Serializable;

public class chess implements Serializable{
	private static final long serialVersionUID = 1L;
	int x;
	int y;
	int color;//-1:black ;0:no chesses;1:white
	chess(int hang,int lie){
		x=125+(lie-1)*50;
		y=100+(hang-1)*50;
		color=0;
	}
}
