package ��Ŀ����ı��ģ��;

/*
 * ��Ӧ�� ���ģ��
 * ��ʾ�������
 * 2017 12 9
 */

public class ��Ӧ�̱��ģ�� extends javax.swing.table.DefaultTableModel { // �̳� ���洢ģ����
	Class[] types = new Class[] { java.lang.String.class, java.lang.String.class, java.lang.String.class,
			java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,
			java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class };
	boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false, false };

	public ��Ӧ�̱��ģ��() {
		// ֱ�ӵ��ø��� DefaultTableModel ���췽��������һ����Ӧ�̱��
		super(new Object[][] {},
				new String[] { "���", "�ͻ�����", "��ַ", "��ϵ��", "��ϵ�绰", "����", "�ʱ�", "�����˺�", "��ַ", "Emall��ַ", "��ע" });
	}
}
