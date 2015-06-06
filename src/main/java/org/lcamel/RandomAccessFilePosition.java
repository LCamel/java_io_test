package org.lcamel;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFilePosition {
    public static void main(String[] args) throws IOException {
        File f = new File("./b.txt");
        f.delete();
        {
            RandomAccessFile raf = new RandomAccessFile(f, "rw");
            System.out.println(raf.getFilePointer() + " " + raf.length());
            raf.write("abc".getBytes());
            System.out.println(raf.getFilePointer() + " " + raf.length());
            raf.close();
        }
        {
            RandomAccessFile raf = new RandomAccessFile(f, "rw");
            System.out.println(raf.getFilePointer() + " " + raf.length());
            raf.write("abc".getBytes());
            System.out.println(raf.getFilePointer() + " " + raf.length());
            raf.close();
        }

    }
}
