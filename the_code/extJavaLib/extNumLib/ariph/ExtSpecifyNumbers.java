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
            DeductionClassRing da = a.get_Domen(), db = b.get_Domen();
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
        
        
        
        class Deduct
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
            
            
            public DeductionClassRing get_Domen()
                    {
                    return DeductionClassRing.this;
                    }
            
            public ExtInteger get_baze(){return this.get_Domen().get_baze();}
            
            public ExtInteger to_ExtInteger(){return new ExtInteger(this.ddct);}
            
            }
        
    
    }
    
    public static class ExtFixedLenghtIntegerNumbers
        {
        private ExtInteger baze,lenght;
        
        public ExtFixedLenghtIntegerNumbers()
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
        
        public ExtFixedLenghtIntegerNumbers(ExtFixedLenghtIntegerNumbers a)
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
        
        
        public ExtFixedLenghtIntegerNumbers(ExtInteger base, ExtInteger len)
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
        
        public class ExtFixedLenghtIntegerNumber
            {        
            private ChainStack<ExtInteger> th;
            
            public ExtFixedLenghtIntegerNumber()
                {
                ExtInteger i;
                ChainStack<ExtInteger> tmp;
                i = new ExtInteger(ExtFixedLenghtIntegerNumbers.this.lenght);
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
            
            public ExtFixedLenghtIntegerNumber(ExtInteger e)
                {
                    ExtInteger i;
                    ExtInteger[] tmp;
                    ChainStack<ExtInteger> st_tmp;
                    i = new ExtInteger(ExtFixedLenghtIntegerNumbers.this.lenght);
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
                        tmp = ExtInteger.QR(e, ExtFixedLenghtIntegerNumbers.this.baze);
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
                                tmp = ExtInteger.QR(tmp[0], ExtFixedLenghtIntegerNumbers.this.baze);
                                st_tmp.set(tmp[1]);
                                }
                        while(i.srav(ExtSpecifyNumbers.ZERO)!=0);
                        }
                    
                }
            
            
            }
        
        
        }
    
    
    
    
}
