

import java.awt.Color;  
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class AdminLogin extends JFrame {
	
	public AdminLogin() {
		setSize(500,400);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
		setLayout(null);
		
		      // header Panel
				JPanel headerPanel = new JPanel();
				headerPanel.setBackground(new Color(54,198,217));
				headerPanel.setBounds(5,5,490,60);
				add(headerPanel);
				
				JLabel headerText = new JLabel("AdminLogin Form !");
				headerText.setFont(new Font("Arial",Font.BOLD,30));
				headerPanel.add(headerText);
				
				//Input Field Panel
				JPanel inputPanel = new JPanel();
				inputPanel.setBackground(new Color(75,196,196));
				inputPanel.setBounds(5,70,490,425);
				inputPanel.setLayout(null);
				add(inputPanel);
				
				JLabel nameLabel = new JLabel("Email : ");
				nameLabel.setBounds(130,5,100,25);
				nameLabel.setFont(new Font("Arial",Font.BOLD,16));
				nameLabel.setForeground(Color.white);
				inputPanel.add(nameLabel);
				JTextField nametext = new JTextField();
				nametext.setBounds(200,5,200,25);
				inputPanel.add(nametext);
				
				JLabel passLabel = new JLabel("Password : ");
				passLabel.setBounds(95,50,100,25);
				passLabel.setFont(new Font("Arial",Font.BOLD,16));
				passLabel.setForeground(Color.white);
				inputPanel.add(passLabel);
				JTextField passtext = new JTextField();
				passtext.setBounds(200,50,200,25);
				inputPanel.add(passtext);
				
				//button field
				
//				JButton admin = new JButton("Admin");
//				admin.setBounds(90,100,100,30);
//				admin.setBackground(new Color(191,42,117));
//				admin.setFont(new Font("Arial",Font.BOLD,16));
//				admin.setBorder(new LineBorder(Color.gray));
//				admin.setForeground(Color.WHITE);
//				inputPanel.add(admin);
//				
//				JButton register = new JButton("Register");
//				register.setBounds(300,100,100,30);
//				register.setBackground(new Color(191,42,117));
//				register.setFont(new Font("Arial",Font.BOLD,16));
//				register.setBorder(new LineBorder(Color.gray));
//				register.setForeground(Color.WHITE);
//				inputPanel.add(register);
				
				JButton AdminLoginBtn = new JButton("AdminLogin");
				AdminLoginBtn.setBounds(195,100,100,30);
				AdminLoginBtn.setBackground(new Color(191,42,117));
				AdminLoginBtn.setFont(new Font("Arial",Font.BOLD,16));
				AdminLoginBtn.setBorder(new LineBorder(Color.gray));
				AdminLoginBtn.setForeground(Color.WHITE);
				inputPanel.add(AdminLoginBtn);
				
				setVisible(true);
				
//				register.addActionListener(new ActionListener(){
//					
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						dispose();
//						new Register();
//					}
//					
//				});
				AdminLoginBtn.addActionListener(new ActionListener(){
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String logUserName = nametext.getText();
						String logPass = passtext.getText();
						String logQuery = "SELECT * FROM `admin`";
						
						DatabaseConnect db = new DatabaseConnect();
						db.AdminLoginMethod(logQuery,logUserName,logPass);
					}
					
				});
		
		
	}

}