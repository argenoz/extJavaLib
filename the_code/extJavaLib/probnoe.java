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


import java.util.concurrent.CompletableFuture;

import java.lang.Runnable;


import extJavaLib.extStructLib.EJLThreadPool;
//import extJavaLib.extStructLib.EJLThreadPool.EJLWork;
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
    
    public static synchronized void vyvod(String s)
        {
        System.out.print(s);
        
        }
    
    
    public static void main(String[] args)
        {
        Ariphmetical q,E,N,dims_ = (new Ariphmetical(3)).cast(8),chsl=(new Ariphmetical(14)).cast(8);
        Ariphmetical[] s,d,i=new Ariphmetical[dims_.toInteger()];
        ExtTuple<Ariphmetical> t;
        ExtArray<Ariphmetical> dims=new ExtArray<>(dims_);
        i[0] = dims_;
        do
            {
                i[0] = Ariphmetical.sub(i[0],Ariphmetical.E);
                dims.set(i[0],chsl);
            }
        while(!i[0].zero());
        args = new String[1];
        t = new ExtTuple<>(dims);
        E = Ariphmetical.E.cast(8);
        N = Ariphmetical.N.cast(8);
        d = new Ariphmetical[dims_.toInteger()];
        s = new Ariphmetical[dims_.toInteger()];
        d[0] = (new Ariphmetical(1)).cast(8);
        d[1] = (new Ariphmetical(1000)).cast(8);
        d[2] = (new Ariphmetical(1000000)).cast(8);
        i[0] = N;
        while(Ariphmetical.cmp(i[0],chsl)==1)
            {
            i[1] = N;
            d[0] = i[0];
            System.out.print(i[0]+"\n");
            dims.set((new Ariphmetical(0)).cast(8),i[0]);
                while(Ariphmetical.cmp(i[1],chsl)==1)
                    {
                    System.out.print("\t"+i[1]+"\n");
                    d[1] = Ariphmetical.prod((new Ariphmetical(1000)).cast(8),i[1]);
                    d[1] = Ariphmetical.prod(d[1],new Ariphmetical(2));
                    d[1] = Ariphmetical.sum(d[1],d[0]);
                    i[2] = N;
                    dims.set((new Ariphmetical(1)).cast(8),i[1]);
                    while(Ariphmetical.cmp(i[2],chsl)==1)
                        {
                        d[2] = Ariphmetical.prod((new Ariphmetical(1000000)).cast(8),i[2]);
                        d[2] = Ariphmetical.prod(d[2],new Ariphmetical(3));
                        d[2] = Ariphmetical.sum(d[1],d[2]);
                        System.out.print("\t\t"+i[2]+"\n");
                        dims.set((new Ariphmetical(2)).cast(8),i[2]);
                        t.set(dims, d[2]);
                        
                        i[2] = Ariphmetical.sum(E,i[2]);
                        }
                    i[1] = Ariphmetical.sum(E,i[1]);
                    }
            i[0] = Ariphmetical.sum(E,i[0]);    
            }
        i[0] = N;
        while(Ariphmetical.cmp(i[0],chsl)==1)
            {
            i[1] = N;
            //d[0] = i[0];
            //System.out.print(i[0]+"\n");
            dims.set((new Ariphmetical(0)).cast(8),i[0]);
                while(Ariphmetical.cmp(i[1],chsl)==1)
                    {
                    //System.out.print("\t"+i[1]+"\n");
                    //d[1] = Ariphmetical.prod((new Ariphmetical(1000)).cast(8),i[1]);
                    //d[1] = Ariphmetical.sum(d[1],d[0]);
                    i[2] = N;
                    dims.set((new Ariphmetical(1)).cast(8),i[1]);
                    while(Ariphmetical.cmp(i[2],chsl)==1)
                        {
                        //d[2] = Ariphmetical.prod((new Ariphmetical(1000000)).cast(8),i[2]);
                        //d[2] = Ariphmetical.sum(d[1],d[2]);
                        //System.out.print("\t\t"+i[2]+"\n");
                        dims.set((new Ariphmetical(2)).cast(8),i[2]);
                        q=t.get(dims);
                        args[0] = i[2].toString()+" "+i[1].toString()+" "
                                +
                                i[0].toString()+"->"+
                                q.toString()+"\n";
                        System.out.print(args[0]);
                        i[2] = Ariphmetical.sum(E,i[2]);
                        }
                    i[1] = Ariphmetical.sum(E,i[1]);
                    }
            i[0] = Ariphmetical.sum(E,i[0]);    
            }
        
        
        }
    
    
    public static void mainw(String[] string) throws Exception
        {
            EJLThreadPool p;
            Ariphmetical a,b,c,i,j,Q;
            a = new Ariphmetical(4);
            a = a.cast(8);
            p = new EJLThreadPool(a,(char)0);
            p.begin();
            Q = new Ariphmetical(15);
            Q = Q.cast(8);
            i = Q;
            while(!i.zero())
                {
                j = Q;
                while(!j.zero())
                    {
                    p.push(
                           new Nuzn(i,j)     
                            );
                    j = Ariphmetical.sub(j,Ariphmetical.E);
                    }
                
                //System.out.print("__\n");
                i = Ariphmetical.sub(i,Ariphmetical.E);
                }
            p.stop();
            //System.out.print(p.isRunning()+"__\n");
            while(p.isRunning())
                Thread.sleep(1000L);
            
        }
    
    public static class Nuzn implements Runnable
            {
            private Ariphmetical i,j;
            Nuzn(Ariphmetical i,Ariphmetical j)
                {
                this.i = i;
                this.j = j;
                }
            public void run()
                {
                Ariphmetical t = Ariphmetical.pow(Ariphmetical.pow(i,i),j);
                String str = i.toString()+"  "+j.toString()+"\t"+t.toString()+"\n";
                probnoe.vyvod(str);
                }
            
            }
    
    
    
}


    


