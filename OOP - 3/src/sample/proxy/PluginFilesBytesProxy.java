package sample.proxy;

import java.util.ArrayList;

public class PluginFilesBytesProxy implements FilesBytes {

    private FilesBytes filesBytes = new PluginFilesBytes();

    private ArrayList<byte[]> cache = null;

    @Override
    public ArrayList<byte[]> getBytesOfFiles(String dirPath) {
        if(cache == null){
            cache = filesBytes.getBytesOfFiles("plugins");
        }
        return cache;
    }

    public void clearCache(){
        cache = null;
    }
}
