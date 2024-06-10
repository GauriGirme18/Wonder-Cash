package ForgetPass;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

import Login.Login;
import Main.Main;

import javax.swing.JSeparator;

public class forget_pass extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JPasswordField passwordField;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_2;
	private JSeparator separator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					forget_pass frame = new forget_pass();
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
	public forget_pass(String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 80, 650, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 51, 51));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JLabel lblNewLabel = new JLabel("Create new password :");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblNewLabel.setBounds(41, 115, 242, 40);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setBounds(302, 115, 176, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Confirm password :");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblNewLabel_1.setBounds(41, 212, 217, 33);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(255, 255, 255));
		passwordField.setBounds(302, 210, 176, 39);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Change");
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con=null;
				String pass=passwordField.getText();
				if(!(textField.getText().matches(pass))) {
					JOptionPane.showMessageDialog(null,"Confirm password is not matching to the password.");
				}
				
				else {
				try
				{
					Class.forName("oracle.jdbc.OracleDriver");
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","12345");
					
					PreparedStatement pstate=null;
					pstate=con.prepareStatement("update register set password=? where userName=?");
					pstate.setString(1,textField.getText());
					pstate.setString(2,username);
					int i=0;
					i=pstate.executeUpdate();
					if(i>0) {
						JOptionPane.showMessageDialog(null,"Successfully changed the password");
						Login l=new Login();
						l.setVisible(true);
						dispose();
					}
					}
				
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
				}
				
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnNewButton.setBounds(104, 326, 131, 40);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login l=new Login();
				l.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnNewButton_1.setBounds(337, 326, 124, 40);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_2 = new JLabel("Forget Password");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(199, 10, 308, 55);
		contentPane.add(lblNewLabel_2);
		
		separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(199, 57, 258, 7);
		contentPane.add(separator);
	}
}
