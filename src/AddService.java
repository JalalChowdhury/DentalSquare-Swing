
import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.util.regex.*;

public class AddService extends JFrame implements  ActionListener {
	
	
	public AddService() {
		setSize(500,460);
//		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
		setLayout(null);
		
		// header Panel
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(new Color(54,198,217));
		headerPanel.setBounds(5,5,490,60);
		add(headerPanel);
		
		JLabel headerText = new JLabel("AddService Form !");
		headerText.setFont(new Font("Arial",Font.BOLD,30));
		headerPanel.add(headerText);
		
		//Input Field Panel
		JPanel inputPanel = new JPanel();
		inputPanel.setBackground(new Color(75,196,196));
		inputPanel.setBounds(5,70,490,425);
		inputPanel.setLayout(null);
		add(inputPanel);
		
		JLabel titleLabel = new JLabel("Service Title: ");
		titleLabel.setBounds(130,5,100,25);
		titleLabel.setFont(new Font("Arial",Font.BOLD,16));
		titleLabel.setForeground(Color.white);
		inputPanel.add(titleLabel);
		JTextField titletext = new JTextField();
		titletext.setBounds(200,5,200,25);
		inputPanel.add(titletext);
		
		JLabel priceLabel = new JLabel("Price : ");
		priceLabel.setBounds(130,50,100,25);
		priceLabel.setFont(new Font("Arial",Font.BOLD,16));
		priceLabel.setForeground(Color.white);
		inputPanel.add(priceLabel);
		JTextField pricetext = new JTextField();
		pricetext.setBounds(200,50,200,25);
		inputPanel.add(pricetext);
		
		JLabel imgLabel = new JLabel("Image URL : ");
		imgLabel.setBounds(95,100,100,25);
		imgLabel.setFont(new Font("Arial",Font.BOLD,16));
		imgLabel.setForeground(Color.white);
		inputPanel.add(imgLabel);
		JTextField imgtext = new JTextField();
		imgtext.setBounds(200,100,200,25);
		inputPanel.add(imgtext);
		
//		JLabel conimgLabel = new JLabel("Confirm Password : ");
//		conimgLabel.setBounds(30,150,170,25);
//		conimgLabel.setFont(new Font("Arial",Font.BOLD,16));
//		conimgLabel.setForeground(Color.white);
//		inputPanel.add(conimgLabel);
//		JTextField conimgtext = new JTextField();
//		conimgtext.setBounds(200,150,200,25);
//		inputPanel.add(conimgtext);
//		
//		JLabel mobileLabel = new JLabel("Mobile : ");
//		mobileLabel.setBounds(120,200,100,25);
//		mobileLabel.setFont(new Font("Arial",Font.BOLD,16));
//		mobileLabel.setForeground(Color.white);
//		inputPanel.add(mobileLabel);
//		JTextField mobiletext = new JTextField();
//		mobiletext.setBounds(200,200,200,25);
//		inputPanel.add(mobiletext);
//		
//		JLabel addressLabel = new JLabel("Address : ");
//		addressLabel.setBounds(105,250,100,25);
//		addressLabel.setFont(new Font("Arial",Font.BOLD,16));
//		addressLabel.setForeground(Color.white);
//		inputPanel.add(addressLabel);
//		JTextField addresstext = new JTextField();
//		addresstext.setBounds(200,250,200,25);
//		inputPanel.add(addresstext);
//		
		//button field
		JButton AddService = new JButton("AddService");
		AddService.setBounds(300,300,100,30);
		AddService.setBackground(new Color(191,42,117));
		AddService.setFont(new Font("Arial",Font.BOLD,16));
		AddService.setBorder(new LineBorder(Color.gray));
		AddService.setForeground(Color.WHITE);
		inputPanel.add(AddService);
		
		JButton Services = new JButton("Services");
		Services.setBounds(200,300,100,30);
		Services.setBackground(new Color(191,42,117));
		Services.setFont(new Font("Arial",Font.BOLD,16));
		Services.setBorder(new LineBorder(Color.gray));
		Services.setForeground(Color.WHITE);
		inputPanel.add(Services);
		
//		JButton loginBtn = new JButton("Login");
//		loginBtn.setBounds(195,300,100,30);
//		loginBtn.setBackground(new Color(191,42,117));
//		loginBtn.setFont(new Font("Arial",Font.BOLD,16));
//		loginBtn.setBorder(new LineBorder(Color.gray));
//		loginBtn.setForeground(Color.WHITE);
//		inputPanel.add(loginBtn);
		
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
		
		
		Services.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ServiceWindow();
			}
			
		});
				
		
		
				
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

	

}