package features;

import textEditor.Editor;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class AutoSave implements Runnable {

	private Editor editor;
	private long saveTime;
	private String text;
	private static final String NOME_ARQUIVO = "Save.txt";
	private FileOutputStream fileOutput;
	private ObjectOutputStream objectOutput;

	public AutoSave(Editor editor) {
		this.editor = editor;
		this.saveTime = 1000; // salva a cada 1 segundo
	}

	private void save(String text) {
		try {
			fileOutput = new FileOutputStream(NOME_ARQUIVO);
			objectOutput = new ObjectOutputStream(fileOutput);
			objectOutput.writeObject(text);
			fileOutput.close();
			objectOutput.close();
			System.out.println("------ALTERACAO SALVA COM SUCESSO------");
		} catch (Exception e) {
			System.out.println("------ERRO AO TENTAR SALVAR O ARQUIVO------");
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(this.saveTime);
				this.text = editor.getText();
				save(this.text);
				System.out.println(this.text);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
