package ��Ŀ�и���ģ���������;

/*
 * �����洰�� ������ �����
 * �� �����洰�� �ı���ͼƬ����
 * 2017 12 6
 */

import java.awt.*; //���� Graphics��
import java.net.*;
import javax.swing.*; //���� ImageIcon��

public class �����洰����� extends JPanel {
	public void paintComponent(Graphics g) {
		try {
			URL url = getClass().getResource("/��Ŀ����ͼƬ�ļ�/�����洰�屳��.jpg"); // ��ȡ�����洰�屳��ͼƬ��·��
			ImageIcon imageI = new ImageIcon(url);
			g.drawImage(imageI.getImage(), 0, 0, this);
		} catch (Exception e) {
			System.out.println("�����洰�屳������ʧ�ܣ�");
			e.printStackTrace();
		}
	}
}
