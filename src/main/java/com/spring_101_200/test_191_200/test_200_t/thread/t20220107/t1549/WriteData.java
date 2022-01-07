package com.spring_101_200.test_191_200.test_200_t.thread.t20220107.t1549;

import java.io.IOException;
import java.io.PipedOutputStream;

public class WriteData {


    public void writeMethod(PipedOutputStream out){
        try {
            System.out.println("write : ");
            for(int i = 0 ;i < 300;i ++){
                String outData = "" + (i + 1 );
                out.write(outData.getBytes());
                System.out.print(outData);
            }
            System.out.println();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }





}
