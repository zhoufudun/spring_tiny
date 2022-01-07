package com.spring_101_200.test_191_200.test_200_t.thread.t20220107.t1549;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Run {


    public static void main(String[] args) throws Exception {
        WriteData writeData = new WriteData();
        ReadData readData = new ReadData();
        PipedInputStream inputStream = new PipedInputStream();
        PipedOutputStream outputStream = new PipedOutputStream();


        outputStream.connect(inputStream);
        ThreadRead threadRead = new ThreadRead(readData, inputStream);
        threadRead.start();


        Thread.sleep(2000);

        ThreadWrite threadWrite = new ThreadWrite(writeData, outputStream);
        threadWrite.start();
    }
}
