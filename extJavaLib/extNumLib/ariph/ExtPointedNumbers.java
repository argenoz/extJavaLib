
package extJavaLib.extNumLib.ariph;

import extJavaLib.baseBlockLib.Pair;
import extJavaLib.baseBlockLib.Trine;
import extJavaLib.baseBlockLib.ChainStack;

import extJavaLib.extJavaLibExceptions.ExtJavaLibExceptions.ExtPointedNumbersException;
import extJavaLib.extJavaLibExceptions.ExtJavaLibExceptions.ExtJavaLibBaseException;

public final class ExtPointedNumbers {
    private final static String[] errs;
    

    /**
     * proizvedenie nabora chisel
     * @param args
     * @return product of all elements if ChainDqueue
     */
    private static ChainStack<ExtInteger> mult(ChainStack<ExtInteger> args)
            {
            ExtInteger s=null;
            if(args==null)
                s = new ExtInteger();
            else
            if(args.next()==null)
                {
                s = new ExtInteger(args.get());
                args = args.next();
                }
            else {
            s = new ExtInteger(args.get());
            args = args.next();
                     
            while(args!=null)
                {
                s.mul(args.get());
                args = args.next();
                if(s.zero()==0) break;
                }
            }
            args = new ChainStack<>();
            args.set(s);
            return args;
            }
    /**
     * summa nabora chisel
     * @param args
     * @return summ of all elements if ChainDqueue
     */
    private static ChainStack<ExtInteger> sum(ChainStack<ExtInteger> args)
            {
            ExtInteger s=null;
            if(args==null)
                s = new ExtInteger();
            else
            if(args.next()==null)
                {
                s = new ExtInteger(args.get());
                args = args.next();
                }
            else {
            s = new ExtInteger(args.get());
            args = args.next();
                    
            while(args!=null)
                {
                s.add(args.get());
                args = args.next();
                }
            }
            args = new ChainStack<>();
            args.set(s);
            return args;
            }
    
    /**
     *  quotient  and remainder of two first elements in ChainDqueue
     * @param args
     * @return quotient  and remainder of two first elements in ChainDqueue
     */
    private static ChainStack<ExtInteger> QR(ChainStack<ExtInteger> args)
            {
            ChainStack<ExtInteger> ans;
            ExtInteger[] i_tmp;
            
            i_tmp = ExtInteger.QR(args.get(), args.next().get());
            ans = new ChainStack<ExtInteger>();
            ans.set(i_tmp[0]);
            ans.next(new ChainStack<>());
            ans.next().set(i_tmp[1]);
            return ans;
            }
    /**
     * comparasion of two first elements in chainDqueue
     * @param args
     * @return 3 if they are equiv, 2 if first element is greater than second and 1 if second is greater than first.
     */
    private static ChainStack<ExtInteger> cmp(ChainStack<ExtInteger> args)
            {
            int i;
            
            if(args==null)
                i=3;
            else
            if(args.next()==null)
                i=3;
            else
                {
                i = args.get().srav(args.next().get());
                if(i==0)
                    i=3;
                else
                    if(i==1)
                        i=2;
                    else
                        i=1;
                
                }
            args = null;
            args = new ChainStack<>();
            args.set(new ExtInteger(i));
            return args;
            }
    
    
    private static ChainStack<ExtInteger> cmp_all(ChainStack<ExtInteger> args1,ChainStack<ExtInteger> args2)
            {
            int i=3,j;
            
            while(args1!=null)
                {
                    j = args1.get().srav(args2.get());
                    if( j == 1 )
                        i = 2;
                    else
                        if( j == 2 )
                            i = 1;
                    args1=args1.next();
                    args2=args2.next();
                }
            
            args1 = new ChainStack<>();
            args1.set(new ExtInteger(i));
            return args1;
            }
    
    
    /**
     * sum of all elements in chainDqueue from second in deduction class of base of first element.
     * @param args
     * @return sum of all elements in chainDqueue from second in deduction class of base of first element.
     */
    private static ChainStack<ExtInteger> sum_b(ChainStack<ExtInteger> args)
            {
            ChainStack<ExtInteger> ans, tmp;
            ExtInteger s;
            if(args==null)
                {
                ans = new ChainStack<>();
                ans.set(new ExtInteger());
                }
            else
            if(args.next()==null)
                {
                ans = new ChainStack<>();
                ans.set(new ExtInteger());
                }
            else
                {
                ans = sum(args.next());
                ans.next(new ChainStack<>());
                ans.next().set(new ExtInteger(args.get()));
                ans = QR(ans);
                ans = ans.next();
                }
            return ans;
            }
    
