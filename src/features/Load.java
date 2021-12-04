package features;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Load {
    private FileInputStream fileInput;
    private ObjectInputStream objectInput;
    private static Load load;
    private String filePath;
    private String fileContent;

    public static Load getContructor(String filePath) {
        if (load == null) {
            load = new Load(filePath);
        } else {
            load.filePath = filePath;
        }
        return load;
    }

    private Load(String filePath) {
        this.filePath = filePath;
    }

    public String getFile() {
        File arquivo = new File(filePath);
        if (arquivo.exists()) {
            try {
                this.fileInput = new FileInputStream(this.filePath);
                this.objectInput = new ObjectInputStream(this.fileInput);
                fileContent = (String) objectInput.readObject();
                objectInput.close();
                fileInput.close();
                return fileContent;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return "";
        }
    }
}
