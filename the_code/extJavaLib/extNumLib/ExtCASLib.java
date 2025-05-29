
package extJavaLib.extNumLib;

import extJavaLib.baseBlockLib.Pair;
import extJavaLib.baseBlockLib.Trine;
import extJavaLib.baseBlockLib.ChainStack;
import extJavaLib.extStructLib.ExtVector;
import extJavaLib.extStructLib.ExtArray;
/////////////////////////////////////////////////
import extJavaLib.extNumLib.ariph.ExtInteger.ExtChar;
import extJavaLib.extNumLib.ariph.ExtInteger;
import extJavaLib.extNumLib.ariph.ExtSInteger;
import extJavaLib.extNumLib.ariph.Racio;
//////////////////////////////////////////////////
import extJavaLib.extNumLib.ExtNum;
import extJavaLib.extNumLib.ExtNumCalc;
//////////////////////////////////////////////////
import extJavaLib.extStringLib.ExtString;
//////////////////////////////////////////////////
import extJavaLib.extJavaLibExceptions.ExtJavaLibExceptions.ExtCASLibExceptions.ExtCASLibException;


public final class ExtCASLib
{
    private static final String[] errs;
    static
        {
        errs=new String[12];
        errs[0]="Null argument is forbidden.";
        errs[1]="Only integer subtypes can be given.";
        errs[2]="This method/constructor can not be used. Use Method/constructor with arguments.";
        errs[3]="Argument must be greater than 0.";
        errs[4]="Bad object.";
        errs[5]="Index must be positive integer number.";
        errs[6]="Index is out of range.";
        errs[7]="Empty ExtString is forbidden.";
        }
    private static void except(int i)
        {
        throw new ExtCASLibException(errs[i]);
        }
    
    private static void except(String s)
        {
        throw new ExtCASLibException(s);
        }
    
    public static class ExtCASLibBaseTypes
            {
            
            
            
            public static final class ExtCASSym  extends ExtCASBaseType
                    {
                    protected void init()
                                {
                                super.init(Ariphmetical.E);
                                }
                    private  ExtString s;
                    public ExtCASSym()
                            {
                            init();
                            this.s=null;
                            ExtCASLib.except(2);
                            }
                    
                    public ExtCASSym(ExtString st)
                            {
                            init();
                            this.s=null;
                            if(st==null)
                                ExtCASLib.except(0);
                            else
                            if(st.empty())
                                ExtCASLib.except(7);
                            else
                                this.s=new ExtString(st);
                            }
                    
                    public ExtCASSym(String st)
                            {
                            init();
                            this.s=null;
                            if(st==null)
                                ExtCASLib.except(0);
                            if(st.length()==0)
                                ExtCASLib.except(7);
                            else
                                this.s=new ExtString(st);
                            }
                    
                    public boolean ifBad(){return (this.s==null);}
                    
                    public ExtString toExtString()
                            {
                            ExtString ans=null;
                            if(this.ifBad())
                                ExtCASLib.except(4);
                            else
                                ans=new ExtString(this.s);
                            return ans;
                            }
                    
                    public static boolean ifEquiv(ExtCASSym s1,ExtCASSym s2)
                                    {
                                    boolean ans=false;
                                    ExtString st1,st2;
                                    int cmp;
                                    if(s1==null || s2==null)
                                        ExtCASLib.except(0);
                                    else
                                        {
                                            st1 = s1.toExtString();
                                            st2 = s2.toExtString();
                                            cmp = ExtString.cmp(st1, st2);
                                            ans = (cmp==3);
                                        }
                                    return ans;
                                    }
                    
                    public String toString()
                                {
                                String ans=null;
                                if(this.ifBad())
                                    ans="";
                                else
                                    ans=this.toExtString().toString();
                                return ans;
                                }
                    }
            
            
            
