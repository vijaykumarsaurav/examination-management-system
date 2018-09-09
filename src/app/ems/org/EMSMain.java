package app.ems.org;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;
import java.io.*;

class EMSMain extends Frame 
{
	JDialog d;
	Panel i;
	Menu file,file1,file2;
	MenuItem login,chlog,exit,help,exit1,login1,chlog1,exit2,help1,login2,chlog2,help2,stu;
	MenuBar log;
	JTabbedPane jtp;	
	Font font=new Font("Arial",Font.BOLD,15);
	public EMSMain()
	{
		setSize(840,700);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
     	int x = (int) ((dimension.getWidth() - getWidth()) / 2);
     	int y = (int) ((dimension.getHeight() - getHeight()) / 2);
     	setLocation(x, y);
     	
		setTitle("Examination Management System - Home");
		setResizable(false);
		log = new MenuBar();
		file =new Menu("  Entry Menu   ");	
		login =new MenuItem("Student form");
		login.addActionListener(new student_form(this));
		chlog=new MenuItem("Date & Time");
		chlog.addActionListener(new date_time(this));
		help=new MenuItem("Answer sheet");
		help.addActionListener(new Answer_sheet(this));
		exit=new MenuItem("Exit");
		exit.addActionListener(new inputexit(this));
		file.add(login);
		file.add(chlog);
		file.add(help);
		file.add(exit);
		log.add(file);
		setMenuBar(log);
		file1 =new Menu("  Show Reports  ");
		login1 =new MenuItem("  HallTickets  ");
		login1.addActionListener(new SearchHallTickect(this));
		chlog1=new MenuItem("Examination Schidules");
		chlog1.addActionListener(new SearchExamSchidule(this));
		help1=new MenuItem("Mark Sheets");
		help1.addActionListener(new SearchMarkSheet(this));
		file1.add(login1);
		file1.add(chlog1);
		file1.add(help1);
		log.add(file1);
		setMenuBar(log);
		file2 =new Menu("  Help  ");
		login2 =new MenuItem("Entry ");
		login2.addActionListener(new InputFormHelp(this));
		stu =new MenuItem("About");
		stu.addActionListener(new About(this));
		chlog2=new MenuItem("Reports");
		chlog2.addActionListener(new OutputFormHelp(this));
		help2=new MenuItem("Setting");
		help2.addActionListener(new SettingFormHelp(this));
		file2.add(stu);
		file2.add(login2);
		file2.add(chlog2);
		file2.add(help2);
		log.add(file2);
		setMenuBar(log);
			
		 jtp=new JTabbedPane();
		 jtp.addTab("Record Entries",new inputform(this));
		 jtp.setBackground(Color.pink);
		 jtp.addTab("Show Report",new outputform(this));
		 jtp.addTab("  Personal reports & Setting  ",new Setting(this));
		 add(jtp);
		 addWindowListener(new WindowAdapter()
		 {
			public void windowClosing(WindowEvent e)
			{
				 int opcion = JOptionPane.showConfirmDialog(null, "Do you want really close the application !", "Oh No !!! ", JOptionPane.YES_NO_OPTION);

            	 if (opcion == 0) { //The ISSUE is here
            		 System.exit(0);
            	 } else {
            	   
            	 }
			} 
		 });
		 setVisible(true);
	 }
	
		/** FUNCTIONS FOR CLOSING MASSAGE **/
		
		public void set()
		{
			d=new JDialog(this,"Exit",true);
			d.setLayout(null);
			d.setBounds(200,200,500,150);
			JLabel jl=new JLabel("Do you want to continue exit this Examination Management System",JLabel.CENTER);
			jl.setBounds(0,0,500,60);
			d.add(jl);
			JButton b=new JButton("Yes");
			b.setBounds(125,70,100,30);
			JButton can=new JButton("No");
			can.setBounds(275,70,100,30);
			can.addActionListener(new MainClose());
			b.addActionListener(new MainClose());
			d.add(b);
			d.add(can);
			d.setVisible(true);	
		}
		
