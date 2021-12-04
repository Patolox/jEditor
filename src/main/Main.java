package main;

import javax.swing.JFrame;
import java.awt.BorderLayout;

import textEditor.Editor;
import textEditor.EncryptOutput;
import features.Controller;

public class Main extends JFrame {

	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private Editor editor = new Editor(WIDTH, HEIGHT);
	private EncryptOutput encryptOutput = new EncryptOutput(WIDTH, HEIGHT);
	private Controller controller = Controller.getConstructor(editor, encryptOutput);

	public Main() {
		setSize(WIDTH, HEIGHT);
		setTitle("jEditor");
		add(editor);
		add(encryptOutput);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Main();
	}
}
