package extJavaLib;

import extJavaLib.extNumLib.ExtCASLib.ExtCASLibBaseTypes.ExtCASNum;
import extJavaLib.extStructLib.ExtVector;
import extJavaLib.extNumLib.ExtCASLib.ExtCASLibBaseTypes.ExtCASDeductionClass;
import extJavaLib.extNumLib.ExtNum;
import extJavaLib.extNumLib.ExtNumCalc;
        
public class probnoe {
    
//    public native void  vsp();
  public class nuzhnoe
    {
      private int g;
      private int vsp;
      public nuzhnoe(){g=0;}
      public int get(){return this.g;}
      public void set(int v) {this.g=v;}
      public void outSet(){vsp=g;}
    }
    public int vsp;
    public probnoe(){vsp=123;}
    public static void main(String[]strig___)
    {
        ExtCASNum a,n,res;
        a=new ExtCASNum(2);
        n=new ExtCASNum(128);
        res= ExtCASNum.pow(a,n);
        System.out.print(a+"^"+n+"=\n"+res+"\n\n");
        n=new ExtCASNum(1,64);
        a= ExtCASNum.pow(res,n);
        System.out.print(res+"^("+n+")=\n"+a+"\n\n");
        
    }
}



interface intir
    {
    public int dai();
    }

