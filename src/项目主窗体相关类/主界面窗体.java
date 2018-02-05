package 项目主窗体相关类;

/*
 * 项目 主界面窗体 中各个面板设置
 * 2017 12 4
 */

import java.awt.*; 
import javax.swing.*; //引用 JPanel类
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.awt.event.*; //引用 ActionListener类
import java.text.SimpleDateFormat;
import java.util.Date;
import 工具类包.会话;
import 与数据库相对应的javabasedata.用户;
import 项目中各子模块所需面板.供应商面板;
import 项目中各子模块所需面板.仓库入库面板;
import 项目中各子模块所需面板.BG面板;
import 项目中各子模块所需面板.主界面窗体面板;
import 项目中特殊面板.反应按钮;

public class 主界面窗体 extends JFrame {
	private JTree tree;
	private Font font;
	private ButtonGroup buttonGroup = null; // 使用 javax.swing.ButtonGroup 类，将按钮组合
	private JScrollPane scrollPane; //存放 树 的卷轴面板

	private JPanel smallBGPanel = new JPanel();  //创建 小展示面板
	private BG面板 BGPanel; //定义 展示面板
	private JPanel unionPanel = null;//按钮拼接面板
	private 供应商面板 providePanel = new 供应商面板();
	private 主界面窗体面板 mainPane;

	private JLabel change_label = new JLabel("基本档案管理"); //位置信息标签 创建并赋值
	private JLabel whereLabel = new JLabel("当前位置是："); // 展示面板 上的标签
	private JLabel welcomelabel;
	private JLabel time;

	private 反应按钮 workSpaceButton = null; //基本档案管理 按钮
	private 反应按钮 bookProjectButton = null;//仓库入库 按钮
	private 反应按钮 progressButton = null; //摆设按钮
	private 反应按钮 personnelManagerButton = null; //摆设按钮 
	private 反应按钮 deptManagerButton = null; //摆设按钮

