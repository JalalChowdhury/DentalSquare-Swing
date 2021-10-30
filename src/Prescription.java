

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class Prescription extends JFrame {
	
	
	public Prescription() {
		setSize(1600,950);
//		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
		setLayout(null);
		
		
		
		
		
		 // header Panel
		JPanel headerPanel = new JPanel();
//		headerPanel.setBackground(new Color(29,8,74));
		headerPanel.setBounds(400,5,750,60);
		add(headerPanel);
		
		JLabel headerText = new JLabel("Prescription ");
		headerText.setForeground(new Color(191,42,117));
		headerText.setFont(new Font("Arial",Font.BOLD,32));
		headerPanel.add(headerText);
		
		//Input Field Panel
		JPanel inputPanel = new JPanel();
//		inputPanel.setBackground(new Color(29,8,74));
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
		JLabel diagnosisLabel = new JLabel("Diagnosis : ");
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
		JButton register = new JButton("Save");
		register.setBounds(1400,740,100,40);
		register.setBackground(new Color(191,42,117));
		register.setFont(new Font("Arial",Font.BOLD,16));
		register.setBorder(new LineBorder(Color.gray));
		register.setForeground(Color.WHITE);
		inputPanel.add(register);
		
		
		
		
		setVisible(true);
	}

}
