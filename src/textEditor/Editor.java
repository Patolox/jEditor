package textEditor;

import java.awt.Color;

import javax.swing.JTextArea;

import features.AutoSave;

public class Editor extends JTextArea{

	public Editor(int width, int height) {
		setSize(width, height);
		setBackground(Color.GRAY);
		setVisible(true);
		Thread autosave = new Thread(new AutoSave(this));
		autosave.start();
	}
}
