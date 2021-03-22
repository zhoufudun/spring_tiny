package com.spring_101_200.test_181_190.test_186_spring_mvc_async;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@EnableScheduling
public class AysncService {
    private DeferredResult<String> deferredResult;

    public DeferredResult<String> getAsyncUpdate() {
        deferredResult = new DeferredResult<String>();
        System.out.println("================getAsyncUpdate============");
        return deferredResult;
    }

    @Scheduled(fixedDelay = 5000)
    public void refresh() {
        if (deferredResult != null) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String preDate = df.format(new Date());
            System.out.println("==================call======preDate==============" + preDate);

            deferredResult.setResult(preDate);
        }
    }


}