package extJavaLib.extStructLib;

import extJavaLib.extJavaLibExceptions.ExtJavaLibExceptions.ExtJavaLibBaseException;
        
//import extJavaLib.baseBlockLib.ChainStack;
import extJavaLib.baseBlockLib.*;

import extJavaLib.extNumLib.Ariphmetical;



public class BaseExtStructs
{
    public static class ExtStack<T>
        {
        ChainStack<T> s;
        
        public ExtStack()
            {
            this.s = null;
            }
        public boolean ifEmpty(){return this.s==null;}
        
        public T pop()
            {
            T ans=null;
            if(this.s==null)
                throw new ExtJavaLibBaseException("Stack is empty.");
            else
                {
                ans = s.get();
                s = s.next();
                }
            return ans;
            }
        
        public void push(T t)
            {
            ChainStack<T> ss;
            ss = new ChainStack<>();
            ss.set(t);
            ss.next(this.s);
            this.s=ss;
            }
        
        public Ariphmetical len()
            {
            Ariphmetical ans = Ariphmetical.N.cast(8);
            ChainStack<T> ss;
            ss = this.s;
            while(ss!=null)
                {
                ss=ss.next();
                ans = Ariphmetical.sum(ans,Ariphmetical.E);
                }
            return ans;
            }
        }
    
    public static class ExtQueue<T> extends ExtStack<T>
        {
            ChainStack<T> s_tail;
            public ExtQueue(){super();}
            
            @Override
            public void push(T t)
                {
                if(this.s==null)
                    {
                    this.s = this.s_tail = new ChainStack<>();
                    }
                else
                    {
                    this.s_tail.next(new ChainStack<>());
                    this.s_tail = this.s_tail.next();
                    }
                this.s_tail.set(t);
                }
            
            @Override
            public T pop()
                {
                    //T ans = null;
                    try
                        {
                        return super.pop();
                        //if(this.s==null)
                        //this.s_tail = null;
                        }
                    catch(ExtJavaLibBaseException e)
                        {throw e;}
                    //return ans;
                }
        }
    
    
    public static class ExtDqueue<T>
        {
        protected ChainDqueue<T> dh,dt;
        
        public ExtDqueue()
            {
            this.dh = null;
            this.dt = this.dh;
            }
        
        public void pushFront(T t)
            {
            if(this.dh==null)
                {
                this.dh = new ChainDqueue<>();
                this.dt = this.dh;
                this.dh.set(t);
                }
            else
                {
                this.dh.before(new ChainDqueue<>());
                this.dh.before().next(dh);
                this.dh = this.dh.before();
                this.dh.set(t);
                }
            }
        
        public void pushBack(T t)
            {
            if(this.dh==null)
                this.pushFront(t);
            else
                {
                this.dt.next(new ChainDqueue<>());
                this.dt.next().before(this.dt);
                this.dt = this.dt.next();
                this.dt.set(t);
                }
            }
        
        public T popFront()
            {
            T ans = null;
            if(this.dh==null)
                throw new ExtJavaLibBaseException("ExtDqueue is empty.");
            else
                {
                ans = this.dh.get();
                this.dh = this.dh.next();
                if(this.dh!=null)
                    this.dh.before(null);
                else
                    this.dt=null;
                }
            return ans;
            }
        
        public T popBack()
            {
            T ans = null;
            if(this.dh==null)
                throw new ExtJavaLibBaseException("ExtList is empty.");
            else
                {
                ans = this.dt.get();
                this.dt = this.dt.before();
                if(this.dt==null)
                    this.dh = null;
                else
                    this.dt.next(null);
                }
            return ans;
            }
        
        public Ariphmetical len()
            {
            Ariphmetical ans = Ariphmetical.N.cast(8);
            ChainDqueue<T> d;
            d = this.dh;
            while(d!=null)
                {
                d = d.next();
                ans = Ariphmetical.sum(Ariphmetical.E,ans);
                }
            return ans;
            }
        public boolean ifEmpty()
            {
            return this.dh==null;
            }
        
        }
    
    public static class ExtList<T> extends ExtDqueue<T>
        {
        protected Ariphmetical l;
        
        public ExtList()
            {
                super();
                l=Ariphmetical.N.cast(8);
            }
        
