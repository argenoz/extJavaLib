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
import extJavaLib.extStringLib.ExtString;
import extJavaLib.extStructLib.BaseExtStructs.*;


import java.lang.Runnable;


import extJavaLib.extStructLib.EJLThreadPull;
import extJavaLib.extStructLib.EJLThreadPull.EJLWork;
public class probnoe {
    public static Object o;
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
    
    
    
    public static void main2(String[]strig___)
    {
        ExtArray<Ariphmetical> q;
        Ariphmetical x,y,z,i,j,k,a,b,c,E,e1,e2,e3,N,k1,k2;
        ExtTuple<ExtString> tpl;
        q = new ExtArray((new Ariphmetical(2)).cast(8));
        x = (new Ariphmetical(5)).cast(8);
        y = (new Ariphmetical(7)).cast(8);
        z = (new Ariphmetical(3)).cast(8);
        k1 = (new Ariphmetical(0)).cast(8);
        k2 = (new Ariphmetical(1)).cast(8);
        q.set((new Ariphmetical(0)).cast(8),x);
        q.set((new Ariphmetical(1)).cast(8),y);
        //q.set((new Ariphmetical(2)).cast(8),z);
        E = Ariphmetical.E;
        e1 = (new Ariphmetical(-4)).cast(10);
        e2 = (new Ariphmetical(2)).cast(8);
        e3 = (new Ariphmetical(14)).cast(8);
        tpl = new ExtTuple(q);
        N=i = j = k = Ariphmetical.N.cast(8);
        while(Ariphmetical.cmp(x,i)==2)
            {
            //a = Ariphmetical.sum(E,i);
            //a = Ariphmetical.pow(a, e1);
            j = N;
            while(Ariphmetical.cmp(y,j)==2)
                {
                    //b = Ariphmetical.sum(a,Ariphmetical.prod(j,new Ariphmetical(3)));
                    q.set(k1,i);
                    q.set(k2,j);
                    //tpl.set(q,b);
                    tpl.set(q,
                            new ExtString(
                            "("+i.toString()+";"
                                    +j.toString()+")"
                            )
                            );
                    j = Ariphmetical.sum(j,E);    
                }
            i = Ariphmetical.sum(i,E);
            }
        i = N;
        while(Ariphmetical.cmp(x,i)==2)
            {
            j = N;
            while(Ariphmetical.cmp(y,j)==2)
                {
                    q.set(k1,i);
                    q.set(k2,j);
                    //a=tpl.get(q);
                    
                    System.out.print(tpl.get(q).toString()+"\t");
                    j = Ariphmetical.sum(j,E);    
                }
            System.out.print("\n");
            i = Ariphmetical.sum(i,E);
            }
    }
    
    public static void main(String[] string) throws Exception
        {
        EJLThreadPull pull;
        Ariphmetical i,j,k,N,E,s,a,b;
        //pull = new EJLThreadPull((new Ariphmetical(5)).cast(8),(char)1);
        k = new Ariphmetical(16);
        N = Ariphmetical.E.cast(8);
        k = k.cast(8);
        E = N;
        i = Ariphmetical.N.cast(8);
        N = i;
        pull=new EJLThreadPull((new Ariphmetical(3)).cast(8),(char)1);
        pull.begin();
        Nuzhn.o = N;
        s = new Ariphmetical(43);
        i=N;
        while(true)
            {
            i = Ariphmetical.sum(E,i);
            j = E;
            while(true)
                {
                //pull.push(new Nuzhn(Ariphmetical.sum(s,i),j,i,j));
                pull.push(new Nuzhn(i,j,i,j));
                if(Ariphmetical.cmp(j,k)==3) break;
                else
                    j = Ariphmetical.sum(E,j);
                synchronized(N)
                    {
                    System.out.print("***"+i+" "+j+"zakinut v pull raboty\n");
                    }
                }
            
            if(Ariphmetical.cmp(i,k)==3) break;
            }
        
        o = N;
        pull.stop();
        //pull = null;
        while(pull.isRunning())
            {
        Thread.sleep(500L);
        //System.gc();
            //N = new Ariphmetical(9);
            //N = N.cast(8);
            //N = Ariphmetical.pow(N,N);
            //N = Ariphmetical.pow(N,N);
            }
        }
    
    
    
}

class Nuzhn implements EJLWork
    {
    public static Object o;
    private Ariphmetical a,b,i,j;
    public Nuzhn(Ariphmetical a, Ariphmetical b,Ariphmetical i, Ariphmetical j)
        {
        this.a = a;
        this.b = b;
        this.i = i;
        this.j = j;
        }
    @Override
    public void run()
        {
        //synchronized(o)
        //{
        //System.out.print("potok"+i+" "+j+"nachal raboty\n");
        //}
        String str;
        a = (new Ariphmetical(a)).cast(8);
        b = (new Ariphmetical(b)).cast(8);
        a = Ariphmetical.pow(a,b);
        a = Ariphmetical.pow(a,(new Ariphmetical(12)).cast(8));
        //a = Ariphmetical.pow(a,a);
        str = "from"+i+" "+j+"\t"+a+"\n";
        synchronized(o)
        {
        System.out.print(str);
        }
        }
    
    }


