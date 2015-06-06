package org.lcamel;

public class Util {
    public static byte[] generate(int len) {
        byte[] ba = new byte[len];
        for (int i = 0; i < len; i++) {
            ba[i] = (byte) 'A';
        }
        return ba;
    }
}
