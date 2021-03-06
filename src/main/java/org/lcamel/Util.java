package org.lcamel;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Util {
    public static byte[] generate(int len) {
        byte[] ba = new byte[len];
        for (int i = 0; i < len; i++) {
            ba[i] = (byte) 'A';
        }
        return ba;
    }
    public static void generateFile(File f, long len) throws IOException {
        System.out.println(">>>> generateFile");
        RandomAccessFile raf = new RandomAccessFile(f, "rw");
        byte[] ba = Util.generate(1000000);
        for (int i = 0; i < (len / ba.length); i++) {
            raf.write(ba);
        }
        raf.close();
        System.out.println("<<<< generateFile");
    }
}
