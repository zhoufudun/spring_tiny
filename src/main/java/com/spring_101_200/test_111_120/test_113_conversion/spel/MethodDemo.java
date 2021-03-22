package com.spring_101_200.test_111_120.test_113_conversion.spel;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MethodDemo {
   public static void main(String[] args) {
      Method[] methods = StringTest2.class.getMethods();
      List<Method> mes = Arrays.asList(methods);
      Collections.sort(mes, new Comparator<Method>() {
         @Override
         public int compare(Method m1, Method m2) {
            int m1pl = m1.getParameterTypes().length;
            int m2pl = m2.getParameterTypes().length;
            // varargs methods go last
            if (m1pl == m2pl) {
               if (!m1.isVarArgs() && m2.isVarArgs()) {
                  return -1;
               }
               else if (m1.isVarArgs() && !m2.isVarArgs()) {
                  return 1;
               }
               else {
                  return 0;
               }
            }
            return (m1pl < m2pl ? -1 : (m1pl > m2pl ? 1 : 0));
         }
      });
      for(Method method:mes){
         System.out.println(method.isVarArgs() + "   " + method);
      }
   }
}

class SampleClass {
   private String sampleField;

   public String getSampleField() {
      return sampleField;
   }

   public String getSampleField(Integer ... b ) {
      return sampleField;
   }

   public void setSampleField(String sampleField) {
      this.sampleField = sampleField;
   } 
}