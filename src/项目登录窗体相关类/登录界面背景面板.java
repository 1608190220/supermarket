package 项目登录窗体相关类;

/*
 * 登录窗口背景面板
 * 2017 11 27
 */

/*
 * Graphics类是所有图形上下文的抽象基类。
 * Graphics类使用的不同的方法实现不同的绘制
 */
import java.awt.*; //导入 Image Graphics类
import javax.swing.JPanel;

public class 登录界面背景面板 extends JPanel {
	private Image image; // 背景图片

	public 登录界面背景面板() {
		setOpaque(false); // 窗体透明
		setLayout(null); // 使用绝对定位布局组件
	}

	public void setImage(Image image) {// 设置背景图片对象的方法
		this.image = image;
	}

	protected void paintComponent(Graphics g) {// 绘制背景，将背景图片导入窗体
		if (image != null) {// 如果图片已经初始化
			g.drawImage(image, 0, 0, this);
		}
		super.paintComponent(g);
	}
}
