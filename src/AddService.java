
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.util.regex.*;

public class AddService extends JFrame implements  ActionListener {
	
	private Container cont;
	
	public AddService() throws IOException {
		setSize(1000,570);
		//setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
		setLayout(null);
		
		/* -------------------------------------------
			 Container setup
		---------------------------------------------- */
		cont = this.getContentPane();
		cont.setLayout(null);
		cont.setBackground(new Color(131,166,160,255));
		
		// header Panel
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(new Color(131,166,160,255));
		headerPanel.setBounds(5,5,490,60);
		add(headerPanel);
		
		JLabel adminHomeText = new JLabel("Admin Home");
		adminHomeText.setBounds(500,40,490,30);
		adminHomeText.setForeground(new Color(191,42,117));
		adminHomeText.setFont(new Font("Arial",Font.BOLD,20));
		headerPanel.add(adminHomeText);
		
		JLabel headerText = new JLabel("Add Service");
		headerText.setBounds(5,40,490,30);
		headerText.setForeground(new Color(191,42,117));
		headerText.setFont(new Font("Arial",Font.BOLD,20));
		headerPanel.add(headerText);
		
		//Input Field Panel
		JPanel inputPanel = new JPanel();
		inputPanel.setBackground(new Color(131,166,160,255));
		inputPanel.setBounds(5,70,490,500);
		inputPanel.setLayout(null);
		add(inputPanel);
		
		JLabel titleLabel = new JLabel("Service Title: ");
		titleLabel.setBounds(70,60,150,35);
		titleLabel.setFont(new Font("Arial",Font.BOLD,19));
		titleLabel.setForeground(Color.white);
		inputPanel.add(titleLabel);
		JTextField titletext = new JTextField();
		titletext.setBounds(200,60,300,35);
		inputPanel.add(titletext);
		
		JLabel priceLabel = new JLabel("Price : ");
		priceLabel.setBounds(130,120,150,35);
		priceLabel.setFont(new Font("Arial",Font.BOLD,19));
		priceLabel.setForeground(Color.white);
		inputPanel.add(priceLabel);
		JTextField pricetext = new JTextField();
		pricetext.setBounds(200,120,300,35);
		inputPanel.add(pricetext);
		
		JLabel imgLabel = new JLabel("Image URL : ");
		imgLabel.setBounds(77,180,150,35);
		imgLabel.setFont(new Font("Arial",Font.BOLD,19));
		imgLabel.setForeground(Color.white);
		inputPanel.add(imgLabel);
		JTextField imgtext = new JTextField();
		imgtext.setBounds(200,180,300,35);
		inputPanel.add(imgtext);
				
		//button field
		JButton AddService = new JButton("AddService");
		AddService.setBounds(320,250,140,40);
		AddService.setBackground(new Color(191,42,117));
		AddService.setFont(new Font("Arial",Font.BOLD,16));
		AddService.setBorder(new LineBorder(Color.gray));
		AddService.setForeground(Color.WHITE);
		inputPanel.add(AddService);
		
//		JButton Services = new JButton("Services");
//		Services.setBounds(160,250,140,40);
//		Services.setBackground(new Color(191,42,117));
//		Services.setFont(new Font("Arial",Font.BOLD,16));
//		Services.setBorder(new LineBorder(Color.gray));
//		Services.setForeground(Color.WHITE);
//		inputPanel.add(Services);
		
		JButton AppointBtn = new JButton("Appointments");
		AppointBtn.setBounds(100,300,140,40);
		AppointBtn.setBackground(new Color(191,42,117));
		AppointBtn.setFont(new Font("Arial",Font.BOLD,16));
		AppointBtn.setBorder(new LineBorder(Color.gray));
		AppointBtn.setForeground(Color.WHITE);
		inputPanel.add(AppointBtn);
		
		JButton prescriptionBtn = new JButton("Write Prescription");
		prescriptionBtn.setBounds(260,300,200,40);
		prescriptionBtn.setBackground(new Color(191,42,117));
		prescriptionBtn.setFont(new Font("Arial",Font.BOLD,16));
		prescriptionBtn.setBorder(new LineBorder(Color.gray));
		prescriptionBtn.setForeground(Color.WHITE);
		inputPanel.add(prescriptionBtn);
		
		JButton logout = new JButton("Log Out");
		logout.setBounds(500, 10,140,40);
		logout.setBackground(new Color(191,42,117));
		logout.setFont(new Font("Arial",Font.BOLD,16));
		logout.setBorder(new LineBorder(Color.gray));
		logout.setForeground(Color.WHITE);
		headerPanel.add(logout);
		
//		JButton loginBtn = new JButton("Login");
//		loginBtn.setBounds(195,300,100,30);
//		loginBtn.setBackground(new Color(191,42,117));
//		loginBtn.setFont(new Font("Arial",Font.BOLD,16));
//		loginBtn.setBorder(new LineBorder(Color.gray));
//		loginBtn.setForeground(Color.WHITE);
//		inputPanel.add(loginBtn);
		
		
		
		       // Image Area
		
				JPanel imgPanel = new JPanel();
//				imgPanel.setBackground(new Color(75,196,196));
				imgPanel.setBounds(500,40,500,550);
				imgPanel.setBackground(new Color(131,166,160,255));
				
				String path = "https://i.ibb.co/jZgG2Gy/Services-Banner.png";
		        System.out.println("Get Image from " + path);
		        URL url = new URL(path);
		        BufferedImage image = ImageIO.read(url);
//		        System.out.println("Load image into frame...");
		        
		        Image newImage = image.getScaledInstance(500, 450, Image.SCALE_DEFAULT);
		          
		        JLabel imageLabel = new JLabel(new ImageIcon(newImage));
		        imageLabel.setBounds(410,70,500,500);
		        imgPanel.add(imageLabel);
		        cont.add(imgPanel);
		
		setVisible(true);
		
		AddService.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//get input text
				String title = titletext.getText();
				String price = pricetext.getText();
				String img = imgtext.getText();
//				String conPass = conimgtext.getText();
//				String mobile = mobiletext.getText();
//				String address = addresstext.getText();
				
				//validation
//				String mobileRex = "(\\+88)?01[3-9]\\d{8}";
				
				
				String titleRex = "^[a-zA-Z. ]+$";
				String priceRex = "^[1-9]\\d*$";
				String imgUrlRex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
				
//				String emailRex = "^[a-zA-Z0-9.]+@[a-z]+.[a-z]+$";
//				String passRex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
				
				//conditions
				if(!Pattern.matches(titleRex, title)) {
					JOptionPane.showMessageDialog(null,"In-Valid Title");
				}
				else if(!Pattern.matches(priceRex, price)) {
					JOptionPane.showMessageDialog(null,"In-Valid Price");
				}
				
				else if(!Pattern.matches(imgUrlRex, img)) {
					JOptionPane.showMessageDialog(null,"In-Valid URL");
				}
				else {
					try {
						
						DatabaseConnect db = new DatabaseConnect();
                 		String queryInsert = "INSERT INTO `services`(`title`, `price`, `img`) VALUES ('"+title+"','"+price+"','"+img+"')";
						
						db.AddServiceInsert(queryInsert);
						
						
					} catch(Exception e2) {
						System.err.println(e2);
					}
					
				}
				
				
				
				
			}
			
		});
		
		
//		Services.addActionListener(new ActionListener(){
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				dispose();
//				new ServiceWindow();
//			}
//			
//		});
		AppointBtn.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Bookings();
			}
			
		});
	    prescriptionBtn.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Prescription();
			}
			
		});
	    logout.addActionListener(new ActionListener(){
			
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