
package extJavaLib.extNumLib;

import extJavaLib.baseBlockLib.Pair;
import extJavaLib.baseBlockLib.Trine;
import extJavaLib.extStructLib.ExtVector;
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
        errs=new String[4];
        errs[0]="Null argument is forbidden.";
        errs[1]="Only integer subtypes can be given.";
        errs[2]="This method/constructor can not be used. Use Method/constructor with arguments.";
        errs[3]="Argument must be greater than 0.";
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
            public static class ExtCASNum
                {
                private final Ariphmetical a;
                
                public ExtCASNum(){a=Ariphmetical.N;}
                
                public ExtCASNum(Short sh)
                        {
                        this.a=new Ariphmetical(sh);
                        }
                public ExtCASNum(Short sh,Short sh1)
                        {
                        this.a=new Ariphmetical(sh,sh1);
                        }
                
                public ExtCASNum(ExtChar sh)
                        {
                        this.a=new Ariphmetical(sh);
                        }
                public ExtCASNum(ExtChar sh,ExtChar sh1)
                        {
                        this.a=new Ariphmetical(sh.charValue(),sh1.charValue());
                        }
                
                public ExtCASNum(Byte sh)
                        {
                        this.a=new Ariphmetical(sh);
                        }
                public ExtCASNum(Byte sh,Byte sh1)
                        {
                        this.a=new Ariphmetical(sh,sh1);
                        }
                
                public ExtCASNum(Integer sh)
                        {
                        this.a=new Ariphmetical(sh);
                        }
                public ExtCASNum(Integer sh,Integer sh1)
                        {
                        this.a=new Ariphmetical(sh,sh1);
                        }
                
                public ExtCASNum(Long sh)
                        {
                        this.a=new Ariphmetical(sh);
                        }
                public ExtCASNum(Long sh,Long sh1)
                        {
                        this.a=new Ariphmetical(sh,sh1);
                        }
                
                public ExtCASNum(Float sh)
                        {
                        this.a=new Ariphmetical(sh);
                        }
                
                public ExtCASNum(Double sh)
                        {
                        this.a=new Ariphmetical(sh);
                        }
                
                public ExtCASNum(ExtInteger sh)
                        {
                        ExtNum tmp;
                        tmp=new ExtNum(sh);
                        this.a=new Ariphmetical(tmp);
                        }
                
                public ExtCASNum(ExtSInteger sh)
                        {
                        ExtNum tmp;
                        tmp=new ExtNum(sh);
                        this.a=new Ariphmetical(tmp);
                        }
                
                public ExtCASNum(Racio sh)
                        {
                        ExtNum tmp;
                        tmp=new ExtNum(sh);
                        this.a=new Ariphmetical(tmp);
                        }
                
                public ExtCASNum(ExtNum sh)
                        {
                        ExtNum tmp;
                        tmp=new ExtNum(sh);
                        this.a=new Ariphmetical(tmp);
                        }
                
                public ExtCASNum(Ariphmetical aa)
                        {
                        if(aa==null)
                            {
                            a=Ariphmetical.N;
                            ExtCASLib.except(0);
                            }
                            else a=aa;
                        }
                public ExtCASNum(ExtCASNum n)
                        {
                        if(n==null)
                            {
                            a=Ariphmetical.N;
                            ExtCASLib.except(0);
                            }
                        else
                            a=n.toAriphmetical();
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
            
            public final static class ExtCASDeductionClass
                    {
                        private final ExtCASNum base;
                        public final static ExtCASNum E,N;
                        static
                            {
                            /*
                            E=new ExtCASNum(1);
                            N=new ExtCASNum(0);
                            */
                            E=new ExtCASNum(Ariphmetical.E);
                            N=new ExtCASNum(Ariphmetical.N);
                            }
                        
                        public ExtCASNum getBase(){return this.base;}
                        
                        public ExtCASDeductionClass()
                                {
                                this.base=N;
                                ExtCASLib.except(2);
                                
                                }
                        
                        public ExtCASDeductionClass(ExtCASNum a)
                                {
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
                        
                        
                        public class ExtCASDeduction
                                {
                                    private final ExtCASNum t;
                                    private final ExtCASDeductionClass b;
                                    public ExtCASDeduction()
                                                {
                                                b=ExtCASDeductionClass.this;
                                                //b.base=null;
                                                this.t=ExtCASDeductionClass.N;
                                                }
                                    
                                    public ExtCASDeduction(ExtCASNum ttt)
                                                {
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
            
            
            
            
            }
}
