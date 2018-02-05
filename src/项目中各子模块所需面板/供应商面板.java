package ��Ŀ�и���ģ���������;

/*
 * ���ص� �����洰�� չʾ��� �е� ���������
 * 2017 12 9
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;
import java.io.*;
import ����ģ����������޸���ϵͳ.��ӹ�Ӧ�̴���;
import ����ģ����������޸���ϵͳ.�޸Ĺ�Ӧ�̴���;
import �����ݿ����Ӧ��javabasedata.��Ӧ��;
import �������ݿ���.���빩Ӧ��;
import ��Ŀ����ı��ģ��.��Ӧ�̱��ģ��;

public class ��Ӧ����� extends JPanel {
	private JPanel providePanel;

	private JTable table;
	private JScrollPane scrollPane;//���� ��Ӧ����� ��� ���� �пɸı䳤��
	private List list; //������ݿ��б���������ݣ�������
	
	private JLabel nameLabel;
	private JLabel addresLlabel;
	private JTextField nameTextField;
	private JTextField addressTextField;

	private JButton findButton;
	private JButton insertButton;
	private JButton updateButton;
	private JButton deleteButton;
	
	private ���빩Ӧ�� provideDao = new ���빩Ӧ��();
	private ��Ӧ�̱��ģ�� tableModel = new ��Ӧ�̱��ģ��();

	/*
	 * �������
	 */
	public JPanel getProvidePanel() {
		//���� ����������������
		providePanel = new JPanel();
		providePanel.setBackground(new Color(71, 201, 223)); // ��������������ó�ǳ��ɫ
		providePanel.setBounds(0, 0, 520, 600);
		providePanel.setLayout(null); // ���ÿղ���

		nameLabel = new JLabel("�ͻ�����");
		nameLabel.setBounds(10, 34, 54, 15);
		providePanel.add(nameLabel);
		nameTextField = new JTextField();
		nameTextField.setBounds(62, 31, 97, 25);
		providePanel.add(nameTextField);
		nameTextField.setColumns(10);

		addresLlabel = new JLabel("��ַ");
		addresLlabel.setBounds(169, 34, 38, 15);
		providePanel.add(addresLlabel);
		addressTextField = new JTextField();
		addressTextField.setBounds(204, 31, 119, 25);
		providePanel.add(addressTextField);
		addressTextField.setColumns(10);

		findButton = new JButton("����");
		findButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableModel.setRowCount(0);
				String name = nameTextField.getText();
				String address = addressTextField.getText();
				// ���û����д��ѯ��Ϣ������ʾ
				if ((name.equals("")) && (address.equals(""))) {
					JOptionPane.showMessageDialog(getParent(), "����д��ѯ������", "��Ϣ��ʾ��", JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				// ֻ��д�����̿ͻ�����
				if ((!name.equals("")) && (address.equals(""))) {
					list = provideDao.selectProvideByName(name);
					for (int i = 0; i < list.size(); i++) {
						��Ӧ�� provide = (��Ӧ��) list.get(i);
						tableModel.addRow(new Object[] { provide.getId(), provide.getcName(), provide.getAddress(),
								provide.getLinkman(), provide.getLinkPhone(), provide.getFaxes(), provide.getPostNum(),
								provide.getBankNum(), provide.getNetAddress(), provide.getEmaillAddress(),
								provide.getRemark() });
					}
				}
				// ֻ��д�����̵�ַ��Ϣ
				if ((name.equals("")) && (!address.equals(""))) {
					list = provideDao.selectProvideByAddress(address);
					for (int i = 0; i < list.size(); i++) {
						��Ӧ�� provide = (��Ӧ��) list.get(i);
						tableModel.addRow(new Object[] { provide.getId(), provide.getcName(), provide.getAddress(),
								provide.getLinkman(), provide.getLinkPhone(), provide.getFaxes(), provide.getPostNum(),
								provide.getBankNum(), provide.getNetAddress(), provide.getEmaillAddress(),
								provide.getRemark() });
					}
				}
				//��д�����̿ͻ����ƺ͵�ַ
				if ((!name.equals("")) && (!address.equals(""))) {
					list = provideDao.selectProvideByNameAddress(address, name);
					for (int i = 0; i < list.size(); i++) {
						��Ӧ�� provide = (��Ӧ��) list.get(i);
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

		insertButton = new JButton("���");
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				��ӹ�Ӧ�̴��� insertProvide = new ��ӹ�Ӧ�̴���();
				insertProvide.setVisible(true);
			}
		});
		insertButton.setBounds(51, 313, 77, 23);
		providePanel.add(insertButton);

		updateButton = new JButton("�޸�");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow(); // �����������
				if (row < 0) {
					JOptionPane.showMessageDialog(getParent(), "û��ѡ��Ҫ�޸ĵ����ݣ�", "��Ϣ��ʾ��", JOptionPane.INFORMATION_MESSAGE);
					return;
				} else {
					File file = new File("�޸�id.txt");
					try {
						/*
						 * Object getValueAt(int rowIndex,int columnIndex)
						 * ���� columnIndex �� rowIndex λ�õĵ�Ԫ��ֵ
						 */
						String column = tableModel.getValueAt(row, 0).toString();
						file.createNewFile();
						// ����һ����ָ�� file���� ��ʾ���ļ���д�����ݵ��ļ������
						FileOutputStream out = new FileOutputStream(file);
						out.write((Integer.parseInt(column)));
						out.close();
						�޸Ĺ�Ӧ�̴��� update = new �޸Ĺ�Ӧ�̴���();
						update.setVisible(true);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		updateButton.setBounds(169, 313, 77, 23);
		providePanel.add(updateButton);

		deleteButton = new JButton("ɾ��");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				String column = tableModel.getValueAt(row, 0).toString();
				if (Integer.parseInt(column) < 0) {
					JOptionPane.showMessageDialog(getParent(), "û��ѡ��Ҫ�h�������ݣ�", "��Ϣ��ʾ��", JOptionPane.INFORMATION_MESSAGE);
					return;
				} else {
					provideDao.deleteProvide(Integer.parseInt(column));
					JOptionPane.showMessageDialog(getParent(), "����ɾ���ɹ���", "��Ϣ��ʾ��", JOptionPane.INFORMATION_MESSAGE);
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
			��Ӧ�� provide = (��Ӧ��) list.get(i);
			tableModel.addRow(new Object[] { provide.getId(), provide.getcName(), provide.getAddress(),
					provide.getLinkman(), provide.getLinkPhone(), provide.getFaxes(), provide.getPostNum(),
					provide.getBankNum(), provide.getNetAddress(), provide.getEmaillAddress(), provide.getRemark() });
		}
		scrollPane.setViewportView(table);// ���ӿڸ�ֵtable���󣬰ѱ��ƴ���������·�

		return providePanel;
	}
}
