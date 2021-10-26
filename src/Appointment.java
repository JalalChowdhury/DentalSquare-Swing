import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.swing.border.LineBorder;
import java.util.regex.*;

public class Appointment extends JFrame{
	
	private Container cont;
	
	public Appointment() throws IOException{
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
		
		JLabel headerText = new JLabel("Request AppointMent");
		headerText.setForeground(new Color(191,42,117));
		headerText.setFont(new Font("Arial",Font.BOLD,30));
		headerPanel.add(headerText);
		
		//Input Field Panel
		JPanel inputPanel = new JPanel();
		inputPanel.setBackground(new Color(29,8,74));
		inputPanel.setBounds(5,70,490,600);
		inputPanel.setLayout(null);
		cont.add(inputPanel);
		
		JLabel nameLabel = new JLabel("Patient Name : ");
		nameLabel.setBounds(130,25,100,35);
		nameLabel.setFont(new Font("Arial",Font.BOLD,19));
		nameLabel.setForeground(Color.white);
		inputPanel.add(nameLabel);
		JTextField nametext = new JTextField();
		nametext.setBounds(200,25,250,35);
		inputPanel.add(nametext);
		
		JLabel mobileLabel = new JLabel("Mobile No : ");
		mobileLabel.setBounds(130,90,100,35);
		mobileLabel.setFont(new Font("Arial",Font.BOLD,19));
		mobileLabel.setForeground(Color.white);
		inputPanel.add(mobileLabel);
		JTextField mobiletext = new JTextField();
		mobiletext.setBounds(200,90,250,35);
		inputPanel.add(mobiletext);
		
		JLabel addressLabel = new JLabel("Address : ");
		addressLabel.setBounds(102,150,100,35);
		addressLabel.setFont(new Font("Arial",Font.BOLD,17));
		addressLabel.setForeground(Color.white);
		inputPanel.add(addressLabel);
		JTextField addresstext = new JTextField();
		addresstext.setBounds(200,150,250,35);
		inputPanel.add(addresstext);
		
		JLabel dateLabel = new JLabel("Date : ");
		dateLabel.setBounds(38,210,170,35);
		dateLabel.setFont(new Font("Arial",Font.BOLD,16));
		dateLabel.setForeground(Color.white);
		inputPanel.add(dateLabel);
		JTextField datetext = new JTextField();
		datetext.setBounds(200,210,250,35);
		inputPanel.add(datetext);
		
		JLabel timeLabel = new JLabel("Time : ");
		timeLabel.setBounds(115,270,100,35);
		timeLabel.setFont(new Font("Arial",Font.BOLD,19));
		timeLabel.setForeground(Color.white);
		inputPanel.add(timeLabel);
		JTextField timetext = new JTextField();
		timetext.setBounds(200,270,250,35);
		inputPanel.add(timetext);
		
		JLabel commentLabel = new JLabel("Comment/Query : ");
		commentLabel.setBounds(105,320,100,55);
		commentLabel.setFont(new Font("Arial",Font.BOLD,19));
		commentLabel.setForeground(Color.white);
		inputPanel.add(commentLabel);
		JTextField commenttext = new JTextField();
		commenttext.setBounds(200,330,250,35);
		inputPanel.add(commenttext);
		
		//button field
		JButton register = new JButton("Register");
		register.setBounds(330,400,130,40);
		register.setBackground(new Color(191,42,117));
		register.setFont(new Font("Arial",Font.BOLD,16));
		register.setBorder(new LineBorder(Color.gray));
		register.setForeground(Color.WHITE);
		inputPanel.add(register);
		
	
		
		
		
		
		// Register Image Area
		
		JPanel imgPanel = new JPanel();
//		imgPanel.setBackground(new Color(75,196,196));
		imgPanel.setBounds(500,71,500,900);
		imgPanel.setBackground(new Color(29,8,74));
		
		String path = "https://i.ibb.co/hDFMcWY/appointment.png";
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
				String time = timetext.getText();
				String address = addresstext.getText();
				String date = datetext.getText();
				String mobile = mobiletext.getText();
				String comment = commenttext.getText();
				
				//validation
				String mobileRex = "(\\+88)?01[3-9]\\d{8}";
				String nameRex = "^[a-zA-Z. ]+$";
				
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
}