            /*
            
            public static final class ExtCASArray<T>
                    {
                    private ExtArray<T> a;
                    
                    public ExtCASArray()
                            {
                            this.a=null;
                            ExtCASLib.except(0);
                            }
                    
                    public ExtCASArray(ExtCASNum n)
                            {
                            int i=0;
                            if(n==null)
                                ExtCASLib.except(0);
                            i=n.type();
                            if(i==6||i==7||i==10)
                                {
                                this.a=null;
                                ExtCASLib.except(1);
                                }
                            n=n.toDefaultType();
                            i=ExtCASNum.cmp(n, new ExtCASNum());
                            
                            
                            if(i!=2)
                                {
                                this.a=null;
                                ExtCASLib.except("Length of array must be positive integer.");
                                }
                            
                            this.a=new ExtArray<T>(n.toAriphmetical());
                            }
                    
                    public ExtCASNum len()
                            {
                            ExtCASNum ans;
                            if(this.a==null)
                                ExtCASLib.except(4);
                            ans=new ExtCASNum(this.a.len());
                            return ans;
                            }
                    
                    public T get(ExtCASNum i)
                            {
                            T ans=null;
                            ExtCASNum l;
                            int k;
                            if(i==null)
                                ExtCASLib.except(0);
                            k=i.type();
                            if(k==6||k==7||k==10)
                                ExtCASLib.except(5);
                            if(this.a==null)
                                ExtCASLib.except(4);
                            else
                                {
                                l=this.len();
                                i=i.toDefaultType();
                                k=ExtCASNum.cmp(l,i);
                                if(k==2)
                                    {
                                    ans=this.a.item(i.toAriphmetical());
                                    }
                                else
                                    if(k==3)
                                        ExtCASLib.except(6);
                                    else
                                        //if(k==1)
                                            ExtCASLib.except(5);
                                        
                                }
                            return ans;
                            }
                    
                    public void set(ExtCASNum i, T nv)
                            {
                            int j;
                            ExtCASNum l;
                            if(this.a==null)
                                ExtCASLib.except(4);
                            if(i==null||nv==null)
                                ExtCASLib.except(0);
                            j=i.type();
                            if(j==6||j==7||j==10)
                                ExtCASLib.except(1);
                            j=ExtCASNum.cmp(i,ExtCASNum.N);
                            if(j==1)
                                ExtCASLib.except(5);
                            l=this.len();
                            j=ExtCASNum.cmp(i,l);
                            if(j>=2)
                                ExtCASLib.except(6);
                            this.a.item(i.toAriphmetical(), nv);
                                
                            }
                    
                    }
                    
            
            
            
            public static interface Operation1<T>
                    {
                    public T operate(T o1);
                    }
            
            public static interface Operation2<T>
                    {
                    public T operate(T o1, T o2);
                    }
            
            public static class ExtCASFiniteSet
                    {
                    
                    }
            */
            
            public static class ExtCASNum extends ExtCASBaseType
                {
                private static final Ariphmetical tp;
                
                static
                {
                tp=new Ariphmetical(2);
                }
                
                protected void init()
                                {
                                super.init(tp);
                                //super.init(new Ariphmetical(2));
                                }
                
                /*
                public ExtVector<Ariphmetical> getTypeRoad()
                            {
                            ExtVector<Ariphmetical> ans;
                            int t;
                            Ariphmetical ar;
                            ans=super.getTypeRoad();
                            t=this.a.type();
                            ar=new Ariphmetical(t);
                            ans.pushBack(ar);
                            return ans;
                            }
                */
                
                public static final ExtCASNum N,E;
                static
                    {
                    N=new ExtCASNum(Ariphmetical.N);
                    E=new ExtCASNum(Ariphmetical.E);
                    }
                private final Ariphmetical a;
                
                public ExtCASNum(){a=Ariphmetical.N;this.init();}
                
                public ExtCASNum(Short sh)
                        {
                        this.init();
                        this.a=new Ariphmetical(sh);
                        }
                public ExtCASNum(Short sh,Short sh1)
                        {
                        this.init();
                        this.a=new Ariphmetical(sh,sh1);
                        }
                
                public ExtCASNum(ExtChar sh)
                        {
                        this.init();
                        this.a=new Ariphmetical(sh);
                        }
                public ExtCASNum(ExtChar sh,ExtChar sh1)
                        {
                        this.init();
                        this.a=new Ariphmetical(sh.charValue(),sh1.charValue());
                        }
                
