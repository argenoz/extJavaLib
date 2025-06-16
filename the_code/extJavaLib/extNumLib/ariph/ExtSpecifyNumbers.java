package extJavaLib.extNumLib.ariph;

import extJavaLib.baseBlockLib.ChainDqueue;
import extJavaLib.baseBlockLib.ChainStack;
import extJavaLib.baseBlockLib.Pair;        
//////////////////////////////////////////////////
//////////////////////////////////////////////////
//////////////////////////////////////////////////
//////////////////////////////////////////////////
//////////////////////////////////////////////////
import extJavaLib.extJavaLibExceptions.ExtJavaLibExceptions.ExtNumLibExceptions.ExtNumLibException;


public class ExtSpecifyNumbers {
    
   public static final String[] errs; 
    
   public static final ExtInteger 
                        ZERO,
                        UNITY,
                        BINARY,
                        TRINITY,
                        EIGHT,
                        DECI,
                        HEX,
                        ONE_BYTE,
                        ONE_EXTCHAR;
   
   static 
    {
       ExtInteger tmp;
       ZERO = ExtInteger.N;//0
       UNITY = ExtInteger.E;//1
       tmp = new ExtInteger(UNITY);//1
       tmp.add(tmp);//2
       BINARY = tmp;//2
       tmp = new ExtInteger(BINARY);//2
       tmp.add(UNITY);//3
       TRINITY = tmp;//3
       EIGHT = BINARY.pow(tmp);//8
       tmp = new ExtInteger(tmp);//3
       tmp.add(BINARY);//5
       tmp.mul(BINARY);//10
       DECI = tmp;
       tmp = new ExtInteger(DECI);//10
       tmp.sub(BINARY);//8
       tmp.add(tmp);//16
       HEX = tmp;
       ONE_BYTE = tmp.pow(BINARY);
       tmp = null;
       ONE_EXTCHAR = ONE_BYTE.pow(BINARY);
       ///////////////////////////////////////////////////
       errs = new String[4];
       errs[0] = "NullPointer argument is forbidden.";
       errs[1] = "Incorrect argument(s).";
       errs[2] = "Base(first argument for constructor) must be greater than 1.";
       errs[3] = "Lenght(second argument for constructor) must be greater than zero.";
   }
   
   public static ExtNumLibException except(int i)
    {
    return except(errs[i]);
    }
   
   public static ExtNumLibException except(String s)
    {
    return new ExtNumLibException(new String(s));
    }
    
    public static final class DeductionClassRing
        {
        
        private ExtInteger baze;
        //ExtSpecifyNumbers
        public ExtInteger get_baze(){return new ExtInteger(this.baze);}
        public DeductionClassRing(ExtInteger i)
            {
            if(i==null)
                throw ExtSpecifyNumbers.except(0);
            else
                if(i.zero()==0)
                throw ExtSpecifyNumbers.except("baze(argument) must be greater than zero.");
                else
                    this.baze = new ExtInteger(i);
            }
        
        public DeductionClassRing()
            {
                this(new ExtInteger(ExtSpecifyNumbers.ONE_EXTCHAR));
            }
        
        private boolean ifCorrect(Deduct a, Deduct b)
            {
            boolean ans ;
            DeductionClassRing da = a.get_Domain(), db = b.get_Domain();
            if(da==this && db ==this)
                ans = true;
            else
                if(da.get_baze().srav(db.get_baze())==0)
                    ans = true;
                else
                    ans = false;
            return ans;
            }
        
        public Deduct new_Deduct(ExtInteger i)
            {
            return this.new Deduct(i);
            }
        public Deduct new_Deduct()
            {
            return this.new Deduct();
            }
        public Deduct new_Deduct(Deduct d)
            {
            return this.new Deduct(d);
            }
        
        public Deduct sum(Deduct a, Deduct b)
            {
            ExtInteger i_tmp;
                if(a==null || b==null)
                    throw ExtSpecifyNumbers.except(0);
                else
                    if(!this.ifCorrect(a,b))
                        throw ExtSpecifyNumbers.except(1);
                    else
                    {
                    i_tmp = a.to_ExtInteger();
                    i_tmp.add(b.to_ExtInteger());
                    a = this.new_Deduct(i_tmp);
                    }
            return a;    
            }
        
