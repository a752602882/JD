package Unit;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class POIUtil {

    private final static String xls = "xls";
    private final static String xlsx = "xlsx";

    private static Logger logger = Logger.getLogger(POIUtil.class);

    //不允许实例化
    private POIUtil() {
    }

    public static Object[][] readExcel(String path, String sheetName) {
        List<Object> list = new ArrayList<>();
        Workbook wb=null;
        //读取execl
        try {
            //检查文件类型
            String type = checkFile(path);
            //初始化处理表格
            wb= initWorkBook(type,path);
        } catch (Exception e) {
            e.printStackTrace();
        }

           //获得表
            Sheet sheet = wb.getSheet(sheetName);
            //判断有多少行
            int last =sheet.getLastRowNum();
            int frist = sheet.getFirstRowNum();
            int rowcount = sheet.getLastRowNum()-sheet.getFirstRowNum();

            List<Object[]> recodes = new ArrayList<Object[]>();

                for (int i = 1; i < rowcount+1; i++) {
                    Row row = sheet.getRow(i);
                    String[] fields = new String[row.getLastCellNum()];
                        for (int j = 0; j < row.getLastCellNum(); j++) {
                            fields[j] = getCellValue(row.getCell(j));
                            //主要是用来防止execl表中读取的数据为null时候（避免报错）
                            if (fields[j].equals("/")) fields[j]="";
                        }
                     recodes.add(fields);
                }

                Object[][] results = new Object[recodes.size()][];
                //把List<Object>转换为一个二维数组
                for (int i = 0;i<recodes.size();i++){
                   results[i]=recodes.get(i);
                }
             return results;
    }

    //判断种类类型
    private static String getCellValue(Cell cell) {
        if (cell == null)
            return null;
        Object result = "";
        switch (cell.getCellTypeEnum()) {
            case STRING:
                result = cell.getStringCellValue();
                break;
            case BOOLEAN:
                result = cell.getBooleanCellValue();
                break;
            case FORMULA:
                result = cell.getCachedFormulaResultTypeEnum();
                break;
            case NUMERIC:
                result = cell.getNumericCellValue();
                break;
            case BLANK:
                break;
            case ERROR:
                result = cell.getErrorCellValue();
                break;
            case _NONE:
                break;
        }
        return result.toString();
    }
    /**
     * 初始化workBook
     */
     public static Workbook initWorkBook(String type, String path) throws Exception {
         Workbook  wb=null;
         if (type.equals(xlsx)) {
             //xlsx 是office>07年
             wb = new XSSFWorkbook(new FileInputStream(path));
         } else {
             wb = new HSSFWorkbook(new FileInputStream(path));
         }
         return wb;
     }


    /**
     *   检查文件名是否正确
     */
    private static String checkFile(String path) throws FileNotFoundException {
        if (null == path) {
            logger.error("文件不存在！");
            throw new FileNotFoundException("文件不存在！");
        }
        //获得文件名类型
        String type = path.split("\\.")[1];
        //判断文件是否为xls,xlsx
        if (type.equals("xls")) {
            return "xls";
        } else if (type.equals("xlsx")) {
            return "xlsx";
        }

        return null;
    }


    @Test
    public void testPOI() {
        readExcel("register.xlsx","Sheet1");
    }

}
