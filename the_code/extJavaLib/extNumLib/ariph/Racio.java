package extJavaLib.extNumLib.ariph;

import extJavaLib.extNumLib.ariph.ExtSInteger;
//import extJavaLib.extNumLib.ariph.ExtInteger.Base_n;
import extJavaLib.extNumLib.ariph.ExtInteger;
import extJavaLib.baseBlockLib.ChainDqueue;
import extJavaLib.baseBlockLib.Pair;
import extJavaLib.baseBlockLib.Trine;
import java.lang.Math;


public final class Racio
{
public static final boolean autoSimp,qqq,qqqq;
public static final Racio epsi,xi,E,N,E_;
public static final long n_d=12;
static
{
qqqq=true;
E=new Racio(1,1);
E_=new Racio(-1,1);
N=new Racio(0,1);
autoSimp=true;
qqq=true;
epsi=new Racio(1,100);
xi=new Racio(1,100);
}

protected ExtSInteger z;
protected ExtInteger n;

public Racio(){this.z=new ExtSInteger(0); this.n=new ExtInteger(1);}


public Racio(float f)
{
long j,i=n_d+1,mn=(1<<16);
double d;
d=f;

Racio r1,r2,r3,r4;
r1=new Racio(0,1);
//r2=new Racio(1,(int)mn);
r2=new Racio(1,mn);
r4=new Racio(1,1);
while(i>0)
    {
    i=i-1;
    r3=new Racio(r4);
    j=(long)Math.floor(d);
    r3.mul(new Racio(j,1));
    r1.add(r3);
    d=(d-j)*mn;
    r4.mul(r2);
    }

this.z=r1.chains().first();
this.n=r1.chains().second();

}

public Racio(double d)
{
long j,i=n_d+1,mn=(1<<16);
Racio r1,r2,r3,r4;
r1=new Racio(0,1);
//r2=new Racio(1,(int)mn);
r2=new Racio(1,mn);
r4=new Racio(1,1);
while(i>0)
    {
    i=i-1;
    r3=new Racio(r4);
    j=(long)Math.floor(d);
    r3.mul(new Racio(j,1));
    r1.add(r3);
    d=(d-j)*mn;
    r4.mul(r2);
    }

this.z=r1.chains().first();
this.n=r1.chains().second();

}



public Racio(long a, long b)
{
if(a*b<0)
    if(a<0)
        {
        this.z=new ExtSInteger(a);
        this.n=new ExtInteger(b);
        }
    else
        {
        this.z=new ExtSInteger(0-a);
        this.n=new ExtInteger(0-b);
        }
else
    if(a>0)
        {
        this.z=new ExtSInteger(a);
        this.n=new ExtInteger(b);
        }
    else
        if(a!=0 && b!=0)
        {
        this.z=new ExtSInteger(0-a);
        this.n=new ExtInteger(0-b);
        }
        else
        {
        this.z=new ExtSInteger(0);
        this.n=new ExtInteger();
        }

}

public Racio(int a, int b)
{
if(a*b==0)
    {
    Pair<ExtSInteger,ExtInteger> vsp=(new Racio()).chains();
    this.z=vsp.first();
    this.n=vsp.second();
    }
else
    {
    Pair<ExtSInteger,ExtInteger> vsp=(new Racio(new ExtSInteger(a),new ExtSInteger(b))).chains();
    this.z=vsp.first();
    this.n=vsp.second();
    }
if(Racio.autoSimp) this.simp();}

public  Racio(ExtSInteger a, ExtSInteger b)
        {
        this.z=new ExtSInteger(a);
        if((z.sign()+b.sign())%2==0) this.z.sign(0);
        else this.z.sign(1);
        this.n=new ExtInteger(b.chains());
if(Racio.autoSimp) this.simp();        }

public Racio (ExtSInteger a, ExtInteger b)
{
this.z=new ExtSInteger(a);
this.n=new ExtInteger(b);
if(Racio.autoSimp) this.simp();
}

public Racio(int a)
{this(a,1);}

public Racio(ExtInteger a, ExtSInteger b)
{
this.z=new ExtSInteger(a);
this.z.sign(b.sign());
this.n=new ExtInteger(b.chains());
if(Racio.autoSimp) this.simp();
}

public Racio(ExtInteger a, ExtInteger b)
{
this(new ExtSInteger(a),b);
}

public Racio(ExtInteger a)
{
this(new ExtSInteger(a));
//this.z=new ExtSInteger(a);
//this.n=new ExtInteger(1);
}



public Racio(ExtSInteger a)
{
this(a,new ExtInteger(1));
}



public Racio(Racio a)
{
Pair<ExtSInteger,ExtInteger> w=a.chains();
this.z=new ExtSInteger(w.first());
this.n=new ExtInteger(w.second());
}

public Pair<ExtSInteger,ExtInteger> chains()
{
Pair<ExtSInteger,ExtInteger> qew=new Pair<ExtSInteger,ExtInteger>();
//qew.first(this.z);
//qew.second(this.n);
qew.first(new ExtSInteger(this.z));
qew.second(new ExtInteger(this.n));
return qew;
}

public int sign(){return this.z.sign();}
public void sign(int s){this.z.sign(s);}

public static int srav(Racio a, Racio b)
	{
	int ans=0;
	ExtSInteger vsp=null;
	a=new Racio(a);
	a.sub(b);
	a.simp();
	vsp=a.chains().first();
	if(vsp.zero()==0)
		ans=3;
	else
		if(vsp.sign()%2==0) ans=2;
		else ans=1;
	return ans;
	}

public Racio abso()
	{
	Racio w=null;
	Pair<ExtSInteger,ExtInteger> vsp=this.chains();
	vsp.first().sign(0);
	w=new Racio(vsp.first(),vsp.second());
	return w;
	}

public void add(Racio a)
{
 /* 
a=new Racio(a);
Pair<ExtSInteger,ExtInteger> vvvvv=a.chains();
ExtSInteger tz=new ExtSInteger(this.z),az=new ExtSInteger(vvvvv.first());
ExtInteger tn=new ExtInteger(this.n),an=new ExtInteger(vvvvv.second());
System.out.print("__0__\n");
tz.mul(an);
System.out.print(an.soutput_()+"__1__\n");
az.mul(tn);
System.out.print(az.soutput_()+"__2__\n");
//System.out.print(az.soutput_10()+" "+tz.soutput_10()+"\n");
System.out.print(tz.soutput_()+" "+"\n");

tz.add(az);
System.out.print("__3__\n");
this.z=tz;
this.n.mul(an);
System.out.print("__4__\n");
if(autoSimp)
    this.simp();
*/
      
a=new Racio(a);
    Pair<ExtSInteger,ExtInteger> vvvvv=a.chains();
/*    
if(this.z.zero()==0||this.n.zero()==0)
    {
    this.z=vvvvv.first();
    this.n=vvvvv.second();
    }
else if(vvvvv.first().zero()!=0 && vvvvv.second().zero()!=0 )

*/
{


ExtSInteger tz=new ExtSInteger(this.z),az=new ExtSInteger(vvvvv.first());
ExtInteger tn=new ExtInteger(this.n),an=new ExtInteger(vvvvv.second());
ExtSInteger b1=new ExtSInteger(az),b2=new ExtSInteger(tz);
ExtInteger nGCD=ExtInteger.GCD(an, tn),nSCM=ExtInteger.SCM(an, tn);;

ExtSInteger pr;pr=new ExtSInteger(tn);
pr.quo(nGCD);
b1.mul(pr);
pr=new ExtSInteger(an);
pr.quo(nGCD);
b2.mul(pr);
b1.add(b2);
this.z=b1;
this.n=nSCM;
}
}

public void sub( Racio a)
{
this.z.sign((this.z.sign()+1)%2);
this.add(a);
this.z.sign((this.z.sign()+1)%2);
//a=new Racio(a);
//a.chains().first().sign((1+a.chains().first().sign())%2);
//this.add(a);
}


public void mul(Racio a)
{
a=new Racio(a);
this.z.mul(new ExtSInteger(a.chains().first()));
this.n.mul(new ExtInteger(a.chains().second()));
if(Racio.autoSimp) this.simp();
/*
ExtSInteger tz=new ExtSInteger(this.z);
tz.mul(a.chains().first());
ExtInteger tn=new ExtInteger(this.n);
tn.mul(a.chains().second());
this.z=tz;
this.n=tn;
*/
}

public void div(Racio a)
{ a=new Racio(a);
ExtSInteger z=new ExtSInteger(a.chains().second());
z.sign(a.chains().first().sign());
a=new Racio(z,new ExtInteger(a.chains().first()));
this.mul(a);
}


public void simp()
{if(n.zero()!=0 && z.zero()!=0){
    int pr;
    ExtInteger z=new ExtInteger(this.z.chains());
    ExtInteger n=new ExtInteger(this.n.chains());
    ExtInteger v=null;
    switch(z.srav(n))
    {
            case 2:{
            v=z;
            z=n;
            n=v;
            v=null;break;
            }
            case 0:
            {  pr=this.z.sign();
            this.z=new ExtSInteger(1);
            this.z.sign(pr);
            this.n=new ExtInteger(1);
            return;
            }
            default:{break;}
        
        }
    //GCD
   /* ExtInteger[] qwe=new ExtInteger[2];
    qwe[0]=z;
    qwe[1]=n;
    do{
      n=qwe[1];
    qwe=ExtInteger.QR(qwe[0], n);
    }while(qwe[1].zero()!=0);*/
   n=ExtInteger.GCD(z, n);
   
    //n = GCD(|this.z| , this.n )
    this.n=ExtInteger.QR(this.n, n)[0];    
    pr=this.z.sign();
    this.z=new ExtSInteger(ExtInteger.QR(new ExtInteger(this.z.chains()), n)[0]);
    this.z.sign(pr);
        
        
        }
else
    {
    this.z=new ExtSInteger(0);
    this.n=new ExtSInteger(1);
    }
}

public Racio pow(ExtInteger w)
	{
	ChainDqueue<Trine<ExtInteger,ExtInteger, Racio>> v1,v2,v3,v4;
	Pair<ExtSInteger,ExtInteger> w1;
	if(w==null)
		{
		v1=new ChainDqueue<>();
		v1.set(new Trine<>());
		v1.get().third(new Racio());
		}
	else
	if(w.zero()==0)
		{
		v1=new ChainDqueue<>();
		v1.set(new Trine<>());
		v1.get().third(new Racio(this));
		}
	else	
	if(w.srav(ExtInteger.E)==0)
		{
		v1=new ChainDqueue<>();
		v1.set(new Trine<>());
		v1.get().third(new Racio(this));
		}
	else
ETTO1:		{
		w=new ExtInteger(w);
		v1=new ChainDqueue<>();
		v2=v1;
		ExtInteger vsp=new ExtInteger(2),pr=null;
		v1.set(new Trine<>());
		v1.get().third(new Racio(this));
		v1.get().first(new ExtInteger(0));
		v1.get().second(new ExtInteger(1));
		while(v2.get().second().srav(w)!=0)
			{
			v3=new ChainDqueue<>();
			v3.set(new Trine<>());
			v3.before(v2);
			v2.next(v3);
			v2.get().first(new ExtInteger());
			v4=v2;
			while(true)
				{
				pr=new ExtInteger(v2.get().second());
				pr.add(v4.get().second());
				if(pr.srav(w)!=1)
					{
					v3.get().second(pr);
					v2=v3;
					break;
					}
				v2.get().first().add(ExtInteger.E);	
				v4=v4.before();
				}
			}
		while(v1.get().first()!=null)
			{
			v3=v1;
			pr=v1.get().first();
			while(pr.zero()!=0)
				{
				pr.sub(ExtInteger.E);
				v3=v3.before();
				}
			v1.next().get().third(new Racio(v1.get().third()));
			v1.next().get().third().mul(v3.get().third());
			v1=v1.next();
			}
		}
	return v1.get().third();
	}

public Racio pow(ExtSInteger w)
	{
	Racio ans=null;
	Pair<ExtSInteger,ExtInteger> vsp=null;
	if(w==null)
		ans=new Racio();
	else if(w.sign()%2==0)
		ans=this.pow(new ExtInteger(w.chains()));
		else
		{
		vsp=this.chains();
		ans=new Racio(new ExtSInteger(vsp.second()),new ExtInteger(vsp.first().chains()));
		ans.sign(this.sign());
		vsp=null;
		ans=ans.pow(new ExtInteger(w.chains()));
		}
	return ans;
	}

public Racio pow(Racio w)
	{
	return this.pow(w,Racio.epsi);
	}
public Racio pow(Racio w,Racio epsi)
	{
	return this.pow(w,epsi,Racio.xi);
	}



public Racio pow(Racio w, Racio epsi, Racio xi)
	{
        Racio ans;
        int i;
        Pair<ExtSInteger,ExtInteger> pair,pair2;
        ExtInteger ei1,ei2,ei3,ei4,ei5;
        ExtSInteger esi1,esi2;
        
        ans=new Racio(this);
        ans.simp();
        w.simp();
        pair=w.chains();
        esi1=pair.first();
POW_ALL:
        {
        if(this.z.srav(ExtSInteger.N)==3)
            {
            ans=new Racio();
            break POW_ALL;
            }
        else if(this.z.srav(ExtSInteger.E)==3&&this.n.srav(ExtInteger.E)==3)
                {
                ans=new Racio(1);
                break POW_ALL;
                }
        else
        if(esi1.srav(ExtSInteger.N)==0)
                {
                ans=new Racio(1);
                break POW_ALL;
                }
        else
        if(esi1.srav(ExtSInteger.E_)==0)
                {
                i=ans.sign();
                esi1=new ExtSInteger(ans.chains().second().chains());
                ei1=new ExtSInteger(ans.chains().first().chains());
                esi1.sign(i);
                ans=new Racio(esi1,ei1);
                }
        else
        if(esi1.srav(ExtSInteger.E)!=0)
            {
            ans=ans.pow(esi1);
            }
/////////////////////////////////////////////////
/////////////////////////////////////////////////
/////////////////////////////////////////////////
/////////////////////////////////////////////////
//natural perebor
            
POW_NAT:
            {
            //ei1=pair.second();
            ei1=new ExtSInteger(pair.second());
            
            if(ei1.srav(ExtSInteger.E)==0)
                break POW_NAT;
            else
            if(ans.sign()%2==1)
                if(ei1.chains().get().charValue()%2==0)
                    {
                    ans=new Racio();
                    break POW_NAT;
                    }
                else
                    {
                    i=1;
                    }
            else i=0;
            
            ei5=pair.second();
            pair=ans.chains();
            
            
            ei1=w.chains().second();
            
            
            ei2=new ExtInteger(pair.first().chains());
            ei3=new ExtInteger(ExtInteger.E);
            
            
            
POW_NAT_CHISL:
            while(true)
                    {
                   ei4=ei3.pow(ei5);
                    switch(ei4.srav(ei2))
                        {
                        case 0:
                                {
                                esi1=new ExtSInteger(ei3.chains());
                                esi1.sign(i);
                                pair.first(esi1);
                                break POW_NAT_CHISL;
                                }
                        case 1:
                                {
                                ei2=null;
                                ei3=null;
                                ei4=null;
                                ei5=null;
                                esi1=null;
                                esi2=null;
                                pair=null;
                                break POW_NAT;
                                }
                        case 2:
                                {
                                ei3.add(new ExtInteger(ExtInteger.E));
                                continue;
                                }
                        }
                    }
            
            //ei1=w.chains().second();
            ei2=new ExtInteger(pair.second().chains());
            ei3=new ExtInteger(ExtInteger.E);
            
            
            
POW_NAT_ZNAM:
            while(true)
                    {
                   ei4=ei3.pow(ei5);
                    switch(ei4.srav(ei2))
                        {
                        case 0:
                                {
                                //esi1=new ExtSInteger(ei3.chains());
                                //esi1.sign(i);
                                pair.second(ei3);
                                break POW_NAT_ZNAM;
                                }
                        case 1:
                                {
                                ei2=null;
                                ei3=null;
                                ei4=null;
                                ei5=null;
                                esi1=null;
                                esi2=null;
                                pair=null;
                                break POW_NAT;
                                }
                        case 2:
                                {
                                ei3.add(new ExtInteger(ExtInteger.E));
                                continue;
                                }
                        }
                    }
                ans=new Racio(pair.first(),pair.second());
                break POW_ALL;
            }
            
        }
        
        return ans;
        }

public String soutput_()
{
return "["+this.z.soutput_()+"]/["+this.n.soutput_()+"]";
}


public String soutput_10()
{
return this.z.soutput_10()+"/"+this.n.soutput_10();
}


public double to_double()
        {
        double ans=0,tmp1=1d,tmp2;
        ExtSInteger t1,t2,t3,t4;
        ExtSInteger[] tmp;
        long vsp=0,mng=(1<<16);
        if(Racio.autoSimp)
        {
        Racio prov=new Racio(this);
        prov.simp();
        t1=new ExtSInteger(prov.chains().second());
        prov=null;
        }
        else
            t1=new ExtSInteger(this.n);
        if(t1.srav(ExtSInteger.E)==0)
            ans=(double) this.z.to_long();
        else
            {
            t1=new ExtSInteger(this.z);
            t2=new ExtSInteger(this.n);
            t3=new ExtSInteger(mng);
            tmp2=t3.to_long();
            
            //while(vsp<Racio.n_d)
            vsp=Racio.n_d+1;
            do
            {
                vsp=vsp-1;
                tmp=ExtSInteger.QR(t1,t2);
                ans=ans+tmp[0].to_long()/tmp1;
                tmp1=tmp1*mng;
                t1=tmp[1];
                t1.mul(t3);
                }
            while(vsp!=0);
            }
        
        return ans;
        }


}
