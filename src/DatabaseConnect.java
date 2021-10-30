
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;



public class DatabaseConnect {
	private Connection con;
	private Statement st ;
	private ResultSet rs;
	private int found = 0;
	
	public DatabaseConnect() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dentalsquare","root", "");
			st = con.createStatement();
			
		}catch(Exception e) {
			System.err.println("Error : " +e);
		}
	}

	public void RegisterInsert(String queryInsert) {
		try {
			st.executeUpdate(queryInsert);
			JOptionPane.showMessageDialog(null,"Register Complete !!!");
			
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Not Inserted !!!"+ex);
		}
		
	}

	public void LoginMethod(String logQuery, String logEmail, String logPass) {
		try {
			rs = st.executeQuery(logQuery);
			while(rs.next()) {
				String dbEmail = rs.getString(3);
				String dbPass = rs.getString(4);
				if(logEmail.equals(dbEmail) && logPass.equals(dbPass)) {
					found = 1;
					
					break;
				}
			}
			
			if(found==1) {
//				JOptionPane.showMessageDialog(null, "Welcome to CSE of website");
				//new window 
				new ServiceWindow();
			}
			else {
				JOptionPane.showMessageDialog(null, "UserName or pasword are incorrect");
				
			}
		} catch(Exception e) {
			
		}
		
	}

	public void AdminLoginMethod(String logQuery, String logUserName, String logPass) {
		try {
			rs = st.executeQuery(logQuery);
			while(rs.next()) {
				String dbEmail = rs.getString(3);
				String dbPass = rs.getString(4);
				if(logUserName.equals(dbEmail) && logPass.equals(dbPass)) {
					found = 1;
					
					break;
				}
			}
			
			if(found==1) {
//				JOptionPane.showMessageDialog(null, "Admin Logged in");
				//new window 
				dispose();

				new AddService();

			}
			else {
				JOptionPane.showMessageDialog(null, "UserName or pasword are incorrect");
				
			}
		} catch(Exception e) {
			
		}
		
	}

	private void dispose() {
		// TODO Auto-generated method stub
		
	}

	public void AddServiceInsert(String queryInsert) {
		// TODO Auto-generated method stub
		try {
			st.executeUpdate(queryInsert);
			JOptionPane.showMessageDialog(null,"Service Added !");
			
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Not Inserted !!!"+ex);
		}
	}

	
//	  Service Method
	

	
	class Service {
	    String service_price;
	    String service_title;
	    String service_img;

	    Service(String sprice, String t, String img) {
	    	service_price = sprice;
	    	service_title = t;
	    	service_img = img;
	    }

	    public String getPrice() {
			return service_price;
	    	
	    }
	    
	    public String getTitle() {
			return service_title;
	    	
	    }
	    
	    public String getImg() {
			return service_img;
	    	
	    }
	}
	
	
	@SuppressWarnings("null")
	public DatabaseConnect.Service[] ServiceMethod(String logQuery) {
		// TODO Auto-generated method stub
		Service[] service = new Service[10];
		
		try {
			rs = st.executeQuery(logQuery);
			int i=0;
			while(rs.next()) {
				String title = rs.getString(2);
				String price = rs.getString(3);
				String img = rs.getString(4);
				service[i] = new Service(price, title, img);

				i++;
			}
			
		
		} catch(Exception e) {
			
		}
		return service;
		
	}

	
	public String[][] AppointmentMethod(String logQuery) {
		// TODO Auto-generated method stub
		String[][] appointment = new String[100][100];
		
		try {
			rs = st.executeQuery(logQuery);
			int i=0;
			while(rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String mobile = rs.getString(3);
				String address = rs.getString(4);
				String date = rs.getString(5);
				String time = rs.getString(6);
				for(int j=0;j<6;j++) {
					appointment[i][j] = rs.getString(j+1);
				}
				i++;
			}
			
		
		} catch(Exception e) {
			
		}
		return appointment;
		
	}

	public void AppointmentInsert(String queryInsert) {
		// TODO Auto-generated method stub
		try {
			st.executeUpdate(queryInsert);
			JOptionPane.showMessageDialog(null,"Appointent Booked !");
			
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Appointent Booking Failed."+ex);
		}
		
	}

	public void PrescriptionInsert(String queryInsert) {
		// TODO Auto-generated method stub
		
		try {
			st.executeUpdate(queryInsert);
			JOptionPane.showMessageDialog(null,"Prescription Saved !!!");
			
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(null,"Not Saved: "+ex);
		}
		
	}


	
	
	

}