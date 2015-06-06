package org.lcamel;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;

@State(Scope.Thread)
public class MappedByteBufferTest {

    MappedByteBuffer mbb;

    byte[] ba = Util.generate(2000);
    @Setup
    public void setup() throws IOException {
        System.out.println("#### setup()");
        File f = new File("./a.txt");
        f.delete();                              // kill it !
        initFile(f);
        try (RandomAccessFile raf = new RandomAccessFile(f, "rw");
                FileChannel channel = raf.getChannel()) {
            mbb = channel.map(MapMode.READ_WRITE, 0, raf.length());
        }
    }
    protected void initFile(File f) throws IOException {
        long fileLen = 2_000_000_000; // 2G
        Util.generateFile(f, fileLen);
    }

    @TearDown
    public void tearDown() throws IOException {
        System.out.println("#### tearDown()");
        mbb = null;
    }
    @Benchmark
    public void test() throws IOException {
        mbb.position(0);
        for (int i = 0; i < 1_000_000; i++)
            mbb.put(ba);
        mbb.force();
    }
}
