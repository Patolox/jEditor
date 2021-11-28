package textEditor;

import java.awt.Color;

import javax.swing.JTextArea;

public class Editor extends JTextArea{

	public Editor(int width, int height) {
		setSize(width, height);
		setBackground(Color.GRAY);
		setVisible(true);
	}
}
