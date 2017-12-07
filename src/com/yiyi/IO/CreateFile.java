package com.yiyi.IO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zgx on 2017-12-07.
 */
public class CreateFile {
    public static void main(String[] args) throws IOException {

        //1.使用java.io.File类
        File f = new File("D:\\zgx\\testdata\\f2\\text.txt");
        if (f.createNewFile()){
            System.out.println("File is created!");
        } else {
            System.out.println("File alrady exists!");
        }

        //2.使用java.io.FileOutputStream类
        String data = "test data";
        FileOutputStream out = new FileOutputStream("D:\\zgx\\testdata\\f2\\outstream.txt");
        out.write(data.getBytes());
        out.close();
        //3.使用NIO的java.nio.file.Files
        //如果你还没有使用它，这应该是你将来首选的方法
        String tst = "for new method to create file";
        Files.write(Paths.get("D:\\zgx\\testdata\\f2\\files.txt"), tst.getBytes());

        List<String> sl = Arrays.asList("1st line", "2ed line");
//        Files.createFile(Paths.get("D:\\zgx\\testdata\\f2\\files_1.txt"));
        Files.write(Paths.get("D:\\zgx\\testdata\\f2\\files1.txt"), sl, StandardCharsets.UTF_8, StandardOpenOption.CREATE ,StandardOpenOption.APPEND);


    }
}
