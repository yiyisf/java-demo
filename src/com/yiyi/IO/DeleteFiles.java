package com.yiyi.IO;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by zgx on 2017-12-07.
 * 递归删除目录
 */
public class DeleteFiles {

    public static void main(String[] args) {
        Path path = Paths.get("D:\\xxx\\testdata\\f2");

        try {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>(){
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println("Deleting file:" + file);
                    Files.delete(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    System.out.println("deleting dir:" + dir);
                    if (exc == null) {
                        Files.delete(dir);
                        return FileVisitResult.CONTINUE;
                    } else {
                        throw exc;
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

/**
 * result
 *
 Deleting file:D:\xxx\testdata\f2\f1 - 副本 (2).txt
 Deleting file:D:\xxx\testdata\f2\f1 - 副本 (3).txt
 Deleting file:D:\xxx\testdata\f2\f1 - 副本.txt
 Deleting file:D:\xxx\testdata\f2\f1.txt
 deleting dir:D:\xxx\testdata\f2\f21\f22\f23
 deleting dir:D:\xxx\testdata\f2\f21\f22
 deleting dir:D:\xxx\testdata\f2\f21
 deleting dir:D:\xxx\testdata\f2
 *
 *
 **/