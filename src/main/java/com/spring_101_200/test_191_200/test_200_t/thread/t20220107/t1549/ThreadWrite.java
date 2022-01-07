package com.spring_101_200.test_191_200.test_200_t.thread.t20220107.t1549;

import java.io.PipedOutputStream;

public class ThreadWrite extends  Thread {

    private WriteData write;

    private PipedOutputStream out;

    public ThreadWrite(WriteData writeData, PipedOutputStream out) {
        this.write = writeData;
        this.out = out;
    }


    @Override
    public void run() {
        write.writeMethod(out);
    }
}
