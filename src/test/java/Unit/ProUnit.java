package Unit;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ProUnit {

    public  String filePath;
    public  Properties properties;

    public ProUnit(String filePath){
       this.filePath=filePath;
       properties = readFile(filePath);
    }

    /**
     *  加载配置文件
     */
    public  Properties  readFile(String path){

        Properties properties = new Properties();
        try {
            FileInputStream in = new FileInputStream(path);
            InputStream input = new BufferedInputStream(in);
            properties.load(input);
            in.close();
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
      return properties;
    }
    /**
     * 解析配置文件
     */
    public String getPro(String key){
           return  properties.getProperty(key);
    }

    public void WritePro(String name, String value) {
    properties.setProperty(name,value);
    }
}
