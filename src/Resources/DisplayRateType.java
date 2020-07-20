package Resources;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class DisplayRateType extends JFrame {

	private JPanel contentPane;
	private JCheckBox chckbxMonday;
	private JCheckBox chckbxTuesday;
	private JCheckBox chckbxWednesday;
	private JCheckBox chckbxThursday;
	private JCheckBox chckbxFriday;
	private JCheckBox chckbxSunday;
	private JCheckBox chckbxFriday1;
	private JCheckBox chckbxSaturday;
	private JCheckBox chckbxSunday1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayRateType frame = new DisplayRateType();
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
	public DisplayRateType() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblWeekday = new JLabel("Weekday");
		lblWeekday.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblRateType = new JLabel("RATE TYPE");
		lblRateType.setFont(new Font("Tahoma", Font.BOLD, 28));
		
		chckbxMonday = new JCheckBox("Monday");
		chckbxMonday.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		chckbxTuesday = new JCheckBox("Tuesday");
		chckbxTuesday.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		chckbxWednesday = new JCheckBox("Wednesday");
		chckbxWednesday.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		chckbxThursday = new JCheckBox("Thursday");
		chckbxThursday.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		chckbxFriday = new JCheckBox("Friday");
		chckbxFriday.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		chckbxSunday = new JCheckBox("Sunday");
		chckbxSunday.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		chckbxFriday1 = new JCheckBox("Friday");
		chckbxFriday1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		chckbxSaturday = new JCheckBox("Saturday");
		chckbxSaturday.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		chckbxSunday1 = new JCheckBox("Sunday");
		chckbxSunday1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		Connection conn = null;
		try {
			// create a String variable for the connection configuration
			String dbURL = "jdbc:sqlserver://localhost;"
					+ "instanceName = MSSQLSERVER;"
					+ "databaseName = hotel;"
					+ "user = madan;"
					+ "password = csis3275";
			
			// Establish a connection to the database server
			conn = DriverManager.getConnection(dbURL);
			if(conn != null) {
				try {
					String query = "select * from day where Day_Type = 'Weekday'";
				    
					PreparedStatement stmt = conn.prepareStatement(query);
					ResultSet rs = stmt.executeQuery();
					
					if(!(rs.next())) {
						JOptionPane.showMessageDialog(null, "RATE TYPE HAS NOT BEEN SET!/n PLEASE SET RATE TYPE FIRST!","NO RATE TYPE", 2);
						dispose();
					}
					
				    int monday = rs.getInt(2);
					int tuesday = rs.getInt(3);
					int wednesday = rs.getInt(4);
					int thursday = rs.getInt(5);
					int friday = rs.getInt(6);
					int sunday = rs.getInt(8);			
						
					if(monday==0)
						chckbxMonday.setSelected(false);
					else {
						chckbxMonday.setSelected(true);
						chckbxMonday.setFont(new Font("Arial", Font.BOLD, 15));
						chckbxMonday.setBackground(Color.CYAN);
					}
						
					if (tuesday==0) 
						chckbxTuesday.setSelected(false);
					else {
						chckbxTuesday.setSelected(true);
						chckbxTuesday.setFont(new Font("Arial", Font.BOLD, 15));
						chckbxTuesday.setBackground(Color.CYAN);
					}
						
					if (wednesday==0) 
						chckbxWednesday.setSelected(false);
					else {
						chckbxWednesday.setSelected(true);
						chckbxWednesday.setFont(new Font("Arial", Font.BOLD, 15));
						chckbxWednesday.setBackground(Color.CYAN);
					}
						
					if (thursday==0) 
						chckbxThursday.setSelected(false);
					else {
						chckbxThursday.setSelected(true);
						chckbxThursday.setFont(new Font("Arial", Font.BOLD, 15));
						chckbxThursday.setBackground(Color.CYAN);
					}
						
					if (friday==0) 
						chckbxFriday.setSelected(false);
					else {
						chckbxFriday.setSelected(true);
						chckbxFriday.setFont(new Font("Arial", Font.BOLD, 15));
						chckbxFriday.setBackground(Color.CYAN);
					}
							
					if (sunday==0) 
						chckbxSunday.setSelected(false);
					else {
						chckbxSunday.setSelected(true);
						chckbxSunday.setFont(new Font("Arial", Font.BOLD, 15));
						chckbxSunday.setBackground(Color.CYAN);
					}
							
					String query1 = "select * from day where Day_Type = 'Weekend'";
				    
					PreparedStatement stmt1 = conn.prepareStatement(query1);
					ResultSet rs1 = stmt1.executeQuery();
					while (rs1.next()) {
						int friday1 = rs1.getInt(6);
						int saturday1 = rs1.getInt(7);
						int sunday1 = rs1.getInt(8);
						
						if (friday1==0) 
							chckbxFriday1.setSelected(false);
						else {
							chckbxFriday1.setSelected(true);
							chckbxFriday1.setFont(new Font("Arial", Font.BOLD, 15));
							chckbxFriday1.setBackground(Color.CYAN);
						}
								
						if (saturday1==0) 
							chckbxSaturday.setSelected(false);
						else {
							chckbxSaturday.setSelected(true);
							chckbxSaturday.setFont(new Font("Arial", Font.BOLD, 15));
							chckbxSaturday.setBackground(Color.CYAN);
						}
								
						if (sunday1==0) 
							chckbxSunday1.setSelected(false);
						else {
							chckbxSunday1.setSelected(true);
							chckbxSunday1.setFont(new Font("Arial", Font.BOLD, 15));
							chckbxSunday1.setBackground(Color.CYAN);
						}
						
					}
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				} 
			}
				
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex);
		
		} finally {
			// close the connection after the job is done
				try {
					if (conn != null && !conn.isClosed()) {
						conn.close();
					}
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, ex);
			}
	}
		
	chckbxMonday.setEnabled(false);
	chckbxTuesday.setEnabled(false);
	chckbxWednesday.setEnabled(false);
	chckbxThursday.setEnabled(false);
	chckbxFriday.setEnabled(false);
	chckbxSunday.setEnabled(false);
	chckbxFriday1.setEnabled(false);
	chckbxSaturday.setEnabled(false);
	chckbxSunday1.setEnabled(false);
	
	
	
	
	JButton btnBack = new JButton("   OK");
	btnBack.setIcon(new ImageIcon(DisplayRateType.class.getResource("/Resources/OKbtn2.png")));
	btnBack.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	});
	
	btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		
	JLabel lblWeekday_1 = new JLabel("Weekend");
	lblWeekday_1.setFont(new Font("Tahoma", Font.BOLD, 18));
			
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(69)
					.addComponent(lblWeekday, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(chckbxSunday, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(chckbxFriday, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(chckbxThursday, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(chckbxWednesday, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(chckbxTuesday, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(chckbxMonday, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
					.addComponent(lblWeekday_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(chckbxFriday1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(chckbxSunday1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(chckbxSaturday, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
					.addGap(65))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(244)
					.addComponent(lblRateType, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(255, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(275, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addGap(269))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblRateType, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(29)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblWeekday, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(1)
											.addComponent(chckbxMonday, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(chckbxTuesday, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(chckbxWednesday, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(chckbxThursday, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(chckbxFriday, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(chckbxSunday, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(30)
									.addComponent(lblWeekday_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(65)
							.addComponent(chckbxFriday1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxSaturday, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxSunday1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(16))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

