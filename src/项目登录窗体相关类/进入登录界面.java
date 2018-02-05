package ��Ŀ��¼���������;

/*
 * ��Ŀ�Ŀ�ʼ���򿪵�¼����
 * 2017 11 27
 */

import javax.swing.*; //����JLabel JTextField JPasswordField JButton��
import javax.swing.border.EmptyBorder; //���ñ߽�İ� �հױ߽�
import java.awt.event.*;
import java.net.URL;
import �������.�Ự;
import �����ݿ����Ӧ��javabasedata.�û�;
import �������ݿ���.�����û�;
import ��Ŀ�����������.�����洰��;

public class �����¼���� extends JFrame {
	private ��¼���汳����� loginPanel;
	
	private JLabel userNameLabel;
	private JLabel passWordLabel;
	private JTextField userNameTextField; 
	private JPasswordField passwordTextField; 
	
	private JButton loginButton;
	
	/*
	 * ����Ŀ�����е�¼����
	 */
	public static void main(String[] args) {
		�����¼���� goBegin = new �����¼����();
		goBegin.setVisible(true);
	}

	/*
	 * ������¼���ڿ��
	 */
	public �����¼����() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ��System exit(0)�����رմ��ڣ��������д��ڲ��˳�����
		setResizable(false); // �õ�¼�����С���ɸı�
		setTitle("��¼");
		setBounds(0, 0, 559, 285); 
		loginPanel = getLoginPanel();
		loginPanel.setBorder(new EmptyBorder(5, 5, 5, 5)); 
		setContentPane(loginPanel);
		loginPanel.setLayout(null);
		setLocationRelativeTo(null); // �������
	}

	/*
	 * ��ʼ����¼���ڵ����
	 */
	private ��¼���汳����� getLoginPanel() {
		if (loginPanel == null) {
			loginPanel = new ��¼���汳�����(); 
			loginPanel.setOpaque(false); // ���͸��
			loginPanel.setImage(getToolkit().getImage(getClass().getResource("/��Ŀ����ͼƬ�ļ�/ܼ��¡���й���ϵͳ��¼���ڱ���.png"))); // ���ص�¼���ڵı���ͼƬ

			userNameLabel = new JLabel("�û�����"); 
			userNameLabel.setBounds(75, 116, 54, 15); 
			loginPanel.add(userNameLabel);
			userNameTextField = new JTextField(); 
			userNameTextField.setBounds(127, 113, 139, 25);
			loginPanel.add(userNameTextField);
			userNameTextField.setColumns(10); // ���������ַ��Ŀ��Ϊ10

			passWordLabel = new JLabel("��  �룺");
			passWordLabel.setBounds(75, 158, 54, 15);
			loginPanel.add(passWordLabel);
			passwordTextField = new JPasswordField();
			passwordTextField.setBounds(127, 155, 139, 25);
			loginPanel.add(passwordTextField);

			loginButton = new JButton(); 
			URL urlLogin = getClass().getResource("/��Ŀ����ͼƬ�ļ�/��¼��ť.png");
			ImageIcon imageI = new ImageIcon(urlLogin); 
			loginButton.setIcon(imageI); 
			loginButton.setBounds(320, 116, imageI.getIconWidth(), imageI.getIconHeight()); // ���� ��¼��ť.png
			loginButton.setContentAreaFilled(false); // ȡ���������
			loginButton.setBorder(null); // ȡ���߿�
			loginPanel.add(loginButton);
			loginButton.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent ae) {
					�����û� userDao = new �����û�(); 
					�û� user = userDao.getUser(userNameTextField.getText(), passwordTextField.getText());
					/*
					 * �ж��û�������û��������Ƿ���ȷ
					 */
					if (user.getId() > 0)
					{
						�Ự.setUser(user); 
						�����洰�� moveFrame = new �����洰��();
						moveFrame.setVisible(true); 
						�����¼����.this.dispose(); 
					} else 
					{
						JOptionPane.showMessageDialog(null, "������û������������"); 
						userNameTextField.setText(""); 
						passwordTextField.setText(""); 
					}
				}
			});
		}
		return loginPanel;
	}
}