                public ExtCASNum(Byte sh)
                        {
                        this.init();
                        this.a=new Ariphmetical(sh);
                        }
                public ExtCASNum(Byte sh,Byte sh1)
                        {
                        this.init();
                        this.a=new Ariphmetical(sh,sh1);
                        }
                
                public ExtCASNum(Integer sh)
                        {
                        this.init();
                        this.a=new Ariphmetical(sh);
                        }
                public ExtCASNum(Integer sh,Integer sh1)
                        {
                        this.init();
                        this.a=new Ariphmetical(sh,sh1);
                        }
                
                public ExtCASNum(Long sh)
                        {
                        this.init();
                        this.a=new Ariphmetical(sh);
                        }
                public ExtCASNum(Long sh,Long sh1)
                        {
                        this.init();
                        this.a=new Ariphmetical(sh,sh1);
                        }
                
                public ExtCASNum(Float sh)
                        {
                        this.init();
                        this.a=new Ariphmetical(sh);
                        }
                
                public ExtCASNum(Double sh)
                        {
                        this.init();
                        this.a=new Ariphmetical(sh);
                        }
                
                public ExtCASNum(ExtInteger sh)
                        {
                        this.init();
                        ExtNum tmp;
                        tmp=new ExtNum(sh);
                        this.a=new Ariphmetical(tmp);
                        }
                
                public ExtCASNum(ExtSInteger sh)
                        {
                        this.init();
                        ExtNum tmp;
                        tmp=new ExtNum(sh);
                        this.a=new Ariphmetical(tmp);
                        }
                
                public ExtCASNum(Racio sh)
                        {
                        this.init();
                        ExtNum tmp;
                        tmp=new ExtNum(sh);
                        this.a=new Ariphmetical(tmp);
                        }
                
                public ExtCASNum(ExtNum sh)
                        {
                        this.init();
                        ExtNum tmp;
                        tmp=new ExtNum(sh);
                        this.a=new Ariphmetical(tmp);
                        }
                
                public ExtCASNum(Ariphmetical aa)
                        {
                        this.init();
                        if(aa==null)
                            {
                            a=Ariphmetical.N;
                            ExtCASLib.except(0);
                            }
                            else a=aa;
                        }
                public ExtCASNum(ExtCASNum n)
                        {
                        this.init();
                        if(n==null)
                            {
                            a=Ariphmetical.N;
                            ExtCASLib.except(0);
                            }
                        else
                            a=n.toAriphmetical();
                        }
                @Override
                public ExtVector<Ariphmetical> getTypeRoad()
                        {
                        ExtVector<Ariphmetical> ans;
                        ans=super.getTypeRoad();
                        ans.pushBack(new Ariphmetical(this.type()));
                        return ans;
                        }
                public int type(){return this.a.type();}
                public ExtCASNum toDefaultType()
                        {
                        int i=this.type();
                        Ariphmetical ar;
                        ExtCASNum ans=null;
                        ar=this.a;
                        if(i<6)
                            {
                                ar=ar.cast(9);
                                ar.simp();
                                ans=new ExtCASNum(ar);
                            }
                        else
                            if(i<8)
                                {
                                    ar=ar.cast(10);
                                    ar.simp();
                                    ans=new ExtCASNum(ar);
                                }
                            else 
                                ans=new ExtCASNum(ar);
                        return ans;
                        }
                
                public ExtCASNum cast(Ariphmetical i)
                        {
                        ExtCASNum ans=null;
                        if(i==null)
                            ExtCASLib.except(0);
                        else
                            ans=this.cast(i.toInteger().intValue());
                        return ans;
                        }
                
                public ExtCASNum cast(ExtCASNum i)
                        {
                        ExtCASNum ans=null;
                        if(i==null)
                            ExtCASLib.except(0);
                        else
                            ans=this.cast(i.toAriphmetical());
                        return ans;
                        }
                
                public ExtCASNum cast(int i)
                        {
                        ExtCASNum ans;
                        if(i<1 || i>10)
                            ExtCASLib.except("Argument must be only greather, than 0, and less, than 11");
                        Ariphmetical ar;
                        ar=this.a.cast(i);
                        ans=new ExtCASNum(ar);
                        return ans;
                        }
                
