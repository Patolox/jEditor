package features;

import textEditor.Editor;
import textEditor.EncryptOutput;

public class Controller {
    private Thread autosave;
    private Thread encrypt;
    private Editor editor;
    private EncryptOutput encryptOutput;
    private Load loader;
    private static final String filePath = "Save.txt";
    private static Controller controller;

    public static Controller getConstructor(Editor editor, EncryptOutput encryptOutput) {
        if (controller == null) {
            controller = new Controller(editor, encryptOutput);
            return controller;
        } else {
            return controller;
        }
    }

    private Controller(Editor editor, EncryptOutput encryptOutput) {
        this.editor = editor;
        this.encryptOutput = encryptOutput;
        this.loader = Load.getContructor(filePath);
        this.loadFile();
        this.autosave = new Thread(new AutoSave(editor));
        this.encrypt = new Thread(new Encrypt(editor, encryptOutput));
        if (this.editor.isAutoSaveEnabled()) {
            autosave.start();
        }
        encrypt.start();
    }

    private void loadFile() {
        String text = loader.getFile();
        editor.setText(text);
    }
}
