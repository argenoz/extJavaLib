package extJavaLib.extNumLib.ariph;

import extJavaLib.baseBlockLib.ChainDqueue;
import extJavaLib.baseBlockLib.ChainStack;
import extJavaLib.baseBlockLib.Pair;
import extJavaLib.baseBlockLib.Trine; 
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
       errs = new String[12];
       errs[0] = "NullPointer argument is forbidden.";
       errs[1] = "Incorrect argument(s).";
       errs[2] = "Base(first argument for constructor) must be greater than 1.";
       errs[3] = "Lenght(second argument for constructor) must be greater than zero.";
       errs[4] = "Length of integer part(second argument) must be greater than zero.";
       errs[5] = "Length of fractional part(third argument) must be greater than zero.";
       errs[6] = "Sum of Length of integer part(second argument) and Length of fractional part(third argument) must be greater than zero.";
       errs[7] = "Base (first argument) must be greater than 1.";
       errs[8] = "Sum of integer part of mantiss and fractional part of mantiss must be greater than zero.";
       errs[9] = "Length of exponent must be greater than zero.";
       errs[10] = "NaN can not be converted into Racio";
       errs[11] = "Infinity can not be converted into Racio";
       
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
                ExtInteger tmp;
                if(baze==null || int_part == null || frac_part == null)
                    throw ExtSpecifyNumbers.except(0);
                else
                if(baze.srav(ExtSpecifyNumbers.UNITY)!=1)
                    throw ExtSpecifyNumbers.except(2);
                else
                    {
                      tmp = new ExtInteger(int_part); 
                      tmp.add(frac_part);
                      if(tmp.srav(ExtSpecifyNumbers.ZERO)==0)
                        throw ExtSpecifyNumbers.except(6);
                        /*
                if(int_part.srav(ExtSpecifyNumbers.ZERO)==0)
                    throw ExtSpecifyNumbers.except(4);
                else
                if(frac_part.srav(ExtSpecifyNumbers.ZERO)==0)
                    throw ExtSpecifyNumbers.except(5);
                */
                    }
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
                int i_cmp;
                ExtFixedPointNumber ans;
                ExtFixedLenghtIntegerNumberClass.ExtFixedLenghtIntegerNumber tmp;
                if(a == null || b == null)
                    throw ExtSpecifyNumbers.except(0);
                else
                    if(this.ifCorrect(a,b))
                        if((a.sign()+b.sign())%2==0)
                        {
                        tmp = this.line.sum(
                                a.to_ExtFixedLenghtIntegerNumber()
                                , 
                                b.to_ExtFixedLenghtIntegerNumber()
                                );
                        ans = this.new_ExtFixedPointNumber(tmp);
                        ans.sign(a.sign());
                        }
                        else
                        {
                        i_cmp = this.cmp(a, b);
                        if(i_cmp==3)
                            ans = this.new_ExtFixedPointNumber();
                        else
                            if(i_cmp==2)
                                {
                                tmp = this.line.sub(
                                a.to_ExtFixedLenghtIntegerNumber()
                                , 
                                b.to_ExtFixedLenghtIntegerNumber()
                                );
                                ans = this.new_ExtFixedPointNumber(tmp);
                                ans.sign(a.sign());
                                }
                            else
                                {
                                tmp = this.line.sub(
                                b.to_ExtFixedLenghtIntegerNumber()
                                , 
                                a.to_ExtFixedLenghtIntegerNumber()
                                );
                                ans = this.new_ExtFixedPointNumber(tmp);
                                ans.sign(b.sign());
                                }
                        }
                    else
                        throw ExtSpecifyNumbers.except(1);
                return ans;
                }
            
            public ExtFixedPointNumber sub(ExtFixedPointNumber a, ExtFixedPointNumber b)
                {
                ExtFixedPointNumber ans;
                ExtFixedLenghtIntegerNumberClass.ExtFixedLenghtIntegerNumber tmp;
                if(a == null || b == null)
                    throw ExtSpecifyNumbers.except(0);
                else
                    if(this.ifCorrect(a,b))
                        {
                        /*
                        tmp = this.line.sub(
                                a.to_ExtFixedLenghtIntegerNumber()
                                , 
                                b.to_ExtFixedLenghtIntegerNumber()
                                );
                        */
                        b = this.new_ExtFixedPointNumber(b);
                        b.sign((b.sign()+1)%2);
                        ans=this.sum(a,b);
                        //ans = this.new_ExtFixedPointNumber(tmp);
                        }
                    else
                        throw ExtSpecifyNumbers.except(1);
                return ans;
                }
           
            public ExtFixedPointNumber prod(ExtFixedPointNumber a, ExtFixedPointNumber b)
                {
                ExtFixedPointNumber ans;
                ExtInteger i_tmp,bz;
                ExtFixedLenghtIntegerNumberClass.ExtFixedLenghtIntegerNumber tmp;
                if(a == null || b == null)
                    throw ExtSpecifyNumbers.except(0);
                else
                    if(this.ifCorrect(a,b))
                        {
                        /*
                        tmp = this.line.prod(
                                a.to_ExtFixedLenghtIntegerNumber()
                                , 
                                b.to_ExtFixedLenghtIntegerNumber()
                                );
                        */
                        bz = a.to_ExtInteger();
                        bz.mul(b.to_ExtInteger());
                        i_tmp = this.line.getAll().first();
                        i_tmp = i_tmp.pow(this.len_of_frac_part);
                        bz = ExtInteger.QR(bz, i_tmp)[0];
                        i_tmp = null;
                        tmp = this.line.new_ExtFixedLenghtIntegerNumber(bz);
                        ans = this.new_ExtFixedPointNumber(tmp);
                        ans.sign((a.sign()+b.sign())%2);
                        }
                    else
                        throw ExtSpecifyNumbers.except(1);
                return ans;
                }
            
            public ExtFixedPointNumber div(ExtFixedPointNumber a, ExtFixedPointNumber b)
                {
                ExtFixedPointNumber ans;
                ExtInteger i_tmp,bz;
                ExtFixedLenghtIntegerNumberClass.ExtFixedLenghtIntegerNumber tmp;
                if(a == null || b == null)
                    throw ExtSpecifyNumbers.except(0);
                else
                    if(this.ifCorrect(a,b))
                        {
                        /*
                        tmp = this.line.prod(
                                a.to_ExtFixedLenghtIntegerNumber()
                                , 
                                b.to_ExtFixedLenghtIntegerNumber()
                                );
                        */
                        bz = a.to_ExtInteger();
                        i_tmp = this.line.getAll().first();
                        i_tmp = i_tmp.pow(this.len_of_frac_part);
                        //System.out.print(bz.soutput_10()+" ");
                        bz.mul(i_tmp);
                        //System.out.print(bz.soutput_10()+" ");
                        i_tmp = null;
                        
                        bz = ExtInteger.QR(bz, b.to_ExtInteger())[0];
                        //System.out.print(bz.soutput_10()+"\n");
                        tmp = this.line.new_ExtFixedLenghtIntegerNumber(bz);
                        ans = this.new_ExtFixedPointNumber(tmp);
                        ans.sign((a.sign()+b.sign())%2);
                        }
                    else
                        throw ExtSpecifyNumbers.except(1);
                return ans;
                }
            
            public int cmp(ExtFixedPointNumber a, ExtFixedPointNumber b)
                {
                int ans=0;
                if(this.ifCorrect(a, b))
                    {
                    //ans = a.to_ExtFixedLenghtIntegerNumber().to_ExtInteger().srav(b.to_ExtFixedLenghtIntegerNumber().to_ExtInteger());
                    ans = a.to_ExtInteger().srav(b.to_ExtInteger());
                    if(ans==0)
                        ans = 3;
                    else
                        if(ans == 1)
                            ans = 2;
                        else
                            ans =1;
                    
                    }
                else throw ExtSpecifyNumbers.except(1);
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
                catch(ExtNumLibException e){ throw e;  }
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
                ExtFixedPointNumber ans=this.new_ExtFixedPointNumber(ei.to_ExtInteger());
                ans.sign(ei.sign());
                return ans;
                }
            
            public ExtFixedPointNumber new_ExtFixedPointNumber(ExtFixedLenghtIntegerNumberClass.ExtFixedLenghtIntegerNumber ei)
                {
                ExtFixedPointNumber ans;
                try
                {
                 ans = this.new ExtFixedPointNumber(ei);
                }
                catch(ExtNumLibException e){ throw e;}
                
                return ans;
                } 
            
            public ExtFixedPointNumber new_ExtFixedPointNumber(Racio r)
                {
                try{
                return this.new ExtFixedPointNumber(r);
                    }
                catch(ExtNumLibException e){throw e;}
                }
            
            
            public Object clone(){return new ExtFixedPointNumberClass(this);}
            
            public class ExtFixedPointNumber
                {
                    private int s;
                    private ExtFixedLenghtIntegerNumberClass.ExtFixedLenghtIntegerNumber th;
                    
                    public int sign(){return this.s;}
                    public void sign(int si){this.s=si;}
                    
                    
                    public Object clone(){return this.getDomain().new_ExtFixedPointNumber(this);}
                    
                    public ExtFixedPointNumberClass getDomain(){return ExtFixedPointNumberClass.this;}
                    
                    public ExtFixedPointNumber(){ this(ExtSpecifyNumbers.ZERO); }
                    
                    public ExtFixedPointNumber(ExtInteger g)
                            {
                            if(g==null)
                                throw ExtSpecifyNumbers.except(0);
                            else
                                g = new ExtInteger(g);
                            this.sign(0);
                            this.th = ExtFixedPointNumberClass.this.line.new_ExtFixedLenghtIntegerNumber(g);
                            }
                    
                    public ExtFixedPointNumber(Racio g)
                            {
                            if(g==null)
                                throw ExtSpecifyNumbers.except(0);
                            else
                                g = new Racio(g);
                            this.sign(g.sign());
                            g.sign(0);
                            this.th = ExtFixedPointNumberClass.this.line.new_ExtFixedLenghtIntegerNumber(this.from_Racio_to_ExtInteger(g));
                            }
                    
                    private  ExtInteger from_Racio_to_ExtInteger(Racio g)
                            {
                            int sig;
                            ExtInteger tmp,baza,e,i,mn,su,zn;
                            ExtInteger[] d;
                            Pair<ExtSInteger,ExtInteger> para;
                            ChainStack<ExtInteger> cs1,cs2;
                            justOperation op = new justOperation<ExtInteger>()
                                                {
                                                public ChainStack<ExtInteger> operate(ChainStack<ExtInteger> cs)
                                                    {
                                                    ChainStack<ExtInteger> ans;
                                                    ExtInteger[] qr = ExtInteger.QR(cs.get(),cs.next().get());
                                                    ans = new ChainStack<>();
                                                    ans.next(new ChainStack<>());
                                                    ans.next().next(new ChainStack<>());
                                                    ans.set(qr[0]);
                                                    ans.next().set(qr[1]);
                                                    ans.next().next().set(new ExtInteger(cs.next().get()));
                                                    return ans;
                                                    }
                                                };
                            if(g==null)
                                throw ExtSpecifyNumbers.except(0);
                            else
                                g = new Racio(g);
                            sig = g.sign();
                            g.sign(0);
                            para = g.chains();
                            g = null;
                            baza = ExtFixedPointNumberClass.this.line.baze;
                            tmp = new ExtInteger();
                            e = ExtInteger.E;
                            cs1 = new ChainStack<>();
                            cs1.next(new ChainStack<>());
                            d = ExtInteger.QR(para.first(), para.second());
                            zn = para.second();
                            para = null;
                            if(ExtFixedPointNumberClass.this.len_of_frac_part.zero()!=0)
                                    if(d[1].zero()!=0)
                                    {
                                    cs1.set(d[1]);
                                    cs1.next().set(new ExtInteger(zn));
                                    i = new ExtInteger(ExtFixedPointNumberClass.this.len_of_frac_part);
                                    while(i.zero()!=0)
                                        {
                                        i.sub(e);
                                        tmp.mul(baza);
                                        cs1.get().mul(baza);
                                        cs1 = op.operate(cs1);
                                        tmp.add(cs1.get());
                                        cs1 = cs1.next();
                                        }
                                    }
                            zn = null;
                            if(ExtFixedPointNumberClass.this.len_of_int_part.zero()!=0)
                                if(d[0].zero()!=0)
                                {
                                mn = baza.pow(ExtFixedPointNumberClass.this.len_of_frac_part);
                                i = new ExtInteger(ExtFixedPointNumberClass.this.len_of_int_part);
                                while(i.zero()!=0)
                                    {
                                    i.sub(e);
                                    d = ExtInteger.QR(d[0],baza);
                                    su = new ExtInteger(mn);
                                    su.mul(d[1]);
                                    tmp.add(su);
                                    mn.mul(baza);
                                    }
                                }
                            
                            return tmp;
                            
                            }
                    
                    public boolean ifZero()
                        {
                        return (this.th.to_ExtInteger().zero()==0);
                        }
                    
                    public ExtFixedPointNumber(ExtFixedLenghtIntegerNumberClass.ExtFixedLenghtIntegerNumber a)
                        {
                        if(a==null)
                           throw ExtSpecifyNumbers.except(0);
                        else
                        try
                            {
                            this.sign(0);
                            this.th = ExtFixedPointNumberClass.this.line.new_ExtFixedLenghtIntegerNumber(a);
                            }
                        catch(ExtNumLibException e){ throw e;}
                        }
                    
                    
                    public ExtFixedLenghtIntegerNumberClass.ExtFixedLenghtIntegerNumber to_ExtFixedLenghtIntegerNumber()
                        {
                        return ExtFixedPointNumberClass.this.line.new_ExtFixedLenghtIntegerNumber(this.th);
                        }
                    
                    public ExtInteger to_ExtInteger()
                        {
                        return this.th.to_ExtInteger();
                        }
                    
                    public Racio to_Racio()
                        {
                        Racio ans,r;
                        ChainStack<ExtInteger> c = this.th.to_ChainStack();
                        ExtInteger i ,
                        d,e;
                        Pair<ExtInteger,Pair<ExtInteger,ExtInteger>> p;
                        p = this.getDomain().getAll();
                        ans = new Racio();
                        e = new ExtInteger(1);
                        r = new Racio(e,p.first());
                        while(c!=null)
                            {
                            ans.mul(r);
                            ans.add(new Racio(c.get()));
                            
                            c = c.next();
                            
                            }
                        p.second().second(null);
                        p.second().first().sub(ExtInteger.E);
                        ans.mul(new Racio(p.first().pow(p.second().first())));
                        p=null;
                        ans.sign(this.sign());
                        return ans;
                        }
                    
                    
                    public String to_String_10()
                        {
                        return this.th.to_String_10();
                        }
                    
                    public String to_String_()
                        {
                        return this.th.to_String_();
                        }
                    
                    
                    
                    
                    public String toString_lr()
                        {
                        String ans;
                        ChainStack<ExtInteger> c;
                        ExtInteger i;
                        if(this.getDomain().getAll().first().srav(ExtSpecifyNumbers.DECI)==0)
                            {
                            c = this.th.to_ChainStack();
                            ans = "";
                            i = this.getDomain().getAll().second().second();
                            if(i.zero()==0)
                                i=null;
                            else i.sub(ExtInteger.E);
                            while(c!=null)
                                {
                                ans = c.get().soutput_10()+ans;
                                if(i!=null)
                                    if(i.zero()==0)
                                        {
                                        ans = "."+ans;
                                        i=null;
                                        }
                                    else i.sub(ExtInteger.E);
                                c = c.next();
                                }
 
                            }
                            else ans = this.to_String_10();
                        if(this.sign()==1)
                            ans = "-"+ans;
                        return ans;
                        
                        }
                    
                    public String toString_rl()
                        {
                        String ans;
                        ChainStack<ExtInteger> c;
                        ExtInteger i;
                        if(this.getDomain().getAll().first().srav(ExtSpecifyNumbers.DECI)==0)
                            {
                            c = this.th.to_ChainStack();
                            ans = "";
                            i = this.getDomain().getAll().second().second();
                            if(i.zero()==0)
                                i=null;
                            else i.sub(ExtInteger.E);
                            while(c!=null)
                                {
                                ans = ans+c.get().soutput_10();
                                if(i!=null)
                                    if(i.zero()==0)
                                        {
                                        ans = ans+".";
                                        i=null;
                                        }
                                    else i.sub(ExtInteger.E);
                                c = c.next();
                                }
 
                            }
                            else ans = this.to_String_10();
                        if(this.sign()==1)
                            ans = "-"+ans;
                        return ans;
                        
                        }
                    
                    public String toString()
                        {
                        return this.toString_lr();
                        }
                        
                    
                }
            
            
        
        
        }
    
    public static class ExtFloatingPointNumberClass
        {
        private static final char[] spec_symbols;
        private static String spec_symbols_to_String(char a)
                {
                String ans;
                ans = null;
                switch(a)
                    {
                    case 2:{ans="NaN";break;}
                    case 3:{ans="+inf";break;}
                    case 4:{ans="-inf";break;}
                    case 5:{ans="+delta";break;}
                    case 6:{ans="-delta";break;}
                    }
                
                return ans;
                }
        static
            {
            spec_symbols = new char[7];
            spec_symbols[0]=0;//0
            spec_symbols[1]=1;//R and not 0
            spec_symbols[2]=2;//NaN
            spec_symbols[3] = 3;//+infinity
            spec_symbols[4] = 4; //-infinity
            spec_symbols[5] = 5; //delta for all x in R x=0 or 0<delta<abs(x)
                                    // and 0>-delta>-abs(x)
            spec_symbols[6] = 6;//-delta
            
            /*
            ExtFloatingPointNumberClass || Racio
                        0               || 0
                     delta/-delta       || 0
                     
            */
            }
        
        
        private ExtFixedPointNumberClass[] mantiss_and_exp;
        private ExtInteger M,m,baza,m_;
        private Racio[] r;
        public Trine<ExtInteger,Trine<ExtInteger,ExtInteger,ExtInteger>,Racio[]> getAll()
            {
            Pair<ExtInteger,Pair<ExtInteger,ExtInteger>>p;
            Trine<ExtInteger,Trine<ExtInteger,ExtInteger,ExtInteger>,Racio[]> ans;
            ans = new Trine<ExtInteger,Trine<ExtInteger,ExtInteger,ExtInteger>,Racio[]>();
            p = this.mantiss_and_exp[0].getAll();
            ans.first(p.first());
            ans.second(new Trine<>());
            ans.second().first(p.second().first());
            ans.second().second(p.second().second());
            ans.second().third(this.mantiss_and_exp[1].getAll().second().first());
            ans.third(new Racio[2]);
            ans.third()[0]=new Racio(r[0]);
            ans.third()[1]=new Racio(r[1]);
            return ans;
            }
        
        public ExtFloatingPointNumberClass(ExtInteger baze, ExtInteger mantiss_int_part,ExtInteger mantiss_frac_part,ExtInteger exp_len)
            {
            ExtInteger a,b,c,d;
            if(baze==null||mantiss_int_part==null||mantiss_frac_part==null||exp_len==null)
                throw except(0);
            if(baze.srav(UNITY)!=1)
                throw except(7);
            if(mantiss_int_part.zero()==0&&mantiss_frac_part.zero()==0)
                throw except(8);
            if(exp_len.zero()==0)
                throw except(9);
            this.r= new Racio[2];
            mantiss_and_exp = new ExtFixedPointNumberClass[2];
            mantiss_and_exp[0] = new ExtFixedPointNumberClass(baze,mantiss_int_part,mantiss_frac_part);
            mantiss_and_exp[1] = new ExtFixedPointNumberClass(baze,exp_len,ZERO);
            baza = new ExtInteger(baze);
            
            c = new ExtInteger(mantiss_int_part);
            a = new ExtInteger(mantiss_frac_part);
            a.add(c);
            a = baza.pow(a);
            a.sub(UNITY);
            //this.r[3] = new Racio(a);
            b = baza.pow(exp_len);
            b.sub(UNITY);
            //this.r[2] = this.r[3];
            //this.r[3] = new Racio(baza.pow(b));
            //this.r[2].mul(this.r[3]);
            //this.r[3].sign(-1);
            c = new ExtInteger(mantiss_int_part);
            c.add(mantiss_frac_part);
            c.sub(UNITY);
            b = baze.pow(c);
            m = b;
            M = a;
            c = new ExtInteger(mantiss_frac_part);
            c = baze.pow(c);
            m_ = c;
            
            this.r[0] = new Racio(m,m_);
            this.r[1] = new Racio(M,m_);
            
            }
        
        
        public ExtFloatingPointNumberClass(ExtFloatingPointNumberClass f)
            {
            if(f==null)
                throw except(0);
            Pair<ExtInteger,Trine<ExtInteger,ExtInteger,ExtInteger>> al;
            al = f.getAll();
            mantiss_and_exp = new ExtFixedPointNumberClass[2];
            mantiss_and_exp[0] = new ExtFixedPointNumberClass(al.first(),al.second().first(),al.second().second());
            mantiss_and_exp[1] = new ExtFixedPointNumberClass(al.first(),al.second().third(),ZERO);
            ExtInteger baze,mantiss_int_part,mantiss_frac_part,b,c,a;
            baze = al.first();
            mantiss_int_part = al.second().first();
            mantiss_frac_part = al.second().second();
            baza = new ExtInteger(baze);
            
            c = new ExtInteger(mantiss_int_part);
            a = new ExtInteger(mantiss_frac_part);
            a.add(c);
            a = baza.pow(a);
            a.sub(UNITY);
            //this.r[3] = new Racio(a);
            b = baza.pow((al.second().third()));
            b.sub(UNITY);
            //this.r[2] = new Racio(b);
            //this.r[2].mul(this.r[3]);
            //this.r[3] = this.r[2];
            //this.r[2] = new Racio(b);
            //this.r[2].sign(1);
            //this.r[2] = (new Racio(this.baza)).pow(this.r[2]);
            c = new ExtInteger(mantiss_int_part);
            c.add(mantiss_frac_part);
            c.sub(UNITY);
            b = baze.pow(c);
            m = b;
            M = a;
            c = new ExtInteger(mantiss_frac_part);
            c = baze.pow(c);
            m_ = c;
            
            this.r[0] = new Racio(m,m_);
            this.r[1] = new Racio(M,m_);
            }
        
        public boolean ifTheSame(ExtFloatingPointNumberClass c)
            {
                boolean ans = false;
                Pair<ExtInteger,Trine<ExtInteger,ExtInteger,ExtInteger>> pt=null,pc=null;
                if(c==null) throw except(0);
                if(this==c) ans = true;
                else
                {
                        pt = this.getAll();
                        pc = c.getAll();
                if(pt.first().srav(pc.first())==0)
                if(pt.second().first().srav(pc.second().first())==0)
                if(pt.second().second().srav(pc.second().second())==0)
                if(pt.second().third().srav(pc.second().third())==0)
                    ans = true;
                }
                return ans;
            }
        
        public boolean ifCorrect(ExtFloatingPointNumber n)
            {
            if(n==null) throw except(0);
            return this.ifTheSame(n.getDomain());
            }
        
        
        
        @Override
        public Object clone(){
            return new ExtFloatingPointNumberClass(this);
        }
        
        public ExtFloatingPointNumber new_ExtFloatingPointNumber()
            {
            return this.new ExtFloatingPointNumber();
            }
        
        public ExtFloatingPointNumber new_ExtFloatingPointNumber(ExtFloatingPointNumber a)
            {
            ExtFloatingPointNumber ans=null;
            try
                {
                ans = new ExtFloatingPointNumber(a);
                }
            catch(ExtNumLibException e){ throw e; }
            return ans;
            }
        
        public ExtFloatingPointNumber new_ExtFloatingPointNumber(Racio r)
            {
            ExtFloatingPointNumber ans=null;
            try
                {
                ans = this.new ExtFloatingPointNumber(r);
                }
            catch(ExtNumLibException e){throw e;};
            
            return ans;
            }
        
        public ExtFloatingPointNumber new_ExtFloatingPointNumber(char c)
            {
            ExtFloatingPointNumber ans = null;
            try
                {
                ans = this.new ExtFloatingPointNumber(c);
                }
            catch(ExtNumLibException e){throw e;}
            return ans;
            }
        
        public  ExtFloatingPointNumber sum(ExtFloatingPointNumber a, ExtFloatingPointNumber b)
            {
            ExtFloatingPointNumber ans = null;
            Pair<ExtFixedPointNumberClass.ExtFixedPointNumber,ExtFixedPointNumberClass.ExtFixedPointNumber> pa,pb;
            ExtInteger ia,ib,ii;
            ExtSInteger ea,eb;
            Racio r;
            int sa,sb;
            int i ;
            char ca,cb;
            if(a==null || b == null) throw except(0);
            else
                if(this.ifCorrect(a)&&this.ifCorrect(b))
                    {
                    ca = a.get_spec_symbols();
                    cb = b.get_spec_symbols();
                    
                    if(ca == 1 && cb == 1)
                        {
                        
                        
                        }
                    else
                        if(ca == 0)
                            if(cb == 0)
                                ans = this.new_ExtFloatingPointNumber();
                            else
                                ans = this.new_ExtFloatingPointNumber(b);
                        else
                        if(cb==0)
                            ans = this.new_ExtFloatingPointNumber(a);
                        else // a !=0 && b !=0     
                        if(ca == 2 || cb == 2)
                            ans = this.new_ExtFloatingPointNumber((char)2);
                        else
                        if(ca == 3 || cb == 3)
                            if(cb==4 || ca == 4)
                                ans = this.new_ExtFloatingPointNumber((char)2);
                            else
                                ans = this.new_ExtFloatingPointNumber((char)3);
                        else
                        if(ca == 4 || cb == 4)
                            ans = this.new_ExtFloatingPointNumber((char)4);
                        else
                        if(ca == 5)
                            if(cb == 5)
                                ans = this.new_ExtFloatingPointNumber(cb);
                            else if(cb==6)
                                ans = this.new_ExtFloatingPointNumber((char)0);
                            else ans = this.new_ExtFloatingPointNumber(b);
                        else
                        if(cb == 5)
                            if(ca == 5)
                                ans = this.new_ExtFloatingPointNumber(ca);
                            else if(ca==6)
                                ans = this.new_ExtFloatingPointNumber((char)0);
                            else ans = this.new_ExtFloatingPointNumber(a);
                        else
                        if(ca == 6)
                            if(cb == 6)
                                ans = this.new_ExtFloatingPointNumber(cb);
                            else if(cb==5)
                                ans = this.new_ExtFloatingPointNumber((char)0);
                            else ans = this.new_ExtFloatingPointNumber(b);
                        else
                        if(cb == 6)
                            if(ca == 6)
                                ans = this.new_ExtFloatingPointNumber(ca);
                            else if(ca==5)
                                ans = this.new_ExtFloatingPointNumber((char)0);
                            else ans = this.new_ExtFloatingPointNumber(a);
                        else throw except("Subtypes' exception.");
                    }
                else throw except(1);
            
            
            
            return ans;
            }
        
        
        public class ExtFloatingPointNumber
            {
            private char spec_symbol;
            public char get_spec_symbols(){return this.spec_symbol;}
            private ExtFixedPointNumberClass.ExtFixedPointNumber mantiss,exp;
            private ExtFloatingPointNumberClass domain;
            public ExtFloatingPointNumberClass getDomain(){return ExtFloatingPointNumberClass.this;}
            
            public Pair<ExtFixedPointNumberClass.ExtFixedPointNumber,ExtFixedPointNumberClass.ExtFixedPointNumber> getMain()
                {
                Pair<ExtFixedPointNumberClass.ExtFixedPointNumber,ExtFixedPointNumberClass.ExtFixedPointNumber> ans;
                ans = new Pair<ExtFixedPointNumberClass.ExtFixedPointNumber,ExtFixedPointNumberClass.ExtFixedPointNumber>();
                ans.first(this.mantiss.getDomain().new_ExtFixedPointNumber(this.mantiss));
                ans.second(this.exp.getDomain().new_ExtFixedPointNumber(this.exp));
                return ans;
                }
            
            
            public int[] sign()
                {
                int[] ans = new int[2];
                ans[0] = this.mantiss.sign();
                ans[1] = this.exp.sign();
                return ans;
                }
            
            
            public ExtFloatingPointNumber()
                    {
                    this.domain = ExtFloatingPointNumberClass.this;
                    mantiss = this.domain.mantiss_and_exp[0].new_ExtFixedPointNumber();
                    exp = this.domain.mantiss_and_exp[1].new_ExtFixedPointNumber();
                    this.spec_symbol=0;
                    }
            public ExtFloatingPointNumber(char c)
                    {
                    this.domain = ExtFloatingPointNumberClass.this;
                    if(c==1)
                        except(1);
                        else this.spec_symbol = c;
                    
                    }
            public ExtFloatingPointNumber(ExtFloatingPointNumber n)
                    {
                   
                    //this();
                    this.domain = ExtFloatingPointNumberClass.this;
                     char q;
                    if(n==null) throw except(0);
                    else if(!this.domain.ifCorrect(n)) throw except(1);
                    q = n.get_spec_symbols();
                    this.spec_symbol = q;
                    if(q!=0)
                        if(q==1){
                    Pair<ExtFixedPointNumberClass.ExtFixedPointNumber,ExtFixedPointNumberClass.ExtFixedPointNumber> p;
                    p = n.getMain();
                    this.mantiss = p.first();
                    this.exp = p.second();
                        }
                    }
            
            public ExtFloatingPointNumber(Racio r)
                    {
                    if(r==null) throw except(0);
                    ExtFloatingPointNumberClass cls = this.getDomain();
                    this.domain = cls;
                    int i;
                    int sig;
                    ExtInteger expp;
                    Racio baz;
                    if(r.ifZero())
                        {
                        this.mantiss = cls.mantiss_and_exp[0].new_ExtFixedPointNumber();
                        this.exp = cls.mantiss_and_exp[1].new_ExtFixedPointNumber();
                        }
                    else
                        {
                        
                        
                        sig = r.sign();
                        r = new Racio(r);
                        r.sign(0);
                        i = Racio.srav(cls.r[0],r);
                        switch(i)
                            {
                            case 3:
                                {
                                r.sign(sig);
                                this.mantiss = cls.mantiss_and_exp[0].new_ExtFixedPointNumber(r);
                                this.exp = cls.mantiss_and_exp[1].new_ExtFixedPointNumber();
                                break;
                                }
                            case 2:
                                {
                                    
                                expp = new ExtInteger();
                                baz = new Racio(cls.baza);
                                
                                
                                while(Racio.srav(cls.r[0],r)==2)
                                    {
                                    r.mul(baz);
                                    expp.add(UNITY);
                                    }
                                r.sign(sig);
                                this.mantiss = cls.mantiss_and_exp[0].new_ExtFixedPointNumber(r);
                                r = new Racio(expp);
                                r.sign(1);
                                this.exp = cls.mantiss_and_exp[1].new_ExtFixedPointNumber(r);
                                break;
                                }
                            case 1:
                                {
                                
                                i = Racio.srav(cls.r[1],r);
                                switch(i)
                                    {
                                    case 2: case 3:
                                        {
                                        r.sign(sig);
                                        this.mantiss = cls.mantiss_and_exp[0].new_ExtFixedPointNumber(r);
                                        this.exp = cls.mantiss_and_exp[1].new_ExtFixedPointNumber();
                                        break;
                                        }
                                    case 1:
                                        {
                                        expp = new ExtInteger();
                                        baz = new Racio(cls.baza);
                                        System.out.println(Racio.srav(cls.r[1],r));
                                        while(Racio.srav(cls.r[1],r)==1)
                                            {
                                            r.div(baz);
                                            expp.add(UNITY);
                                            }
                                        r.sign(sig);
                                        this.mantiss = cls.mantiss_and_exp[0].new_ExtFixedPointNumber(r);
                                        this.exp = cls.mantiss_and_exp[1].new_ExtFixedPointNumber(new Racio(expp));
                                        break;
                                        }
                                    
                                    }
                                //throw new ExtNumLibException("beda!!!");
                                break;
                                }
                            
                            }
                        
                        
                        }
                    
                    
                    
                    }
            
            public Racio toRacio()
                    {
                    Racio ans;
                    ans = this.exp.to_Racio();
                    ans = (new Racio(this.domain.baza)).pow(ans);
                    ans.mul(this.mantiss.to_Racio());
                    return ans;
                    }
            
            
            public String toString()
                    {
                        
                    String tmp,ans;/* = ("("+this.mantiss.toString_lr()+")");
                    ans = ans + "*("+this.domain.baza.soutput_10()+")^"+
                            "("+this.exp.toString_lr()+")";*/
                    //return ans;
                    String sig,ans_mantiss,exp,baza;
                    
                    if(this.getDomain().baza.srav(DECI)!=0)
                        {
                        ans = "";
                        
                        if(this.mantiss.sign()==1) ans = "-";
                        ans = "("+ans +
                              this.mantiss.to_Racio().soutput_10() +
                               ")*["+
                              this.domain.baza.soutput_10()+
                                "]^{";
                        ans_mantiss = ans ;
                        ans = "";
                        if(this.exp.sign()==1)
                            ans = "-";
                        ans_mantiss = ans_mantiss + ans + this.exp.to_ExtInteger().soutput_10()+"}";
                        ans = ans_mantiss;
                        return ans;
                        }
                    baza = this.domain.baza.soutput_10();
                    ans_mantiss = this.mantiss.toString_lr();
                    
                    boolean vsp;
                    int i,j,k,l,t=0;
                    //ans_mantiss.l
                    //ans_mantiss.
                    sig="_";
                    if(ans_mantiss.charAt(ans_mantiss.length()-1)!=sig.charAt(0))
                        sig="";
                    l = ans_mantiss.length();
                    j=0;
                    char c;
                    if(ans_mantiss.charAt(0)!='-')
                    {i=0;ans="";}
                    else {i=1; ans="-";}
                    while(i<l)
                        {
                        c = ans_mantiss.charAt(i);
                        if(c=='.')
                            {
                            ans = ans+"0.";
                            j = ans_mantiss.length();
                            do
                                {
                                j=j-1;
                                if(j==i) ans=ans+"0";
                                else
                                if('0'!=ans_mantiss.charAt(j))
                                    {
                                    ans=ans+ans_mantiss.substring(i+1, j+1);
                                    break;
                                    }
                                }
                            while(j>i);
                            break;
                            }
                        else
                        if(c!='0')
                            {
                            j=i+1;
                            if(j==l)
                                 ans = ans + ans_mantiss.substring(i, j);
                            else
                            while(j<l)
                                if(ans_mantiss.charAt(j)!='.')
                                    if(j<l-1)
                                    j=j+1;
                                    else
                                        {
                                        ans = ans + ans_mantiss.substring(i, j+1);
                                        break;
                                        }
                                else
                                    {
                                    ans = ans + ans_mantiss.substring(i, j);
                                    i = j;
                                    j = ans_mantiss.length();
                                    do
                                        {
                                        j=j-1;
                                        if(j==i) ans = ans+".0";
                                        else if('0'!=ans_mantiss.charAt(j))
                                                {
                                                ans = ans+"." +ans_mantiss.substring(i+1, j+1);
                                                break;
                                                }
                                        }
                                    while(j>i);
                                    break;
                                    }
                            break;
                            }
                        i=i+1;
                        }
                    ans = "("+ans+")*["+this.domain.baza.soutput_10()+"]";
                    tmp = ans;
                    
                    ans_mantiss = this.exp.toString_lr();
                    l = ans_mantiss.length();
                    j=0;
                    if(ans_mantiss.charAt(0)!='-')
                    {i=0;ans="";}
                    else {i=1; ans="-";}
                    while(i<l)
                        {
                        c = ans_mantiss.charAt(i);
                        //System.out.print("exp:\t"+c+"\n");
                        if(c=='.')
                            {
                            ans = ans+"0.";
                            j = ans_mantiss.length();
                            do
                                {
                                j=j-1;
                                if(j==i) ans=ans+"0";
                                else
                                if('0'!=ans_mantiss.charAt(j))
                                    {
                                    ans=ans+ans_mantiss.substring(i+1, j+1);
                                    break;
                                    }
                                }
                            while(j>i);
                            break;
                            }
                        else
                        if(c!='0')
                            {
                             t = 1;   
                            j=i+1;
                            if(j==l){
                                 ans = ans + ans_mantiss.substring(i, j);
                                 
                            }
                            else
                            {
                                
                            while(j<l)
                                if(ans_mantiss.charAt(j)!='.')
                                    if(j<l-1)
                                    j=j+1;
                                    else
                                        {
                                        ans = ans + ans_mantiss.substring(i, j+1);
                                        break;
                                        }
                                else
                                    {
                                    ans = ans + ans_mantiss.substring(i, j);
                                    i = j;
                                    j = ans_mantiss.length();
                                    do
                                        {
                                        j=j-1;
                                        if(j==i) ans = ans+".0";
                                        else if('0'!=ans_mantiss.charAt(j))
                                                {
                                                ans = ans+"." +ans_mantiss.substring(i+1, j+1);
                                                break;
                                                }
                                        }
                                    while(j>i);
                                    break;
                                    }
                                    }
                            break;
                            }
                        i=i+1;
                        }
                    if(t==0) ans = "0";
                    tmp = tmp+"^{"+ans+"}";
                    ans=tmp;
                    
                    
                    return ans;
                    }
            
            
            
            
            }
            
            
        }
            
        
    
    
}


interface justOperation<T>
    {
    public ChainStack<T> operate(ChainStack<T> c);
    }