	/*
	 * 创建主界面窗体
	 */
	public 主界面窗体() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 923, 625); 
		mainPane = new 主界面窗体面板(); 
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPane); 
		setTitle("芗客隆超市管理系统");
		mainPane.setLayout(null); 
		setResizable(false); 
		setLocationRelativeTo(null); // 窗体居中

		// 添加 窗口上方的 小滚轴面板
		mainPane.add(unionJPanel());

		// 主界面窗口左侧 欢迎标签
		用户 user = 会话.getUser(); // 获取登录用户对象的用户名
		font = new Font("楷体", 1, 20); // 字体，风格，大小
		String tip = "你好：" + user.getUserName() + " 欢迎登陆！";
		welcomelabel = new JLabel(tip);
		welcomelabel.setFont(font);
		welcomelabel.setBounds(35, 220, 228, 35);
		mainPane.add(welcomelabel);

		// 显示系统时间
		// 设置Timer 每过1s实现一次动作 是一个线程
		time = new JLabel();
		Timer timeAction = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long timemillis = System.currentTimeMillis();// 64位有符号的Java原始数据类型,精度大于int
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				time.setText(df.format(new Date(timemillis)));
			}
		});
		timeAction.start();
		font = new Font("楷体", 1, 18);
		time.setFont(font);
		time.setBounds(35, 265, 228, 35);
		mainPane.add(time);

		mainPane.add(getContentPanel()); // 添加右下方 卡其色 展示面板
	}

	/*
	 * 设置 主界面窗口 中的 展示面板
	 */
	private BG面板 getContentPanel() {
		if (BGPanel == null) // 如果没有展示面板
		{
			//  设置展示面板
			BGPanel = new BG面板();
			BGPanel.setBackground(new Color(255, 228, 181));
			BGPanel.setBounds(279, 149, 629, 416); // 设置主界面窗口中 展示面板 大小和位置
			BGPanel.setLayout(null);

			whereLabel.setBounds(50, 35, 96, 15); // “当前位置” 标签
			BGPanel.add(whereLabel);
			
			change_label.setBounds(150, 35, 123, 15); // 位置信息标签
			BGPanel.add(change_label);
			
			//  设置 展示面板 上的 小展示面板
			smallBGPanel.setBounds(10, 63, 611, 343);
			smallBGPanel.setLayout(null);
			BGPanel.add(smallBGPanel);
			
			//设置 树 放置的面板
			scrollPane = new JScrollPane();
			scrollPane.setBackground(new Color(71, 201, 223));
			scrollPane.setBounds(0, 0, 138, 354);
			smallBGPanel.add(scrollPane);

			/*
			 * 用 树 来保存列表信息
			 * DefaultMutableTreeNode 构建树通用结点
			 */
			DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("基本档案管理");
			DefaultMutableTreeNode childNode1 = new DefaultMutableTreeNode("供应商管理");
			DefaultMutableTreeNode childNode2 = new DefaultMutableTreeNode("XXX");
			DefaultMutableTreeNode childNode3 = new DefaultMutableTreeNode("XXX");
			DefaultMutableTreeNode childNode4 = new DefaultMutableTreeNode("XXX");
			rootNode.add(childNode1);
			rootNode.add(childNode2);
			rootNode.add(childNode3);
			rootNode.add(childNode4);
			tree = new JTree(rootNode);
			scrollPane.setColumnHeaderView(tree);
			JPanel smallProvidePanel = new JPanel();//浅蓝色 小供应商面板
			smallProvidePanel.setBackground(new Color(255, 228, 181));
			smallProvidePanel.setBounds(138, 0, 473, 343);
			smallProvidePanel.setLayout(null);
			smallBGPanel.add(smallProvidePanel);
			tree.addTreeSelectionListener(new TreeSelectionListener() {
				public void valueChanged(TreeSelectionEvent e) {
					if (!tree.isSelectionEmpty()) {
						TreePath selectionPaths = tree.getSelectionPath();
						Object path = selectionPaths.getLastPathComponent();
						DefaultMutableTreeNode node = (DefaultMutableTreeNode) path;
						String userObject = (String) node.getUserObject();
						repaint();
						if (userObject.equals("供应商管理")) {//只有 供货商管理 这一个结点
							change_label.setText("供应商管理");
							smallProvidePanel.removeAll();
							smallProvidePanel.add(providePanel.getProvidePanel());
						}
					}
				}
			});
		}
		return BGPanel;
	}

	 //将多个 按钮图片 拼接到 unionPanel面板 中
	public JPanel unionJPanel() {
		if (unionPanel == null) {
			GridLayout gridLayout = new GridLayout(); // 定义网格布局管理器
			gridLayout.setRows(1); // 设置网格布局管理器的行数
			gridLayout.setHgap(0); // 设置组件间水平间距
			gridLayout.setVgap(0); // 设置组件间垂直间距
			unionPanel = new BG面板(); 
			// 设置主界面窗口中 拼接按钮面板 大小和位置
			unionPanel.setBounds(280, 1, 349, 116); 
			// 设置布局管理器
			unionPanel.setLayout(gridLayout);
			// 设置初始大小
			unionPanel.setPreferredSize(new Dimension(400, 50));
			unionPanel.setOpaque(false);
			// 添加按钮
			unionPanel.add(getWorkSpaceButton(), null); // 添加基本档案管理按钮
			unionPanel.add(getrukuButton(), null); // 添加入库按钮
			unionPanel.add(getProgressButton(), null); // 添加采购订单摆设按钮
			unionPanel.add(getPersonnelManagerButton(), null); // 添加人员管理摆设按钮
			unionPanel.add(getDeptManagerButton(), null); // 添加部门管理摆设按钮
			if (buttonGroup == null) {
				buttonGroup = new ButtonGroup();
			}
			// 把所有按钮添加到一个组控件中
			buttonGroup.add(getWorkSpaceButton());
			buttonGroup.add(getrukuButton());
			buttonGroup.add(getProgressButton());
			buttonGroup.add(getPersonnelManagerButton());
			buttonGroup.add(getDeptManagerButton());
		}
		return unionPanel;
	}
	// 基本档案管理按钮
	private 反应按钮 getWorkSpaceButton() {
		if (workSpaceButton == null) {
			workSpaceButton = new 反应按钮();
			workSpaceButton.setActionCommand("基本档案管理"); // 设置按钮的动作命令
			workSpaceButton.setIcon(new ImageIcon(getClass().getResource("/项目所需图片文件/基本档案1.png"))); 
			ImageIcon icon = new ImageIcon(getClass().getResource("/项目所需图片文件/基本档案2.png"));
			workSpaceButton.setRolloverIcon(icon); // 设置按钮的翻转图片
			workSpaceButton.setSelectedIcon(icon); // 设置按钮被选中时显示图片
			workSpaceButton.setSelected(true);
			workSpaceButton.addActionListener(new toolsButtonActionAdapter()); // 按钮的监听器
		}
		return workSpaceButton;
	}
	// 采购进货管理按钮
	private 反应按钮 getProgressButton() {
		if (progressButton == null) {
			progressButton = new 反应按钮();
			progressButton.setActionCommand("采购进货");
			progressButton.setText("");
			progressButton.setIcon(new ImageIcon(getClass().getResource("/项目所需图片文件/采购1.png")));
			ImageIcon icon = new ImageIcon(getClass().getResource("/项目所需图片文件/采购2.png"));
			progressButton.setRolloverIcon(icon);
			progressButton.setSelectedIcon(icon);
		}
		return progressButton;
	}
	// 部门管理系统
	private 反应按钮 getDeptManagerButton() {
		if (deptManagerButton == null) {
			deptManagerButton = new 反应按钮();
			ImageIcon imageIcon = new ImageIcon(getClass().getResource("/项目所需图片文件/deptButton.png"));
			deptManagerButton.setIcon(imageIcon);
			ImageIcon icon = new ImageIcon(getClass().getResource("/项目所需图片文件/deptButton2.png"));
			deptManagerButton.setRolloverIcon(icon);
			deptManagerButton.setSelectedIcon(icon);
		}
		return deptManagerButton;
	}
	// 仓库入库管理
	private 反应按钮 getrukuButton() {
		if (bookProjectButton == null) {
			bookProjectButton = new 反应按钮();
			bookProjectButton.setIcon(new ImageIcon(getClass().getResource("/项目所需图片文件/入库1.png")));
			ImageIcon icon = new ImageIcon(getClass().getResource("/项目所需图片文件/入库2.png"));
			bookProjectButton.setSelectedIcon(icon);
			bookProjectButton.setRolloverIcon(icon);
			bookProjectButton.addActionListener(new toolsButtonActionAdapter());
		}
		return bookProjectButton;
	}
	// 人员管理系统
	private 反应按钮 getPersonnelManagerButton() {
		if (personnelManagerButton == null) {
			personnelManagerButton = new 反应按钮();
			ImageIcon imageIcon = new ImageIcon(getClass().getResource("/项目所需图片文件/person2.png"));
			personnelManagerButton.setIcon(imageIcon);
			ImageIcon icon = new ImageIcon(getClass().getResource("/项目所需图片文件/person1.png"));
			personnelManagerButton.setRolloverIcon(icon);
			personnelManagerButton.setSelectedIcon(icon);
		}
		return personnelManagerButton;
	}

	// 小滚轴面板 上全部 图标按钮 的响应事件
	class toolsButtonActionAdapter implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == workSpaceButton) {
				BGPanel.removeAll();//清理 展示面板上的组件
				
				smallBGPanel.setBounds(10, 63, 611, 376);
				
				change_label.setBounds(150, 35, 123, 15);
				change_label.setText("基本档案管理");
				
				BGPanel.add(whereLabel);
				BGPanel.add(smallBGPanel);
				BGPanel.add(change_label);
				
				repaint();
			}
			if (e.getSource() == bookProjectButton) {
				BGPanel.removeAll();
				
				smallBGPanel.setBounds(10, 63, 611, 386);

				change_label.setBounds(150, 35, 123, 15);
				change_label.setText("仓库入库");
				
				仓库入库面板 joinPanel = new 仓库入库面板();
				BGPanel.add(joinPanel);
				BGPanel.add(whereLabel);
				BGPanel.add(change_label);
				
				repaint();
			}
		}
	}
}
