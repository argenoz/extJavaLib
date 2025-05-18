package extJavaLib.extStructLib;
import extJavaLib.extNumLib.Ariphmetical;
import extJavaLib.extStringLib.ExtString;
import extJavaLib.baseBlockLib.ChainDqueue;
import extJavaLib.baseBlockLib.ChainStack;
import extJavaLib.extStructLib.ExtStack;
import extJavaLib.baseBlockLib.Pair;
import extJavaLib.baseBlockLib.Trine;

import extJavaLib.extJavaLibExceptions.ExtJavaLibExceptions.ExtStructLibExceptions.ExtVectorException;
import extJavaLib.extJavaLibExceptions.ExtJavaLibExceptions.ExtStructLibExceptions.LogicalStructsExceptions.ExtJSONException;

public  class LogicalStructs
        {
        ///////////////////////////////
        ///////////////////////////////
        ///////////////////////////////
///////////////////////////////
///////////////////////////////
///////////////////////////////
///////////////////////////////
        public static final class ExtJSON
            {
            private Four<Ariphmetical,
                        ExtString,
                        ExtJSON_list,
                    ExtJSON_dict> 
                            j;
            private void nullify(){this.j=new Four<>();}
            public void toNothing(){this.nullify();}
            public ExtJSON(){this.toNothing();}
            public int type_(){return this.j.nutshell();}
            public int type()
                        {
                        int ans=this.type_();
                        if(ans==4)
                            ans=3;
                        else if(ans==8)
                            ans=4;
                        
                        return ans;
                        }
            
            public void set(Ariphmetical a)
                    {
                    if(a==null)
                        throw new ExtJSONException("Null argument has been given.");
                    toNothing();
                    this.j.first(new Ariphmetical(a));
                    }
            public void set(ExtString exs)
                    {
                    if(exs==null)
                        throw new ExtJSONException("Null argument has been given.");
                    toNothing();
                    this.j.second(new ExtString(exs));
                    }
            
            public void toAriphmetical()
                    {
                    this.set(Ariphmetical.N);
                    }
            public void toExtString()
                    {
                    this.set(new ExtString());
                    }
            public void toList()
                    {
                    if(this.type()!=3)
                    {
                    this.toNothing();
                    this.j.third(new ExtJSON_list());
                    }
                    }
            public void toDict()
                    {
                    if(this.type()!=4)
                    {
                    this.toNothing();
                    this.j.fourth(new ExtJSON_dict());
                    }
                    }
            public Ariphmetical len()
                    {
                    int tmp=this.type();
                    Ariphmetical ans=null;
                    if(tmp==3)
                        ans=this.j.third().len();
                    else
                        if(tmp==4)
                            ans=this.j.fourth().len();
                        else throw new ExtJSONException("Subtype is not list or dictionary.");
                    return ans;
                    }
            public Ariphmetical getAriphmetical()
                    {
                    if(this.type()==1)
                        return new Ariphmetical(this.j.first());
                        else throw new ExtJSONException("Type of ExtJSON object is not Ariphmetical.");
                    }
            public ExtString getExtString()
                    {
                    if(this.type()==2)
                        return new ExtString(this.j.second());
                        else throw new ExtJSONException("Type of ExtJSON object is not ExtString.");
                    }
            public ExtJSON get(Ariphmetical i)
                    {
                    if(this.type()==3)
                        return this.j.third().get(i);
                    else throw new ExtJSONException("Type of ExtJSON object is not ExtJSON_list.");
                    }
            public void list_set(Ariphmetical i,ExtJSON o)
                    {
                    if(this.type()==3)
                        this.j.third().set(i, o);
                        else throw new ExtJSONException("Subtype of subobject is not ExtJSON_list.");
                    }
            public ExtJSON list_get(Ariphmetical i)
                {
                ExtJSON ans;
                if(this.type()==3)
                    ans=this.j.third().get(i);
                else throw new ExtJSONException("Subtype of subobject is not ExtJSON_list.");
                return ans;
                }
            public void list_append(ExtJSON o)
                {
                if(this.type()==3)
                    this.j.third().append(o);
                else throw new ExtJSONException("Subtype of subobject is not ExtJSON_list.");
                }
            public void dict_set(ExtJSON a, ExtJSON b)
                {
                if(this.type()==4)
                    this.j.fourth().set(a, b);
                else throw new ExtJSONException("Subtype of subobject is not ExtJSON_dict.");
                }
            public ExtJSON dict_get(ExtJSON a)
                {
                ExtJSON ans;
                if(this.type()==4)
                    ans=this.j.fourth().get(a);
                else throw new ExtJSONException("Subtype of subobject is not ExtJSON_dict.");
                return ans;
                }
            public void dict_del(ExtJSON a)
                {
                if(this.type()==4)
                    this.j.fourth().del(a);
                else throw new ExtJSONException("Subtype of subobject is not ExtJSON_dict.");
                }
            
            public Four<Ariphmetical,ExtString,ChainDqueue<ExtJSON>,ChainDqueue<Pair<ExtJSON,ExtJSON>>> getAll()
            {
            Four<Ariphmetical,ExtString,ChainDqueue<ExtJSON>,ChainDqueue<Pair<ExtJSON,ExtJSON>>> ans=new Four<Ariphmetical,ExtString,ChainDqueue<ExtJSON>,ChainDqueue<Pair<ExtJSON,ExtJSON>>>();
            ans.first(null);
            ans.second(null);
            ans.third(null);
            ans.fourth(null);
            switch(this.type())
            {
                case 1:
                    {
                    ans.first(this.getAriphmetical());
                    break;
                    }
                case 2:
                    {
                    ans.second(this.getExtString());
                    break;
                    }
                case 3:
                    {
                    ans.third(this.j.third().toChainDqueue());
                    break;
                    }
                case 4:
                    {
                    ans.fourth(this.j.fourth().toChainDqueue().first());
                    break;
                    }
                
            }
            
            return ans;
            }
            
            public static int cmp(ExtJSON j1, ExtJSON j2)
            {
            int ans=0;
            int mod_=4;
            boolean a,b=true;
            ExtJSON_cmp_stack s=null,ss;
            s=new ExtJSON_cmp_stack(j1,j2,s);
            if(j1==j2)
                ans=0;
            else
ETTO:
            {
            while(s!=null)
                {
                if(s.t1==s.t2)
                    switch(s.t1)
                        {
                        case 0:
                            {
                            s=s.n;
                            if(s!=null)
                                {
                                s.res=0;
                                s.st=(s.st+1);
                                }
                            else
                                ans=0;
                            break;
                            }
                        case 1:
                            {
                            ans=Ariphmetical.cmp(s.o.first().first(), s.o.second().first());
                            if(ans==3) ans=0;
                            s=s.n;
                            if(s!=null)
                                {
                                s.st=s.st+1;
                                s.res=ans;
                                ans=0;
                                }
                            break;
                            }
                        case 2:
                            {
                            ans=ExtString.cmp(s.o.first().second(), s.o.second().second());
                            if(ans==3) ans=0;
                            s=s.n;
                            if(s!=null)
                                {
                                s.st=s.st+1;
                                s.res=ans;
                                ans=0;
                                }
                            break;
                            }
                        case 3:
                            {
                            switch(s.st)
                                {
                                case 0:
                                    {
                                    if(Ariphmetical.cmp(s.j.first().len(),s.j.second().len())==3)
                                        s.st=1;
                                    else
                                        {
                                        s.res=1;
                                        s.st=2;
                                        }
                                    break;
                                    }
                                case 1:
                                    {
                                    if(s.o.first().third()!=null&&s.o.second().third()!=null)
                                        s=new ExtJSON_cmp_stack(s.o.first().third().get(),s.o.second().third().get(),s);
                                    else
                                        {
                                        s=s.n;
                                        if(s!=null)
                                            {
                                            s.res=1;
                                            s.st=(s.st+1);
                                            }
                                            else ans=1;
                                        }
                                    break;
                                    }
                                case 2:
                                    {
                                    if(s.res==0)
                                        {
                                        s.o.first().third(s.o.first().third().next());
                                        s.o.second().third(s.o.second().third().next());
                                        s.st=0;
                                        }
                                    else
                                        {
                                        s=s.n;
                                        if(s!=null)
                                            {
                                            s.res=1;
                                            s.st=(s.st+1);
                                            }
                                            else ans=1;
                                        }
                                    break;
                                    }
                                }
                                
                            break;    
                            }
                        case 4:
                            {
                            switch(s.st)
                                {
                                
                                case 0:
                                    {
                                    
                                    if(3==Ariphmetical.cmp(s.j.first().len(),s.j.second().len()))
                                        s.st=1;
                                    else
                                        {
                                        s=s.n;
                                        if(s!=null)
                                            {
                                            s.st=s.st+1;
                                            s.res=1;
                                            }
                                            else ans=1;
                                        }
                                    break;
                                    }
                                case 1:
                                    {
                                    if(s.o.first().fourth().get()==null && s.o.second().fourth().get()==null)
                                        {
                                        s=s.n;
                                        if(s!=null)
                                            {
                                            s.st=s.st+1;
                                            s.res=0;
                                            }
                                            else ans=0;
                                        }
                                    else
                                    if(s.o.first().fourth().get()!=null && s.o.second().fourth().get()!=null)
                                        {
                                        s=new ExtJSON_cmp_stack(s.o.first().fourth().get().first(),s.o.second().fourth().get().first(),s);
                                        }
                                    else
                                        {
                                        s=s.n;
                                        if(s!=null)
                                            {
                                            s.st=s.st+1;
                                            s.res=1;
                                            }
                                            else ans=1;
                                        }
                                    break;
                                    }
                                case 2:
                                    {
                                    if(s.res==0)
                                        s.st=3;
                                    else
                                        
                                        if(s.o.second().fourth().next()!=null)
                                            {
                                            s.o.second().fourth(s.o.second().fourth().next());
                                            s.st=1;
                                            }
                                        else
                                            if(s.o.first().fourth().next()!=null)
                                                {
                                                s.st=1;
                                                s.o.first().fourth(s.o.first().fourth().next());
                                                s.o.second().fourth(s.h2);
                                                }
                                            else
                                                {
                                                s=s.n;
                                                if(s!=null)
                                                    {
                                                    s.st=s.st+1;
                                                    s.res=1;
                                                    }
                                                    else ans=1;
                                                }
                                        
                                        
                                    break;
                                    }
                                case 3:
                                    {
                                    s=new ExtJSON_cmp_stack(s.o.first().fourth().get().second(),s.o.second().fourth().get().second(),s);
                                    break;
                                    }
                                case 4:
                                    {
                                    if(s.res==0)
                                            {
                                            if(s.o.first().fourth().next()!=null)
                                                s.o.first().fourth().next().before(s.o.first().fourth().before());
                                            if(s.o.first().fourth().before()!=null)
                                                s.o.first().fourth().before().next(s.o.first().fourth().next());
                                            else
                                                {
                                                s.h1=s.o.first().fourth().next();
                                                s.h1.before(null);
                                                }
                                            if(s.o.second().fourth().next()!=null)
                                                s.o.second().fourth().next().before(s.o.second().fourth().before());
                                            if(s.o.second().fourth().before()!=null)
                                                s.o.second().fourth().before().next(s.o.second().fourth().next());
                                            else
                                                {
                                                s.h2=s.o.second().fourth().next();
                                                s.h2.before(null);
                                                }
                                            s.o.first().fourth(s.h1);
                                            s.o.second().fourth(s.h2);
                                            s.st=1;
                                            }
                                    else
                                        {
                                        s=s.n;
                                        if(s!=null)
                                            {
                                            s.st=s.st+1;
                                            s.res=1;
                                            }
                                            else ans=1;
                                        
                                        }
                                    break;
                                    }
                                }
                            break;
                            }
                        }
                else
                    {
                    s=s.n;
                    if(s!=null)
                        {
                        s.res=1;
                        s.st=(s.st+1);
                        }
                    else
                        ans=1;
                    }
                }//end of big circle.
            
            }
            return ans;
            }
            
            public final static class ExtJSON_list
            {
                private ExtVector<ExtJSON> l;
                public ExtJSON_list(){this.l=new ExtVector<>();}
                public Ariphmetical len(){return this.l.len();}
                public ExtJSON get(Ariphmetical i)
                        {
                        int tmp=i.type();
                        if(tmp==5||tmp==6||tmp==10||Ariphmetical.cmp(Ariphmetical.N,i)==2)
                            throw new ExtJSONException("Argument must be only positive integer.");
                        else
                            try{
                                return this.l.get(i);
                            }
                            catch(ExtVectorException ee)
                                    {
                                    throw new ExtJSONException("Out of bounds.");
                                    }
                        }
                public void set(Ariphmetical i, ExtJSON j)
                        {
                        int tmp=i.type();
                        if(tmp==5||tmp==6||tmp==10||Ariphmetical.cmp(Ariphmetical.N,i)==2)
                            throw new ExtJSONException("Argument must be only positive integer.");
                        else
                            try{
                                 this.l.set(i,j);
                            }
                            catch(ExtVectorException ee)
                                    {
                                    throw new ExtJSONException("Out of bounds.");
                                    }
                        }
                public void append(ExtJSON j)
                        {
                        this.l.pushBack(j);
                        }
                public ChainDqueue<ExtJSON> toChainDqueue()
                        {
                        return this.l.toChainDqueue().first();
                        }
            
            }
            
            public final static class ExtJSON_dict
                    {
                    private ChainDqueue<Pair<ExtJSON,ExtJSON>> d;
                    private Ariphmetical l;
                    public ExtJSON_dict(){l=Ariphmetical.N.cast(8);this.d=null;}
                    public Ariphmetical len(){return this.l.cast(8);}
                    public Pair<ChainDqueue<Pair<ExtJSON,ExtJSON>>,ChainDqueue<Pair<ExtJSON,ExtJSON>>> toChainDqueue()
                            {
                            Pair<ChainDqueue<Pair<ExtJSON,ExtJSON>>,ChainDqueue<Pair<ExtJSON,ExtJSON>>> ans=new Pair<ChainDqueue<Pair<ExtJSON,ExtJSON>>,ChainDqueue<Pair<ExtJSON,ExtJSON>>>();
                            ChainDqueue<Pair<ExtJSON,ExtJSON>> h,t,tmp;
                            if(this.d==null)
                            {
                            h=null;
                            t=null;}
                            else
                                {
                                h=new ChainDqueue<>();
                                h.set(new Pair<>());
                                h.get().first(this.d.get().first());
                                h.get().second(this.d.get().second());
                                tmp=this.d.next();
                                t=h;
                                while(tmp!=null)
                                    {
                                    t.next(new ChainDqueue<>());
                                    t.next().before(t);
                                    t=t.next();
                                    t.set(new Pair<>());
                                    t.get().first(tmp.get().first());
                                    t.get().second(tmp.get().second());
                                    tmp=tmp.next();
                                    }
                                }
                            ans.first(h);
                            ans.second(t);
                            return ans;
                            }
                    public void set(ExtJSON a, ExtJSON b)
                        {
                        ChainDqueue<Pair<ExtJSON,ExtJSON>> tmp;
                        if(a==null||b==null)
                            throw new ExtJSONException("Null argument has been given.");
                        tmp=this.d;
                        while(tmp!=null)
                            if(0==ExtJSON.cmp(tmp.get().first(),a))
                                break;
                            else
                               tmp=tmp.next();
                        if(tmp!=null)
                            tmp.get().second(b);
                        else
                            {
                            this.l=Ariphmetical.sum(this.l, Ariphmetical.E);
                            if(this.d!=null)
                                {
                                this.d.before(new ChainDqueue<>());
                                this.d.before().next(this.d);
                                this.d=this.d.before();
                                this.d.set(new Pair<>());
                                }
                                else
                                    {
                                    this.d=new ChainDqueue<>();
                                    this.d.set(new Pair<>());
                                    }
                                this.d.get().first(a);
                                this.d.get().second(b);
                            }
                        }
                    public ExtJSON get(ExtJSON a)
                        {
                        ExtJSON ans=null;
                        ChainDqueue<Pair<ExtJSON,ExtJSON>> tmp;
                        if(a==null)
                            throw new ExtJSONException("Null argument has been given.");
                        tmp=this.d;
                        while(tmp!=null)
                            if(0==ExtJSON.cmp(tmp.get().first(),a))
                                break;
                            else
                               tmp=tmp.next();
                        if(tmp!=null)
                            ans=tmp.get().second();
                        else throw new ExtJSONException("There is no ExtJSON object for given ExtJSON object.");
                        return ans;
                        }
                    public void del(ExtJSON a)
                        {
                        ChainDqueue<Pair<ExtJSON,ExtJSON>> tmp;
                        if(a==null)
                            throw new ExtJSONException("Null argument has been given.");
                        tmp=this.d;
                        while(tmp!=null)
                            if(0==ExtJSON.cmp(tmp.get().first(),a))
                                break;
                            else
                               tmp=tmp.next();
                        if(tmp!=null)
                            {
                            this.l=Ariphmetical.sub(this.l, Ariphmetical.E);
                            if(tmp.before()!=null)
                                {
                                tmp.before().next(tmp.next());
                                }
                                else this.d=tmp.next();
                            if(tmp.next()!=null)
                                tmp.next().before(tmp.before());
                            
                            }
                        else throw new ExtJSONException("There is no ExtJSON object for given ExtJSON object.");
                        }
                    public boolean empty()
                        {
                        return this.d==null;
                        }
                    
                    
                    }
            
            
            
            }
    
        
        }




