package 项目中各子模块所需面板;

/*
 * 主界面窗体 中最大的 主面板
 * 将 主界面窗体 的背景图片导入
 * 2017 12 6
 */

import java.awt.*; //引用 Graphics类
import java.net.*;
import javax.swing.*; //引用 ImageIcon类

public class 主界面窗体面板 extends JPanel {
	public void paintComponent(Graphics g) {
		try {
			URL url = getClass().getResource("/项目所需图片文件/主界面窗体背景.jpg"); // 获取主界面窗体背景图片的路径
			ImageIcon imageI = new ImageIcon(url);
			g.drawImage(imageI.getImage(), 0, 0, this);
		} catch (Exception e) {
			System.out.println("主界面窗体背景加载失败！");
			e.printStackTrace();
		}
	}
}
