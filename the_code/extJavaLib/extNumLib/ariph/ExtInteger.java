package extJavaLib.extNumLib.ariph;
//import extJavaLib.baseBlockLib.Dqueue;
import extJavaLib.baseBlockLib.ChainDqueue;
import extJavaLib.baseBlockLib.Pair;
//import extJavaLib.extStringLib.ExtString.ExtChar;

public class ExtInteger
{
public static final int A= maxi();

public static final ExtInteger E=new ExtInteger(1),AE=new ExtInteger(ExtInteger.maxi()),N=new ExtInteger();

public static int maxi()
{
int odin_byte=256;
int otvet=1;
int pr,nuzhn=Base_n.BYTES;
for(pr=0;pr<nuzhn;pr++)
	otvet=otvet*odin_byte;

return otvet;
}


protected ChainDqueue<Base_n> c;
public ChainDqueue<Base_n> chains(){return this.c;}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public ExtInteger(){ this.c=new ChainDqueue<Base_n>(); this.c.set(new Base_n((char)0)); }
public ExtInteger(long w)
		{

		if(w<=0) { this.c=(new ExtInteger()).chains(); }
		else
		{
		this.c=null;
		ChainDqueue<Base_n> t;
		char ww;
		ww=(char)(w%ExtInteger.A);
		w=w/ExtInteger.A;
		t=new ChainDqueue<Base_n>();
		//t.set( new Base_n(ww) );
		t.set( new Base_n(ww) );
		this.c=t;
		while(w>0)
			{
			ww=(char)(w%ExtInteger.A);
			w=w/ExtInteger.A;
			t.next(new ChainDqueue<Base_n>());
			//t.set(new Base_n(ww));
			
			t.next().before(t);
			t=t.next();
			t.set(new Base_n(ww));
			}
		}
		}


public ExtInteger(int w)
	{
	this.c=(new ExtInteger((long)w)).chains();       
	}
public ExtInteger(char w)
	{
	this.c=(new ExtInteger((int)w)).chains();
	}


public ExtInteger(ExtInteger w)
{
ChainDqueue <Base_n> vsp=w.chains(),t=null;;
this.c=null;
while(vsp!=null)
{
if(this.c==null)
	{
	this.c=new ChainDqueue<Base_n>();
	this.c.set(new Base_n(vsp.get()));
	t=this.c;
	}
else
	{
	t.next(new ChainDqueue<Base_n>());
	t.next().before(t);
	t=t.next();
	t.set(new Base_n(vsp.get()));
	}
vsp=vsp.next();
}
}


public ExtInteger(ChainDqueue<Base_n> wc)
{
this.c=wc;
this.c=new ExtInteger(this).chains();
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public void add(ExtInteger w)
{
if(this.zero()==0)
	this.c=(new ExtInteger(w)).chains();
else
if(w.zero()!=0){
//w=new ExtInteger(w);
ChainDqueue<Base_n> a=(new ExtInteger(this)).chains(), 
	b=(new ExtInteger(w)).chains(),aa=null,aaa,vsp;
aaa=a;
int buff;
vsp=a;
char flag=0;
while(b!=null)
		{
		buff=a.get().charValue()+b.get().charValue();
		a.set(new Base_n((char)(buff%ExtInteger.A)));
		buff=buff/ExtInteger.A;
		if(buff!=0)
			{
			aa=a;
			while(buff!=0)
				{
				if(aa.next()==null)
					{
					aa.next(new ChainDqueue<Base_n>());
					aa.next().set(new Base_n((char)buff));
					aa.next().before(aa);
					buff=0;
					}
				else
					{
					aa=aa.next();
					buff=buff+aa.get().charValue();
					aa.set(new Base_n((char)(buff%ExtInteger.A)));
					buff=buff/ExtInteger.A;
					}
				}
			}
		b=b.next();
		if(b!=null && a.next()==null) 
				{
				a.next(new ChainDqueue<Base_n>());
				a.next().set(new Base_n((char)0));
				a.next().before(a);
				}
		a=a.next();

		}


this.c=vsp;
}
}




public void sub(ExtInteger w)
{
if(w==null) w=new ExtInteger();
if(w.zero()!=0)
if(this.zero()!=0)
{

ChainDqueue<Base_n> a=this.chains()//(new ExtInteger(this)).chains()
	, b=(new ExtInteger(w)).chains(),aa=null,bb=null;
int buff;

while(b!=null)
	{
	if(a==null) { this.c=(new ExtInteger()).chains();break; }
	else
			{
			if(a.get().charValue()>=b.get().charValue())
				{
				a.set(new Base_n((char)(a.get().charValue()-b.get().charValue())));
			//	a=a.next();
			//	b=b.next();
				}
			else
				{
				
				a.set(new Base_n((char)(ExtInteger.A+a.get().charValue()-b.get().charValue())));
				aa=a.next();
				if(aa==null) {a=null; continue;}
				while(aa!=null)
					if(aa.get().charValue()==0)
						if(aa.next()==null)
							{a=null; continue;}
						else
							{
							aa.set(new Base_n((char)(ExtInteger.A-1)));
							aa=aa.next();
							}
					else
						{ aa.set(new Base_n((char)(aa.get().charValue()-1)));break; }
				while(aa.next()==null && aa.get().charValue()==0)
					{ aa=aa.before(); aa.next(null);  }
				//b=b.next();
				}
			
			
			
			a=a.next();
			b=b.next();
			}	
	
	
	}	
if(a!=null)	
aa=a;
else aa=this.chains();
while(aa.next()!=null) aa=aa.next();
while(aa.get().charValue()==0 && aa.before()!=null ) { aa=aa.before(); aa.next(null); }

}
}


public boolean o_z()
{
return this.c.next()==null;
}


public void mul(ExtInteger w)
{
if(  w.zero()==0)
	{
	this.c=new ChainDqueue<Base_n>();
	this.c.set(new Base_n());
	}
else if (this.zero()!=0)
{
ExtInteger otvet=new ExtInteger(),pr1,pr2;
long qwe;
ChainDqueue<Base_n> t=this.chains(), ww1,w1=w.chains(),n1=null,n2=null,n1t=null,n2t=null,vsp;
ww1=w1;
while(t!=null)
	{
	w1=ww1;
	n2=null;
	while(w1!=null)
		{
        	qwe=t.get().charValue();
		qwe=qwe*w1.get().charValue();
		vsp=(new ExtInteger(qwe)).chains();
		if(n1==null)
			if(n2==null){
				otvet.add(new ExtInteger(vsp));
				n2=(new ExtInteger()).chains();
				n2t=n2;
					}
			else
				{
				n2t.next(vsp);
				otvet.add(new ExtInteger(n2));
				n2t.next((new ExtInteger()).chains());
				n2t.next().before(n2t);
				n2t=n2t.next();
				}
		else
			if(n2==null)
				{
				n1t.next(vsp);
				otvet.add(new ExtInteger(n1));
				//n1t.next((new ExtInteger()).chains());
				n2=(new ExtInteger()).chains();
				n2t=n2;
				}
			else
				{
				n2t.next(vsp);
				n1t.next(n2);
				otvet.add(new ExtInteger(n1));
				n2t.next((new ExtInteger()).chains());
				n2t.next().before(n2t);
				n2t=n2t.next();
				}
			
		w1=w1.next();
		}
	t=t.next();
	if(n1==null) {n1=(new ExtInteger()).chains();n1t=n1;}
	else {n1t.next((new ExtInteger()).chains()); n1t.next().before(n1t); n1t=n1t.next(); }
	}

this.c=otvet.chains();
}
}

public void mul2(ExtInteger w)

{
ChainDqueue<Base_n> t=this.chains(),w1=w.chains(),
	n1=null,n2=null,n2t,n1t,otv,p1,p2,p3,w2;

ExtInteger pr1,pr2,otvet=new ExtInteger();
p1=otvet.chains();
	p3=p1;
long  qwe;
//int i=0,j;
while(t!=null)
	{
	p2=p1;
	w2=w1;
	while(w2!=null)
		{
		
		qwe=t.get().charValue();
		qwe=qwe*w2.get().charValue();
		pr1=new ExtInteger(qwe);
			
			pr1.add(new ExtInteger(p2));
		
		if(p2.next()==null)
			{
				
				
			}
			
		/*
		if(p2.before()==null)
		{
		otvet=pr1;
		p2=otvet.chains();
		p1=p2;
		}
		else
		{
		p2=p2.before();
		p2.next(pr1.chains());
		p2.next().before(p2);
		p2=p2.next();
		}
		w2=w2.next();
		if(w2!=null){
		if(p2.next()==null) {p2.next((new ExtInteger()).chains()); p2.next().before(p2);}
				p2=p2.next();}
		
		*/
		}
	t=t.next();//i=i+1;
		if(t!=null){
		if(p1.next()==null) {p1.next((new ExtInteger()).chains()); p1.next().before(p1);}
				p1=p1.next();}
	}
this.c=otvet.chains();
}

public void mul1(ExtInteger w)
{
ChainDqueue<Base_n> qwe,n1t,t=(new ExtInteger(this)).chains(),
			w1=(new ExtInteger(w)).chains(),w2,n1=null, n2=null, n2t=null,cpr=null;
ExtInteger otvet=new ExtInteger(), pr=null,pr1;
int qweewq;
n1t=null;
while(t!=null)
	{
	w2=w1;
	n2=null;
	pr=new ExtInteger();
	while(w2!=null)
		{
		//qweewq=t.get().charValue();qweewq=qweewq*w2.get().charValue();
		//pr1=new ExtInteger(qweewq);
		qwe=(new ExtInteger(t.get().charValue()*w2.get().charValue())).chains();
		if(n2==null)
			{
			pr.add(new ExtInteger(qwe));
			n2=new ChainDqueue<Base_n>();
			n2.set(new Base_n((char)0));
			n2t=n2;
			}
		else
			{
			n2t.next(qwe);
			pr.add(new ExtInteger(n2));
			n2.before(new ChainDqueue<Base_n>());
			n2.before().next(n2);
			n2=n2.before();
			n2.set(new Base_n((char)0));
			}
		w2=w2.next();
		}//vnutrennii
	if(n1==null)
		{
		otvet.add(pr);
		n1=new ChainDqueue<Base_n>();
		n1.set(new Base_n((char)0));
		n1t=n1;
		}
	else
		{
		n1t.next(pr.chains());
		otvet.add(new ExtInteger(n1));
		n1.before(new ChainDqueue<Base_n>());
		n1.before().next(n1);
		n1=n1.before();
		n1.set(new Base_n((char)0));
		}	
	t=t.next();
	}//vneshnii

this.c=otvet.chains();

}

//if this == 0 or null
    // then 0
// else 1
public int zero()
{ int otvet;
if(this.c==null) otvet= 0;
else if(this.c.get().charValue()==0 && this.c.next()==null) otvet=0;
	else otvet=1;
return otvet;
}
/*
this==w -> 0
this>w ->  1
this <w-> 2
*/
public int srav(ExtInteger w)
{
int otvet=0;
w=new ExtInteger(w);
ExtInteger pr=new ExtInteger(this);
pr.sub(w);
if(pr.zero()==0)
	{
	pr=new ExtInteger(w);
	pr.sub(this);
	if(pr.zero()==0)
		otvet=0;
	else otvet=2;
	}
else
	{
	otvet=1;
	}
return otvet;
}


public void  quo(ExtInteger w)
{
this.c=ExtInteger.QR(this,w)[0].chains();
//return ExtInteger.QR(this,w)[0].chains();
//this.c=this.QR(this,w)[0].chains();
}

public void rmn(ExtInteger w)
{
this.c=ExtInteger.QR(this,w)[1].chains();
//return ExtInteger.QR(this,w)[1].chains();
//this.c=this.QR(this,w)[1].chains();

}

public  ExtInteger pow(ExtInteger n)
{
    if(n==null) {n=new ExtInteger();}
    else n=new ExtInteger(n);
ChainDqueue<Pair<ExtInteger,ExtInteger>> c,cc,ccc;
ExtInteger a1,a2,a3;
a1=null;a2=null;a3=null;
c=null;
cc=null;
ccc=cc;
ExtInteger ans=null;
if(n==null)
    ans=new ExtInteger(1);
else
    if(0==n.srav(new ExtInteger()))
        ans=new ExtInteger(1);
    else if(0==n.srav(ExtInteger.E))
            ans=new ExtInteger(this);
         else
            { 
                
            c=new ChainDqueue<>();
            c.set(new Pair<>());
            c.get().first(ExtInteger.E);
            c.get().second(new ExtInteger());
            ccc=c;
            while(c.get().first().srav(n)!=0)
                {
                c.get().second(new ExtInteger());
                c.next(new ChainDqueue<>());
                c.next().before(c);
                c.next().set(new Pair<>());
                //c.next().get().second(new ExtInteger());
                cc=c;
                
                //a2=new ExtInteger();
                while(true)
                    {
                    
                    a1=new ExtInteger(c.get().first());
                    a1.add(cc.get().first());
                    if(a1.srav(n)==1)
                        {
                        cc=cc.before();
                        
                        c.get().second().add(ExtInteger.E);
                        }
                    else 
                        {
                        c.next().get().first(a1);
                        c=c.next();
                        //c.get().second(a2);
                        break;
                        }
                    }
                        
                }
                c=ccc;
                c.get().first(new ExtInteger(this));
                while(c.next()!=null)
                    {
                    cc=c;
                    while(c.get().second().zero()!=0)
                        {
                        cc=cc.before();
                        c.get().second().sub(ExtInteger.E);
                        }
                    c.next().get().first(new ExtInteger(c.get().first()));
                    c.next().get().first().mul(cc.get().first());
                    c=c.next();
                    }
                ans=c.get().first();
            
            }
        

return ans;
}

public static ExtInteger[] QR(ExtInteger ss,ExtInteger w)
{
ss=new ExtInteger(ss);
w=new ExtInteger(w);
if(w.zero()==0) return null;
ExtInteger[] otvet=new ExtInteger[2];
if(w.srav(ExtInteger.E)==0) 
	{
	otvet[0]=new ExtInteger(ss);
	otvet[1]=new ExtInteger(0);
	}
else
if(w.zero()==0)
	{
	otvet[0]=new ExtInteger();
	otvet[1]=new ExtInteger(ss);
	}
else
{
ExtInteger O=new ExtInteger(w);//,E=new ExtInteger(1);
otvet[1]=new ExtInteger();
otvet[0]=new ExtInteger(ss);
ChainDqueue<Base_n> aa,bb,cc;
while(otvet[0].srav(O)!=2)
	{
	aa=new ChainDqueue<Base_n>();
	aa.set(new Base_n((char)0));
	aa.next(O.chains());
	aa.next().before(aa);
	O=new ExtInteger(aa);
	}
O=new ExtInteger(O.chains().next());
while(true)
	{
	
	if(O.srav(w)==2) break;
	if(otvet[1].zero()==1)	{
	aa=otvet[1].chains();
	aa.before(new ChainDqueue<Base_n>());
	aa.before().next(aa);
	aa=aa.before();
	aa.set(new Base_n((char)0));
	otvet[1]=new ExtInteger(aa);
				}
	while(otvet[0].srav(O)!=2)
		{
		otvet[1].add(ExtInteger.E);
		otvet[0].sub(O);
		}
	if(O.chains().next()!=null)
	O=new ExtInteger(O.chains().next());
	else break;
	}

w=otvet[1];
otvet[1]=otvet[0];
otvet[0]=w;
}
return otvet;

}




public String soutput_()
{
String w=null;
ChainDqueue<Base_n> vsp=this.chains();
while(vsp!=null)
{
if(w==null) w=new String(Integer.toString(vsp.get().charValue()));
else w=  new String(Integer.toString(vsp.get().charValue())) +" |" +w ;
vsp=vsp.next();

}
return w;
}



public String soutput_10()
{
String otv=null,vsps;
ExtInteger[] q=new ExtInteger[2];
q[0]=new ExtInteger(this);
int flg=0;
ExtInteger d=new ExtInteger(1000);
if(q[0].zero()==0)
	{ 
	otv=new String("0");
	}
else
	while(q[0].zero()!=0)
		{
		q=ExtInteger.QR(q[0],d);
		vsps=Integer.toString((int)(q[1].chains().get().charValue()));
	//	System.out.print(vsps+"\n");
		if(q[0].zero()!=0)
		//while(vsps.length()<3 && flg==0) vsps="0"+vsps;
		while(vsps.length()<3) vsps="0"+vsps;
		flg=1;
		if(otv==null) otv=vsps;
		else otv=vsps+otv;
		}
return otv;

}

public static final class Base_n
{
protected char c;
public static final int BYTES=2;
public Base_n(){this((char)0);}
public Base_n(char w) { this.c=w;}
public Base_n(int w) { this.c=(char)w;}
public Base_n(Base_n w) {this.c=w.charValue();}
public void charValue(char w) { this.c=w;}
public char charValue(){return this.c;}

}

public static ExtInteger GCD(ExtInteger a, ExtInteger b)
{ a=new ExtInteger(a);
    b=new ExtInteger(b);
ExtInteger otv=null;
switch(a.srav(b))
    {
    case 0:{otv=a;break;}
    case 2:{otv=ExtInteger.GCD(b, a);break;}
    case 1:

        {
        ExtInteger[] qwe=new ExtInteger[2];
        qwe[0]=a;
        qwe[1]=b;
        do
        {
        qwe=ExtInteger.QR(a, b);
        if(qwe[1].zero()==0) break;
        a=b;
        b=qwe[1];
        }while(true);
        otv=b;break;
        }
    }

return otv;
}

public static ExtInteger SCM(ExtInteger a, ExtInteger b)
{   a=new ExtInteger(a);
    b=new ExtInteger(b);
//ExtInteger cmd=ExtInteger.GCD(a, b);
    a.quo(ExtInteger.GCD(a, b));
    a.mul(b);
    return a;
}


public long to_long()
{
long ans=0,l=1,m=(1<<16);
ChainDqueue<Base_n> vsp=this.c;
while(vsp!=null && l!=0)
{
ans=ans+l*vsp.get().charValue();
l=(l<<16);
vsp=vsp.next();
}


return ans;
}



/**
Character class is deprecated
that is why i have to use ExtChar

*/
public static class ExtChar
{

protected char c;
public char charValue(){return this.c;}
public void charValue(char cc) {this.c=cc;}
public ExtChar(){this.c=(char)0;}
public ExtChar(ExtChar w) {if(w!=null)this.c=w.charValue(); else this.c=(char)0;}

public ExtChar(char cc){this.c=cc;}
public String toString()
    {
    String ans=null;
    char[] vsp=new char[1];
    vsp[0]=this.c;
    ans=new String(vsp);
    
    return ans;
    }
/*public char ExtChartype()
		{
		char ans=0;
		if((this.c<='z'&&this.c>='a') || (this.c>='A' && this.c<='Z')  )
			ans=1;
		else
		switch(this.c)
		{
			case '[':{ ans=2;break; }
			case '{':{ans=4;break;}
			case ']':{ans=(~(2)); break;}
			case '}':{ans=(~(4));break;}
			case '\"':{ans=8;break;}
			case '\'':{ans=9; break;}
			case ':':{ans=10; break;}

		
		}
		
		return ans;
		}*/

}



}