        @Override
        public void pushFront(T t)
            {
            T ans = null;
            Ariphmetical ll = this.l;
            try
                {
                this.l = Ariphmetical.sum(this.l,Ariphmetical.E);
                super.pushFront(t);
                }
            catch(ExtJavaLibBaseException e){ this.l=ll; throw e;}
            }
        @Override
        public void pushBack(T t)
            {
            T ans = null;
            Ariphmetical ll = this.l;
            try
                {
                this.l = Ariphmetical.sum(this.l,Ariphmetical.E);
                super.pushBack(t);
                }
            catch(ExtJavaLibBaseException e){ this.l=ll; throw e;}
            }
        
        
        @Override
        public T popFront()
            {
            T ans = null;
            Ariphmetical ll = this.l;
            try
                {
                ans = super.popFront();
                this.l = Ariphmetical.sub(this.l,Ariphmetical.E);
                }
            catch(ExtJavaLibBaseException e) {this.l=ll; throw new ExtJavaLibBaseException("ExtList is empty.");  }
            return ans;
            }
        
        @Override
        public T popBack()
            {
            T ans = null;
            Ariphmetical ll = this.l;
            try
                {
                ans = super.popBack();
                this.l = Ariphmetical.sub(this.l,Ariphmetical.E);
                }
            catch(ExtJavaLibBaseException e) {this.l=ll; throw new ExtJavaLibBaseException("ExtList is empty.");  }
            return ans;
            }
        
        @Override
        public Ariphmetical len()
            {
            return new Ariphmetical(this.l);
            }
        }
    
    public static class ExtArray<T> extends ExtList<T>
        {
        
        public ExtArray()
            {
            super();
            }
        
        public ExtArray(Ariphmetical i)
            {
            super();
            ExtJavaLibBaseException ex;
            ChainDqueue<T> d;
            if(i==null)
                ex = new ExtJavaLibBaseException("Null argument is forbidden.");
            else
            if(i.type()!=8)
                ex = new ExtJavaLibBaseException("Length must be ExtInteger subtype of Ariphmetical(8).");
            else
                ex = null;
            if(ex!=null)
                throw ex;
            else
                if(!i.zero())
                    {
                    this.l=i;
                    i = Ariphmetical.sub(i,Ariphmetical.E);
                    this.dh = new ChainDqueue<>();
                    d = this.dh;
                    while(!i.zero())
                        {
                        i = Ariphmetical.sub(i,Ariphmetical.E);
                        d.next(new ChainDqueue<>());
                        d.next().before(d);
                        d = d.next();
                        }
                    this.dt = d;
                    }
                    //else this.dt = this.dh=null;
            }
        
        
        private ExtJavaLibBaseException ifCorrectIndex(Ariphmetical i)
            {
            ExtJavaLibBaseException ex;
            if(i==null)
                ex = new ExtJavaLibBaseException("Null argument is forbidden.");
            else
            if(i.type()!=8)
                ex = new ExtJavaLibBaseException("Index must be ExtInteger subtype of Ariphmetical(8).");
            else
            if(Ariphmetical.cmp(i,this.l)==1)
                ex = null;
            else
                ex = new ExtJavaLibBaseException("Out of bounds.");
            return ex;
            }
        
        public T get(Ariphmetical i)
            {
            T ans = null;
            ChainDqueue<T> t;
            ExtJavaLibBaseException ex;
            
            if(this.ifEmpty())
                ex = new ExtJavaLibBaseException("ExtArray is empty.");
            else
                ex = ifCorrectIndex(i);
            if(ex!=null)
                throw ex;
            else
                {
                t = this.dh;
                i = new Ariphmetical(i);
                while(!i.zero())
                    {
                    i = Ariphmetical.sub(i,Ariphmetical.E);
                    t = t.next();
                    }
                ans = t.get();
                }
            return ans;
            }
        
        public void set(Ariphmetical i,T tt)
            {
            ChainDqueue<T> t;
            ExtJavaLibBaseException ex;
            
            if(this.ifEmpty())
                ex = new ExtJavaLibBaseException("ExtArray is empty.");
            else
                ex = ifCorrectIndex(i);
            if(ex!=null)
                throw ex;
            else
                {
                t = this.dh;
                i = new Ariphmetical(i);
                //this.l = i;
                //i = Ariphmetical.sub(i, Ariphmetical.E);
                while(!i.zero())
                    {
                    i = Ariphmetical.sub(i,Ariphmetical.E);
                    t = t.next();
                    }
                t.set(tt);
                }
            }
        
