package textEditor;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextArea;

public class Editor extends JTextArea {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean isAutoSaveEnabled;

	public Editor(int width, int height) {
		setSize(width/2, height);
		setMaximumSize(new Dimension(width/2, height));
		setLineWrap(true);
		setBackground(Color.GRAY);
		setVisible(true);
		this.isAutoSaveEnabled = true;
//		setFocusable(true);
//		requestFocus();
		//addKeyListener(new HotKeyHandler(this));
	}

	public boolean isAutoSaveEnabled() {
		return this.isAutoSaveEnabled;
	}

	public void setAutoSaveEnabled(boolean status) {
		this.isAutoSaveEnabled = status;
	}

}
