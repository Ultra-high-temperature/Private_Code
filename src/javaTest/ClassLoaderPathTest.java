package javaTest;

import sun.misc.Launcher;

import java.net.URL;

public class ClassLoaderPathTest {
    public static void main(String[] args) {
        //启动类加载器
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL url:urLs) {
            System.out.println(url);
        }



        //扩展类加载器
        String extDir = System.getProperty("java.ext.dirs");
        for (String path:extDir.split(";")) {
            System.out.println(path);
        }
    }
}
