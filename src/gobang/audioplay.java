package gobang;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;




public class audioplay {
	AudioClip aduAudioClip;
	public audioplay() throws MalformedURLException {
		JApplet applet=new JApplet();
		File file=new File("落棋声.wav");
		java.net.URI uri=file.toURI();
		URL url=null;
		url=uri.toURL();
		aduAudioClip=Applet.newAudioClip(url);
		
	}
	public void play() {
		aduAudioClip.play();
	}
	
}
