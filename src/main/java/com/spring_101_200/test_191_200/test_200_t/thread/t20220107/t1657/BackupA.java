package com.spring_101_200.test_191_200.test_200_t.thread.t20220107.t1657;

public class BackupA extends Thread {

    private DBTools dbTools;

    public BackupA(DBTools dbTools) {
        this.dbTools = dbTools;
    }

    @Override
    public void run() {
        dbTools.backupA();
    }
}