    /**
     * prodct of all elements in chainDqueue from second in deduction class of base of first element.
     * @param args
     * @return prodct of all elements in chainDqueue from second in deduction class of base of first element.
     */
    private static ChainStack<ExtInteger> mult_b(ChainStack<ExtInteger> args)
            {
            ChainStack<ExtInteger> ans, tmp;
            ExtInteger s;
            if(args==null)
                {
                ans = new ChainStack<>();
                ans.set(new ExtInteger());
                }
            else
            if(args.next()==null)
                {
                ans = new ChainStack<>();
                ans.set(new ExtInteger());
                }
            else
                {
                ans = mult(args.next());
                ans.next(new ChainStack<>());
                ans.next().set(new ExtInteger(args.get()));
                ans = QR(ans);
                ans = ans.next();
                }
            return ans;
            }
    
    /**
     * inversion of all elements in chainDqueue from second in deduction class of base of first element.
     * @param args
     * @return inversion of all elements in chainDqueue from second in deduction class of base of first element.
     */
    private static ChainStack<ExtInteger> invert_b(ChainStack<ExtInteger> args)
            {
            ChainStack<ExtInteger> tail,ans;
                ExtInteger b,tmp;
                ans = new ChainStack<ExtInteger>();
                b = new ExtInteger(args.get());
                ans.set(b);
                tail = ans;
                args = args.next();
                while(args!=null)
                    {
                    tmp = new ExtInteger(b);
                    tmp.sub(args.get());
                    tail.next(new ChainStack<>());
                    tail = tail.next();
                    tail.set(tmp);
                    args = args.next();
                    }
                return ans;
            }
    
    /**
     * sub of all elements in chainDqueue from second in deduction class of base of first element.
     * @param args
     * @return result of sub of two elements in chainDqueue from second in deduction class of base of first element.
     */
    private static ChainStack<ExtInteger> sub_b(ChainStack<ExtInteger> args)
            {
            ChainStack<ExtInteger> ans;
            ans = new ChainStack<ExtInteger>();
            ans.next(new ChainStack<ExtInteger>());
            ans.set(new ExtInteger(args.get()));
            ans.next().set(new ExtInteger(args.next().next().get()));
            ans = invert_b(ans);
            ans.next().next(new ChainStack<>());
            ans.next().next().set(new ExtInteger(args.next().get()));
            args = null;
            ans = sum_b(ans);
            return ans;
            }
    
    /**
     * poweration of all elements in chainDqueue from second in deduction class of base of first element.
     * a b c -> c^(b^a)
     * @param args
     * @return result of poweration of two elements in chainDqueue from second in deduction class of base of first element.
     */
    private static ChainStack<ExtInteger> pow_n(ChainStack<ExtInteger> args)
            {
            ExtInteger t1,t2;
            t1 = new ExtInteger(args.get());
            args = args.next();
            t2 = t1;
            while(args != null)
                {
                    t1 = t2;
                    t2 = new ExtInteger(args.get());
                    t2=t2.pow(t1);
                    args = args.next();
                }
            args = new ChainStack<>();
            args.set(t2);
            return args;
            }
    
    
    
    
    
                    
     public static final ExtInteger 
            NULL,
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
        errs = new String[6];
        errs[0] = "Null argument.";
        errs[1] = "First argument must be greater than zero.";
        errs[2] = "Sum of second and third argument must be greater than zero.";
        errs[3] = "Argument(s) is(are) not correct.";
        /////////////////////////////////////////////////
        /////////////////////////////////////////////////
        /////////////////////////////////////////////////
        /////////////////////////////////////////////////
        /////////////////////////////////////////////////



        
        
