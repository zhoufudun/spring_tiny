package com.spring_101_200.test_181_190.test_186_spring_mvc_async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;

@Controller
@RequestMapping(value = {"/test"})
public class TestController {

    @Autowired
    AysncService aysncService;

    //https://blog.csdn.net/qq_34652458/article/details/80331275
    @RequestMapping("/async")
    public String async() {
        return "async";
    }


    @RequestMapping("/call")
    @ResponseBody
    public Callable<String> asyncCall() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String preDate = df.format(new Date());
        System.out.println("==================call======preDate==============" + preDate);
        //借助mvcTaskExecutor在另外一个线程调用
        //此时Servlet容器线程已经释放,可以处理其他的请求
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(5000);
                String afterDate = df.format(new Date());
                System.out.println("++++++++++++++++++++date+++++++++++++++++++afterDate=" + afterDate);
                return "Async Hello World " + afterDate;
            }
        };
    }

    @RequestMapping("/defer")
    @ResponseBody
    public DeferredResult<String> deferredCall() {
        //调用aysncService的getAsyncUpdate方法
        //deferredResult被计划任务每五秒钟更新一次
        return aysncService.getAsyncUpdate();
    }

}
