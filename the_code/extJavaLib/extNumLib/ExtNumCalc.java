
package extJavaLib.extNumLib;
import extJavaLib.extNumLib.ExtNum;
import extJavaLib.extNumLib.ariph.ExtSInteger;
import extJavaLib.extNumLib.ariph.ExtInteger;
import extJavaLib.extNumLib.ariph.Racio;
import extJavaLib.baseBlockLib.Trine;
import extJavaLib.baseBlockLib.Pair;

import extJavaLib.extJavaLibExceptions.ExtJavaLibExceptions.ExtNumLibExceptions.*;


public final class ExtNumCalc
{
public static final ExtNum E=new ExtNum(1);
public static final ExtNum NULL= new ExtNum(0);

/*
public static int cmp(ExtNum a, ExtNum b)
	{
	return ExtNum.cmp(a,b);
	}
*/
public static ExtNum sum(ExtNum a, ExtNum b)
	{ //a=new ExtNum(a);b=new ExtNum(b);
		return  ExtNum.sum(a, b);}
public static ExtNum sub(ExtNum a, ExtNum b)
	{ //a=new ExtNum(a);b=new ExtNum(b);
		return ExtNum.sub(a, b); }

public static ExtNum prod(ExtNum a, ExtNum b)
	{
	//a=new ExtNum(a);b=new ExtNum(b);
	return ExtNum.prod(a,b);
	}
public static ExtNum div(ExtNum a, ExtNum b)
{
return ExtNum.div(a,b);
}

public static int cmp(ExtNum a, ExtNum b)
	{
	return ExtNum.cmp(new ExtNum(a), new ExtNum(b));
	}
public static Trine<ExtNum,ExtNum,ExtNum> get_Trine(ExtNum w)
	{
		/*
		 a=(N/m)=(nm+q)/m=n+q/m
		 first - n
		 second - q
		 third - m
		  */
	w.simp();
	Trine<ExtNum,ExtNum,ExtNum> ans=new Trine<>();
	Pair<ExtSInteger, ExtInteger> a=null;
	ExtSInteger[] b=null;
	switch(w.type())
		{
			case 1:case 0:
				{
				ans.first(new ExtNum(w));
				//ans.second(new ExtNum(ExtNumCalc.E));
				//ans.third(new ExtNum(ExtNumCalc.NULL));
                                ans.second((ExtNumCalc.NULL));
				ans.third((ExtNumCalc.E));
                                
				break;
				}
			case 2:
				{
				a=w.main().third().chains();
				b=ExtSInteger.QR(a.first(),a.second());
				//ans.first(new ExtNum(b[0]));
				//ans.second(new ExtNum(b[1]));
				//ans.third(new ExtNum(a.second()));
                                ans.first(new ExtNum(b[0]));
				ans.second(new ExtNum(b[1]));
				ans.third(new ExtNum(a.second()));
                                
				break;
				}
			
		}
	return ans;
	}


public static ExtNum[] QR(ExtNum a, ExtNum b)
    {
    ExtNum[] ans=new ExtNum[2];
    Trine<ExtNum,ExtNum,ExtNum> tmp=ExtNumCalc.get_Trine(a, b);
    ans[0]=tmp.first();
    ans[1]=tmp.second();
    return ans;
    }

public static Trine<ExtNum,ExtNum,ExtNum> get_Trine(ExtNum a, ExtNum b)
	{
	Trine<ExtNum,ExtNum,ExtNum> ans=new Trine<>();
	ExtSInteger[] qr=null;
	a=new ExtNum(a);
	b=new ExtNum(b);
	a.simp();
	b.simp();
	if(a.type()<=1&&b.type()<=1)
		{
		qr=new ExtSInteger[2];
		if(a.type()==0)
			qr[0]=new ExtSInteger(a.main().first());
		else
			qr[0]=new ExtSInteger(a.main().second());
		a=b;
		if(a.type()==0)
			qr[1]=new ExtSInteger(a.main().first());
		else
			qr[1]=new ExtSInteger(a.main().second());
		qr=ExtSInteger.QR(qr[0],qr[1]);
		ans.first(new ExtNum(qr[0]));
		ans.second(new ExtNum(qr[1]));
		ans.third(a);
		}
	else ans=null;
	return ans;
	}

public static ExtNum pow(ExtNum a, ExtNum n) //throws ExtNumNullPointerException
	{
	//if(a==null) throw new ExtNumNullPointerException();
	//if(n==null) throw new ExtNumNullPointerException();
	a=new ExtNum(a);
	n=new ExtNum(n);
	n.simp();
	a.simp();
        ExtInteger ei=null;
	ExtSInteger esi=null;
	Racio r=null;
	switch(n.type())
		{
		case 0:
			{
			switch(a.type())
				{
				case 0:
					{
					a=new ExtNum((a.main().first().pow(n.main().first())));
					break;
					}
				case 1:
					{
					a=new ExtNum((a.main().second().pow(n.main().first())));
					//a=new ExtNum();
                                        break;
					}
				case 2:
					{
					a=new ExtNum((a.main().third().pow(n.main().first())));
					break;
					}
				
				}
			break;
			}
		case 1:
			{
			switch(a.type())
				{
				case 0:
					{
					r=new Racio(a.main().first());
					r=r.pow(n.main().second());
					a=new ExtNum(r);
					r=null;
					break;
					}
				case 1:
					{
					r=new Racio(a.main().second());
					r=r.pow(n.main().second());
					a=new ExtNum(r);
					r=null;
					break;
					}
				case 2:
					{
					a=new ExtNum(a.main().third().pow(n.main().second()));
					break;
					}
				
				}
			break;
			}
		case 2:
			{
			switch(a.type())
				{
				case 0:
					{
					r=new Racio(a.main().first());
					break;
					}
				case 1:
					{
					r=new Racio(a.main().second());
					break;
					}
				case 2:
					{
					r=new Racio(a.main().third());
					break;
					}
				
				}
                        a=null;
			r=r.pow(n.main().third());
			a=new ExtNum(r);
			r=null;
			break;
			}
		}
	a.simp();
	return a;
	}

public static ExtNum pow(ExtNum a, ExtNum n,ExtNum epsi, ExtNum xi)//a^n
	{
	switch(a.type())
		{
		
		}
	return a;
	}

public static ExtNum abs(ExtNum a)
        {
        ExtNum ans=null;
        ExtSInteger esi,esi1;
        Pair<ExtSInteger,ExtInteger> p;
        int t;
        if(a==null)
            a=ExtNumCalc.NULL;
        else
            {
            a=new ExtNum(a);
            a.simp();
            t=a.type();
            if(t==1)
                {
                esi=a.main().second();
                a=new ExtNum(new ExtInteger(esi.chains()));
                }
            else
                if(t==2)
                {
                p=a.main().third().chains();
                p.first().sign(0);
                a=new ExtNum(p.first(),p.second());
                }
            ans=a;
            }
        return ans;
        }
    
    public static Trine<ExtNum,ExtNum,ExtNum> getTrine(ExtNum a)
            {
            Trine<ExtNum,ExtNum,ExtNum> ans=new Trine<ExtNum,ExtNum,ExtNum>();
            ExtNum[] tmp;
            Pair<ExtSInteger,ExtInteger> p;
            switch(a.type())
                {
                case 0: case 1:
                        {
                        ans.first(a);
                        ans.second(ExtNumCalc.NULL);
                        ans.third(ExtNumCalc.E);
                        break;
                        }
                case 2:
                        {
                        p=a.main().third().chains();
                        ans.third(new ExtNum(p.second()));
                        tmp = ExtNumCalc.QR(new ExtNum(p.first()), ans.third());
                        p=null;
                        ans.first(tmp[0]);
                        ans.second(tmp[1]);
                        break;
                        }
                }
            
            return ans;
            }


}

