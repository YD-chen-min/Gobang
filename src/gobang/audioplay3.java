package gobang;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class audioplay3 {
	AudioClip aduAudioClip;
	public audioplay3() throws MalformedURLException {
		JApplet applet=new JApplet();
		File file=new File("胜利.wav");
		java.net.URI uri=file.toURI();
		URL url=null;
		url=uri.toURL();
		aduAudioClip=Applet.newAudioClip(url);
		
	}
	public void play() {
		aduAudioClip.play();
	}
	
}
