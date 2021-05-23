package sample.proxy;

import java.util.ArrayList;

public interface FilesBytes {
    //Получить все файлы в байтах из заданной директории
    ArrayList<byte[]> getBytesOfFiles(String dirPath);
}
