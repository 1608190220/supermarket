package ��Ŀ�����������;

/*
 * ��Ŀ �����洰�� �и����������
 * 2017 12 4
 */

import java.awt.*; 
import javax.swing.*; //���� JPanel��
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.awt.event.*; //���� ActionListener��
import java.text.SimpleDateFormat;
import java.util.Date;
import �������.�Ự;
import �����ݿ����Ӧ��javabasedata.�û�;
import ��Ŀ�и���ģ���������.��Ӧ�����;
import ��Ŀ�и���ģ���������.�ֿ�������;
import ��Ŀ�и���ģ���������.BG���;
import ��Ŀ�и���ģ���������.�����洰�����;
import ��Ŀ���������.��Ӧ��ť;

public class �����洰�� extends JFrame {
	private JTree tree;
	private Font font;
	private ButtonGroup buttonGroup = null; // ʹ�� javax.swing.ButtonGroup �࣬����ť���
	private JScrollPane scrollPane; //��� �� �ľ������

	private JPanel smallBGPanel = new JPanel();  //���� Сչʾ���
	private BG��� BGPanel; //���� չʾ���
	private JPanel unionPanel = null;//��ťƴ�����
	private ��Ӧ����� providePanel = new ��Ӧ�����();
	private �����洰����� mainPane;

	private JLabel change_label = new JLabel("������������"); //λ����Ϣ��ǩ ��������ֵ
	private JLabel whereLabel = new JLabel("��ǰλ���ǣ�"); // չʾ��� �ϵı�ǩ
	private JLabel welcomelabel;
	private JLabel time;

	private ��Ӧ��ť workSpaceButton = null; //������������ ��ť
	private ��Ӧ��ť bookProjectButton = null;//�ֿ���� ��ť
	private ��Ӧ��ť progressButton = null; //���谴ť
	private ��Ӧ��ť personnelManagerButton = null; //���谴ť 
	private ��Ӧ��ť deptManagerButton = null; //���谴ť

