package 操作数据库类;

/*
 *  项目连接数据库
 *  2017 12 2
 */

import java.sql.*; //引用Connection类 

public class 获得连接 {
	private Connection ct; // 定义 连接类 对象ct
	private String user = "sa";
	private String password = "wxS246";
	/*
	 * 连接数据库驱动的地址，引用项目文件中 Referenced Libraries 下sqljdbc.jar文件
	 * 中com.microsoft.sqlserver.jdbc包中SQLServerDriver类
	 */
	private String jdbcName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String dataBaseUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=芗客隆超市数据库"; // 本项目数据库的地址

	/*
	 * 构造方法中连接数据库驱动
	 */
	public 获得连接() {// 连接数据库驱动
		try {
			Class.forName(jdbcName);
			System.out.println("数据库驱动加载成功！");
		} catch (ClassNotFoundException notExcept) {
			System.out.println("数据库驱动加载失败！");
			notExcept.printStackTrace();
		}
	}

	/*
	 * 数据库连接
	 */
	public Connection getCon() {
		try {
			ct = DriverManager.getConnection(dataBaseUrl, user, password);
			System.out.println("数据库连接创建成功！");
		} catch (SQLException sqlExcept) {
			System.out.println("创建数据库连接失败！");
			ct = null;
			sqlExcept.printStackTrace();
		}
		return ct; // 如果没有报错,获得 连接类 对象ct的值（ct的值就是连接进入的数据库）
	}
}
