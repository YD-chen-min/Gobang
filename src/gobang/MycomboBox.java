package gobang;

import javax.swing.*;
import java.io.File;

public class MycomboBox extends AbstractListModel<String> implements ComboBoxModel<String> {
	private static final long serialVersionUID=1L;
	String selecteditem;
	static String[] text;
	static {
		File background=new File("background");
		File[] files=background.listFiles();
		text=new String[files.length];
		for(int i=0;i<files.length;i++){
			text[i]=files[i].getName();
		}
	}
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return text.length;
	}

	@Override
	public String getElementAt(int index) {
		// TODO Auto-generated method stub
		return text[index];
	}

	@Override
	public void setSelectedItem(Object anItem) {
		// TODO Auto-generated method stub
		selecteditem=(String)anItem;
	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		return selecteditem;
	}
	public int getIndex() {
		for(int i=0;i<text.length;i++) {
			if(text[i].equals(getSelectedItem()))  return i;
			
		}
		return 0;
	}

}
