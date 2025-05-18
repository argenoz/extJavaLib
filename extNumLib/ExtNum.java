
package extJavaLib.extNumLib;

import extJavaLib.extJavaLibInterfaces.Numerical;

import extJavaLib.extNumLib.ariph.*;
import extJavaLib.baseBlockLib.Trine;
import extJavaLib.baseBlockLib.Pair;
//import extJavaLib.extNumLib.ExtNumCalc;
//import  extJavaLib.extStringLib.ExtString.ExtChar;

public class ExtNum {
    protected ExtInteger ei;
    protected ExtSInteger esi;
    protected Racio r;
    
    public int type()
    { int otvet=0;
        // 0 - ExtInteger
        // 1 - ExtSInteger
        // 2 - Racio
    if(this.r!=null)
        otvet=2;
    else
        if(this.esi!=null)
            otvet=1;
        else otvet=0;
    return otvet;
    }
    
    public ExtNum(){this.ei=new ExtInteger(0); this.esi=null;this.r=null;}
    
    
    public Trine<ExtInteger,ExtSInteger,Racio> main()
    {//t1f9YbobJ57U8Y3RC6vHnvBmy9mfqizxEi3
    Trine<ExtInteger,ExtSInteger,Racio > m = new  Trine<ExtInteger,ExtSInteger,Racio >();   
			//t1f9YbobJ57U8Y3RC6vHnvBmy9mfqizxEi3
              //Trine<ExtInteger,ExtSInteger,Racio >
/*    if(this.ei!=null)
    m.first(this.ei);
    if(this.esi!=null)
    m.second(this.esi);
    if(this.r!=null)
    m.third(this.r);
*/
    if(this.ei!=null)
    m.first(new ExtInteger(this.ei));
	else
    if(this.esi!=null)
    m.second(new ExtSInteger(this.esi));
	else
    if(this.r!=null)
    m.third(new Racio(this.r));
    return m;
    }
	

    public  ExtNum(ExtInteger v)
    {
    this.ei=new ExtInteger(v);
    this.esi=null;this.r=null;
    }
    
    public ExtNum(ExtSInteger v)
    {
    this.esi=new ExtSInteger(v);
    this.ei=null;this.r=null;
    this.simp();}
    
    public ExtNum(Racio a)
    {
    this.r=new Racio(a);
    this.ei=null; this.esi=null;
    if(Racio.autoSimp) this.simp();}
    
    public ExtNum(int a)
    {
    this(new ExtSInteger(a));
    if(Racio.autoSimp) this.simp();
    }
    
    public ExtNum(int a, int b)
    {
    this(new Racio(a,b));
    if(Racio.autoSimp)this.simp();
    }
    
    public ExtNum(ExtInteger a, ExtInteger b)
    {
    this.r=new Racio(a,b);
    if(Racio.autoSimp) this.simp();
    }
    
    public ExtNum(ExtSInteger a, ExtInteger b)
    {
    this.r=new Racio(a,b);
    if(Racio.autoSimp) this.simp();
    }
    
    public ExtNum(ExtSInteger a, ExtSInteger b)
    {
    this.r=new Racio(a,b);
    if(Racio.autoSimp) this.simp();
    }
    public ExtNum(ExtInteger a, ExtSInteger b)
    {
    this.r=new Racio(a,b);
    if(Racio.autoSimp) this.simp();
    }
    
    
    public ExtNum(ExtNum a)
    {
    this.ei=null;
    this.esi=null;
    this.r=null;
    switch(a.type())
    {
        //case 0:{this.ei=new ExtInteger(a.)}
        case 0:{this.ei=(a.main().first());break;}
        case 1:{this.esi=(a.main().second());break;}
        case 2:{this.r=(a.main().third());break;}
    }
    }
    
    public int sign()
    {
    int ans=0;
    switch(this.type())
    {
        case 0: break;
        case 1: {ans=this.esi.sign(); break;}
        case 2:{ans=this.r.sign(); break;}
    }
    return ans;
    }
    
    public void sign(int s)
    {
    s=s%2;
    switch(this.type())
            {
            case 0:{if(s==1) {this.esi=new ExtSInteger(this.ei); this.ei=null; this.esi.sign(s);}  break;}
            case 1:{this.esi.sign(s); this.simp();break;}
            case 2:{this.r.sign(s);break;}
            }

    
    }
    
    
    public String soutput_()
    {
    String otv=null;
    switch(this.type())
        {
        case 0:{otv=this.ei.soutput_();break;}
        case 1:{{otv=this.esi.soutput_();break;}}
        case 2:{{otv=this.r.soutput_();break;}}
        }
    return otv;
    }
    
