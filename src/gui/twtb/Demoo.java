package gui.twtb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demoo {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "insert into hero1 values(null,?,?,?)";
        try (
                //Connection
                Connection c = DriverManager.getConnection("jdbc:mysql://39.102.42.170:3306/twtb_database?characterEncoding=UTF-8",
                        "root", "12345678");
                //sql语句创建PreparedStatement
                PreparedStatement ps = c.prepareStatement(sql);
        )
                //设置参数
        {
            ps.setString(1,"提莫");
            ps.setFloat(2,3130f);
            ps.setInt(3,40);
            //执行
            ps.execute();

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
