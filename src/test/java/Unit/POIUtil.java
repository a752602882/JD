package Unit;

import Module.Quan;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class POIUtil {

    private final static String xls = "xls";
    private final static String xlsx = "xlsx";

    private static Logger logger = Logger.getLogger(POIUtil.class);

    //不允许实例化
    private POIUtil() {
    }

    /**
     * 读取execl
     */
    public static Object[][] readExcel(String path, String sheetName) {
        List<Object> list = new ArrayList<>();
        Workbook wb = null;
        //读取execl
        try {
            //检查文件类型
            String type = checkFile(path);
            //初始化处理表格
            wb = initWorkBook(type, path);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //获得表
        Sheet sheet = wb.getSheet(sheetName);
        //判断有多少行
        int last = sheet.getLastRowNum();
        int frist = sheet.getFirstRowNum();
        int rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum();

        List<Object[]> recodes = new ArrayList<Object[]>();

        for (int i = 1; i < rowcount + 1; i++) {
            Row row = sheet.getRow(i);
            String[] fields = new String[row.getLastCellNum()];
            for (int j = 0; j < row.getLastCellNum(); j++) {
                fields[j] = getCellValue(row.getCell(j));
                //主要是用来防止execl表中读取的数据为null时候（避免报错）
                if (fields[j].equals("/")) fields[j] = "";
            }
            recodes.add(fields);
        }

        Object[][] results = new Object[recodes.size()][];
        //把List<Object>转换为一个二维数组
        for (int i = 0; i < recodes.size(); i++) {
            results[i] = recodes.get(i);
        }
        return results;
    }

    /*
        ****************************************************************************************************************
        ****************************************************************************************************************
     */

    /**
     * 判断文件是否存在
     */
    public boolean isFileExist(String path) {
        File file = new File(path);
        if (file.exists())
            return true;
        return false;
    }

    /**
     * 写入execl
     */
    public static boolean write(String path, String sheetName, List<Object[]> list, String[] titleRowValue) {

        Workbook wb = null;
        try {
            String type = checkFile(path);
            //wb = initWorkBook(fileType, path);
            if (type.equals(xls)) {
                wb = new XSSFWorkbook();
            }else if (type.equals(xlsx)){
                wb = new HSSFWorkbook();
            }else {
                System.out.println("错误文件类型");
            }


        //创建表
        Sheet sheet = wb.createSheet(sheetName);
        int rowIndex = 0;
        Row titleRow = sheet.createRow(rowIndex);
        for (int i = 0; i < titleRowValue.length; i++) {
            titleRow.createCell(i).setCellValue(titleRowValue[i]);
        }
        System.out.println("表头写入完成>>>>>>>>");
        rowIndex++;
        //循环写入主表数据
        for (Object[] object : list) {
            Row row = sheet.createRow(rowIndex);
            //创建单元格

            for (int i = 0;i<object.length;i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(object[i].toString());
            }
            /*
            Cell cell_price = row.createCell(1);
            cell_price.setCellValue(quan.getPrice());
            Cell cell_limit = row.createCell(2);
            cell_limit.setCellValue(quan.getLimit());
            Cell cell_progress = row.createCell(3);
            cell_progress.setCellValue(quan.getProgress());
            Cell cell_ishave = row.createCell(4);
            cell_ishave.setCellValue(quan.getIs_have());
   */         rowIndex++;
        }
        System.out.println("主表数据写入完成>>>>>>>>");
        FileOutputStream fos = new FileOutputStream(path);
        wb.write(fos);
        fos.close();
        System.out.println(path + "写入文件成功>>>>>>>>>>>");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    /*
        ****************************************************************************************************************
        ****************************************************************************************************************
     */

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
        Workbook wb = null;
        if (type.equals(xlsx)) {
            //xlsx 是office>07年
            wb = new XSSFWorkbook(new FileInputStream(path));
        } else {
            wb = new HSSFWorkbook(new FileInputStream(path));
        }
        return wb;
    }


    /**
     * 检查文件名是否正确
     */
    private static String checkFile(String path) throws FileNotFoundException {
        if (null == path) {
            logger.error("文件路径错误！");
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
      //  readExcel("register.xlsx", "Sheet1");
        List<Quan> quans = new ArrayList<>();
        quans.add(new Quan("自营机械师笔记本指定商品","已抢16%","立即领取","满5000可用","200"));
        quans.add(new Quan("自营炫龙游戏本指定商品","已抢16%","立即领取","满3000可用","200"));
        quans.add(new Quan("自营组装电脑部分商品","已抢16%","立即领取","满6000可用","200"));

        String[] titleRow = {"id","优惠券名","进度","是否拥有","限制","价值"};

    //    write("quan.xlsx","sheet1",quans,titleRow);
    }

}
