package features;

import textEditor.Editor;
import textEditor.EncryptOutput;

public class Encrypt implements Runnable {

    private Editor editor;
    private EncryptOutput encryptOutput;
    private String text;
    private long encryptTime;
    private String encrypted = "";

    public Encrypt(Editor editor, EncryptOutput encryptOutput) {
        this.editor = editor;
        this.encryptOutput = encryptOutput;
        this.encryptTime = 1000; // encrypta a cada 1 segundo
    }

    private void encryptNow() {
        int length = this.text.length();
        String newEncryted = "";
        for (int i = 0; i < length; i++) {
            char c = this.text.charAt(i);
            newEncryted += (char) (c - 2);
        }
        if (!(encrypted.equals(newEncryted))) {
            encrypted = newEncryted;
            this.encryptOutput.setText(encrypted);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(this.encryptTime);
                this.text = editor.getText();
                encryptNow();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}