package ��Ŀ��¼���������;

/*
 * ��¼���ڱ������
 * 2017 11 27
 */

/*
 * Graphics��������ͼ�������ĵĳ�����ࡣ
 * Graphics��ʹ�õĲ�ͬ�ķ���ʵ�ֲ�ͬ�Ļ���
 */
import java.awt.*; //���� Image Graphics��
import javax.swing.JPanel;

public class ��¼���汳����� extends JPanel {
	private Image image; // ����ͼƬ

	public ��¼���汳�����() {
		setOpaque(false); // ����͸��
		setLayout(null); // ʹ�þ��Զ�λ�������
	}

	public void setImage(Image image) {// ���ñ���ͼƬ����ķ���
		this.image = image;
	}

	protected void paintComponent(Graphics g) {// ���Ʊ�����������ͼƬ���봰��
		if (image != null) {// ���ͼƬ�Ѿ���ʼ��
			g.drawImage(image, 0, 0, this);
		}
		super.paintComponent(g);
	}
}
