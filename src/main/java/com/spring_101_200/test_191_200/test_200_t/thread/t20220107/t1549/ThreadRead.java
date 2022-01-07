package com.spring_101_200.test_191_200.test_200_t.thread.t20220107.t1549;

import java.io.PipedInputStream;

public class ThreadRead extends Thread {


    private ReadData read;

    private PipedInputStream input;

    public ThreadRead(ReadData read, PipedInputStream input) {
        this.read = read;
        this.input = input;
    }


    @Override
    public void run() {
        read.readMethod(input);
    }
}
