package extJavaLib.extNumLib.ariph;

import extJavaLib.extNumLib.ariph.ExtInteger;
import extJavaLib.baseBlockLib.ChainDqueue;


public class ExtSInteger extends ExtInteger
{
protected int s;
public static final ExtSInteger E,N,E_;
static
	{
	E=new ExtSInteger(1);
	E_=new ExtSInteger(-1);
	N=new ExtSInteger(0);
	}

public int sign() {return this.s;}
public void sign(int s){this.s=s;}

public ExtSInteger() {super(); this.s=0; }
public ExtSInteger(long a) { if(a<0) {this.s=1;a=0-a;} else this.s=0; this.c=(new ExtInteger(a)).chains();   }
public ExtSInteger(int  a) { if(a<0){this.s=1;a=0-a;} else this.s=0; this.c=(new ExtInteger((long)a)).chains(); }
public ExtSInteger(char a) { this.s=0;  this.c=(new ExtInteger((int)a)).chains();}
public ExtSInteger(ExtInteger a)
	{
	this.s=0;
	this.c=(new ExtInteger(a)).chains();
	}
public ExtSInteger( ExtSInteger a)
	{
	this.s=a.sign();
	this.c=(new ExtInteger(a.chains())).chains();
	}

public ExtSInteger(ChainDqueue <Base_n> w) {super(w);this.s=0;}

public int srav(ExtSInteger a)
{ int otvet;otvet=0;	
if((this.s+a.sign())%2==0)
	{		otvet=(new ExtInteger(this.c)).srav(new ExtInteger(a.chains()));
			if(this.s==1 && otvet!=0)
				if(otvet==1)
					otvet=2;
				else
					otvet=1;
			
			
			
			
	}
else if(this.s==0) otvet=1; else otvet=2;

return otvet;
}

public int srav(ExtInteger a)
{
return this.srav(new ExtSInteger(a));
}

public ChainDqueue<Base_n> chains()
{
return super.chains();
}

public void add(ExtSInteger a)
{
a=new ExtSInteger(a);
ExtInteger w=null;
w=(new ExtInteger(this.c));


if((this.s+a.sign())%2==0)
{ 
 w=new ExtInteger(this.c);
w.add(new ExtInteger(a.chains()));
this.c=w.chains();
}
else
	//switch((new ExtInteger(this.c)).srav(new ExtInteger(a.chains())))
            switch((new ExtInteger(this.c)).srav(a))
		{
			case 0:
				{
                                
				this.s=0;
				this.c=(new ExtInteger()).chains();
				break;
				}
			case 1:
				{
                                     
				w=new ExtInteger(this.c);
				//w.sub(new ExtInteger(a.chains()));
				w.sub(new ExtInteger(a.chains()));
				this.c=w.chains();
				break;
				}
			case 2:
				{
                                  
				this.s=a.sign();
				//w=new ExtInteger(a.chains());
				w=new ExtInteger(a);
				w.sub(new ExtInteger(this.c));
				this.c=w.chains();
				break;
				}
		
		}


	if(this.zero()==0)
	 this.sign(0);


}


public void sub(ExtSInteger a)
{
a=new ExtSInteger(a);
a.sign((1+a.sign())%2);
this.add(a);


}
@Override
public void add(ExtInteger a)
{
this.add(new ExtSInteger(a.chains()));

}
@Override
public void sub(ExtInteger a)
{
this.sub(new ExtSInteger(a.chains()));
}


public void mul(ExtSInteger w)
{
ExtInteger pr=(new ExtInteger(this.c));
pr.mul(new ExtInteger(w.chains()));
this.c=pr.chains();
this.sign((this.sign()+w.sign())%2);
if(this.zero()==0) this.sign(0);
}




@Override
public String soutput_()
{
String otvet=null;
if(this.s==0)
	otvet=super.soutput_();
else
	otvet = '-'+ super.soutput_();

return otvet;

}

//@Override
public static ExtSInteger[] QR(ExtInteger ss, ExtInteger w )
{
ExtSInteger a=new ExtSInteger(ss);
ExtSInteger b=new ExtSInteger(w);
return ExtSInteger.QR(a,b);
}

//@Override
public static ExtSInteger[] QR(ExtSInteger ss, ExtInteger w )
{
ExtSInteger a=new ExtSInteger(ss);
ExtSInteger b=new ExtSInteger(w);
return ExtSInteger.QR(a,b);
}


//@Override
public static ExtSInteger[] QR(ExtInteger ss, ExtSInteger w )
{
ExtSInteger a=new ExtSInteger(ss);
ExtSInteger b=new ExtSInteger(w);
return ExtSInteger.QR(a,b);
}


public static ExtSInteger[] QR( ExtSInteger ss, ExtSInteger w)
{
ExtInteger[] qwe= ExtInteger.QR(new ExtInteger(ss.chains()),new ExtInteger(w.chains()));
ExtSInteger[] otvet=new ExtSInteger[2];
otvet[0]=new ExtSInteger(qwe[0]);
otvet[1]=new ExtSInteger(qwe[1]);
vse:{
if(ss.sign()==1)
	if(w.sign()==1)
		{
		otvet[0].add(ExtInteger.E);
		if(otvet[1].zero()==0) break vse;
		
		qwe[0]=new ExtInteger(w);
		qwe[0].sub(new ExtInteger(otvet[1]));
		otvet[1]=new ExtSInteger(qwe[0]);
		}
	else
		{
		otvet[0].sign(1);
		if(otvet[1].zero()==0) break vse;
		otvet[0].sub(ExtInteger.E);
		qwe[0]=new ExtInteger(w);
		qwe[0].sub(new ExtInteger(otvet[1]));
		otvet[1]=new ExtSInteger(qwe[0]);
		}
else
	if(w.sign()==1)
		{
		otvet[0].sign(1);
		if(otvet[1].zero()==0) break vse;
		}
}

return otvet;
}


public void rmn(ExtSInteger w)
{
w=ExtSInteger.QR(this,w)[1];
this.c=w.chains();
this.s=w.sign();
}

public void quo(ExtSInteger w)
{
w=ExtSInteger.QR(this,w)[0];
this.c=w.chains();
this.s=w.sign();
}


@Override
public void rmn(ExtInteger w)
{
this.rmn(new ExtSInteger(w));
}

@Override
public void quo(ExtInteger w)
{
this.quo(new ExtSInteger(w));
}

public String soutput_10()
{
//System.out.print("\n\t\t"+this.sign()+"\n\n");
String otvet=super.soutput_10();
if(this.sign()==1) otvet="-"+otvet;

return otvet;
}

public long to_long()
{
long ans=super.to_long();
if(this.s%2!=0)
    ans=ans*(0-1);

return ans;
}

public  ExtSInteger pow(ExtInteger n)
{
ExtSInteger ans =new ExtSInteger(new ExtInteger(super.pow(n)));
if(n.chains().get().charValue()%2==1)
    ans.sign(this.sign());
return ans;
}

}



