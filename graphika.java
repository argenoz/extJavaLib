
package extJavaLib;
import java.awt.*;
import java.awt.Panel;
import extJavaLib.extNumLib.ExtNum;
import extJavaLib.extNumLib.ExtNumCalc;



public class graphika {
    
    public static class Graphika extends Frame
    {
    public Graphika()
    {
    setLayout(new FlowLayout());
   Panel  p=null;
   Button b;
   int i;
   p=new Panel();
   p.setLayout(new GridLayout(4,2));
    
    for(i=0;i<4;i=1+i)
    {
        p.add(new Button("nomer"+i+" "));
        p.add(new TextField());
    }
    this.add(p);
    p=new Panel();
   p.setLayout(new GridLayout());
    
    for(i=0;i<4;i=1+i)
        p.add(new Button("nomer"+i+" "));
    this.add(p);
    
   
   
    }
        
    }
    
public static void main(String[] vvv)
    {
    Graphika qwe=new Graphika();//extends Frame
    qwe.setSize(300, 300);
    System.out.print("1\n");
    qwe.setVisible(true);
    System.out.print("1\n");
    }
    
}
