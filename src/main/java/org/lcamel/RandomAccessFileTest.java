package org.lcamel;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;

@State(Scope.Thread)
public class RandomAccessFileTest {

    RandomAccessFile raf;
    byte[] ba = Util.generate(2000);
    @Setup
    public void setup() throws IOException {
        System.out.println("#### setup()");
        File f = new File("./a.txt");
        f.delete();                              // kill it !
        initFile(f);
        raf = new RandomAccessFile(f, "rw");
    }
    protected void initFile(File f) throws IOException {
        // do nothing in this class
    }

    @TearDown
    public void tearDown() throws IOException {
        System.out.println("#### tearDown()");
        raf.close();
    }
    @Benchmark
    public void test() throws IOException {
        raf.write(ba);
    }
}
