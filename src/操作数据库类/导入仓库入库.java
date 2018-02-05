package 操作数据库类;

/*
 * 仓库入库 数据库操作
 * 2017 12 10
 */

import java.sql.*;
import java.util.*;
import 与数据库相对应的javabasedata.仓库入库;;

public class 导入仓库入库 {
	// 定义添加仓库信息方法
	获得连接 connection = new 获得连接();
	Connection conn = null;

	// 向仓库入库表中添加数据
	public void insertJoinDepot(仓库入库 joinDepot) {
		conn = connection.getCon();
		PreparedStatement statement=null;
		
		try {
			statement = conn.prepareStatement("insert into 仓库入库表 values(?,?,?,?,?)");
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
					System.out.println("数据库连接断开！");
				}catch(SQLException e) {}
			}
		}*/
	}

	// 定义查询仓库入库表中全部数据方法
	public List selectJoinDepot() {
		List list = new ArrayList<仓库入库>();
		conn = connection.getCon();
		
		try {
			Statement statement = conn.createStatement();
			ResultSet rest = statement.executeQuery("select * from 仓库入库表");
			while (rest.next()) {
				仓库入库 depot = new 仓库入库();
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

	// 定义按仓库入库时间查询方法
	public List selectJoinDepot(String joinTime) {
		conn = connection.getCon();
		List list = new ArrayList<仓库入库>();
		try {
			Statement statement = conn.createStatement();
			String sql = "select * from 仓库入库表 where joinTime = '" + joinTime + "'";
			ResultSet rest = statement.executeQuery(sql);
			while (rest.next()) {
				仓库入库 depot = new 仓库入库();
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

	// 定义删除仓库入库 信息
	public void deleteJoinDepot(int id) {
		conn = connection.getCon();
		String sql = "delete from 仓库入库表 where id =" + id;
		try {
			Statement statement = conn.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
