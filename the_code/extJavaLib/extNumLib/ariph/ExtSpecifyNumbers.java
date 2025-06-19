package extJavaLib.extNumLib.ariph;

import extJavaLib.baseBlockLib.ChainDqueue;
import extJavaLib.baseBlockLib.ChainStack;
import extJavaLib.baseBlockLib.Pair;
//import extJavaLib.baseBlockLib.Trine; 
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
       errs = new String[10];
       errs[0] = "NullPointer argument is forbidden.";
       errs[1] = "Incorrect argument(s).";
       errs[2] = "Base(first argument for constructor) must be greater than 1.";
       errs[3] = "Lenght(second argument for constructor) must be greater than zero.";
       errs[4] = "Length of integer part(second argument) must be greater than zero.";
       errs[5] = "Length of fractional part(third argument) must be greater than zero.";
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
    
    public static class ExtFixedLenghtIntegerNumberClass
        {
        private ExtInteger baze,lenght,baze__;
        
        public ExtFixedLenghtIntegerNumberClass()
            {
            //this.baze = new ExtInteger(ExtSpecifyNumbers.ONE_EXTCHAR);
            //this.lenght = this.baze;
            //this.lenght = new ExtInteger(this.baze);
            //this.baze__ = this.baze.pow(this.lenght);
            this(ExtSpecifyNumbers.ONE_EXTCHAR,ExtSpecifyNumbers.ONE_EXTCHAR);
            }
        
        public Pair<ExtInteger,ExtInteger> getAll()
            {
            Pair<ExtInteger,ExtInteger> ans=new Pair<ExtInteger,ExtInteger>();
            ans.first(new ExtInteger(this.baze));
            ans.second(new ExtInteger(this.lenght));
            return ans;
            }
        
        public ExtFixedLenghtIntegerNumberClass(ExtFixedLenghtIntegerNumberClass a)
            {
             Pair<ExtInteger,ExtInteger> tmp;
            if(a==null)
                throw ExtSpecifyNumbers.except(0);
            else
                {
                tmp = a.getAll();
                this.baze = tmp.first();
                this.lenght = tmp.second();
                this.baze__ = this.baze.pow(this.lenght);
                }
            }
        
        
        public ExtFixedLenghtIntegerNumberClass(ExtInteger base, ExtInteger len)
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
                    this.baze__ = this.baze.pow(this.lenght);
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
            ExtFixedLenghtIntegerNumberClass d_tmp = i.get_Domain();
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
            ExtFixedLenghtIntegerNumberClass da = a.get_Domain(),
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
                    tmp = ExtInteger.QR(sa.get(), ExtFixedLenghtIntegerNumberClass.this.baze);
                    sa.set(tmp[1]);
                    sa = sa.next();
                    sb = sb.next();
                    //st1 = sa;
                    //st2 = sb;
                    while(sa!=null)
                        if(tmp[0].zero()==0)
                            {
                            sa.get().add(sb.get());
                            tmp = ExtInteger.QR(sa.get(), ExtFixedLenghtIntegerNumberClass.this.baze);
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
                                tmp = ExtInteger.QR(st1.get(), ExtFixedLenghtIntegerNumberClass.this.baze);
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
                            tmp = new ExtInteger(ExtFixedLenghtIntegerNumberClass.this.baze);
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
            return this.invert_2(a);
            }
        
        private ExtFixedLenghtIntegerNumber invert_1(ExtFixedLenghtIntegerNumber a )
            {
            Pair<ExtInteger,ExtInteger> pa;
            ExtInteger tmp;
            if(this!=a.get_Domain())
                {
                pa = a.get_Domain().getAll();
                if(this.baze.srav(pa.first())!=0 && this.lenght.srav(pa.second())!=0 )
                    throw ExtSpecifyNumbers.except(1);
                }
            tmp = new ExtInteger(ExtFixedLenghtIntegerNumberClass.this.baze__);
            tmp.sub(a.to_ExtInteger());
            a = this.new ExtFixedLenghtIntegerNumber(tmp);
            return a;
            }
        
        private ExtFixedLenghtIntegerNumber invert_2(ExtFixedLenghtIntegerNumber a )
            {
            ChainStack<ExtInteger> st,st_tmp;
            Pair<ExtInteger,ExtInteger> pa;
            ExtInteger tmp,bz;
            if(this!=a.get_Domain())
                {
                pa = a.get_Domain().getAll();
                if(this.baze.srav(pa.first())!=0 && this.lenght.srav(pa.second())!=0 )
                    throw ExtSpecifyNumbers.except(1);
                }
               
            
            
            //if(this.baze.srav(pa.first())==0 && this.lenght.srav(pa.second())==0 )
                {
                   st = a.to_ChainStack();
                   st_tmp = st;
                   bz = new ExtInteger(ExtFixedLenghtIntegerNumberClass.this.baze);
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
                            tmp = new ExtInteger(ExtFixedLenghtIntegerNumberClass.this.baze);
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
            //else
            //    throw ExtSpecifyNumbers.except(1);
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
                        mn.mul(ExtFixedLenghtIntegerNumberClass.this.baze);
                    
                    }
                return ans;
                }
            
            public ExtFixedLenghtIntegerNumberClass get_Domain()
                    {
                    return ExtFixedLenghtIntegerNumberClass.this;
                    }
            
            public ExtFixedLenghtIntegerNumber()
                {
                ExtInteger i;
                ChainStack<ExtInteger> tmp;
                i = new ExtInteger(ExtFixedLenghtIntegerNumberClass.this.lenght);
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
                ExtInteger i = new ExtInteger(ExtFixedLenghtIntegerNumberClass.this.lenght);
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
                    i = new ExtInteger(ExtFixedLenghtIntegerNumberClass.this.lenght);
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
                        tmp = ExtInteger.QR(e, ExtFixedLenghtIntegerNumberClass.this.baze);
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
                                tmp = ExtInteger.QR(tmp[0], ExtFixedLenghtIntegerNumberClass.this.baze);
                                st_tmp.set(tmp[1]);
                                }
                        while(i.srav(ExtSpecifyNumbers.ZERO)!=0);
                        }
                    
                }
            
            public String toString(){return this.to_ExtInteger().soutput_10();}
            public String to_String_()
                {
                String ans;
                ChainStack<ExtInteger> g;
                g = this.th;
                ans = new String("["+g.get().soutput_()+"]");
                g = g.next();
                while(g!=null)
                    {
                    //ans = ans + new String(";["+g.get().soutput_()+"]");
                    ans =  new String("["+g.get().soutput_()+"];")+ans;
                    g = g.next();
                    }
                return ans;
                }
            
            public String to_String_10()
                {
                String ans;
                ChainStack<ExtInteger> g;
                g = this.th;
                ans = new String("["+g.get().soutput_10()+"]");
                g = g.next();
                while(g!=null)
                    {
                    //ans = ans + new String(";["+g.get().soutput_10()+"]");
                    ans =  new String("["+g.get().soutput_10()+"];")+ans;
                    g = g.next();
                    }
                return ans;
                }
            
            }
        
        
        }
    
    public static final class ExtFixedPointNumberClass
        {
            private ExtFixedLenghtIntegerNumberClass line;
            private ExtInteger len_of_int_part,len_of_frac_part;
            
            public Pair<ExtInteger,Pair<ExtInteger,ExtInteger>> getAll()
                        {
                        Pair<ExtInteger,Pair<ExtInteger,ExtInteger>> ans;
                        ans = new Pair<ExtInteger,Pair<ExtInteger,ExtInteger>>();
                        ans.first(new ExtInteger(this.line.getAll().first()));
                        ans.second(new Pair<ExtInteger,ExtInteger>());
                        ans.second().first(new ExtInteger(this.len_of_int_part));
                        ans.second().second(new ExtInteger(this.len_of_frac_part));
                        return ans;
                        }
            public ExtFixedPointNumberClass()
                {
                this(ExtSpecifyNumbers.ONE_EXTCHAR,ExtSpecifyNumbers.HEX,ExtSpecifyNumbers.HEX);
                }
            
            public ExtFixedPointNumberClass(ExtInteger baze,ExtInteger int_part,ExtInteger frac_part)
                {
                if(baze==null || int_part == null || frac_part == null)
                    throw ExtSpecifyNumbers.except(0);
                else
                if(baze.srav(ExtSpecifyNumbers.UNITY)!=1)
                    throw ExtSpecifyNumbers.except(2);
                else
                if(int_part.srav(ExtSpecifyNumbers.ZERO)==0)
                    throw ExtSpecifyNumbers.except(4);
                else
                if(frac_part.srav(ExtSpecifyNumbers.ZERO)==0)
                    throw ExtSpecifyNumbers.except(5);
                this.len_of_int_part = new ExtInteger(int_part);
                this.len_of_frac_part = new ExtInteger(frac_part);
                int_part = new ExtInteger(int_part);
                int_part.add(frac_part);
                this.line = new ExtFixedLenghtIntegerNumberClass(new ExtInteger(baze),int_part);
                }
            
            public ExtFixedPointNumberClass(ExtFixedPointNumberClass cl)
                {
                Pair<ExtInteger,Pair<ExtInteger,ExtInteger>> p;
                if(cl==null)
                    throw ExtSpecifyNumbers.except(0);
                p = cl.getAll();
                this.len_of_int_part = new ExtInteger(p.second().first());
                this.len_of_frac_part = p.second().second();
                p.second().first().add(p.second().second());
                this.line = new ExtFixedLenghtIntegerNumberClass(p.first(),p.second().first());
                }
            
            public ExtFixedPointNumber sum(ExtFixedPointNumber a, ExtFixedPointNumber b)
                {
                ExtFixedPointNumber ans;
                ExtFixedLenghtIntegerNumberClass.ExtFixedLenghtIntegerNumber tmp;
                if(a == null || b == null)
                    throw ExtSpecifyNumbers.except(0);
                else
                    if(this.ifCorrect(a,b))
                        {
                        tmp = this.line.sum(
                                a.to_ExtFixedLenghtIntegerNumber()
                                , 
                                b.to_ExtFixedLenghtIntegerNumber()
                                );
                        ans = this.new_ExtFixedPointNumber(tmp);
                        }
                    else
                        throw ExtSpecifyNumbers.except(1);
                return ans;
                }
            
            private boolean ifCorrect(ExtFixedPointNumber a, ExtFixedPointNumber b)
                {
                boolean ans = false;
                ExtInteger ei;
                ExtFixedPointNumberClass ca,cb;
                Pair<ExtInteger,Pair<ExtInteger,ExtInteger>> pa,pb;
                ca = a.getDomain();
                cb = b.getDomain();
                if((ca == this && cb == this))
                    ans = true;
                else
ETTO:               {
                    pa = ca.getAll();
                    pb = cb.getAll();
                    ei = this.line.getAll().first();
                    if(ei.srav(pa.first())!=0 || ei.srav(pb.first())!=0 )
                        break ETTO;
                    ei = this.len_of_int_part;
                    if(ei.srav(pa.second().first())!=0 || ei.srav(pb.second().first())!=0 )
                        break ETTO;
                    ei = this.len_of_frac_part;
                    if(ei.srav(pa.second().second())!=0 || ei.srav(pb.second().second())!=0 )
                        break ETTO;
                    ans = true;
                    }
                return ans;
                }
            
            private boolean ifCorrect(ExtFixedPointNumber a)
                {
                boolean ans = false;
                ExtInteger ei;
                ExtFixedPointNumberClass ca;
                Pair<ExtInteger,Pair<ExtInteger,ExtInteger>> pa;
                ca = a.getDomain();
                if((ca == this ))
                    ans = true;
                else
ETTO:               {
                    pa = ca.getAll();
                    ei = this.line.getAll().first(); 
                    if(ei.srav(pa.first())!=0  )
                        break ETTO;
                    ei = this.len_of_int_part;
                    if(ei.srav(pa.second().first())!=0  )
                        break ETTO;
                    ei = this.len_of_frac_part;
                    if(ei.srav(pa.second().second())!=0)
                        break ETTO;
                    ans = true;
                    }
                
                return ans;
                }
            
            
            public ExtFixedPointNumber new_ExtFixedPointNumber()
                {
                return this.new ExtFixedPointNumber();
                }
            
            public ExtFixedPointNumber new_ExtFixedPointNumber(ExtInteger ei)
                {
                try{
                return this.new ExtFixedPointNumber(ei);
                        }
                catch(ExtNumLibException e){ throw ExtSpecifyNumbers.except(e.getI());  }
                }
            
            public ExtFixedPointNumber new_ExtFixedPointNumber(ExtFixedPointNumber ei)
                {
                Pair<ExtInteger,Pair<ExtInteger,ExtInteger>> p;
                if(ei==null)
                    throw ExtSpecifyNumbers.except(0);
                else
                if(ei.getDomain()!=this)
                    {
                    p = ei.getDomain().getAll();
                    if(this.len_of_int_part.srav(p.second().first())!=0 || this.len_of_frac_part.srav(p.second().second())!=0 || this.getAll().first().srav(p.first())!=0)
                        throw ExtSpecifyNumbers.except(1);
                    else
                        p = null;
                    }
                return this.new_ExtFixedPointNumber(ei.to_ExtInteger());
                }
            
            public ExtFixedPointNumber new_ExtFixedPointNumber(ExtFixedLenghtIntegerNumberClass.ExtFixedLenghtIntegerNumber ei)
                {
                ExtFixedPointNumber ans;
                try
                {
                 ans = this.new ExtFixedPointNumber(ei);
                }
                catch(ExtNumLibException e){ throw ExtSpecifyNumbers.except(e.getI());}
                
                return ans;
                } 
            
            
            public class ExtFixedPointNumber
                {
                    private ExtFixedLenghtIntegerNumberClass.ExtFixedLenghtIntegerNumber th;
                    
                    public ExtFixedPointNumberClass getDomain(){return ExtFixedPointNumberClass.this;}
                    
                    public ExtFixedPointNumber(){ this(ExtSpecifyNumbers.ZERO); }
                    
                    public ExtFixedPointNumber(ExtInteger g)
                            {
                            if(g==null)
                                throw ExtSpecifyNumbers.except(0);
                            else
                                g = new ExtInteger(g);
                            this.th = ExtFixedPointNumberClass.this.line.new ExtFixedLenghtIntegerNumber(g);
                            }
                    
                    public ExtFixedPointNumber(ExtFixedLenghtIntegerNumberClass.ExtFixedLenghtIntegerNumber a)
                        {
                        if(a==null)
                           throw ExtSpecifyNumbers.except(0);
                        else
                        try
                            {
                            this.th = ExtFixedPointNumberClass.this.line.new_ExtFixedLenghtIntegerNumber(a);
                            }
                        catch(ExtNumLibException e){ throw ExtSpecifyNumbers.except(e.getI());}
                        }
                    
                    
                    public ExtFixedLenghtIntegerNumberClass.ExtFixedLenghtIntegerNumber to_ExtFixedLenghtIntegerNumber()
                        {
                        return ExtFixedPointNumberClass.this.line.new_ExtFixedLenghtIntegerNumber(this.th);
                        }
                    
                    public ExtInteger to_ExtInteger()
                        {
                        return this.th.to_ExtInteger();
                        }
                    
                    
                    
                }
            
            
        
        
        }
    
    
    
    
    
    
}