		class MainClose implements ActionListener
	    {
			public void  actionPerformed(ActionEvent ae)
			{
				String str=ae.getActionCommand();
				if(str.equals("Yes"))
				{
				dispose();
				System.exit(0);
				}
				else
				d.dispose();
			}
		} 
  	 	
	
  	class inputform extends JPanel
   	{
	Panel i;
	JLabel pic;
	JButton stu_form ,date,ans_sheet,help,exit;
	EMSMain e;
	public inputform(EMSMain e)
	{
		this.e=e;
		Color c=new Color(74,182,77);
		setBackground(c);	
		setLayout(null);
		ImageIcon ii=new ImageIcon("123.jpg");
	    pic =new JLabel(ii);
		pic.setBounds(255,47,528,429);	
		add(pic);
		stu_form = new JButton("Examination form");
		stu_form.setBounds(30,100,200,60);
		stu_form.setBackground(Color.yellow);
		stu_form.setForeground(Color.black);
		stu_form.addActionListener(new student_form(e));
		stu_form.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				i=new Panel();
				i.setLayout(null);
				stu_form.setBackground(Color.red);
				Font font1=new Font("Arial",Font.BOLD,20);
				i.setBounds(300,100,438,328);
				String log_help="\t\tSTUDENT EXAMINATION FORM \n\n"+"This page take data entry the all the student Examination form records as name, enrollment number,program code ,all the course code ,Examination Centre code , Study Centre code ,DD no.,DD amout ,and DD issuing bank name and address for the perpose of full recodes of student form  \ninformation of this Program\n";
				JTextPane jtp=new JTextPane();
				jtp.setText(log_help);
				jtp.setBackground(Color.yellow);
				jtp.setForeground(Color.red);
				jtp.setBounds(0,0,438,328);
				jtp.setFont(font);
				i.add(jtp);
				add(i);
				show();
			}
			public  void mouseExited(MouseEvent e)
			{
		    ImageIcon ii=new ImageIcon("125.jpg");
			stu_form.setBackground(Color.yellow);	
			remove(i);
			}
		});	
		
		add(stu_form);
		date = new JButton("Date & time");
		date.setBackground(Color.yellow);
		date.setForeground(Color.black);
		date.setBounds(30,160,200,60);
		date.addActionListener(new date_time(e));
		date.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				i=new Panel();
				i.setLayout(null);
				date.setBackground(Color.red);
				Font font1=new Font("Arial",Font.BOLD,20);
				i.setBounds(300,100,438,328);
				String log_help="\t\tDATE AND TIME\n\n"+"This button provide as management of which course code when examination happen with date and time ";
				JTextPane jtp=new JTextPane();
				jtp.setText(log_help);
				jtp.setBackground(Color.red);
				jtp.setForeground(Color.white);
				jtp.setBounds(0,0,438,328);
				jtp.setFont(font);
				i.add(jtp);				
				add(i);
				show();
			}
			public  void mouseExited(MouseEvent e)
			{
			remove(i);
			date.setBackground(Color.yellow);
			}
		});
		add(date);
		ans_sheet = new JButton("Answer sheet");
		ans_sheet.setBounds(30,220,200,60);
		ans_sheet.setBackground(Color.yellow);
		ans_sheet.setForeground(Color.black);
		ans_sheet.addActionListener(new Answer_sheet(e));
		ans_sheet.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				i=new Panel();
				i.setLayout(null);
				ans_sheet.setBackground(Color.red);
				Font font1=new Font("Arial",Font.BOLD,20);
				i.setBounds(300,100,438,328);
				String log_help="\t\tANSWER SHEET\n\n+This is answer sheet manu this take the input of student answer sheet as marks maximum marks and evaluated marks";  
				JTextPane jtp=new JTextPane();
				jtp.setText(log_help);
				jtp.setBackground(Color.blue);
				jtp.setForeground(Color.white);
				jtp.setBounds(0,0,438,328);
				jtp.setFont(font);
				i.add(jtp);
				add(i);
				show();
			}
			public  void mouseExited(MouseEvent e)
			{
			remove(i);
			ans_sheet.setBackground(Color.yellow);
			}
		});
		add(ans_sheet);
		help = new JButton("Help");
		help.setBackground(Color.yellow);
		help.setForeground(Color.black);
		help.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				i=new Panel();
				i.setLayout(null);
				help.setBackground(Color.red);
				Font font1=new Font("Arial",Font.BOLD,20);
				i.setBounds(300,100,438,328);
				String log_help="\t\tHELP\n\nThis show all the entry help of each option so that the you can enter currect data and it have also the some validation but when may take some wrong information.";
				JTextPane jtp=new JTextPane();
				jtp.setText(log_help);
				jtp.setBackground(Color.lightGray);
				jtp.setForeground(Color.red);
				jtp.setBounds(0,0,438,328);
				jtp.setFont(font);
				i.add(jtp);
				add(i);
				show();
			}
			public  void mouseExited(MouseEvent e)
			{
			help.setBackground(Color.yellow);
			remove(i);
			}
		});
		help.setBounds(30,280,200,60);
		help.addActionListener(new InputFormHelp(e));
		add(help);
		exit = new JButton("Exit");
		exit.setBackground(Color.yellow);
		exit.setForeground(Color.black);
		exit.setBounds(30,340,200,60);
		exit.addActionListener(new inputexit(e));
		exit.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				i=new Panel();
				exit.setBackground(Color.red);
				i.setLayout(null);
				Font font1=new Font("Arial",Font.BOLD,20);
				i.setBounds(300,100,438,328);
				String log_help="\t\t\tEXIT \n\nThis is exit button.\n After clicking this button,the the window will be close \nThis is  Termination button of this window.";
				JTextPane jtp=new JTextPane();
				jtp.setText(log_help);
				jtp.setBackground(Color.black);
				jtp.setForeground(Color.white);
				jtp.setBounds(0,0,438,328);
				jtp.setFont(font);
				i.add(jtp);
				add(i);
				show();
			}
			public  void mouseExited(MouseEvent e)
			{
				exit.setBackground(Color.yellow);
			remove(i);
			}
		});
		add(exit);
	}
	public void actionPerformed(ActionEvent ae){}
  
}
  class outputform extends JPanel
  {
  	JLabel pic;
  	EMSMain e;
  	JButton stu_form,date,exit,ans_sheet,help;
	public outputform(EMSMain e)
	{
		this.e=e;
		setLayout(null);
		Color c=new Color(74,182,177);
		setBackground(c);	
		ImageIcon ii=new ImageIcon("1234.jpg");
	    pic =new JLabel(ii); 
	   	pic.setBounds(255,47,528,429);	
		add(pic);
	    stu_form = new JButton("HallTicket");
		stu_form.addActionListener(new SearchHallTickect(e));
		stu_form.setBounds(30,100,200,60);
		stu_form.setBackground(Color.yellow);
		stu_form.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				i=new Panel();
				i.setLayout(null);
				stu_form.setBackground(Color.green);
				Font font1=new Font("Arial",Font.BOLD,20);
				i.setBounds(300,100,438,328);
				String log_help="\t\tHall Ticket\n\nThis button provide the HallTicket for Examintion it contain student form recodes with date and time,\n After clicking the search menu window  will open and it window take the student entrollment number and program code  if eno. and  program code matches from database ,then give Hall Ticket.  ";
				JTextPane jtp=new JTextPane();
				jtp.setText(log_help);
				jtp.setBackground(Color.yellow);
				jtp.setForeground(Color.black);
				jtp.setBounds(0,0,438,328);
				jtp.setFont(font);
				i.add(jtp);
				
				add(i);
				show();
			}
			public  void mouseExited(MouseEvent e)
			{
			remove(i);
			stu_form.setBackground(Color.yellow);
			}
		});
		add(stu_form);
		date = new JButton("Examination Schidule");
		date.setBackground(Color.yellow);
		date.addActionListener(new SearchExamSchidule(e));
		date.setBounds(30,160,200,60);
		date.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				i=new Panel();
				i.setLayout(null);
				date.setBackground(Color.green);
				Font font1=new Font("Arial",Font.BOLD,20);
				i.setBounds(300,100,438,328);
				String log_help="\t\tEXAMINATION SCHIDULE\n\n it provides examination Attendent sheet for examintion ,after Clicking this it show a small window that show the program list ,just select the program list and with course code it give the examination schidule.   ";
				JTextPane jtp=new JTextPane();
				jtp.setText(log_help);
				jtp.setBackground(Color.green);
				jtp.setForeground(Color.blue);
				jtp.setBounds(0,0,438,328);
				jtp.setFont(font);
				i.add(jtp);
				
				add(i);
				show();
			}
			public  void mouseExited(MouseEvent e)
			{
			date.setBackground(Color.yellow);
			remove(i);
			}
		});
		add(date);
		ans_sheet = new JButton("Mark sheet");
		ans_sheet.addActionListener(new SearchMarkSheet(e));
		ans_sheet.setBounds(30,220,200,60);
		ans_sheet.setBackground(Color.yellow);
		ans_sheet.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				i=new Panel();
				i.setLayout(null);
				ans_sheet.setBackground(Color.green);
				Font font1=new Font("Arial",Font.BOLD,20);
				i.setBounds(300,100,438,328);
				String log_help="\t\tMARK SHEET\n\nThis is as like forma of mark sheet it's not actual mark sheet,is only formate of course code ,maximum marks and marks. it also show small window for conformation of student existence and appreance of this.";
				JTextPane jtp=new JTextPane();
				jtp.setText(log_help);
				jtp.setBackground(Color.blue);
				jtp.setForeground(Color.white);
				jtp.setBounds(0,0,438,328);
				jtp.setFont(font);
				i.add(jtp);
				add(i);
				show();
			}
			public  void mouseExited(MouseEvent e)
			{
			ans_sheet.setBackground(Color.yellow);
			remove(i);
			}
		});
		add(ans_sheet);
		help = new JButton("Help");
		help.setBackground(Color.yellow);
		help.addActionListener(new OutputFormHelp(e));
		help.setBounds(30,280,200,60);
		help.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				i=new Panel();
				i.setLayout(null);
				help.setBackground(Color.green);
				Font font1=new Font("Arial",Font.BOLD,20);
				i.setBounds(300,100,438,328);
				String log_help="\t\t\tHELP\n\n This is help menu that show th all the help of output form. It show each item with each reports. ";
				JTextPane jtp=new JTextPane();
				jtp.setText(log_help);
				jtp.setBackground(Color.red);
				jtp.setForeground(Color.white);
				jtp.setBounds(0,0,438,328);
				jtp.setFont(font);
				i.add(jtp);
				
				add(i);
				show();
			}
			public  void mouseExited(MouseEvent e)
			{
			help.setBackground(Color.yellow);
			remove(i);
			}
		});
		add(help);
		exit = new JButton("Exit");
		exit.setBackground(Color.yellow);
		exit.addActionListener(new OutputExit(e));
		exit.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				i=new Panel();
				exit.setBackground(Color.green);
				i.setLayout(null);
				Font font1=new Font("Arial",Font.BOLD,20);
				i.setBounds(300,100,438,328);
				String log_help="\t\t\tEXIT\n\nThis is exit button alter it click,the showing page will terminate or exit";
				JTextPane jtp=new JTextPane();
				jtp.setText(log_help);
				jtp.setBackground(Color.black);
				jtp.setForeground(Color.white);
				jtp.setBounds(0,0,438,328);
				jtp.setFont(font);
				i.add(jtp);
				add(i);
				show();
			}
			public  void mouseExited(MouseEvent e)
			{
			exit.setBackground(Color.yellow);
			remove(i);
			}
		});
		exit.setBounds(30,340,200,60);
		add(exit);
	}
  }
  class Setting extends JPanel
  {	
  	JLabel pic;
  	JButton stu_form,help,exit,top,dis;
  	EMSMain e;
	public Setting(EMSMain e)
	{
		this.e=e;
		setLayout(null);
		ImageIcon ii=new ImageIcon("123.jpg");
	    pic =new JLabel(ii);
		pic.setBounds(255,47,528,429);	
		add(pic);
		setBackground(Color.red);
		Color c=new Color(170,180,70);
		setBackground(c);
		dis = new JButton("Over All Description");
		dis.setBackground(Color.yellow);
		dis.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				i=new Panel();
				i.setLayout(null);
				dis.setBackground(Color.blue);
				dis.setForeground(Color.white);
				Font font1=new Font("Arial",Font.BOLD,20);
				i.setBounds(300,100,438,328);
				String log_help="\t\tOVER ALL DESCRIPTION \n\n This show the how many student appear in examination and how many  student fillup the examination etc..."; 
				JTextPane jtp=new JTextPane();
				jtp.setText(log_help);
				jtp.setBackground(Color.blue);
				jtp.setForeground(Color.white);
				jtp.setBounds(0,0,438,328);
				jtp.setFont(font);
				i.add(jtp);				
				add(i);
				show();
			}
			public  void mouseExited(MouseEvent e)
			{
			remove(i);
			dis.setForeground(Color.black);
			dis.setBackground(Color.yellow);
			}
		});
		dis.addActionListener(new OverAll(e));
		dis.setBounds(30,100,200,60);
		add(dis);
		
		
		top = new JButton("Topper");
		top.addActionListener(new SearchTopper(e));
		top.setBackground(Color.yellow);
		top.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				i=new Panel();
				i.setLayout(null);
				top.setBackground(Color.blue);
				top.setForeground(Color.white);
				Font font1=new Font("Arial",Font.BOLD,20);
				i.setBounds(300,100,438,328);
				String log_help="\tTAPPER STUDENT SEARCH WINDOW \n\nThis button provide to couse code wise which student get maximum marks of among of all ,as a topper of that subject. ";
				JTextPane jtp=new JTextPane();
				jtp.setText(log_help);
				jtp.setBackground(Color.blue);
				jtp.setForeground(Color.white);
				jtp.setBounds(0,0,438,328);
				jtp.setFont(font);
				i.add(jtp);				
				add(i);
				show();
			}
			public  void mouseExited(MouseEvent e)
			{
			remove(i);
			top.setForeground(Color.black);
			top.setBackground(Color.yellow);
			}
		});
		top.setBounds(30,160,200,60);
		add(top);
		
			
		stu_form = new JButton("Change Passward");
		stu_form.setBackground(Color.yellow);
		stu_form.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				i=new Panel();
				i.setLayout(null);
				stu_form.setBackground(Color.blue);
				stu_form.setForeground(Color.white);
				Font font1=new Font("Arial",Font.BOLD,20);
				i.setBounds(300,100,438,328);
				String log_help="\tCHANGE NAME AND PASSWORD\n\n This is the page that take the old  user and passwod and it matches from the database  .if it machages then New password will be valid. " ;
				JTextPane jtp=new JTextPane();
				jtp.setText(log_help);
				jtp.setBackground(Color.blue);
				jtp.setForeground(Color.white);
				jtp.setBounds(0,0,438,328);
				jtp.setFont(font);
				i.add(jtp);				
				add(i);
				show();
			}
			public  void mouseExited(MouseEvent e)
			{
			remove(i);
			stu_form.setForeground(Color.black);
			stu_form.setBackground(Color.yellow);
			}
		});
		stu_form.addActionListener(new Change_Passward(e));
		stu_form.setBounds(30,220,200,60);
		add(stu_form);
		help = new JButton("Help");
		help.setBackground(Color.yellow);
		help.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				i=new Panel();
				i.setLayout(null);
				help.setBackground(Color.blue);
				help.setForeground(Color.white);
				Font font1=new Font("Arial",Font.BOLD,20);
				i.setBounds(300,100,438,328);
				String log_help="\t\t\tHELP\n\n This show the brief help of each menu ,so that any easly handle this program";
				JTextPane jtp=new JTextPane();
				jtp.setText(log_help);
				jtp.setBackground(Color.green);
				jtp.setForeground(Color.red);
				jtp.setBounds(0,0,438,328);
				jtp.setFont(font);
				i.add(jtp);				
				add(i);
				show();
			}
			public  void mouseExited(MouseEvent e)
			{
			remove(i);
			help.setForeground(Color.black);
			help.setBackground(Color.yellow);
			}
		});
		help.addActionListener(new SettingFormHelp(e));
		help.setBounds(30,280,200,60);
		add(help);
		exit = new JButton("Exit");
		exit.addActionListener(new SettingExit(e));
		exit.setBackground(Color.yellow);
		exit.setBounds(30,340,200,60);
		exit.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				i=new Panel();
				i.setLayout(null);
				exit.setBackground(Color.blue);
				exit.setForeground(Color.white);
				Font font1=new Font("Arial",Font.BOLD,20);
				i.setBounds(300,100,438,328);
				String log_help="\t\t\tEXIT\n\nthis is exit menu ,after click this button the window will be closed";
				JTextPane jtp=new JTextPane();
				jtp.setText(log_help);
				jtp.setBackground(Color.black);
				jtp.setForeground(Color.white);
				jtp.setBounds(0,0,438,328);
				jtp.setFont(font);
				i.add(jtp);
				add(i);
				show();
			}
			public  void mouseExited(MouseEvent e)
			{
			remove(i);
			exit.setBackground(Color.yellow);
			exit.setForeground(Color.black);
			}
		});

		add(exit);
	}
	
	}  
}//emshead closing 

    class SearchTopper implements ActionListener,ItemListener
    {
	JDialog d;
	EMSMain e;
	Choice pro,eno;
	public  SearchTopper(EMSMain e)
	{
		this.e=e;
	}
	Font f3=new Font("Arial Blank",Font.BOLD,12);
	public void actionPerformed(ActionEvent ae)
	{
	d=new JDialog(e,"Topper ",true);
	d.setLayout(null);
	d.setBounds(340,100,500,275);
	JLabel headline=new JLabel("Search Coursewise Topper Student",JLabel.CENTER);
	Font f2=new Font("Castellar",Font.BOLD,18 );
	headline.setFont(f2);
	headline.setBackground(Color.red);
	headline.setBounds(0,10,500,40);
	d.add(headline);
	JLabel pro_lab=new JLabel("Select Program Code");
	JLabel eno_lab=new JLabel("Select Course code");
	pro_lab.setBounds(30,60,200,40);
	eno_lab.setBounds(30,100,200,40);
	d.add(pro_lab);
	d.add(eno_lab);
	pro=new Choice();
	eno=new Choice();
	pro.addItemListener(this);
	pro.setFont(f3);
	eno.setFont(f3);
	pro.setBounds(300,65,150,40);
	eno.setBounds(300,105,150,25);
	pro.addItem("BCA");
	pro.addItem("MCA");
	pro.addItem("CIT");
	d.add(pro);
	d.add(eno);
	JLabel jl=new JLabel("Select Program code and select course code then click submit button...");
	jl.setBounds(30,135,400,25);
	d.add(jl);
	JButton	ok=new JButton("Submit");
	ok.addActionListener(new verifytopper());
	JButton bb2=new JButton("Cancel");
	bb2.addActionListener(new can_work());                                                                                                                             
	ok.setBounds(90,175,150,28);
	bb2.setBounds(290,175,150,28);
	d.add(ok);
	d.add(bb2);
	d.setVisible(true);
	}
	public void itemStateChanged(ItemEvent ie)
	{
		String  set=pro.getSelectedItem();
		if(set.equals("BCA"))
		{
			String co_name[]={"CS-610","FHS-01","CS-611","CS-612","CS-60","CS-62","FST-01","CS-05","CS-66","CS-06","CS-64","CS-65","CS-66","CS-67","CS-68","BCS-061","CS-70","CS-71","CS-72","CS-73","CS-74","CS-75","CS-76"};
			eno.removeAll();
			for(int j=0;j<co_name.length;j++)
			{
				eno.addItem(co_name[j]);
			}
		}
		else if(set.equals("MCA"))
		{
			String co_name[]={"MCS 011","MCS 012","MCS 013","MCS 014","MCS 015","MCS 016","MCSL 017","MCS 021","MCS 022","MCS 023","MCS 024","MCSL 025","MCS 031","MCS 032","MCS 033","MCS 034","MCS 035","MCSL 036","MCS 041","MCS 042","MCS 043","MCS 044","MCSL 045","MCS 051","MCS 052","MCS 053","MCSL 054","MCSE 003","MCSE 004","MCSE 005","MCSP 060"};
			eno.removeAll();
			for(int j=0;j<co_name.length;j++)
			{
				eno.addItem(co_name[j]);
			}

		}
		else if(set.equals("CIT"))
		{
		eno.removeAll();
		eno.addItem("cs 01");
		eno.addItem("cs 02");
		eno.addItem("cs 04");
		eno.addItem("cs 05");
		}		
	}
	
	class verifytopper implements ActionListener
	{
		String pr_de,eno_roll,pname,ppass;
		public void actionPerformed(ActionEvent ae)
		{
			try{
				Connection	con =  MySQLConnection.getConnection();
  				try{
  				    pr_de=pro.getSelectedItem();
  					eno_roll=eno.getSelectedItem();
  				    Statement st = con.createStatement();
   				    ResultSet res = st.executeQuery("select * from form where ENO="+"'"+eno_roll+"'"+"&&"+"pro_code="+"'"+pr_de+"'");
  					while (res.next()) 				//"SELECT ENO FROM answer(SELECT course FROM answer where pro_code="+"'"+pr_de+"'"+"&&"+"course="+"'"+eno_roll+"'"+"ORDER BY  DESC)";
  					{
  					pname = res.getString("eno");
					ppass = res.getString("pro_code");
	  		   		}			
				    if(pr_de.equals(pname) && eno_roll.equals(ppass))
				    {
				//    getMarkSheet ght=new getMarkSheet();
				  //  ght.get_MarkSheet();
				    d.dispose();
				    }
					else
					{
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(null,"Entroment number not found","Error!", JOptionPane.ERROR_MESSAGE);
				   }}
				catch (SQLException s)
  				{
				JOptionPane.showMessageDialog(null,"Query  error ","Error !",JOptionPane.ERROR_MESSAGE); 	
  				}  
  		 	}
			catch (Exception e){
  			JOptionPane.showMessageDialog(null,"Database connection error ","Error !",JOptionPane.ERROR_MESSAGE); 	
  			}
		}}	
	

    class can_work implements ActionListener
	{
		public void actionPerformed(ActionEvent ea)
		{
			d.setVisible(false);
			d.dispose();
		}
	}	
}	

 class student_form implements ActionListener,ItemListener
  {
	JDialog d;
	EMSMain e;
	JButton ok;
	Choice t4,t5,t6,tt1,tt2,tt3,tt4,tt5,tt6,tt7,tt8,tt9,tt10,tt11,tt12,tt13,tt14,tt15;
	JTextField t1,t2,t3,t7,t8,t9;
//	Choice coursefield[],coursefield2[],coursefield3[];
	JTextField textfield[]=new JTextField[9];
	Font f3 = new Font("Arial",Font.BOLD,16);
	Font ff = new Font("Arial",Font.BOLD,13);	
	public student_form(EMSMain e)
	{
	this.e=e;
	}	
	public void actionPerformed(ActionEvent ae)
	{
	d=new JDialog(e,"student form",true);
	d.setLayout(null);
	d.setBounds(340,77,550,563);
	JLabel headline=new JLabel("Examination Form Entry",JLabel.	CENTER);
	Font f2=new Font("Castellar",Font.BOLD,20);
	headline.setFont(f2);
	headline.setBackground(Color.red);
	headline.setBounds(0,10,600,50);
	d.add(headline);
	ok=new JButton("Ok");
	ok.addActionListener(new savestudentform());
	JButton bb2=new JButton("Cancel");
	bb2.addActionListener(new can_work());                                                                                                                             
	ok.setBounds(116,453,150,30);
	bb2.setBounds(330,453,150,30);
	d.add(ok);
	d.add(bb2);
	JLabel course= new JLabel("Course Code :");
	Font cfont=new Font("Arial",Font.BOLD,20);
	course.setBounds(40,290,300,30);
	d.add(course);	
	String name[] ={"Name","Enrollment no.","Address","Program code","Study Cantre Code","Exam. Centre Code","DD number","DD Amount","DD Issing Bank"};
	JLabel label[]=new JLabel[9];
	int y=60;
		for(int i=0;i<9;i++,y+=25)
		{
			label[i]=new JLabel(name[i]);
			label[i].setBounds(25,y,180,25);
			label[i].setFont(f3);
			d.add(label[i]);
		}
		int yy=60;
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		t4=new Choice();
		t5=new Choice();
		t6=new Choice();
		t7=new JTextField();
		t8=new JTextField();
		t9=new JTextField();
		
		JTextField add[] ={t1,t2,t3};
		for(int i=0;i<3;i++,yy+=25)
		{
			//textfield[i]=new JTextField();		
			add[i].setBounds(250,yy,270,25);
			add[i].setFont(ff);
			d.add(add[i]);
		}
		int yy1=135;
		Choice add1[]={t4,t5,t6};
		t4.addItem("");
		t4.addItem("BCA");
		t4.addItem("MCA");
		t4.addItem("CIT");
		t4.addItemListener(this);
		t5.addItem("");
		t5.addItem("0548P");
		t5.addItem("0546P");
		t5.addItem("0548P");
		t6.addItem("");
		t6.addItem("0504");
		t6.addItem("0505");
		t6.addItem("0506");
		for(int i=0;i<3;i++,yy1+=25)
		{
			//textfield[i]=new JTextField();		
			add1[i].setBounds(250,yy1,270,25);
			add1[i].setFont(ff);
			d.add(add1[i]);
		}
		int yy2=210;
		JTextField add2[]={t7,t8,t9};
		for(int i=0;i<3;i++,yy2+=25)
		{
			//textfield[i]=new JTextField();		
			add2[i].setBounds(250,yy2,270,25);
			add2[i].setFont(ff);
			d.add(add2[i]);
		}
		
		String name2[] ={"1.","2.","3.","4.","5."};
		int ly=320;
		JLabel label2[]=new JLabel[5];
		for(int i=0;i<5;i++,ly+=25)
		{
			label2[i]=new JLabel(name2[i]);
			label2[i].setBounds(25,ly,20,25);
			label2[i].setFont(f3);
			d.add(label2[i]);
		}
		int yyy=320;
		tt1=new Choice();
		tt2=new Choice();
		tt3=new Choice();
		tt4=new Choice();
		tt5=new Choice();
		tt6=new Choice();
		tt7=new Choice();
		tt8=new Choice();
		tt9=new Choice();
		tt10=new Choice();
		tt11=new Choice();
		tt12=new Choice();
		tt13=new Choice();
		tt14=new Choice();
		tt15=new Choice();
		
		Choice coursefield[]={tt1,tt2,tt3,tt4,tt5};
		for(int i=0;i<5;i++,yyy+=25)
		{		
			coursefield[i].setBounds(45,yyy,120,22);
			coursefield[i].setFont(ff);
			d.add(coursefield[i]);
		}
		String name3[] ={"6.","7.","8.","9.","10."};
		int lyy=320;
		JLabel label3[]=new JLabel[5];
		for(int i=0;i<5;i++,lyy+=25)
		{
			label3[i]=new JLabel(name3[i]);
			label3[i].setBounds(202,lyy,30,25);
			label3[i].setFont(ff);
			d.add(label3[i]);
		}
		int yyyy=320;
		Choice coursefield2[]={tt6,tt7,tt8,tt9,tt10};
		for(int i=0;i<5;i++,yyyy+=25)
		{		
			coursefield2[i].setBounds(225,yyyy,120,22);
			coursefield2[i].setFont(ff);
			d.add(coursefield2[i]);
		}
		String name4[] ={"11.","12.","13.","14.","15."};
		int lyyy=320;
		JLabel label5[]=new JLabel[5];
		for(int i=0;i<5;i++,lyyy+=25)
		{
			label5[i]=new JLabel(name4[i]);
			label5[i].setBounds(375,lyyy,30,25);
			label5[i].setFont(ff);
			d.add(label5[i]);
		}
		int yyyyy=320;
		Choice coursefield3[]={tt11,tt12,tt13,tt14,tt15};
		for(int i=0;i<5;i++,yyyyy+=25)
		{
			coursefield3[i].setBounds(408,yyyyy,120,22);
			coursefield3[i].setFont(ff);
			d.add(coursefield3[i]);
		}
		d.setResizable(false);
		d.setVisible(true);
	  }	
	public void itemStateChanged(ItemEvent  ie)
	{
		Choice co[]={tt1,tt2,tt3,tt4,tt5,tt6,tt7,tt8,tt9,tt10,tt11,tt12,tt13,tt14,tt15};
		String  set=t4.getSelectedItem();
		if(set.equals(""))
		{
			for(int i=0;i<15;i++)
			{	co[i].removeAll();}
		}
		else if(set.equals("BCA"))
		{
			String co_name[]={"","CS-610","FHS-01","CS-611","CS-612","CS-60","CS-62","FST-01","CS-05","CS-66","CS-06","CS-64","CS-65","CS-66","CS-67","CS-68","BCS-061","CS-70","CS-71","CS-72","CS-73","CS-74","CS-75","CS-76"};
			for(int i=0;i<15;i++)
			{	co[i].removeAll();
				for(int j=0;j<co_name.length;j++)
				{
				co[i].addItem(co_name[j]);
				}
			}
		}
		else if(set.equals("MCA"))
		{
			String co_name[]={"","MCS 011","MCS 012","MCS 013","MCS 014","MCS 015","MCS 016","MCSL 017","MCS 021","MCS 022","MCS 023","MCS 024","MCSL 025","MCS 031","MCS 032","MCS 033","MCS 034","MCS 035","MCSL 036","MCS 041","MCS 042","MCS 043","MCS 044","MCSL 045","MCS 051","MCS 052","MCS 053","MCSL 054","MCSE 003","MCSE 004","MCSE 005","MCSP 060"};
			for(int i=0;i<15;i++)
			{	co[i].removeAll();
				for(int j=0;j<co_name.length;j++)
				{
				co[i].addItem(co_name[j]);
				}
			}
			
			
		}
		else if(set.equals("CIT"))
		{
			String co_name[]={"","CS-01","CS-02","CS-03","CS-04"};
			for(int i=0;i<15;i++)
			{	co[i].removeAll();
			}
				for(int i=0;i<4;i++)
				{
				for(int j=0;j<co_name.length;j++)
				{
				co[i].addItem(co_name[j]);
				}
				}
		}		
	}


	class savestudentform implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
		 if(!((t1.getText()=="")&&(t2.getText()=="")&&(t3.getText()=="")&&(t7.getText()=="")&&(t8.getText()=="")&&(t9.getText()=="")))	
		 {
		    	Connection con = null;
 			
 			try{

	 			con =  MySQLConnection.getConnection();
 	 			try{
  					Statement st = con.createStatement();
				   // String table =  "CREATE TABLE date_time(p_code varchar(10),course varchar(10)primary key,year varchar(4),month varchar(15),date varchar(2),session varchar(10))";
				   // st.executeUpdate(table);
				   // JOptionPane.showMessageDialog(null,"Table Creation sussesfull ","Table Creation !",JOptionPane.PLAIN_MESSAGE);
  					//	String ins="INSERT INTO time VALUES(" + pc + "," + cc + "," + yy + "," + mm + "," + dd + ")";
   						 String sql[]= new String[15];
   						 Choice sub[]={tt1,tt2,tt3,tt4,tt5,tt6,tt7,tt8,tt9,tt10,tt11,tt12,tt13,tt14,tt15};
   						 for(int i=0;i<15;i++)
   						 {
   						 sql[i]="INSERT INTO form VALUES('"+t1.getText()+"'";
	    	    		 sql[i]+=",'"+t2.getText()+"'";
	    	    		 sql[i]+=",'"+t3.getText()+"'";
	    	    		 sql[i]+=",'"+t4.getSelectedItem()+"'";
	    	    		 sql[i]+=",'"+t5.getSelectedItem()+"'";
	    	    		 sql[i]+=",'"+t6.getSelectedItem()+"'";
	    	    		 sql[i]+=",'"+t7.getText()+"'";
	    	    		 sql[i]+=",'"+t8.getText()+"'";	 	    	    		 
	    	    		 sql[i]+=",'"+t9.getText()+"'";
	    	    		 sql[i]+=",'"+sub[i].getSelectedItem()+"')";
	    	    		 st.executeUpdate(sql[i]);
	    	    		 System.out.println(sql[i]);
	    	    		 }
	    	    		
   					JOptionPane.showMessageDialog(null,"Do you want to continue\nto store these information... ","Store !",JOptionPane.PLAIN_MESSAGE);  	    		  

					JOptionPane.showMessageDialog(null,"All these information successfully stored ","Stored !",JOptionPane.PLAIN_MESSAGE);   	    			
   			  				 t1.setText("");
	    	    		 	 t2.setText("");
	    	    		 	 t3.setText("");
	    	    		 	 t4.select(0);
	    	    		 	 t5.select(0);
	    	    		 	 t6.select(0);
	    	    		 	 t7.setText("");
	    	    		 	 t8.setText("");
	    	    		 	 t9.setText("");
	 	   	    		 	Choice co[]={tt1,tt2,tt3,tt4,tt5,tt6,tt7,tt8,tt9,tt10,tt11,tt12,tt13,tt14,tt15};
	 	   	    		 	for(int i=0;i<15;i++)
							{	co[i].removeAll();
							}
			
	    					 	 
	    	 }
		  			catch(SQLException s)
		  			{
  					JOptionPane.showMessageDialog(null,"This information can not save,\nDublication not allowed","Error !",JOptionPane.ERROR_MESSAGE); 
  					JOptionPane.showMessageDialog(null,s.toString());
  					}
  					con.close();
  					}
  				catch (Exception e){
  				JOptionPane.showMessageDialog(null,"Connection error... ","Error !",JOptionPane.ERROR_MESSAGE); 
  				JOptionPane.showMessageDialog(null,e.toString());
  				e.printStackTrace();
  				}	 		 
		   	 
		   	 }
		   	 else
		   	 JOptionPane.showMessageDialog(null,"Please fill up the full information.\nFill  Couse code must at least one ","Error !",JOptionPane.ERROR_MESSAGE); 
		   }
		 
		} 
		   	 	 
		   	 	 
    	  
	class can_work implements ActionListener
	{
		public void actionPerformed(ActionEvent ea)
		{
			d.setVisible(false);
			d.dispose();
		}
	}
 }
  
  class date_time implements ActionListener,ItemListener
  {
	JDialog d;
	Checkbox evening,morning;
	CheckboxGroup cg=new CheckboxGroup();
	Choice  jpro_code,jc_code,year,month,date;
	EMSMain e;
	Font f5=new Font("Arial Blank",Font.BOLD,14);
	public date_time(EMSMain e)
	{
		this.e=e;
	}
	public void actionPerformed(ActionEvent ae)
	{
		d=new JDialog(e,"Date and Time Entry",true);
		d.setBounds(340,77,550,563);
		d.setLayout(null);
		d.setResizable(false);
		JLabel headline=new JLabel("Date and Time Entry",JLabel.CENTER);
		headline.setBounds(10,20,540,40);
		Font f1 =new Font("Arial",Font.BOLD,25);
		headline.setFont(f1);
		d.add(headline);
		JLabel pro_code=new JLabel("Program Code");
		pro_code.setBounds(70,80,150,70);
		pro_code.setFont(f5);
		d.add(pro_code);
	    jpro_code=new Choice();
		jpro_code.setBounds(260,103,210,35);
		jpro_code.addItem("BCA");
		jpro_code.addItem("MCA");
		jpro_code.addItem("CIT");
		jpro_code.setFont(f5);
		jpro_code.addItemListener(new programselection());
		d.add(jpro_code);
		JLabel c_code=new JLabel("Course Code");
		c_code.setBounds(70,163,150,70);
		c_code.setFont(f5);
		d.add(c_code);
		jc_code=new Choice();
		jc_code.setBounds(260,175,210,35);
		jc_code.setFont(f5);
		jc_code.addItem("");;
		
		String co_name[]={"MCS 011","MCS 012","MCS 013","MCS 014","MCS 015","MCS 016","MCSL 017","MCS 021","MCS 022","MCS 023","MCS 024","MCSL 025","MCS 031","MCS 032","MCS 033","MCS 034","MCS 035","MCSL 036","MCS 041","MCS 042","MCS 043","MCS 044","MCSL 045","MCS 051","MCS 052","MCS 053","MCSL 054","MCSE 003","MCSE 004","MCSE 005","MCSP 060"};
		for(int j=0;j<co_name.length;j++)
		{
			jc_code.addItem(co_name[j]);
		}
		
		d.add(jc_code);
		JLabel d_code=new JLabel("Date of Exam");
		d_code.setBounds(70,280,115,30);
		d_code.setFont(f5);
		d.add(d_code);
		year=new Choice();
		year.setBounds(180,280,90,30);
		String mon1[]={"2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030","2031","2032","2033","2034","2035","2036","2037","2038","2039","2040","2041","2042","2043","2044","2045","2046","2047","2048","2049","2050"};
		for(int i=0;i<mon1.length;i++)
		{
			year.addItem(mon1[i]);
		}
		year.setFont(f5);
		d.add(year);
		JLabel  yy = new JLabel("Year",JLabel.CENTER);
		yy.setBounds(180,260,90,15);
		JLabel mm=new JLabel("Month",JLabel.CENTER);
		mm.setBounds(280,260,90,15);
		JLabel dd=new JLabel("Date",JLabel.CENTER);
		dd.setBounds(380,260,90,15);
		d.add(yy);
		d.add(mm);
		d.add(dd);
		month=new Choice();
		month.setBounds(280,280,90,30);
		String mon[]={"January","Febuary","March","April","May","June","July","August","September","October","November","December"};
		for(int i=0;i<12;i++)
		{
			month.addItem(mon[i]);
		}
		month.setFont(f5);
		month.addItemListener(this);
		d.add(month);
		date=new Choice();
		date.setBounds(380,280,90,30);
		date.setFont(f5);
		d.add(date);
		JLabel session=new JLabel("Session :-");
		session.setBounds(70,330,150,70);
		Font f6 =new Font("Arial Blank",Font.BOLD,18);
		session.setFont(f6);
		d.add(session);
		Font f7 =new Font("Arial Blank",Font.BOLD,16);
		morning =new Checkbox("Morning",cg,true);
		morning.setBounds(200,350,100,30);
		morning.setFont(f7);
	//	morning.addItemListener(this);
		d.add(morning);
		evening =new Checkbox("Evening",cg,false);
		evening.setBounds(378,350,100,30);
	//	evening.addItemListener(this);
		evening.setFont(f7);
		d.add(evening);
		JButton okok=new JButton("Ok");
		okok.setBounds(100,420,150,30);
		okok.addActionListener(new savedate());
		okok.setFont(f7);
		d.add(okok);
		JButton can=new JButton("Cancel");
		can.setBounds(300,420,150,30);
		can.addActionListener(new can_work());
		can.setFont(f7);
		d.add(can);
		d.setVisible(true);		
	}
	public void itemStateChanged(ItemEvent  ie)
	{
		String mm=month.getSelectedItem();
		if(mm.equals("January"))
		{ 
			date.removeAll();
			for(int i=1;i<=31;i++)
			{	
				date.addItem(String.valueOf(i));
			}
		}
		else if(mm=="Febuary")
		{ 
			date.removeAll();
			String yy=(String)year.getSelectedItem();
			int y=Integer.valueOf(yy).intValue();
			if(y%4==0)
			{
			for(int i=1;i<=29;i++)
			{	
				date.addItem(String.valueOf(i));
			}
			}
			else
			{
				for(int i=1;i<=28;i++)
				{	
				date.addItem(String.valueOf(i));
				}
			}
		}
		else if(mm=="March")
		{ 
			date.removeAll();
			for(int i=1;i<=31;i++)
			{	
				date.addItem(String.valueOf(i));
			}
		}
		else if(mm=="April")
		{ 
			date.removeAll();
			for(int i=1;i<=30;i++)
			{	
				date.addItem(String.valueOf(i));
			}
		}
		else if(mm=="May")
		{ 
			date.removeAll();
			for(int i=1;i<=31;i++)
			{	
				date.addItem(String.valueOf(i));
			}
		}
		else if(mm=="June")
		{ 
			date.removeAll();
			for(int i=1;i<=30;i++)
			{	
				date.addItem(String.valueOf(i));
			}
		}
		else if(mm=="July")
		{ 
			date.removeAll();
			for(int i=1;i<=31;i++)
			{	
				date.addItem(String.valueOf(i));
			}
		}
		else if(mm=="August")
		{ 
			date.removeAll();
			for(int i=1;i<=31;i++)
			{	
				date.addItem(String.valueOf(i));
			}
		}
		else if(mm=="September")
		{ 
			date.removeAll();
			for(int i=1;i<=30;i++)
			{	
				date.addItem(String.valueOf(i));
			}
		}
		else if(mm=="October")
		{ 
			date.removeAll();
			for(int i=1;i<=31;i++)
			{	
				date.addItem(String.valueOf(i));
			}
		}
		else if(mm=="November")
		{ 
			date.removeAll();
			for(int i=1;i<=30;i++)
			{	
				date.addItem(String.valueOf(i));
			}
		}
		else if(mm=="December")
		{ 
			date.removeAll();
			for(int i=1;i<=31;i++)
			{	
				date.addItem(String.valueOf(i));
			}
		}
	}

class programselection implements ItemListener
{
	public void itemStateChanged(ItemEvent  ie)
	{
		
		String  set=jpro_code.getSelectedItem();
		if(set.equals("BCA"))
		{
			String co_name[]={"CS-610","FHS-01","CS-611","CS-612","CS-60","CS-62","FST-01","CS-05","CS-66","CS-06","CS-64","CS-65","CS-66","CS-67","CS-68","BCS-061","CS-70","CS-71","CS-72","CS-73","CS-74","CS-75","CS-76"};
			jc_code.removeAll();
			for(int j=0;j<co_name.length;j++)
			{
				jc_code.addItem(co_name[j]);
			}
		}
		else if(set.equals("MCA"))
		{
			String co_name[]={"MCS 011","MCS 012","MCS 013","MCS 014","MCS 015","MCS 016","MCSL 017","MCS 021","MCS 022","MCS 023","MCS 024","MCSL 025","MCS 031","MCS 032","MCS 033","MCS 034","MCS 035","MCSL 036","MCS 041","MCS 042","MCS 043","MCS 044","MCSL 045","MCS 051","MCS 052","MCS 053","MCSL 054","MCSE 003","MCSE 004","MCSE 005","MCSP 060"};
			jc_code.removeAll();
			for(int j=0;j<co_name.length;j++)
			{
				jc_code.addItem(co_name[j]);
			}

		}
		else if(set.equals("CIT"))
		{
		jc_code.removeAll();
		jc_code.addItem("cs 01");
		jc_code.addItem("cs 02");
		jc_code.addItem("cs 04");
		jc_code.addItem("cs 05");
		}		
	}
}
	class savedate implements ActionListener,ItemListener
	{
	 	public void actionPerformed(ActionEvent ae)
	 	{
	 		String pc=(String)jpro_code.getSelectedItem();
	 		String cc=(String)jc_code.getSelectedItem();
	 		String yy=(String)year.getSelectedItem();
	 		String mm=(String)month.getSelectedItem();
	 		String dd=(String)date.getSelectedItem();
	 		Boolean morn =morning.getState();
	 		Boolean even= evening.getState();
	 		Checkbox cb= cg.getSelectedCheckbox();
	 		String time="";
	 		if(morn==true)
	 		time+="Morning";
	 		else
	 		time+="Evening";
 			try{
 				Connection	con =  MySQLConnection.getConnection();
 	 			try{
  					Statement st = con.createStatement();
  					String dd1=date.getSelectedItem();
  					String mm1=month.getSelectedItem();
  					String yy1=year.getSelectedItem();
  					String date=dd1+"-"+mm1+"-"+yy1;
   					String sql="INSERT INTO date VALUES('"+jpro_code.getSelectedItem()+"'";
	    	    	sql+=",'"+jc_code.getSelectedItem()+"'";
					sql+=",'"+date+"'";    	 
	    	    	sql+=",'"+time+"')"; 
	    	    	JOptionPane.showMessageDialog(null,"Do you want to continue\nto store these information... ","Store !",JOptionPane.PLAIN_MESSAGE);  	    		  
   	    			st.executeUpdate(sql);
					JOptionPane.showMessageDialog(null,"All these information successfully stored ","Stored !",JOptionPane.PLAIN_MESSAGE);   	    			
   			  		}
  		catch(SQLException s){
  		JOptionPane.showMessageDialog(null,"This information can not save,\nDublication not allowed ... "+s.getMessage(),"Error !",JOptionPane.ERROR_MESSAGE); 
  		}
  	
  	}
  catch (Exception e){
  JOptionPane.showMessageDialog(null,"Connection error... ","Error !",JOptionPane.ERROR_MESSAGE); 
  e.printStackTrace();
  }	 		
}
	 public void itemStateChanged(ItemEvent  ie){}
	 }
     	class can_work implements ActionListener
		{
		public void actionPerformed(ActionEvent ea)
		{
			d.setVisible(false);
			d.dispose();
		}
		}
}

 class Answer_sheet implements ActionListener,ItemListener ,TextListener 
  {
	JDialog d;
	EMSMain e;
	Choice pro,pro_no;
	Choice c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12,m13,m14,m15,k1,k2,k3,k4,k5,k6,k7,k8,k9,k10,k11,k12,k13,k14,k15;
	TextField t1,t2;
	public Answer_sheet(EMSMain e)
	{
		this.e=e;
	}
	Font f3=new Font("Arial Blank",Font.BOLD,14);
	public void actionPerformed(ActionEvent ae)
	{
	d=new JDialog(e,"Answer sheet entry",true);
	d.setLayout(null);
	d.setBounds(340,77,550,610);
	JLabel headline=new JLabel("Answer sheet entry",JLabel.CENTER);
	Font f2=new Font("Castellar",Font.BOLD,26);
	headline.setFont(f2);
	headline.setBackground(Color.red);
	headline.setBounds(0,10,550,35);
	d.add(headline);
	JButton	ok=new JButton("Ok");
	ok.addActionListener(new saveAnswersheet());
	JButton bb2=new JButton("Cancel");
	bb2.addActionListener(new can_work());                                                                                                                             
	ok.setBounds(100,529,150,28);
	bb2.setBounds(290,529,150,28);
	d.add(ok);
	d.add(bb2);
		String name[] ={"Name","Enrollment no.","No. of Courses","Program code"};
		JLabel label[]=new JLabel[4];
		int y=60;
		for(int i=0;i<4;i++,y+=30)
		{
			label[i]=new JLabel(name[i]);
			label[i].setBounds(40,y,160,25);
			label[i].setFont(f3);
			d.add(label[i]);
		}
		int yy=60;
		t1=new TextField();
		t2=new TextField();
		TextField textfield[]={t1,t2};
		try
		{
		for(int i=0;i<2;i++,yy+=30)
		{
			textfield[i].setBounds(250,yy,200,25);
			textfield[i].setColumns(10);
			textfield[i].addTextListener(this);
			textfield[i].setFont(f3);
			d.add(textfield[i]);
		}
		pro_no =new Choice();
		pro_no.setBounds(250,123,200,25);
		d.add(pro_no);
		for(int i=1;i<=15;i++)
		{
		pro_no.setFont(f3);
		pro_no.addItem(String.valueOf(i));
		}
		
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("its avobe input ");
		}
		JLabel course= new JLabel("Course Code",JLabel.CENTER);
		Font cfont=new Font("Arial",Font.BOLD,15);
		course.setBounds(40,185,150,30);
		course.setFont(f3);
		d.add(course);	
		JLabel max= new JLabel("Maximum Marks",JLabel.CENTER);
		max.setBounds(220,185,150,30);
		max.setFont(f3);
		d.add(max);	
		JLabel marks= new JLabel("Marks",JLabel.CENTER);
		marks.setBounds(350,185,150,30);
		marks.setFont(f3);
		d.add(marks);				
		pro=new Choice();
		pro.setBounds(250,150,200,25);
		pro.setFont(f3);
		pro.addItem("BCA");
		pro.addItem("MCA");
		pro.addItem("CIT");
		pro.addItemListener(this);
		d.add(pro);
		String name2[] ={"1.","2.","3.","4.","5.","6.","7.","8.","9.","10.","11.","12.","13.","14.","15.",""};
		int ly=220;
		JLabel label2[]=new JLabel[16];
		Font ff1=new Font("Arial Blank",Font.BOLD,14);
		for(int i=0;i<16;i++,ly+=20)
		{
			label2[i]=new JLabel(name2[i]);
			label2[i].setBounds(40,ly,30,20);
			label2[i].setFont(ff1);
			d.add(label2[i]);
		}
		c1=new Choice();
		c2=new Choice();
		c3=new Choice();
		c4=new Choice();
		c5=new Choice();
		c6=new Choice();
		c7=new Choice();
		c8=new Choice();
		c9=new Choice();
		c10=new Choice();
		c11=new Choice();
		c12=new Choice();
		c13=new Choice();
		c14=new Choice();
		c15=new Choice();
		int x=220;
		Choice jc_code[]={c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15};
		for(int i=0;i<15;i++,x+=20)
		{
			jc_code[i].setBounds(70,x,100,20);
			jc_code[i].setFont(f3);
			d.add(jc_code[i]);
		}
		m1=new Choice();
		m2=new Choice();
		m3=new Choice();
		m4=new Choice();
		m5=new Choice();
		m6=new Choice();
		m7=new Choice();
		m8=new Choice();
		m9=new Choice();
		m10=new Choice();
		m11=new Choice();
		m12=new Choice();
		m13=new Choice();
		m14=new Choice();
		m15=new Choice();
		int y1=220;
		Choice coursefield1[]={m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12,m13,m14,m15};
		for(int i=0;i<15;i++,y1+=20)
		{
			coursefield1[i].setBounds(230,y1,100,20);
			coursefield1[i].setFont(f3);
			//coursefield1[i].addItemListener(this);
			coursefield1[i].addItemListener(new maxwork());
			d.add(coursefield1[i]);
		}
		k1=new Choice();
		k2=new Choice();
		k3=new Choice();
		k4=new Choice();
		k5=new Choice();
		k6=new Choice();
		k7=new Choice();
		k8=new Choice();
		k9=new Choice();
		k10=new Choice();
		k11=new Choice();
		k12=new Choice();
		k13=new Choice();
		k14=new Choice();
		k15=new Choice();
		int yyby=220;
		Choice coursefield3[]={k1,k2,k3,k4,k5,k6,k7,k8,k9,k10,k11,k12,k13,k14,k15};
		for(int i=0;i<15;i++,yyby+=20)
		{		
			coursefield3[i].setBounds(375,yyby,100,20);
			coursefield3[i].setFont(f3);
			d.add(coursefield3[i]);	
		}
		d.setResizable(false);
		d.setVisible(true);
	}
	
			
	class maxwork implements ItemListener
	{
		public void itemStateChanged(ItemEvent  ie)
		{	
		    Choice jc_code[]={c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c13,c14,c15};
			Choice coursefield3[]={k1,k2,k3,k4,k5,k6,k7,k8,k9,k10,k11,k12,k13,k14,k15};
			Choice coursefield1[]={m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12,m13,m14,m15};
		    int n=pro_no.getSelectedIndex()+1;
			int mx[]=new int[n];
			for(int j=0;j<15;j++)
			{
				coursefield3[j].removeAll();
			}
			for(int i=0;i<n;i++)
			{
				mx[i]=coursefield1[i].getSelectedIndex();
				for(int l=0;l<=mx[i];l++)
				{
				coursefield3[i].addItem(String.valueOf(l));
				}
			}
		
		}
	}

	public void itemStateChanged(ItemEvent  ie)
	{
		
		Choice jc_code[]={c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c13,c14,c15};
		Choice coursefield3[]={k1,k2,k3,k4,k5,k6,k7,k8,k9,k10,k11,k12,k13,k14,k15};
		Choice coursefield1[]={m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12,m13,m14,m15};    
		String  set=pro.getSelectedItem();
		int n=pro_no.getSelectedIndex()+1;
		
		if(set.equals("BCA"))
		{
			String co_name[]={"CS-610","FHS-01","CS-611","CS-612","CS-60","CS-62","FST-01","CS-05","CS-66","CS-06","CS-64","CS-65","CS-66","CS-67","CS-68","BCS-061","CS-70","CS-71","CS-72","CS-73","CS-74","CS-75","CS-76"};
			for(int i=0;i<n;i++)
			{
				jc_code[i].removeAll();
				for(int j=0;j<co_name.length;j++)
				{
					jc_code[i].addItem(co_name[j]);
				}
			}
				
			for(int i=0;i<n;i++)
			{
				for(int k=0;k<=100;k++)
				{
				coursefield1[i].addItem(String.valueOf(k));
				}
			}
			
		}
		 else if(set.equals("MCA"))
		{
			String cor_name[]={"MCS 011","MCS 012","MCS 013","MCS 014","MCS 015","MCS 016","MCSL 017","MCS 021","MCS 022","MCS 023","MCS 024","MCSL 025","MCS 031","MCS 032","MCS 033","MCS 034","MCS 035","MCSL 036","MCS 041","MCS 042","MCS 043","MCS 044","MCSL 045","MCS 051","MCS 052","MCS 053","MCSL 054","MCSE 003","MCSE 004","MCSE 005","MCSP 060"};
			for(int i=0;i<n;i++)
			{
				jc_code[i].removeAll();
				for(int j=0;j<cor_name.length;j++)
				{
					jc_code[i].addItem(cor_name[j]);
				}
			}
				
			for(int i=0;i<n;i++)
			{
				for(int k=0;k<=100;k++)
				{
				coursefield1[i].addItem(String.valueOf(k));
				}
			}
		}	
			
	}
	public void textValueChanged(TextEvent e){}
	public void textChanged(TextEvent e)
	{
	 //String str= e.paramString();
	 String str1=t1.getText();
	 char a='a',z='z';
	 if(!str1.equals (a>=z))
	 JOptionPane.showMessageDialog(null,"wrong","Error!", JOptionPane.ERROR_MESSAGE);
	} 
	
	class saveAnswersheet implements ActionListener
	{
		String course[],max[],marks[];
		public void actionPerformed(ActionEvent ae)
		{
 		try{
 			Connection	con =  MySQLConnection.getConnection();
 				try{
  						
  					     String sql[]=new String[20];
						 Statement st = con.createStatement();
						 Choice course[]={c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c13,c14,c15};
						 Choice max[]={m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12,m13,m14,m15};    
   						 Choice marks[]={k1,k2,k3,k4,k5,k6,k7,k8,k9,k10,k11,k12,k13,k14,k15};
   						 JOptionPane.showMessageDialog(null,"Do you want to continue\nto store these information... ","Store !",JOptionPane.PLAIN_MESSAGE);  	    		  
   						 for(int i=0;i<15;i++)
   						 {
   						 sql[i]="INSERT INTO answer VALUES('"+t1.getText()+"'";
	    	    		 sql[i]+=",'"+t2.getText()+"'";
	    	    		 sql[i]+=",'"+pro.getSelectedItem()+"'";
	    	    		 sql[i]+=",'"+course[i].getSelectedItem()+"'";
	    	    		 sql[i]+=",'"+max[i].getSelectedItem()+"'";
	    	    		 sql[i]+=",'"+marks[i].getSelectedItem()+"')";	 	    	    		 
	    	    		 st.executeUpdate(sql[i]);
	    	    		 }
						 JOptionPane.showMessageDialog(null,"All these information successfully stored ","Stored !",JOptionPane.PLAIN_MESSAGE);   	    			
   			  				 t1.setText("");
	    	    		 	 t2.setText("");
	    	    		 	 pro.select(0);
	    	    		 	Choice co[]={c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12,m13,m14,m15,k1,k2,k3,k4,k5,k6,k7,k8,k9,k10,k11,k12,k13,k14,k15};
	 	   	    		 	for(int i=0;i<45;i++)
							{	co[i].removeAll();
							} 	    			 
 		 		 					}
  					catch(SQLException s){
  						s.printStackTrace();
  						//	 JOptionPane.showMessageDialog(null,"Qeuery problem ","ERROR !",JOptionPane.ERROR_MESSAGE);   	    			
  					}
  					con.close();
  					}
 		catch(Exception e){
 			 JOptionPane.showMessageDialog(null,"All these information successfully stored ","Stored !",JOptionPane.PLAIN_MESSAGE);   	
  			//JOptionPane.showMessageDialog(null,e.toString()); 
 			e.printStackTrace();
  			}
	}		
	}		
		
	
	class can_work implements ActionListener
	{
		public void actionPerformed(ActionEvent ea)
		{
			d.setVisible(false);
			d.dispose();
		}
	}
  }	
 
  class InputFormHelp implements ActionListener
  {
 	JDialog d;
 	EMSMain e;
 	public InputFormHelp(EMSMain e)
 	{
 		this.e=e;
 	}
	Font f3=new Font("Arial Blank",Font.BOLD,16);
	public void actionPerformed(ActionEvent ae)
	{
	d=new JDialog(e,"Input Help",true);
	d.setLayout(null);
	d.setResizable(false);
	d.setBounds(340,77,550,563);
	JLabel headline=new JLabel("Record Entry Help");
	Font f2=new Font("Castellar",Font.BOLD,26);
	headline.setFont(f2);
	headline.setBackground(Color.red);
	headline.setBounds(135,10,650,50);
	d.add(headline);
	JButton can=new JButton("Cancel");
	can.addActionListener(new can_work());                                                                                                                             
	can.setBounds(200,450,140,30);
	d.add(can);
	String msg1="\t\tHELP\n It provide student Examination all details entiry help"+
			"as like student examination form entry ,date and time of particular paper :-\n\n"+
			"Student examination form :-\n * Name :- only 30 chatecter and only alphbet \n Entrollment no:-only 9 digit number\nprogram code:-select from choice\nAddress:-only 50 charecter\nStudy Centre code:-select from choice\nExamination Cenre code:- Select from Choice \nDD no.:-only 6 digit number\nDD amount :-only less than 2000\n DD issue:-only 30 charecter and finally select \nCourse code:-Select course code from the list of course code..";
	TextArea jtp=new TextArea("Help\n\n",10,10,TextArea.SCROLLBARS_VERTICAL_ONLY);
	jtp.setText(msg1);
	Font f22=new Font("Arial Bold",Font.HANGING_BASELINE,18);
	jtp.setBounds(0,75,550,350);
	jtp.setFont(f22);
	jtp.setEditable(false);
	d.add(jtp);
	d.show();
	}
	class can_work implements ActionListener
	{
		public void actionPerformed(ActionEvent ea)
		{
			d.setVisible(false);
			d.dispose();
		}
	}
  }

 class inputexit implements ActionListener
	{
		EMSMain e;
		JDialog d;
		public inputexit(EMSMain e)
		{
			this.e=e;
		}
		public void actionPerformed(ActionEvent ae)
		{
			d=new JDialog(e,"Exit",true);
			d.setBounds(200,200,500,150);
			d.setLayout(null);
			d.setResizable(false);
			JLabel jl=new JLabel("Do you want to continue exit this Examination Management System",JLabel.CENTER);
			jl.setBounds(0,0,500,60);
			d.add(jl);
			JButton b=new JButton("Yes");
			b.setBounds(125,70,100,30);
			JButton can=new JButton("No");
			can.setBounds(275,70,100,30);
			can.addActionListener(new Action());
			b.addActionListener(new Action());
			d.add(b);
			d.add(can);
			d.setVisible(true);	
		}
		class Action implements ActionListener
		{
		public void  actionPerformed(ActionEvent ae)
		{
			String str=ae.getActionCommand();
			if(str.equals("Yes"))
			{
			e.dispose();
			System.exit(0);
			}
			else if(str.equals("No"))
			d.dispose(); 
		}
		}
	  }
  	    
  
  
    class SearchHallTickect implements ActionListener
    {
	JDialog d;
	EMSMain e;
	Choice pro;
	JTextField eno;
	String eno_roll,pr_de,pname,ppass;;
	public  SearchHallTickect(EMSMain e)
	{
		this.e=e;
	}
	Font f3=new Font("Arial Blank",Font.BOLD,16);
	public void actionPerformed(ActionEvent ae)
	{
	d=new JDialog(e,"Search HallTicket",true);
	d.setLayout(null);
	d.setBounds(340,100,500,275);
	JLabel headline=new JLabel("Search HallTicket sheet",JLabel.CENTER);
	Font f2=new Font("Castellar",Font.BOLD,22 );
	headline.setFont(f2);
	headline.setBackground(Color.red);
	headline.setBounds(0,10,500,40);
	d.add(headline);
	JLabel pro_lab=new JLabel("Select Program Code");
	JLabel eno_lab=new JLabel("Enter 9 digit Enrollment no.");
	pro_lab.setBounds(30,60,200,40);
	eno_lab.setBounds(30,100,200,40);
	d.add(pro_lab);
	d.add(eno_lab);
    pro=new Choice();
	eno=new JTextField();
	pro.setBounds(300,65,150,40);
	eno.setBounds(300,105,150,25);
	pro.addItem("BCA");
	pro.addItem("MCA");
	pro.addItem("CIT");
	d.add(pro);
	d.add(eno);
	JLabel jl=new JLabel("Select Program code and Enter nine digit Enrollment no...");
	jl.setBounds(30,135,400,25);
	d.add(jl);
	JButton	ok=new JButton("Submit");
	ok.addActionListener(new TestHallTicket());
	JButton bb2=new JButton("Cancel");
	bb2.addActionListener(new can_work());                                                                                                                             
	ok.setBounds(90,175,150,28);
	bb2.setBounds(290,175,150,28);
	d.add(ok);
	d.add(bb2);
	d.setVisible(true);
	}
	class TestHallTicket implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			try{
				Connection	con =  MySQLConnection.getConnection();
  				try{
  				    pr_de=pro.getSelectedItem();
  					eno_roll=eno.getText();
  				    Statement st = con.createStatement();
   				    ResultSet res = st.executeQuery("select * from form where ENO="+"'"+eno_roll+"'"+"&&"+"pro_code="+"'"+pr_de+"'");
  					while (res.next()) 
  					{
  					pname = res.getString("eno");
					ppass = res.getString("pro_code");
	  		   		}			
				    if(pr_de.equals(pname) && eno_roll.equals(ppass))
				    {
				    getHallTicket ght=new getHallTicket();
				    ght.get_HallTicket();
				    d.dispose();
				    }
					else
					{
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(null,"Entroment number not found","Error!", JOptionPane.ERROR_MESSAGE);
				   }}
				catch (SQLException s)
  				{
				JOptionPane.showMessageDialog(null,"Query  error ","Error !",JOptionPane.ERROR_MESSAGE); 	
  				}  
  		 	}
			catch (Exception e){
  			JOptionPane.showMessageDialog(null,"Database connection error ","Error !",JOptionPane.ERROR_MESSAGE); 	
  			}
		}}
			
