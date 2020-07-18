import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Resources.DisplayRateType;
import Resources.DisplayRoomType;
import Resources.RateType;
import Resources.RoomType;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;

public class RoomSetting extends JFrame {

	private JPanel ctpMain;
	private JButton btnRoomType;
	private JButton btnRateType;
	private JButton btnDisplay;
	private JButton btnDisplay_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomSetting frame = new RoomSetting();
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
		ctpMain = new JPanel();
		ctpMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ctpMain);
		
		btnRoomType = new JButton("ROOM TYPE");
		btnRoomType.setBackground(Color.GREEN);
		
		btnRoomType.setIcon(new ImageIcon(RoomSetting.class.getResource("/Resources/baseline_hotel_black_18dp.png")));
		
		btnRoomType.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		btnRateType = new JButton("RATE TYPE");
		btnRateType.setBackground(Color.GREEN);
	
		btnRateType.setIcon(new ImageIcon(RoomSetting.class.getResource("/Resources/baseline_monetization_on_black_18dp.png")));
		btnRateType.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblRoomSetting = new JLabel("ROOM SETTING");
		lblRoomSetting.setFont(new Font("Tahoma", Font.BOLD, 28));
		
		btnDisplay = new JButton(" SHOW ROOM TYPE");
		btnDisplay.setBackground(Color.GREEN);
		
		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		btnDisplay_1 = new JButton(" SHOW RATE TYPE");
		btnDisplay_1.setBackground(Color.GREEN);
		
		btnDisplay_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon(RoomSetting.class.getResource("/Resources/Exitbtn.png")));
		GroupLayout gl_ctpMain = new GroupLayout(ctpMain);
		gl_ctpMain.setHorizontalGroup(
			gl_ctpMain.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_ctpMain.createSequentialGroup()
					.addGap(55)
					.addGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING)
						.addComponent(btnRateType, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
						.addComponent(btnRoomType, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))
					.addGap(89)
					.addGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING)
						.addComponent(btnDisplay, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDisplay_1, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
					.addGap(58))
				.addGroup(gl_ctpMain.createSequentialGroup()
					.addContainerGap(256, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
					.addGap(254))
				.addGroup(gl_ctpMain.createSequentialGroup()
					.addGap(212)
					.addComponent(lblRoomSetting)
					.addContainerGap(217, Short.MAX_VALUE))
		);
		gl_ctpMain.setVerticalGroup(
			gl_ctpMain.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_ctpMain.createSequentialGroup()
					.addComponent(lblRoomSetting)
					.addGroup(gl_ctpMain.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_ctpMain.createSequentialGroup()
							.addGap(84)
							.addComponent(btnDisplay, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(btnDisplay_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_ctpMain.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRoomType, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(btnRateType, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(62)))
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		ctpMain.setLayout(gl_ctpMain);
	}
	
	private void createEvents() {
		btnRoomType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ctpMain.hide();
				RoomType rmType = null;
				try {
					rmType = new RoomType();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				rmType.setVisible(true);
			}
		});
		
		btnRateType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RateType rdType = new RateType();
				rdType.setVisible(true);
			}
		});
		
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayRoomType dispRmType = new DisplayRoomType();
				dispRmType.setVisible(true);
			}
		});
		
		btnDisplay_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DisplayRateType dispRdType = new DisplayRateType();
				dispRdType.setVisible(true);
			}
		});
		
	}
	
	/**
	 * Create the frame.
	 */
	public RoomSetting() {
		setupComponents();
		createEvents();
	}
}
