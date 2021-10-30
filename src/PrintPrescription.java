import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterJob;
import java.io.IOException;
import java.util.regex.Pattern;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.*;
import javax.swing.border.LineBorder;



public class PrintPrescription extends JFrame {
	private Container cont;

  public PrintPrescription(String name, String age, String mobile, String address, String pressure, String temperature, String symptoms, String medicine) {

    setSize(900, 1150);
    //    setVisible(true);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(3);
    setLayout(null);
    
    /* -------------------------------------------
		Container setup
	---------------------------------------------- */
    cont = this.getContentPane();
    cont.setLayout(null);
    cont.setBackground(Color.white);

    // header Panel
    JPanel headerPanel = new JPanel();
      headerPanel.setBackground(Color.white);
    headerPanel.setBounds(10, 5, 800, 100);
    add(headerPanel);

    JLabel headerText = new JLabel("Prescription(Print) ");
    headerText.setForeground(new Color(191, 42, 117));
    headerText.setFont(new Font("Arial", Font.BOLD, 32));

    // save button
    JButton printBtn = new JButton("Print");
    printBtn.setBounds(500, 10, 200, 40);
    printBtn.setBackground(new Color(191, 42, 117));
    printBtn.setFont(new Font("Arial", Font.BOLD, 16));
    printBtn.setBorder(new LineBorder(Color.gray));
    printBtn.setForeground(Color.WHITE);
    headerPanel.add(printBtn);
    headerPanel.add(headerText);
    
    JButton AppointBtn = new JButton("Back to Home");
	AppointBtn.setBounds(10,10,200,40);
	AppointBtn.setBackground(new Color(191,42,117));
	AppointBtn.setFont(new Font("Arial",Font.BOLD,16));
	AppointBtn.setBorder(new LineBorder(Color.gray));
	AppointBtn.setForeground(Color.WHITE);
	headerPanel.add(AppointBtn);

    // 
    JPanel inputPanel = new JPanel();
    inputPanel.setBackground(Color.white);
    inputPanel.setBounds(10, 70, 790, 1122);
    inputPanel.setLayout(null);
    add(inputPanel);

    JLabel infoLabel = new JLabel("Personal Info : ");
    infoLabel.setBounds(70, 60, 250, 35);
    infoLabel.setFont(new Font("Arial", Font.BOLD, 24));
    //            emailLabel.setForeground(Color.white);
    inputPanel.add(infoLabel);

    JLabel nameLabel = new JLabel("Name : ");
    nameLabel.setBounds(80, 100, 200, 35);
    nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
    //          emailLabel.setForeground(Color.white);
    inputPanel.add(nameLabel);
    //          JTextField nametext = new JTextField();
    JLabel nametext = new JLabel(name);
    nametext.setBounds(200, 100, 250, 35);
    inputPanel.add(nametext);

    //age
    JLabel ageLabel = new JLabel("Age : ");
    ageLabel.setBounds(80, 140, 100, 35);
    ageLabel.setFont(new Font("Arial", Font.BOLD, 18));
    //        emailLabel.setForeground(Color.white);
    inputPanel.add(ageLabel);
    JLabel agetext = new JLabel(age);
    agetext.setBounds(200, 140, 100, 35);
    inputPanel.add(agetext);

    //mob
    JLabel mobileLabel = new JLabel("Mobile : ");
    mobileLabel.setBounds(80, 180, 100, 35);
    mobileLabel.setFont(new Font("Arial", Font.BOLD, 18));
    //      emailLabel.setForeground(Color.white);
    inputPanel.add(mobileLabel);
    JLabel mobiletext = new JLabel(mobile);
    mobiletext.setBounds(200, 180, 200, 35);
    inputPanel.add(mobiletext);

    // address
    JLabel addressLabel = new JLabel("Address : ");
    addressLabel.setBounds(80, 220, 100, 35);
    addressLabel.setFont(new Font("Arial", Font.BOLD, 18));
    //    emailLabel.setForeground(Color.white);
    inputPanel.add(addressLabel);
    JLabel addresstext = new JLabel(address);
    addresstext.setBounds(200, 220, 250, 35);
    inputPanel.add(addresstext);

    /*--------------------------------------
           //    Diagonosis
      ------------------------------------------*/
    JLabel diagnosisLabel = new JLabel("Diagnosis");
    diagnosisLabel.setBounds(70, 260, 200, 35);
    diagnosisLabel.setFont(new Font("Arial", Font.BOLD, 24));
    //emailLabel.setForeground(Color.white);
    inputPanel.add(diagnosisLabel);

    JLabel pressureLabel = new JLabel("Pressure : ");
    pressureLabel.setBounds(80, 300, 120, 35);
    pressureLabel.setFont(new Font("Arial", Font.BOLD, 18));
    //       emailLabel.setForeground(Color.white);
    inputPanel.add(pressureLabel);
    JLabel pressuretext = new JLabel(pressure);
    pressuretext.setBounds(210, 300, 250, 35);
    inputPanel.add(pressuretext);

    JLabel temperatureLabel = new JLabel("Temperature : ");
    temperatureLabel.setBounds(80, 340, 150, 35);
    temperatureLabel.setFont(new Font("Arial", Font.BOLD, 18));
    //     emailLabel.setForeground(Color.white);
    inputPanel.add(temperatureLabel);
    JLabel temperaturetext = new JLabel(temperature);
    temperaturetext.setBounds(260, 340, 250, 35);
    inputPanel.add(temperaturetext);

    // symp

    JLabel symptomsLabel = new JLabel("Symptoms : ");
    symptomsLabel.setBounds(70, 400, 150, 35);
    symptomsLabel.setFont(new Font("Arial", Font.BOLD, 20));
    //   emailLabel.setForeground(Color.white);
    inputPanel.add(symptomsLabel);
    JTextArea symptomsArea = new JTextArea(symptoms);
    symptomsArea.setFont(new Font("Arial", Font.BOLD, 20));
    symptomsArea.setBounds(70, 440, 200, 400);
    inputPanel.add(symptomsArea);

    JLabel MedicineLabel = new JLabel("Medicine : ");
    MedicineLabel.setBounds(300, 400, 150, 35);
    MedicineLabel.setFont(new Font("Arial", Font.BOLD, 20));
    // emailLabel.setForeground(Color.white);
    inputPanel.add(MedicineLabel);
    JTextArea MedicineArea = new JTextArea(medicine);
    MedicineArea.setFont(new Font("Arial", Font.BOLD, 18));
    MedicineArea.setBounds(300, 440, 600, 400);
    inputPanel.add(MedicineArea);

    setVisible(true);

	printBtn.addActionListener(new ActionListener(){
		
		@Override
		public void actionPerformed(ActionEvent e) {
		
			
//			----------Print-------------
			
			PrinterJob job = PrinterJob.getPrinterJob();
            job.setJobName("Print Data");
            
            job.setPrintable(new Printable(){
            public int print(Graphics pg,PageFormat pf, int pageNum){
                    pf.setOrientation(PageFormat.LANDSCAPE);
                 if(pageNum > 0){
                    return Printable.NO_SUCH_PAGE;
                }
                
                Graphics2D g2 = (Graphics2D)pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(1,1);
                
                inputPanel.print(g2);
         
               
                return Printable.PAGE_EXISTS;
                         
                
            }
    });
            boolean ok = job.printDialog();
        if(ok){
        try{
            
        job.print();
        }
        catch (PrinterException ex){
	ex.printStackTrace();
}
        }
			
//			-----------------------------
			
			
		}
		
	});
	
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
  }

}