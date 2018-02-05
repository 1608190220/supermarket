package 项目中各子模块所需面板;

/*
 * 主窗体右下方的 展示面板 模型
 * 卡其色面板
 * 2017 12 8
 */

import java.awt.*;
import java.io.Serializable;
import javax.swing.*;

public class BG面板 extends JPanel implements Serializable {
	// 构造方法
	public BG面板() {
		super();
		initialize();
	}

	// 初始化方法
	private void initialize() {
		this.setSize(new Dimension(300, 200)); // 设置面积
		this.setLayout(new GridBagLayout()); // 设置布局
	}
}
