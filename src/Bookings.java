import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.*;    
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
//    cont.setBackground(new Color(29,8,74));
    
    JLabel headerText = new JLabel("All Bookings Information ");
    headerText.setBounds(110,5,700,40);  
	headerText.setForeground(new Color(191,42,117));
	headerText.setFont(new Font("Arial",Font.BOLD,30));
	cont.add(headerText);



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
    jt.setBounds(110,50,1000,750);          
    JScrollPane sp=new JScrollPane(jt); 
    cont.add(jt);
    cont.add(sp);         
    
    setVisible(true);    
}     

    
}  