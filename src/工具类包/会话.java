package 工具类包;

/*
 *  某些类会话类连接用户
 *  2017 11 30
 */

import 与数据库相对应的javabasedata.用户;

public class 会话 {
	private static 用户 u1; // 会话类中定义一个用户类对象u1

	public static 用户 getUser() {// 获取会话类的u1对象
		return u1;
	}

	public static void setUser(用户 u) {// 将值赋给会话类中的u1对象
		会话.u1 = u;
	}
}
