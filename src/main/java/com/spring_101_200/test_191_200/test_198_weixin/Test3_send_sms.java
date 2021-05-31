package com.spring_101_200.test_191_200.test_198_weixin;

import com.alibaba.fastjson.JSON;
import com.utils.HttpUtil;
import freemarker.ext.servlet.AllHttpScopesHashModel;
import sun.jvmstat.perfdata.monitor.PerfStringVariableMonitor;

import java.util.HashMap;
import java.util.Map;

public class Test3_send_sms {

    public static void main(String[] args) {
        // {"errcode":0,"errmsg":"ok","userlist":[{"userid":"QuYiXiao","name":"瞿贻晓","department":[2,1]},{"userid":"YangYang","name":"秧秧","department":[1]}]}

        String token = "jZm3crxSmzye185VBVjGREM39WYNc7qxUXpAm44txM0C-f65yHyu3JQcDUzRFK5gY32N5kKdESedRbbnrbMDkLv3GcicqBnzpK0sTvwKuypd05pcQ2kDJF3L69sEMA9uR9tbaG3QFyWXNO4CDTpCKdJhwHtd7dGP6cTEgjSKDoMkQkMdDx2MvCjQJb1y_hliQFRDRWkkvX-vB6F9XA6kUw";


        Map<String,Object> map = new HashMap<>();
        map.put("touser","QuYiXiao");
        map.put("msgtype","text");
        map.put("agentid","1000003");
        Map<String ,String >contenMap =new HashMap<>();
        contenMap.put("content","你的快递已到，请携带工卡前往邮件中心领取。\\n出发前可查看<a href=\\\"http://work.weixin.qq.com\\\">邮件中心视频实况</a>，聪明避开排队。");
        map.put("text",contenMap);

        System.out.println(JSON.toJSONString(map));



      String b =   HttpUtil.doPost("https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token="+token,JSON.toJSONString(map));
        System.out.println(b);

    }
}
