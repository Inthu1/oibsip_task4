import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exam{
    
    static Panel p5=new Panel();
    static Panel p3=new Panel();
    static JPanel p7=new JPanel();
    static Panel p4=new Panel();
    static JLabel jl,h;
    static JRadioButton a,b,c,d,a2,b2,c2,d2,a3,b3,c3,d3,a4,b4,c4,d4,a5,b5,c5,d5;
    static byte ac=0,ad2=0,ad5=0,ab3=0,ab4=0;
    static int marks=0,size=0,X=0,Y=0;
    static boolean flag=false;
    static boolean temp=false;
    static Button submit;
    static JScrollBar scroll;
    static int x=(Main.sizew-(Main.sizew-30)),y=(Main.sizeh-(Main.sizeh-20)),w=(Main.sizew-90);

    public static void exam(){
      
        Main.f.add(p5);
        p5.setSize(Main.sizew,Main.sizeh);
        p5.setBackground(Color.pink);
        p5.setLayout(null);
        JLabel l1,l2,l3,l4,l5;
        Timer t=new Timer();
        Main.f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        h=new JLabel("JAVA ASSESSMENT",JLabel.CENTER);
        h.setFont(new Font("Calibri",Font.BOLD,24));
        h.setBounds((Main.sizew-(Main.sizew-30)),(Main.sizeh-(Main.sizeh-50)),(Main.sizew-30),20);
        p5.add(h);

        p5.add(p7);
        p7.setLocation(0,(Main.sizeh-(Main.sizeh-140)));
        p7.setSize(Main.sizew,Main.sizeh-140);
        p7.setBackground(Color.white);
        p7.setLayout(null);

        JScrollBar scroll=new JScrollBar(JScrollBar.VERTICAL,0,100,0,780);
        scroll.setBounds(Main.sizew-20,0, 20, Main.sizeh-200);
        scroll.setBlockIncrement(20); 
        scroll.setUnitIncrement(20);
        p7.add(scroll);

        Font font=new Font("Calibri",Font.PLAIN,20);        
        
        l1=new JLabel("1) Which of the following is an incorrect array declaration?");
        l1.setFont(new Font("Calibri",Font.PLAIN,20));
        l1.setBounds(x,y,w,50);
        p7.add(l1);
        ButtonGroup group = new ButtonGroup();
    	JRadioButton a = new JRadioButton("a) int[]b = new int[10];");
    	JRadioButton b = new JRadioButton("b) int[] b;");
		JRadioButton c = new JRadioButton("c) int[][] b = new int[10];");
        JRadioButton d = new JRadioButton("d) int[][] b = {{7,2,4,6},{9,8,5}};");
		a.setFont(font);b.setFont(font);c.setFont(font);d.setFont(font);
		a.setBounds(x+30,y+50,w,50);
		b.setBounds(x+30,y+90,w,50);
        c.setBounds(x+30,y+130,w,50);
        d.setBounds(x+30,y+170,w,50);
        a.setFocusable(false);b.setFocusable(false);c.setFocusable(false);d.setFocusable(false);
        group.add(a);group.add(b);group.add(c);group.add(d);
		p7.add(a);p7.add(b);p7.add(c);p7.add(d);

        l2=new JLabel("2) Which of the following is used to find and fix bugs in the Java programs?");
        l2.setFont(new Font("Calibri",Font.PLAIN,20));
        l2.setBounds(x,y+220,w,50);
        p7.add(l2);
        ButtonGroup group2 = new ButtonGroup();
    	JRadioButton a2 = new JRadioButton("a) JVM");
    	JRadioButton b2 = new JRadioButton("b) JRE");
		JRadioButton c2 = new JRadioButton("c) JDK");
        JRadioButton d2 = new JRadioButton("d) JDB");
		a2.setFont(font);b2.setFont(font);c2.setFont(font);d2.setFont(font);
		a2.setBounds(x+30,y+270,w,50);
		b2.setBounds(x+30,y+310,w,50);
        c2.setBounds(x+30,y+350,w,50);
        d2.setBounds(x+30,y+390,w,50);
        a2.setFocusable(false);b2.setFocusable(false);c2.setFocusable(false);d2.setFocusable(false);
        group2.add(a2);group2.add(b2);group2.add(c2);group2.add(d2);
		p7.add(a2);p7.add(b2);p7.add(c2);p7.add(d2);

        l3=new JLabel("3) Hiding internal data from the outside world, and accessing it only through publicly exposed methods is known as data __________");
        l3.setFont(new Font("Calibri",Font.PLAIN,20));
        l3.setBounds(x,y+440,w,50);
        p7.add(l3);
        ButtonGroup group3 = new ButtonGroup();
    	JRadioButton a3 = new JRadioButton("a) Polymorphism");
    	JRadioButton b3 = new JRadioButton("b) Encapsulation");
		JRadioButton c3 = new JRadioButton("c) Inheritance");
        JRadioButton d3 = new JRadioButton("d) Duplication");
		a3.setFont(font);b3.setFont(font);c3.setFont(font);d3.setFont(font);
		a3.setBounds(x+30,y+490,w,50);
		b3.setBounds(x+30,y+530,w,50);
        c3.setBounds(x+30,y+570,w,50);
        d3.setBounds(x+30,y+610,w,50);
        a3.setFocusable(false);b3.setFocusable(false);c3.setFocusable(false);d3.setFocusable(false);
        group3.add(a3);group3.add(b3);group3.add(c3);group3.add(d3);
		p7.add(a3);p7.add(b3);p7.add(c3);p7.add(d3);

        l4=new JLabel("4) When does method overloading is determined?");
        l4.setFont(new Font("Calibri",Font.PLAIN,20));
        l4.setBounds(x,y+660,w,50);
        p7.add(l4);
        ButtonGroup group4 = new ButtonGroup();
    	JRadioButton a4 = new JRadioButton("a) At run time");
    	JRadioButton b4 = new JRadioButton("b) At compile time");
		JRadioButton c4 = new JRadioButton("c) At coding time");
        JRadioButton d4 = new JRadioButton("d) At exection time");
		a4.setFont(font);b4.setFont(font);c4.setFont(font);d4.setFont(font);
		a4.setBounds(x+30,y+710,w,50);
		b4.setBounds(x+30,y+750,w,50);
        c4.setBounds(x+30,y+790,w,50);
        d4.setBounds(x+30,y+830,w,50);
        a4.setFocusable(false);b4.setFocusable(false);c4.setFocusable(false);d4.setFocusable(false);
        group4.add(a4);group4.add(b4);group4.add(c4);group4.add(d4);
		p7.add(a4);p7.add(b4);p7.add(c4);p7.add(d4);

        l5=new JLabel("5) Which of the following is false statement about interface in Java?");
        l5.setFont(new Font("Calibri",Font.PLAIN,20));
        l5.setBounds(x,y+880,w,50);
        p7.add(l5);
        ButtonGroup group5 = new ButtonGroup();
    	JRadioButton a5 = new JRadioButton("a) An interface can extend other interfaces.");
    	JRadioButton b5 = new JRadioButton("b) The interface body can contain abstract methods, default methods, and static methods.");
		JRadioButton c5 = new JRadioButton("c) All constant values defined in an interface are implicitly public,static, final.");
        JRadioButton d5 = new JRadioButton("d) A static method in an interface are implicitly private.");
		a5.setFont(font);b5.setFont(font);c5.setFont(font);d5.setFont(font);
		a5.setBounds(x+30,y+930,w,50);
		b5.setBounds(x+30,y+970,w,50);
        c5.setBounds(x+30,y+1010,w,50);
        d5.setBounds(x+30,y+1050,w,50);
        a5.setFocusable(false);b5.setFocusable(false);c5.setFocusable(false);d5.setFocusable(false);
        group5.add(a5);group5.add(b5);group5.add(c5);group5.add(d5);
		p7.add(a5);p7.add(b5);p7.add(c5);p7.add(d5);

        submit=new Button("Submit");
        submit.setBounds((Main.sizew/2)-50,y+1150,100,40);
        submit.setFocusable(false);
		submit.setFont(new Font("Calibri",Font.PLAIN,14));
        submit.setBackground(Color.pink);
	    p7.add(submit);
        
        scroll.addAdjustmentListener(new AdjustmentListener(){
            public void adjustmentValueChanged(AdjustmentEvent ade){  
                try{                                                      
                    X=scroll.getValue();                   
                    updown();                                 
                    p7.repaint();  
                }
                catch(Exception ex){
                    System.out.println("Exception for scrollbar"+ex);
                }
            }
            public void updown(){
               int dif;
                if(X > Y){
                    dif=X-Y;
                    y=y-dif;
                }
                else if(X==Y) ;
                else{
                    dif=Y-X;
                    y=y+dif;
                }
                Y=X;
                l1.setBounds(x,y,w,50);
                a.setBounds(x+30,y+50,w,50);
		        b.setBounds(x+30,y+90,w,50);
                c.setBounds(x+30,y+130,w,50);
                d.setBounds(x+30,y+170,w,50);
                l2.setBounds(x,y+220,w,50);
                a2.setBounds(x+30,y+270,w,50);
		        b2.setBounds(x+30,y+310,w,50);
                c2.setBounds(x+30,y+350,w,50);
                d2.setBounds(x+30,y+390,w,50);
                l3.setBounds(x,y+440,w,50);        
		        a3.setBounds(x+30,y+490,w,50);
		        b3.setBounds(x+30,y+530,w,50);
                c3.setBounds(x+30,y+570,w,50);
                d3.setBounds(x+30,y+610,w,50);
                l4.setBounds(x,y+660,w,50);
                a4.setBounds(x+30,y+710,w,50);
		        b4.setBounds(x+30,y+750,w,50);
                c4.setBounds(x+30,y+790,w,50);
                d4.setBounds(x+30,y+830,w,50);
                l5.setBounds(x,y+880,w,50);
                a5.setBounds(x+30,y+930,w,50);
		        b5.setBounds(x+30,y+970,w,50);
                c5.setBounds(x+30,y+1010,w,50);
                d5.setBounds(x+30,y+1050,w,50);
                submit.setBounds((Main.sizew/2)-50,y+1150,100,40);
               
                if (c.isSelected() && ac==0){
                    marks=marks+10; ac=1;
                }
                if (d2.isSelected() && ad2==0){
                    marks=marks+10;ad2=1;
                }
                if (d5.isSelected() && ad5==0){
                    marks=marks+10;ad5=1;
                }
                if (b3.isSelected() && ab3==0){
                    marks=marks+10; ab3=1;
                }
                if (b4.isSelected() && ab4==0){
                    marks=marks+10;ab4=1;
                }
                
                if(c.isSelected()==false && ac==1){
                    marks=marks-10;ac=0;
                }
                if(d2.isSelected()==false && ad2==1){
                    marks=marks-10;ad2=0;
                }
                if(b3.isSelected()==false && ab3==1){
                    marks=marks-10;ab3=0;
                }
                if(d5.isSelected()==false && ad5==1){
                    marks=marks-10;ad5=0;
                }
                if(b4.isSelected()==false && ab4==1){
                    marks=marks-10;ab4=0;
                }
                else
                    marks=marks+0;
            }            
        });

        Panel p3=new Panel();
        p5.add(p3);
        p3.setLocation(Main.sizew-(Main.sizew-1200),(Main.sizeh-(Main.sizeh-80)));
        p3.setBackground(Color.cyan);
        p3.setSize(80,50);
        p3.setLayout(null);
        jl=new JLabel("",JLabel.CENTER);
        jl.setBounds(0,0,80,50);
        jl.setForeground(Color.red);
        jl.setFont(new Font("Calibri",Font.PLAIN,22));
        p3.add(jl);

        t.start();

        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                
                JFrame f1=new JFrame();
                int ans=JOptionPane.showConfirmDialog(f1,"Are you sure you want to finish the Java Assessment?","Confirmation",JOptionPane.YES_NO_CANCEL_OPTION);
                switch(ans){
                    case JOptionPane.YES_OPTION:
                        JOptionPane.showMessageDialog(f1,"Thanks for taken the Java Assessment.","ThankYou",JOptionPane.INFORMATION_MESSAGE);
                        temp=true;
                        p5.setVisible(false);
                        score();
                        break;
                    case JOptionPane.NO_OPTION:
                        break;
                    case JOptionPane.CANCEL_OPTION:
                        break;
                }
                }
                catch(Exception e){
                    System.out.println("exception on submit"+e.getMessage());
                }
            }
        });
    }

    public static void score(){           
          
        String str; 
        Main.f.add(p4);
		p4.setLocation(Main.x,Main.y);
		p4.setBackground(Color.cyan);            
        p4.setSize(500,500);
		p4.setLayout(null);
        JLabel jl1,jl2,jh;
        JButton jb2;
        str=(String.valueOf(marks*2))+'%';
        jh=new JLabel("Result");
        jh.setBackground(Color.cyan);
        jh.setFont(new Font("Calibri",Font.BOLD,28));
        jh.setOpaque(true);
        jh.setBounds(215,35,100,50);
		p4.add(jh);
        jl1=new JLabel("Your Percentage is",JLabel.CENTER);
        jl1.setBounds(0,150,500,50);
        jl1.setFont(new Font("Calibri",Font.PLAIN,24));
        jl2=new JLabel(str,JLabel.CENTER);
        jl2.setBackground(Color.cyan);
        jl2.setForeground(Color.orange);
        jl2.setBounds(0,230,500,50);
        jl2.setFont(new Font("Calibri",Font.BOLD,34));
        jl2.setOpaque(true);
        p4.add(jl1);
        p4.add(jl2);

        jb2=new JButton("Exit");
        jb2.setBounds(175,350,150,40);
        jb2.setFocusable(false);
        jb2.setFont(new Font("Calibri",Font.PLAIN,20));
        jb2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                JFrame f1=new JFrame();
                int ans=JOptionPane.showConfirmDialog(f1,"Are you sure you want Exit?","Confirmation",JOptionPane.YES_NO_CANCEL_OPTION);
                switch(ans){
                    case JOptionPane.YES_OPTION:
                        Main.f.dispose();
                        System.exit(0);
                        break;
                    case JOptionPane.NO_OPTION:
                        break;
                    case JOptionPane.CANCEL_OPTION:
                        break;
                }
            }
        });
        p4.add(jb2);
    }
}
