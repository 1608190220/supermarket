package ��Ŀ����ı��ģ��;

/*
 * �ֿ���� ��� ģ��
 * ��ʾ�������
 * 2017 12 10
 */

public class �ֿ������ģ�� extends javax.swing.table.DefaultTableModel {// ��class�ཨģ������Ԫ�ض���String����
	Class[] types = new Class[] { java.lang.String.class, java.lang.String.class, java.lang.String.class,
			java.lang.String.class, java.lang.String.class };
	boolean[] canEdit = new boolean[] { false, false, false, false, false };

	public �ֿ������ģ��() {
		// ֱ�ӵ��ø��� DefaultTableModel ���췽��������һ����Ӧ�̱��
		super(new Object[][] {}, new String[] { "���", "��Ʒ����", "���ʱ��", "����", "��ע" });
	}
}
