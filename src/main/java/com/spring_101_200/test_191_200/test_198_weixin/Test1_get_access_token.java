package com.spring_101_200.test_191_200.test_198_weixin;

import com.utils.HttpUtil;

public class Test1_get_access_token  {


    //{"errcode":0,"errmsg":"ok","access_token":"40XUDsyu4L9unF5SMA10u-tXuw5Nca4nNKLA386Yf_PsW0RqvJIULjXxBwtefMEtU1tSjhJR9498OArywr4Vkih9X0XpiXiVSIv9ckdPW3aZaPEGKsrfimksGXpDGGNIy7A7XP_JKCtuHaCYGPfo9lEb7pg1iwFLHgJsHoKhHCYmwbYSwXuRVEH26GNCzh-bBlEgojsoNaK0k1q_OSVFuw","expires_in":7200}
    public static void main(String[] args) throws Exception{
        String ID = "wwa51543f629f5a288";
        String SECRET = "p3zenJ_4cTDRP67M1FBp8815LZEPKhvXtn2PPyj7ON8";
        String a = HttpUtil.doGet("https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid="+ID+"&corpsecret="+SECRET,50000);
        System.out.println(a);
    }
}
