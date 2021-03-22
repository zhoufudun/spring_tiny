package com.spring_101_200.test_101_110.test104_xstream;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PersistenceSample {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setUsername("zhangsan");
        user.setUserId(10l);
        users.add(user);

        // 创建持久化策略
        File file = new File("/Users/quyixiao/project/spring_tiny/src/main/java/com/spring_101_200/test_101_110/test104_xstream/PersistenceSample");

    }
}
