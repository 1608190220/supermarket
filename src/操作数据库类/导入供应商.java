package �������ݿ���;

/*
 * ��Ӧ�̱������������ݿ�Ĳ���
 * 2017 12 9
 */

import java.sql.*;
import java.util.*;
import �����ݿ����Ӧ��javabasedata.��Ӧ��;

public class ���빩Ӧ�� {
	������� connection = new �������(); // �������ݿ�����
	Connection conn = null;

	// ���� ��ӹ�Ӧ�̷���
	public void insertProvide(��Ӧ�� provide) {
		conn = connection.getCon();
		try {
			PreparedStatement statement = conn.prepareStatement("insert into ��Ӧ����Ϣ�� values(?,?,?,?,?,?,?,?,?,?,?)");
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
			System.out.println("��������Ϣ���ʧ�ܣ�");
			e.printStackTrace();
		}
	}

	// ��д����Ų�ѯ��Ӧ����Ϣ����
	public ��Ӧ�� selectProvideByid(int id) {
		��Ӧ�� provide = new ��Ӧ��();
		conn = connection.getCon();

		try {
			Statement statement = conn.createStatement();
			String sql = "select * from ��Ӧ����Ϣ�� where id = " + id;
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
			System.out.println("�����̱�Ų�ѯʧ�ܣ�");
			e.printStackTrace();
		}
		return provide;
	}

	// �����ѯ ��Ӧ�̱�� ��ȫ�����ݵķ���
	public List selectProvide() {
		// ����List�������ģ�彨��һ�� ��Ӧ���� �Ķ�������
		List list = new ArrayList<��Ӧ��>();
		conn = connection.getCon();

		try {
			Statement statement = conn.createStatement();
			ResultSet rest = statement.executeQuery("select * from ��Ӧ����Ϣ��");
			while (rest.next()) {
				��Ӧ�� pro = new ��Ӧ��();
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
			System.out.println("������ȫ����Ϣ��ѯʧ�ܣ�");
			e.printStackTrace();
		}
		return list;
	}

	// ���尴�ͻ���ַ��ѯ��Ӧ����Ϣ����
	public List selectProvideByAddress(String address) {
		��Ӧ�� provide = new ��Ӧ��();
		conn = connection.getCon();
		List list = new ArrayList<��Ӧ��>();

		try {
			Statement statement = conn.createStatement();
			String sql = "select * from ��Ӧ����Ϣ�� where address = '" + address + "'";
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
			System.out.println("�����̵�ַ��ѯʧ�ܣ�");
			e.printStackTrace();
		}
		return list;
	}

	// ���尴�ͻ����Ʋ�ѯ��Ӧ����Ϣ����
	public List selectProvideByName(String name) {

		conn = connection.getCon();
		List list = new ArrayList<��Ӧ��>();
		try {
			Statement statement = conn.createStatement();
			String sql = "select * from ��Ӧ����Ϣ�� where cName = '" + name + "'";
			ResultSet rest = statement.executeQuery(sql);
			while (rest.next()) {
				��Ӧ�� provide = new ��Ӧ��();
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
			System.out.println("�����̿ͻ����Ʋ�ѯʧ�ܣ�");
			e.printStackTrace();
		}
		return list;
	}

	// ���尴�ͻ����ƺͿͻ���ַ��ѯ��Ӧ����Ϣ����
	public List selectProvideByNameAddress(String address, String name) {
		��Ӧ�� provide = new ��Ӧ��();
		conn = connection.getCon();
		List list = new ArrayList<��Ӧ��>();

		try {
			Statement statement = conn.createStatement();
			String sql = "select * from ��Ӧ����Ϣ�� where cName = '" + name + "' and address = '" + address + "'";
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
			System.out.println("�����̿ͻ����Ƶ�ַ��ѯʧ�ܣ�");
			e.printStackTrace();
		}
		return list;
	}

	// �����޸Ĺ�Ӧ����Ϣ����
	public void updateProvide(��Ӧ�� provide) {
		conn = connection.getCon();
		try {
			String sql = "update ��Ӧ����Ϣ�� set cName = ?,address = ?,linkman = ?,linkPhone=?,faxes=?,postNum=?,"
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
			System.out.println("��������Ϣ�޸�ʧ�ܣ�");
			e.printStackTrace();
		}
	}

	// ����ɾ����Ӧ����Ϣ����
	public void deleteProvide(int id) {
		conn = connection.getCon();
		String sql = "delete from ��Ӧ����Ϣ�� where id =" + id;
		try {
			Statement statement = conn.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("��������Ϣɾ��ʧ�ܣ�");
			e.printStackTrace();
		}
	}
}
