package gobang;

public class clear {
	public clear(chess[][] chess) {
		for(int i=0;i<15;i++) {
			for(int j=0;j<15;j++) {
				chess[i][j].color=0;
			}
		}
	}
}
