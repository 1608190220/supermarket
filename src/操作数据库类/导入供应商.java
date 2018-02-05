package 操作数据库类;

/*
 * 供应商表格各项连接数据库的操作
 * 2017 12 9
 */

import java.sql.*;
import java.util.*;
import 与数据库相对应的javabasedata.供应商;

public class 导入供应商 {
	获得连接 connection = new 获得连接(); // 加载数据库驱动
	Connection conn = null;

	// 定义 添加供应商方法
	public void insertProvide(供应商 provide) {
		conn = connection.getCon();
		try {
			PreparedStatement statement = conn.prepareStatement("insert into 供应商信息表 values(?,?,?,?,?,?,?,?,?,?,?)");
			statement.setInt(1, provide.getId());
			statement.setString(2, provide.getcName());
			statement.setString(3, provide.getAddress());
			statement.setString(4, provide.getLinkman());
			statement.setString(5, provide.getLinkPhone());
			statement.setString(6, provide.getFaxes());
			statement.setString(7, provide.getPostNum());
			statement.setString(8, provide.getBankNum());
			statement.setString(9, provide.getNetAddress());
			statement.setString(10, provide.getEmaillAddress());
			statement.setString(11, provide.getRemark());
			statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("供货商信息添加失败！");
			e.printStackTrace();
		}
	}

	// 编写按编号查询供应商信息方法
	public 供应商 selectProvideByid(int id) {
		供应商 provide = new 供应商();
		conn = connection.getCon();

		try {
			Statement statement = conn.createStatement();
			String sql = "select * from 供应商信息表 where id = " + id;
			ResultSet rest = statement.executeQuery(sql);
			while (rest.next()) {
				provide.setId(rest.getInt(1));
				provide.setcName(rest.getString("cName"));
				provide.setAddress(rest.getString("address"));
				provide.setLinkman(rest.getString("linkman"));
				provide.setLinkPhone(rest.getString("linkPhone"));
				provide.setFaxes(rest.getString("faxes"));
				provide.setPostNum(rest.getString("postNum"));
				provide.setBankNum(rest.getString("bankNum"));
				provide.setNetAddress(rest.getString("netAddress"));
				provide.setEmaillAddress(rest.getString("emaillAddress"));
				provide.setRemark(rest.getString("remark"));
			}
		} catch (SQLException e) {
			System.out.println("供货商编号查询失败！");
			e.printStackTrace();
		}
		return provide;
	}

	// 定义查询 供应商表格 中全部数据的方法
	public List selectProvide() {
		// 创建List类对象，用模板建立一个 供应商类 的对象数组
		List list = new ArrayList<供应商>();
		conn = connection.getCon();

		try {
			Statement statement = conn.createStatement();
			ResultSet rest = statement.executeQuery("select * from 供应商信息表");
			while (rest.next()) {
				供应商 pro = new 供应商();
				pro.setId(rest.getInt(1));
				pro.setcName(rest.getString("cName"));
				pro.setAddress(rest.getString("address"));
				pro.setLinkman(rest.getString("linkman"));
				pro.setLinkPhone(rest.getString("linkPhone"));
				pro.setFaxes(rest.getString("faxes"));
				pro.setPostNum(rest.getString("postNum"));
				pro.setBankNum(rest.getString("bankNum"));
				pro.setNetAddress(rest.getString("netAddress"));
				pro.setEmaillAddress(rest.getString("emaillAddress"));
				pro.setRemark(rest.getString("remark"));
				list.add(pro);
			}
		} catch (SQLException e) {
			System.out.println("供货商全部信息查询失败！");
			e.printStackTrace();
		}
		return list;
	}

	// 定义按客户地址查询供应商信息方法
	public List selectProvideByAddress(String address) {
		供应商 provide = new 供应商();
		conn = connection.getCon();
		List list = new ArrayList<供应商>();

		try {
			Statement statement = conn.createStatement();
			String sql = "select * from 供应商信息表 where address = '" + address + "'";
			ResultSet rest = statement.executeQuery(sql);
			while (rest.next()) {
				provide.setId(rest.getInt(1));
				provide.setcName(rest.getString("cName"));
				provide.setAddress(rest.getString("address"));
				provide.setLinkman(rest.getString("linkman"));
				provide.setLinkPhone(rest.getString("linkPhone"));
				provide.setFaxes(rest.getString("faxes"));
				provide.setPostNum(rest.getString("postNum"));
				provide.setBankNum(rest.getString("bankNum"));
				provide.setNetAddress(rest.getString("netAddress"));
				provide.setEmaillAddress(rest.getString("emaillAddress"));
				provide.setRemark(rest.getString("remark"));
				list.add(provide);
			}
		} catch (SQLException e) {
			System.out.println("供货商地址查询失败！");
			e.printStackTrace();
		}
		return list;
	}

