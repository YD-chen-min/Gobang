package gobang;

import java.io.Serializable;

public class message implements Serializable{
	private static final long serialVersionUID = 1L;
	private chess[][] chess=null;
	private int chessol=-1;
	public int getChessol() {
		return chessol;
	}
	public void setChessol(int chessol) {
		this.chessol = chessol;
	}
	private  boolean isend=false;
	private  String ip=null;
	public chess[][] getChess() {
		return chess;
	}
	public void setChess(chess[][] chess) {
		this.chess = chess;
	}
	
	
	public boolean isIsend() {
		return isend;
	}
	public void setIsend(boolean isend) {
		this.isend = isend;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public message() {}
}
