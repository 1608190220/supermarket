package ��Ŀ���������;

/*
 * С������� �� �� ��ť
 * 2017 12 9
 */

import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import javax.swing.*;

public class ��Ӧ��ť extends JToggleButton implements Serializable {//�̳� �л���ť�ࡣ���л��ӿڣ��̳нӿڵ�������л�
	private boolean paintFlag = false;

	public ��Ӧ��ť() {
		addMouseListener(new MouseRollListener());
		initialize();
	}
	
	private final class MouseRollListener extends MouseAdapter implements Serializable {//�ж�����Ƿ���ͼ����
		public void mouseExited(MouseEvent e) { //��겻��ͼ����
			paintFlag = false;
			repaint();
		}
		public void mouseEntered(MouseEvent e) { //�����ͼ����
			paintFlag = true;
			repaint();
		}
	}

	/*
	 * ��ʼ�� ��Ӧ��ť�� �ķ���
	 */
	private void initialize() {
		this.setBorderPainted(false);//ȡ����ť�߽�
		this.setSize(new Dimension(168, 136));//�����л���ť��С
		this.setContentAreaFilled(false);//����ť���ó�͸����
		this.setMargin(new Insets(0, 0, 0, 0));//���ð�ť��Ե
		this.setIconTextGap(0);//����ͼ��֮��ļ�϶Ϊ0
	}
}
