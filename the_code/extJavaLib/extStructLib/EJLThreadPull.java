package extJavaLib.extStructLib;

import extJavaLib.baseBlockLib.ChainStack;
import extJavaLib.extStructLib.BaseExtStructs.ExtQueue;
import extJavaLib.extNumLib.Ariphmetical;

import java.lang.Thread;
import java.lang.Runnable;
import java.lang.Exception;


import extJavaLib.extJavaLibExceptions.ExtJavaLibExceptions.ExtJavaLibBaseException;


public class EJLThreadPull
{
    private static final Ariphmetical dss = (new Ariphmetical(2)).cast(8);
    private char actual;
    private Ariphmetical ss;
    //ChainStack<EJLWork> st;
    ExtQueue<EJLWork> st;
    //ChainStack<Thread> stth;
    ChainStack<EJLThread> stth;
    public EJLThreadPull()
            {
            this.actual = 0;
            this.st = new ExtQueue<>();
            this.ss = dss;
            this.stth = null;//new ExtQueue<>();
            //throw new ExtJavaLibBaseException("Need an argument");
            }
    
    public EJLThreadPull(Ariphmetical ss)
        {
        this();
        if(ss==null)
            throw new ExtJavaLibBaseException("Null Argument is forbidden.");
        if(ss.type()!=8)
            throw new ExtJavaLibBaseException("Only ExtInteger subtype is not forbidden.");
        this.ss = new Ariphmetical(ss);
        }
    public EJLThreadPull(Ariphmetical ss,char acti)
        {
        this();
        if(ss==null)
            throw new ExtJavaLibBaseException("Null Argument is forbidden.");
        if(ss.type()!=8)
            throw new ExtJavaLibBaseException("Only ExtInteger subtype is not forbidden.");
        this.ss = new Ariphmetical(ss);
        this.actual = (char)(acti<<2);
        }
    public EJLThreadPull(char acti)
        {
        this();
        this.actual = (char)(acti<<2);
        }
    
    
    public void begin()
        {
        if((this.actual&2)==0)
            this.actual = (char) (this.actual|2);
        else
            throw new ExtJavaLibBaseException("This EJLThreadPull work is already started.");
        Ariphmetical i = this.ss,E=Ariphmetical.E.cast(8);
        EJLThread tr=null;
        ChainStack<EJLThread> st_;
        this.stth = null;
        do
            {
            i = Ariphmetical.sub(i,E);
            tr = new EJLThread();
            tr.start();
            st_ = new ChainStack<>();
            st_.next(stth);
            stth = st_;
            stth.set(tr);
            /*tr = new Thread(
                        ()
                                ->
                                {
                                EJLWork w=null;
                                
                                do
                                    {
                                        
                                        if((this.actual&1)==0||(this.actual&4)!=0)
                                            synchronized(this) 
                                                    {
                                                    if(this.st.ifEmpty())
                                                        if((this.actual&4)!=4)
                                                            w = null;
                                                        else break;
                                                    else
                                                        w = this.st.pop();
                                                    }
                                        else break;
                                        //if(w==null)
                                        //    System.out.print("___\n");
                                        try{
                                        if(w==null){
                                            Thread.sleep(1000L);}
                                        else
                                        {w.run();}
                                        
                                        }
                                        
                                        catch(Exception e)
                                        {
                                        throw new ExtJavaLibBaseException("Beda");
                                        }
                                        
                                    }
                                while(true);
                                System.out.print("Vyhod\n");
                                }
                        );
            this.stth.push(tr);
            tr.start();
            */
            }
        while(!i.zero());
        }
    
    public void stop()
        {
            synchronized(this)
            {
            this.actual = (char)(this.actual|1);
            }
        }
    
  
    
    
    public synchronized  void push(EJLWork w)
            {
            //synchronized(this)
                {
                this.st.push(w);
                }
            }
    
    public void finalize()
        {
        this.stop();
        //System.out.print("srabotalo\n");
        extJavaLib.probnoe.o = null;
        }
    
    
    public boolean isRunning()
        {
        ChainStack<EJLThread> tr = this.stth,trr=null;
        while(tr!=null)
            if(tr.get().isAlive())
            {this.stth=tr = tr.next();}
            else
                break;
        return (tr!=null);
        }
    
    
    public static interface EJLWork extends Runnable
                {
                
                }
    
    private class EJLThread extends Thread 
        {
        public EJLThread()
            { 
            super(
                    ()->
                    {
                    EJLWork w=null;
                    do
                        { 
                        //if((EJLThreadPull.this.actual&1)==0||(EJLThreadPull.this.actual&4)!=0)
                        if((EJLThreadPull.this.actual&1)==1)
                            if((EJLThreadPull.this.actual&4)==0)
                                break;
                            synchronized(EJLThreadPull.this)
                                {
                                if(EJLThreadPull.this.st.ifEmpty())
                                    {
                                    //System.out.print("II");
                                    if((EJLThreadPull.this.actual&1)==0)
                                        w = null;
                                    else break;
                                    }
                                else
                                    w = EJLThreadPull.this.st.pop();
                                }
                        //else break;
                        try{
                                        if(w==null){
                                            Thread.sleep(500L);}
                                        else
                                        {
                                            w.run();}
                                        
                                        }
                                        
                                        catch(Exception e)
                                        {
                                        throw new ExtJavaLibBaseException("Beda");
                                        }
                        }
                    while(true);
                    }
                );
            }
        
        
        }
    
}
