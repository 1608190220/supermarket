package 各子模块中添加与修改子系统;

/*
 * 2017 12 10
 */

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import 与数据库相对应的javabasedata.仓库入库;
import 操作数据库类.导入仓库入库;

public class 添加仓库入库窗口 extends JFrame {
	private JPanel contentPane;

	private JLabel idLabel;
	private JLabel weight;
	private JLabel wNameLabel;
	private JLabel joinTimeLabel;
	private JLabel remarkLabel;

	private JTextField idTextField;
	private JTextField weighttextField;;
	private JTextField wNameTextField;
	private JTextField joinTimeTextField;
	private JTextArea remarkTextArea; // 创建备注多行文本框对象

	private JButton closeButton;

	// 红色星号
	private JLabel Label_id;
	private JLabel label_wName;
	private JLabel label_joinTime;
	private JLabel label_weight;

	/*
	 * 创建窗口
	 */
	public 添加仓库入库窗口() {
		setTitle("添加仓库入库窗体");
		setBounds(100, 100, 635, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		idLabel = new JLabel("编 号：");
		idLabel.setBounds(59, 55, 60, 15);
		contentPane.add(idLabel);
		idTextField = new JTextField();
		idTextField.setBounds(113, 50, 164, 25);
		contentPane.add(idTextField);
		idTextField.setColumns(10);

		wNameLabel = new JLabel(" 货品名称：");
		wNameLabel.setBounds(41, 99, 70, 15);
		contentPane.add(wNameLabel);
		wNameTextField = new JTextField();
		wNameTextField.setBounds(114, 94, 164, 25);
		contentPane.add(wNameTextField);
		wNameTextField.setColumns(10);

		joinTimeLabel = new JLabel("入库时间：");
		joinTimeLabel.setBounds(315, 55, 72, 15);
		contentPane.add(joinTimeLabel);
		joinTimeTextField = new JTextField();
		joinTimeTextField.setBounds(385, 50, 164, 25);
		contentPane.add(joinTimeTextField);
		joinTimeTextField.setColumns(10);

		remarkLabel = new JLabel("  备 注：");
		remarkLabel.setBounds(59, 233, 54, 15);
		contentPane.add(remarkLabel);
		remarkTextArea = new JTextArea();
		remarkTextArea.setBounds(114, 193, 435, 112);
		contentPane.add(remarkTextArea);

		weight = new JLabel("重量： ");
		weight.setBounds(70, 146, 44, 15);
		contentPane.add(weight);
		weighttextField = new JTextField();
		weighttextField.setBounds(114, 144, 164, 25);
		contentPane.add(weighttextField);
		weighttextField.setColumns(10);
		JLabel weightUnit = new JLabel("千克");
		weightUnit.setBounds(284, 146, 54, 15);
		contentPane.add(weightUnit);

		Label_id = new JLabel("*");
		Label_id.setForeground(Color.red);
		Label_id.setBounds(284, 53, 7, 15);
		contentPane.add(Label_id);
		label_wName = new JLabel("*");
		label_wName.setForeground(Color.red);
		label_wName.setBounds(284, 97, 7, 15);
		contentPane.add(label_wName);
		label_joinTime = new JLabel("*");
		label_joinTime.setForeground(Color.red);
		label_joinTime.setBounds(559, 55, 7, 15);
		contentPane.add(label_joinTime);
		label_weight = new JLabel("*");
		label_weight.setForeground(Color.red);
		label_weight.setBounds(315, 150, 7, 15);
		contentPane.add(label_weight);

		JButton insertButton = new JButton("添加");
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				导入仓库入库 dao = new 导入仓库入库();
				仓库入库 joinDepot = new 仓库入库();

				String id = idTextField.getText();
				String wName = wNameTextField.getText();
				String joinTime = joinTimeTextField.getText();
				String wight = weighttextField.getText();
				if ((id.equals("")) || (wName.equals("")) || (joinTime.equals("")) || (wight.equals(""))) {
					JOptionPane.showMessageDialog(getContentPane(), "请将带星号的内容填写完整！", "信息提示框",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				int id1 = Integer.parseInt(id);
				float wight1 = Float.parseFloat(wight);
				joinDepot.setId(id1);
				joinDepot.setJoinTime(joinTime);
				joinDepot.setWareName(wName);
				joinDepot.setWeight(wight1);
				joinDepot.setRemark(remarkTextArea.getText());
				dao.insertJoinDepot(joinDepot);
				JOptionPane.showMessageDialog(getContentPane(), "数据添加成功！", "信息提示框", JOptionPane.INFORMATION_MESSAGE);

				repaint();
			}
		});
		insertButton.setBounds(185, 329, 93, 23);
		contentPane.add(insertButton);

		closeButton = new JButton("退出");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_closeButton_actionPerformed(e);
			}
		});
		closeButton.setBounds(326, 329, 93, 23);
		contentPane.add(closeButton);

		setLocationRelativeTo(null); // 窗体居中
		setResizable(false);
	}

	protected void do_closeButton_actionPerformed(ActionEvent arg0) {
		this.setVisible(false);
	}
}
