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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
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
import java.awt.Color;


public class RoomType extends JFrame {

	private JPanel contentPane;
	private JTextField txtRoomName;
	private JTextField txtSize;
	private JTextField txtNumber;
	private JTextField txtWeekday;
	private JTextField txtWeekend;
	private JButton btnCancel;
	private JButton btnSave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomType frame = new RoomType();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void setupComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblRoomType = new JLabel("ROOM TYPE");
		lblRoomType.setFont(new Font("Tahoma", Font.BOLD, 28));
		
		JLabel lblRoomName = new JLabel("Room Name ");
		lblRoomName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblRoomSize = new JLabel("Room Size");
		lblRoomSize.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNumberOfRooms = new JLabel("Number of Rooms");
		lblNumberOfRooms.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtRoomName = new JTextField();
		txtRoomName.setBackground(Color.CYAN);
		txtRoomName.setColumns(10);
		
		txtSize = new JTextField();
		txtSize.setBackground(Color.CYAN);
		txtSize.setColumns(10);
		
		txtNumber = new JTextField();
		txtNumber.setBackground(Color.CYAN);
		txtNumber.setColumns(10);
		
		btnCancel = new JButton("CANCEL");
		btnCancel.setBackground(Color.GREEN);
		
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancel.setIcon(new ImageIcon(RoomType.class.getResource("/Resources/cancelbtn.png")));
		
		btnSave = new JButton("SAVE");
		btnSave.setBackground(Color.GREEN);
		
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSave.setIcon(new ImageIcon(RoomType.class.getResource("/Resources/savebtn.png")));
		
		JLabel lblWeekendRate_1 = new JLabel("Weekend Rate");
		lblWeekendRate_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblWeekendRate = new JLabel("Weekday Rate");
		lblWeekendRate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtWeekday = new JTextField();
		txtWeekday.setBackground(Color.CYAN);
		txtWeekday.setColumns(10);
		
		txtWeekend = new JTextField();
		txtWeekend.setBackground(Color.CYAN);
		txtWeekend.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(175)
					.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addGap(89)
					.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(149, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(152)
					.addComponent(lblRoomName)
					.addGap(92)
					.addComponent(txtRoomName, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(126, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(235)
					.addComponent(lblRoomType)
					.addContainerGap(249, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(152)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblWeekendRate_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblWeekendRate, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(txtWeekend, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtWeekday, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
							.addGap(1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(152, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblRoomSize, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
									.addGap(86))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNumberOfRooms, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
									.addGap(38)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtNumber, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtSize, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
							.addGap(2)))
					.addGap(227))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(3)
					.addComponent(lblRoomType)
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblRoomName, Alignment.TRAILING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(txtRoomName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(1)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(22)
							.addComponent(lblRoomSize, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addGap(21)
							.addComponent(lblNumberOfRooms, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addComponent(txtSize, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
							.addComponent(txtNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(21)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(lblWeekendRate, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addGap(23)
							.addComponent(lblWeekendRate_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtWeekday, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(20)
							.addComponent(txtWeekend, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addGap(13))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addGap(15))))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public static boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
	}
	
	private void createEvents() {
		
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public RoomType() throws IOException {
		setupComponents();
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtRoomName.getText();
				String size = txtSize.getText();
				String number = txtNumber.getText();
				String rtWeekday = txtWeekday.getText();
				String rtWeekend = txtWeekend.getText();
				Boolean isExisted = false;
				
				if(name.isBlank()||size.isBlank()||number.isBlank()||rtWeekday.isBlank()||rtWeekend.isBlank()) {
					JOptionPane.showMessageDialog(null, "FIELD MAY NOT BE EMPTY!","EMPTY FIELD", 2);
					dispose();
					RoomType rmType = null;
					try {
						rmType = new RoomType();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					rmType.setVisible(true);
				}
				else 
				if (!(isNumeric(size)&&isNumeric(number)&&isNumeric(rtWeekday)&&isNumeric(rtWeekend))){
					JOptionPane.showMessageDialog(null, "WRONG DATA TYPE! \nRoom Size, Number of Rooms, Weekday Rate and Weekend Rate MUST BE FILLED WITH NUMBERS","WRONG DATA TYPE", 2);
					//getContentPane().removeAll();
					dispose();
					RoomType rmType = null;
					try {
						rmType = new RoomType();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					rmType.setVisible(true);
				}
				else {	
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
							
							double rmSize = Double.parseDouble(size);
							int numOfroom = Integer.parseInt(number);
							double weekday = Double.parseDouble(rtWeekday);
							double weekend = Double.parseDouble(rtWeekend);
							
							Statement stmt = conn.createStatement();
							ResultSet rs = stmt.executeQuery("select * from room");
							while (rs.next()) {
								if(name.toLowerCase().equals(rs.getString(1).toLowerCase())){
									isExisted = true;
									JOptionPane.showMessageDialog(null, name + " ALREADY EXISTS!\nPLEASE INPUT ANOTHER ROOM TYPE","DUPLICATE ROOM TYPE", 2);
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
							
							if (!(isExisted)) {
								PreparedStatement stmt2 = null;
								String insertSQL = "insert into room values (?, ?, ?, ?, ?)";
								stmt2 = conn.prepareStatement(insertSQL);
								stmt2.setString(1, name);
								stmt2.setDouble(2, rmSize);
								stmt2.setInt(3, numOfroom);
								stmt2.setDouble(4, weekday);
								stmt2.setDouble(5, weekend);
								stmt2.executeUpdate();
								
								
								int selectedOption = JOptionPane.showConfirmDialog(null, name +
										" ROOM TYPE IS SUCCESSFULLY SAVED!\nDO YOU WANT TO SET ANOTHER ROOM TYPE ?", 
					                    "Choose", JOptionPane.YES_NO_OPTION); 
								if (selectedOption == JOptionPane.NO_OPTION) {
									stmt.close();
									stmt2.close();
									rs.close();
									conn.close();
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
				}	
			}
		});
		
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
	}

}
