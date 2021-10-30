
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.util.regex.*;

public class Register extends JFrame implements  ActionListener {
	
	private Container cont;
	
	public Register() throws IOException {
		setSize(1000,700);
//		setVisible(true);
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
		headerPanel.setBounds(100,5,800,60);
		cont.add(headerPanel);
		
		JLabel headerText = new JLabel("Welcome To Dental Square And Create Your Account");
		headerText.setForeground(new Color(191,42,117));
		headerText.setFont(new Font("Arial",Font.BOLD,30));
		headerPanel.add(headerText);
		
		//Input Field Panel
		JPanel inputPanel = new JPanel();
		inputPanel.setBackground(new Color(29,8,74));
		inputPanel.setBounds(5,70,490,600);
		inputPanel.setLayout(null);
		cont.add(inputPanel);
		
		JLabel nameLabel = new JLabel("Name : ");
		nameLabel.setBounds(130,25,100,35);
		nameLabel.setFont(new Font("Arial",Font.BOLD,19));
		nameLabel.setForeground(Color.white);
		inputPanel.add(nameLabel);
		JTextField nametext = new JTextField();
		nametext.setBounds(200,25,250,35);
		inputPanel.add(nametext);
		
		JLabel emailLabel = new JLabel("Email : ");
		emailLabel.setBounds(130,90,100,35);
		emailLabel.setFont(new Font("Arial",Font.BOLD,19));
		emailLabel.setForeground(Color.white);
		inputPanel.add(emailLabel);
		JTextField emailtext = new JTextField();
		emailtext.setBounds(200,90,250,35);
		inputPanel.add(emailtext);
		
		JLabel passLabel = new JLabel("Password : ");
		passLabel.setBounds(102,150,100,35);
		passLabel.setFont(new Font("Arial",Font.BOLD,17));
		passLabel.setForeground(Color.white);
		inputPanel.add(passLabel);
		JTextField passtext = new JTextField();
		passtext.setBounds(200,150,250,35);
		inputPanel.add(passtext);
		
		JLabel conPassLabel = new JLabel("Confirm Password : ");
		conPassLabel.setBounds(38,210,170,35);
		conPassLabel.setFont(new Font("Arial",Font.BOLD,16));
		conPassLabel.setForeground(Color.white);
		inputPanel.add(conPassLabel);
		JTextField conPasstext = new JTextField();
		conPasstext.setBounds(200,210,250,35);
		inputPanel.add(conPasstext);
		
		JLabel mobileLabel = new JLabel("Mobile : ");
		mobileLabel.setBounds(115,270,100,35);
		mobileLabel.setFont(new Font("Arial",Font.BOLD,19));
		mobileLabel.setForeground(Color.white);
		inputPanel.add(mobileLabel);
		JTextField mobiletext = new JTextField();
		mobiletext.setBounds(200,270,250,35);
		inputPanel.add(mobiletext);
		
		JLabel addressLabel = new JLabel("Address : ");
		addressLabel.setBounds(105,320,100,55);
		addressLabel.setFont(new Font("Arial",Font.BOLD,19));
		addressLabel.setForeground(Color.white);
		inputPanel.add(addressLabel);
		JTextField addresstext = new JTextField();
		addresstext.setBounds(200,330,250,35);
		inputPanel.add(addresstext);
		
		//button field
		JButton register = new JButton("Register");
		register.setBounds(330,400,130,40);
		register.setBackground(new Color(191,42,117));
		register.setFont(new Font("Arial",Font.BOLD,16));
		register.setBorder(new LineBorder(Color.gray));
		register.setForeground(Color.WHITE);
		inputPanel.add(register);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.setBounds(195,400,130,40);
		loginBtn.setBackground(new Color(191,42,117));
		loginBtn.setFont(new Font("Arial",Font.BOLD,16));
		loginBtn.setBorder(new LineBorder(Color.gray));
		loginBtn.setForeground(Color.WHITE);
		inputPanel.add(loginBtn);
		
		
		
		
		// Register Image Area
		
		JPanel imgPanel = new JPanel();
//		imgPanel.setBackground(new Color(75,196,196));
		imgPanel.setBounds(500,71,500,900);
		imgPanel.setBackground(new Color(29,8,74));
		
		String path = "https://i.ibb.co/4Nd2Jgb/Register-Img.jpg";
        System.out.println("Get Image from " + path);
        URL url = new URL(path);
        BufferedImage image = ImageIO.read(url);
//        System.out.println("Load image into frame...");
        
        Image newImage = image.getScaledInstance(640, 450, Image.SCALE_DEFAULT);
          
        JLabel imgLabel = new JLabel(new ImageIcon(newImage));
        imgLabel.setBounds(410,70,640,450);
        imgPanel.add(imgLabel);
        cont.add(imgPanel);
		
		
		
		
		setVisible(true);
		
		register.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//get input text
				String name = nametext.getText();
				String email = emailtext.getText();
				String pass = passtext.getText();
				String conPass = conPasstext.getText();
				String mobile = mobiletext.getText();
				String address = addresstext.getText();
				
				//validation
				String mobileRex = "(\\+88)?01[3-9]\\d{8}";
				String nameRex = "^[a-zA-Z. ]+$";
				String emailRex = "^[a-zA-Z0-9.]+@[a-z]+.[a-z]+$";
				String passRex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
				
				//conditions
				if(!Pattern.matches(nameRex, name)) {
					JOptionPane.showMessageDialog(null,"In-Valid UserName");
				}
				else if(!Pattern.matches(emailRex, email)) {
					JOptionPane.showMessageDialog(null,"In-Valid Email");
				}
				else if(!pass.equals(conPass)) {
					JOptionPane.showMessageDialog(null,"PassWord and Confirm-password are not matched.");
				}
				
				else if(!Pattern.matches(passRex, pass)) {
					JOptionPane.showMessageDialog(null,"Please, Give a Strong Password & Following :\r\n"
							+ "1. A digit must occur at least once \r\n"
							+ "2. A lower case letter must occur at least once \r\n"
							+ "3. An upper case letter must occur at least once \r\n"
							+ "4. A special character must occur at least once \r\n"
							+ "5. no whitespace allowed in the entire string \r\n"
							+ "6. Ensure string is of length 8.\r\n");
				}
				
				else if(!Pattern.matches(mobileRex, mobile)) {
					JOptionPane.showMessageDialog(null,"In-Valid Mobile number");
				}
				else {
					try {
						
						DatabaseConnect db = new DatabaseConnect();
                 		String queryInsert = "INSERT INTO `users`(`name`, `email`, `pass`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+pass+"','"+mobile+"','"+address+"')";
						
						db.RegisterInsert(queryInsert);
						dispose();
						
						
					} catch(Exception e2) {
						System.err.println(e2);
					}
					
				}
				
				
				
				
			}
			
		});
		loginBtn.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					new Login();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
				
		
		
				
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

	

}