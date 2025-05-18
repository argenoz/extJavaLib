
package extJavaLib.extStructLib;
import extJavaLib.extJavaLibExceptions.ExtJavaLibExceptions.ExtStructLibExceptions.ExtVectorException;
import extJavaLib.extNumLib.Ariphmetical;
import extJavaLib.extNumLib.Ariphmetical;
import extJavaLib.baseBlockLib.ChainDqueue;
import extJavaLib.baseBlockLib.Pair;

public final class ExtVector<T> {
    private ChainDqueue<T> s,ss;
    private Ariphmetical l;
    private AddE add;
    public ExtVector(){
                this.ss=null;
                this.s=null;this.l=new Ariphmetical(Ariphmetical.N);
                this.l=this.l.cast(8);
                this.add=new AddE(){
                            public Ariphmetical add(Ariphmetical w){return Ariphmetical.sum(Ariphmetical.E,w);}
                            public Ariphmetical sub(Ariphmetical w){return Ariphmetical.sub(w,Ariphmetical.E);}
                                    
                                    };
                        }
    public Ariphmetical len(){return new Ariphmetical(this.l);}
    public boolean empty(){return this.s==null;}
    public void pushFront(T w) 
        {
        ChainDqueue<T> tmp=new ChainDqueue<T>();
        if(this.s==null)
            {
            this.s=tmp;
            this.ss=this.s;
            this.s.set(w);
            }
        else
            {
            tmp.next(this.s);
            this.s.before(tmp);
            this.s=tmp;
            this.s.set(w);
            }
        this.l=this.add.add(this.l);
        }
    
    
    public void pushBack(T w)
        {
        ChainDqueue<T> tmp=new ChainDqueue<T>();
        if(this.s==null)
            {
            this.s=tmp;
            this.ss=this.s;
            this.s.set(w);
            }
        else
            {
            tmp.before(this.ss);
            this.ss.next(tmp);
            this.ss=tmp;
            this.ss.set(w);
            }
        this.l=this.add.add(this.l);
        }
    
    public T popFront()
    {
    T ans=null;
    if(this.s==null) throw new ExtVectorException("ExtVector object is empty.",1);
    ans=this.s.get();
    this.s=this.s.next();
    if(this.s==null)
        {
        this.ss=null;
        this.l=new Ariphmetical(Ariphmetical.N);
        this.l=this.l.cast(8);
        }
    else
        {
        this.s.before(null);
        this.l=this.add.sub(this.l);
        }
    return ans;
    }
    
    public T popBack()
    {
    T ans=null;
    if(this.s==null) throw new ExtVectorException("ExtVector object is empty.",1);
    ans=this.ss.get();
    this.ss=this.ss.before();
    if(this.ss==null)
        {
        this.s=null;
        this.l=new Ariphmetical(Ariphmetical.N);
        this.l=this.l.cast(8);
        }
    else
        {
        this.ss.next(null);
        this.l=this.add.sub(this.l);
        }
    return ans;
    }
    
    public void setEmpty()
        {
        this.s=null;
        this.ss=null;
        this.l=(Ariphmetical.N);
        this.l=this.l.cast(8);
        }
    
    public T get(Ariphmetical i)
    {
    T ans=null;
    ChainDqueue<T> tmp=null;
    int ii;
    if(this.empty()) throw new ExtVectorException("ExtVector object is empty.",1);
    ii=i.type();
    if(ii==6||ii==7||ii==9||ii==10)
        throw new ExtVectorException("Argument type for iteration must be non-negative integer.",2);
    if(Ariphmetical.cmp(this.len(), i)!=2)
        throw new ExtVectorException("Out of bounds.",3);
    tmp=this.s;
    while(!i.zero())
        {
        i=this.add.sub(i);
        tmp=tmp.next();
        }
    ans=tmp.get();
    return ans;
    }
    
    public void set(Ariphmetical i, T w)
    {
    ChainDqueue<T> tmp=null;
    int ii;
    if(this.empty()) throw new ExtVectorException("ExtVector object is empty.",1);
    ii=i.type();
    if(ii==6||ii==7||ii==9||ii==10)
        throw new ExtVectorException("Argument type for iteration must be non-negative integer.",2);
    if(Ariphmetical.cmp(this.len(), i)!=2)
        throw new ExtVectorException("Out of bounds.",3);
    tmp=this.s;
    while(!i.zero())
        {
        i=this.add.sub(i);
        tmp=tmp.next();
        }
    tmp.set(w);
    }
    
    public Pair<ExtVector<T>,ExtVector<T>> slice(Ariphmetical i)
    {
    Pair<ExtVector<T>,ExtVector<T>> ans=null;
    ExtVector v;
    Ariphmetical j=new Ariphmetical(0),k;
    int ii;
    if(this.empty()) throw new ExtVectorException("ExtVector object is empty.",1);
    k=this.len();
    if(i==null) throw new ExtVectorException("Null argument.",-1);
    ii=i.type();
    //if(Ariphmetical.cmp(k, i)!=2)
    if(ii==6||ii==7||ii==9||ii==10)
        throw new ExtVectorException("Argument type for iteration must be non-negative integer.",2);
    i=i.cast(8);
    j=j.cast(8);
    if(Ariphmetical.cmp(k, i)==1)
        throw new ExtVectorException("Out of bounds.",3);
    ans=new Pair<ExtVector<T>,ExtVector<T>>();
    //ans.first(new ExtVector<T>());
    //ans.second(new ExtVector<T>());
    v=new ExtVector<T>();
    while(Ariphmetical.cmp(j, i)==1)
        {
        //ans.first().pushBack(this.get(j));
        v.pushBack(this.get(j));
        j=this.add.add(j);
        }
    ans.first(v);
    v=new ExtVector<T>();
    while(Ariphmetical.cmp(j, k)==1)
        {
        //ans.second().pushBack(this.get(j));
        v.pushBack(this.get(j));
        j=this.add.add(j);
        }
    ans.second(v);
    return ans;
    }
    
    public Pair<ChainDqueue<T>,ChainDqueue<T>> toChainDqueue()
            {
            Pair<ChainDqueue<T>,ChainDqueue<T>> ans;
            ChainDqueue<T> vsp,h,t;
            ans=new Pair<ChainDqueue<T>,ChainDqueue<T>>();
            if(this.empty())
                {
                ans.first(null);
                ans.second(null);
                }
            else
                {
                vsp=this.s;
                h=new ChainDqueue<>();
                h.set(vsp.get());
                t=h;
                vsp=vsp.next();
                while(vsp!=null)
                    {
                    t.next(new ChainDqueue<>());
                    t.next().before(t);
                    t=t.next();
                    t.set(vsp.get());
                    vsp=vsp.next();
                    }
                ans.first(h);
                ans.second(t);
                }
            
            return ans;
            }
    
    
}


 interface AddE
{
public Ariphmetical add(Ariphmetical w);
public Ariphmetical sub(Ariphmetical w);
}
