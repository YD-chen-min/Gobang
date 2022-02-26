package gobang;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class musicPlay extends Thread {
	String nameString;
	Player player;
	Thread musicThread;
	public musicPlay(String name) throws FileNotFoundException, JavaLayerException {
		BufferedInputStream buffer=new BufferedInputStream(new FileInputStream(name));
		player=new Player(buffer);
		musicThread=new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				try {
					
					player.play();
				} catch (JavaLayerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		});
		
		
	}


	
	

}
