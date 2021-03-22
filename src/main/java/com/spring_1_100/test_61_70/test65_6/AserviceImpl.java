package com.spring_1_100.test_61_70.test65_6;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.AopConfigException;
import org.springframework.aop.framework.ProxyConfig;
import org.springframework.stereotype.Service;

@Service
public class AserviceImpl extends ProxyConfig implements Aservice, Advised {

    public AserviceImpl b(String x, User y) {
        System.out.println("=================== print x=" + x + ",y=" + y);
        return this;
    }

    @Override
    public boolean isFrozen() {


        System.out.println("===========isFrozen====================");
        return false;
    }

    @Override
    public Class<?>[] getProxiedInterfaces() {
        return new Class[0];
    }

    @Override
    public boolean isInterfaceProxied(Class<?> intf) {
        return false;
    }

    @Override
    public void setTargetSource(TargetSource targetSource) {

    }

    @Override
    public TargetSource getTargetSource() {
        return null;
    }

    @Override
    public void setPreFiltered(boolean preFiltered) {

    }

    @Override
    public boolean isPreFiltered() {
        return false;
    }

    @Override
    public Advisor[] getAdvisors() {
        return new Advisor[0];
    }

    @Override
    public void addAdvisor(Advisor advisor) throws AopConfigException {

    }

    @Override
    public void addAdvisor(int pos, Advisor advisor) throws AopConfigException {

    }

    @Override
    public boolean removeAdvisor(Advisor advisor) {
        return false;
    }

    @Override
    public void removeAdvisor(int index) throws AopConfigException {

    }

    @Override
    public int indexOf(Advisor advisor) {
        return 0;
    }

    @Override
    public boolean replaceAdvisor(Advisor a, Advisor b) throws AopConfigException {
        return false;
    }

    @Override
    public void addAdvice(Advice advice) throws AopConfigException {

    }

    @Override
    public void addAdvice(int pos, Advice advice) throws AopConfigException {

    }

    @Override
    public boolean removeAdvice(Advice advice) {
        return false;
    }

    @Override
    public int indexOf(Advice advice) {
        return 0;
    }

    @Override
    public String toProxyConfigString() {
        return null;
    }


    @Override
    public Class<?> getTargetClass() {
        return null;
    }
}
