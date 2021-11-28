package main;

import javax.swing.JFrame;

import textEditor.Editor;

public class Main extends JFrame{

	public Main() {
		setSize(800, 600);
		setTitle("jEditor");
		setVisible(true);
		add(new Editor(800, 600));
	}
	
	public static void main(String[] args) {
		new Main();

	}

}