                public Ariphmetical toAriphmetical(){return this.a;}
                
                
                public String toString()
                        {
                        String res=null;
                        res=this.a.toString();
                        return res;
                        }
                
                public ExtString toExtString()
                        {
                        ExtString res=null;
                        res=new ExtString(this.toString());
                        return res;
                        }
                
                
                public static ExtCASNum sum(ExtVector<ExtCASNum> arr)
                    {
                    ExtCASNum res=null;
                    Ariphmetical s,i,a,E; 
                    if(arr==null)
                        ExtCASLib.except(0);
                    else
                        {
                        i=arr.len();
                        if(i.zero())
                            res=new ExtCASNum();
                        else
                            {
                            E=Ariphmetical.E;
                            i=Ariphmetical.sub(i,E);
                            res=arr.get(i);
                            s=res.toAriphmetical();
                            if(i.zero())
                                res=new ExtCASNum(s);
                            else
                                {
                                do
                                    {
                                    i=Ariphmetical.sub(i,E);
                                    res=arr.get(i);
                                    if(res==null)
                                        ExtCASLib.except(0);
                                    a=res.toAriphmetical();
                                    if(a==null)
                                        ExtCASLib.except(0);
                                    s=Ariphmetical.sum(s,a);
                                    }
                                while(!i.zero());
                                res=new ExtCASNum(s);
                                }
                            }
                        }
                    return res;
                    }
                
                public static ExtCASNum prod(ExtVector<ExtCASNum> arr)
                    {
                    ExtCASNum res=null;
                    Ariphmetical s,i,a,E; 
                    if(arr==null)
                        ExtCASLib.except(0);
                    else
                        {
                        i=arr.len();
                        if(i.zero())
                            res=new ExtCASNum();
                        else
                            {
                            E=Ariphmetical.E;
                            i=Ariphmetical.sub(i,E);
                            res=arr.get(i);
                            a=res.toAriphmetical();
                            if(a==null)
                                ExtCASLib.except(0);
                            else
                            if(!(a.zero()||i.zero()))
                                {
                                s=a;
                                do
                                    {
                                    i=Ariphmetical.sub(i,E);
                                    res=arr.get(i);
                                    if(res==null)
                                        ExtCASLib.except(0);
                                    else
                                    a=res.toAriphmetical();
                                    if(a==null)
                                        ExtCASLib.except(0);
                                    else
                                    if(a.zero())
                                        {
                                        s=a;
                                        break;
                                        }
                                    else
                                        s=Ariphmetical.prod(s, a);
                                    }
                                while(!i.zero());
                                res=new ExtCASNum(s);
                                }
                            else res=new ExtCASNum(a);
                            }
                            
                        }
                    return res;
                    }
                
                public static ExtCASNum sum(ExtCASNum o1, ExtCASNum o2)
                        {
                        ExtCASNum res=null;
                        ExtVector<ExtCASNum> m;
                        m=new ExtVector<>();
                        m.pushBack(o1);
                        m.pushBack(o2);
                        res=ExtCASNum.sum(m);
                        return res;
                        /*
                        Ariphmetical a1,a2;
                        ExtCASNum res=null;
                        if(o1==null || o2==null)
                            ExtCASLib.except(0);
                        a1=o1.toAriphmetical();
                        a2=o2.toAriphmetical();
                        a1=Ariphmetical.sum(a1, a2);
                        res=new ExtCASNum(a1);
                        return res;
                        */
                        }
                
                public static ExtCASNum sub(ExtCASNum o1, ExtCASNum o2)
                        {
                        Ariphmetical a1,a2;
                        ExtCASNum res=null;
                        if(o1==null || o2==null)
                            ExtCASLib.except(0);
                        a1=o1.toAriphmetical();
                        a2=o2.toAriphmetical();
                        a1=Ariphmetical.sub(a1, a2);
                        res=new ExtCASNum(a1);
                        return res;
                        }
                
