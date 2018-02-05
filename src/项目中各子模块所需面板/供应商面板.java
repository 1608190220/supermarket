package 项目中各子模块所需面板;

/*
 * 加载到 主界面窗体 展示面板 中的 供货商面板
 * 2017 12 9
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;
import java.io.*;
import 各子模块中添加与修改子系统.添加供应商窗口;
import 各子模块中添加与修改子系统.修改供应商窗口;
import 与数据库相对应的javabasedata.供应商;
import 操作数据库类.导入供应商;
import 项目所需的表格模型.供应商表格模型;

public class 供应商面板 extends JPanel {
	private JPanel providePanel;

	private JTable table;
	private JScrollPane scrollPane;//控制 供应商面板 表格 列名 行可改变长度
	private List list; //获得数据库中表里面的数据，存入表格
	
	private JLabel nameLabel;
	private JLabel addresLlabel;
	private JTextField nameTextField;
	private JTextField addressTextField;

	private JButton findButton;
	private JButton insertButton;
	private JButton updateButton;
	private JButton deleteButton;
	
	private 导入供应商 provideDao = new 导入供应商();
	private 供应商表格模型 tableModel = new 供应商表格模型();

	/*
	 * 创建面板
	 */
	public JPanel getProvidePanel() {
		//设置 供货商面板相关属性
		providePanel = new JPanel();
		providePanel.setBackground(new Color(71, 201, 223)); // 将供货商面板设置成浅蓝色
		providePanel.setBounds(0, 0, 520, 600);
		providePanel.setLayout(null); // 设置空布局

		nameLabel = new JLabel("客户名称");
		nameLabel.setBounds(10, 34, 54, 15);
		providePanel.add(nameLabel);
		nameTextField = new JTextField();
		nameTextField.setBounds(62, 31, 97, 25);
		providePanel.add(nameTextField);
		nameTextField.setColumns(10);

		addresLlabel = new JLabel("地址");
		addresLlabel.setBounds(169, 34, 38, 15);
		providePanel.add(addresLlabel);
		addressTextField = new JTextField();
		addressTextField.setBounds(204, 31, 119, 25);
		providePanel.add(addressTextField);
		addressTextField.setColumns(10);

		findButton = new JButton("搜索");
		findButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableModel.setRowCount(0);
				String name = nameTextField.getText();
				String address = addressTextField.getText();
				// 如果没有填写查询信息，给提示
				if ((name.equals("")) && (address.equals(""))) {
					JOptionPane.showMessageDialog(getParent(), "请填写查询条件！", "信息提示框", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				// 只填写供货商客户名称
				if ((!name.equals("")) && (address.equals(""))) {
					list = provideDao.selectProvideByName(name);
					for (int i = 0; i < list.size(); i++) {
						供应商 provide = (供应商) list.get(i);
						tableModel.addRow(new Object[] { provide.getId(), provide.getcName(), provide.getAddress(),
								provide.getLinkman(), provide.getLinkPhone(), provide.getFaxes(), provide.getPostNum(),
								provide.getBankNum(), provide.getNetAddress(), provide.getEmaillAddress(),
								provide.getRemark() });
					}
				}
				// 只填写供货商地址信息
				if ((name.equals("")) && (!address.equals(""))) {
					list = provideDao.selectProvideByAddress(address);
					for (int i = 0; i < list.size(); i++) {
						供应商 provide = (供应商) list.get(i);
						tableModel.addRow(new Object[] { provide.getId(), provide.getcName(), provide.getAddress(),
								provide.getLinkman(), provide.getLinkPhone(), provide.getFaxes(), provide.getPostNum(),
								provide.getBankNum(), provide.getNetAddress(), provide.getEmaillAddress(),
								provide.getRemark() });
					}
				}
				//填写供货商客户名称和地址
				if ((!name.equals("")) && (!address.equals(""))) {
					list = provideDao.selectProvideByNameAddress(address, name);
					for (int i = 0; i < list.size(); i++) {
						供应商 provide = (供应商) list.get(i);
						tableModel.addRow(new Object[] { provide.getId(), provide.getcName(), provide.getAddress(),
								provide.getLinkman(), provide.getLinkPhone(), provide.getFaxes(), provide.getPostNum(),
								provide.getBankNum(), provide.getNetAddress(), provide.getEmaillAddress(),
								provide.getRemark() });
					}
				}
			}
		});
		findButton.setBounds(333, 30, 77, 23);
		providePanel.add(findButton);

		insertButton = new JButton("添加");
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				添加供应商窗口 insertProvide = new 添加供应商窗口();
				insertProvide.setVisible(true);
			}
		});
		insertButton.setBounds(51, 313, 77, 23);
		providePanel.add(insertButton);

		updateButton = new JButton("修改");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow(); // 鼠标点击的行数
				if (row < 0) {
					JOptionPane.showMessageDialog(getParent(), "没有选择要修改的数据！", "信息提示框", JOptionPane.INFORMATION_MESSAGE);
					return;
				} else {
					File file = new File("修改id.txt");
					try {
						/*
						 * Object getValueAt(int rowIndex,int columnIndex)
						 * 返回 columnIndex 和 rowIndex 位置的单元格值
						 */
						String column = tableModel.getValueAt(row, 0).toString();
						file.createNewFile();
						// 创建一个向指定 file对象 表示的文件中写入数据的文件输出流
						FileOutputStream out = new FileOutputStream(file);
						out.write((Integer.parseInt(column)));
						out.close();
						修改供应商窗口 update = new 修改供应商窗口();
						update.setVisible(true);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		updateButton.setBounds(169, 313, 77, 23);
		providePanel.add(updateButton);

		deleteButton = new JButton("删除");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				String column = tableModel.getValueAt(row, 0).toString();
				if (Integer.parseInt(column) < 0) {
					JOptionPane.showMessageDialog(getParent(), "没有选择要刪除的数据！", "信息提示框", JOptionPane.INFORMATION_MESSAGE);
					return;
				} else {
					provideDao.deleteProvide(Integer.parseInt(column));
					JOptionPane.showMessageDialog(getParent(), "数据删除成功！", "信息提示框", JOptionPane.INFORMATION_MESSAGE);
					repaint();
				}
			}
		});
		deleteButton.setBounds(285, 313, 77, 23);
		providePanel.add(deleteButton);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 416, 233);
		providePanel.add(scrollPane);
		table = new JTable(tableModel);
		list = provideDao.selectProvide();
		tableModel.setRowCount(0);
		for (int i = 0; i < list.size(); i++) {
			供应商 provide = (供应商) list.get(i);
			tableModel.addRow(new Object[] { provide.getId(), provide.getcName(), provide.getAddress(),
					provide.getLinkman(), provide.getLinkPhone(), provide.getFaxes(), provide.getPostNum(),
					provide.getBankNum(), provide.getNetAddress(), provide.getEmaillAddress(), provide.getRemark() });
		}
		scrollPane.setViewportView(table);// 给视口赋值table对象，把表格拼接在列名下方

		return providePanel;
	}
}
