import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Main extends LoginPage{
    
    public static int x,y,sizew,sizeh;
    static JFrame f=new JFrame("Online Examination");
    static JPanel p=new JPanel();
    static Panel p6=new Panel();
    static JList<String> list;
    static Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
    
    public static void main(String args[]){        
        sizew=(int)screenSize.width;
        sizeh=(int)screenSize.height;
        x=(sizew/2)-250;
        y=(sizeh/2)-250;
        new Register();
        new LoginPage();
        createPanel();    
         
        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
 
                int ans=JOptionPane.showConfirmDialog(f,"Are you sure you want exit?","Confirmation",JOptionPane.YES_NO_CANCEL_OPTION);
                switch(ans){
                    case JOptionPane.YES_OPTION:
                        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        break;
                    case JOptionPane.NO_OPTION:
                        f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                        break;
                    case JOptionPane.CANCEL_OPTION:
                        f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                        break;
                }
            }
        });
    }
      
    public static void createPanel(){
        
        p.setLayout(null);
        p.setSize(500,500);
        p.setBackground(Color.cyan);
        JLabel l1,l2,l3;
        Button b1,b2;

        f.setSize(screenSize.width,screenSize.height);
        p.setLocation(x,y);
        f.setLayout(null);
        String clear=new String("");
        b1=new Button("Login");
        b1.setBounds(300,300,100,50);
        b1.setFocusable(false);
        b1.setFont(new Font("Calibri",Font.PLAIN,16));
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                p.setVisible(false);
                LoginPage.tf.setText(clear);
                LoginPage.jpass.setText(clear);
                LoginPage.p1.setVisible(true);
            }
        });
        b2=new Button("Register");
        b2.setBounds(300,225,100,50);
        b2.setFocusable(false);
        b2.setFont(new Font("Calibri",Font.PLAIN,16));
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                p.setVisible(false);
                Register.p2.setVisible(true);
            }
        });
        l1=new JLabel("Welcome");
        l1.setFont(new Font("Calibri",Font.BOLD,24));
        l1.setBounds(215,80,100,50);
        l2=new JLabel("New User");
        l2.setFont(new Font("Calibri",Font.PLAIN,20));
        l2.setBounds(90,225,100,50);
        l3=new JLabel("Registered User");
        l3.setFont(new Font("Calibri",Font.PLAIN,20));
        l3.setBounds(90,300,200,50);

        p.add(l1);
        p.add(l2);
        p.add(b2);
        p.add(l3);
        p.add(b1);
        f.add(p);
        p.setVisible(true);
        f.setVisible(true);
    }

    public static void inst(){

        Main.f.add(p6);
        p6.setSize(Main.sizew,Main.sizeh);
        p6.setLayout(null);

        JLabel h,inst;
        JButton profile,assess;
        h=new JLabel("Instructions while Writing the Test",JLabel.CENTER);
        h.setFont(new Font("Calibri",Font.BOLD,24));
        h.setOpaque(true);
        h.setBounds((sizew-(sizew-30)),(sizeh-(sizeh-50)),(sizew-30),20);
        p6.add(h);

        String[] data={"Edit Profile","Logout"};
        list=new JList<>(data);
        list.setFocusable(true);
        list.setBounds(sizew-(sizew-1160),(sizeh-(sizeh-130)),100,60);
        list.setFont(new Font("Calibri",Font.PLAIN,14));
        list.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent le){
                try{
                    int selection=list.getSelectedIndex();
                    if(selection==0){
                        p6.setVisible(false);
                        Register.edit();
                    }

                    if(selection==1){
                        JFrame f1=new JFrame();
                        int ans=JOptionPane.showConfirmDialog(f1,"Do you want to logout?","Confirmation",JOptionPane.YES_NO_CANCEL_OPTION);
                        switch(ans){
                            case JOptionPane.YES_OPTION:
                                p6.setVisible(false);
                                p.setVisible(true);
                                break;
                            case JOptionPane.NO_OPTION:
                                break;
                            case JOptionPane.CANCEL_OPTION:
                                break;
                        }
                    }
                }
                catch(Exception ex){}
            }
        });
        p6.add(list);
        list.setVisible(false);
        
        profile=new JButton(new ImageIcon("profile.png"));
        profile.setBounds(sizew-(sizew-1200),(sizeh-(sizeh-80)),40,40 );
        profile.setFocusable(false);
        profile.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                list.setVisible(true);
            }
        });
        p6.add(profile);

        inst=new JLabel(); 
        inst.setText("<html><body><p>"+
        "-> Please note, you need to take the test at one single stretch. If you have logged into the test then complete your whole test as it is a timer-based test. <br><br>"+
        "-> You will have a set of 5 questions and the time provided to complete the assessment is 2 minutes. <br><br>"+
        "-> You need to attempt all questions before submitting the assessment. <br><br>"+
        "-> If you fail to submit the assessment before the timer out then the assessment will be auto submitted. <br><br>"+
        "-> It is important to have continuous internet and power backup while taking the test. <br><br>"+
        "-> Do not switch test window during the test. <br><br>"+
        "-> Make sure that you have correctly attempted all the questions before submission."+
        "</p> </body> </html>");
        inst.setFont(new Font("Calibri",Font.PLAIN,20));
        inst.setBounds((sizew-(sizew-30)),(sizeh-(sizeh-150)),(sizew-30),400);
        p6.add(inst);

        assess=new JButton("Take Assessment");
        assess.setBounds((sizew/2)-50,(sizeh-160),200,40);
        assess.setFocusable(false);
        assess.setFont(new Font("Calibri",Font.PLAIN,20));
        p6.add(assess);
        assess.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    p6.setVisible(false);
                    Exam.exam();
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        });
    }   
}