                public static ExtCASNum prod(ExtCASNum o1, ExtCASNum o2)
                        {
                        ExtCASNum res=null;
                        ExtVector<ExtCASNum> m;
                        m=new ExtVector<>();
                        m.pushBack(o1);
                        m.pushBack(o2);
                        res=ExtCASNum.prod(m);
                        return res;
                        /*
                        Ariphmetical a1,a2;
                        ExtCASNum res=null;
                        if(o1==null || o2==null)
                            ExtCASLib.except(0);
                        a1=o1.toAriphmetical();
                        a2=o2.toAriphmetical();
                        a1=Ariphmetical.prod(a1, a2);
                        res=new ExtCASNum(a1);
                        return res;
                        */
                        }
                public static ExtCASNum div(ExtCASNum o1, ExtCASNum o2)
                        {
                        Ariphmetical a1,a2;
                        ExtCASNum res=null;
                        if(o1==null || o2==null)
                            ExtCASLib.except(0);
                        a1=o1.toAriphmetical();
                        a2=o2.toAriphmetical();
                        if(a2.zero())
                            ExtCASLib.except("Division by zero.");
                        a1=Ariphmetical.div(a1, a2);
                        res=new ExtCASNum(a1);
                        return res;
                        }
                
                public static ExtCASNum[] QR(ExtCASNum o1, ExtCASNum o2)
                    {
                    ExtCASNum[] ans;
                    ExtVector<ExtCASNum> v=QR_(o1,o2);
                    ans=new ExtCASNum[2];
                    ans[0]=v.get(Ariphmetical.N);
                    ans[1]=v.get(Ariphmetical.E);
                    return ans;
                    }
                
                public static ExtVector<ExtCASNum> QR_(ExtCASNum o1, ExtCASNum o2)
                    {
                    ExtVector<ExtCASNum> res=null;
                    Ariphmetical[] a;
                    int i;
                    if(o1==null || o2==null)
                            ExtCASLib.except(0);
                    else
                        {
                        i=o1.type();
                        if(i==6||i==7||i==10)
                            ExtCASLib.except(1);
                        i=o2.type();
                        if(i==6||i==7||i==10)
                            //ExtCASLib.except("Only integer subtypes can be given.");
                            ExtCASLib.except(1);
                        a=new Ariphmetical[2];
                        a[0]=o1.toAriphmetical();
                        a[1]=o2.toAriphmetical();
                        a=Ariphmetical.QR(a[0], a[1]);
                        res=new ExtVector<>();
                        o1=new ExtCASNum(a[0]);
                        res.pushBack(o1);
                        o2=new ExtCASNum(a[1]);
                        res.pushBack(o2);
                        }
                    return res;
                    }
                public static boolean ifEquiv(ExtVector<ExtCASNum> arr)
                        {
                        boolean ans=true;
                        Ariphmetical i,E,a,b;
                        ExtCASNum tmp;
                        if(arr==null)
                            ExtCASLib.except(0);
                        i=arr.len();
                        if(!i.zero())
                                {
                                E=Ariphmetical.E;
                                i=Ariphmetical.sub(i,E);
                                if(!i.zero())
                                    {
                                    tmp=arr.get(i);
                                    if(tmp==null)
                                        ExtCASLib.except(0);
                                    a=tmp.toAriphmetical();
                                    do
                                        {
                                        i=Ariphmetical.sub(i,E);
                                        tmp=arr.get(i);
                                        if(tmp==null)
                                            ExtCASLib.except(0);
                                        b=tmp.toAriphmetical();
                                        ans=(3!=Ariphmetical.cmp(a,b));
                                        if(ans)
                                            break;
                                        //else a=b;
                                        }
                                    while(!i.zero());
                                    
                                    }
                                    else ans=true;
                                
                                
                                }
                                else ans=true;
                        return ans;
                        }
                
                public static boolean ifEquiv(ExtCASNum a,ExtCASNum b)
                            {
                            boolean ans;
                            ExtVector<ExtCASNum> arr;
                            arr=new ExtVector<>();
                            arr.pushBack(a);
                            arr.pushBack(b);
                            ans=ExtCASNum.ifEquiv(arr);
                            return ans;
                            }
                