class getHallTicket// implements ActionListener
{
	JDialog d;
	JTextField a1,a2,a3,a4,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,u1,u2,u3,u4,u5,u6,u7,u8,u9,u10,u11,u12,u13,u14,u15,v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14,v15;
	Font f3=new Font("Arial Blank",Font.BOLD,16);
	public getHallTicket()
	{
		d=new JDialog(e,"Admit Card",true);
		d.setLayout(null);
		d.setBounds(340,77,550,588);
		JLabel headline=new JLabel("HallTicket",JLabel.CENTER);
		Font f2=new Font("Castellar",Font.BOLD,22 );
		headline.setFont(f2);
		headline.setBackground(Color.red);
		headline.setBounds(0,10,550,40);
		d.add(headline);
		JButton	ok=new JButton("Ok");
		ok.setBounds(220,524,150,28);
		ok.addActionListener(new hallexit());
		d.add(ok);
		String name[] ={"Name","Enrollment no.","Program code","Exaination Centre code",""};
		JLabel label[]=new JLabel[5];
		int y=60;
		for(int i=0;i<5;i++,y+=30)
		{
			label[i]=new JLabel(name[i]);
			label[i].setBounds(40,y,180,25);
			label[i].setFont(f3);
			d.add(label[i]);
		}
		a1=new JTextField();
		a2=new JTextField();
		a3=new JTextField();
		a4=new JTextField();
		int yy=60;
		JTextField textfield[]={a1,a2,a3,a4};
		for(int i=0;i<4;i++,yy+=30)
		{	
			textfield[i].setBounds(250,yy,270,25);
			textfield[i].setFont(f3);
			d.add(textfield[i]);
		}
		JLabel course= new JLabel("Course Code",JLabel.CENTER);
		Font cfont=new Font("Arial",Font.BOLD,20);
		course.setBounds(30,184,200,30);
		course.setFont(f3);
		d.add(course);	
		JLabel max= new JLabel("Date",JLabel.CENTER);
		max.setBounds(182,184,200,30);
		max.setFont(f3);
		d.add(max);	
		JLabel marks= new JLabel("Session",JLabel.CENTER);
		marks.setBounds(365,184,150,30);
		marks.setFont(f3);
		d.add(marks);	
		String name2[] ={"1.","2.","3.","4.","5.","6.","7.","8.","9.","10.","11.","12.","13.","14.","15.",""};
		int ly=217;
		JLabel label2[]=new JLabel[16];
		Font ff1=new Font("Arial Blank",Font.BOLD,16);
		for(int i=0;i<16;i++,ly+=20)
		{
			label2[i]=new JLabel(name2[i]);
			label2[i].setBounds(40,ly,30,20);
			label2[i].setFont(ff1);
			d.add(label2[i]);
		}
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		t5=new JTextField();
		t6=new JTextField();
		t7=new JTextField();
		t8=new JTextField();
		t9=new JTextField();
		t10=new JTextField();
		t11=new JTextField();
		t12=new JTextField();
		t13=new JTextField();
		t14=new JTextField();
		t15=new JTextField();	
		int yyy=217;
    	JTextField coursefield[]={t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15};
		for(int i=0;i<coursefield.length;i++,yyy+=20)
		{		
			coursefield[i].setBounds(70,yyy,120,22);
			coursefield[i].setFont(f3);
			d.add(coursefield[i]);
		}
		u1=new JTextField();
		u2=new JTextField();
		u3=new JTextField();
		u4=new JTextField();
		u5=new JTextField();
		u6=new JTextField();
		u7=new JTextField();
		u8=new JTextField();
		u9=new JTextField();
		u10=new JTextField();
		u11=new JTextField();
		u12=new JTextField();
		u13=new JTextField();
		u14=new JTextField();
		u15=new JTextField();	
		int y1=217;
		JTextField coursefield1[]={u1,u2,u3,u4,u5,u6,u7,u8,u9,u10,u11,u12,u13,u14,u15};
		for(int i=0;i<coursefield1.length;i++,y1+=20)
		{
			coursefield1[i].setBounds(230,y1,120,22);
			coursefield1[i].setFont(f3);
			d.add(coursefield1[i]);
		}
		v1=new JTextField();
		v2=new JTextField();
		v3=new JTextField();
		v4=new JTextField();
		v5=new JTextField();
		v6=new JTextField();
		v7=new JTextField();
		v8=new JTextField();
		v9=new JTextField();
		v10=new JTextField();
		v11=new JTextField();
		v12=new JTextField();
		v13=new JTextField();
		v14=new JTextField();
		v15=new JTextField();	
		int yyby=217;
		JTextField coursefield3[]={v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14,v15};
		for(int i=0;i<coursefield3.length;i++,yyby+=20)
		{		
			coursefield3[i].setBounds(390,yyby,120,22);
			coursefield3[i].setFont(f3);
			d.add(coursefield3[i]);
		}
		d.setResizable(false);
		d.setVisible(true);
	}			
	void get_HallTicket()
	{
		 try{
				Connection	con =  MySQLConnection.getConnection();
  			try{
  				Statement st = con.createStatement();  
   				JTextField course[]={t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15};
   				JTextField date[]={u1,u2,u3,u4,u5,u6,u7,u8,u9,u10,u11,u12,u13,u14,u15};
   				JTextField session[]={v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14,v15};
   				ResultSet res = st.executeQuery("select name,eno,pro_code,ec_code,course,date,session from form natural join date"); 				
  				for(int i=0;i<15;i++)
  				{
  				while (res.next()) 
  				{
  			//	a1.setText=res.getString("name");
  			//	a2.setText=res.getString("eno");
			//	a3.setText=res.getString("pro_code");  				
  				a4.setText(res.getString("ec_code"));
  				course[i].setText(res.getString("course")); 
				date[i].setText(res.getString("date"));  				
  				session[i].setText(res.getString("session"));
  				}  				
  				}
 			   }
  				catch (SQLException s)
  				{
  				JOptionPane.showMessageDialog(null,"Sql not executed ","Error!", JOptionPane.ERROR_MESSAGE);
  				}
  				con.close();  
  		   }
  		catch (Exception e){
  		JOptionPane.showMessageDialog(null,"Error in database connection ","Error!", JOptionPane.ERROR_MESSAGE);
		}
	}

