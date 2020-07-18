package Resources;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class RateType extends JFrame {

	private JPanel contentPane;
	private JButton btnCancel;
	private JButton btnSave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RateType frame = new RateType();
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
	public RateType() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblRateType = new JLabel("RATE TYPE");
		lblRateType.setFont(new Font("Tahoma", Font.BOLD, 28));
		
		JLabel lblWeekday = new JLabel("Weekday");
		lblWeekday.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JCheckBox chckbxMonday = new JCheckBox("Monday");
		chckbxMonday.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JCheckBox chckbxTuesday = new JCheckBox("Tuesday");
		chckbxTuesday.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JCheckBox chckbxWednesday = new JCheckBox("Wednesday");
		chckbxWednesday.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JCheckBox chckbxThursday = new JCheckBox("Thursday");
		chckbxThursday.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JCheckBox chckbxFriday = new JCheckBox("Friday");
		chckbxFriday.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JCheckBox chckbxSunday = new JCheckBox("Sunday");
		chckbxSunday.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblWeekday_1 = new JLabel("Weekend");
		lblWeekday_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JCheckBox chckbxFriday1 = new JCheckBox("Friday");
		chckbxFriday1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JCheckBox chckbxSaturday = new JCheckBox("Saturday");
		chckbxSaturday.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JCheckBox chckbxSunday1 = new JCheckBox("Sunday");
		chckbxSunday1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancel.setIcon(new ImageIcon(RateType.class.getResource("/Resources/cancelbtn.png")));
		
		btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] statusWeekday = new int[7];
				int[] statusWeekend = new int[7];
				statusWeekday[5] = 0;
				statusWeekend[0] = 0;
				statusWeekend[1] = 0;
				statusWeekend[2] = 0;
				statusWeekend[3] = 0;
				
				if(chckbxMonday.isSelected())
					statusWeekday[0] = 1;
					else statusWeekday[0] = 0;
				if(chckbxTuesday.isSelected())
					statusWeekday[1] = 1;
					else statusWeekday[1] = 0;
				if(chckbxWednesday.isSelected())
					statusWeekday[2] = 1;
					else statusWeekday[2] = 0;
				if(chckbxThursday.isSelected())
					statusWeekday[3] = 1;
					else statusWeekday[3] = 0;
				if(chckbxFriday.isSelected())
					statusWeekday[4] = 1;
					else statusWeekday[4] = 0;
				if(chckbxSunday.isSelected())
					statusWeekday[6] = 1;
					else statusWeekday[6] = 0;
				if(chckbxFriday1.isSelected())
					statusWeekend[4] = 1;
					else statusWeekend[4] = 0;
				if(chckbxSaturday.isSelected())
					statusWeekend[5] = 1;
					else statusWeekend[5] = 0;
				if(chckbxSunday1.isSelected())
					statusWeekend[6] = 1;
					else statusWeekend[6] = 0;
				
				Connection conn = null;
				Statement statement = null;
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
							String query = "select * from day";
						    
							PreparedStatement stmt = conn.prepareStatement(query);
							ResultSet rs = stmt.executeQuery();
							
							if(rs.next()) {
								statement = conn.createStatement();
								String update = "monday="+statusWeekday[0]+", tuesday="+statusWeekday[1]+", wednesday="+statusWeekday[2]+", thursday="+statusWeekday[3]+", friday="+statusWeekday[4]+", sunday="+statusWeekday[6];
								String updateSQL = "UPDATE day SET " + update + " WHERE Day_Type = 'Weekday'";
								statement.executeUpdate(updateSQL);
								
								String update1 = "friday="+statusWeekend[4]+", saturday="+statusWeekend[5]+", sunday="+statusWeekend[6];
								String updateSQL1 = "UPDATE day SET " + update1 + " WHERE Day_Type = 'Weekend'";
								statement.executeUpdate(updateSQL1);
								
							} else {
								PreparedStatement stmt1 = null;
								String insertSQL1 = "insert into day values (?, ?, ?, ?, ?, ?, ?, ?)";
								stmt1 = conn.prepareStatement(insertSQL1);
								stmt1.setString(1, "Weekday");
								stmt1.setInt(2, statusWeekday[0]);
								stmt1.setInt(3, statusWeekday[1]);
								stmt1.setInt(4, statusWeekday[2]);
								stmt1.setInt(5, statusWeekday[3]);
								stmt1.setInt(6, statusWeekday[4]);
								stmt1.setInt(7, statusWeekday[5]);
								stmt1.setInt(8, statusWeekday[6]);
								stmt1.executeUpdate();	
								
								PreparedStatement stmt2 = null;
								String insertSQL2 = "insert into day values (?, ?, ?, ?, ?, ?, ?, ?)";
								stmt2 = conn.prepareStatement(insertSQL2);
								stmt2.setString(1, "Weekend");
								stmt2.setInt(2, statusWeekend[0]);
								stmt2.setInt(3, statusWeekend[1]);
								stmt2.setInt(4, statusWeekend[2]);
								stmt2.setInt(5, statusWeekend[3]);
								stmt2.setInt(6, statusWeekend[4]);
								stmt2.setInt(7, statusWeekend[5]);
								stmt2.setInt(8, statusWeekend[6]);
								stmt2.executeUpdate();
								stmt1.close();
								stmt2.close();
							}
						
							
						} catch (Exception exp) {
							exp.printStackTrace();
						}
				}
			} catch (SQLException ex) {
					ex.printStackTrace();
				
			} finally {
					// close the connection after the job is done
				try {
					if (conn != null && !conn.isClosed()) {
						conn.close();
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
	
			int selectedOption = JOptionPane.showConfirmDialog(null, 
				"RATE TYPE IS SUCCESSFULLY SAVED!\nDO YOU WANT TO SET ROOM TYPE ?",  "Choose", 
                JOptionPane.YES_NO_OPTION); 
			if (selectedOption == JOptionPane.NO_OPTION) {
				dispose();
			}
			else {
				dispose();
				RoomType rmType = null;
				try {
						rmType = new RoomType();
					} catch (IOException e1) {
						e1.printStackTrace();
				}
				rmType.setVisible(true);
			}
				
		}
	});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSave.setIcon(new ImageIcon(RateType.class.getResource("/Resources/savebtn.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(245)
					.addComponent(lblRateType)
					.addContainerGap(255, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(68, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblWeekday)
							.addGap(30)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(chckbxMonday)
								.addComponent(chckbxFriday, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
								.addComponent(chckbxTuesday, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
								.addComponent(chckbxWednesday, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(chckbxThursday, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(chckbxSunday, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addGap(3)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
							.addComponent(lblWeekday_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(chckbxFriday1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
								.addComponent(chckbxSaturday, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
								.addComponent(chckbxSunday1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
							.addGap(65))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(123)
							.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblRateType)
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblWeekday)
						.addComponent(lblWeekday_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(chckbxMonday)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxTuesday, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxWednesday, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxThursday, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxFriday, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxSunday, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(chckbxFriday1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(chckbxSaturday, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(chckbxSunday1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCancel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSave, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGap(13))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
