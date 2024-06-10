package Recharge;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

import DthRecharge.DRecharge;
import MobileRecharge.MRecharge;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class REchargeServices extends JFrame {

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					REchargeServices frame = new REchargeServices();
					frame.setVisible(true);
				
	}

	/**
	 * Create the frame.
	 */
	private JPanel contentPane;
	public REchargeServices(String UName) {
		String userName=UName;
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350,80,900,700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblheading = new JLabel("Recharge Services");
		lblheading.setAlignmentY(0.5f);
		lblheading.setAlignmentX(0.5f);
		lblheading.setBackground(new Color(255, 255, 255));
		lblheading.setForeground(new Color(255, 51, 51));
		lblheading.setFont(new Font("Times New Roman", Font.BOLD, 38));
		lblheading.setBounds(328, 30, 427, 95);
		contentPane.add(lblheading);
		
		JSeparator headingline = new JSeparator();
		headingline.setForeground(new Color(255, 51, 51));
		headingline.setBounds(310, 98, 334, 12);
		contentPane.add(headingline);
		
		JLabel lblmobile = new JLabel();
		ImageIcon icon=new ImageIcon(this.getClass().getResource("/mobile_recharge.png"));
		lblmobile.setIcon(icon);
		lblmobile.setBounds(86, 214, 356, 334);
		contentPane.add(lblmobile);
		
		JLabel lbldth = new JLabel();
		ImageIcon icon2=new ImageIcon(this.getClass().getResource("/dth_recharge.png"));
		lbldth.setIcon(icon2);
		lbldth.setBounds(488, 214, 356, 334);
		contentPane.add(lbldth);
		
		JButton btnmobile = new JButton("Mobile Recharge");
		btnmobile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MRecharge mr=new MRecharge(userName);
				mr.setVisible(true);
				dispose();
			}
		});
		btnmobile.setBorder(new LineBorder(new Color(255, 51, 51), 2));
		btnmobile.setBackground(Color.WHITE);
		btnmobile.setForeground(Color.BLACK);
		btnmobile.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnmobile.setBounds(112,540, 272, 57);
		contentPane.add(btnmobile);
		
		JButton btndth = new JButton("D2H Recharge");
		btndth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DRecharge dr=new DRecharge(userName);
				dr.setVisible(true);
				dispose();
			}
		});
		btndth.setBorder(new LineBorder(new Color(255, 51, 51), 2));
		btndth.setBackground(Color.WHITE);
		btndth.setForeground(Color.BLACK);
		btndth.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btndth.setBounds(538,540, 272, 57);
		contentPane.add(btndth);
	}
}
