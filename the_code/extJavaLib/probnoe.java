package extJavaLib;

import extJavaLib.baseBlockLib.*;
//import extJavaLib.extNumLib.ExtCASLib.ExtCASLibBaseTypes.ExtCASArray;
import extJavaLib.extNumLib.Ariphmetical;
import extJavaLib.extNumLib.ExtNum;
import extJavaLib.extNumLib.ExtNumCalc;

import extJavaLib.extNumLib.ariph.*;
import extJavaLib.extNumLib.ariph.ExtSpecifyNumbers.ExtFixedLenghtIntegerNumberClass;
import extJavaLib.extNumLib.ariph.ExtSpecifyNumbers.ExtFixedPointNumberClass;
import extJavaLib.extNumLib.ariph.ExtSpecifyNumbers.ExtFloatingPointNumberClass;
//import extJavaLib.extNumLib.ExtPointedNumber.ExtFixedPointNumberClass;

import extJavaLib.extStructLib.BaseExtStruct.*;

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
        ExtArray<Ariphmetical> q;
        Ariphmetical l = (new Ariphmetical(513)).cast(8),i,r,x,e;
        e = new Ariphmetical(5);
        e = e.cast(8);
        q = new ExtArray(new Ariphmetical(l));
        r = new Ariphmetical(17);
        r = r.cast(8);
        i = l;
        do
            {
             x = i;
             i = Ariphmetical.sub(i,Ariphmetical.E);
             x = Ariphmetical.pow(x, e);
             
             q.set(i, x);
            }
            while(!i.zero());
        i = Ariphmetical.N.cast(8);
        while(Ariphmetical.cmp(i,l)==1)
            {
            System.out.print(i+"\t"+q.get(i)+"\n");
            i = Ariphmetical.sum(i,Ariphmetical.E);
            }
        i = (new Ariphmetical(54)).cast(8);
        System.out.print(i+"\t"+q.get(i)+"\n");
        
    }
}


