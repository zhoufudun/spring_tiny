package com.spring_101_200.test_191_200.test_200_t.thread.t20220107.t1657;

public class BackupB extends Thread {

    private DBTools dbTools;

    public BackupB(DBTools dbTools) {
        this.dbTools = dbTools;
    }

    @Override
    public void run() {
        dbTools.backupB();
    }
}