                public static int cmp(ExtCASNum a,ExtCASNum b)
                            {
                            int ans=0;
                            Ariphmetical aa,bb;
                            aa=a.toAriphmetical();
                            bb=b.toAriphmetical();
                            ans=Ariphmetical.cmp(aa,bb);
                            return ans;
                            }
                
                public static ExtCASNum pow(ExtCASNum a,ExtCASNum b)
                            {
                            ExtCASNum ans=null;
                            Ariphmetical A,B;
                            int i;
                            if(a==null || b==null)
                                ExtCASLib.except(0);
                            i=a.type();
                            if(i==6 || i==7)
                                ExtCASLib.except("Bad operands subtype.");
                            else
                                a=a.toDefaultType();
                            i=b.type();
                            if(i==6 || i==7)
                                ExtCASLib.except("Bad operands subtype.");
                            else
                                b=b.toDefaultType();
                            A=a.toAriphmetical();
                            B=b.toAriphmetical();
                            A=Ariphmetical.pow(A, B);
                            ans=new ExtCASNum(A);
                            return ans;
                            }
                
                
                
                }
            
            public final static class ExtCASDeductionClass extends ExtCASBaseType
                    {
                    
                    public final static ExtCASNum E,N;
                    public final static Ariphmetical tp;
                    static
                    {
                    tp=new Ariphmetical(3);
                    E=new ExtCASNum(Ariphmetical.E);
                    N=new ExtCASNum(Ariphmetical.N);
                    }
                        
                        private final ExtCASNum base;
                        
                        protected void init()
                                {
                                super.init(tp);
                                //super.init(new Ariphmetical(3));
                                }
                        
                        public ExtCASNum getBase(){return this.base;}
                        
                        public ExtCASDeductionClass()
                                {
                                this.init();
                                this.base=N;
                                ExtCASLib.except(2);
                                
                                }
                        
                        public ExtCASDeductionClass(ExtCASNum a)
                                {
                                this.init();
                                int i=0;
                                if(a==null)
                                    ExtCASLib.except(0);
                                i=a.type();
                                if(i==6||i==7||i==10)
                                    ExtCASLib.except(1);
                                i=ExtCASNum.cmp(a, N);
                                if(i!=2)
                                    ExtCASLib.except(3);
                                a=a.toDefaultType();
                                this.base=a;
                                }
                        
                        public ExtCASDeductionClass(Ariphmetical a)
                                {
                                this(new ExtCASNum(a));
                                }
                        
                        public ExtCASDeductionClass(Byte a)
                                {
                                this(new Ariphmetical(a));
                                }
                        
                        public ExtCASDeductionClass(ExtChar a)
                                {
                                this(new Ariphmetical(a));
                                }
                        
                        public ExtCASDeductionClass(Short a)
                                {
                                this(new Ariphmetical(a));
                                }
                        
                        public ExtCASDeductionClass(Integer a)
                                {
                                this(new Ariphmetical(a));
                                }
                        
                        public ExtCASDeductionClass(Long a)
                                {
                                this(new Ariphmetical(a));
                                }
                        
                        public ExtCASDeductionClass(ExtNum a)
                                {
                                this(new Ariphmetical(a));
                                }
                        
                        public ExtCASDeduction newClass(){return this.new ExtCASDeduction();}
                        
                        
                        
                        public ExtCASDeduction newClass(Byte a)
                                        {
                                        return this.newClass(new ExtCASNum(a));
                                        }
                        public ExtCASDeduction newClass(ExtChar a)
                                        {
                                        return this.newClass(new ExtCASNum(a));
                                        }
                        public ExtCASDeduction newClass(Short a)
                                        {
                                        return this.newClass(new ExtCASNum(a));
                                        }
                        public ExtCASDeduction newClass(Integer a)
                                        {
                                        return this.newClass(new ExtCASNum(a));
                                        }
                        public ExtCASDeduction newClass(Long a)
                                        {
                                        return this.newClass(new ExtCASNum(a));
                                        }
                        public ExtCASDeduction newClass(ExtNum a)
                                        {
                                        return this.newClass(new ExtCASNum(a));
                                        }
                        
