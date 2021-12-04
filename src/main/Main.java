package main;

import javax.swing.JFrame;

import textEditor.Editor;

public class Main extends JFrame{

	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	
	public Main() {
		setSize(WIDTH, HEIGHT);
		setTitle("jEditor");
		add(new Editor(WIDTH, HEIGHT));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Main();

	}

}
