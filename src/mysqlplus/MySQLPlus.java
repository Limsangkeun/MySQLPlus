package mysqlplus;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
//DBConn.close 꼭 호출시키기
public class MySQLPlus extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection conn;
	private JPanel contentPane;
	private JTextArea ta_queryArea;
	private JButton btn_CTable;
	private JButton btn_CSeq;
	private JButton btn_CProc;
	private JButton btn_CTrig;
	private JButton btn_CFunction;
	private JButton btn_select;
	private JButton btn_Insert;
	private JButton btn_Delete;
	private JButton btn_Execute;
	private JButton btn_Reset;
	private JButton btn_FreeSQL;
	private JButton btn_Grant;
	private JButton btn_CUser;
	private JButton btn_Logout;
	private JScrollPane inputScroll;
	private JScrollPane resultScroll;
	private JLabel lblResult;
	private JTable table;
	private DefaultTableModel model;
	private JTextArea ta_resultArea;
	/**
	 * Create the frame.
	 */
	public MySQLPlus(Connection conn) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Sangkeun's SQL Developer");
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e) {
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
		setBounds(100, 100, 1200, 739);
		ImageIcon icon = new ImageIcon("src/sqlImage.jpg");
		setIconImage(icon.getImage());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.conn = conn;
		setComponents();
		setLayout();
	}

	public void setComponents() {
	
		ta_queryArea = new JTextArea();
		ta_queryArea.setFont(new Font("돋움체", Font.BOLD | Font.ITALIC, 20));
		inputScroll = new JScrollPane(ta_queryArea);
		resultScroll = new JScrollPane();
		
		ta_resultArea = new JTextArea();
		ta_resultArea.setFont(new Font("돋움체", Font.BOLD | Font.ITALIC, 20));
		ta_resultArea.setEditable(false);
		resultScroll.setViewportView(ta_resultArea);

		
		btn_CTable = new JButton("Create Table");
		btn_CTable.addActionListener(this);
		
		btn_CSeq = new JButton("Create Seq");
		btn_CSeq.addActionListener(this);
		
		btn_CProc = new JButton("Create Proc");
		btn_CProc.addActionListener(this);
		
		btn_CTrig = new JButton("Create Trig");
		btn_CTrig.addActionListener(this);
		
		btn_CFunction = new JButton("Create Func");
		btn_CFunction.addActionListener(this);
		
		btn_select = new JButton("Select");
		btn_select.addActionListener(this);
		
		btn_Insert = new JButton("Insert");
		btn_Insert.addActionListener(this);
		
		btn_Delete = new JButton("Delete");
		btn_Delete.addActionListener(this);
		
		btn_Execute = new JButton("Execute");
		btn_Execute.addActionListener(this);
		
		btn_Reset = new JButton("Reset");
		btn_Reset.addActionListener(this);
		
		btn_FreeSQL = new JButton("Free SQL");
		btn_FreeSQL.addActionListener(this);
		
		btn_CUser = new JButton("Create User");
		btn_CUser.addActionListener(this);
		btn_CUser.setEnabled(false);
		
		btn_Grant = new JButton("Grant");
		btn_Grant.addActionListener(this);
		btn_Grant.setEnabled(false);
		
		btn_Logout = new JButton("Logout");
		btn_Logout.addActionListener(this);
	}
	
	public void setLayout() {
		
		lblResult = new JLabel("Result");
		lblResult.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblResult.setHorizontalAlignment(SwingConstants.LEFT);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(resultScroll, GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE)
										.addComponent(inputScroll, GroupLayout.PREFERRED_SIZE, 962, Short.MAX_VALUE))
									.addGap(37))
								.addComponent(lblResult))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btn_CTable, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_CSeq, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_CProc, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_CTrig, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_CFunction, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_select, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_Insert, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_Delete, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_FreeSQL, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_Logout, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_CUser, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_Grant, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
							.addGap(26))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btn_Execute, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_Reset, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addComponent(btn_CTable, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_CSeq, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_CProc, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_CTrig, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_CFunction, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_select, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_Insert, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_Delete, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(inputScroll, GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(lblResult)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(resultScroll, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btn_Execute, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_Reset, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
							.addGap(20))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_FreeSQL, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_Logout, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_CUser, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_Grant, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		contentPane.setLayout(gl_contentPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton button = (JButton)e.getSource();
		StringBuilder sb = new StringBuilder();
		if(button == btn_CTable) {
			ta_queryArea.setText("CREATE TABLE tname (\n\n)");
		}
		else if(button == btn_CSeq) {
			sb.append("CREATE OR REPLACE SEQUENCE sname\n");
			sb.append("increment by \n");
			sb.append("start with \n");
			sb.append("--MAXVALUE \n");
			sb.append("--MINVALUE \n");
			sb.append("--NOCYCLE");
			ta_queryArea.setText(sb.toString());
		}
		else if(button == btn_CProc) {
			sb.append("CREATE OR REPLACE PROCEDURE pname\n");
			sb.append("(\n");
			sb.append("\n)\n");
			sb.append("IS\n");
			sb.append("\nBEGIN\n");
			sb.append("\nEND;\n");
			sb.append("/");
			ta_queryArea.setText(sb.toString());
		}
		else if(button == btn_CTrig) {
			sb.append("CREATE OR REPLACE TRIGGER trigName\n");
			sb.append("(BEFORE/AFTER)\n");
			sb.append("(INSERT/DELETE/UPDATE) ON tName\n");
			sb.append("FOR EACH ROW\n");
			sb.append("BEGIN\n\n");
			sb.append("END;\n");
			sb.append("/");
			
			ta_queryArea.setText(sb.toString());
		}
		else if(button == btn_CFunction) {
			//sb.append("select * from tab;\n");
			sb.append("CREATE OR REPLACE FUNCTION fName\n");
			sb.append("(\n\n)\n");
			sb.append("RETURN \n");
			sb.append("IS \n");
			sb.append("BEGIN \n\n");
			sb.append("END;\n");
			sb.append("/");
			
			//sb.append("")
			ta_queryArea.setText(sb.toString());
		}
		else if(button == btn_select) {
			sb.append("SELECT col1.. FROM tName");
			ta_queryArea.setText(sb.toString());
		}
		else if(button == btn_Insert) {
			sb.append("INSERT INTO tName(cols..) VALUES(values...)");
			ta_queryArea.setText(sb.toString());
		}
		else if(button == btn_Delete) {
			sb.append("DELETE FROM tName WHERE = ");
			ta_queryArea.setText(sb.toString());
		}
		else if(button == btn_Reset) {
			ta_queryArea.setText("");
		}
		else if(button == btn_FreeSQL) {
			ta_queryArea.setText("");
		}
		else if(button == btn_Grant) {
			sb.append("GRANT a1, a2 TO userName");
			ta_queryArea.setText(sb.toString());
		}
		else if(button == btn_CUser) {
			sb.append("CREATE USER uName IDENTIFIED BY pw");
			ta_queryArea.setText(sb.toString());
		}
		else if(button == btn_Logout) {
			dispose();
			OracleInfo frame = new OracleInfo();
			frame.setVisible(true);
		}
		else if(button == btn_Execute) {
			acceptQuery();
		}
	}
	
	private void acceptQuery() {
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		try
		{
			String query = ta_queryArea.getText().toUpperCase().trim().replace('\n', ' ').replace('\t', ' ');
			
			pstmt = conn.prepareStatement(query);
			if(ta_queryArea.getText().toUpperCase().indexOf("SELECT")==0) {
				
				ResultSet rs = pstmt.executeQuery();
				int cols = rs.getMetaData().getColumnCount();
				String columns[] = new String[cols];
				
				for(int i=1; i<=cols; i++) {
					columns[i-1]=rs.getMetaData().getColumnLabel(i);
					//ta_resultArea.append(rs.getMetaData().getColumnLabel(i)+"\t");
				}
				
				model = new DefaultTableModel(columns,0);
				table = new JTable(model);
				resultScroll.setViewportView(table);
				//ta_resultArea.append("\n");
				while(rs.next()) {
					for(int i=1; i<=cols; i++) {
						columns[i-1] = String.valueOf(rs.getObject(i));
						//ta_resultArea.append(rs.getObject(i)+"\t");
					}
					//ta_resultArea.append("\n");
					model.addRow(columns);
				}
				if(rs !=null) {
					try {
						if(!rs.isClosed()) {
							rs.close();
						}
					}catch (Exception e) {
						// TODO: handle exception
					}
				}
				
			}else {
				resultScroll.setViewportView(ta_resultArea);
				int result = pstmt.executeUpdate();
				System.out.println(result);
				ta_resultArea.setText("");
				System.out.println(query);
					System.out.println(result);
					if(query.toUpperCase().indexOf("CREATE TABLE")!=-1) {
						ta_resultArea.setText("테이블이 생성되었습니다.");
					}else if(query.toUpperCase().indexOf("PROCEDURE")!=-1){ //프로세져
						ta_resultArea.setText("프로시져가 생성되었습니다.");
					}else if(query.toUpperCase().indexOf("TRIGGER")!=-1){ //
						ta_resultArea.setText("트리거가 생성되었습니다.");
					}else if(query.toUpperCase().indexOf("FUNCTION")!=-1){ //
						ta_resultArea.setText("함수가 생성되었습니다.");
					}else if(query.toUpperCase().indexOf("SEQUENCE")!=-1){ //
						ta_resultArea.setText("시퀀스가 생성되었습니다.");
					}else if(query.toUpperCase().indexOf("INSERT")!=-1) {
						ta_resultArea.setText(result+"개를 삽입했습니다.");
					}else if(query.toUpperCase().indexOf("DELETE")!=-1) {
						ta_resultArea.setText(result+"개를 삭제했습니다.");
					}else if(query.toUpperCase().indexOf("UPDATE")!=-1) {
						ta_resultArea.setText(result+"개를 수정했습니다.");
					}		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			ta_resultArea.setText(e.toString());
		} finally {
			if(pstmt != null) {
				try {
					if(!pstmt.isClosed()) {
						pstmt.close();
					}
				}catch(Exception e) {
					
				}
			}
		}
	}
	
}