	class hallexit implements ActionListener
	{
		public void actionPerformed(ActionEvent ea)
		{
			d.setVisible(false);
			d.dispose();
		}
	}
}
	class can_work implements ActionListener
	{
		public void actionPerformed(ActionEvent ea)
		{
			d.setVisible(false);
			d.dispose();
		}
	}

}
 	
  
    class OverAll implements ActionListener
    {
	JDialog d;
	EMSMain e;
	JButton pr,PR1;
	JTextField pro,eno;
	Label l2,l4,l6;
	Connection	con;
	public  OverAll(EMSMain e)
	{
		this.e=e;
	}
	Font f3=new Font("Arial Blank",Font.BOLD,16);
	public void actionPerformed(ActionEvent ae)
	{
	d=new JDialog(e,"Over all description ",true);
	d.setLayout(null);
	d.setBounds(340,100,500,500);
	JLabel headline=new JLabel("Over all description",JLabel.CENTER);
	Font f2=new Font("Castellar",Font.BOLD,22 );
	headline.setFont(f2);
	headline.setBackground(Color.red);
	headline.setBounds(0,10,500,40);
	d.add(headline);
	JLabel pro_lab=new JLabel("No of students fillup form");
	JLabel eno_lab=new JLabel("No of students apprer in Examination.");
	pro_lab.setBounds(30,60,250,40);
	eno_lab.setBounds(30,100,250,40);
	d.add(pro_lab);
	d.add(eno_lab);
	pro=new JTextField();
	eno=new JTextField();
	pro.setBounds(340,65,100,25);
	eno.setBounds(340,105,100,25);
	d.add(pro);
	d.add(eno);
	JLabel jl=new JLabel("Program code wise student apprear in examination ");
	jl.setBounds(30,135,400,25);
	pr=new JButton("SHOW");
	pr.setBounds(342,135,100,25);
	pr.addActionListener(new tech());
	d.add(pr);
	d.add(jl);
	JLabel JL=new JLabel("Program code with number of  course code ");
	JL.setBounds(30,275,400,25);
	PR1=new JButton("Look");
	PR1.setBounds(342,275,100,25);
	PR1.addActionListener(new tech());
	d.add(PR1);
	d.add(JL);
	JButton bb2=new JButton("Cancel");
	bb2.addActionListener(new can_work());                                                                                   
	bb2.setBounds(180,395,100,25);
	d.add(bb2);
	d.setVisible(true);
	int count=0;
	try
	{
		Connection	con =  MySQLConnection.getConnection();
 	 	try{
  		Statement st = con.createStatement();
   		ResultSet res = st.executeQuery("SELECT eno,course FROM form");
   		ResultSet res1 = st.executeQuery("SELECT eno,course FROM answer");
   		ResultSet res3 = st.executeQuery("SELECT pro_code,course FROM answer");
   		int coun=0,coun1=0,count3=0;
  		while (res.next()) 
  		{
  		coun = res.getInt(1);
  		}
  		pro.setText(String.valueOf(coun));
  		while (res1.next()) 
  		{
  		coun1 = res.getInt(1);
  		}
  		eno.setText(String.valueOf(coun1));
  		while (res3.next()) 
  		{
  		count3 = res.getInt(1);
  		}
  		l2.setText(String.valueOf(count3));
  		}
  		catch(Exception e){}
  		}
  	catch(Exception e){}
  	String s=String.valueOf(count);
	pro.setText(s);
	
	
	
	}	
	class tech implements ActionListener
	{
		public void actionPerformed(ActionEvent ie)
		{
		Panel p=new Panel();
		Label ll1 =new Label("Program code",Label.CENTER);
		Label ll2 =new Label("Number of students",Label.CENTER);
		Label ll3 =new Label("Number of Courses ",Label.CENTER);
		Label l1=new Label("BCA",Label.CENTER);
		l2=new Label();
		Label l3=new Label("MCA",Label.CENTER);
		l4=new Label();
		Label l5=new Label("CIT",Label.CENTER);
		 l6=new Label();
		
		p.setBackground(Color.yellow);
		p.setLayout(new GridLayout(4,2));
		p.setFont(f3);		
		String st=ie.getActionCommand();
		if(st.equals("SHOW"))	
		{	
			p.setBounds(40,170,400,100);
			p.add(ll1);
			p.add(ll2);
			p.add(l1);
			p.add(l2);
			p.add(l3);
			p.add(l4);
			p.add(l5);
			p.add(l6);
			d.add(p);
			d.show();	
		}
		else if(st.equals("Look"))
		{	
		Panel p2=new Panel();
		p2.setBackground(Color.yellow);
			p2.setLayout(new GridLayout(4,2));
			p2.setFont(f3);		
			p2.setBounds(50,300,400,150);
			p2.add(ll1);
			p2.add(ll3);
			p2.add(l1);
			p2.add(l2);
			p2.add(l3);
			p2.add(l4);
			p2.add(l5);
			p2.add(l6);
			d.add(p);
			d.show();
		}
	}}
	class can_work implements ActionListener
	{
		public void actionPerformed(ActionEvent ea)
		{
			d.setVisible(false);
			d.dispose();
		}
	}
	
	
	
	
			
}
  
  
class SearchExamSchidule implements ActionListener
{
	JDialog d;
	EMSMain e;
	Choice pro,eno;
	String pr_de,eno_roll;
	public  SearchExamSchidule(EMSMain e)
	{
		this.e=e;
	}
	Font f3=new Font("Arial Blank",Font.BOLD,16);
	public void actionPerformed(ActionEvent ae)
	{
	d=new JDialog(e,"Search Examination Schidule ",true);
	d.setLayout(null);
	d.setBounds(340,100,500,275);
	JLabel headline=new JLabel("Search Examination Schidule",JLabel.CENTER);
	Font f2=new Font("Castellar",Font.BOLD,22 );
	headline.setFont(f2);
	headline.setBackground(Color.red);
	headline.setBounds(0,10,500,40);
	d.add(headline);
	JLabel pro_lab=new JLabel("Select Program Code");
	JLabel eno_lab=new JLabel("Select Examination Centre code");
	pro_lab.setBounds(30,60,200,40);
	eno_lab.setBounds(30,100,200,40);
	d.add(pro_lab);
	d.add(eno_lab);
	pro=new Choice();
	eno=new Choice();
	pro.setBounds(300,65,150,40);
	eno.setBounds(300,105,150,25);
	pro.addItem("BCA");
	pro.addItem("MCA");
	pro.addItem("CIT");
	eno.addItem("0504");
	eno.addItem("0505");
	eno.addItem("0506");
	d.add(pro);
	d.add(eno);
	JLabel jl=new JLabel("Please Select Program code and select examination centre.");
	jl.setBounds(30,135,400,25);
	d.add(jl);
	JButton	ok=new JButton("Submit");
	ok.addActionListener(new VerifyExamSchidule());
	JButton bb2=new JButton("Cancel");
	bb2.addActionListener(new can_work());                                                                                                                             
	ok.setBounds(90,175,150,28);
	bb2.setBounds(290,175,150,28);
	d.add(ok);
	d.add(bb2);
	d.setVisible(true);	
	}
	
	
	
