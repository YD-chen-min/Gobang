package gobang;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class audioplay2 {
	AudioClip aduAudioClip;
	public audioplay2() throws MalformedURLException {
		JApplet applet=new JApplet();
		File file=new File("按键音效1.wav");
		java.net.URI uri=file.toURI();
		URL url=null;
		url=uri.toURL();
		
		aduAudioClip=Applet.newAudioClip(url);
		
	}
	public void play() {
		aduAudioClip.play();
	}
	
}
