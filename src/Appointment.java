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
		nameLabel.setBounds(65,25,150,35);
		nameLabel.setFont(new Font("Arial",Font.BOLD,16));
		nameLabel.setForeground(Color.white);
		inputPanel.add(nameLabel);
		JTextField nametext = new JTextField();
		nametext.setBounds(200,25,300,35);
		inputPanel.add(nametext);
		
		JLabel mobileLabel = new JLabel("Mobile No : ");
		mobileLabel.setBounds(90,90,150,35);
		mobileLabel.setFont(new Font("Arial",Font.BOLD,17));
		mobileLabel.setForeground(Color.white);
		inputPanel.add(mobileLabel);
		JTextField mobiletext = new JTextField();
		mobiletext.setBounds(200,90,300,35);
		inputPanel.add(mobiletext);
		
		JLabel addressLabel = new JLabel("Address : ");
		addressLabel.setBounds(102,150,150,35);
		addressLabel.setFont(new Font("Arial",Font.BOLD,17));
		addressLabel.setForeground(Color.white);
		inputPanel.add(addressLabel);
		JTextField addresstext = new JTextField();
		addresstext.setBounds(200,150,300,35);
		inputPanel.add(addresstext);
		
		JLabel dateLabel = new JLabel("Date : ");
		dateLabel.setBounds(130,210,150,35);
		dateLabel.setFont(new Font("Arial",Font.BOLD,16));
		dateLabel.setForeground(Color.white);
		inputPanel.add(dateLabel);
		JTextField datetext = new JTextField();
		datetext.setBounds(200,210,300,35);
		inputPanel.add(datetext);
		
		JLabel timeLabel = new JLabel("Time : ");
		timeLabel.setBounds(130,270,150,35);
		timeLabel.setFont(new Font("Arial",Font.BOLD,17));
		timeLabel.setForeground(Color.white);
		inputPanel.add(timeLabel);
		JTextField timetext = new JTextField();
		timetext.setBounds(200,270,300,35);
		inputPanel.add(timetext);
		
		JLabel commentLabel = new JLabel("Comment/Query : ");
		commentLabel.setBounds(40,320,150,55);
		commentLabel.setFont(new Font("Arial",Font.BOLD,16));
		commentLabel.setForeground(Color.white);
		inputPanel.add(commentLabel);
		JTextField commenttext = new JTextField();
		commenttext.setBounds(200,330,300,35);
		inputPanel.add(commenttext);
		
		//button field
		JButton appointment = new JButton("Book Appointment");
		appointment.setBounds(200,400,200,40);
		appointment.setBackground(new Color(191,42,117));
		appointment.setFont(new Font("Arial",Font.BOLD,16));
		appointment.setBorder(new LineBorder(Color.gray));
		appointment.setForeground(Color.WHITE);
		inputPanel.add(appointment);
		
	
		
	
		
		
		// appointment Image Area
		
		JPanel imgPanel = new JPanel();
//		imgPanel.setBackground(new Color(75,196,196));
		imgPanel.setBounds(550,71,500,900);
		imgPanel.setBackground(new Color(29,8,74));
		
		String path = "https://i.ibb.co/hDFMcWY/appointment.png";
        System.out.println("Get Image from " + path);
        URL url = new URL(path);
        BufferedImage image = ImageIO.read(url);
//        System.out.println("Load image into frame...");
        
        Image newImage = image.getScaledInstance(600, 450, Image.SCALE_DEFAULT);
          
        JLabel imgLabel = new JLabel(new ImageIcon(newImage));
        imgLabel.setBounds(610,70,600,450);
        imgPanel.add(imgLabel);
        cont.add(imgPanel);
		
		
		
		
		setVisible(true);
		
		appointment.addActionListener(new ActionListener(){
			
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
			    String dateRex = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";
			    String timeRex = "^(0?[1-9]|1[0-2]):([0-5]\\d)\\s?((?:A|P)\\.?M\\.?)$";
			    
				//conditions
				if(!Pattern.matches(nameRex, name)) {
					JOptionPane.showMessageDialog(null,"In-Valid UserName");
				}
				else if(!Pattern.matches(mobileRex, mobile)) {
					JOptionPane.showMessageDialog(null,"In-Valid Mobile Number");
				}
				
				else if(!Pattern.matches(dateRex, date)) {
					JOptionPane.showMessageDialog(null,"Date format must me in dd/mm/yyyy");
				}
				else if(!Pattern.matches(timeRex, time)) {
					JOptionPane.showMessageDialog(null,"Time format must me in hh:mm AM/PM");
				}
				else {
					try {
						
						DatabaseConnect db = new DatabaseConnect();
                 		String queryInsert = "INSERT INTO `appointments`(`name`, `mobile`, `address`, `date`, `time`, `comment`) VALUES ('"+name+"','"+mobile+"','"+address+"','"+date+"','"+time+"','"+comment+"')";
						
						db.AppointmentInsert(queryInsert);
						
						
					} catch(Exception e2) {
						System.err.println(e2);
					}
					
				}
				
				
				
				
			}
			
		});
				
		
	}
}