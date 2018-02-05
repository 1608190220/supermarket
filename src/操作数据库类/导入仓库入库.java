package �������ݿ���;

/*
 * �ֿ���� ���ݿ����
 * 2017 12 10
 */

import java.sql.*;
import java.util.*;
import �����ݿ����Ӧ��javabasedata.�ֿ����;;

public class ����ֿ���� {
	// ������Ӳֿ���Ϣ����
	������� connection = new �������();
	Connection conn = null;

	// ��ֿ��������������
	public void insertJoinDepot(�ֿ���� joinDepot) {
		conn = connection.getCon();
		PreparedStatement statement=null;
		
		try {
			statement = conn.prepareStatement("insert into �ֿ����� values(?,?,?,?,?)");
			statement.setInt(1, joinDepot.getId());
			statement.setString(2, joinDepot.getWareName());
			statement.setString(3, joinDepot.getJoinTime());
			statement.setFloat(4, joinDepot.getWeight());
			statement.setString(5, joinDepot.getRemark());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}/*finally {
			if(statement!=null) {
				try {
					statement.close();
				}catch(SQLException e) {}
			}
			if(conn!=null) {
				try {
					conn.close();
					System.out.println("���ݿ����ӶϿ���");
				}catch(SQLException e) {}
			}
		}*/
	}

	// �����ѯ�ֿ�������ȫ�����ݷ���
	public List selectJoinDepot() {
		List list = new ArrayList<�ֿ����>();
		conn = connection.getCon();
		
		try {
			Statement statement = conn.createStatement();
			ResultSet rest = statement.executeQuery("select * from �ֿ�����");
			while (rest.next()) {
				�ֿ���� depot = new �ֿ����();
				depot.setId(rest.getInt("id"));
				depot.setWareName(rest.getString("wareName"));
				depot.setJoinTime(rest.getString("joinTime"));
				depot.setWeight(rest.getShort("weight"));
				depot.setRemark(rest.getString("remark"));
				list.add(depot);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	// ���尴�ֿ����ʱ���ѯ����
	public List selectJoinDepot(String joinTime) {
		conn = connection.getCon();
		List list = new ArrayList<�ֿ����>();
		try {
			Statement statement = conn.createStatement();
			String sql = "select * from �ֿ����� where joinTime = '" + joinTime + "'";
			ResultSet rest = statement.executeQuery(sql);
			while (rest.next()) {
				�ֿ���� depot = new �ֿ����();
				depot.setId(rest.getInt(1));
				depot.setWareName(rest.getString("wareName"));
				depot.setJoinTime(rest.getString("joinTime"));
				depot.setWeight(rest.getShort("weight"));
				depot.setRemark(rest.getString("remark"));
				list.add(depot);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// ����ɾ���ֿ���� ��Ϣ
	public void deleteJoinDepot(int id) {
		conn = connection.getCon();
		String sql = "delete from �ֿ����� where id =" + id;
		try {
			Statement statement = conn.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
