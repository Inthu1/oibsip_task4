import javax.swing.*;

class Timer extends Thread {     
    public void run(){
        try{
            int i,j,m,s;
            m=1;s=60;i=m;j=s;
            for(i=m;i>=0;i--){
                for(j=s;j>=0;j--){
                    if(Exam.temp==true) break;
                    String str=i+" : "+j+"  ";
                    Exam.jl.setText(str);
                    sleep(1000);
                    Exam.p3.repaint();
                }
            }  
            if(Exam.temp==false)
            {
            JFrame f1=new JFrame();
            JOptionPane.showMessageDialog(f1,"Time out! Assessment is auto submitted. Thanks for taken the Java Assessment.","ThankYou",JOptionPane.INFORMATION_MESSAGE);
            Exam.p5.setVisible(false);
            Exam.score();     
            }
        }
        catch(Exception e){}
    }
}
