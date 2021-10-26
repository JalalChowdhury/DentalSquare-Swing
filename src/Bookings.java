import java.awt.Color;
import java.awt.Font;

import javax.swing.*;    
public class Bookings {    
    JFrame f;    
    Bookings(){    
    f=new JFrame();    
    
    f.setSize(1200,900);   
    f.setTitle("Dental Square");
//    JLabel headerText = new JLabel("Welcome To Dental Square And Create Your Account");
//    headerText.setBounds(100,10,800,50);
//	headerText.setForeground(new Color(191,42,117));
//	headerText.setFont(new Font("Arial",Font.BOLD,30));
//	f.add(headerText);

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
    
    String column[]={"ID","NAME","Mobile", "ADDRESS", "DATE","TIME"};         
    JTable jt=new JTable(data,column);    
    jt.setBounds(100,100,1000,750);          
    JScrollPane sp=new JScrollPane(jt);    
    f.add(sp);         
    
    f.setVisible(true);    
}     

    
}  