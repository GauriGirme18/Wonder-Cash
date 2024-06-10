package Login;
import Main.Main;
import SplashScreen.Front;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import ForgetPass.forget_pass;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnterUsername;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					frame.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 80, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(2, 0, 2, 2, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 51, 51));
		panel.setBounds(503, 0, 397, 700);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome !");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblNewLabel_1.setBounds(117, 49, 146, 42);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Login To Your Account");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(68, 104, 278, 32);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Username :");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(68, 176, 157, 32);
		panel.add(lblNewLabel_2_1);
		
		txtEnterUsername = new JTextField();
		txtEnterUsername.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
		txtEnterUsername.setForeground(Color.BLACK);
		txtEnterUsername.setBounds(68, 224, 249, 32);
		panel.add(txtEnterUsername);
		txtEnterUsername.setColumns(10);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Password :");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_2_1_1.setBounds(68, 282, 157, 32);
		panel.add(lblNewLabel_2_1_1);
		
		
		JButton btnlogin = new JButton("Login");
		btnlogin.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=txtEnterUsername.getText();
				String password=passwordField.getText();
				
					//if both username and password are blank...
					if(username.equals("")&&password.equals(""))
					{
						JOptionPane.showMessageDialog(null,"Please enter the username and password.","Error",JOptionPane.ERROR_MESSAGE);
					}
					//if username is enter but password is null...
					else if(!(username.equals(""))&& password.equals(""))
					{
						JOptionPane.showMessageDialog(null,"Please enter the password.","Error",JOptionPane.ERROR_MESSAGE);
					}
					//if password is enter but username is null...
					else if(username.equals("")&& !(password.equals("")))
					{
						JOptionPane.showMessageDialog(null,"Please enter the username.","Error",JOptionPane.ERROR_MESSAGE);
					}
					else {
						Connection con=null;
						try
						{
							Class.forName("oracle.jdbc.OracleDriver");
							con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","12345");
							
							PreparedStatement pstate=null;
							pstate=con.prepareStatement("select password from register where userName=?");
							pstate.setString(1,txtEnterUsername.getText());
							ResultSet rs=pstate.executeQuery();
							
							if(rs.next()) {
								if(rs.getString(1).matches(passwordField.getText()))
								{
									JOptionPane.showMessageDialog(null,"Login successful");
									Main m=new Main(txtEnterUsername.getText());
									m.show();
									dispose();
								}
								else
								{
									JOptionPane.showMessageDialog(null,"Wrong username or password.","Error",JOptionPane.ERROR_MESSAGE);
								}
							}
						}catch(Exception e1)
						{
							e1.printStackTrace();
						}
					}
					
				}
		});
		
		btnlogin.setForeground(Color.BLACK);
		btnlogin.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnlogin.setBounds(263, 646, 124, 30);
		panel.add(btnlogin);
		
		String user=txtEnterUsername.getText();
		
		JButton btnNewButton_1 = new JButton("Forget Password?");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtEnterUsername.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null,"Please enter the username.","Error",JOptionPane.ERROR_MESSAGE);
				}
				else if(!(txtEnterUsername.getText().trim().isEmpty())) {
					Connection con=null;
					try
					{
						Class.forName("oracle.jdbc.OracleDriver");
						con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","12345");
						
						Statement st=con.createStatement();
						String sql="Select userName from register";
						ResultSet rs=st.executeQuery(sql);
						if(rs.next())
						{
							if(!(rs.getString(1).matches(txtEnterUsername.getText())))
							{
								JOptionPane.showMessageDialog(null,"Please enter the correct username.","Error",JOptionPane.ERROR_MESSAGE);
							}
							else {
								
								String name=txtEnterUsername.getText();
								forget_pass fp=new forget_pass(name);
								fp.setVisible(true);
								dispose();
							}
						}
					}catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null,"Exception.");
					}
				}
				else {
				forget_pass fp=new forget_pass(user);
				fp.setVisible(true);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnNewButton_1.setBounds(112, 383, 205, 30);
		panel.add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(68, 335, 249, 32);
		panel.add(passwordField);
		
		JButton btnback = new JButton("Back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Front f=new Front();
				f.setVisible(true);
				dispose();
			}
		});
		btnback.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnback.setForeground(Color.BLACK);
		btnback.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnback.setBounds(10, 647, 124, 32);
		panel.add(btnback);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 504, 700);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		ImageIcon icon=new ImageIcon(this.getClass().getResource("/ma.jpg"));
		lblNewLabel_3.setBounds(37, 139, 370, 419);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.setBounds(37, 113, 355, 432);
		panel_1.add(lblNewLabel);
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 23));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setIcon(icon);
		//contentPane.add(panel_1);
	}
	
		
}
