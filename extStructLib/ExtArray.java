package extJavaLib.extStructLib;

import extJavaLib.extNumLib.Ariphmetical;
import extJavaLib.extStructLib.ExtVector;
import extJavaLib.extJavaLibExceptions.ExtJavaLibExceptions.ExtStructLibExceptions.ExtArrayException;


public final class ExtArray<T> {
    private ExtVector<T> w;
    private Ariphmetical l;
    public ExtArray(){this.w=null; this.l=Ariphmetical.N;}
    public ExtArray(Ariphmetical l)
            {
            if(l==null)
                throw new ExtArrayException("Null argument has been given.");
            int t=l.type();
            if(t==6||t==7||t==9||t==10||Ariphmetical.cmp(l,Ariphmetical.N)==1)
                throw new ExtArrayException("Length must be positive integer.");
            
            //this.l=new Ariphmetical(l);
            this.l=l.cast(8);
            w=new ExtVector<>();
            do
            {
            l=Ariphmetical.sub(l, Ariphmetical.E);
            w.pushBack(null);
            
            if(l.zero())
                break;
            }
            while(true);
            }
    public T item(Ariphmetical i)
    {
    int tmp=i.type();
    T ans=null;
    if(i==null)
            throw new ExtArrayException("Null index argument has been given.");
        else
    if(tmp==6||tmp==7||tmp==9||tmp==10||Ariphmetical.cmp(i,Ariphmetical.N)==1)
        throw new ExtArrayException("Index must be positive integer.");
    else
    if(Ariphmetical.cmp(this.l,i)==2&&Ariphmetical.cmp(this.l,Ariphmetical.N)!=1)
        ans=this.w.get(i);
    else throw new ExtArrayException("Out of bounds.");
    
    return ans;
    }
    public void item(Ariphmetical i, T t)
        {
        int tmp=i.type();
        if(i==null)
            throw new ExtArrayException("Null index argument has been given.");
        else
        if(tmp==6||tmp==7||tmp==9||tmp==10||Ariphmetical.cmp(i,Ariphmetical.N)==1)
        throw new ExtArrayException("Index must be positive integer.");
        else   
        if(Ariphmetical.cmp(this.l,i)==2&&Ariphmetical.cmp(this.l,Ariphmetical.N)!=1)
            this.w.set(i, t);
        else throw new ExtArrayException("Out of bounds.");
        }
    public Ariphmetical len(){return new Ariphmetical(this.l);}
    
}
