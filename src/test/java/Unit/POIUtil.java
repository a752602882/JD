package Unit;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileNotFoundException;

public class POIUtil {

    private final static  String xls = "xls";
    private final static  String xlsx = "xlsx";

    private static Logger logger= Logger.getLogger(POIUtil.class);

    //不允许实例化
    private POIUtil(){
    }

    public  void  readExcel(File file) throws FileNotFoundException {

        String type = checkFile(file);
        getWorkBook(type);

    }

    private static void getWorkBook(String type) {

        Workbook workbook = null;

        if (type.equals(xls)){

        }else if(type.equals(xlsx)){

        }
    }

    private String checkFile(File file) throws FileNotFoundException {
       if (null ==file){
           logger.error("文件不存在！");
           throw new FileNotFoundException("文件不存在！");
       }
       //获得文件名
        String fileName = file.getName();
       String type = fileName.split(">")[1];
       //判断文件是否为xls,xlsx
         if (type.equals("xls")){
            return "xls";
         }
         else if (type.equals("xlsx")) {
             return "xlsx";
        }

        return null;
    }


}
