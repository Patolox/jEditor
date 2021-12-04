package features;

import textEditor.Editor;

public class AutoSave implements Runnable{

	private Editor editor;
	private long saveTime;
	private String text;
	
	public AutoSave(Editor editor) {
		this.editor = editor;
		this.saveTime = 1000; // salva a cada 1 segundo
	}
	

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(this.saveTime);
				this.text = editor.getText();
				System.out.println(this.text);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