                        public ExtCASDeduction newClass(ExtCASNum a)
                                        {
                                        ExtCASDeduction ans=null;
                                        int i=0;
                                        if(a==null)
                                            ExtCASLib.except(0);
                                        i=a.type();
                                        if(i==6||i==7||i==10)
                                            ExtCASLib.except(1);
                                        a=a.toDefaultType();
                                        ans=new ExtCASDeduction(a);
                                        return ans;
                                        }
                        
                        
                        
                        public ExtCASDeduction newClass(ExtCASDeduction a)
                                        {
                                        ExtCASDeduction ans=null;
                                        ans= new ExtCASDeduction(a.toExtCASNum());
                                        return ans;
                                        }
                        
                        public ExtCASDeduction sum(ExtCASDeduction a, ExtCASDeduction b)
                                    {
                                    ExtCASDeduction ans;
                                    ExtCASNum[] qr;
                                    if(a==null || b==null)
                                        ExtCASLib.except(0);
                                    if(a.getExtCASDeductionClass()!=b.getExtCASDeductionClass())
                                        ExtCASLib.except("Elements are not from the same base of Deduction Class.");
                                    
                                    /*
                                    if(ExtCASNum.cmp(a.toExtCASNum(),b.toExtCASNum())!=3)
                                        ExtCASLib.except("Elements are not from the same base of Deduction Class.");
                                    */


                                    qr=new ExtCASNum[2];
                                    qr[0]=a.toExtCASNum();
                                    qr[1]=b.toExtCASNum();
                                    qr[1]=ExtCASNum.sum(qr[0],qr[1]);
                                    //qr=ExtCASNum.QR(qr[1], this.base);
                                    ans=this.newClass(qr[1]);
                                    return ans;
                                    }
                        
                        public ExtCASDeduction sub(ExtCASDeduction a, ExtCASDeduction b)
                                    {
                                    ExtCASDeduction ans;
                                    ExtCASNum[] qr;
                                    if(a==null || b==null)
                                        ExtCASLib.except(0);
                                    qr=new ExtCASNum[2];
                                    qr[0]=a.toExtCASNum();
                                    qr[1]=b.toExtCASNum();
                                    qr[1]=ExtCASNum.sub(qr[0],qr[1]);
                                    //qr=ExtCASNum.QR(qr[1], this.base);
                                    ans=this.newClass(qr[1]);
                                    return ans;
                                    }
                        
                        public ExtCASDeduction prod(ExtCASDeduction a, ExtCASDeduction b)
                                    {
                                    ExtCASDeduction ans;
                                    ExtCASNum[] qr;
                                    if(a==null || b==null)
                                        ExtCASLib.except(0);
                                    qr=new ExtCASNum[2];
                                    qr[0]=a.toExtCASNum();
                                    qr[1]=b.toExtCASNum();
                                    qr[1]=ExtCASNum.prod(qr[0],qr[1]);
                                    //qr=ExtCASNum.QR(qr[1], this.base);
                                    ans=this.newClass(qr[1]);
                                    return ans;
                                    }
                        
                        
                        public class ExtCASDeduction extends ExtCASBaseType
                                {
                                    
                                    protected void init()
                                        {
                                        super.init(Ariphmetical.N);
                                        this.type.next(ExtCASDeductionClass.this.type);
                                        }
                                    
                                    private final ExtCASNum t;
                                    private final ExtCASDeductionClass b;
                                    
                                    public ExtCASDeduction()
                                                {
                                                this.init();
                                                b=ExtCASDeductionClass.this;
                                                //b.base=null;
                                                this.t=ExtCASDeductionClass.N;
                                                }
                                    
                                    public ExtCASDeduction(ExtCASNum ttt)
                                                {
                                                    this.init();
                                                    int i;
                                                    b=ExtCASDeductionClass.this;
                                                    if(ttt==null)
                                                        ExtCASLib.except(0);
                                                    i=ttt.type();
                                                    if(i==6||i==7||i==10)
                                                        ExtCASLib.except(1);
                                                    ttt=ttt.toDefaultType();
                                                    ttt=ExtCASNum.QR_(ttt, this.b.base).get(Ariphmetical.E);
                                                    this.t=ttt;
                                                }
                                    
                                    
                                    
