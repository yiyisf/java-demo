package com.yiyi.IO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 * Created by zgx on 2017-12-07.
 */
public class DirectoryCopy {
    public static void main(String[] args) throws IOException {
        File src = new File("D:\\zgx\\testdata\\f1");
        File dest = new File("D:\\zgx\\testdata\\f2");

        copyFolder(src, dest);
    }

    private static void copyFolder(File srcFolder, File distinationFolder) throws IOException {
        if (srcFolder.isDirectory()) {
            if (!distinationFolder.exists()) {
                if (distinationFolder.mkdir()) {
                    System.out.println("Destinatin folder created:" + distinationFolder);
                }
            }

            String files[] = srcFolder.list();
            for (String file : files) {
                File srcFile = new File(srcFolder, file);
                File destFile = new File(distinationFolder, file);

                copyFolder(srcFile, destFile);
            }

        } else {
            Files.copy(srcFolder.toPath(), distinationFolder.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied:" + distinationFolder);
        }
    }

}
