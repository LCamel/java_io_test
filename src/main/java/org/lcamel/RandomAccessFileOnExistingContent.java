package org.lcamel;

import java.io.File;
import java.io.IOException;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;

@State(Scope.Thread)
public class RandomAccessFileOnExistingContent extends RandomAccessFileTest {
    long fileLen = 0;
    @Override
    protected void initFile(File f) throws IOException {
        System.out.println("init !!");
        fileLen = 10000000000L; // 10G
        Util.generateFile(f, fileLen);
    }

    @TearDown
    public void myTearDown() throws IOException {
        super.tearDown();
        //
    }
}
