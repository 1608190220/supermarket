package �������ݿ���;

/* 
 * ��Ŀ��¼ʱ����ȡ������û������룬ͨ��SQL������ж�
 * �Ƿ�������ȷ�����������ݿ��ѯ �û��� ��Ϣ
 * 2017 12 2
 */

import java.sql.*; //���� Connection��
import �����ݿ����Ӧ��javabasedata.�û�; //���� �û���

public class �����û� {
	������� connection = new �������(); // ����������һ�� ��������� �Ķ���connection
	Connection con = null;

	/*
	 * ���һ�� �û��� ���󣬰��û��������ѯ�û��ķ���
	 */
	public �û� getUser(String userName, String passWord) {
		�û� user = new �û�();
		con = connection.getCon(); // ��ȡ���ݿ�����

		try {
			String sql = "select * from �û���Ϣ�� where userName=? and passWord=?"; // �����ѯ�û��������Ԥ�������
			PreparedStatement pState = con.prepareStatement(sql); // ʵ���� ׼�������� �Ķ���pState
			pState.setString(1, userName); // 1�Ų���
			pState.setString(2, passWord); // 2�Ų���
			ResultSet res = pState.executeQuery(); // ִ��Ԥ�������
			while (res.next()) {
				user.setId(res.getInt(1)); // �����ݿ� �û��� �л�÷���������Ԫ���id
				user.setUserName(res.getString(2)); // ��ø�Ԫ���userName���������ڽ�����ʾ�û���
				// user.setPassWord(res.getString(3)); ����Ҫ�������
			}
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
		return user;
	}
}
