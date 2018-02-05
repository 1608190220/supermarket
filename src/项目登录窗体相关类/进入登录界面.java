package 项目登录窗体相关类;

/*
 * 项目的开始，打开登录窗体
 * 2017 11 27
 */

import javax.swing.*; //引用JLabel JTextField JPasswordField JButton类
import javax.swing.border.EmptyBorder; //设置边界的包 空白边界
import java.awt.event.*;
import java.net.URL;
import 工具类包.会话;
import 与数据库相对应的javabasedata.用户;
import 操作数据库类.导入用户;
import 项目主窗体相关类.主界面窗体;

public class 进入登录界面 extends JFrame {
	private 登录界面背景面板 loginPanel;
	
	private JLabel userNameLabel;
	private JLabel passWordLabel;
	private JTextField userNameTextField; 
	private JPasswordField passwordTextField; 
	
	private JButton loginButton;
	
	/*
	 * 打开项目，运行登录界面
	 */
	public static void main(String[] args) {
		进入登录界面 goBegin = new 进入登录界面();
		goBegin.setVisible(true);
	}

	/*
	 * 创建登录窗口框架
	 */
	public 进入登录界面() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 用System exit(0)方法关闭窗口，销毁所有窗口并退出程序
		setResizable(false); // 让登录界面大小不可改变
		setTitle("登录");
		setBounds(0, 0, 559, 285); 
		loginPanel = getLoginPanel();
		loginPanel.setBorder(new EmptyBorder(5, 5, 5, 5)); 
		setContentPane(loginPanel);
		loginPanel.setLayout(null);
		setLocationRelativeTo(null); // 窗体居中
	}

	/*
	 * 初始化登录窗口的面板
	 */
	private 登录界面背景面板 getLoginPanel() {
		if (loginPanel == null) {
			loginPanel = new 登录界面背景面板(); 
			loginPanel.setOpaque(false); // 面板透明
			loginPanel.setImage(getToolkit().getImage(getClass().getResource("/项目所需图片文件/芗客隆超市管理系统登录窗口背景.png"))); // 加载登录窗口的背景图片

			userNameLabel = new JLabel("用户名："); 
			userNameLabel.setBounds(75, 116, 54, 15); 
			loginPanel.add(userNameLabel);
			userNameTextField = new JTextField(); 
			userNameTextField.setBounds(127, 113, 139, 25);
			loginPanel.add(userNameTextField);
			userNameTextField.setColumns(10); // 设置输入字符的宽度为10

			passWordLabel = new JLabel("密  码：");
			passWordLabel.setBounds(75, 158, 54, 15);
			loginPanel.add(passWordLabel);
			passwordTextField = new JPasswordField();
			passwordTextField.setBounds(127, 155, 139, 25);
			loginPanel.add(passwordTextField);

			loginButton = new JButton(); 
			URL urlLogin = getClass().getResource("/项目所需图片文件/登录按钮.png");
			ImageIcon imageI = new ImageIcon(urlLogin); 
			loginButton.setIcon(imageI); 
			loginButton.setBounds(320, 116, imageI.getIconWidth(), imageI.getIconHeight()); // 放置 登录按钮.png
			loginButton.setContentAreaFilled(false); // 取消填充区域
			loginButton.setBorder(null); // 取消边框
			loginPanel.add(loginButton);
			loginButton.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent ae) {
					导入用户 userDao = new 导入用户(); 
					用户 user = userDao.getUser(userNameTextField.getText(), passwordTextField.getText());
					/*
					 * 判断用户输入的用户名密码是否正确
					 */
					if (user.getId() > 0)
					{
						会话.setUser(user); 
						主界面窗体 moveFrame = new 主界面窗体();
						moveFrame.setVisible(true); 
						进入登录界面.this.dispose(); 
					} else 
					{
						JOptionPane.showMessageDialog(null, "输入的用户名或密码错误"); 
						userNameTextField.setText(""); 
						passwordTextField.setText(""); 
					}
				}
			});
		}
		return loginPanel;
	}
}