        /////////////////////////////////////////////////
        /////////////////////////////////////////////////
        /////////////////////////////////////////////////
        /////////////////////////////////////////////////
        /////////////////////////////////////////////////
        
        ChainStack<ExtInteger> vsp = new ChainStack<ExtInteger>();
        vsp.next(new ChainStack<ExtInteger>());
        
        NULL = ExtInteger.N;
        UNITY = ExtInteger.E;
            vsp.set(UNITY);//1
            vsp.next().set(UNITY);// 1 1
            vsp.next().next(sum(vsp));// 1 1 2
        BINARY = vsp.next().next().get();
            vsp = vsp.next();// 1 2
            vsp.next().next(sum(vsp));// 1 2 3
        TRINITY = vsp.next().next().get();
            vsp.next().next().next(vsp.next());//1 2 3 (2)
            vsp = vsp.next().next();// 3 2 (3)
            vsp.next().next(null);//3 2
            vsp.next().next(pow_n(vsp));//3 2 8
        EIGHT = vsp.next().next().get();
            vsp.next().next(null);//3 2
            vsp.next().next(sum(vsp));//3 2 5
            vsp = vsp.next();//2 5
            vsp.next().next(mult(vsp));//2 5 10
        DECI = vsp.next().next().get();    
            vsp = vsp.next();//5 10
            vsp.next().next(new ChainStack<>());
            vsp.next().next().set(UNITY);//5 10 1
            vsp = sum(vsp);//16
        HEX = vsp.get();
            vsp.next(new ChainStack<>());
            vsp.next().set(BINARY);//16 2
            vsp.next().next(vsp);//16 2 (16)
            vsp = vsp.next();// 2 16 (2)
            vsp.next().next(null);//2 16
            vsp.next(pow_n(vsp));//2 256
        ONE_BYTE = vsp.next().get();
            vsp.next(pow_n(vsp));//2 256^2
        ONE_EXTCHAR = vsp.next().get();
            //ONE_EXTCHAR.mul(BINARY);
        vsp = null;
        /////////////////////////////////////////////////
        /////////////////////////////////////////////////
        /////////////////////////////////////////////////
        /////////////////////////////////////////////////
        /////////////////////////////////////////////////
        
        
        }
    
    private static ExtPointedNumbersException except(int i)
        {
        ExtPointedNumbersException expt = null;
        if(i<errs.length)
        expt = new ExtPointedNumbersException(new String(errs[i]));
        else
            throw new ExtJavaLibBaseException("Out of range.");
        return expt;
        }
    
    private static ExtPointedNumbersException except(String str)
        {
        return new ExtPointedNumbersException(new String(str));
        }
    
    
    
    
    public static class ExtFixedPointNumberClass
        {
        private ExtInteger baza,//base of system number.
                           len_of_int_part,//length(nmber of digits of system number with base of baza) of integer part
                           len_of_frac_part;//length(nmber of digits of system number with base of baza) of fractional  part
        
        private ExtPointedNumbersException except(int i)
                {
                return ExtPointedNumbers.except(i);
                }
        
        private ExtPointedNumbersException except(String str)
                {
                return ExtPointedNumbers.except(str);
                }
        
        
        public Trine<ExtInteger,ExtInteger,ExtInteger> getProp()
                {
                Trine<ExtInteger,ExtInteger,ExtInteger> ans=new Trine<ExtInteger,ExtInteger,ExtInteger> ();
                ans.first(new ExtInteger(this.baza));
                ans.second(new ExtInteger(this.len_of_int_part));
                ans.third(new ExtInteger(this.len_of_frac_part));
                return ans;
                }
        
        private void init_(ExtInteger b, ExtInteger l_i, ExtInteger l_fr)
                {
                this.baza = new ExtInteger(b);
                this.len_of_int_part = new ExtInteger(l_i);
                this.len_of_frac_part = new ExtInteger(l_fr);
                }
        
        public ExtFixedPointNumberClass()
                {
                this.init_(ExtPointedNumbers.DECI, ExtPointedNumbers.HEX, ExtPointedNumbers.HEX);
                }
        
        
        
        public ExtFixedPointNumberClass(ExtInteger ba, ExtInteger l_i, ExtInteger l_fr)
                {
                ExtInteger l;
                if(ba==null || l_i == null || l_fr ==null)
                    throw this.except(0);
                if(ba.zero()==0)
                    throw this.except(1);
                l = new ExtInteger(l_i);
                l.add(l_fr);
                if(l.zero()==0)
                   throw this.except(2);
                else l=null;
                this.init_(ba, l_i, l_fr);
                }
        
        private static boolean theSame(ExtFixedPointNumber a, ExtFixedPointNumber b)
                {
                boolean ans;
                Trine<ExtInteger,ExtInteger,ExtInteger> ap,bp;
                
                if(a.getDomain()==b.getDomain())
                    ans = true;
                else
                {
                ap = a.getProp();
                bp = b.getProp();
                if(ap.first().srav(bp.first())!=0)
                    ans = false;
                else
                if(ap.second().srav(bp.second())!=0)
                    ans = false;
                else
                if(ap.third().srav(bp.third())!=0)
                    ans = false;
                else
                    ans = true;
                }
                return ans;
                }
        
        public ExtFixedPointNumber sum(ExtFixedPointNumber a, ExtFixedPointNumber b)
                {
                ExtFixedPointNumber ans=null;
                Pair<ExtInteger,ChainStack<ExtInteger>> pa,pb;
                ChainStack<ExtInteger> expr,st1,st2,st3,st4,sa,sb,sr;
                
                int s = 0;
                
                
                
                if(a==null || b==null)
                   throw this.except(0);
                else
                if(ExtFixedPointNumberClass.theSame(a, b))
                        {
                        
                        sa = null;
                        sb = null;
                        expr = new ChainStack<ExtInteger>();
                        expr.next(new ChainStack<ExtInteger>());
                        expr.set(new ExtInteger(ExtPointedNumbers.NULL));
                        expr.next().set(new ExtInteger(ExtPointedNumbers.NULL));
                        pa = a.getMain();
                        pb = b.getMain();
                        sr = new ChainStack<>();
                        sr.set(this.baza);
                        s =(int) ExtPointedNumbers.cmp_all(pa.second(), pb.second()).get().to_long();
                        if(((int)pa.first().to_long())%2!=0)
                            {
                            sr.next(pa.second());
                            //pa.second(ExtPointedNumbers.invert_b(sr.next()));
                            sa = ExtPointedNumbers.invert_b(sr.next()).next();
                            sr.next(null);
                            }
                        else sa = pa.second();
                        if(((int)pb.first().to_long())%2!=0)
                            {
                            sr.next(pb.second());
                            //pb.second(ExtPointedNumbers.invert_b(sr.next()));
                            sb = ExtPointedNumbers.invert_b(sr.next()).next();
                            sr.next(null);
                            }
                        else sb = pb.second();
                        if(s>=2)
                            s = (int)pa.first().to_long();
                        else
                            s = (int)pb.first().to_long();
                        ans = this.new ExtFixedPointNumber();
                        System.out.print(ans.getMain()==null);
                        sr = ans.getMain().second();
                        
                        st1 =null;
                        st2=null;
                        st3 = sr;
                        st4=null;
                        while(sa!=null)
                            {
                            expr.get().add(sa.get());
                            expr.get().add(sb.get());
                            expr.next().set(this.baza);
                            expr = ExtPointedNumbers.QR(expr);
                            st3.set(expr.next().get());
                            sa = sa.next();
                            sb = sb.next();
                            st3=st3.next();
                            
                            }
                        ans.l=sr;
                        ans.s=s;
                        }
                else
                    throw this.except(3);
                return ans;
                }
        
        
        
        public class ExtFixedPointNumber
                {
                /**
                 * sign
                 * 0 -   zero;
                 * 1 - positive;
                 * 2 - negative;
                 */
                private int s;//sign
                /**
                 * line of digits with base of baze.
                 */
                ChainStack<ExtInteger> l;
                
                public ExtInteger getSign(){return new ExtInteger(this.s);}
                
                public Trine<ExtInteger,ExtInteger,ExtInteger> getProp()
                    {
                    return ExtFixedPointNumberClass.this.getProp();
                    }
                
                public ExtFixedPointNumberClass getDomain()
                    {
                    return ExtFixedPointNumberClass.this;
                    }
                        
                public Pair<ExtInteger,ChainStack<ExtInteger>> getMain()
                        {
                        ChainStack<ExtInteger> h,t,th ;
                        Pair<ExtInteger,ChainStack<ExtInteger>> ans = new 
                                Pair<ExtInteger,ChainStack<ExtInteger>>();
                        ans.first(new ExtInteger(this.s));
                        h = new ChainStack<>();
                        h.set(new ExtInteger(this.l.get()));
                        t=h;
                        th = this.l.next();
                        while(th!=null)
                            {
                            t.next(new ChainStack<>());
                            t=t.next();
                            
                            //System.out.print(th.get()+"\n");
                            t.set(new ExtInteger(th.get()));
                            th=th.next();
                            }
                        ans.second(h);
                        return ans;
                        }
                
                public ExtFixedPointNumber()
                        {
                        ChainStack<ExtInteger> tmp;
                        ExtInteger l = new ExtInteger(ExtFixedPointNumberClass.this.len_of_frac_part);
                        l.add(ExtFixedPointNumberClass.this.len_of_int_part);
                        this.l = new ChainStack<>();
                        this.l.set(new ExtInteger(ExtInteger.N));
                        //this.l.set(new ExtInteger());
                        tmp = this.l;
                        l.sub(ExtInteger.E);
                        if(l.zero()!=0)
                            while(true)
                                {
                                tmp.next(new ChainStack<>());
                                tmp = tmp.next();
                                tmp.set(new ExtInteger(ExtInteger.N));
                                //this.l.set(new ExtInteger(ExtInteger.N));
                                l.sub(ExtInteger.E);
                                if(l.zero()==0) break;
                                //this.l.set(new ExtInteger());
                                }
                        this.s= 0;
                        }
                
                public ExtFixedPointNumber(ExtFixedPointNumber a)
                        {
                        Pair<ExtInteger,ChainStack<ExtInteger>> p;
                        if(ExtFixedPointNumberClass.theSame(this,a))
                            {
                            p = a.getMain();
                            this.s = (int)(p.first().to_long());
                            this.l = p.second();
                            }
                        else throw ExtFixedPointNumberClass.this.except(3);
                        }
                
                public ExtFixedPointNumber(ExtInteger a)
                        {
                        ExtInteger[] r = new ExtInteger[2];
                        ExtInteger l;
                        ChainStack<ExtInteger> stk;
                        r[0] = new ExtInteger(a);
                        l = new ExtInteger(ExtFixedPointNumberClass.this.len_of_frac_part);
                        l.add(ExtFixedPointNumberClass.this.len_of_int_part);
                        l.sub(ExtPointedNumbers.UNITY);
                        this.l = new ChainStack<>();
                        r = ExtInteger.QR(r[0],ExtFixedPointNumberClass.this.baza);
                        this.l.set(r[1]);
                        stk = this.l;
                        while(l.zero()!=0)
                            if(r[0].zero()==0)
                                {
                                stk.next(new ChainStack<>());
                                stk = stk.next();
                                stk.set(new ExtInteger());
                                l.sub(ExtPointedNumbers.UNITY);
                                }
                            else
                                {
                                stk.next(new ChainStack<>());
                                stk = stk.next();
                                r = ExtInteger.QR(r[0],ExtFixedPointNumberClass.this.baza);
                                stk.set(r[1]);
                                l.sub(ExtPointedNumbers.UNITY);
                                }
                        } 
                        
                        
                        
                        
                }
        
        
        
        
        
        
        }
    
    
    
    
}






