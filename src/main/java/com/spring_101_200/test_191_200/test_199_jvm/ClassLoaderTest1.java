package com.spring_101_200.test_191_200.test_199_jvm;

import org.apache.tools.ant.taskdefs.Classloader;
import sun.security.util.SecurityConstants;

public class ClassLoaderTest1 {


/*
    public ClassLoader getClassLoader(){
        ClassLoader cl = getClassLoader0();
        if(cl == null){
            return null;
        }
        SecurityManager sm = System.getSecurityManager();
        if(sm  != null){
            Classloader ccl = ClassLoader.getCallerClassLoader();
            if(ccl != null && ccl != cl && !cl.isAncestor(ccl)){
                sm.checkPermission(SecurityConstants.GET_CLASSLOADER_PERMISSION);
            }
        }
        return cl;
    }
*/

}
