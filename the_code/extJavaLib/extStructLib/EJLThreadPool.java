package extJavaLib.extStructLib;

import extJavaLib.baseBlockLib.ChainStack;
import extJavaLib.extStructLib.BaseExtStructs.*;

import extJavaLib.extNumLib.Ariphmetical;

import java.lang.Thread;
import java.lang.Runnable;
import java.lang.Exception;


import extJavaLib.extJavaLibExceptions.ExtJavaLibExceptions.ExtJavaLibBaseException;


public class EJLThreadPool
{
    private static final Ariphmetical dss = (new Ariphmetical(2)).cast(8);
    private char actual;
    private Ariphmetical ss;
    //ChainStack<EJLWork> st;
    ExtQueue<Runnable> st;
    //ChainStack<Thread> stth;
    ChainStack<Thread> stth;
    public EJLThreadPool()
            {
            this.actual = 0;
            this.st = new ExtQueue<>();
            this.ss = dss;
            this.stth = null;//new ExtQueue<>();
            //throw new ExtJavaLibBaseException("Need an argument");
            }
    
    public EJLThreadPool(Ariphmetical ss)
        {
        this();
        if(ss==null)
            throw new ExtJavaLibBaseException("Null Argument is forbidden.");
        if(ss.type()!=8)
            throw new ExtJavaLibBaseException("Only ExtInteger subtype is not forbidden.");
        this.ss = new Ariphmetical(ss);
        }
    public EJLThreadPool(Ariphmetical ss,char acti)
        {
        this();
        if(ss==null)
            throw new ExtJavaLibBaseException("Null Argument is forbidden.");
        if(ss.type()!=8)
            throw new ExtJavaLibBaseException("Only ExtInteger subtype is not forbidden.");
        this.ss = new Ariphmetical(ss);
        this.actual = (char)(acti<<2);
        }
    public EJLThreadPool(char acti)
        {
        this();
        this.actual = (char)(acti<<2);
        }
    
    
    public synchronized void begin()
        {
        if((this.actual&1)==0)
            this.actual = (char) (this.actual|1);
        else
            throw new ExtJavaLibBaseException("This EJLThreadPull work is already started.");
        Ariphmetical i = this.ss,E=Ariphmetical.E.cast(8);
        Thread tr=null;
        ChainStack<Thread> st_;
        this.stth = null;
        do
            {
            i = Ariphmetical.sub(i,E);
            tr = new Thread(
                        ()
                                ->
                                {
                                int flg;
                                Runnable w;
                                while(true)
                                if((flg=((EJLThreadPool.this.actual>>1)&3))==3)
                                    return;
                                else
                                    {
                                    synchronized(EJLThreadPool.this)
                                        {
                                        if(EJLThreadPool.this.st.ifEmpty())
                                            if(flg==1)
                                                return;
                                            else
                                                w = null;
                                        else
                                            w = EJLThreadPool.this.st.pop();
                                        }
                                    try {
                                    if(w==null)
                                        Thread.sleep(1000L);
                                    else
                                        w.run();
                                        }
                                    catch(Exception e) 
                                        {
                                        ExtJavaLibBaseException exp = new ExtJavaLibBaseException("Some went wrong",11);
                                        exp.setException(e);
                                        throw exp;
                                        }
                                    }
                                }
                            );
            tr.start();
            st_ = new ChainStack<>();
            st_.next(stth);
            stth = st_;
            stth.set(tr);
            
            }
        while(!i.zero());
        }
    
    public  void stop()
        {
            synchronized(this)
            {
            this.actual = (char)(this.actual|2);
            }
        }
    
  
    
    
    public   void push(Runnable w)
            {
            synchronized(this)
                {
                this.st.push(w);
                }
            }
    
    public void finalize()
        {
        this.stop();
        //System.out.print("srabotalo\n");
        //extJavaLib.probnoe.o = null;
        }
    
    
    public  boolean isRunning()
        {
        ChainStack<Thread> tr = this.stth,trr=null;
        while(tr!=null)
            if(tr.get().isAlive())
                //tr = tr.next();
                tr = (trr = tr).next();
            else
            {
                if((this.actual&2)!=0)
                    if(trr==null)
                        this.stth = tr.next();
                    else
                        trr.next(tr.next());
                    
                return true;
            
            }   
        return false;
        //return (tr!=null);
        }
    
    
    
    
}
