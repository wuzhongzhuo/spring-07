package java0224;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
		public static void main(String[] args) {
			//格式jdbc:mysql://主机IP:端口号/数据库名
			String url="jdbc:mysql://192.168.59.130:3306/mysql1";
			String user="root";
			String password="123456";
			
			//提升作用域的方式
			Connection con =null;
			PreparedStatement pStt =null;
			ResultSet rs =null;
			//选择要操作的数据库种类----加载驱动（反射）
			try {
				Class.forName("com.mysql.jdbc.Driver.class");
				//创建主机IP 端口号   用户名  密码(返回什么就用什么接收)//选择要操作的数据库
				con = DriverManager.getConnection(url, user, password);
				//创建命令窗口（写sql语句）
				pStt = con.prepareStatement("select * from student1");
				//运行sql语句并查看结果，如果是增删改，则返回的是受影响的行数，
				//如果查询的是返回的结果
				//运行的时候注意  如果是增删改则调用executeUpdate 返回int，如果是查询则调用executeQuery,返回resultSet(无序去重)
				rs = pStt.executeQuery();
				//查看结果集
				while(rs.next()) {
					System.out.println(rs.getInt("id")+" "+rs.getString("name"));
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//创建主机IP 端口号   用户名  密码
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if(rs!=null)
						rs.close();
					if(pStt!=null)
						pStt.close();
					if(con!=null)
						con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}
}
