package CheckBalance;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import Main.Main;

import javax.swing.JTextField;
import java.awt.Component;

public class CheckBal extends JFrame {

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckBal frame = new CheckBal();
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
	private JTextField txtacbal;
	private JTextField txtacno;
	private JTextField txtuname;
	private JTextField txtname;
	
	public CheckBal(String name) {
		
		String fname=null,lname=null,uname=null;
		String uaccno=null,uaccbal=null;
		try {
			Connection con=null;
			
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","12345");
			PreparedStatement pstate=null;
			pstate=con.prepareStatement("select firstName,lastName,userName,accNo,accbal from register where userName=?");
			pstate.setString(1,name);
			ResultSet rs=pstate.executeQuery();
			
			while(rs.next()) {
				fname=rs.getString(1);
				lname=rs.getString(2);
				uname=rs.getString(3);
				uaccno=rs.getString(4);
				uaccbal=rs.getString(5);
				
			}
			}
		catch(Exception e) {
			
		}
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350,80,900,700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel toppanel = new JPanel();
		toppanel.setBorder(new MatteBorder(2, 2, 0, 2, (Color) new Color(0, 0, 0)));
		toppanel.setBackground(new Color(255, 51, 51));
		toppanel.setBounds(0, 0, 900, 39);
		contentPane.add(toppanel);
		
		JPanel leftpanel = new JPanel();
		leftpanel.setBorder(new MatteBorder(0, 2, 2, 0, (Color) new Color(0, 0, 0)));
		leftpanel.setBackground(new Color(255, 51, 51));
		leftpanel.setBounds(0, 33, 45, 667);
		contentPane.add(leftpanel);
		
		JPanel bottompanel = new JPanel();
		bottompanel.setBorder(new MatteBorder(0, 0, 2, 2, (Color) new Color(0, 0, 0)));
		bottompanel.setBackground(new Color(255, 51, 51));
		bottompanel.setBounds(44, 658, 856, 42);
		contentPane.add(bottompanel);
		
		JPanel rightpanel = new JPanel();
		rightpanel.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 0, 0)));
		rightpanel.setBackground(new Color(255, 51, 51));
		rightpanel.setBounds(854, 33, 46, 630);
		contentPane.add(rightpanel);
		
		JPanel middlepanel = new JPanel();
		middlepanel.setBackground(new Color(255, 51, 51));
		middlepanel.setBounds(206, 124, 511, 458);
		contentPane.add(middlepanel);
		middlepanel.setLayout(null);
		
		JButton btnexit = new JButton("Exit");
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main m=new Main(name);
				m.setVisible(true);
				dispose();
			}
		});
		btnexit.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(22, 406, 100, 31);
		middlepanel.add(btnexit);
		
		JLabel lblname = new JLabel("Name :");
		lblname.setForeground(Color.WHITE);
		lblname.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblname.setBounds(22, 63, 92, 31);
		middlepanel.add(lblname);
		
		JLabel lbluname = new JLabel("Username :");
		lbluname.setFont(new Font("Verdana", Font.PLAIN, 20));
		lbluname.setForeground(Color.WHITE);
		lbluname.setBounds(22, 115, 136, 38);
		middlepanel.add(lbluname);
		
		JLabel lblacbal = new JLabel("Account Balance is  : ");
		lblacbal.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblacbal.setForeground(Color.WHITE);
		lblacbal.setBounds(144, 258, 233, 31);
		middlepanel.add(lblacbal);
		
		txtacbal = new JTextField();
		txtacbal.setAlignmentX(Component.RIGHT_ALIGNMENT);
		txtacbal.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtacbal.setBackground(new Color(255, 51, 51));
		txtacbal.setForeground(Color.WHITE);
		txtacbal.setFont(new Font("Verdana", Font.PLAIN, 30));
		txtacbal.setBounds(144, 284, 220, 58);
		middlepanel.add(txtacbal);
		txtacbal.setColumns(10);
		txtacbal.setText(uaccbal);
		
		JLabel lblacno = new JLabel("Account Number : ");
		lblacno.setForeground(Color.WHITE);
		lblacno.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblacno.setBounds(22, 176, 191, 38);
		middlepanel.add(lblacno);
		
		txtacno = new JTextField();
		txtacno.setForeground(new Color(255, 255, 255));
		txtacno.setBackground(new Color(255, 51, 51));
		txtacno.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtacno.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtacno.setColumns(10);
		txtacno.setBounds(213, 175, 298, 44);
		middlepanel.add(txtacno);
		txtacno.setText(uaccno);
		
		txtuname = new JTextField();
		txtuname.setForeground(Color.WHITE);
		txtuname.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtuname.setColumns(10);
		txtuname.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtuname.setBackground(new Color(255, 51, 51));
		txtuname.setBounds(185, 114, 292, 44);
		middlepanel.add(txtuname);
		txtuname.setText(uname);
		
		txtname = new JTextField();
		txtname.setForeground(Color.WHITE);
		txtname.setFont(new Font("Verdana", Font.PLAIN, 18));
		txtname.setColumns(10);
		txtname.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtname.setBackground(new Color(255, 51, 51));
		txtname.setBounds(124, 61, 298, 38);
		middlepanel.add(txtname);
		String fullName=fname+" "+lname;
		txtname.setText(fullName);
		
		JLabel lblheading = new JLabel("Account Balance");
		lblheading.setFont(new Font("Verdana", Font.PLAIN, 34));
		lblheading.setBounds(331, 61, 371, 48);
		contentPane.add(lblheading);
		
		JSeparator headingline = new JSeparator();
		headingline.setForeground(Color.BLACK);
		headingline.setBounds(331, 105, 265, 15);
		contentPane.add(headingline);
	}
}
