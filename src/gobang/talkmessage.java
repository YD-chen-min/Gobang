package gobang;

import java.io.Serializable;
import java.util.ArrayList;

public class talkmessage implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<String> talkArrayList=new ArrayList<String>();
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getTalkArrayList() {
		return talkArrayList;
	}
	public void setTalkArrayList(String e) {
		talkArrayList.add(e);
	}
	
}
