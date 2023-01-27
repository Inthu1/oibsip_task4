import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Register{
	
	static JdbcConn jdbc=new JdbcConn();
	static JPanel p2=new JPanel();
	static String textValue,ptextValue,name,age,prof;
	static TextField tfu,tfp,txt;
	static Choice choi=new Choice();
	static Choice choi1=new Choice();
	static JButton goback,b1;
	static JLabel l1,l2,l3,l4,l5,l6;
	
	public Register(){
		
		p2.removeAll();		
		Main.f.add(p2);		
		p2.setLocation(Main.x,Main.y);
		p2.setBackground(Color.cyan);
		p2.setSize(500,500);
		p2.setLayout(null);
		
		l1=new JLabel("Register");
        l1.setFont(new Font("Calibri",Font.BOLD,24));
        l1.setBounds(215,35,100,50);
		p2.add(l1);
		
		b1=new JButton("Submit");
		b1.setBounds(210,450,100,40);
		b1.setFocusable(false);
		b1.setFont(new Font("Calibri",Font.PLAIN,14));
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					name=txt.getText();
					JdbcConn.Nam=name;
					textValue=tfu.getText();
					JdbcConn.User=textValue;
					ptextValue=tfp.getText();
					JdbcConn.Pass=ptextValue;
					age=choi.getSelectedItem();
					JdbcConn.Ag=age;
					prof=choi1.getSelectedItem();
					JdbcConn.Prof=prof;
						
					if(name==null || textValue==null || ptextValue==null || age==null || prof==null){
						Frame frame=new Frame();
						JOptionPane.showMessageDialog(frame,"Fill all the fields.","Warning",JOptionPane.WARNING_MESSAGE);
					}
					jdbc.insert();
				}
				catch(NullPointerException nullex){
					System.out.println("Fill all the fields");
				}
				catch(Exception ex){
					System.out.println(ex.getMessage());
				}	
			}
		});
		p2.add(b1);
		
		goback=new JButton(new ImageIcon("goback.png"));
		goback.setBounds(20,20,35,30);
		goback.setFocusable(false);
		goback.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				p2.setVisible(false);
				Main.p.setVisible(true);
			}
		});
		p2.add(goback);

		l2=new JLabel("Name");
		l2.setFont(new Font("Calibri",Font.PLAIN,20));
		l2.setBounds(90,110,80,50);
		p2.add(l2);

		l6=new JLabel("Age");
		l6.setFont(new Font("Calibri",Font.PLAIN,20));
		l6.setBounds(90,180,100,50);
		p2.add(l6);

		l4=new JLabel("Profession");
		l4.setFont(new Font("Calibri",Font.PLAIN,20));
		l4.setBounds(90,250,100,50);
		p2.add(l4);

		l3=new JLabel("Username");
		l3.setFont(new Font("Calibri",Font.PLAIN,20));
        l3.setBounds(90,320,100,50);
		p2.add(l3);

		l5=new JLabel("Password");
		l5.setFont(new Font("Calibri",Font.PLAIN,20));
        l5.setBounds(90,390,100,50);
		p2.add(l5);

		txt=new TextField(50);
		txt.setFont(new Font("Calibri",Font.PLAIN,14));
		txt.setBounds(230,115,170,35);
		txt.setEditable(true);
		p2.add(txt);

		tfu=new TextField("abcd@gmail.com",50);
		tfu.setFont(new Font("Calibri",Font.PLAIN,14));
		tfu.setBounds(230,325,170,35);
		tfu.setEditable(true);
		p2.add(tfu);

		tfp=new TextField(".........",50);
		tfp.setFont(new Font("Calibri",Font.PLAIN,14));
		tfp.setBounds(230,395,170,35);
		tfp.setEditable(true);
		p2.add(tfp);
				
		choi.add("Below 18");
		choi.add("18-50");
		choi.add("Above 50");
		choi.setBounds(230,185,170,35);
		choi.setFont(new Font("Calibri",Font.PLAIN,14));
		p2.add(choi);
		
		choi1.add("Student");
		choi1.add("Freelancer");
		choi1.add("Working Person");
		choi1.setBounds(230,255,170,35);
		choi1.setFont(new Font("Calibri",Font.PLAIN,14));
		p2.add(choi1);
		p2.setVisible(false);
	}
	
	static public void edit(){
		if(!p2.isDisplayable())
			new Register();
		
		JButton save;
		l1.setText("Edit Profile");
		l1.setBounds(185,35,150,50);
		b1.setVisible(false);
		goback.setVisible(false);
		jdbc.getData();
		txt.setText(JdbcConn.Nam);
		tfu.setText(JdbcConn.User);
		tfu.setEditable(false);
		tfp.setText(JdbcConn.Pass);
		choi.select(JdbcConn.Ag);
		choi1.select(JdbcConn.Prof);
		txt.setEditable(true);
		tfp.setEditable(true);

		save=new JButton("Save");
		save.setBounds(200,450,100,40);
		save.setFocusable(false);
		save.setFont(new Font("Calibri",Font.PLAIN,14));
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				try{
					name=txt.getText();
					JdbcConn.Nam=name;
					textValue=tfu.getText();
					JdbcConn.User=textValue;
					ptextValue=tfp.getText();
					JdbcConn.Pass=ptextValue;
					age=choi.getSelectedItem();
					JdbcConn.Ag=age;
					prof=choi1.getSelectedItem();
					JdbcConn.Prof=prof;
						
					if(name==null || textValue==null || ptextValue==null || age==null || prof==null){
						Frame frame=new Frame();
						JOptionPane.showMessageDialog(frame,"Fill all the fields.","Warning",JOptionPane.WARNING_MESSAGE);
					}
					jdbc.update();
				}
				catch(NullPointerException nullex){
					System.out.println("Fill all the fields");
				}
				catch(Exception ex){
					System.out.println(ex.getMessage());
				}	
			}
		});
		p2.add(save);
		Register.p2.setVisible(true);
	}
}
