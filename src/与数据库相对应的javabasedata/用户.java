package 与数据库相对应的javabasedata;

/*
 *  在javabasedata中模拟数据库中 用户表 ，映射相关属性
 *  2017 11 29
 */

public class 用户 {
	private int id;
	private String userName;
	private String passWord;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
}