	class VerifyExamSchidule implements ActionListener
	{
		String pname,ppass;
		public void actionPerformed(ActionEvent ae)
		{
			try{
				Connection	con =  MySQLConnection.getConnection();
  				try{
  				    pr_de=pro.getSelectedItem();
  					eno_roll=eno.getSelectedItem();
  				    Statement st = con.createStatement();
   				    ResultSet res = st.executeQuery("select * from form where ENO="+"'"+eno_roll+"'"+"&&"+"pro_code="+"'"+pr_de+"'");
  					while (res.next()) 
  					{
  					pname = res.getString("eno");
					ppass = res.getString("pro_code");
	  		   		}			
				    if(pr_de.equals(pname) && eno_roll.equals(ppass))
				    {
				   	getExaminationSchidule gts=new getExaminationSchidule();
				    gts.get_ExamSchidule();
				    d.dispose();
				    }
					else
					{
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(null,"Entroment number not found","Error!", JOptionPane.ERROR_MESSAGE);
				   }}
				catch (SQLException s)
  				{
				JOptionPane.showMessageDialog(null,"Query  error ","Error !",JOptionPane.ERROR_MESSAGE); 	
  				}  
  		 	}
			catch (Exception e){
  			JOptionPane.showMessageDialog(null,"Database connection error ","Error !",JOptionPane.ERROR_MESSAGE); 	
  			}
		}}	
	
