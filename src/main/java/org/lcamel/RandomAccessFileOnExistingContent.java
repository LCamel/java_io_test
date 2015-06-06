package org.lcamel;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;

@State(Scope.Thread)
public class RandomAccessFileOnExistingContent extends RandomAccessFileTest {
    long fileLen = 0;
    @Override
    protected void initFile(File f) throws IOException {
        System.out.println("init !!");
        RandomAccessFile raf = new RandomAccessFile(f, "rw");
        byte[] ba = Util.generate(2000);
        for (int i = 0; i < 1000000; i++) {
            raf.write(ba);
        }
        fileLen = raf.length();
        raf.close();
    }

    @TearDown
    public void myTearDown() throws IOException {
        super.tearDown();
        //
    }
}
