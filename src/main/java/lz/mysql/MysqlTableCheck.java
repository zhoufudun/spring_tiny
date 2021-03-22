package lz.mysql;

import com.utils.StringUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/***
 * 预发布环境回调接口地址：
 https://pre-callback.sinawallent.com/platform/callback
 https://pre-callback.sinawallent.com/platformweb/query
 */
public class MysqlTableCheck {


    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {

        Map<String, String> map = MysqlUtil2ShowCreateTable.getComments();

        List<TablesBean> list = new ArrayList<TablesBean>();

        String path = ResourceUtils.getURL("classpath:").getPath();
        String dir = null;
        if (StringUtils.isNotBlank(path)) {
            dir = path.split("target")[0];
        }
        String save_path = dir + "src/main/java";
        System.out.println(save_path);


        List<String> resultFileName = new ArrayList<>();
        File file = new File(save_path);
        if(file.exists()){
            file.mkdirs();
        }
        ergodic(file, resultFileName);

        Map<String, String> fileNameMap = new HashMap<>();


        for (String fileName : resultFileName) {
            String fileNames[] = fileName.split("\\.");
            fileNameMap.put(fileNames[fileNames.length - 2], fileName);
        }


        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!entry.getKey().startsWith("QRTZ") && !entry.getKey().startsWith("sys")) {
                String tableName = entry.getKey();
                TablesBean tablesBean = new TablesBean(tableName);
                List<FieldBean> itemList = MysqlUtil2ShowCreateTable.readTableDetail(tableName);
                tablesBean.setFieldList(itemList);
                tablesBean.setComment(map.get(tableName));
                list.add(tablesBean);
            }
        }


        for (TablesBean tablesBean : list) {
            String className = fileNameMap.get(tablesBean.getSpaceName());
            if (StringUtils.isNotBlank(className)) {
                List<FieldBean> fields = tablesBean.getFieldList();
                Map<String, String> fieldMap = new HashMap<>();
                for (FieldBean fieldBean : fields) {
                    fieldMap.put(fieldBean.getJavaCode(), fieldBean.getField());
                }
                fileNameMap.get(tablesBean.getSpaceName());
                className = className.replaceAll("\\.java", "");
                Class clazz = Class.forName(className);
                List<String> daima = new ArrayList<>();

                // 获取普通方法
                Field[] field02 = clazz.getDeclaredFields(); // 返回所有的属性
                for (Field field : field02) {
                    String a = fieldMap.get(field.getName());
                    //System.out.println("field="+field.getName()+ ",value="+a);
                    if (StringUtils.isBlank(a)) {
                        daima.add(field.getName());
                    } else {
                        fieldMap.remove(field.getName());
                    }
                }
                if (daima.size() > 0 || !fieldMap.isEmpty()) {
                    String c = "";
                    if (daima.size() > 0) {
                        c += "，代码中存在,数据库中不存在字段:";
                        for (String dai : daima) {
                            c += dai + ",";
                        }
                    }
                    String d = "";
                    if (!fieldMap.isEmpty()) {
                        d += "，数据库中存在,代码中中不存在字段:";
                        for (Map.Entry<String, String> entry : fieldMap.entrySet()) {
                            d += entry.getValue() + ",";
                        }
                    }

                    System.out.println("======类名：" + tablesBean.getTableName() + d + c);
                }
            } else {
                System.out.println("代码中不存在,数据中存在表：" + tablesBean.getTableName());
            }
        }

    }

    public static List<String> ergodic(File file, List<String> resultFileName) {
        File[] files = file.listFiles();
        if (files == null) return resultFileName;// 判断目录下是不是空的
        for (File f : files) {
            if (f.isDirectory()) {// 判断是否文件夹
                ergodic(f, resultFileName);// 调用自身,查找子目录
            } else {
                String path = f.getPath();
                String paths[] = path.split("/src/main/java/");
                String className = paths[1].replaceAll("/", ".");
                resultFileName.add(className);
            }
        }
        return resultFileName;
    }

}
