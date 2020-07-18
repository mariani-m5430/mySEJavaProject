package Resources;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class DisplayRoomType extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnBack;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayRoomType frame = new DisplayRoomType();
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
	public DisplayRoomType() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JLabel lblListOfRoom = new JLabel("LIST OF ROOM TYPE");
		lblListOfRoom.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		table = new JTable();
		String[] column = {"Room Name", "Room Size", "Number of Rooms", "Weekday Rate ($)", "Weekend Rate ($)"};
	    table.setRowHeight(18);
	    JTableHeader tableHeader = table.getTableHeader();
	    tableHeader.setBackground(Color.black);
	    tableHeader.setForeground(Color.white);
	    Font headerFont = new Font("Verdana", Font.PLAIN, 14);
	    tableHeader.setFont(headerFont);

	    
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.setColumnIdentifiers(column);
		model.addRow(column);
		
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
					String query = "select * from room";
				    
					PreparedStatement stmt = conn.prepareStatement(query);
					ResultSet rs = stmt.executeQuery();
					
					while(rs.next()) {
							String col2 = ""+rs.getDouble(2);
							String col3 = ""+rs.getInt(3);
							String col4 = ""+rs.getDouble(4);
							String col5 = ""+rs.getDouble(5);
							String[] data = {rs.getString(1), col2, col3, col4, col5};
							model.addRow(data);
						}
					conn.close();
					
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
		
		btnBack = new JButton("  OK");
		btnBack.setIcon(new ImageIcon(DisplayRoomType.class.getResource("/Resources/OKbtn2.png")));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(table, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(237, Short.MAX_VALUE)
					.addComponent(lblListOfRoom)
					.addGap(232))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(276, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addGap(275))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblListOfRoom)
					.addGap(18)
					.addComponent(table, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