                                    public ExtCASNum toExtCASNum(){return this.t;}
                                    
                                    @Override
                                    public String toString(){return this.t.toString();}
                                    
                                    public ExtCASDeductionClass getExtCASDeductionClass(){return this.b;}
                                    public ExtCASNum getBase(){return this.getExtCASDeductionClass().getBase();}
                                   
                                }
                        
                        
                    }
            
                    public static final class FixedPointNumberClass extends ExtCASBaseType
                            {
                            public static final Ariphmetical Decimal,
                                                             Binary,
                                                            Trinity,
                                                            Eight,
                                                            OneByte,
                                                            OneExtChar;
                            
                            static
                                {
                                Decimal = (new Ariphmetical(10)).cast(8);
                                Binary = (new Ariphmetical(2)).cast(8);
                                Trinity = (new Ariphmetical(3)).cast(8);
                                Eight  = (new Ariphmetical(8)).cast(8);
                                OneByte = (new Ariphmetical(256)).cast(8);
                                OneExtChar = Ariphmetical.
                                        pow(
                                                Binary
                                                    , 
                                                Ariphmetical.
                                                        sum(
                                                                Eight
                                                                ,
                                                                Eight
                                                        )
                                        )
                                        .cast(8);
                                }
                            
                            private Ariphmetical base,weight;
                            }
            
            
            /*
             * Base type of all types.
             */
            /*
            public static  class ExtCASBaseType
                        {
                        protected static ExtVector<Pair<ExtString,Ariphmetical>> extCasTypes;
                        static
                            {
                            ExtString str;
                            Ariphmetical a;
                            Pair<ExtString,Ariphmetical> p;
                            ExtVector<Pair<ExtString,Ariphmetical>> v = new ExtVector<Pair<ExtString,Ariphmetical>>();
                            extCasTypes=v;
                            ///////////////////////////////////
                            // 0 - Base type without something.
                            ///////////////////////////////////
                            a=Ariphmetical.N;
                            str=new ExtString("Base type.");
                            p=new Pair<ExtString,Ariphmetical>();
                            p.first(str);
                            p.second(a);
                            v.pushBack(p);
                            ///////////////////////////////////
                            ///////////////////////////////////
                            // 1 - Base type without something.
                            ///////////////////////////////////
                            a=Ariphmetical.sum(a, Ariphmetical.E);
                            str=new ExtString("ExtCasSym.");
                            p=new Pair<ExtString,Ariphmetical>();
                            p.first(str);
                            p.second(a);
                            v.pushBack(p);
                            ///////////////////////////////////
                            ///////////////////////////////////
                            // 2 - Base type without something.
                            ///////////////////////////////////
                            a=Ariphmetical.sum(a, Ariphmetical.E);
                            str=new ExtString("ExtCasNum.");
                            p=new Pair<ExtString,Ariphmetical>();
                            p.first(str);
                            p.second(a);
                            v.pushBack(p);
                            
                            
                            
                            }
                        protected Ariphmetical extCasTypeNumber;
                        public ExtCASBaseType(){this.extCasTypeNumber=Ariphmetical.N;}
                        
                        }
            */
            
            /**
             * Base type of all types of view of ExtCAS___.
             */
            public static class ExtCASBaseType
                        {
                        protected ChainStack<Ariphmetical> type;
                        protected void init(Ariphmetical t)
                                    {
                                    this.type=new ChainStack<Ariphmetical>();
                                    this.type.set(t);
                                    }
                        public ExtVector<Ariphmetical> getTypeRoad()
                                    {
                                    ChainStack<Ariphmetical> tps;
                                    ExtVector<Ariphmetical> ans;
                                    ans=new ExtVector<Ariphmetical>();
                                    tps=this.type;
                                    while(tps!=null)
                                        {
                                        ans.pushFront(tps.get());
                                        tps=tps.next();
                                        }
                                    return ans;
                                    }
                        
                        public ExtCASBaseType()
                                {
                                this.init(Ariphmetical.N);
                                }
                        
                        
                        
                        }
            
            }
}