	/*
	 * ���������洰��
	 */
	public �����洰��() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 923, 625); 
		mainPane = new �����洰�����(); 
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPane); 
		setTitle("ܼ��¡���й���ϵͳ");
		mainPane.setLayout(null); 
		setResizable(false); 
		setLocationRelativeTo(null); // �������

		// ��� �����Ϸ��� С�������
		mainPane.add(unionJPanel());

		// �����洰����� ��ӭ��ǩ
		�û� user = �Ự.getUser(); // ��ȡ��¼�û�������û���
		font = new Font("����", 1, 20); // ���壬��񣬴�С
		String tip = "��ã�" + user.getUserName() + " ��ӭ��½��";
		welcomelabel = new JLabel(tip);
		welcomelabel.setFont(font);
		welcomelabel.setBounds(35, 220, 228, 35);
		mainPane.add(welcomelabel);

		// ��ʾϵͳʱ��
		// ����Timer ÿ��1sʵ��һ�ζ��� ��һ���߳�
		time = new JLabel();
		Timer timeAction = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long timemillis = System.currentTimeMillis();// 64λ�з��ŵ�Javaԭʼ��������,���ȴ���int
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				time.setText(df.format(new Date(timemillis)));
			}
		});
		timeAction.start();
		font = new Font("����", 1, 18);
		time.setFont(font);
		time.setBounds(35, 265, 228, 35);
		mainPane.add(time);

		mainPane.add(getContentPanel()); // ������·� ����ɫ չʾ���
	}

	/*
	 * ���� �����洰�� �е� չʾ���
	 */
	private BG��� getContentPanel() {
		if (BGPanel == null) // ���û��չʾ���
		{
			//  ����չʾ���
			BGPanel = new BG���();
			BGPanel.setBackground(new Color(255, 228, 181));
			BGPanel.setBounds(279, 149, 629, 416); // ���������洰���� չʾ��� ��С��λ��
			BGPanel.setLayout(null);

			whereLabel.setBounds(50, 35, 96, 15); // ����ǰλ�á� ��ǩ
			BGPanel.add(whereLabel);
			
			change_label.setBounds(150, 35, 123, 15); // λ����Ϣ��ǩ
			BGPanel.add(change_label);
			
			//  ���� չʾ��� �ϵ� Сչʾ���
			smallBGPanel.setBounds(10, 63, 611, 343);
			smallBGPanel.setLayout(null);
			BGPanel.add(smallBGPanel);
			
			//���� �� ���õ����
			scrollPane = new JScrollPane();
			scrollPane.setBackground(new Color(71, 201, 223));
			scrollPane.setBounds(0, 0, 138, 354);
			smallBGPanel.add(scrollPane);

			/*
			 * �� �� �������б���Ϣ
			 * DefaultMutableTreeNode ������ͨ�ý��
			 */
			DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("������������");
			DefaultMutableTreeNode childNode1 = new DefaultMutableTreeNode("��Ӧ�̹���");
			DefaultMutableTreeNode childNode2 = new DefaultMutableTreeNode("XXX");
			DefaultMutableTreeNode childNode3 = new DefaultMutableTreeNode("XXX");
			DefaultMutableTreeNode childNode4 = new DefaultMutableTreeNode("XXX");
			rootNode.add(childNode1);
			rootNode.add(childNode2);
			rootNode.add(childNode3);
			rootNode.add(childNode4);
			tree = new JTree(rootNode);
			scrollPane.setColumnHeaderView(tree);
			JPanel smallProvidePanel = new JPanel();//ǳ��ɫ С��Ӧ�����
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
						if (userObject.equals("��Ӧ�̹���")) {//ֻ�� �����̹��� ��һ�����
							change_label.setText("��Ӧ�̹���");
							smallProvidePanel.removeAll();
							smallProvidePanel.add(providePanel.getProvidePanel());
						}
					}
				}
			});
		}
		return BGPanel;
	}

	 //����� ��ťͼƬ ƴ�ӵ� unionPanel��� ��
	public JPanel unionJPanel() {
		if (unionPanel == null) {
			GridLayout gridLayout = new GridLayout(); // �������񲼾ֹ�����
			gridLayout.setRows(1); // �������񲼾ֹ�����������
			gridLayout.setHgap(0); // ���������ˮƽ���
			gridLayout.setVgap(0); // ��������䴹ֱ���
			unionPanel = new BG���(); 
			// ���������洰���� ƴ�Ӱ�ť��� ��С��λ��
			unionPanel.setBounds(280, 1, 349, 116); 
			// ���ò��ֹ�����
			unionPanel.setLayout(gridLayout);
			// ���ó�ʼ��С
			unionPanel.setPreferredSize(new Dimension(400, 50));
			unionPanel.setOpaque(false);
			// ��Ӱ�ť
			unionPanel.add(getWorkSpaceButton(), null); // ��ӻ�����������ť
			unionPanel.add(getrukuButton(), null); // �����ⰴť
			unionPanel.add(getProgressButton(), null); // ��Ӳɹ��������谴ť
			unionPanel.add(getPersonnelManagerButton(), null); // �����Ա������谴ť
			unionPanel.add(getDeptManagerButton(), null); // ��Ӳ��Ź�����谴ť
			if (buttonGroup == null) {
				buttonGroup = new ButtonGroup();
			}
			// �����а�ť��ӵ�һ����ؼ���
			buttonGroup.add(getWorkSpaceButton());
			buttonGroup.add(getrukuButton());
			buttonGroup.add(getProgressButton());
			buttonGroup.add(getPersonnelManagerButton());
			buttonGroup.add(getDeptManagerButton());
		}
		return unionPanel;
	}
	// ������������ť
	private ��Ӧ��ť getWorkSpaceButton() {
		if (workSpaceButton == null) {
			workSpaceButton = new ��Ӧ��ť();
			workSpaceButton.setActionCommand("������������"); // ���ð�ť�Ķ�������
			workSpaceButton.setIcon(new ImageIcon(getClass().getResource("/��Ŀ����ͼƬ�ļ�/��������1.png"))); 
			ImageIcon icon = new ImageIcon(getClass().getResource("/��Ŀ����ͼƬ�ļ�/��������2.png"));
			workSpaceButton.setRolloverIcon(icon); // ���ð�ť�ķ�תͼƬ
			workSpaceButton.setSelectedIcon(icon); // ���ð�ť��ѡ��ʱ��ʾͼƬ
			workSpaceButton.setSelected(true);
			workSpaceButton.addActionListener(new toolsButtonActionAdapter()); // ��ť�ļ�����
		}
		return workSpaceButton;
	}
	// �ɹ���������ť
	private ��Ӧ��ť getProgressButton() {
		if (progressButton == null) {
			progressButton = new ��Ӧ��ť();
			progressButton.setActionCommand("�ɹ�����");
			progressButton.setText("");
			progressButton.setIcon(new ImageIcon(getClass().getResource("/��Ŀ����ͼƬ�ļ�/�ɹ�1.png")));
			ImageIcon icon = new ImageIcon(getClass().getResource("/��Ŀ����ͼƬ�ļ�/�ɹ�2.png"));
			progressButton.setRolloverIcon(icon);
			progressButton.setSelectedIcon(icon);
		}
		return progressButton;
	}
	// ���Ź���ϵͳ
	private ��Ӧ��ť getDeptManagerButton() {
		if (deptManagerButton == null) {
			deptManagerButton = new ��Ӧ��ť();
			ImageIcon imageIcon = new ImageIcon(getClass().getResource("/��Ŀ����ͼƬ�ļ�/deptButton.png"));
			deptManagerButton.setIcon(imageIcon);
			ImageIcon icon = new ImageIcon(getClass().getResource("/��Ŀ����ͼƬ�ļ�/deptButton2.png"));
			deptManagerButton.setRolloverIcon(icon);
			deptManagerButton.setSelectedIcon(icon);
		}
		return deptManagerButton;
	}
	// �ֿ�������
	private ��Ӧ��ť getrukuButton() {
		if (bookProjectButton == null) {
			bookProjectButton = new ��Ӧ��ť();
			bookProjectButton.setIcon(new ImageIcon(getClass().getResource("/��Ŀ����ͼƬ�ļ�/���1.png")));
			ImageIcon icon = new ImageIcon(getClass().getResource("/��Ŀ����ͼƬ�ļ�/���2.png"));
			bookProjectButton.setSelectedIcon(icon);
			bookProjectButton.setRolloverIcon(icon);
			bookProjectButton.addActionListener(new toolsButtonActionAdapter());
		}
		return bookProjectButton;
	}
	// ��Ա����ϵͳ
	private ��Ӧ��ť getPersonnelManagerButton() {
		if (personnelManagerButton == null) {
			personnelManagerButton = new ��Ӧ��ť();
			ImageIcon imageIcon = new ImageIcon(getClass().getResource("/��Ŀ����ͼƬ�ļ�/person2.png"));
			personnelManagerButton.setIcon(imageIcon);
			ImageIcon icon = new ImageIcon(getClass().getResource("/��Ŀ����ͼƬ�ļ�/person1.png"));
			personnelManagerButton.setRolloverIcon(icon);
			personnelManagerButton.setSelectedIcon(icon);
		}
		return personnelManagerButton;
	}

	// С������� ��ȫ�� ͼ�갴ť ����Ӧ�¼�
	class toolsButtonActionAdapter implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == workSpaceButton) {
				BGPanel.removeAll();//���� չʾ����ϵ����
				
				smallBGPanel.setBounds(10, 63, 611, 376);
				
				change_label.setBounds(150, 35, 123, 15);
				change_label.setText("������������");
				
				BGPanel.add(whereLabel);
				BGPanel.add(smallBGPanel);
				BGPanel.add(change_label);
				
				repaint();
			}
			if (e.getSource() == bookProjectButton) {
				BGPanel.removeAll();
				
				smallBGPanel.setBounds(10, 63, 611, 386);

				change_label.setBounds(150, 35, 123, 15);
				change_label.setText("�ֿ����");
				
				�ֿ������� joinPanel = new �ֿ�������();
				BGPanel.add(joinPanel);
				BGPanel.add(whereLabel);
				BGPanel.add(change_label);
				
				repaint();
			}
		}
	}
}
