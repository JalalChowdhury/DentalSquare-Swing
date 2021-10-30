import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.border.LineBorder;


public class Prescription extends JFrame {
	
	private Container cont;
	
	public Prescription() {
		setSize(1600,950);
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
		
		
		
		
		
		 // header Panel
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(new Color(130, 221, 237));
		headerPanel.setBounds(400,5,750,60);
		add(headerPanel);
		
		JLabel headerText = new JLabel("Prescription ");
		headerText.setForeground(new Color(191,42,117));
		headerText.setFont(new Font("Arial",Font.BOLD,32));
		headerPanel.add(headerText);
		
		//Input Field Panel
		JPanel inputPanel = new JPanel();
		inputPanel.setBackground(new Color(130, 221, 237));
		inputPanel.setBounds(5,70,1530,880);
		inputPanel.setLayout(null);
		add(inputPanel);
		
		/*--------------------------------------
		    name,age,mob,address
		 ------------------------------------------*/
		JLabel nameLabel = new JLabel("Patient's Name : ");
		nameLabel.setBounds(70,60,200,35);
		nameLabel.setFont(new Font("Arial",Font.BOLD,20));
//		emailLabel.setForeground(Color.white);
		inputPanel.add(nameLabel);
		JTextField nametext = new JTextField();
		nametext.setBounds(250,60,250,35);
		inputPanel.add(nametext);
		
		JLabel ageLabel = new JLabel("Age : ");
		ageLabel.setBounds(550,60,100,35);
		ageLabel.setFont(new Font("Arial",Font.BOLD,20));
//		emailLabel.setForeground(Color.white);
		inputPanel.add(ageLabel);
		JTextField agetext = new JTextField();
		agetext.setBounds(620,60,200,35);
		inputPanel.add(agetext);
		
		JLabel mobileLabel = new JLabel("Mobile : ");
		mobileLabel.setBounds(850,60,100,35);
		mobileLabel.setFont(new Font("Arial",Font.BOLD,20));
//		emailLabel.setForeground(Color.white);
		inputPanel.add(mobileLabel);
		JTextField mobiletext = new JTextField();
		mobiletext.setBounds(960,60,200,35);
		inputPanel.add(mobiletext);
		
		JLabel addressLabel = new JLabel("Address : ");
		addressLabel.setBounds(1165,60,100,35);
		addressLabel.setFont(new Font("Arial",Font.BOLD,20));
//		emailLabel.setForeground(Color.white);
		inputPanel.add(addressLabel);
		JTextField addresstext = new JTextField();
		addresstext.setBounds(1270,60,250,35);
		inputPanel.add(addresstext);
		
		/*--------------------------------------
	        Diagonosis
	    ------------------------------------------*/
		JLabel diagnosisLabel = new JLabel("Diagnosis");
		diagnosisLabel.setBounds(70,120,200,35);
		diagnosisLabel.setFont(new Font("Arial",Font.BOLD,20));
//		emailLabel.setForeground(Color.white);
		inputPanel.add(diagnosisLabel);
		
		JLabel pressureLabel = new JLabel("Pressure : ");
		pressureLabel.setBounds(70,170,120,35);
		pressureLabel.setFont(new Font("Arial",Font.BOLD,20));
//		emailLabel.setForeground(Color.white);
		inputPanel.add(pressureLabel);
		JTextField pressuretext = new JTextField();
		pressuretext.setBounds(220,170,250,35);
		inputPanel.add(pressuretext);
		
		JLabel temperatureLabel = new JLabel("Temperature : ");
		temperatureLabel.setBounds(70,220,150,35);
		temperatureLabel.setFont(new Font("Arial",Font.BOLD,20));
//		emailLabel.setForeground(Color.white);
		inputPanel.add(temperatureLabel);
		JTextField temperaturetext = new JTextField();
		temperaturetext.setBounds(220,220,250,35);
		inputPanel.add(temperaturetext);
		
		JLabel symptomsLabel = new JLabel("Symptoms : ");
		symptomsLabel.setBounds(70,270,150,35);
		symptomsLabel.setFont(new Font("Arial",Font.BOLD,20));
//		emailLabel.setForeground(Color.white);
		inputPanel.add(symptomsLabel);
		JTextArea symptomsArea = new JTextArea();
		symptomsArea.setFont(new Font("Arial",Font.BOLD,20));
		symptomsArea.setBounds(70,310,400,400);
		inputPanel.add(symptomsArea);
		
		JLabel MedicineLabel = new JLabel("Medicine : ");
		MedicineLabel.setBounds(600,270,150,35);
		MedicineLabel.setFont(new Font("Arial",Font.BOLD,20));
//		emailLabel.setForeground(Color.white);
		inputPanel.add(MedicineLabel);
		JTextArea MedicineArea = new JTextArea();
		MedicineArea.setFont(new Font("Arial",Font.BOLD,18));
		MedicineArea.setBounds(600,310,900,400);
		inputPanel.add(MedicineArea);
		
		// save button
		JButton saveBtn = new JButton("Save");
		saveBtn.setBounds(1400,740,100,40);
		saveBtn.setBackground(new Color(191,42,117));
		saveBtn.setFont(new Font("Arial",Font.BOLD,16));
		saveBtn.setBorder(new LineBorder(Color.gray));
		saveBtn.setForeground(Color.WHITE);
		inputPanel.add(saveBtn);
		
		JButton homeBtn = new JButton("Back to Home");
		homeBtn.setBounds(1180,740,200,40);
		homeBtn.setBackground(new Color(191,42,117));
		homeBtn.setFont(new Font("Arial",Font.BOLD,16));
		homeBtn.setBorder(new LineBorder(Color.gray));
		homeBtn.setForeground(Color.WHITE);
		inputPanel.add(homeBtn);
		
		
		
		setVisible(true);
		
		

		saveBtn.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//get input text
				String name = nametext.getText();
				String age = agetext.getText();
				String pressure = pressuretext.getText();
				String temperature = temperaturetext.getText();
				String mobile = mobiletext.getText();
				String address = addresstext.getText();
				String symptoms = symptomsArea.getText();
				String medicine = MedicineArea.getText();
				
				
				//validation
				String mobileRex = "(\\+88)?01[3-9]\\d{8}";
				String nameRex = "^[a-zA-Z. ]+$";
				String emailRex = "^[a-zA-Z0-9.]+@[a-z]+.[a-z]+$";
				String passRex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
				
				//conditions
				if(!Pattern.matches(nameRex, name)) {
					JOptionPane.showMessageDialog(null,"In-Valid UserName");
				}
		
				
				else if(!Pattern.matches(mobileRex, mobile)) {
					JOptionPane.showMessageDialog(null,"In-Valid Mobile number");
				}
				else {
					dispose();
					try {
						
						DatabaseConnect db = new DatabaseConnect();
                 		String queryInsert = "INSERT INTO `prescription`(`name`, `age`, `mobile`, `address`, `pressure`, `temperature`, `symptoms`, `medicine`) VALUES ('"+name+"','"+age+"','"+mobile+"','"+address+"','"+pressure+"','"+temperature+"','"+symptoms+"','"+medicine+"')";
						
						db.PrescriptionInsert(queryInsert);
						
						
						new PrintPrescription(name, age, mobile, address, pressure, temperature, symptoms, medicine);

						
						
						
						
						
					} catch(Exception e2) {
						System.err.println(e2);
					}
					
					
					
					
					
				}
				
				
				
				
			}
			
		});
		
		homeBtn.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					new AddService();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		
		
		
		
	}

}