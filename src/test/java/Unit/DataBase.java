package Unit;

import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataBase  {

     //不允许实例化
      private  DataBase(){

      }

    /**
     * 链接mysql数据库
     */
    public static void getMysqlJDBC(String table){

        String url = "jdbc:mysql://127.0.0.1:3306/jd";
        String user = "root";
        String password = "";
        Connection conn;
        List<Object[]> recodes = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,password);
            if (!conn.isClosed()){
                System.out.println("连接数据库成功！！！！");
            }
            // Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
            Statement stmt = conn.createStatement();

            //++++++++++++++
            String sql = "select * from "+table;
            //申明ResultSet , 用于执行Sql语句后返回的数据结果
            ResultSet rs = stmt.executeQuery(sql);

            //声明一个ResultSetMetaData
            ResultSetMetaData rsMetadata= rs.getMetaData();
            //获得所有的列
            int cols =rsMetadata.getColumnCount();
             int size = rs.getRow();
            while(rs.next()){
                String[] fields = new String[cols];
                //int col= 0;
                //遍历所有列的数据，并存在字符数组中
                for (int i=0;i<cols;i++)
                    fields[i] = rs.getString(i);

                recodes.add(fields);
            }

            rs.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();
        }


    }

    /**
     *list<object>转化成为 object[][]
     */
    public Object[][] listToArray(List<Object[]> list){
        Object [][] results= new Object[list.size()][];
        //设置值
        for (int i = 0 ; i<list.size();i++){
            //厉害了，对象直接一行  复制给二维数组
            results[i] = list.get(i);
        }
        return results;
    }

    /**
     * list<object> 转化Iterator
     */
    public Iterator<Object[]> listToIterator(List<Object[]> list){
        return list.iterator() ;
    }

    @Test
    public void testDataBase(){
        getMysqlJDBC("quan");
    }
}
