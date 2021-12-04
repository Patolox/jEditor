package features;

import textEditor.Editor;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class HotKeyHandler implements KeyListener {

    private Editor editor;
    private boolean ctrl;
    private boolean s;

    public HotKeyHandler(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        if (arg0.getKeyCode() == 17) {
            this.ctrl = true;
        } else if (arg0.getKeyChar() == 's') {
            this.s = true;
        }

        if (this.ctrl && this.s && !editor.isAutoSaveEnabled()) {
            editor.setAutoSaveEnabled(true);
        } else if (this.ctrl && this.s) {
            editor.setAutoSaveEnabled(false);
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        if (arg0.getKeyCode() == 17) {
            this.ctrl = false;
        } else if (arg0.getKeyChar() == 's') {
            this.s = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent arg0) {

    }

}