    public String soutput_10()
    {
    String otv=null;
    switch(this.type())
        {
        case 0:{otv=this.ei.soutput_10();break;}
        case 1:{{otv=this.esi.soutput_10();break;}}
        case 2:{{otv=this.r.soutput_10();break;}}
        }
    return otv;
    }
    
    
    public int simp()
    { 
    /*
    // abcdef
    // abc - bylo
    // def - stalo
    // ExtInteger -> ExtInteger otv=9
    // ExtSInteger -> ExtInteger otv=17
    // ExtSInteger -> ExtSInteger otv=18
    // Racio -> ExtInteger otv=33
    // Racio -> ExtSInteger otv=34
    // Racio -> Racio otv=36
    */
    int otv=9;
    switch(this.type())
        {
        case 0:{otv=9;break;}
        case 1: 
            {
            otv=16;
            if(this.esi.sign()%2==0)
                {otv=(otv|1);this.ei=new ExtInteger(this.esi.chains()); this.esi=null;}
            else otv=(otv|2);
            break;
            }
        case 2:
            {
            otv=32;
            this.r.simp();
            if(this.r.chains().second().srav(new ExtInteger(1))==0)
            {
            this.esi=new ExtSInteger(this.r.chains().first());
            this.r=null;
            if(this.esi.sign()%2==0)
                {otv=(otv|1);this.ei=new ExtInteger(this.esi.chains()); this.esi=null;}
            else otv=( otv|2);
            }
            else otv=(otv|4);
            break;
            }
        }
return otv;
    }//koenc simp
    
   
    
    /////////////////////////////////////////////////////////////////////////////////
    //opiations
    /////////////////////////////////////////////////////////////////////////////////
    
    public static ExtNum sum(ExtNum a, ExtNum b)
    {
    ExtNum r=null;
    ExtInteger pI=null;
    ExtSInteger pSI=null;
    Racio pR=null;
    a=new ExtNum(a);
    b=new ExtNum(b);
    
   switch(a.type())
   {
       case 0:
                {
                switch(b.type())
                    {
                    case 0:{ pI=new ExtInteger(a.main().first());pI.add(b.main().first());break; }
                    case 1:{ pSI=new ExtSInteger(a.main().first());pSI.add(b.main().second());break; }
                    case 2:{pR=new Racio(a.main().first()); pR.add(b.main().third());break;}
                    }
                
                break;}
       case 1:
       {
       switch(b.type())
        {
           case 0:{pSI=new ExtSInteger(b.main().first());   pSI.add(a.main().second());break;}
           case 1:{pSI=new ExtSInteger(b.main().second());   pSI.add(a.main().second());break;}
           case 2:{pR=new Racio(a.main().second());pR.add(b.main().third());break;}
       }
       
       break;}
       case 2:
       {
       switch(b.type())
        {
           case 0:{pR=new Racio(b.main().first());break;}
           case 1:{pR=new Racio(b.main().second());break;}
           case 2:{pR=new Racio(b.main().third());break;}
        }
       
       pR.add(a.main().third());
      
       break;}
   
   }//switch a.type()
   ETTO_pr:{
    if(pI!=null) {r=new ExtNum(pI);break ETTO_pr;}
    
    if(pSI!=null) {r=new ExtNum(pSI);break ETTO_pr;}
    
    if(pR!=null) {r=new ExtNum(pR);break ETTO_pr;}
   }
    r.simp();
    return r;
    }
    
    
    public static ExtNum sub(ExtNum a, ExtNum b)
    {
   // ExtInteger ei=null;
    ExtSInteger esi=null;
    Racio r=null;
    a=new ExtNum(a);b=new ExtNum(b);
    ExtNum otv=null;
ETTO:{
    b.sign((1+b.sign())%2);
    /*
   switch(b.type())
   	{
		case 0: {b.sign(1);  break ETTO;}
		case 1: //{ {esi=new ExtSInteger(b.main().second()); esi.sign((esi.sign()+1)%2); b=new ExtNum(esi);  break ETTO;}  }
                {b.sign((b.sign()+1)%2);break;}
                case 2: //{ b.main().third().chains().first().sign((1+b.main().third().chains().first().sign())%2);  break ETTO; }
                {
                System.out.print("promezh:"+b.main().third().chains().first().sign()+"\n\n");
                b.main().third().chains().first().sign((1+b.main().third().chains().first().sign())%2);
                b.main().third().sign((b.main().third().sign()+1)%2);
                System.out.print("promezh:"+b.main().third().chains().first().sign()+"\n\n");
//r=b.main().third();
                //r.chains().first().sign((1+r.chains().first().sign())%2);
                //b=new ExtNum(r);
                break;
                }
   
   }// of type a
*/
	}
        //System.out.print("promezh:"+b.soutput_10()+"\n\n");
   otv=ExtNum.sum(a, b);
    return otv;
    }
    
