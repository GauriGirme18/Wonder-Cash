package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;

import ChangePassword.Change_Pass;
import CheckBalance.CheckBal;
import Profile.UserProfile;
import Recharge.REchargeServices;
import SplashScreen.Front;
import Transaction.deposit;
import Transaction.withdraw;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	 		
	 private JPanel contentPane;
	public Main(String username) {
		
		String name=username;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 80, 900,700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setUndecorated(true);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(113, 10, 623, 65);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Wonder Cash Bank");
		lblNewLabel.setBounds(158, 10, 376, 38);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 36));		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(49, 85, 175, 154);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		ImageIcon icon=new ImageIcon(this.getClass().getResource("/profile2.png"));
		lblNewLabel_1.setIcon(icon);
		lblNewLabel_1.setBounds(0, 0, 175, 154);
		panel_3.add(lblNewLabel_1,icon);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(329, 85, 175, 154);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBorder(new EmptyBorder(0, 0, 0, 0));
		ImageIcon icon2=new ImageIcon(this.getClass().getResource("/Recharge Service1.jpeg"));
		lblNewLabel_2.setIcon(icon2);
		lblNewLabel_2.setBounds(0, 0, 175, 154);
		panel_4.add(lblNewLabel_2,icon2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(602, 85, 175, 154);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBorder(new EmptyBorder(0, 0, 0, 0));
		ImageIcon icon3=new ImageIcon(this.getClass().getResource("/password.jpeg"));
		lblNewLabel_3.setIcon(icon3);
		lblNewLabel_3.setBounds(0, 0, 175, 154);
		panel_5.add(lblNewLabel_3,icon3);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(49, 362, 175, 154);
		panel.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBorder(new EmptyBorder(0, 0, 0, 0));
		ImageIcon icon4=new ImageIcon(this.getClass().getResource("/withdraw_1.jpeg"));
		lblNewLabel_5.setIcon(icon4);
		lblNewLabel_5.setBounds(0, 0, 175, 154);
		panel_6.add(lblNewLabel_5,icon4);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(329, 362, 175, 154);
		panel.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBorder(new EmptyBorder(0, 0, 0, 0));
		ImageIcon icon5=new ImageIcon(this.getClass().getResource("/with1.jpg"));
		lblNewLabel_4.setIcon(icon5);
		lblNewLabel_4.setBounds(0, 0, 175, 154);
		panel_7.add(lblNewLabel_4,icon5);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		panel_8.setBounds(602, 362, 175, 154);
		panel.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBorder(new EmptyBorder(0, 0, 0, 0));
		ImageIcon icon10=new ImageIcon(this.getClass().getResource("/check_balance.jpeg"));
		lblNewLabel_6.setIcon(icon10);
		lblNewLabel_6.setBounds(0, 0, 175, 154);
		panel_8.add(lblNewLabel_6,icon10);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_9.setBackground(Color.WHITE);
		panel_9.setBounds(25, 75, 833, 528);
		panel.add(panel_9);
		panel_9.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Profile");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserProfile uprofile=new UserProfile(name);
				uprofile.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBorder(new LineBorder(new Color(255, 51, 51)));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		btnNewButton_1.setBounds(51, 197, 107, 40);
		panel_9.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Recharge");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				REchargeServices rs=new REchargeServices(name);
				rs.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBorder(new LineBorder(new Color(255, 51, 51)));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		btnNewButton_2.setBounds(328, 197, 107, 40);
		panel_9.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Change Password");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Change_Pass chngpass=new Change_Pass(name);
				chngpass.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBorder(new LineBorder(new Color(255, 51, 51)));
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		btnNewButton_3.setBounds(581, 197, 195, 39);
		panel_9.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Deposit Money");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deposit d=new deposit(name);
				d.setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setBorder(new LineBorder(new Color(255, 51, 51)));
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		btnNewButton_4.setBounds(26, 470, 169, 40);
		panel_9.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Withdraw Money");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				withdraw d=new withdraw(name);
				d.setVisible(true);
				dispose();
			}
		});
		btnNewButton_5.setBorder(new LineBorder(new Color(255, 51, 51)));
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		btnNewButton_5.setBounds(311, 470, 195, 40);
		panel_9.add(btnNewButton_5);
		
		JButton btnNewButton_5_1 = new JButton("Check Balance");
		btnNewButton_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckBal check=new CheckBal(name);
				check.setVisible(true);
				dispose();
			}
		});
		btnNewButton_5_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		btnNewButton_5_1.setBorder(new LineBorder(new Color(255, 51, 51)));
		btnNewButton_5_1.setBackground(Color.WHITE);
		btnNewButton_5_1.setBounds(581, 470, 195, 40);
		panel_9.add(btnNewButton_5_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(421, 45, 1, 2);
		panel.add(separator);
		
		JButton btnNewButton = new JButton();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response=JOptionPane.showConfirmDialog(null,"Do you confirm to logout?","Confirm",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(response==JOptionPane.YES_OPTION) {
					Front f=new Front();
					f.setVisible(true);
					dispose();
				}
			}
		});
		ImageIcon icon8=new ImageIcon(this.getClass().getResource("/log_2.png"));
		btnNewButton.setIcon(icon8);
		btnNewButton.setBounds(836, 10, 44, 47);
		panel.add(btnNewButton);
		
		JButton btnNewButton_6 = new JButton();
		ImageIcon icon9=new ImageIcon(this.getClass().getResource("/back_6.jpeg"));
		btnNewButton_6.setIcon(icon9);
		btnNewButton_6.setBounds(25, 633, 62, 47);
		panel.add(btnNewButton_6);
		
		
	}
}