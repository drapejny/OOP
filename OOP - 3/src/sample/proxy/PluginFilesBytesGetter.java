package sample.proxy;

import java.util.ArrayList;

public class PluginFilesBytesGetter {

    private FilesBytes filesBytes = new PluginFilesBytes();

    public ArrayList<byte[]> getPluginFilesBytes(String dirPath) {
        ArrayList<byte[]> files = filesBytes.getBytesOfFiles(dirPath);
        return files;
    }
}