	// 定义按客户名称查询供应商信息方法
	public List selectProvideByName(String name) {

		conn = connection.getCon();
		List list = new ArrayList<供应商>();
		try {
			Statement statement = conn.createStatement();
			String sql = "select * from 供应商信息表 where cName = '" + name + "'";
			ResultSet rest = statement.executeQuery(sql);
			while (rest.next()) {
				供应商 provide = new 供应商();
				provide.setId(rest.getInt(1));
				provide.setcName(rest.getString("cName"));
				provide.setAddress(rest.getString("address"));
				provide.setLinkman(rest.getString("linkman"));
				provide.setLinkPhone(rest.getString("linkPhone"));
				provide.setFaxes(rest.getString("faxes"));
				provide.setPostNum(rest.getString("postNum"));
				provide.setBankNum(rest.getString("bankNum"));
				provide.setNetAddress(rest.getString("netAddress"));
				provide.setEmaillAddress(rest.getString("emaillAddress"));
				provide.setRemark(rest.getString("remark"));
				list.add(provide);
			}
		} catch (SQLException e) {
			System.out.println("供货商客户名称查询失败！");
			e.printStackTrace();
		}
		return list;
	}

	// 定义按客户名称和客户地址查询供应商信息方法
	public List selectProvideByNameAddress(String address, String name) {
		供应商 provide = new 供应商();
		conn = connection.getCon();
		List list = new ArrayList<供应商>();

		try {
			Statement statement = conn.createStatement();
			String sql = "select * from 供应商信息表 where cName = '" + name + "' and address = '" + address + "'";
			ResultSet rest = statement.executeQuery(sql);
			while (rest.next()) {
				provide.setId(rest.getInt(1));
				provide.setcName(rest.getString("cName"));
				provide.setAddress(rest.getString("address"));
				provide.setLinkman(rest.getString("linkman"));
				provide.setLinkPhone(rest.getString("linkPhone"));
				provide.setFaxes(rest.getString("faxes"));
				provide.setPostNum(rest.getString("postNum"));
				provide.setBankNum(rest.getString("bankNum"));
				provide.setNetAddress(rest.getString("netAddress"));
				provide.setEmaillAddress(rest.getString("emaillAddress"));
				provide.setRemark(rest.getString("remark"));
				list.add(provide);
			}
		} catch (SQLException e) {
			System.out.println("供货商客户名称地址查询失败！");
			e.printStackTrace();
		}
		return list;
	}

	// 定义修改供应商信息方法
	public void updateProvide(供应商 provide) {
		conn = connection.getCon();
		try {
			String sql = "update 供应商信息表 set cName = ?,address = ?,linkman = ?,linkPhone=?,faxes=?,postNum=?,"
					+ " bankNum=?,netAddress=?,emaillAddress=?,remark=? where id =?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, provide.getcName());
			statement.setString(2, provide.getAddress());
			statement.setString(3, provide.getLinkman());
			statement.setString(4, provide.getLinkPhone());
			statement.setString(5, provide.getFaxes());
			statement.setString(6, provide.getPostNum());
			statement.setString(7, provide.getBankNum());
			statement.setString(8, provide.getNetAddress());
			statement.setString(9, provide.getEmaillAddress());
			statement.setString(10, provide.getRemark());
			statement.setInt(11, provide.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("供货商信息修改失败！");
			e.printStackTrace();
		}
	}

	// 定义删除供应商信息方法
	public void deleteProvide(int id) {
		conn = connection.getCon();
		String sql = "delete from 供应商信息表 where id =" + id;
		try {
			Statement statement = conn.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("供货商信息删除失败！");
			e.printStackTrace();
		}
	}
}
