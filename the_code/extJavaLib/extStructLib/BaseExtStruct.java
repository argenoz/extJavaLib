package extJavaLib.extStructLib;

import extJavaLib.extJavaLibExceptions.ExtJavaLibExceptions.ExtJavaLibBaseException;
        
import extJavaLib.baseBlockLib.ChainStack;
import extJavaLib.baseBlockLib.ChainDqueue;

import extJavaLib.extNumLib.Ariphmetical;



public class BaseExtStruct
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
        
        @Override
        public void pushBack(T t)
            {
            throw new ExtJavaLibBaseException("ExtArray has fixed length.");
            }
        
        @Override
        public void pushFront(T t)
            {
            throw new ExtJavaLibBaseException("ExtArray has fixed length.");
            }
        
        @Override
        public T popBack()
            {
            throw new ExtJavaLibBaseException("ExtArray has fixed length.");
            }
        
        @Override
        public T popFront()
            {
            throw new ExtJavaLibBaseException("ExtArray has fixed length.");
            }
        
        
        }
    
    
    
    
    
}
