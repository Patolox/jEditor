package textEditor;

import java.awt.Color;

import javax.swing.JTextArea;

public class EncryptOutput extends JTextArea {

    public EncryptOutput(int width, int height) {
        setEditable(false);
        setSize(width / 2, height);
        setAlignmentX(width / 2);
        setBackground(Color.BLUE);
        setVisible(true);
    }
}