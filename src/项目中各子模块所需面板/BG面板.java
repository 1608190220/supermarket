package ��Ŀ�и���ģ���������;

/*
 * ���������·��� չʾ��� ģ��
 * ����ɫ���
 * 2017 12 8
 */

import java.awt.*;
import java.io.Serializable;
import javax.swing.*;

public class BG��� extends JPanel implements Serializable {
	// ���췽��
	public BG���() {
		super();
		initialize();
	}

	// ��ʼ������
	private void initialize() {
		this.setSize(new Dimension(300, 200)); // �������
		this.setLayout(new GridBagLayout()); // ���ò���
	}
}
