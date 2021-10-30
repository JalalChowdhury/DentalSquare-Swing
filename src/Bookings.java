import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.LineBorder;    
public class Bookings extends JFrame {  
	private Container cont;
//    JFrame f;    
    Bookings(){    
//    f=new JFrame();    
    
    setSize(1200,900);   
    setTitle("Dental Square");
    
    /* -------------------------------------------
		Container setup
	---------------------------------------------- */
    cont = this.getContentPane();
    cont.setLayout(null);
    cont.setBackground(new Color(130, 221, 237));

    
    JLabel logoLabel = new JLabel("DENTAL SQUARE");
	logoLabel.setForeground(new Color(191,42,117));
	logoLabel.setBounds(100,10,400,80);
	logoLabel.setFont(new Font("Arial",Font.BOLD,40));
	cont.add(logoLabel);
    
    JLabel headerText = new JLabel("All Bookings Information ");
    headerText.setBounds(110,105,700,40);  
//	headerText.setForeground( Color.yellow);
	headerText.setFont(new Font("Arial",Font.BOLD,30));
	cont.add(headerText);
	
	//NavBar Btn

	
	JButton AppointBtn = new JButton("Back to Home");
	AppointBtn.setBounds(600,20,200,50);
	AppointBtn.setBackground(new Color(191,42,117));
	AppointBtn.setFont(new Font("Arial",Font.BOLD,16));
	AppointBtn.setBorder(new LineBorder(Color.gray));
	AppointBtn.setForeground(Color.WHITE);
    cont.add(AppointBtn);
	
	JButton prescriptionBtn = new JButton("Prescription");
	prescriptionBtn.setBounds(830,20,200,50);
	prescriptionBtn.setBackground(new Color(191,42,117));
	prescriptionBtn.setFont(new Font("Arial",Font.BOLD,16));
	prescriptionBtn.setBorder(new LineBorder(Color.gray));
	prescriptionBtn.setForeground(Color.WHITE);
	cont.add(prescriptionBtn);



    String logQuery = "SELECT * FROM `appointments`";
	DatabaseConnect db = new DatabaseConnect();
//	DatabaseConnect.Appointment[] appointment = db.AppointmentMethod(logQuery);
	String[][] appointment = db.AppointmentMethod(logQuery);


    
	String[][] data = new String[100][100];
    

    
    for(int i=0; i<appointment.length;i++) {
    	for(int j=0; j<6;j++) {
//    		data[i][j] = appointment[i][j];
    		if(appointment[i][j]!=null) {
        		data[i][j] = appointment[i][j];
        		System.out.println(data[i][j]);


    		}
    	}
    }
    
    String column[]={"ID","NAME","MOBILE", "ADDRESS", "DATE","TIME"};         
    JTable jt=new JTable(data,column);    
    jt.setBounds(110,150,1000,650);          
    JScrollPane sp=new JScrollPane(jt); 
    cont.add(jt);
    cont.add(sp);         
    
    setVisible(true);  
    
    
    AppointBtn.addActionListener(new ActionListener(){
		
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
    prescriptionBtn.addActionListener(new ActionListener(){
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			new Prescription();
		}
		
	});
}     

    
}  