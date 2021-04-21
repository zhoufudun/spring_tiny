package com.spring_1_100.test_71_80.test76_spring_rmi;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;
import java.util.Random;

public class RoundRobinStrategy implements ApplicationContextAware {
    private Map<Integer, String> weights;

    private static ApplicationContext applicationContext;

    public RoundRobinStrategy(Map<Integer, String> weights) {
        this.weights = weights;
    }

    public Map<Integer, String> getWeights() {
        return weights;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public HelloRMIService getService() {
        Random random = new Random();
        int a = random.nextInt(1000);
        String serviceName = null;
        for (Map.Entry<Integer, String> weight : weights.entrySet()) {
            if (a < weight.getKey()) {
                serviceName = weight.getValue();
                break;
            }
        }
        return applicationContext.getBean(serviceName, HelloRMIService.class);
    }

}
