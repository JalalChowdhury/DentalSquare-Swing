

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Login extends JFrame {
	private Container cont;
	
	
	public Login() throws IOException {
		setSize(1000,400);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
		setLayout(null);
		
		
		/* -------------------------------------------
			Container setup
		---------------------------------------------- */
		cont = this.getContentPane();
		cont.setLayout(null);
		cont.setBackground(new Color(29,8,74));
		
		        // header Panel
				JPanel headerPanel = new JPanel();
				headerPanel.setBackground(new Color(29,8,74));
				headerPanel.setBounds(100,5,350,60);
				add(headerPanel);
				
				JLabel headerText = new JLabel("User Login ");
				headerText.setForeground(new Color(191,42,117));
				headerText.setFont(new Font("Arial",Font.BOLD,30));
				headerPanel.add(headerText);
				
				//Input Field Panel
				JPanel inputPanel = new JPanel();
				inputPanel.setBackground(new Color(29,8,74));
				inputPanel.setBounds(5,70,490,425);
				inputPanel.setLayout(null);
				add(inputPanel);
				
				JLabel emailLabel = new JLabel("Email : ");
				emailLabel.setBounds(130,60,100,35);
				emailLabel.setFont(new Font("Arial",Font.BOLD,20));
				emailLabel.setForeground(Color.white);
				inputPanel.add(emailLabel);
				JTextField emailtext = new JTextField();
				emailtext.setBounds(200,60,250,35);
				inputPanel.add(emailtext);
				
				JLabel passLabel = new JLabel("Password : ");
				passLabel.setBounds(105,140,100,35);
				passLabel.setFont(new Font("Arial",Font.BOLD,16));
				passLabel.setForeground(Color.white);
				inputPanel.add(passLabel);
				JTextField passtext = new JTextField();
				passtext.setBounds(200,140,250,35);
				inputPanel.add(passtext);
				
				//button field
				
				JButton admin = new JButton("Admin");
				admin.setBounds(120,200,100,40);
				admin.setBackground(new Color(191,42,117));
				admin.setFont(new Font("Arial",Font.BOLD,16));
				admin.setBorder(new LineBorder(Color.gray));
				admin.setForeground(Color.WHITE);
				inputPanel.add(admin);
				
				JButton register = new JButton("Register");
				register.setBounds(350,200,100,40);
				register.setBackground(new Color(191,42,117));
				register.setFont(new Font("Arial",Font.BOLD,16));
				register.setBorder(new LineBorder(Color.gray));
				register.setForeground(Color.WHITE);
				inputPanel.add(register);
				
				JButton loginBtn = new JButton("Login");
				loginBtn.setBounds(235,200,100,40);
				loginBtn.setBackground(new Color(191,42,117));
				loginBtn.setFont(new Font("Arial",Font.BOLD,16));
				loginBtn.setBorder(new LineBorder(Color.gray));
				loginBtn.setForeground(Color.WHITE);
				inputPanel.add(loginBtn);
				
				
				
				
				
				// Register Image Area
				
				JPanel imgPanel = new JPanel();
//				imgPanel.setBackground(new Color(75,196,196));
				imgPanel.setBounds(500,71,500,500);
				imgPanel.setBackground(new Color(29,8,74));
				
				String path = "https://i.ibb.co/4Nd2Jgb/Register-Img.jpg";
		        System.out.println("Get Image from " + path);
		        URL url = new URL(path);
		        BufferedImage image = ImageIO.read(url);
//		        System.out.println("Load image into frame...");
		        
		        Image newImage = image.getScaledInstance(640, 250, Image.SCALE_DEFAULT);
		          
		        JLabel imgLabel = new JLabel(new ImageIcon(newImage));
		        imgLabel.setBounds(410,70,640,250);
		        imgPanel.add(imgLabel);
		        cont.add(imgPanel);
				
				setVisible(true);
				
				register.addActionListener(new ActionListener(){
					
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
						try {
							new Register();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
				});
				admin.addActionListener(new ActionListener(){
					
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
						try {
							new AdminLogin();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
				});
				loginBtn.addActionListener(new ActionListener(){
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String logEmail = emailtext.getText();
						String logPass = passtext.getText();
						String logQuery = "SELECT * FROM `users`";
						
						DatabaseConnect db = new DatabaseConnect();
						db.LoginMethod(logQuery,logEmail,logPass);
						dispose();
					}
					
				});
		
		
	}

}