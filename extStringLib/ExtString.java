
package extJavaLib.extStringLib;
import extJavaLib.baseBlockLib.ChainDqueue;
import extJavaLib.baseBlockLib.ChainStack;
import extJavaLib.baseBlockLib.Pair;
import extJavaLib.baseBlockLib.Trine;
import extJavaLib.extNumLib.ExtNum;
import extJavaLib.extNumLib.ExtNumCalc;
import extJavaLib.extNumLib.ariph.ExtInteger.ExtChar;
import extJavaLib.extJavaLibExceptions.ExtJavaLibExceptions.ExtJavaLibBaseException;
import extJavaLib.extJavaLibExceptions.ExtJavaLibExceptions.LogicalStructsExceptions.ExtTagLibExceptions.*;
import extJavaLib.extJavaLibExceptions.ExtJavaLibExceptions.ExtStringExceptions.*;
import extJavaLib.extJavaLibExceptions.ExtJavaLibExceptions.NullArgumentException;
//NullArgumentException
/**
ExtString is Extended String;
It is not numerateble;
For hipsters: if ye wanna use thiz as senior and drink yer coffee, ye muzt be master of using ChainDqueue and nezzted class  ExtChar as great as senior;
For simple people: I think it shall be good if you know argenozlib.baseBlockLib.ChainDqueue, extJavaLib.baseBlockLib.Pair and nested class ExtChar due to ExtString is no more than ChainDqueue of ExtChar and ExtChar is no more than nutshell for char; Good luck, have a fun!
@version 1.0
*/