final class  ExtJSON_cmp_stack
{
    public int res;
    public int t1,t2;
    public int st,mod_;
    public  Pair<LogicalStructs.ExtJSON,LogicalStructs.ExtJSON> j;
    public ExtJSON_cmp_stack n;
    public Pair<
                Four<
                    Ariphmetical,
                    ExtString,
                    ChainDqueue<LogicalStructs.ExtJSON>,
                    ChainDqueue<Pair<LogicalStructs.ExtJSON,LogicalStructs.ExtJSON>>
                    >,
                Four<
                    Ariphmetical,
                    ExtString,
                    ChainDqueue<LogicalStructs.ExtJSON>,
                    ChainDqueue<Pair<LogicalStructs.ExtJSON,LogicalStructs.ExtJSON>>
                    >
                > o;
    public  ChainDqueue<Pair<LogicalStructs.ExtJSON,LogicalStructs.ExtJSON>> h1,h2;
    private void nullify()
        {
        res=0;
        t1=0;
        t2=0;
        st=0;
        mod_=5;
        j=null;
        n=null;
        o=null;
        }
    
    public ExtJSON_cmp_stack()
            {
                nullify();
                //throw new ExtJSONException("Mist have been arguments.");
            }
    public ExtJSON_cmp_stack(LogicalStructs.ExtJSON j1, LogicalStructs.ExtJSON j2)
            {
            this();
            if(j1==null||j2==null)
                throw new ExtJSONException("Null argument has been given.");
            this.set(j1,j2);
            }
    public ExtJSON_cmp_stack(LogicalStructs.ExtJSON j1, LogicalStructs.ExtJSON j2,ExtJSON_cmp_stack nn)
            {
            this(j1,j2);
            this.n=nn;
            }
    private void set(LogicalStructs.ExtJSON j1, LogicalStructs.ExtJSON j2)
        {
        j=new Pair<>();
        j.first(j1);
        j.second(j2);
        o=new Pair<>();
        o.first(j.first().getAll());
        o.second(j.second().getAll());
        this.t1=this.j.first().type();
        this.t2=this.j.second().type();
        h1=o.first().fourth();
        h2=o.second().fourth();
        }
}


class Five<T1,T2,T3,T4,T5> extends Four<T1,T2,T3,T4>
{
    protected T5 e;
    Five(){super();this.e=null;}
    public T5 fifth(){return this.e;}
    public void fifth(T5 ewq) {this.e=ewq;}
    @Override
        public int nutshell()
            {
            int ans=0;
            if(this.e!=null)
                ans=16;
            ans=(ans|super.nutshell());
            return ans;
            }
    @Override
	public  boolean ifEmpty()
	{return this.nutshell()==0;}
    
}

 class Four<T1,T2,T3,T4> extends Trine<T1,T2,T3>
{
    protected T4 d;
    Four(){super();this.d=null;}
    public T4 fourth(){ return this.d;}
    public void fourth(T4 qwe){this.d=qwe;}
    @Override
	public int nutshell()
	{
	int otvet=0;
	if(this.d!=null)
		otvet=8;
	return (otvet|super.nutshell());
	}
@Override
	public  boolean ifEmpty()
	{return this.nutshell()==0;}
    
}