        public Deduct sub(Deduct a, Deduct b)
            {
            ExtInteger i_tmp;
                if(a==null || b==null)
                    throw ExtSpecifyNumbers.except(0);
                else
                    if(!this.ifCorrect(a,b))
                        throw ExtSpecifyNumbers.except(1);
                    else
                    {
                    i_tmp = this.get_baze();
                    i_tmp.sub(b.to_ExtInteger());
                    i_tmp.add(a.to_ExtInteger());
                    a = this.new_Deduct(i_tmp);
                    }
            return a;    
            }
        
         public Deduct prod(Deduct a, Deduct b)
            {
            ExtInteger i_tmp;
                if(a==null || b==null)
                    throw ExtSpecifyNumbers.except(0);
                else
                    if(!this.ifCorrect(a,b))
                        throw ExtSpecifyNumbers.except(1);
                    else
                    {
                    i_tmp=(b.to_ExtInteger());
                    i_tmp.mul(a.to_ExtInteger());
                    a = this.new_Deduct(i_tmp);
                    }
            return a;    
            }
        
        
        
        public class Deduct
            {
            private ExtInteger ddct;
            
            public Deduct(){this.ddct=ExtSpecifyNumbers.ZERO;}
            public Deduct(ExtInteger i)
                    {
                    if(i==null)
                        throw ExtSpecifyNumbers.except(0);
                    else
                        this.ddct = ExtInteger.QR(i, baze)[1];
                    }
            public Deduct(Deduct d)
                    { 
                    if(DeductionClassRing.this.ifCorrect(this,d))
                        this.ddct = new ExtInteger(d.to_ExtInteger());
                    else
                        throw ExtSpecifyNumbers.except(1);
                    }
            
            
            public DeductionClassRing get_Domain()
                    {
                    return DeductionClassRing.this;
                    }
            
            public ExtInteger get_baze(){return this.get_Domain().get_baze();}
            
            public ExtInteger to_ExtInteger(){return new ExtInteger(this.ddct);}
            
            }
        
    
    }
    
    public static class ExtFixedLenghtIntegerNumbersClass
        {
        private ExtInteger baze,lenght;
        
        public ExtFixedLenghtIntegerNumbersClass()
            {
            this.baze = new ExtInteger(ExtSpecifyNumbers.ONE_EXTCHAR);
            //this.lenght = this.baze;
            this.lenght = new ExtInteger(this.baze);
            }
        
        public Pair<ExtInteger,ExtInteger> getAll()
            {
            Pair<ExtInteger,ExtInteger> ans=new Pair<ExtInteger,ExtInteger>();
            ans.first(new ExtInteger(this.baze));
            ans.second(new ExtInteger(this.lenght));
            return ans;
            }
        
        public ExtFixedLenghtIntegerNumbersClass(ExtFixedLenghtIntegerNumbersClass a)
            {
             Pair<ExtInteger,ExtInteger> tmp;
            if(a==null)
                throw ExtSpecifyNumbers.except(0);
            else
                {
                tmp = a.getAll();
                this.baze = tmp.first();
                this.lenght = tmp.second();
                }
            }
        
        
        public ExtFixedLenghtIntegerNumbersClass(ExtInteger base, ExtInteger len)
            {
            if(base==null || len==null)
                throw ExtSpecifyNumbers.except(0);
            else
                if(base.srav(ExtSpecifyNumbers.BINARY)==2)
                    throw ExtSpecifyNumbers.except(2);
                else
                if(len.srav(ExtSpecifyNumbers.ZERO)==0)
                    throw ExtSpecifyNumbers.except(3);
                else
                    {
                    this.baze = new ExtInteger(base);
                    this.lenght = new ExtInteger(len);
                    }
            }
        
        
        public ExtFixedLenghtIntegerNumber new_ExtFixedLenghtIntegerNumber()
            {
            return this.new ExtFixedLenghtIntegerNumber();
            }
        
        public ExtFixedLenghtIntegerNumber new_ExtFixedLenghtIntegerNumber(ExtInteger i)
            {
            return this.new ExtFixedLenghtIntegerNumber(i);
            }
        
