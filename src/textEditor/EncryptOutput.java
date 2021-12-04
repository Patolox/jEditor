package textEditor;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextArea;


public class EncryptOutput extends JTextArea {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EncryptOutput(int width, int height) {
		setSize(width/2, height);
		setMaximumSize(new Dimension(width/2, height));
		setLineWrap(true);
		setEditable(false);
        setBackground(Color.BLUE);
        setVisible(true);
    }
}