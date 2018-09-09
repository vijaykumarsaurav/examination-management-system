package app.ems.org;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;


public class LoginEMS {


	TextField t1,t2,oname,opass,nname,npass ;
	Button b1, b2,ok,can,ca;
	Label l1,l2,log,msglab,help_msg;
	JFrame f;
	Panel p2,i;
	TextArea tt;
	JLabel pic;
	JDialog exit_dia,d;	int pass_file; 
	Panel pl=new Panel();
	Panel p=new Panel();
	Font font=new Font("Arial",Font.BOLD,16);
	String pname,ppass;
	public LoginEMS()
	{
		f=new JFrame("Examination Management System - login");
		f.setState(0);
		f.setSize(840,700);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
     	int x = (int) ((dimension.getWidth() - f.getWidth()) / 2);
     	int y = (int) ((dimension.getHeight() - f.getHeight()) / 2);
     	f.setLocation(x, y);
     	
		f.setResizable(false);
		f.setLayout(null);
		f.setBackground(Color.gray);
		ImageIcon ii=new ImageIcon("mainpic.jpg");
	    pic =new JLabel(ii); 
		pic.setBounds(0,60,800,650);
	//	f.add(pic);
	//	ImageIcon iii=new ImageIcon("welcome.jpg");
		Label wel=new Label("Welcome To...                                                                                   ...To Welcome");
		Label ems =new Label("Examination Management System",Label.CENTER);
		Font f1=new Font("Arial",Font.BOLD,22);
		Font f2=new Font("Castellar",Font.BOLD,40);
		wel.setFont(f1);
		ems.setBackground(Color.white);
		wel.setBackground(Color.blue);
		ems.setFont(f2);
		wel.setBounds(0,30,900,40);
		ems.setBounds(1,10,900,100);
		//f.add(wel);
		f.add(ems);
		//Font bf=new Font("Castellar",Font.BOLD,17);
		
	
		p.setLayout(null);
		p.setBackground(Color.white);
		p.setBounds(200,297,438,328);
		
		log =new Label("Loing Details",Label.CENTER);
		log.setBounds(0,0,438,40);
		log.setBackground(Color.green);
		p.add(log);
		l1 =new Label("User Name");
		l1.setBounds(40,70,150,30);
		p.add(l1);
		t1 =new TextField();
		t1.setBounds(200,70,170,30);
		t1.setBackground(Color.yellow);
		p.add(t1);
		l2= new Label("Passward");
		l2.setBounds(40,120,150,30);
		p.add(l2);
		t2 =new TextField();
		t2.setEchoChar('*');
		t2.setBounds(200,120,170,30);
		t2.setBackground(Color.yellow);
		p.add(t2);
		msglab=new Label("Please enter the name and passward",Label.CENTER);
		msglab.setBounds(0,175,400,30);
		p.add(msglab);
		ok = new Button("OK");
		ok.setBounds(100,230,100,30);
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

			//	JOptionPane.showMessageDialog (null, (String)t1.getText(), "Title", JOptionPane.INFORMATION_MESSAGE);
				String name=(String)t1.getText();
				String pass=(String)t2.getText();
				
 				try{
					Connection	con =  MySQLConnection.getConnection();
					
	  				Statement st = con.createStatement();
	   				ResultSet res = st.executeQuery("select * from user where username='"+name+"' && password='"+pass+"'");		  				
	  				while (res.next()) 
	  				{
	  				pname = res.getString("username");
					ppass = res.getString("password");
		  		   	}
  		 	  	}
  			  catch (Exception ee){
  			  //JOptionPane.showMessageDialog(null,"Database connection error "+e.getCause(),"Error !",JOptionPane.ERROR_MESSAGE); 	
  				  ee.printStackTrace();
  			  }		
 				 	
				if(name.equalsIgnoreCase(pname) && pass.equalsIgnoreCase(ppass))
				{
				 new EMSMain();	
				f.setVisible(false);
				}
				else
				{
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null,"Invalid User Name or Password","Error!", JOptionPane.ERROR_MESSAGE);
				}
		
			}
			});
		
		
		p.add(ok);
	//	ok.setBackground(Color.pink);
		can =new Button("Reset");
		can.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent e) {
		         t1.setText("");
		         t2.setText("");
		     }
		});
		
	//	can.setBackground(Color.pink);
		can.setBounds(240,230,100,30);
		p.add(can);
		//Font f1=new Font("Helvetica",Font.BOLD,17);
     	Font f3=new Font("Helvetica",Font.PLAIN,25);
     	l1.setFont(f1);
     	l2.setFont(f1);
     	ok.setFont(f1);
     	can.setFont(f1);
     	log.setFont(f3);
		f.remove(pl);
     	f.add(p);
    
     	f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        f.addWindowListener( new WindowAdapter() {
             @Override
             public void windowClosing(WindowEvent we) {
            	 int opcion = JOptionPane.showConfirmDialog(null, "Do you want really close the application !", "Oh No !!! ", JOptionPane.YES_NO_OPTION);

            	 if (opcion == 0) { //The ISSUE is here
            		 System.exit(0);
            	 } else {
            	   
            	 }
                 
             }
         } );
     	
     	f.setVisible(true);
   
}
  	 
/*public static void main(String[] args) {
	new LoginEMS();
}
	*/
}
