package Unit;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;

public class POIUtil {

    private static Logger logger= Logger.getLogger(POIUtil.class);

    //不允许实例化
    private POIUtil(){
    }

    public  void  readExcel(File file){

      //  checkFile(file);

    }

    private void checkFile(File file) throws FileNotFoundException {
       if (null ==file){
           logger.error("文件不存在！");
           throw new FileNotFoundException("文件不存在！");
       }
       //获得文件名
        String fileName = file.getName();
       //判断文件是否为xls,xlsx
       // if (file.)

    }


}
