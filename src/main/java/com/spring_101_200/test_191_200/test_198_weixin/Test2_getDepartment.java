package com.spring_101_200.test_191_200.test_198_weixin;

import com.utils.HttpUtil;

public class Test2_getDepartment {

    public static void main(String[] args) {
        String token = "649jWoVAKQiTeDObPzOm-4Mb9a9b0VPAhXdChnxSLBeEYNLvTRPxNxmGlXBDLwXsB-NN07MRG9qU2dbWZJKqhOb5yX4hdsDSACaCn7RP10c4lLUf74PDz65-bgS-b8imUXbMirRhop3HOK0MnpAalvfAyx0P9w-ZC718Onm2UfHQAWNVQk1wx0uKBeaaj6qLQYyG9DS0i4mMP3NTraEzWg";


       String a = HttpUtil.doGet("https://qyapi.weixin.qq.com/cgi-bin/user/simplelist?access_token="+token+"&department_id=1&fetch_child=1",700000);
        System.out.println(a);
    }
}