        public ExtFixedLenghtIntegerNumber new_ExtFixedLenghtIntegerNumber(ExtFixedLenghtIntegerNumber i)
            {
            ExtFixedLenghtIntegerNumbersClass d_tmp = i.get_Domain();
            Pair<ExtInteger,ExtInteger> p_tmp;
            ExtFixedLenghtIntegerNumber ans;
            if(this == d_tmp)
                ans = this.new ExtFixedLenghtIntegerNumber(i.to_ExtInteger());
            else
                {
                p_tmp = d_tmp.getAll();
                if(this.baze.srav(p_tmp.first())==0 && this.lenght.srav(p_tmp.second())==0 )
                   ans = this.new ExtFixedLenghtIntegerNumber(i.to_ExtInteger());
                else
                    throw ExtSpecifyNumbers.except(1);
                }
            return ans;
            }
        
        
        
        
        private boolean ifCorrect(ExtFixedLenghtIntegerNumber a, ExtFixedLenghtIntegerNumber b)
            {
            boolean ans;
            ExtFixedLenghtIntegerNumbersClass da = a.get_Domain(),
                                              db = b.get_Domain();
            Pair<ExtInteger,ExtInteger> pa,pb;
            if(da == this && db == this)
                ans = true;
            else
                {
                pa = da.getAll();
                pb = db.getAll();
                if(pa.first().srav(pb.first())==0 && pa.second().srav(pb.second())==0 )
                    ans = true;
                else
                    ans = false;
                }
            return ans;
            }
        
        public ExtFixedLenghtIntegerNumber sum(ExtFixedLenghtIntegerNumber a , ExtFixedLenghtIntegerNumber b)
            {
            ChainStack<ExtInteger> sa,sb,st1,ans_st;
            ExtInteger[] tmp;
            if(this.ifCorrect(a, b))
                {
                    sa = a.to_ChainStack();
                    sb = b.to_ChainStack();
                    a = null;
                    b = null;
                    ans_st = sa;
                    sa.get().add(sb.get());
                    tmp = ExtInteger.QR(sa.get(), ExtFixedLenghtIntegerNumbersClass.this.baze);
                    sa.set(tmp[1]);
                    sa = sa.next();
                    sb = sb.next();
                    //st1 = sa;
                    //st2 = sb;
                    while(sa!=null)
                        if(tmp[0].zero()==0)
                            {
                            sa.get().add(sb.get());
                            tmp = ExtInteger.QR(sa.get(), ExtFixedLenghtIntegerNumbersClass.this.baze);
                            sa.set(tmp[1]);
                            sa = sa.next();
                            sb = sb.next();
                            //st1 = sa;
                            //st2 = sb;
                            }
                        else
                            {
                            st1 = sa;
                            while(st1!=null)
                                {
                                st1.get().add(tmp[0]);
                                tmp = ExtInteger.QR(st1.get(), ExtFixedLenghtIntegerNumbersClass.this.baze);
                                st1.set(tmp[1]);
                                if(tmp[0].zero()==0){ st1 = null; break;}
                                else
                                st1 = st1.next();
                                }
                            }
                    
                    a = this.new ExtFixedLenghtIntegerNumber(ans_st);
                }
            else
                throw ExtSpecifyNumbers.except(1);
            
            /*    
            ExtInteger i_tmp;
            if(this.ifCorrect(a, b))
                {
                i_tmp = a.to_ExtInteger();
                i_tmp.add(b.to_ExtInteger());
                a = this.new ExtFixedLenghtIntegerNumber(i_tmp);
                }
            else
                throw ExtSpecifyNumbers.except(1);
            */
            return a;
            }
        
        public ExtFixedLenghtIntegerNumber sub(ExtFixedLenghtIntegerNumber a , ExtFixedLenghtIntegerNumber b)
            {
            ChainStack<ExtInteger> st,st_tmp;
            ExtInteger tmp;
            if(this.ifCorrect(a, b))
                {
                    /*
                   st = b.to_ChainStack();
                   st_tmp = st;
                   while(st_tmp!=null)
                    {
                        if(st_tmp.get().zero()!=0)
                            {
                            tmp = new ExtInteger(ExtFixedLenghtIntegerNumbersClass.this.baze);
                            tmp.sub(st_tmp.get());
                            st_tmp.set(tmp);
                            }
                        st_tmp = st_tmp.next();
                    }
                   b = this.new ExtFixedLenghtIntegerNumber(st);
                   a = this.sum(a, b);
                   */
                   b = this.invert(b);
                   a = this.sum(a, b);
                }
            else
                throw ExtSpecifyNumbers.except(1);
            return a;
            }
        
