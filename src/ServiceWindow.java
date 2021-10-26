
import java.sql.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;


public class ServiceWindow extends JFrame {
	
	
	Connection conn;
	Statement st ;
    ResultSet rs ;
	
	public ServiceWindow() {
		setSize(1750,900);
//		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
		setLayout(null);
		
		
		

		 
		 
	
 		String logQuery = "SELECT * FROM `services`";

			DatabaseConnect db = new DatabaseConnect();

			 DatabaseConnect.Service[] service = db.ServiceMethod(logQuery);
			 

			
			 int boundsX=100;
			 JPanel panelMain = new JPanel();
             panelMain.setSize(1600,800);
             panelMain.setLayout(null);
			JLabel[] label =new JLabel[11];
			JLabel[] titleLabel = new JLabel[11];
			JLabel[] priceLabel = new JLabel[11];
			
			JLabel headerLabel = new JLabel("Welcome To Dentist Square");
			headerLabel.setBounds(450,10,900,80);
			headerLabel.setFont(new Font("Arial",Font.BOLD,60));
			
			JLabel headerLabel2 = new JLabel("We care about your smile :)");
			headerLabel2.setBounds(950,100,900,50);
			headerLabel2.setFont(new Font("Arial",Font.BOLD,22));
			
			panelMain.add(headerLabel);
			panelMain.add(headerLabel2);
			
			
//			appointment btn
			
			JButton AppointBtn = new JButton("Book an Appointment");
			AppointBtn.setBounds(700,700,200,50);
			AppointBtn.setBackground(new Color(191,42,117));
			AppointBtn.setFont(new Font("Arial",Font.BOLD,16));
			AppointBtn.setBorder(new LineBorder(Color.gray));
			AppointBtn.setForeground(Color.WHITE);
			panelMain.add(AppointBtn);
			
			
			
			
			for(int i=0; i<service.length;i++) {
//				if(service[i].getTitle!=null) {
//				System.out.println(serv[i]);
				
				 try {
		             String path = service[i].getImg();
		             System.out.println("Get Image from " + path);
		             URL url = new URL(path);
		             BufferedImage image = ImageIO.read(url);
		             System.out.println("Load image into frame...");
		             
		             Image newImage = image.getScaledInstance(300, 150, Image.SCALE_DEFAULT);
		             
		             System.out.println("Bounds X " +boundsX);
		             
		             label[i] = new JLabel(new ImageIcon(newImage));
		             label[i].setBounds(boundsX,400,300,150);
		             
		             titleLabel[i] = new JLabel("Title : "+service[i].getTitle());
		             titleLabel[i].setBounds(boundsX,560,300,40);
		             titleLabel[i].setFont(new Font("Arial",Font.BOLD,20));
		             
		             priceLabel[i] = new JLabel("Price is: $"+service[i].getPrice());
		             priceLabel[i].setBounds(boundsX,610,300,20);
		             priceLabel[i].setFont(new Font("Arial",Font.BOLD,19));
		             

		               
		               // added label in jPANEL
		               panelMain.add(label[i]);
		               panelMain.add(titleLabel[i]);
		               panelMain.add(priceLabel[i]);
		        
		               boundsX+=310;
		        
		               add(panelMain);
		               
		         } catch (Exception exp) {
		             exp.printStackTrace();
		         }
				
//				}
			}
			
			
			
			
			

			 setVisible(true);


		
	    }          
	
	
		
}


