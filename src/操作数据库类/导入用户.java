package 操作数据库类;

/* 
 * 项目登录时，获取输入的用户名密码，通过SQL语句来判断
 * 是否输入正确，并连接数据库查询 用户表 信息
 * 2017 12 2
 */

import java.sql.*; //引用 Connection类
import 与数据库相对应的javabasedata.用户; //引用 用户类

public class 导入用户 {
	获得连接 connection = new 获得连接(); // 创建包中另一个 获得连接类 的对象connection
	Connection con = null;

	/*
	 * 获得一个 用户类 对象，按用户名密码查询用户的方法
	 */
	public 用户 getUser(String userName, String passWord) {
		用户 user = new 用户();
		con = connection.getCon(); // 获取数据库连接

		try {
			String sql = "select * from 用户信息表 where userName=? and passWord=?"; // 定义查询用户名密码的预处理语句
			PreparedStatement pState = con.prepareStatement(sql); // 实例化 准备声明类 的对象pState
			pState.setString(1, userName); // 1号参数
			pState.setString(2, passWord); // 2号参数
			ResultSet res = pState.executeQuery(); // 执行预处理语句
			while (res.next()) {
				user.setId(res.getInt(1)); // 从数据库 用户表 中获得符合条件的元组的id
				user.setUserName(res.getString(2)); // 获得该元组的userName，在主窗口界面显示用户名
				// user.setPassWord(res.getString(3)); 不需要获得密码
			}
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
		return user;
	}
}