        public ExtFixedLenghtIntegerNumber invert(ExtFixedLenghtIntegerNumber a )
            {
            ChainStack<ExtInteger> st,st_tmp;
            Pair<ExtInteger,ExtInteger> pa;
            ExtInteger tmp,bz;
            if(this!=a.get_Domain())
               throw ExtSpecifyNumbers.except(1);
            pa = a.get_Domain().getAll();
            
            if(this.baze.srav(pa.first())==0 && this.lenght.srav(pa.second())==0 )
                {
                   st = a.to_ChainStack();
                   st_tmp = st;
                   bz = new ExtInteger(ExtFixedLenghtIntegerNumbersClass.this.baze);
                   bz.sub(ExtSpecifyNumbers.UNITY);
                   while(st_tmp!=null)
                    {
                        tmp = new ExtInteger(bz);
                        tmp.sub(st_tmp.get());
                        st_tmp.set(tmp);
                        st_tmp = st_tmp.next();
                        /*
                        if(st_tmp.get().zero()!=0)
                            {
                            tmp = new ExtInteger(ExtFixedLenghtIntegerNumbersClass.this.baze);
                            tmp.sub(st_tmp.get());
                            st_tmp.set(tmp);
                            }
                        st_tmp = st_tmp.next();
                        */
                    }
                   a = this.new ExtFixedLenghtIntegerNumber(st);
                   a = this.sum(a, this.new ExtFixedLenghtIntegerNumber(ExtSpecifyNumbers.UNITY));
                   //a = this.sum(a, b);
                }
            else
                throw ExtSpecifyNumbers.except(1);
            return a;
            }
        
        
        public ExtFixedLenghtIntegerNumber prod(ExtFixedLenghtIntegerNumber a , ExtFixedLenghtIntegerNumber b)
            {
            ChainStack<ExtInteger> st,st_tmp;
            ExtInteger tmp;
            if(this.ifCorrect(a, b))
                {
                   tmp = a.to_ExtInteger();
                   tmp.mul(b.to_ExtInteger());
                   a = this.new ExtFixedLenghtIntegerNumber(tmp);
                }
            else
                throw ExtSpecifyNumbers.except(1);
            return a;
            } 
        
        
        public class ExtFixedLenghtIntegerNumber
            {        
            private ChainStack<ExtInteger> th;
            
            
            public ChainStack<ExtInteger> to_ChainStack()
                {
                ChainStack<ExtInteger> ans,tmp,tail;
                ans = new ChainStack<>();
                ans.set(new ExtInteger(this.th.get()));
                tail = ans;
                tmp = th.next();
                while(tmp!=null)
                    {
                    tail.next(new ChainStack<>());
                    tail = tail.next();
                    tail.set(new ExtInteger(tmp.get()));
                    tmp = tmp.next();
                    }
                return ans;
                }
            
            public ExtInteger to_ExtInteger()
                {
                ExtInteger ans = new ExtInteger(),mn,tmp;
                ChainStack<ExtInteger> t;
                mn = new ExtInteger(ExtSpecifyNumbers.UNITY);
                t = this.th;
                while(true)
                    {
                    tmp = new ExtInteger(t.get());
                    tmp.mul(mn);
                    ans.add(tmp);
                    t = t.next();
                    if(t==null)
                        break;
                    else
                        mn.mul(ExtFixedLenghtIntegerNumbersClass.this.baze);
                    
                    }
                return ans;
                }
            
            public ExtFixedLenghtIntegerNumbersClass get_Domain()
                    {
                    return ExtFixedLenghtIntegerNumbersClass.this;
                    }
            