public class ExtString
{

protected ChainDqueue<ExtChar> h,t;

/**
Constructor for empty ExtString
*/
public ExtString()
	{
	this.h=null;
	this.t=null;
	}

//convert String to ExtString
/**
This constructor is only for converting String to ExtString
*/

public ExtString( String qwe) 
{
this();
int i,l;
char vsp;
if(qwe!=null)
if(qwe.length()>0){	
this.h=new ChainDqueue<ExtChar>();
this.h.set(new ExtChar(qwe.charAt(0)));
i=1;
this.t=this.h;
l=qwe.length();
while(i<l){this.t.next(new ChainDqueue<ExtChar>()); this.t.next().before(this.t); this.t=this.t.next(); this.t.set(new ExtChar(qwe.charAt(i)));i=1+i; }
} 
//else {this.h=this.t=null;}
//	else this();
}


//the beginning and the end of ExtString
/** 
It gets head and tail of ExtString; The first element of Pair is head of the ExtString and  second is tail of the ExtString;
@version 1.0
@return Pair
*/

public Pair<ChainDqueue<ExtChar>,ChainDqueue<ExtChar>> chains(){
Pair<ChainDqueue<ExtChar>,ChainDqueue<ExtChar>> otv=new Pair<ChainDqueue<ExtChar>,ChainDqueue<ExtChar>>();
otv.first(this.h);
otv.second(this.t);
return otv;
}


//copy ExtString

public static ExtString copy(ExtString w)
	{
	w=new ExtString(w);
	return w;
	}


/**     
It copies ExtString w, no more;
@param W
@version 1.0
*/

//public ExtString(){this.h=this.t=null;}
public ExtString(ExtString w)
{       if(w==null){this.h=this.t=null;} else
      	if(w.empty()){this.h=this.t=null;}
	else{this.h=null;
ChainDqueue<ExtChar> vsp=w.chains().first();
	int vvv=0;
        vvv=1;
        if(vvv%2==1)
        while(vsp!=null)
	{
		if(this.h==null) {this.h=new ChainDqueue<ExtChar>(); this.h.set(new ExtChar(vsp.get().charValue()));this.t=this.h;}
		else { this.t.next(new ChainDqueue<ExtChar>()); this.t.next().before(this.t); this.t=this.t.next(); this.t.set(new ExtChar(vsp.get().charValue())); }
	vsp=vsp.next();
	}
        else
            {
            this.h=new ChainDqueue<ExtChar>();
            this.h.set(new ExtChar(vsp.get().charValue()));
            vsp=vsp.next();
            this.t=this.h;
            while(vsp!=null)
            {
            this.t.next(new ChainDqueue<ExtChar>());
            this.t.next().before(this.t);
            this.t=this.h.next();
            this.t.set(new ExtChar());
            this.t.get().charValue(vsp.get().charValue());
            vsp=vsp.next();
            }
            }
	
	}
}


public boolean ifEmpty()
	{
	return this.h==null;
	}


/**
 It compair two ExtString objects; It takes two arguments - ExtString s1 and ExtString s2; If s1 is substring of s2 it returns 2(10), if s1 is supstring of s2 it returns 1(01), of s1 and s2 are equal it returns 3(11) else it returns 0(00) 
 @param s1 ExtString object
 @param s2 ExtString object
 @return int
 @version 1.0
 */
public static int cmp(ExtString s1, ExtString s2)
{
int res=0,flg=0,otv=0;
s1=new ExtString(s1);
s2=new ExtString(s2);
ChainDqueue<ExtChar> a=s1.chains().first(),b=s2.chains().first(),aa=null,bb=null;
	etto:
	{
	if(s1.ifEmpty()&&s2.ifEmpty())
		{
		otv=3;
		break etto;
		}	
	while(a!=null)
		{
		aa=a;
		bb=b;
		while(aa!=null && bb!=null)
			if(aa.get().charValue()==bb.get().charValue())
				{aa=aa.next();bb=bb.next();}
			else
				break;

		if(aa==null)
			if(bb==null)
				if(flg==0)
					if(a==s1.chains().first())
						{otv=3;break;}
					else
						{otv=2;break;}
				else
					if(a==s2.chains().first())
						{otv=3;break;}
					else
						{otv=1;break;}
			else
				if(flg==0)
					{flg=1;b=s1.chains().first();a=s2.chains().first();continue;}
				else break;
		else if(bb==null)
			if(flg==0) {otv=1;break;}
			else {otv=2;break;}
			else if(a.next()==null)
					{if(flg==0)
						{flg=1;b=s1.chains().first();a=s2.chains().first();continue;}
						else break;}
				else a=a.next();
					

				
				
				
				
				

		}	
	}

res=otv;
return res;

}





//copy ExtString. h - beginning(head); t - tail;
/**
 this convert ChainDqueue to ExtString making copy of every ExtChar
 @param h head of ChainDqueue of ExtChar
 @param t tail of ChainDqueue of ExtChar
 @version 1.0
 * */
public ExtString(ChainDqueue<ExtChar> h, ChainDqueue<ExtChar> t)
{   
if(h!=null && t!=null)
    {
    this.h=new ChainDqueue<ExtChar>();
    this.h.set(new ExtChar(h.get().charValue()));
    
    this.t=this.h;
    if(h==t) return;
    h=h.next();
    this.t=this.h;
    ChainDqueue<ExtChar> tt=null;
    if(t!=null)
    tt=t.next();
    while(h!=tt)
        {
        
        this.t.next(new ChainDqueue<ExtChar>());
        this.t.next().before(this.t);
        this.t=this.t.next();
        this.t.set(new ExtChar(h.get().charValue()));
        h=h.next();
        }

    }
else {this.h=null; this.t=this.h;}
}



//slice of the String
/**
 It copies sunstring and return this substring as ExtString
 @param h head of ChainDqueue of ExtChar
 @param t tail of ChainDqueue of ExtChar
 @return ExtString object
 @version 1.0 
 */
public static ExtString slice(ChainDqueue<ExtChar>h, ChainDqueue<ExtChar> t)
{
    int vv=1;
    if(vv%2==1)
    {
    return new ExtString(h,t);
    }
        else
    {ChainDqueue<ExtChar> vsp=null,k;
k=vsp;
if(t!=null) t=t.next();
while(h!=t)
	{
	if(vsp==null)
		{
		vsp=new ChainDqueue<ExtChar>();
		vsp.set(new ExtChar(h.get().charValue()));
		k=vsp;
		}
	else
		{
		k.next(new ChainDqueue<ExtChar>());
		k.next().before(k);
		k=k.next();
		k.set(new ExtChar(h.get().charValue()));
		}
	h=h.next();
	}
return new ExtString(vsp,k);
}
}


public ChainDqueue<ExtString> separete(ChainDqueue<ExtString> sep)
{
return this.separete(sep,0);

}

public ChainDqueue<ExtString> separete(ChainDqueue<ExtString> sep,int I)
{
ChainDqueue<ExtString> ans=null,tmp_cd=null,sep_=null;
ChainDqueue<ExtChar> t1,t2,t3,t4;
Pair<ChainDqueue<ExtChar>,ChainDqueue<ExtChar>> p1=null,p2=null,p3=null;
ExtString s1=null,s2=null;






if(!this.ifEmpty()&&sep!=null)
    {
        //////////////////////////////////////////
        //copying separators strings
        int vsp=0;
        sep_=new ChainDqueue<>();
        sep_.set(new ExtString(sep.get()));
        tmp_cd=sep_;
        sep=sep.next();
        while(sep!=null)
            {
                if(!sep.get().ifEmpty()){
            tmp_cd.next(new ChainDqueue<>());
            tmp_cd.next().before(tmp_cd);
            tmp_cd=tmp_cd.next();
            
            tmp_cd.set(new ExtString(sep.get()));
            
                }
            sep=sep.next();
            }
        sep=sep_;
        
        ////////////////////////////////////////
        t1=this.chains().first();
        t2=t1;
        //t1=null;
        while(t2!=null)
            {
            sep_=sep;
            t3=t2;
            vsp=0;
            while(sep_!=null)
                {
                t3=t2;
                t4=sep_.get().chains().first();
                while(t4!=null&&t3!=null)
                    if(t4.get().charValue()==t3.get().charValue())
                        {
                        t4=t4.next();
                        t3=t3.next();
                        }
                        else break;
                if(t4==null)
                    {
                    if(t3==null)
                        {
                        vsp=1;
                        if(t1!=null&&t1!=t2)
                            {
                            if(ans==null)
                                {
                                ans=new ChainDqueue<>();
                                tmp_cd=ans;
                                }
                            else
                                {
                                tmp_cd.next(new ChainDqueue<>());
                                tmp_cd.next().before(tmp_cd);
                                tmp_cd=tmp_cd.next();
                                }
                            
                            tmp_cd.set(new ExtString(t1,t2.before()));
                            }
                        if(I%2==0)
                            {
                            if(ans==null)
                                {
                                ans=new ChainDqueue<>();
                                tmp_cd=ans;
                                }
                            else
                                {
                                tmp_cd.next(new ChainDqueue<>());
                                tmp_cd.next().before(tmp_cd);
                                tmp_cd=tmp_cd.next();
                                }
                            tmp_cd.set(new ExtString(t2,t3));
                            }
                        t2=t3;
                        }
                        else
                        {
                        vsp=1;
                        if(t1!=null&&t2!=t1)
                            {
                            if(ans==null)
                                {
                                ans=new ChainDqueue<>();
                                tmp_cd=ans;
                                }
                            else
                                {
                                tmp_cd.next(new ChainDqueue<>());
                                tmp_cd.next().before(tmp_cd);
                                tmp_cd=tmp_cd.next();
                                }
                            tmp_cd.set(new ExtString(t1,t2.before()));
                            }
                        if(I%2==0)
                            {
                            if(ans==null)
                                {
                                ans=new ChainDqueue<>();
                                tmp_cd=ans;
                                }
                            else
                                {
                                tmp_cd.next(new ChainDqueue<>());
                                tmp_cd.next().before(tmp_cd);
                                tmp_cd=tmp_cd.next();
                                }
                            tmp_cd.set(new ExtString(t2,t3.before()));
                            }
                        t2=t3;
                        t1=t2;
                        }
                        break;
                        }
                sep_=sep_.next();
                }
            if(sep_==null)
            t2=t2.next();
            }
        if(vsp==0&&t1!=null)
                {
                if(ans==null)
                                {
                                ans=new ChainDqueue<>();
                                tmp_cd=ans;
                                }
                            else
                                {
                                tmp_cd.next(new ChainDqueue<>());
                                tmp_cd.next().before(tmp_cd);
                                tmp_cd=tmp_cd.next();
                                }
                tmp_cd.set(new ExtString(t1,this.chains().second()));
                }
            
    }


return ans;
}


//nutshell for toStr
/**
Just  see ExtString.toStr()
@see extJavaLib.extStringLib.ExtString.toStr()
*/
public String toString()
{
String ans= new String("");
if(this.h!=null && this.t!=null)
    ans=this.toStr();
return ans;
}


//convert ExtString to String
/**
 It convert ExtString to String; It is to use for output;
 I can not remember why i did it protected so i make public method toString() that uses toStr().
 @return String
 @version 1.0

 */
protected String toStr()
{
String otvet="";
ChainDqueue<ExtChar> tt=this.t;
while(tt!=null)
	{
	otvet=tt.get().charValue()+otvet;
	tt=tt.before();
	}

return otvet;
}

/**
 It concattinates two ExtString
	s1 and s2 become s1s2 
 */
public static ExtString cat(ExtString s1, ExtString s2)
{ s1=new ExtString(s1);
	s2=new ExtString(s2);
ExtString otvet=null;
if(s1.ifEmpty())
if(s2.ifEmpty())
	{
	otvet=new ExtString();
	}
else
	{
	otvet=s2;
	}
else
	if(s2.ifEmpty())
	{
	otvet=s1;
	}
else
{
ChainDqueue<ExtChar> a1=null,a2=null,a3=null,a4=null;
Pair<ChainDqueue<ExtChar>,ChainDqueue<ExtChar>> sp1=s1.chains(),sp2=s2.chains();

sp1.second().next(sp2.first());
sp2.first().before(sp1.second());
a1=sp1.first();
//return s1;
otvet = new ExtString(sp1.first(),sp2.second());
}
return otvet;
}
 

/*
 
 it is unuseless
 
  */
//@Deprecated
public boolean empty(){return this.h==null;}



///////////////////////////////
///////////////////////////////
///////////////////////////////
///////////////////////////////
///////////////////////////////
///////////////////////////////
///////////////////////////////

		
	


}


