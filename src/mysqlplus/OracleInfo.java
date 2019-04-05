package mysqlplus;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class OracleInfo extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tf_Ip;
	private JTextField tf_Port;
	private JTextField tf_Sid;
	private JTextField tf_User;
	private JTextField tf_Pw;
	private JTextField tf_Status;
	private JButton btn_Test;
	private JButton btn_Login;
	private JButton btn_Exit;
	private JLabel lbl_Ip;
	private JLabel lbl_Port;
	private JLabel lblSid;
	private JLabel lblUser;
	private JLabel lblPw;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OracleInfo frame = new OracleInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OracleInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 435, 337);
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setTitle("Sangkeun's SQL Developer");
		ImageIcon icon = new ImageIcon("src/sqlImage.jpg");
		setIconImage(icon.getImage());
		
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("ComboBox.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		setComponenets();
		setLayout();


	}

	private void setComponenets() {
		lbl_Ip = new JLabel("IP");
		lbl_Ip.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Ip.setFont(new Font("Dialog", Font.BOLD, 17));
		
		lbl_Port = new JLabel("Port");
		lbl_Port.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Port.setFont(new Font("Dialog", Font.BOLD, 17));
		
		lblSid = new JLabel("SID");
		lblSid.setHorizontalAlignment(SwingConstants.CENTER);
		lblSid.setFont(new Font("Dialog", Font.BOLD, 17));
		
		lblUser = new JLabel("USER");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setFont(new Font("Dialog", Font.BOLD, 17));
		
		lblPw = new JLabel("PW");
		lblPw.setHorizontalAlignment(SwingConstants.CENTER);
		lblPw.setFont(new Font("Dialog", Font.BOLD, 17));
		
		tf_Ip = new JTextField();
		tf_Ip.setHorizontalAlignment(SwingConstants.CENTER);
		tf_Ip.setFont(new Font("Dialog", Font.BOLD, 17));
		tf_Ip.setColumns(10);
		tf_Ip.setText("localhost");
		
		tf_Port = new JTextField();
		tf_Port.setHorizontalAlignment(SwingConstants.CENTER);
		tf_Port.setFont(new Font("Dialog", Font.BOLD, 17));
		tf_Port.setColumns(10);
		tf_Port.setText("1521");
		
		tf_Sid = new JTextField();
		tf_Sid.setHorizontalAlignment(SwingConstants.CENTER);
		tf_Sid.setFont(new Font("Dialog", Font.BOLD, 17));
		tf_Sid.setColumns(10);
		tf_Sid.setText("xe");
		
		tf_User = new JTextField();
		tf_User.setHorizontalAlignment(SwingConstants.CENTER);
		tf_User.setFont(new Font("Dialog", Font.BOLD, 17));
		tf_User.setColumns(10);
		
		tf_Pw = new JTextField();
		tf_Pw.setHorizontalAlignment(SwingConstants.CENTER);
		tf_Pw.setFont(new Font("Dialog", Font.BOLD, 17));
		tf_Pw.setColumns(10);
		
		btn_Test = new JButton("\uD14C\uC2A4\uD2B8");
		btn_Test.addActionListener(this);
		btn_Login = new JButton("\uB85C\uADF8\uC778");
		btn_Login.addActionListener(this);
		btn_Exit = new JButton("\uC885 \uB8CC");
		btn_Exit.addActionListener(this);

		tf_Status = new JTextField();
		tf_Status.setHorizontalAlignment(SwingConstants.CENTER);
		tf_Status.setColumns(12);
		tf_Status.setEditable(false);
	}
	
	public void setLayout() {
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(lbl_Ip, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
									.addComponent(lbl_Port, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblSid, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblUser, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPw, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(tf_Sid, 290, 290, 290)
								.addComponent(tf_User, 290, 290, 290)
								.addComponent(tf_Pw, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
								.addComponent(tf_Port, 290, 290, 290)
								.addComponent(tf_Ip, 290, 290, 290)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btn_Test)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_Login, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_Exit, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tf_Status, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(41, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl_Ip, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(tf_Ip, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_Port, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(tf_Port, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSid, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(tf_Sid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUser, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(tf_User, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPw, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(tf_Pw, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_Test)
						.addComponent(btn_Login)
						.addComponent(btn_Exit)
						.addComponent(tf_Status, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//e.getSource() 이벤트가 발생한 위치 OBJECT로 반환
		if((JButton)e.getSource() == btn_Exit) {
			int result = JOptionPane.showConfirmDialog(null, "정말 종료하시겠습니까?","프로그램 종료",JOptionPane.YES_NO_OPTION);
			if(result == 0) {
				System.exit(0);
			}
			return;
		}
		if((JButton)e.getSource() == btn_Test) {
			if(checkAll()) {
				try {
					Connection conn = DBConn.getConnection(tf_Ip.getText(), tf_Port.getText(), tf_Sid.getText(), tf_User.getText(), tf_Pw.getText());
					tf_Status.setText("성공");
					return;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					tf_Status.setText(e1.getMessage());
					return;
				}		
			}
			JOptionPane.showMessageDialog(null, "모든 값을 입력하세요!");
			return;
		}
		if((JButton)e.getSource() == btn_Login) {
			if(checkAll()) {
				try {
					Connection conn = DBConn.getConnection(tf_Ip.getText(), tf_Port.getText(), tf_Sid.getText(), tf_User.getText(), tf_Pw.getText());
					MySQLPlus frame = new MySQLPlus(conn);
					frame.setVisible(true);
					dispose();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					tf_Status.setText(e1.getMessage());
					JOptionPane.showMessageDialog(null, "연결 실패");
					return;
				}		
			}else {
				JOptionPane.showMessageDialog(null, "모든 값을 입력하세요!");
				return;
			}
		}
		
	}

	private boolean checkAll() {
		// TODO Auto-generated method stub
		if(!tf_Ip.getText().equals("") && !tf_Port.getText().equals("") && !tf_Sid.getText().equals("")
				&& !tf_User.getText().equals("") && !tf_Pw.getText().equals("")) {
			return true;
		}
		return false;
	}
	
	
}