            public ExtFixedLenghtIntegerNumber()
                {
                ExtInteger i;
                ChainStack<ExtInteger> tmp;
                i = new ExtInteger(ExtFixedLenghtIntegerNumbersClass.this.lenght);
                i.sub(ExtSpecifyNumbers.UNITY);
                th = new ChainStack<>();
                th.set(new ExtInteger());
                tmp =th;
                if(i.srav(ExtSpecifyNumbers.ZERO)!=0)
                do
                    {
                    i.sub(ExtSpecifyNumbers.UNITY);
                    tmp.next(new ChainStack<>());
                    tmp = tmp.next();
                    tmp.set(new ExtInteger());
                    }
                while(i.srav(ExtSpecifyNumbers.ZERO)!=0);
                }
            
            
            public ExtFixedLenghtIntegerNumber(ChainStack<ExtInteger> st)
                {
                ExtInteger i = new ExtInteger(ExtFixedLenghtIntegerNumbersClass.this.lenght);
                ChainStack<ExtInteger> s1;
                if(st==null)
                    {
                    this.th = new ChainStack<>();
                    s1 = this.th;
                    s1.set(new ExtInteger());
                    i.sub(ExtSpecifyNumbers.UNITY);
                    if(i.srav(ExtSpecifyNumbers.ZERO)!=0)
                    do
                        {
                        i.sub(ExtSpecifyNumbers.UNITY);
                        s1.next(new ChainStack<>());
                        s1 = s1.next();
                        s1.set(new ExtInteger());
                        }
                    while(i.srav(ExtSpecifyNumbers.ZERO)!=0);
                    }
                else
                    {
                    this.th = new ChainStack<>();
                    s1 = this.th;
                    s1.set(st.get());
                    st = st.next();
                    i.sub(ExtSpecifyNumbers.UNITY);
                    if(i.srav(ExtSpecifyNumbers.ZERO)!=0)
                    do
                        if(st!=null)
                            {
                            i.sub(ExtSpecifyNumbers.UNITY);
                            s1.next(new ChainStack<>());
                            s1 = s1.next();
                            s1.set(st.get());
                            st = st.next();
                            }
                        else
                            {
                                do
                                    {
                                      i.sub(ExtSpecifyNumbers.UNITY);
                                      s1.next(new ChainStack<>());
                                      s1 = s1.next();
                                      s1.set(new ExtInteger());
                                    }
                                while(i.srav(ExtSpecifyNumbers.ZERO)!=0);
                                break;
                            }
                            
                    while(i.srav(ExtSpecifyNumbers.ZERO)!=0);
                    }
                
                
                }
            
            public ExtFixedLenghtIntegerNumber(ExtInteger e)
                {
                    ExtInteger i;
                    ExtInteger[] tmp;
                    ChainStack<ExtInteger> st_tmp;
                    i = new ExtInteger(ExtFixedLenghtIntegerNumbersClass.this.lenght);
                    if(e.zero()==0)
                        {
                        this.th = new ChainStack<>();
                        st_tmp = this.th;
                        this.th.set(new ExtInteger());
                        i.sub(ExtSpecifyNumbers.UNITY);
                        if(i.srav(ExtSpecifyNumbers.ZERO)!=0)
                        do
                            {
                            i.sub(ExtSpecifyNumbers.UNITY);
                            st_tmp.next(new ChainStack<>());
                            st_tmp = st_tmp.next();
                            st_tmp.set(new ExtInteger());
                            }
                        while(i.srav(ExtSpecifyNumbers.ZERO)!=0);
                        }
                    else
                        {
                        tmp = ExtInteger.QR(e, ExtFixedLenghtIntegerNumbersClass.this.baze);
                        this.th = new ChainStack<>();
                        this.th.set(tmp[1]);
                        st_tmp = this.th;
                        i.sub(ExtSpecifyNumbers.UNITY);
                        if(i.srav(ExtSpecifyNumbers.ZERO)!=0)
                        do
                            if(tmp[0].zero()==0)
                                { 
                                tmp = null;
                                do
                                    {
                                    i.sub(ExtSpecifyNumbers.UNITY);
                                    st_tmp.next(new ChainStack<>());
                                    st_tmp = st_tmp.next();
                                    st_tmp.set(new ExtInteger());
                                    }
                                while(i.srav(ExtSpecifyNumbers.ZERO)!=0);
                                break;
                                }
                            else
                                {
                                i.sub(ExtSpecifyNumbers.UNITY);
                                st_tmp.next(new ChainStack<>());
                                st_tmp = st_tmp.next();
                                tmp = ExtInteger.QR(tmp[0], ExtFixedLenghtIntegerNumbersClass.this.baze);
                                st_tmp.set(tmp[1]);
                                }
                        while(i.srav(ExtSpecifyNumbers.ZERO)!=0);
                        }
                    
                }
            
            public String toString(){return this.to_ExtInteger().soutput_10();}
            
            }
        
        
        }
    
    
    
    
}
