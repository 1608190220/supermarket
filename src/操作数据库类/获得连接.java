package �������ݿ���;

/*
 *  ��Ŀ�������ݿ�
 *  2017 12 2
 */

import java.sql.*; //����Connection�� 

public class ������� {
	private Connection ct; // ���� ������ ����ct
	private String user = "sa";
	private String password = "wxS246";
	/*
	 * �������ݿ������ĵ�ַ��������Ŀ�ļ��� Referenced Libraries ��sqljdbc.jar�ļ�
	 * ��com.microsoft.sqlserver.jdbc����SQLServerDriver��
	 */
	private String jdbcName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String dataBaseUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=ܼ��¡�������ݿ�"; // ����Ŀ���ݿ�ĵ�ַ

	/*
	 * ���췽�����������ݿ�����
	 */
	public �������() {// �������ݿ�����
		try {
			Class.forName(jdbcName);
			System.out.println("���ݿ��������سɹ���");
		} catch (ClassNotFoundException notExcept) {
			System.out.println("���ݿ���������ʧ�ܣ�");
			notExcept.printStackTrace();
		}
	}

	/*
	 * ���ݿ�����
	 */
	public Connection getCon() {
		try {
			ct = DriverManager.getConnection(dataBaseUrl, user, password);
			System.out.println("���ݿ����Ӵ����ɹ���");
		} catch (SQLException sqlExcept) {
			System.out.println("�������ݿ�����ʧ�ܣ�");
			ct = null;
			sqlExcept.printStackTrace();
		}
		return ct; // ���û�б���,��� ������ ����ct��ֵ��ct��ֵ�������ӽ�������ݿ⣩
	}
}
