package com.spring_101_200.test_181_190.test_185_spring_mvc;

import org.junit.Test;
import org.springframework.beans.PropertyAccessor;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.util.StringUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestAdapter {

    public static void main(String[] args) {

        HandlerAdapter1 handlerAdapter1 = new HandlerAdapter1();
        HandlerAdapter2 handlerAdapter2 = new HandlerAdapter2();
        List<IAdapter> adapterList = new ArrayList<>();

        adapterList.add(handlerAdapter1);
        adapterList.add(handlerAdapter2);


        AnnotationAwareOrderComparator.sort(adapterList);
        for (IAdapter handlerAdapter : adapterList) {
            System.out.println(handlerAdapter.getClass().getSimpleName());
        }
    }





    @Test
    public void test4() {
        String [][] a = new String[][]{};
        Class componentType = a.getClass().getComponentType();
        if(componentType.isArray()){
            System.out.println("是二维数组类型");
        }else{
            System.out.println("是一维数组类型");
        }


    }



    @Test
    public void test() {
        System.out.println(canonicalPropertyName("abc"));
        System.out.println(canonicalPropertyName("['abc']"));
        System.out.println(canonicalPropertyName("[''abc'']"));
        System.out.println(canonicalPropertyName("[\"abc\"]"));
    }


    public static String canonicalPropertyName(String propertyName) {
        if (propertyName == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder(propertyName);
        int searchIndex = 0;
        while (searchIndex != -1) {
            int keyStart = sb.indexOf(PropertyAccessor.PROPERTY_KEY_PREFIX, searchIndex);
            searchIndex = -1;
            if (keyStart != -1) {
                int keyEnd = sb.indexOf(
                        PropertyAccessor.PROPERTY_KEY_SUFFIX, keyStart + PropertyAccessor.PROPERTY_KEY_PREFIX.length());
                if (keyEnd != -1) {
                    String key = sb.substring(keyStart + PropertyAccessor.PROPERTY_KEY_PREFIX.length(), keyEnd);
                    if ((key.startsWith("'") && key.endsWith("'")) || (key.startsWith("\"") && key.endsWith("\""))) {
                        sb.delete(keyStart + 1, keyStart + 2);
                        sb.delete(keyEnd - 2, keyEnd - 1);
                        keyEnd = keyEnd - 2;
                    }
                    searchIndex = keyEnd + PropertyAccessor.PROPERTY_KEY_SUFFIX.length();
                }
            }
        }
        return sb.toString();
    }


    @Test
    public void test2() {
        System.out.println(getNestedPropertySeparatorIndex("[abc].[def]", false));
    }


    public static int getNestedPropertySeparatorIndex(String propertyPath, boolean last) {
        boolean inKey = false;
        int length = propertyPath.length();
        int i = (last ? length - 1 : 0);
        while (last ? i >= 0 : i < length) {
            switch (propertyPath.charAt(i)) {
                case PropertyAccessor.PROPERTY_KEY_PREFIX_CHAR:
                case PropertyAccessor.PROPERTY_KEY_SUFFIX_CHAR:
                    inKey = !inKey;
                    break;
                case PropertyAccessor.NESTED_PROPERTY_SEPARATOR_CHAR:
                    if (!inKey) {
                        return i;
                    }
            }
            if (last) {
                i--;
            } else {
                i++;
            }
        }
        return -1;
    }

    @Test
    public void test3() {
        PropertyTokenHolder tokenHolder = getPropertyNameTokens("names[0][1]");
        System.out.println(tokenHolder.canonicalName);
        System.out.println(tokenHolder.actualName);
        System.out.println(Arrays.toString(tokenHolder.keys));
    }


    protected static class PropertyTokenHolder {

        public String canonicalName;

        public String actualName;

        public String[] keys;
    }


    private PropertyTokenHolder getPropertyNameTokens(String propertyName) {
        PropertyTokenHolder tokens = new PropertyTokenHolder();
        String actualName = null;
        List<String> keys = new ArrayList<String>(2);
        int searchIndex = 0;
        while (searchIndex != -1) {
            int keyStart = propertyName.indexOf(PROPERTY_KEY_PREFIX, searchIndex);
            searchIndex = -1;
            if (keyStart != -1) {
                int keyEnd = propertyName.indexOf(PROPERTY_KEY_SUFFIX, keyStart + PROPERTY_KEY_PREFIX.length());
                if (keyEnd != -1) {
                    if (actualName == null) {
                        actualName = propertyName.substring(0, keyStart);
                    }
                    String key = propertyName.substring(keyStart + PROPERTY_KEY_PREFIX.length(), keyEnd);
                    if ((key.startsWith("'") && key.endsWith("'")) || (key.startsWith("\"") && key.endsWith("\""))) {
                        key = key.substring(1, key.length() - 1);
                    }
                    keys.add(key);
                    searchIndex = keyEnd + PROPERTY_KEY_SUFFIX.length();
                }
            }
        }
        tokens.actualName = (actualName != null ? actualName : propertyName);
        tokens.canonicalName = tokens.actualName;
        if (!keys.isEmpty()) {
            tokens.canonicalName +=
                    PROPERTY_KEY_PREFIX +
                            StringUtils.collectionToDelimitedString(keys, PROPERTY_KEY_SUFFIX + PROPERTY_KEY_PREFIX) +
                            PROPERTY_KEY_SUFFIX;
            tokens.keys = StringUtils.toStringArray(keys);
        }
        return tokens;
    }

    String NESTED_PROPERTY_SEPARATOR = ".";
    char NESTED_PROPERTY_SEPARATOR_CHAR = '.';

    /**
     * Marker that indicates the start of a property key for an
     * indexed or mapped property like "person.addresses[0]".
     */
    String PROPERTY_KEY_PREFIX = "[";
    char PROPERTY_KEY_PREFIX_CHAR = '[';

    /**
     * Marker that indicates the end of a property key for an
     * indexed or mapped property like "person.addresses[0]".
     */
    String PROPERTY_KEY_SUFFIX = "]";
    char PROPERTY_KEY_SUFFIX_CHAR = ']';


}
