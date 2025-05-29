package extJavaLib;

import extJavaLib.extNumLib.ExtCASLib.ExtCASLibBaseTypes.ExtCASNum;
import extJavaLib.baseBlockLib.*;
//import extJavaLib.extNumLib.ExtCASLib.ExtCASLibBaseTypes.ExtCASArray;
import extJavaLib.extStructLib.ExtVector;
import extJavaLib.extNumLib.Ariphmetical;
import extJavaLib.extNumLib.ExtCASLib.ExtCASLibBaseTypes.ExtCASDeductionClass;
import extJavaLib.extNumLib.ExtNum;
import extJavaLib.extNumLib.ExtNumCalc;


import extJavaLib.extNumLib.ExtPointedNumber.ExtFixedPointNumberClass;



public class probnoe {
    
//    public native void  vsp();
  public class nuzhnoe1
    {
      private int g;
      private int vsp;
      public nuzhnoe1(){g=0;}
      public int get(){return this.g;}
      public void set(int v) {this.g=v;}
      public void outSet(){vsp=g;}
    }
    
    public class nuzhnoe2 extends nuzhnoe1
    {
      private int h;
      public nuzhnoe2(){super.g=0;}
      public nuzhnoe2(int gg){super.g=gg;}
      public int get(){return super.g;}
      public void set(int v) {super.g=v;}
      
    }
    
    public int vsp;
    public probnoe(){vsp=123;}
    public static void main(String[]strig___)
    {
        ExtFixedPointNumberClass bb = new
            ExtFixedPointNumberClass();
        ExtFixedPointNumberClass.ExtFixedPointNumber a,b,c;
        a = bb.new ExtFixedPointNumber(new ExtNum(-123,10));
        System.out.print(a.toExtNum()+"\n");
        
        
        /*
        System.out.print(extJavaLib.extNumLib.ExtCASLib.ExtCASLibBaseTypes.FixedPointNumberClass.OneExtChar+"\n\n");
        System.exit(0);
        ExtCASDeductionClass dc=new ExtCASDeductionClass(7);
        ExtCASDeductionClass.ExtCASDeduction d=dc.new ExtCASDeduction(new ExtCASNum(4));
        ExtVector<Ariphmetical> tps=d.getTypeRoad();
        Ariphmetical a,i=Ariphmetical.N,l=tps.len();
        while(Ariphmetical.cmp(i,l)!=3)
            {
            a=tps.get(i);
            System.out.print(a+"\n");
            i=Ariphmetical.sum(i,Ariphmetical.E);
            }
        System.out.print("______________________________\n");
        */
        
        /*
        probnoe t=new probnoe();
        probnoe.nuzhnoe2 e=t.new nuzhnoe2(-213);
        probnoe.nuzhnoe1 e2;
        System.out.print(e.get()+"\n");
        System.out.print((e instanceof probnoe.nuzhnoe2)+"\n");
        e2=e;
        System.out.print((e2 instanceof probnoe.nuzhnoe2)+"\n");
        System.out.print((e2 instanceof probnoe.nuzhnoe1)+"\n");
        */
        /*
        ExtCASNum a,n,res,svn=new ExtCASNum(17),dv=new ExtCASNum(3);
        ExtCASArray<ExtCASNum> ar;
        n=new ExtCASNum(10);
        ar=new ExtCASArray<>(n);
        a=ExtCASNum.N;
        while(true)
            {
            if(3==ExtCASNum.cmp(a,n)) break;
            res=new ExtCASNum(a);
            res=res.toDefaultType();
            res=ExtCASNum.div(res,svn);
            res=ExtCASNum.pow(res, dv);
            System.out.print(res+"**\t");
            System.out.print("___"+a+"\n");
            ar.set(a, res);
            a=ExtCASNum.sum(a, ExtCASNum.E);
            }
        
        System.out.print(ar.get(new ExtCASNum(5)));
        */
        
    }
}



interface intir
    {
    public int dai();
    }

