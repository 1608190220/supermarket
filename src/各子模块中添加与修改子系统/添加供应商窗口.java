package 各子模块中添加与修改子系统;

/*
 * 当添加供应商信息时弹出的窗口
 * 2017 12 9
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import 与数据库相对应的javabasedata.供应商;
import 操作数据库类.导入供应商;

public class 添加供应商窗口 extends JFrame {
	private JPanel contentPane; // 创建一个 添加供应商窗口类 显示窗口的主面板

	private JTextField idTextField;
	private JTextField cNameTextField;
	private JTextField addressTextField;
	private JTextField linkmanTextField;
	private JTextField linkPhoneTextField;
	private JTextField faxesTextField;
	private JTextField postNumTextField;
	private JTextField bankNumTextField;
	private JTextField netAddressTextField;
	private JTextField emaillTextField;
	private JTextArea remarkTextArea; // 创建备注区多行文本框区域对象

	private JLabel idLabel;
	private JLabel cNameLabel;
	private JLabel addressLabel;
	private JLabel linkmanLabel;
	private JLabel linkPhoneLabel;
	private JLabel fexesLabel;
	private JLabel postNumLabel;
	private JLabel bankNumLabel;
	private JLabel netAddressLabel;
	private JLabel emailLabel;
	private JLabel remarklabel;

	private JLabel label_id;
	private JLabel Label_cName;
	private JLabel label_address;
	private JLabel label_linkman;
	private JLabel label_linkPhone;
	private JLabel label_faxes;
	private JLabel label_bankNum;
	private JLabel label_email;

	private JButton insertButton;
	private JButton closeButton;

	/*
	 * 创建窗口
	 */
	public 添加供应商窗口() {
		setTitle("添加供应商");
		setBounds(100, 100, 635, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		idLabel = new JLabel("编号：");
		idLabel.setBounds(321, 140, 54, 15);
		contentPane.add(idLabel);
		idTextField = new JTextField();
		idTextField.setBounds(385, 137, 164, 25);
		contentPane.add(idTextField);
		idTextField.setColumns(10);

		cNameLabel = new JLabel("客户名称：");
		cNameLabel.setBounds(49, 53, 72, 15);
		contentPane.add(cNameLabel);
		cNameTextField = new JTextField();
		cNameTextField.setBounds(114, 50, 164, 25);
		contentPane.add(cNameTextField);
		cNameTextField.setColumns(10);

		addressLabel = new JLabel("客户地址：");
		addressLabel.setBounds(315, 53, 72, 15);
		contentPane.add(addressLabel);
		addressTextField = new JTextField();
		addressTextField.setColumns(10);
		addressTextField.setBounds(385, 50, 164, 25);
		contentPane.add(addressTextField);

		linkmanLabel = new JLabel(" 联系人：");
		linkmanLabel.setBounds(49, 97, 70, 15);
		contentPane.add(linkmanLabel);
		linkmanTextField = new JTextField();
		linkmanTextField.setBounds(114, 94, 164, 25);
		contentPane.add(linkmanTextField);
		linkmanTextField.setColumns(10);

		linkPhoneLabel = new JLabel("联系电话：");
		linkPhoneLabel.setBounds(315, 97, 72, 15);
		contentPane.add(linkPhoneLabel);
		linkPhoneTextField = new JTextField();
		linkPhoneTextField.setBounds(385, 94, 164, 25);
		contentPane.add(linkPhoneTextField);
		linkPhoneTextField.setColumns(10);

		fexesLabel = new JLabel("  传 真：");
		fexesLabel.setBounds(50, 140, 54, 15);
		contentPane.add(fexesLabel);
		faxesTextField = new JTextField();
		faxesTextField.setColumns(10);
		faxesTextField.setBounds(114, 137, 164, 25);
		contentPane.add(faxesTextField);

		postNumLabel = new JLabel(" 邮  编：");
		postNumLabel.setBounds(321, 225, 72, 15);
		contentPane.add(postNumLabel);
		postNumTextField = new JTextField();
		postNumTextField.setColumns(10);
		postNumTextField.setBounds(385, 225, 164, 25);
		contentPane.add(postNumTextField);

		bankNumLabel = new JLabel("银行账号：");
		bankNumLabel.setBounds(49, 180, 72, 15);
		contentPane.add(bankNumLabel);
		bankNumTextField = new JTextField();
		bankNumTextField.setColumns(10);
		bankNumTextField.setBounds(114, 177, 164, 25);
		contentPane.add(bankNumTextField);

		netAddressLabel = new JLabel("   网 址：");
		netAddressLabel.setBounds(315, 180, 60, 15);
		contentPane.add(netAddressLabel);
		netAddressTextField = new JTextField();
		netAddressTextField.setColumns(10);
		netAddressTextField.setBounds(385, 177, 164, 25);
		contentPane.add(netAddressTextField);

		emailLabel = new JLabel("   邮 箱：");
		emailLabel.setBounds(49, 223, 72, 15);
		contentPane.add(emailLabel);
		emaillTextField = new JTextField();
		emaillTextField.setColumns(10);
		emaillTextField.setBounds(114, 220, 164, 25);
		contentPane.add(emaillTextField);

		remarklabel = new JLabel("   备 注：");
		remarklabel.setBounds(49, 294, 72, 15);
		contentPane.add(remarklabel);
		remarkTextArea=new JTextArea();
		remarkTextArea.setBounds(114, 267, 435, 89);
		contentPane.add(remarkTextArea);
		
		label_id = new JLabel("*");
		label_id.setForeground(Color.red);
		label_id.setBounds(559, 142, 6, 15);
		contentPane.add(label_id);
		
		Label_cName = new JLabel("*");
		Label_cName.setForeground(Color.red);
		Label_cName.setBounds(283, 55, 6, 15);
		contentPane.add(Label_cName);

		label_address = new JLabel("*");
		label_address.setForeground(Color.red);
		label_address.setBounds(559, 55, 6, 15);
		contentPane.add(label_address);

		label_linkman = new JLabel("*");
		label_linkman.setForeground(Color.red);
		label_linkman.setBounds(283, 99, 6, 15);
		contentPane.add(label_linkman);

		label_linkPhone = new JLabel("*");
		label_linkPhone.setForeground(Color.red);
		label_linkPhone.setBounds(559, 99, 6, 15);
		contentPane.add(label_linkPhone);

		label_faxes = new JLabel("*");
		label_faxes.setForeground(Color.red);
		label_faxes.setBounds(283, 142, 6, 15);
		contentPane.add(label_faxes);

		label_bankNum = new JLabel("*");
		label_bankNum.setForeground(Color.red);
		label_bankNum.setBounds(283, 182, 6, 15);
		contentPane.add(label_bankNum);

		label_email = new JLabel("*");
		label_email.setForeground(Color.red);
		label_email.setBounds(283, 225, 6, 15);
		contentPane.add(label_email);

		insertButton = new JButton("添加");
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				导入供应商 dao = new 导入供应商();
				供应商 provide = new 供应商();
				String id = idTextField.getText();
				String cName = cNameTextField.getText();
				String address = addressTextField.getText();
				String bankNum = bankNumTextField.getText();
				String linkName = linkmanTextField.getText();
				String linkPhone = linkPhoneTextField.getText();
				String faxes = faxesTextField.getText();
				String netAddress = netAddressTextField.getText();
				String emaillAddress = emaillTextField.getText();
				if ((id.equals("")) || (cName.equals("")) || (address.equals("")) || (bankNum.equals(""))
						|| (linkName.equals("")) || (linkPhone.equals("")) || (faxes.equals(""))) {
					JOptionPane.showMessageDialog(getContentPane(), "将带星号的信息填写完整！", "信息提示框",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				int id1 = Integer.parseInt(id); // 获取的id文本框中内容转为int型
				provide.setId(id1);
				provide.setcName(cName);
				provide.setAddress(address);
				provide.setBankNum(bankNum);
				provide.setLinkman(linkName);
				provide.setLinkPhone(linkPhone);
				provide.setFaxes(faxes);
				provide.setBankNum(bankNum);
				provide.setPostNum(postNumTextField.getText());
				provide.setNetAddress(netAddress);
				provide.setEmaillAddress(emaillAddress);
				provide.setRemark(remarkTextArea.getText());
				dao.insertProvide(provide);
				JOptionPane.showMessageDialog(getContentPane(), "数据添加成功！", "信息提示框", JOptionPane.INFORMATION_MESSAGE);
				repaint();

			}
		});
		insertButton.setBounds(185, 388, 93, 23);
		contentPane.add(insertButton);

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
