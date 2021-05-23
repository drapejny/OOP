package sample.proxy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class PluginFilesBytes implements FilesBytes {
    @Override
    public ArrayList<byte[]> getBytesOfFiles(String dirPath) {
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        ArrayList<byte[]> bytesOfFiles = new ArrayList<>();
        for (File file : files) {
            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] bytes = new byte[fis.available()];
                fis.read(bytes);
                bytesOfFiles.add(bytes);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bytesOfFiles;
    }
}
