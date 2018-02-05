package ��Ŀ�и���ģ���������;

/*
 * �ֿ�������
 * ��ʾ�� �����洰�� ���·�������չʾ�ֿ����ĸ����������Ϣ 
 * 2017 12 10
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;
import java.io.*;
import ����ģ����������޸���ϵͳ.��Ӳֿ���ⴰ��;
import �����ݿ����Ӧ��javabasedata.�ֿ����;
import �������ݿ���.����ֿ����;
import ��Ŀ����ı��ģ��.�ֿ������ģ��;

public class �ֿ������� extends JPanel {
	private JTable table;
	private List list;
	private JScrollPane scrollPane ;
	
	private JLabel dateLabel;
	private JTextField dateTextField; 
	
	private JButton findButton;
	private JButton insertButton;
	private JButton deleteButton;
	
	private �ֿ������ģ�� joinDepotModel = new �ֿ������ģ��();
	private ����ֿ���� dao = new ����ֿ����();

	/*
	 * �������
	 */
	public �ֿ�������() {
		setSize(631, 413);
		setLayout(null);
		this.setBackground(new Color(71, 201, 223));
		
		dateLabel = new JLabel("���ʱ�䣺");
		dateLabel.setBounds(212, 86, 66, 15);
		add(dateLabel);
		dateTextField = new JTextField();
		dateTextField.setBounds(277, 83, 156, 25);
		add(dateTextField);
		dateTextField.setColumns(10);

		findButton = new JButton("����");
		findButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String joinDate = dateTextField.getText();
				if (joinDate.equals("")) {
					JOptionPane.showMessageDialog(getParent(), "û����д��ѯ������", "��Ϣ��ʾ��", JOptionPane.INFORMATION_MESSAGE);
					return;
				} else if (!joinDate.equals("")) {
					list = dao.selectJoinDepot(joinDate);
					joinDepotModel.setRowCount(0);
					for (int i = 0; i < list.size(); i++) {
						�ֿ���� depot = (�ֿ����) list.get(i);
						//��select��������ӵ����
						joinDepotModel.addRow(new Object[] { depot.getId(),  depot.getWareName(),
								depot.getJoinTime(), depot.getWeight(), depot.getRemark() });
					}
				}

			}
		});
		findButton.setBounds(513, 82, 93, 23);
		add(findButton);
		
		insertButton = new JButton("���");
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				��Ӳֿ���ⴰ�� insertJoin = new ��Ӳֿ���ⴰ��();
				insertJoin.setVisible(true);
			}
		});
		insertButton.setBounds(217, 369, 66, 23);
		add(insertButton);
		
		deleteButton = new JButton("ɾ��");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row < 0) {
					JOptionPane.showMessageDialog(getParent(), "û��ѡ��Ҫ�h�������ݣ�", "��Ϣ��ʾ��", JOptionPane.INFORMATION_MESSAGE);
					return;
				} else {
					String column = joinDepotModel.getValueAt(row, 0).toString();
					dao.deleteJoinDepot(Integer.parseInt(column));
					JOptionPane.showMessageDialog(getParent(), "����ɾ���ɹ���", "��Ϣ��ʾ��", JOptionPane.INFORMATION_MESSAGE);
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
		final ����ֿ���� dao = new ����ֿ����();
		list = dao.selectJoinDepot();
		for (int i = 0; i < list.size(); i++) {
			�ֿ���� depot = (�ֿ����) list.get(i);
			joinDepotModel.addRow(new Object[] { depot.getId(), depot.getWareName(),
					depot.getJoinTime(), depot.getWeight(), depot.getRemark() });
		}
		scrollPane.setViewportView(table);
	}
}