	class can_work implements ActionListener
	{
		public void actionPerformed(ActionEvent ea)
		{
			d.setVisible(false);
			d.dispose();
		}
	}		
	

  class getExaminationSchidule implements ActionListener
  { 
	JDialog d;
	JTextField t1,t2,t3,t4;
	Font f3=new Font("Arial Blank",Font.BOLD,14);
	public void actionPerformed(ActionEvent ae)
	{
	d=new JDialog(e,"Examination schidule",true);
	d.setBounds(340,77,550,563);
	JLabel headline=new JLabel("Examination Attendece Schidule");
	Font f2=new Font("Castellar",Font.BOLD,26);
	headline.setFont(f2);
	headline.setBackground(Color.red);
	headline.setBounds(135,10,650,50);
	JButton bb2=new JButton("Cancel");
	bb2.addActionListener(new can_work());                 
	bb2.setBounds(175,480,150,25);
	d.add(bb2);
	t1=new JTextField();
	t2=new JTextField();
	t3=new JTextField();
	t4=new JTextField();
		String name[] ={"Date","Exam.Cente Code","Program code","Course Code",""};
		JLabel label[]=new JLabel[5];
		JTextField textfield[]={t1,t2,t3,t4};
		int i,j,x,y=405;
		for(i=0,j=135,x=30;i<4;i++,x+=247,j+=268)
		{
			if(i==2)
			{
				y=435;
				x=30;
				j=135;
			}
			label[i]=new JLabel(name[i]);
			label[i].setBounds(x,y,150,25);
			label[i].setFont(f3);
			d.add(label[i]);
			
			textfield[i]=new JTextField();		
			textfield[i].setBounds(j,y,125,25);
			textfield[i].setFont(f3);
			d.add(textfield[i]);
		}
		d.setResizable(false);
		d.setVisible(true);
	}
	
	
	void get_ExamSchidule()
	{
		 final String col[]={"s.no","Eno.","Name","Singnature","Pre/Abs","Book no."};
		 try{
				Connection	con =  MySQLConnection.getConnection();
  			try{
  				Statement st = con.createStatement();  
   				ResultSet res = st.executeQuery("select name,eno,pro_code,ec_code,course,date,session from form natural join date"); 				
  				int i=1;
  				while (res.next()) 
  				{
  				String name=res.getString("name");
  				String eno=res.getString("eno");
  				t1.setText(res.getString("date"));
  				t2.setText(res.getString("ec_code"));
  				//t3.setText=res.getString("pro_code");
  				t4.setText(res.getString("course"));   				 			
  				final Object data[][]={
				{i,eno,name,"............","......","........"}};
				i++;
				JTable table=new JTable(data,col);
				int v =ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;	
				int h =ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;	
				JScrollPane jsp=new JScrollPane(table,v,h);	
				d.add(jsp);  					
  				}  				
  				}
 			   
  				catch (SQLException s)
  				{
  				JOptionPane.showMessageDialog(null,"Sql not executed ","Error!", JOptionPane.ERROR_MESSAGE);
  				}
  				con.close();  
  		   }
  		catch (Exception e){
  		JOptionPane.showMessageDialog(null,"Error in database connection ","Error!", JOptionPane.ERROR_MESSAGE);
		}
	}
	class can_work implements ActionListener
	{
		public void actionPerformed(ActionEvent ea)
		{
			d.setVisible(false);
			d.dispose();
		}
	}
}   
}
    class SearchMarkSheet implements ActionListener
    {
	JDialog d;
	EMSMain e;
	Choice pro;
	JTextField eno;
	public  SearchMarkSheet(EMSMain e)
	{
		this.e=e;
	}
	Font f3=new Font("Arial Blank",Font.BOLD,16);
	public void actionPerformed(ActionEvent ae)
	{
	d=new JDialog(e,"Search Marks sheet ",true);
	d.setLayout(null);
	d.setBounds(340,100,500,275);
	JLabel headline=new JLabel("Search Marks sheet",JLabel.CENTER);
	Font f2=new Font("Castellar",Font.BOLD,22 );
	headline.setFont(f2);
	headline.setBackground(Color.red);
	headline.setBounds(0,10,500,40);
	d.add(headline);
	JLabel pro_lab=new JLabel("Select Program Code");
	JLabel eno_lab=new JLabel("Enter 9 digit Enrollment no.");
	pro_lab.setBounds(30,60,200,40);
	eno_lab.setBounds(30,100,200,40);
	d.add(pro_lab);
	d.add(eno_lab);
	pro=new Choice();
	eno=new JTextField();
	pro.setBounds(300,65,150,40);
	eno.setBounds(300,105,150,25);
	pro.addItem("BCA");
	pro.addItem("MCA");
	pro.addItem("CIT");
	d.add(pro);
	d.add(eno);
	JLabel jl=new JLabel("Select Program code and Enter nine digit Enrollment no...");
	jl.setBounds(30,135,400,25);
	d.add(jl);
	JButton	ok=new JButton("Submit");
	ok.addActionListener(new VerifyMarksheet());
	JButton bb2=new JButton("Cancel");
	bb2.addActionListener(new can_work());                                                                                                                             
	ok.setBounds(90,175,150,28);
	bb2.setBounds(290,175,150,28);
	d.add(ok);
	d.add(bb2);
	d.setVisible(true);
	}
	
	class VerifyMarksheet implements ActionListener
	{
		String pr_de,eno_roll,pname,ppass;
		public void actionPerformed(ActionEvent ae)
		{
			try{
				Connection	con =  MySQLConnection.getConnection();
  				try{
  				    pr_de=pro.getSelectedItem();
  					eno_roll=eno.getText();
  				    Statement st = con.createStatement();
   				    ResultSet res = st.executeQuery("select * from form where ENO="+"'"+eno_roll+"'"+"&&"+"pro_code="+"'"+pr_de+"'");
  					while (res.next()) 
  					{
  					pname = res.getString("eno");
					ppass = res.getString("pro_code");
	  		   		}			
				    if(pr_de.equals(pname) && eno_roll.equals(ppass))
				    {
				    getMarkSheet ght=new getMarkSheet();
				    ght.get_MarkSheet();
				    d.dispose();
				    }
					else
					{
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(null,"Entroment number not found","Error!", JOptionPane.ERROR_MESSAGE);
				   }}
				catch (SQLException s)
  				{
				JOptionPane.showMessageDialog(null,"Query  error ","Error !",JOptionPane.ERROR_MESSAGE); 	
  				}  
  		 	}
			catch (Exception e){
  			JOptionPane.showMessageDialog(null,"Database connection error ","Error !",JOptionPane.ERROR_MESSAGE); 	
  			}
		}}
		
		
class getMarkSheet implements ActionListener
{
	JDialog d;
	JTextField tt1,tt2,tt3,tt4,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,u1,u2,u3,u4,u5,u6,u7,u8,u9,u10,u11,u12,u13,u14,u15,v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14,v15;
	public void actionPerformed(ActionEvent ae)
	{
	d=new JDialog(e,"Admit Card",true);
	d.setLayout(null);
	d.setBounds(340,77,550,588);
	JLabel headline=new JLabel("Marksheet",JLabel.CENTER);
	Font f2=new Font("Castellar",Font.BOLD,22 );
	headline.setFont(f2);
	headline.setBackground(Color.red);
	headline.setBounds(0,10,550,40);
	d.add(headline);
	JButton	ok=new JButton("Ok");
	JButton bb2=new JButton("Cancel");
	bb2.addActionListener(new can_work());                                                                                                                             
	ok.setBounds(115,524,150,28);
	bb2.setBounds(315,524,150,28);
	d.add(ok);
	d.add(bb2);
		String name[] ={"Name","Enrollment no.","Program code","Exaination Centre code",""};
		JLabel label[]=new JLabel[5];
		int y=60;
		for(int i=0;i<5;i++,y+=30)
		{
			label[i]=new JLabel(name[i]);
			label[i].setBounds(40,y,180,25);
			label[i].setFont(f3);
			d.add(label[i]);
		}
		JTextField textfield[]={tt1,tt2,tt3,tt4};
		int yy=60;
		for(int i=0;i<4;i++,yy+=30)
		{
			textfield[i]=new JTextField();		
			textfield[i].setBounds(250,yy,270,25);
			textfield[i].setFont(f3);
			d.add(textfield[i]);
		}
		JLabel course= new JLabel("Course Code",JLabel.CENTER);
		Font cfont=new Font("Arial",Font.BOLD,20);
		course.setBounds(30,184,200,30);
		course.setFont(f3);
		d.add(course);	
		JLabel max= new JLabel("Max_Marks",JLabel.CENTER);
		max.setBounds(182,184,200,30);
		max.setFont(f3);
		d.add(max);	
		JLabel marks= new JLabel("Marks",JLabel.CENTER);
		marks.setBounds(365,184,150,30);
		marks.setFont(f3);
		d.add(marks);	
		String name2[] ={"1.","2.","3.","4.","5.","6.","7.","8.","9.","10.","11.","12.","13.","14.","15.",""};
		int ly=217;
		JLabel label2[]=new JLabel[16];
		Font ff1=new Font("Arial Blank",Font.BOLD,16);
		for(int i=0;i<16;i++,ly+=20)
		{
			label2[i]=new JLabel(name2[i]);
			label2[i].setBounds(40,ly,30,20);
			label2[i].setFont(ff1);
			d.add(label2[i]);
		}
		int yyy=217;
		JTextField coursefield[]={t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15};
    	for(int i=0;i<15;i++,yyy+=20)
		{
			coursefield[i]=new JTextField();		
			coursefield[i].setBounds(70,yyy,120,22);
			coursefield[i].setFont(f3);
			d.add(coursefield[i]);
		}
		int y1=217;
		JTextField coursefield1[]={u1,u2,u3,u4,u5,u6,u7,u8,u9,u10,u11,u12,u13,u14,u15};
		for(int i=0;i<15;i++,y1+=20)
		{
			coursefield1[i]=new JTextField();		
			coursefield1[i].setBounds(230,y1,120,22);
			coursefield1[i].setFont(f3);
			d.add(coursefield1[i]);
		}		
		int yyby=217;
		JTextField coursefield3[]={v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14,v15};
		for(int i=0;i<15;i++,yyby+=20)
		{
			coursefield3[i]=new JTextField();		
			coursefield3[i].setBounds(390,yyby,120,22);
			coursefield3[i].setFont(f3);
			d.add(coursefield3[i]);
		}
		d.setResizable(false);
		d.setVisible(true);
	}
	
	void get_MarkSheet()
	{
		 try{
				Connection	con =  MySQLConnection.getConnection();
  			try{
  				Statement st = con.createStatement();  
   				JTextField course[]={t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15};
   				JTextField max[]={u1,u2,u3,u4,u5,u6,u7,u8,u9,u10,u11,u12,u13,u14,u15};
   				JTextField mark[]={v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14,v15};
   				ResultSet res = st.executeQuery("select name,eno,pro_code,ec_code,course,max_marks,marks from form natural join answer"); 				
  				while (res.next()) 
  				{
  				String name=res.getString("name");
  				String eno=res.getString("eno");
  				String pro=res.getString("pro_code");
  				String ec_code=res.getString("ec_code");
			  	String details[]={name,eno,pro,ec_code};
			  	JTextField textfield[]={t1,t2,t3,t4};			
  				for(int j=0;j<4;j++)
  				{
  				textfield[j].setText(details[j]);
  				}
  				for(int k=0;k<15;k++)
  				{
  				course[k].setText("course");
  				max[k].setText("max_marks");
  				mark[k].setText("marks");
  				}
  				}  				
 			   }
  				catch (SQLException s)
  				{
  				JOptionPane.showMessageDialog(null,"Sql not executed ","Error!", JOptionPane.ERROR_MESSAGE);
  				}
  				con.close();  
  		   }
  		catch (Exception e){
  		JOptionPane.showMessageDialog(null,"Error in database connection ","Error!", JOptionPane.ERROR_MESSAGE);
		}
	}
  }	
	class can_work implements ActionListener
	{
		public void actionPerformed(ActionEvent ea)
		{
			d.setVisible(false);
			d.dispose();
		}
	}		

}

 
  class OutputFormHelp implements ActionListener
  {
	JDialog d;
	EMSMain e;
	public OutputFormHelp(EMSMain e)
	{
		this.e=e;
	}
	Font f3=new Font("Arial Blank",Font.BOLD,16);
	public void actionPerformed(ActionEvent ae)
	{
	d=new JDialog(e,"Input Help",true);
	d.setLayout(null);
	d.setResizable(false);
	d.setBounds(340,77,550,563);
	JLabel headline=new JLabel("Record Entry Help");
	Font f2=new Font("Castellar",Font.BOLD,26);
	headline.setFont(f2);
	headline.setBackground(Color.red);
	headline.setBounds(135,10,650,50);
	d.add(headline);
	JButton can=new JButton("Cancel");
	can.addActionListener(new can_work());                                                                                                                             
    can.setBounds(200,450,140,30);
	d.add(can);
    String msg1="\t\tHELP\n It provide student Examination all details as a report of examination as like student examination Hall Ticket :-\n * Name :- it show 30 chatecter letter and only alphbet \n Entrollment no:-only 9 digit number\nprogram code:-according to examination form record from choice\nAddress:-only 50 charecter\nStudy Centre code:-show the selected of examination form of choice menu\nExamination Cenre code:- selecte from Choice of student form record  \nDD no.:-only 6 digit number\n  show  \nCourse code:-list of course code Selected from  course code from the list of course code those are already selected from the student form entiry\nDate:- date with appropiate matches date \nSession :-show the all the session of each course code";
	TextArea jtp=new TextArea("Help\n\n",10,10,TextArea.SCROLLBARS_VERTICAL_ONLY);	jtp.setText(msg1);
	Font f22=new Font("Arial Bold",Font.HANGING_BASELINE,18);
	jtp.setBounds(0,75,550,350);
	jtp.setFont(f22);
	jtp.setEditable(false);
	d.add(jtp);
	d.show();
	}
	class can_work implements ActionListener
	{
		public void actionPerformed(ActionEvent ea)
		{
			d.setVisible(false);
			d.dispose();
		}
	}
}
 
    class OutputExit implements ActionListener
	{
		JDialog d;
		EMSMain e;
		public OutputExit(EMSMain e)
		{
			this.e=e;
		}
		public void actionPerformed(ActionEvent ae)
		{
		
			d=new JDialog(e,"Exit",true);
			d.setBounds(200,200,500,150);
			d.setLayout(null);	
			d.setResizable(false);
			JLabel jl=new JLabel("Do you want to continue exit this Examination Management System",JLabel.CENTER);
			jl.setBounds(0,0,500,60);
			d.add(jl);
			JButton b=new JButton("Yes");
			b.setBounds(125,70,100,30);
			JButton can=new JButton("No");
			can.setBounds(275,70,100,30);
			can.addActionListener(new Action());
			b.addActionListener(new Action());
			d.add(b);
			d.add(can);
			d.setVisible(true);
			}
    	class Action implements ActionListener
		{
		public void  actionPerformed(ActionEvent ae)
		{
			String str=ae.getActionCommand();
			if(str.equals("Yes"))
			{
			e.dispose();
			}
			else
			d.dispose();
		}
		}
	}

  class Change_Passward implements ActionListener
  {
	JDialog d;
	JTextField oname,opass,nname,npass;
	EMSMain e;
	public Change_Passward(EMSMain e)
	{
		this.e=e;
	}
	Font first_textfield_font=new Font("Arial Blank",Font.BOLD,16);	
	public void actionPerformed(ActionEvent ae)
	{
	d=new JDialog(e,"Change Passward Setting",true);
	d.setLayout(null);
	d.setResizable(false);
	d.setBounds(340,87,550,480);
	JLabel headline=new JLabel("Change Setting");
	Font f2=new Font("Castellar",Font.BOLD,22);
	headline.setFont(f2);
	headline.setBackground(Color.red);
	headline.setBounds(135,10,650,50);
	d.add(headline);
	JLabel conf =new JLabel("Conformation",JLabel.CENTER);
	conf.setBounds(0,85,550,30);
	d.add(conf);
	JLabel old_name =new JLabel("Old Name");
	old_name.setBounds(40,120,180,30);
	d.add(old_name);
	JLabel oldpass =new JLabel("Old Passward");
	oldpass.setBounds(40,160,180,30);
	d.add(oldpass);
    oname=new JTextField();
	oname.setBounds(250,120,240,30);
	d.add(oname);
	opass=new JTextField();
	opass.setBounds(250,160,240,30);
	d.add(opass);
	JLabel nconf =new JLabel("New Name & Passward",JLabel.CENTER);
	nconf.setBounds(0,207,550,30);
	d.add(nconf);
	JLabel newname =new JLabel("New Name");
	newname.setBounds(40,240,180,30);
	d.add(newname);
	JLabel newpass =new JLabel("New Passward");
	newpass.setBounds(40,280,180,30);
	d.add(newpass);
	nname=new JTextField();
	nname.setBounds(250,240,240,30);
	d.add(nname);
	npass=new JTextField();
	npass.setBounds(250,280,240,30);
	d.add(npass);
	JButton nok=new JButton("Ok");
	nok.addActionListener(new change_ok());
	nok.setBounds(80,350,150,30);
	d.add(nok);
	JButton ncan=new JButton("Cancel");
	ncan.addActionListener(new can_work());
	ncan.setBounds(290,350,150,30);
	d.add(ncan);
	d.show();
	}
	class can_work implements ActionListener
	{
		public void actionPerformed(ActionEvent ea)
		{
			d.setVisible(false);
			d.dispose();
		}
	}
	class change_ok implements ActionListener
	{
		String pname,ppass;
		public void actionPerformed(ActionEvent ae)
		{
			try{
				Connection	con =  MySQLConnection.getConnection();
  				try{
  					String name=(String)oname.getText();
 				    String pass=(String)opass.getText();
  					Statement st = con.createStatement();
   				    ResultSet res = st.executeQuery("select * from user where username='"+name+"' && password='"+pass+"'");		  				
  					while (res.next()) 
  					{
  					pname = res.getString("username");
					ppass = res.getString("password");
	  		   		}			
				 
  				    String nn=nname.getText();	
				    String pp=npass.getText();
				 	//String update="update login set name="+"'"+nn+"'"+","+"passward="+"'"+pp+"'";
				    String sql = "UPDATE user SET username = ? , password = ? where username='"+name+"' && password='"+pass+"'";
				   // System.out.println(sql);
			    	if(name.equalsIgnoreCase(pname) && pass.equalsIgnoreCase(ppass))
				    {
				 	PreparedStatement prest = con.prepareStatement(sql);
  					prest.setString(1,nn);
  					prest.setString(2,pp);
				    JOptionPane.showMessageDialog(null,"Do you want to change you name and password !");
				    prest.executeUpdate();
				    JOptionPane.showMessageDialog(null,"Name and Passward sucessfully changed ");
				    d.dispose();
				    }
					else
					{
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(null,"Invalid User Name or Password","Error!", JOptionPane.ERROR_MESSAGE);
				   }}
				catch (SQLException s)
  				{
				JOptionPane.showMessageDialog(null,"Query  error ","Error !",JOptionPane.ERROR_MESSAGE); 	
  				}  
  		 	}
			catch (Exception e){
  			JOptionPane.showMessageDialog(null,"Database connection error ","Error !",JOptionPane.ERROR_MESSAGE); 	
  			}
		}
			
	}	
  }

  class SettingFormHelp implements ActionListener
  {
	JDialog d;
	EMSMain e;
	public SettingFormHelp(EMSMain e)
	{
		this.e=e;
	}
	Font f3=new Font("Arial Blank",Font.BOLD,16);
	public void actionPerformed(ActionEvent ae)
	{
	d=new JDialog(e,"Setting Help",true);
	d.setLayout(null);
	d.setResizable(false);
	d.setBounds(340,77,550,563);
	JLabel headline=new JLabel("Passward change Help");
	Font f2=new Font("Castellar",Font.BOLD,26);
	headline.setFont(f2);
	headline.setBackground(Color.red);
	headline.setBounds(135,10,650,50);
	d.add(headline);
	JButton can=new JButton("Cancel");
	can.addActionListener(new can_work());                                                                                                                             
	can.setBounds(200,450,140,30);
	d.add(can);
    String msg1="\t\tPersonal and change setting \n It provide user to see all the pesonal information as change user name and password ,student over all description,topper student according to course code wise....\nChange Login user name and password\n\nfirst field Take old user name/id:-Charecter type 25 digit \nSecoand field :-take 25 charecter old  password \nThird field :-take new user naem/id \nForth field :-take new password \n Ok:- click ok if user name and password matches to existing name and password,then permission to go on main Screen....";
    TextArea jtp=new TextArea("Help\n\n",10,10,TextArea.SCROLLBARS_VERTICAL_ONLY);	jtp.setText(msg1);
	jtp.setText(msg1);
	Font f22=new Font("Arial Bold",Font.HANGING_BASELINE,18);
	jtp.setBounds(0,75,550,350);
	jtp.setFont(f22);
	jtp.setEditable(false);
	d.add(jtp);
	d.show();
	}
	class can_work implements ActionListener
	{
		public void actionPerformed(ActionEvent ea)
		{
			d.setVisible(false);
			d.dispose();
		}
	}
 }
 
    class SettingExit implements ActionListener
	{
		EMSMain e;
		JDialog d;
		public SettingExit(EMSMain e)
		{
			this.e=e;
		}
		public void actionPerformed(ActionEvent ae)
		{
			d=new JDialog(e,"Exit",true);
			d.setBounds(200,200,500,150);
			d.setLayout(null);
			d.setResizable(false);
			JLabel jl=new JLabel("Do you want to continue exit this Examination Management System",JLabel.CENTER);
			jl.setBounds(0,0,500,60);
			d.add(jl);
			JButton b=new JButton("Yes");
			b.setBounds(125,70,100,30);
			JButton can=new JButton("No");
			can.setBounds(275,70,100,30);
			can.addActionListener(new Action());
			b.addActionListener(new Action());
			d.add(b);
			d.add(can);
			d.setVisible(true);
			}
    	class Action implements ActionListener
		{
		public void  actionPerformed(ActionEvent ae)
		{
			String str=ae.getActionCommand();
			if(str.equals("Yes"))
			{
			e.dispose();
			System.exit(0);
			}
			else
			d.dispose();
		}
		}
  }
 
   class About implements ActionListener
   {
 	JDialog d;
 	EMSMain e;
	Font f3=new Font("Arial Blank",Font.BOLD,16);
	public About(EMSMain e)
	{
		this.e=e;
	}
	public void actionPerformed(ActionEvent ae)
	{
  	d=new JDialog(e,"About EMS",true);
  	d.setLayout(null);
	d.setResizable(false);
	d.setBounds(310,220,400,300);
  	ImageIcon ii=new ImageIcon("about.gif");
  	JLabel jl=new JLabel(ii);
  	jl.setBounds(0,0,400,68);
  	d.add(jl);
  	JButton jb=new JButton("OK");
  	jb.setBounds(150,230,100,25);
  	//new can_work()
  	jb.addActionListener(this);
  	d.add(jb);
	Font f2=new Font("Castellar",Font.BOLD,26);
	String msg1="                  Examination Management System\n                  -----------------------------------------------\n"+
	"This program is as a Student's BCA Project\nDeveloped by...  \n\n"+
	"Name :- Vijay kumar \nEntollment no. :- 084596689\nMobile no. :- 9471996823";
	JTextPane jtp=new JTextPane();
	jtp.setText(msg1);
	Font f22=new Font("Arial Bold",Font.BOLD,14);
	jtp.setBounds(10,70,375,150);
	jtp.setFont(f22);
	jtp.setEditable(false);
	d.add(jtp);
	d.setVisible(true);
	}
	
  }	
