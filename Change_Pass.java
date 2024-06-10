package ChangePassword;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import Main.Main;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class Change_Pass extends JFrame {

	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Change_Pass frame = new Change_Pass();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private JPasswordField txtconpass;
	private JTextField txtpass;
	/**
	 * Create the frame.
	 */
	private JPanel contentPane;
	public Change_Pass(String name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350,80,900,700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 51, 51));
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 51, 51));
		panel.setBounds(206,124,511,458);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblpass = new JLabel("Enter New Password :");
		lblpass.setForeground(Color.WHITE);
		lblpass.setFont(new Font("Verdana", Font.PLAIN, 22));
		lblpass.setBounds(39, 120, 267, 32);
		panel.add(lblpass);
		
		JLabel lblconpass = new JLabel("Confirm Password :");
		lblconpass.setForeground(Color.WHITE);
		lblconpass.setFont(new Font("Verdana", Font.PLAIN, 22));
		lblconpass.setBounds(39, 204, 237, 32);
		panel.add(lblconpass);
		
		JButton btnchange = new JButton("Change");
		btnchange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Connection con=null;
					String pass=txtconpass.getText();
					if(!(txtpass.getText().matches(pass)))
					{
						JOptionPane.showMessageDialog(null,"Confirm password is not matching to the password.","Error",JOptionPane.ERROR_MESSAGE);
					}
					if(txtpass.getText().length()<8) {
						JOptionPane.showMessageDialog(null,"Password should be grater than 8 characters.","Error",JOptionPane.ERROR_MESSAGE);

					}
					else 
					{
						try
						{
							Class.forName("oracle.jdbc.OracleDriver");
							con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","12345");
						
							PreparedStatement pstate=null;
							pstate=con.prepareStatement("update register set password=? where userName=?");
							pstate.setString(1,txtpass.getText());
							pstate.setString(2,name);
							int i=0;
							i=pstate.executeUpdate();
							if(i>0) 
							{
								JOptionPane.showMessageDialog(null,"Successfully changed the password");
								Main m=new Main(name);
								m.setVisible(true);
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
		btnchange.setBackground(Color.WHITE);
		btnchange.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnchange.setBounds(372, 395, 118, 42);
		panel.add(btnchange);
		
		JButton btnexit = new JButton("Exit");
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main m=new Main(name);
				m.setVisible(true);
				dispose();
			}
		});
		btnexit.setBackground(Color.WHITE);
		btnexit.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnexit.setBounds(24, 395, 109, 42);
		panel.add(btnexit);
		
		txtconpass = new JPasswordField();
		txtconpass.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtconpass.setBounds(316, 208, 136, 30);
		panel.add(txtconpass);
		
		txtpass = new JTextField();
		txtpass.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpass.setBounds(316, 120, 136, 30);
		panel.add(txtpass);
		txtpass.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(30, 33, 835, 636);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblheading = new JLabel("Change Password");
		lblheading.setBounds(271, 10, 322, 48);
		panel_1.add(lblheading);
		lblheading.setFont(new Font("Verdana", Font.PLAIN, 34));
		
		JSeparator headingline = new JSeparator();
		headingline.setBounds(271, 57, 322, 9);
		panel_1.add(headingline);
		headingline.setBackground(Color.BLACK);
		headingline.setForeground(Color.BLACK);
		setUndecorated(true);
	}
}
