package features;

import textEditor.Editor;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.Semaphore;

public class AutoSave implements Runnable {

	private Editor editor;
	private long saveTime;
	private String text;
	private static final String NOME_ARQUIVO = "Save.txt";
	private FileOutputStream fileOutput;
	private ObjectOutputStream objectOutput;
	private Semaphore semaforo;

	public AutoSave(Editor editor, Semaphore semaforo) {
		this.editor = editor;
		this.saveTime = 1000; // salva a cada 1 segundo
		this.semaforo = semaforo; 
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
				semaforo.acquire();
				this.text = editor.getText();
				save(this.text);
				System.out.println(this.text);
				semaforo.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
