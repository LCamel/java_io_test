package org.lcamel;

import java.io.File;
import java.io.IOException;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
public class ChannelOnExistingContent extends ChannelTest {

    @Override
    protected void initFile(File f) throws IOException {
        long fileLen = 10000000000L; // 10G
        Util.generateFile(f, fileLen);
    }
}
