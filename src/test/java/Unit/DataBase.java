package Unit;

import Module.Quan;
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
    public static Iterator<Object[]> getMysqlJDBC(String table){

        String url = "jdbc:mysql://localhost:3306/jd";
        String user = "root";
        String password ="123456";
        Connection conn;

        List<Quan> quans = new ArrayList<>();
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

               // Quan quan = new Quan();
                int id = rs.getInt(rs.findColumn("id"));
                String ticket_name = rs.getString(rs.findColumn("ticket_name"));

                int type = rs.getInt(rs.findColumn("type"));
                float progress =rs.getFloat(rs.findColumn("progress"));
                Boolean is_have =rs.getBoolean(rs.findColumn("is_have"));
                int limit = rs.getInt(rs.findColumn("limit"));
                int price = rs.getInt(rs.findColumn("price"));
/*                quan.setId(id);
                quan.setTicket_name(ticket_name);
                quan.setType(type);
                quan.setProgress(progress);
                quan.setIs_have(is_have);
                quan.setLimit(limit);
                quan.setPrice(price);
                quans.add(quan);*/
            }

            rs.close();
            conn.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
        return  listToIterator(quans);


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
     * @param datas
     */
    public static Iterator<Object[]> listToIterator(List<Quan> datas){

        List<Object[]>  list  = new ArrayList<>();
        for (Object o:datas) {
            list.add(new Object[]{o});

        }return list.iterator() ;

    }

    @Test
    public void testDataBase(){
        //暂时不用数据库实现优惠券的功能
        getMysqlJDBC("quan");
    }
}
