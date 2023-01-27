import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginPage{

	JdbcConn jdbc=new JdbcConn();
	static JPanel p1=new JPanel();
	static TextField tf;
	static JPasswordField jpass;
	static String textValue,ptextValue;

	public LoginPage(){
		
		p1.removeAll();
		Main.f.add(p1);
		p1.setLocation(Main.x,Main.y);
		p1.setBackground(Color.cyan);
		p1.setSize(500,500);
		p1.setLayout(null);		
		Label l1,l2,l3,l4;
		Button b1;
		
		JButton goback=new JButton(new ImageIcon("goback.png"));
		goback.setBounds(20,20,35,30);
		goback.setFocusable(false);
		goback.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				p1.setVisible(false);
				Main.p.setVisible(true);
			}
		});
		p1.add(goback);

		l1=new Label("Login");
		l1.setFont(new Font("Calibri",Font.BOLD,24));
        l1.setBounds(215,80,100,50);
		p1.add(l1);

		l2=new Label("Username");
		l2.setFont(new Font("Calibri",Font.PLAIN,20));
        l2.setBounds(90,225,100,50);
		p1.add(l2);

		l3=new Label("Password");
		l3.setFont(new Font("Calibri",Font.PLAIN,20));
        l3.setBounds(90,300,150,50);
		p1.add(l3);

		l4=new Label("Login Success!");
		l4.setBounds(75,50,100,50);

		tf=new TextField(50);
		tf.setFont(new Font("Calibri",Font.PLAIN,14));
		tf.setBounds(260,230,200,35);
		tf.setEditable(true);
		p1.add(tf);

		jpass=new JPasswordField();
		jpass.setBounds(260,305,200,35);
		jpass.setEditable(true);
		p1.add(jpass);
		
		b1=new Button("Submit");
		b1.setBounds(200,400,100,50);
		b1.setFont(new Font("Calibri",Font.PLAIN,16));
		b1.setFocusable(false);
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			try{
				textValue=tf.getText();
				JdbcConn.User=textValue;
				char[] charArr=jpass.getPassword();
				ptextValue=new String(charArr);
				JdbcConn.Pass=ptextValue;
				jdbc.compare();
				
			}
			catch(NullPointerException nullex){
				System.out.println("Fill all the fields"+nullex.getMessage());
			}
			catch(Exception ex){
				System.out.println("Exception:"+ex.getMessage()+""+ex);
			}	
			}
		});
		p1.add(b1);
		p1.setVisible(false);
	}
	
}