    public static ExtNum prod(ExtNum a, ExtNum b)
    {
    ExtInteger I2,I=null;
    ExtSInteger SI2,SI=null;
    Racio R=null,R2;
    a=new ExtNum(a);
    b=new ExtNum(b);
    ExtSInteger pr=null;
    Racio prr=null;
    etto:
        {
        switch(a.type())
        { 
            case 0:
                {I=a.main().first();
                switch(b.type())
                {
                    case 0:{
                        I2=b.main().first();
                        I.mul(I2);
                        a=new ExtNum(I);
                        break;
                        }
                    case 1:{
                            SI=b.main().second();
                            
                            SI.mul(I);
                            a=new ExtNum(SI);
                            break;
                            }
                    case 2:{
                            R=b.main().third();
                            R2=new Racio(I);
                            R.mul(R2);
                            a=new ExtNum(R);
                            break;
                         } 
                }
                
                break;}
                
               
            case 1:
                { SI=a.main().second();
                switch(b.type())
                {
                    case 0:{
                            I=b.main().first();
                            SI.mul(I);
                            a=new ExtNum(SI);
                            break;
                            }
                    case 1:{
                            SI2=b.main().second();
                            SI.mul(SI2);
                            a=new ExtNum(SI);
                            break;}
                    case 2:{
                            R=b.main().third();
                            R.mul(new Racio(SI));
                            a=new ExtNum(R);
                            break;}
                    
                }
                break;}
            case 2:
                {R=a.main().third();
                switch(b.type())
                {
                    case 0:{
                            I=b.main().first();
                            R2=new Racio(I);
                            R.mul(R2);
                            a=new ExtNum(R);
                            break;}
                    case 1:{
                            SI=b.main().second();
                            R2=new Racio(SI);
                            R.mul(R2);
                            a=new ExtNum(R);
                            break;}
                    case 2:{
                            R2=b.main().third();
                            R.mul(R2);
                            a=new ExtNum(R);
                            break;}
                }
                
               break; }
        
        
        
        }
        }
    //a.simp();
    return a;
    
    }

    public static ExtNum div(ExtNum a, ExtNum b)
    {
    a=new ExtNum(a);
    b=new ExtNum(b);
    switch(b.type())
        {
        case 0:
            {
            b=new ExtNum(ExtInteger.E,b.main().first());
            break;
            }
        case 1:
            {
            b=new ExtNum(ExtInteger.E,b.main().second());
            break;
            }
        case 2:
            {
            Racio vsp=new Racio(1,1);
            vsp.div(b.main().third());
            b=new ExtNum(vsp);
            break;
            }
        }
    
    ExtNum ans=null;
   // a.simp();
   // b.simp();
    ans=prod(a,b);
    return ans;
    }


    public boolean zero()
    	{ boolean otv=false;
	switch(this.type()){
		case 0: {otv=(0==this.main().first().zero());break;}
		case 1: {otv=(0==this.main().second().zero());break;}
		case 2: {otv=(0==this.main().third().chains().first().zero());break;}
	}
	return otv;
	
	}

    public static int cmp(ExtNum a, ExtNum b)
    	{
	a=new ExtNum(a);
	b=new ExtNum(b);
		int otv=0;
	b=ExtNum.sub(a,b);
	b.simp();
	if(b.zero())
		otv=3;
	else
		switch(b.type())
			{
				case 0:{ if(b.main().first().zero()==0) otv=3; else otv=2; break;}
				case 1:{ if(b.main().second().sign()%2==0) otv=2; else otv=1; break; }
				case 2:{	
					Racio vsp1=b.main().third();
					if(vsp1.chains().first().sign()%2==0) otv=2;
					else otv=1;
					       break;
					}
			}	
	
	return otv;
	}

//////////////////////////

public String toString()
{
return this.soutput_10();
}

public String toString_()
{
return this.soutput_();
}

public long to_long()
{
long ans=0;
switch(this.type())
{
    case 0:
    {
    ans=this.ei.to_long();
    break;
    }
    case 1:
    {
    ans=this.esi.to_long();
    break;
    }
    /*
    case 2:
    {
    ans=this.r.to_long();
    break;
    }*/
    default:
    {
    ans=0;
    break;
    }

}

return ans;
}


public double to_double()
{
double ans=0;
switch(this.type())
{
    case 0:
    {
    ans=this.ei.to_long();
    break;
    }
    case 1:
    {
    ans=this.esi.to_long();
    break;
    }
    case 2:
    {
    ans=this.r.to_double();
    break;
    }
}

return ans;
}


}
