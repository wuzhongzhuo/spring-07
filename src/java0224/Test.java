package java0224;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
		public static void main(String[] args) {
			//��ʽjdbc:mysql://����IP:�˿ں�/���ݿ���
			String url="jdbc:mysql://192.168.59.130:3306/mysql1";
			String user="root";
			String password="123456";
			
			//����������ķ�ʽ
			Connection con =null;
			PreparedStatement pStt =null;
			ResultSet rs =null;
			//ѡ��Ҫ���������ݿ�����----�������������䣩
			try {
				Class.forName("com.mysql.jdbc.Driver.class");
				//��������IP �˿ں�   �û���  ����(����ʲô����ʲô����)//ѡ��Ҫ���������ݿ�
				con = DriverManager.getConnection(url, user, password);
				//��������ڣ�дsql��䣩
				pStt = con.prepareStatement("select * from student1");
				//����sql��䲢�鿴������������ɾ�ģ��򷵻ص�����Ӱ���������
				//�����ѯ���Ƿ��صĽ��
				//���е�ʱ��ע��  �������ɾ�������executeUpdate ����int������ǲ�ѯ�����executeQuery,����resultSet(����ȥ��)
				rs = pStt.executeQuery();
				//�鿴�����
				while(rs.next()) {
					System.out.println(rs.getInt("id")+" "+rs.getString("name"));
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//��������IP �˿ں�   �û���  ����
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
