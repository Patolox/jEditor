package main;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;

import textEditor.Editor;
import textEditor.EncryptOutput;
import features.Controller;

public class Main extends JFrame {

	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private Editor editor = new Editor(WIDTH, HEIGHT);
	private EncryptOutput encryptOutput = new EncryptOutput(WIDTH, HEIGHT);
	private Controller controller;

	public Main() {
		setSize(WIDTH, HEIGHT);
		setLayout(new BorderLayout());
		setTitle("jEditor");
		setBackground(Color.WHITE);
		add(editor, BorderLayout.WEST);
		add(encryptOutput, BorderLayout.EAST);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		controller = Controller.getConstructor(editor, encryptOutput);
	}

	public static void main(String[] args) {
		new Main();
	}
}
