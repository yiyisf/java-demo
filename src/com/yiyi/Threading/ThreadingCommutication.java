package com.yiyi.Threading;

import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * Created by zgx on 2017-12-07.
 */
public class ThreadingCommutication {
    public static void main(String[] args) {
        new ThreadingCommutication();
    }
    public ThreadingCommutication(){
        try{
            // Create writer and reader instances
            PipedReader pr = new PipedReader();
            PipedWriter pw = new PipedWriter();
            // Connect the writer with reader
            pw.connect(pr);

            Thread t1 = new Thread(new PipeReaderThread(pr, "Reader"));
            Thread t2 = new Thread(new PipeWriterThread(pw, "Writer"));

            t1.start();
            t2.start();
            System.out.println(t1.getId());
            System.out.println(t2.getId());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class PipeReaderThread implements Runnable {

    PipedReader pr;
    String name = null;

    public PipeReaderThread(PipedReader pr, String name) {
        this.pr = pr;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            // continuously read data from stream and print it in console
            while (true){
                char c = (char) pr.read();
                if ( c != -1) { // check for -1 indicating end of file
                    System.out.print(c);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class PipeWriterThread implements Runnable {

    PipedWriter pw;
    String name = null;

    public PipeWriterThread(PipedWriter pw, String name) {
        this.pw = pw;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Write some data after every two seconds
                pw.write("Test for write data ...\n");
                pw.flush();
                Thread.sleep(2000);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}


