package com.spring_101_200.test_191_200.test_200_t.thread.t20220107.t1549;

import java.io.IOException;
import java.io.PipedInputStream;

public class ReadData {

    public void readMethod(PipedInputStream input){
        try {
            System.out.println("read :");
            byte [ ] byteArray = new byte[1024];
            int readLength = input.read(byteArray);
            while(readLength != -1 ){
                String newData = new String(byteArray,0 ,readLength);
                System.out.print(newData);
                readLength = input.read(byteArray);
            }
            System.out.println();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
