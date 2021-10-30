
import java.sql.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;


public class ServiceWindow extends JFrame {
	
	private Container cont;
	Connection conn;
	Statement st ;
    ResultSet rs ;
	
	public ServiceWindow() {
		setSize(1750,900);
//		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
		setLayout(null);
		
		 /* -------------------------------------------
		          Container setup
	     ---------------------------------------------- */
        cont = this.getContentPane();
        cont.setLayout(null);
        cont.setBackground(new Color(130, 221, 237));
		
		

		 
		 
	
 			String logQuery = "SELECT * FROM `services`";

			DatabaseConnect db = new DatabaseConnect();

			 DatabaseConnect.Service[] service = db.ServiceMethod(logQuery);
			 

			
			 int boundsX=100;
			 // Main JPanel
			 JPanel panelMain = new JPanel();
			 panelMain.setBackground(new Color(130, 221, 237));
             panelMain.setSize(1700,800);
             panelMain.setLayout(null);
             
			JLabel[] label =new JLabel[11];
			JLabel[] titleLabel = new JLabel[11];
			JLabel[] priceLabel = new JLabel[11];
			
			JLabel logoLabel = new JLabel("DENTAL SQUARE");
			logoLabel.setForeground(new Color(191,42,117));
			logoLabel.setBounds(100,10,400,80);
			logoLabel.setFont(new Font("Arial",Font.BOLD,40));
			
			JLabel headerLabel = new JLabel("Welcome To Dental Square");
			headerLabel.setBounds(450,100,900,80);
			headerLabel.setFont(new Font("Arial",Font.BOLD,60));
			
			JLabel headerLabel2 = new JLabel("We care about your smile :)");
			headerLabel2.setBounds(950,190,900,50);
			headerLabel2.setFont(new Font("Arial",Font.BOLD,22));
			
			JLabel popularLabel = new JLabel("Our Top Services");
			popularLabel.setBounds(500,250,1200,80);
			popularLabel.setFont(new Font("Arial",Font.BOLD,30));
			
			panelMain.add(popularLabel);
			panelMain.add(logoLabel);
			panelMain.add(headerLabel);
			panelMain.add(headerLabel2);
			
			//NavBar Btn
//			appointment btn
			
			JButton AppointBtn = new JButton("Book an Appointment");
			AppointBtn.setBounds(1200,20,200,50);
			AppointBtn.setBackground(new Color(191,42,117));
			AppointBtn.setFont(new Font("Arial",Font.BOLD,16));
			AppointBtn.setBorder(new LineBorder(Color.gray));
			AppointBtn.setForeground(Color.WHITE);
			panelMain.add(AppointBtn);
			
			JButton logoutBtn = new JButton("Logout");
			logoutBtn.setBounds(1430,20,200,50);
			logoutBtn.setBackground(new Color(191,42,117));
			logoutBtn.setFont(new Font("Arial",Font.BOLD,16));
			logoutBtn.setBorder(new LineBorder(Color.gray));
			logoutBtn.setForeground(Color.WHITE);
			panelMain.add(logoutBtn);
			
			
			
			
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
			AppointBtn.addActionListener(new ActionListener(){
				
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					try {
						new Appointment();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			});
			logoutBtn.addActionListener(new ActionListener(){
				
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
			
			
			
			
			

			 setVisible(true);


		
	    }          
	
	
		
}


