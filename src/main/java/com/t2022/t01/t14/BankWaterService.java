package com.t2022.t01.t14;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class BankWaterService implements Runnable {

    // 创建4 个屏障，处理完之后执行当前类的run方法
    private CyclicBarrier c = new CyclicBarrier(4, this);

    // 假设只有4个sheet ，所以只启动4个线程
    private Executor executor = Executors.newFixedThreadPool(4);
    //保存每个 sheet算出的银行结果
    private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<>();

    private void count() {
        for (int i = 0; i < 4; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    // 计算当前sheet的银行流数据 ，计算代码省略的sheetBankWaterCount
                    sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
                    //银行流水计算完成 ，插入一个屏障
                    try {
                        c.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @Override
    public void run() {
        int result = 0;
        //汇总每个 sheet计算出的结果
        for (Map.Entry<String, Integer> sheet : sheetBankWaterCount.entrySet()) {
            result += sheet.getValue();
        }
        //将结果输出
        sheetBankWaterCount.put("result", result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();
    }

}
