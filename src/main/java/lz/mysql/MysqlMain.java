package lz.mysql;


import com.utils.StringUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MysqlMain {

    public static String package_name = "com.sina.model.entity";
    public static String package_name_model = "com.chengyi.user.dao";
/*

    //public static String save_path = "C:\\Users\\linzi\\Desktop\\mysql";

    //public static String save_path ="C:\\workspace\\life";
    public static String save_path = "C:\\workspace\\ideaworkspace\\api";

    public static String mysql_url = "jdbc:mysql://rr-bp1ih900km0q3e0ur.mysql.rds.aliyuncs.com:3306";
    public static String pre = "";
    public static String mysql_dbname = "igo";
    public static String mysql_username = "igo_readonly";
    public static String mysql_password = "qEJMAwIjY45F";
*/


    //public static String save_path = "C:\\Users\\linzi\\Desktop\\mysql";

    //public static String save_path ="C:\\workspace\\life";
    public static String save_path = "C:\\workspace\\ideaworkspace\\api";

    public static String mysql_url = "jdbc:mysql://localhost:3306";


    public static String pre = "";


    public static String mysql_dbname = "pple_test";

    public static String mysql_username = "ldd_biz";
    public static String mysql_password = "Hello1234";
    public static String dto_exclude = ",is_delete,gmt_create,gmt_modified,";//生成dto时排除字段，前后都要加英文逗号
    public static String req_exclude = ",,";//生成Req时排除字段，前后都要加英文逗号

    public static class TestStaticAndHuo{
        public static int compare(Long a, Long b){
            return a.compareTo(b);
        }

        public static boolean isEmpt(String str){
            return str == null || str.length() == 0;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        String path = ResourceUtils.getURL("classpath:").getPath();
        System.out.println(path);
        String dir = null;
        if (StringUtils.isNotBlank(path)) {
            dir = path.split("target")[0];
        }
        save_path = dir + "src/test/tmp";
        System.out.println(save_path);
        File file = new File(save_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        List<TablesBean> list = new ArrayList<TablesBean>();


        list.add(new TablesBean("lz_user"));

        List<TablesBean> list2 = new ArrayList<TablesBean>();
        Map<String, String> map = MysqlUtil2ShowCreateTable.getComments();
        for (int i = 0; i < list.size(); i++) {
            TablesBean obj = list.get(i);
            String tableName = list.get(i).getTableName();
            List<FieldBean> itemList = MysqlUtil2ShowCreateTable.readTableDetail(tableName);
            obj.setFieldList(itemList);
            obj.setComment(map.get(tableName));
            list2.add(obj);
        }

        for (int i = 0; i < list2.size(); i++) {
            MysqlUtilTable2Bean.printEntity(list2.get(i));
            MysqlUtilTable2Bean.printReq(list2.get(i));
            MysqlUtilTable2Bean.printDto(list2.get(i));
        }


        for (int i = 0; i < list2.size(); i++) {
            MysqlUtilTable2Contoller.printController(list2.get(i));
        }


        for (int i = 0; i < list2.size(); i++) {
            MysqlUtilTable2Mapper.printDao(list2.get(i));
        }

        for (int i = 0; i < list2.size(); i++) {
            MysqlUtilTable2Service.printService(list2.get(i));
            MysqlUtilTable2Service.printServiceImpl(list2.get(i));
        }

        for (int i = 0; i < list2.size(); i++) {
            MysqlUtilTable2XML.printXMLForMap(list2.get(i));
        }


    }

}
