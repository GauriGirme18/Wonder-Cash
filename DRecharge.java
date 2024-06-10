package DthRecharge;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import Main.Main;

public class DRecharge extends JFrame {

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DRecharge frame = new DRecharge();
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
	public DRecharge(String name) {
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
				
			}
		});
		btnexit.setFont(new Font("Verdana", Font.PLAIN, 20));
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(22, 406, 100, 31);
		middlepanel.add(btnexit);
		
		JButton btnRecharge = new JButton("Recharge");
		btnRecharge.setFont(new Font("Verdana", Font.PLAIN, 18));
		btnRecharge.setBackground(Color.WHITE);
		btnRecharge.setBounds(355, 406, 127, 31);
		middlepanel.add(btnRecharge);
		
		JLabel lblprepaid = new JLabel("Prepaid :");
		lblprepaid.setForeground(Color.WHITE);
		lblprepaid.setFont(new Font("Verdana", Font.PLAIN, 28));
		lblprepaid.setBounds(104, 122, 148, 49);
		middlepanel.add(lblprepaid);
		
		JComboBox prepaidbox = new JComboBox();
		prepaidbox.setModel(new DefaultComboBoxModel(new String[] {"Select Prepaid", "Airtel Digital TV", "D2H", "Dish TV", "Sun Direct", "TATA Sky"}));
		prepaidbox.setFont(new Font("Verdana", Font.PLAIN, 18));
		prepaidbox.setBackground(Color.WHITE);
		prepaidbox.setBounds(258, 134, 209, 31);
		middlepanel.add(prepaidbox);
		
		JLabel lblplan = new JLabel("Plans :");
		lblplan.setForeground(Color.WHITE);
		lblplan.setFont(new Font("Verdana", Font.PLAIN, 28));
		lblplan.setBounds(104, 219, 148, 49);
		middlepanel.add(lblplan);
		
		JTextPane txtdesc = new JTextPane();
		txtdesc.setFont(new Font("Verdana", Font.PLAIN, 16));
		txtdesc.setForeground(new Color(255, 255, 255));
		txtdesc.setDisabledTextColor(new Color(255, 255, 255));
		txtdesc.setCaretColor(new Color(255, 255, 255));
		txtdesc.setBackground(new Color(255, 51, 51));
		txtdesc.setBounds(258, 270, 209, 112);
		middlepanel.add(txtdesc);
		
		
		JComboBox planbox = new JComboBox();
		planbox.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent e) {
			}
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
				String rupees=(String)planbox.getSelectedItem();
				if(Integer.parseInt(rupees)==19) {
					txtdesc.setText("Plan : 19 Rs."+"\n"+"Validity : 1 days");
				}
				else if(Integer.parseInt(rupees)==99) {
					txtdesc.setText("Plan : 99 Rs."+"\n"+"Validity : 7 days");
				}
				else if(Integer.parseInt(rupees)==270) {
					txtdesc.setText("Plan : 270 Rs."+"\n"+"Validity : 22 days");
				}
				else if(Integer.parseInt(rupees)==280) {
					txtdesc.setText("Plan : 280 Rs."+"\n"+"Validity : 26 days");
				}
				else if(Integer.parseInt(rupees)==299) {
					txtdesc.setText("Plan : 299 Rs."+"\n"+"Validity : 28 days");
				}
				else if(Integer.parseInt(rupees)==340) {
					txtdesc.setText("Plan : 340 Rs."+"\n"+"Validity : 30 days");
				}
				else if(Integer.parseInt(rupees)==360) {
					txtdesc.setText("Plan : 360 Rs."+"\n"+"(HD Channels)"+"\n"+"Validity : 14 days");
				}
				else if(Integer.parseInt(rupees)==640) {
					txtdesc.setText("Plan : 640 Rs."+"\n"+"(HD Channels)"+"\n"+"Validity : 22 days");
				}
				else if(Integer.parseInt(rupees)==680) {
					txtdesc.setText("Plan : 680 Rs."+"\n"+"(HD Channels)"+"\n"+"Validity : 28 days");
				}
				else if(Integer.parseInt(rupees)==840) {
					txtdesc.setText("Plan : 840 Rs."+"\n"+"(HD Channels)"+"\n"+"Validity : 42 days");
				}
				else if(Integer.parseInt(rupees)==999) {
					txtdesc.setText("Plan : 999 Rs."+"\n"+"(HD Channels)"+"\n"+"Validity : 56 days");
				}
			}
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
			}
		});
		
		
		planbox.setModel(new DefaultComboBoxModel(new String[] {"Select Plan", "19", "99", "270", "280", "299", "340", "360", "640", "680", "840", "999"}));
		planbox.setFont(new Font("Verdana", Font.PLAIN, 18));
		planbox.setBackground(Color.WHITE);
		planbox.setBounds(258, 229, 159, 31);
		middlepanel.add(planbox);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBounds(104, 169, 127, 2);
		middlepanel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBounds(104, 267, 100, 2);
		middlepanel.add(separator_1);
		
		JLabel lblheading = new JLabel("DTH Recharge");
		lblheading.setFont(new Font("Verdana", Font.PLAIN, 34));
		lblheading.setBounds(331, 61, 371, 48);
		contentPane.add(lblheading);
		
		JSeparator headingline = new JSeparator();
		headingline.setForeground(Color.BLACK);
		headingline.setBounds(331, 105, 265, 15);
		contentPane.add(headingline);
		btnRecharge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response=JOptionPane.showConfirmDialog(null,"Do you confirm to rechrage.","Confirm",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(response==JOptionPane.YES_OPTION) {
					int prepaid=prepaidbox.getSelectedIndex();
					int plan=planbox.getSelectedIndex();
					if(prepaid<=0 || plan<=0) {
						JOptionPane.showMessageDialog(null,"Prepaid or plan is not selected.","Error",JOptionPane.ERROR_MESSAGE);
					}
					else {
						Connection dbcon=null;
						PreparedStatement pstate=null;
						int i=0;
						int currBal=0;
						try
						{
							Class.forName("oracle.jdbc.OracleDriver");
							dbcon=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","12345");
							pstate=dbcon.prepareStatement("select accBal from register where userName=?");
							pstate.setString(1,name);
							ResultSet rs=pstate.executeQuery();
							
							while(rs.next()) {
								currBal=Integer.parseInt(rs.getString(1));
								
							}
							String rupees=(String) planbox.getSelectedItem();
							int newBal=0;
							if(currBal<Integer.parseInt(rupees)) {
								JOptionPane.showMessageDialog(null,"You have less balance in your account.","Error",JOptionPane.ERROR_MESSAGE);
							}
							else {
								newBal=currBal-Integer.parseInt(rupees);
								pstate=dbcon.prepareStatement("update register set accBal=? where userName=?");
								pstate.setString(1,Integer.toString(newBal));
								pstate.setString(2,name);
								i=pstate.executeUpdate();
							}
							if(i>0) {
								JOptionPane.showMessageDialog(null,"Recharged Successfully.");
								Main m=new Main(name);
								m.setVisible(true);
								dispose();
							}
							}
						
						catch(Exception e1)
						{
							//JOptionPane.showMessageDialog(null,"Exception in database.","Error",JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						}
					}
				}
			}
		});
	}

}
