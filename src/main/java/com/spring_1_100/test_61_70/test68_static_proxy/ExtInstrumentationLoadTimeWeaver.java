package com.spring_1_100.test_61_70.test68_static_proxy;

import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;

import java.lang.instrument.ClassFileTransformer;

public class ExtInstrumentationLoadTimeWeaver extends InstrumentationLoadTimeWeaver {
    @Override
    public void addTransformer(ClassFileTransformer transformer) {
        try {
            super.addTransformer(transformer);
        } catch (Exception e) {

        }
    }
} 