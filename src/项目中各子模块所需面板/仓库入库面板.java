package 项目中各子模块所需面板;

/*
 * 仓库入库面板
 * 显示在 主界面窗体 右下方，用来展示仓库入库的各项操作和信息 
 * 2017 12 10
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;
import java.io.*;
import 各子模块中添加与修改子系统.添加仓库入库窗口;
import 与数据库相对应的javabasedata.仓库入库;
import 操作数据库类.导入仓库入库;
import 项目所需的表格模型.仓库入库表格模型;

public class 仓库入库面板 extends JPanel {
	private JTable table;
	private List list;
	private JScrollPane scrollPane ;
	
	private JLabel dateLabel;
	private JTextField dateTextField; 
	
	private JButton findButton;
	private JButton insertButton;
	private JButton deleteButton;
	
	private 仓库入库表格模型 joinDepotModel = new 仓库入库表格模型();
	private 导入仓库入库 dao = new 导入仓库入库();

	/*
	 * 创建面板
	 */
	public 仓库入库面板() {
		setSize(631, 413);
		setLayout(null);
		this.setBackground(new Color(71, 201, 223));
		
		dateLabel = new JLabel("入库时间：");
		dateLabel.setBounds(212, 86, 66, 15);
		add(dateLabel);
		dateTextField = new JTextField();
		dateTextField.setBounds(277, 83, 156, 25);
		add(dateTextField);
		dateTextField.setColumns(10);

		findButton = new JButton("搜索");
		findButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String joinDate = dateTextField.getText();
				if (joinDate.equals("")) {
					JOptionPane.showMessageDialog(getParent(), "没有填写查询条件！", "信息提示框", JOptionPane.INFORMATION_MESSAGE);
					return;
				} else if (!joinDate.equals("")) {
					list = dao.selectJoinDepot(joinDate);
					joinDepotModel.setRowCount(0);
					for (int i = 0; i < list.size(); i++) {
						仓库入库 depot = (仓库入库) list.get(i);
						//将select到的行添加到表格
						joinDepotModel.addRow(new Object[] { depot.getId(),  depot.getWareName(),
								depot.getJoinTime(), depot.getWeight(), depot.getRemark() });
					}
				}

			}
		});
		findButton.setBounds(513, 82, 93, 23);
		add(findButton);
		
		insertButton = new JButton("添加");
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				添加仓库入库窗口 insertJoin = new 添加仓库入库窗口();
				insertJoin.setVisible(true);
			}
		});
		insertButton.setBounds(217, 369, 66, 23);
		add(insertButton);
		
		deleteButton = new JButton("删除");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row < 0) {
					JOptionPane.showMessageDialog(getParent(), "没有选择要刪除的数据！", "信息提示框", JOptionPane.INFORMATION_MESSAGE);
					return;
				} else {
					String column = joinDepotModel.getValueAt(row, 0).toString();
					dao.deleteJoinDepot(Integer.parseInt(column));
					JOptionPane.showMessageDialog(getParent(), "数据删除成功！", "信息提示框", JOptionPane.INFORMATION_MESSAGE);
					repaint();

				}
			}
		});
		deleteButton.setBounds(380, 369, 66, 23);
		add(deleteButton);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 118, 577, 230);
		add(scrollPane);
		table = new JTable(joinDepotModel);
		final 导入仓库入库 dao = new 导入仓库入库();
		list = dao.selectJoinDepot();
		for (int i = 0; i < list.size(); i++) {
			仓库入库 depot = (仓库入库) list.get(i);
			joinDepotModel.addRow(new Object[] { depot.getId(), depot.getWareName(),
					depot.getJoinTime(), depot.getWeight(), depot.getRemark() });
		}
		scrollPane.setViewportView(table);
	}
}