        @Deprecated
        @Override
        public void pushBack(T t)
            {
            throw new ExtJavaLibBaseException("ExtArray has fixed length.");
            }
        @Deprecated
        @Override
        public void pushFront(T t)
            {
            throw new ExtJavaLibBaseException("ExtArray has fixed length.");
            }
        @Deprecated
        @Override
        public T popBack()
            {
            throw new ExtJavaLibBaseException("ExtArray has fixed length.");
            }
        @Deprecated
        @Override
        public T popFront()
            {
            throw new ExtJavaLibBaseException("ExtArray has fixed length.");
            }
        
        
        }
    
    public static class ExtTuple<T>
        {
        private ExtArray<Object> a;
        private Ariphmetical dims;
        public ExtTuple()
            {
            a = null;
            }
        
        public ExtTuple(ExtArray<Ariphmetical> dim)
            {
            Ariphmetical q,E,i,j,k,dim_size,N;
            ChainStack<Pair<Ariphmetical,ExtArray<Object>>> st,st1;
            Pair<Ariphmetical,ExtArray<Object>> p,p1;
            int t;
           // boolean flg = true;
            if(dim==null)
                throw new ExtJavaLibBaseException("Null argument is forbidden.");
            dim_size = dim.len();
            E = Ariphmetical.E.cast(8);
            N = Ariphmetical.N.cast(8);
            i=N;
            st = new ChainStack<>();
            st.set(new Pair<>());
            st.get().first(N);
            st.get().second(new ExtArray<>(dim.get(i)));
            q = Ariphmetical.sub(dim_size,E);
            this.dims = dim_size;
            while(true)
                if(Ariphmetical.cmp(i,q)==3)
                    if(st.next()==null)
                        break;
                    else
                        {
                        p = st.get();
                        p1 = (st=st.next()).get();
                        p1.second().set(p1.first(),p.second());
                        p1.first(Ariphmetical.sum(p1.first(),E));
                        i = Ariphmetical.sub(i,E);
                        p1 = p = null;
                        }
                else
                    if(Ariphmetical.cmp(st.get().first(),dim.get(i))==3)
                        if(st.next()==null)
                            break;
                        else
                            {
                            p1 = st.get();
                            p = (st = st.next()).get();
                            p.second().set(p.first(),p1.second());
                            p.first(Ariphmetical.sum(E, p.first()));
                            p1 = p = null;
                            i = Ariphmetical.sub(i,E);
                            }
                    else
                        {
                        st1 = new ChainStack<>();
                        st1.next(st);
                        st = st1;
                        p = new Pair<>();
                        p.first(N);
                        i = Ariphmetical.sum(i,E);
                        p.second(new ExtArray<Object>(dim.get(i)));
                        st.set(p);
                        p1 = p = null;
                        }
                        this.a = st.get().second();
            }
        
            public T get(ExtArray<Ariphmetical> i)
                {
                T ans = null;
                Ariphmetical j,l,k;
                ExtArray<Object> a = this.a;
                j = Ariphmetical.N.cast(8);
                l = i.len();
                l = Ariphmetical.sub(l,Ariphmetical.E);
                while(true)
                    if(Ariphmetical.cmp(j,l)==3)
                        {
                        ans =(T) a.get(i.get(j));
                        break;
                        }
                    else
                        {
                        a =(ExtArray<Object>) a.get(i.get(j));
                        j = Ariphmetical.sum(Ariphmetical.E,j);
                        }
                    
                return ans;
                }
            
            public void set(ExtArray<Ariphmetical> i,T t)
                {
                Ariphmetical j,l,k;
                ExtArray<Object> a = this.a;
                j = Ariphmetical.N.cast(8);
                l = i.len();
                l = Ariphmetical.sub(l,Ariphmetical.E);
                while(true)
                    {
                    if(Ariphmetical.cmp(j,l)==3)
                        {
                        //ans =(T) a.get(i.get(j));
                        a.set(i.get(j),t);
                        break;
                        }
                    else
                        {
                        a =(ExtArray<Object>) a.get(i.get(j));
                        j = Ariphmetical.sum(Ariphmetical.E,j);
                        }
                    }
                }
        
        
        
        }
    
    
    
}
