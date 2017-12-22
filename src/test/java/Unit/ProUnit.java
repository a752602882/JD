package Unit;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
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
     *  写入配置文件
     */
    public  void  writeFile(String path){
        try {
            FileOutputStream out = new FileOutputStream(path);
            properties.store(out,new Date().toString());
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
          }

    /**
     * 解析配置文件
     */
    public String getPro(String key){
           return  properties.getProperty(key);
    }

    public void writePro(String name, String value) {
    properties.setProperty(name,value);
    }
}
