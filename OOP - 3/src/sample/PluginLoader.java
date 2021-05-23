package sample;

import sample.proxy.PluginFilesBytesGetter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class PluginLoader implements PluginBytesReader {
    private static PluginLoader instance;
    private Method resolve;
    private Method define;
    ArrayList<byte[]> filesInBytes;

    private PluginLoader() throws NoSuchMethodException {
        PluginFilesBytesGetter pluginFilesBytesGetter = new PluginFilesBytesGetter();
        filesInBytes = pluginFilesBytesGetter.getPluginFilesBytes("plugins");

        Class<ClassLoader> c = ClassLoader.class;
        define = c.getDeclaredMethod("defineClass", String.class, byte[].class, int.class, int.class);
        resolve = c.getDeclaredMethod("resolveClass", Class.class);
        define.setAccessible(true);//методы - protected
        resolve.setAccessible(true);
    }

    public static PluginLoader getInstance() throws NoSuchMethodException {
        if (instance == null) {
            instance = new PluginLoader();
        }
        return instance;
    }

    @Override
    public ArrayList<Plugin> readPluginBytes() {
        ArrayList<Plugin> plugins = new ArrayList<Plugin>();

        ClassLoader c = ClassLoader.getSystemClassLoader();//Системный ClassLoader
        Class<?> cl;   //Загруженный класс
        Object instance;  //Его экземпляр



        for (byte[] file : filesInBytes) {
            try {
                cl = (Class<?>) define.invoke(c, null, file, 0, file.length);//Вызываем названный метод defineClass. От лица
                //Системного класслоадера, имя мы не знаем, читаем полностью от 0 до b.length
                resolve.invoke(c, cl);/// c.resolveClass(cl)
                instance = cl.newInstance();//Вызываем конструктор без аргументов
                //Если это плагин, то добавляем в результат
                if (instance instanceof Plugin) {
                    plugins.add((Plugin) instance);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
        return plugins;
    }

}
