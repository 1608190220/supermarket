package 各子模块中添加与修改子系统;

/*
 * 修改供应商信息时弹出的窗口
 * 2017 12 9
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.io.*;
import 与数据库相对应的javabasedata.供应商;
import 操作数据库类.导入供应商;

public class 修改供应商窗口 extends JFrame {
	private JPanel contentPane;

	private JTextField cNameTextField;
	private JTextField addressTextField;
	private JTextField linkmanTextField;
	private JTextField linkPhoneTextField;
	private JTextField faxesTextField;
	private JTextField postNumTextField;
	private JTextField bankNumTextField;
	private JTextField netAddressTextField;
	private JTextField emaillTextField;
	private JTextArea remarkTextArea = new JTextArea();

	private JLabel cNameLabel;
	private JLabel addressLabel;
	private JLabel linkNameLabel;
	private JLabel linkPhoneLabel;
	private JLabel fexesLabel;
	private JLabel postNumLabel;
	private JLabel bankNumLabel;
	private JLabel netAddressLabel;
	private JLabel emailLabel;
	private JLabel remarkLabel;

	private JButton closeButton;
	private JButton updatetButton;

	供应商 provide = null;

	/*
	 * 创建 修改供应商信息窗口
	 */
	public 修改供应商窗口() {
		setTitle("修改供应商信息");

		导入供应商 dao = new 导入供应商();

		try {
			File file = new File("修改id.txt");
			//创建一个FileInputStream,打开一个到实际文件的连接，该文件通过文件系统中的File 对象file 指定
			FileInputStream fin = new FileInputStream(file);
			int count = fin.read(); //读取的信息来自 供货商面板类 中 修改按钮 录入到文件里的信息
			fin.close(); //先关流再删除文件，否则删除不了
			file.delete();
			provide = dao.selectProvideByid(count);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 绘制窗体的面板
		setBounds(100, 100, 635, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane); // 把contentPane容器设置为 修改供应商窗口 的面板
		contentPane.setLayout(null);

		cNameLabel = new JLabel("客户名称：");
		cNameLabel.setBounds(49, 53, 72, 15);
		contentPane.add(cNameLabel);
		cNameTextField = new JTextField();
		cNameTextField.setText(provide.getcName());
		cNameTextField.setBounds(114, 50, 164, 25);
		contentPane.add(cNameTextField);
		cNameTextField.setColumns(10);

		addressLabel = new JLabel("客户地址：");
		addressLabel.setBounds(315, 53, 72, 15);
		contentPane.add(addressLabel);
		addressTextField = new JTextField();
		addressTextField.setText(provide.getAddress());
		addressTextField.setColumns(10);
		addressTextField.setBounds(385, 50, 164, 25);
		contentPane.add(addressTextField);

		linkNameLabel = new JLabel(" 联系人：");
		linkNameLabel.setBounds(49, 97, 70, 15);
		contentPane.add(linkNameLabel);
		linkmanTextField = new JTextField();
		linkmanTextField.setText(provide.getLinkman());
		linkmanTextField.setBounds(114, 94, 164, 25);
		contentPane.add(linkmanTextField);
		linkmanTextField.setColumns(10);

		linkPhoneLabel = new JLabel("联系电话：");
		linkPhoneLabel.setBounds(315, 97, 72, 15);
		contentPane.add(linkPhoneLabel);
		linkPhoneTextField = new JTextField();
		linkPhoneTextField.setText(provide.getLinkPhone());
		linkPhoneTextField.setBounds(385, 94, 164, 25);
		contentPane.add(linkPhoneTextField);
		linkPhoneTextField.setColumns(10);

		fexesLabel = new JLabel("  传 真：");
		fexesLabel.setBounds(50, 140, 54, 15);
		contentPane.add(fexesLabel);
		faxesTextField = new JTextField();
		faxesTextField.setText(provide.getFaxes());
		faxesTextField.setColumns(10);
		faxesTextField.setBounds(114, 137, 164, 25);
		contentPane.add(faxesTextField);

		postNumLabel = new JLabel("  邮 编：");
		postNumLabel.setBounds(321, 140, 54, 15);
		contentPane.add(postNumLabel);
		postNumTextField = new JTextField();
		postNumTextField.setText(provide.getPostNum());
		postNumTextField.setColumns(10);
		postNumTextField.setBounds(385, 137, 164, 25);
		contentPane.add(postNumTextField);

		bankNumLabel = new JLabel("银行账号：");
		bankNumLabel.setBounds(49, 180, 72, 15);
		contentPane.add(bankNumLabel);
		bankNumTextField = new JTextField();
		bankNumTextField.setText(provide.getBankNum());
		bankNumTextField.setColumns(10);
		bankNumTextField.setBounds(114, 177, 164, 25);
		contentPane.add(bankNumTextField);

		netAddressLabel = new JLabel("   网 址：");
		netAddressLabel.setBounds(315, 180, 60, 15);
		contentPane.add(netAddressLabel);
		netAddressTextField = new JTextField();
		netAddressTextField.setText(provide.getNetAddress());
		netAddressTextField.setColumns(10);
		netAddressTextField.setBounds(385, 177, 164, 25);
		contentPane.add(netAddressTextField);

		emailLabel = new JLabel("   邮 箱：");
		emailLabel.setBounds(49, 223, 72, 15);
		contentPane.add(emailLabel);
		emaillTextField = new JTextField();
		emaillTextField.setText(provide.getEmaillAddress());
		emaillTextField.setColumns(10);
		emaillTextField.setBounds(114, 220, 164, 25);
		contentPane.add(emaillTextField);

		remarkLabel = new JLabel("   备 注：");
		remarkLabel.setBounds(49, 294, 72, 15);
		contentPane.add(remarkLabel);
		remarkTextArea.setBounds(114, 267, 435, 89);
		contentPane.add(remarkTextArea);
		remarkTextArea.setText(provide.getRemark());

		updatetButton = new JButton("修改");
		updatetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				导入供应商 dao = new 导入供应商();
				provide.setcName(cNameTextField.getText());
				provide.setAddress(addressTextField.getText());
				provide.setLinkman(linkmanTextField.getText());
				provide.setLinkPhone(linkPhoneTextField.getText());
				provide.setBankNum(bankNumTextField.getText());
				provide.setFaxes(faxesTextField.getText());
				provide.setPostNum(postNumTextField.getText());
				provide.setBankNum(bankNumTextField.getText());
				provide.setNetAddress(netAddressTextField.getText());
				provide.setEmaillAddress(emaillTextField.getText());
				provide.setRemark(remarkTextArea.getText());
				dao.updateProvide(provide);
				repaint(); // 重绘组件
				JOptionPane.showMessageDialog(getContentPane(), "数据修改成功！", "信息提示框", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		updatetButton.setBounds(185, 388, 93, 23);
		contentPane.add(updatetButton);

		closeButton = new JButton("退出");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_closeButton_actionPerformed(e);
			}
		});
		closeButton.setBounds(342, 388, 93, 23);
		contentPane.add(closeButton);

		setLocationRelativeTo(null); // 窗体居中
		setResizable(false);
	}

	protected void do_closeButton_actionPerformed(ActionEvent arg0) {
		this.setVisible(false);
	}
}
