package 项目中特殊面板;

/*
 * 小滚轴面板 上 的 按钮
 * 2017 12 9
 */

import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import javax.swing.*;

public class 反应按钮 extends JToggleButton implements Serializable {//继承 切换按钮类。序列化接口，继承接口的类可序列化
	private boolean paintFlag = false;

	public 反应按钮() {
		addMouseListener(new MouseRollListener());
		initialize();
	}
	
	private final class MouseRollListener extends MouseAdapter implements Serializable {//判断鼠标是否在图标上
		public void mouseExited(MouseEvent e) { //鼠标不在图标上
			paintFlag = false;
			repaint();
		}
		public void mouseEntered(MouseEvent e) { //鼠标在图标上
			paintFlag = true;
			repaint();
		}
	}

	/*
	 * 初始化 反应按钮类 的方法
	 */
	private void initialize() {
		this.setBorderPainted(false);//取消按钮边界
		this.setSize(new Dimension(168, 136));//设置切换按钮大小
		this.setContentAreaFilled(false);//将按钮设置成透明的
		this.setMargin(new Insets(0, 0, 0, 0));//设置按钮边缘
		this.setIconTextGap(0);//设置图标之间的间隙为0
	}
}
