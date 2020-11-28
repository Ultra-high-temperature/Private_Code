package javaTest;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("C:\\Users\\admin\\Desktop\\callin-docker-compose-base.yml");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            LineInputStream lineInputStream = new LineInputStream(bufferedInputStream);
            int available = fileInputStream.available();
            System.out.println(available+"字节");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(fileInputStream!=null){
            int read = fileInputStream.read();
            System.out.println(read);
        }
        int read = 0;
        while (-1!=(read=fileInputStream.read())){
            System.out.println(read);
        }

        // 对object对象的输入输出
        List<CollectorsTest.User> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            CollectorsTest.User user = new CollectorsTest.User("name" + i, i, "11-11" + 1);
            list.add(user);
        }
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("listOut.txt"));
        out.writeObject(list);
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("listOut.txt"));
        List<CollectorsTest.User> list2 = (List<CollectorsTest.User>) input.readObject();

        System.out.println();
    }
}
