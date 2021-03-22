package lz.mysql;

import org.apache.ibatis.parsing.XNode;
import org.apache.ibatis.parsing.XPathParser;

import java.util.List;

public class XPathParserTest {


    public static void main(String[] args) {
        String a = "<resultMap id=\"userBillResult\" type=\"com.lz.mybatis.plugin.entity.Page\">\n" +
                "        <id property=\"totalCount\" column=\"totalCount\" />\n" +
                "        <id property=\"pageCount\" column=\"pageCount\"></id>\n" +
                "        <id property=\"pageSize\" column=\"pageSize\"></id>\n" +
                "        <id property=\"currPage\" column=\"currPage\"></id>\n" +
                "        <collection property=\"list\" ofType=\"TestUser\">\n" +
                "            <id column=\"id\" property=\"id\"/>\n" +
                "            <result column=\"is_delete\" property=\"isDelete\"/>\n" +
                "            <result column=\"gmt_create\" property=\"gmtCreate\"/>\n" +
                "            <result column=\"gmt_modified\" property=\"gmtModified\"/>\n" +
                "            <result column=\"type\" property=\"type\"/>\n" +
                "            <result column=\"branch_id\" property=\"branchId\"/>\n" +
                "            <result column=\"real_name\" property=\"realName\"/>\n" +
                "            <result column=\"mobile\" property=\"mobile\"/>\n" +
                "            <result column=\"username\" property=\"username\"/>\n" +
                "            <result column=\"task_id\" property=\"taskId\"/>\n" +
                "            <result column=\"staff_id\" property=\"staffId\"/>\n" +
                "        </collection>\n" +
                "    </resultMap>";

        XPathParser xPathParser = new XPathParser(a);
        List<XNode> xNodeList = xPathParser.evalNodes("/resultMap");

    }
}
