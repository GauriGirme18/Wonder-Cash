package SplashScreen;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class Splash extends JFrame {

	private JPanel contentPane;
	private static JProgressBar progressBar;
	private static JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
				int x;
					Splash frame = new Splash();
					frame.setVisible(true);
				
					try {
						for(x=0;x<=100;x++) {
						Splash.progressBar.setValue(x);
						Thread.sleep(250);
						Splash.lblNewLabel_1.setText(Integer.toString(x)+"%");
						if(x==100) {
							frame.dispose();
							Front f=new Front();
							f.show();
						}
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
	}

	/**
	 * Create the frame.
	 */
	public Splash() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350,80,900,700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setBorder(new LineBorder(new Color(0, 0, 0)));
		progressBar.setBackground(Color.WHITE);
		progressBar.setForeground(new Color(255, 51, 51));
		progressBar.setBounds(26, 651, 848, 25);
		contentPane.add(progressBar);
		
		JLabel lblNewLabel = new JLabel(" ");
		ImageIcon icon=new ImageIcon(this.getClass().getResource("/loading.gif"));
		lblNewLabel.setIcon(icon);
		lblNewLabel.setBounds(291, 60, 407, 341);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(427, 607, 108, 34);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Loading....");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_2.setForeground(new Color(255, 51, 51));
		lblNewLabel_2.setBounds(389, 411, 172, 34);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Please Wait...");
		lblNewLabel_3.setForeground(new Color(255, 51, 51));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_3.setBounds(373, 455, 172, 34);
		contentPane.add(lblNewLabel_3);
	}
}
