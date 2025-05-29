package extJavaLib.extNumLib;

import extJavaLib.baseBlockLib.ChainStack;
import extJavaLib.baseBlockLib.Trine;


import extJavaLib.extNumLib.ExtNum;
import extJavaLib.extNumLib.ExtNumCalc;

import extJavaLib.extJavaLibExceptions.ExtJavaLibExceptions.ExtNumLibExceptions.ExtNumLibException;
        
public class ExtPointedNumber
{
        public final static ExtNum
                    ZERO,
                    UNITY,
                    BINARY,
                    TRINITY,
                    EIGHT,
                    DEC,
                    HEX,
                    ONE_BYTE,
                    ONE_EXTCHAR;
        
        private final static String[] errs;
        
        protected void except(int i)
                {
                throw new ExtNumLibException(new String(errs[i]));
                }
        
        static
            {
            ZERO = ExtNumCalc.NULL;
            UNITY = ExtNumCalc.E;
            BINARY = ExtNumCalc.sum(UNITY,UNITY);
            TRINITY = ExtNumCalc.sum(UNITY,BINARY);
            EIGHT = ExtNumCalc.pow(BINARY,TRINITY);
            DEC = ExtNumCalc.prod(BINARY,ExtNumCalc.sum(BINARY,TRINITY));
            HEX = ExtNumCalc.sum(EIGHT,EIGHT);
            ONE_BYTE = ExtNumCalc.pow(HEX, BINARY);
            ONE_EXTCHAR = ExtNumCalc.pow(HEX,BINARY);
            ///////////////////////////////////////////////////////////////
            ///////////////////////////////////////////////////////////////
            ///////////////////////////////////////////////////////////////
            ///////////////////////////////////////////////////////////////
            errs = new String[5];
            errs[0] = "Null argument is forbidden here.";
            errs[1] = "Need positive integer ExtNum.";
            errs[2] = "Lenght must be greater than zero. For this lenght of exp or lenght of mantiss must be greater than zero.";
            errs[3] = "Base must be greater than zero integer.";
            }
    
    
        public final static class ExtFixedPointNumberClass extends ExtPointedNumber
            {
            private ExtNum base;
            private ExtNum lenght_int;
            private ExtNum lenght_fr;
            private ExtNum lenght;
            
            
            private void init_(ExtNum b, ExtNum inti, ExtNum fr)
                {
                this.base = b;
                this.lenght_int = inti;
                this.lenght_fr = fr;
                this.lenght = ExtNumCalc.sum(this.lenght_int,this.lenght_fr);
                }
            
            public ExtFixedPointNumberClass(ExtNum b, ExtNum inti, ExtNum fr)
                {
                if(b == null || inti == null || fr == null)
                    super.except(0);
                else
                if(b.type() !=0 || inti.type() != 0 || fr.type() != 0)
                    super.except(1);
                else
                if(b.zero())
                    super.except(3);
                else
                if(inti.zero() && fr.zero())
                    super.except(2);
                else
                    {
                    this.init_(b, inti, fr);
                    }
                }
            
            public ExtFixedPointNumberClass()
                {
                //this.base = ExtPointedNumber.DEC;
                //this.lenght_fr = ExtPointedNumber.HEX;
                //this.lenght_int = ExtPointedNumber.HEX;
                this.init_(DEC, HEX, HEX);
                }
            
            public Trine<ExtNum,ExtNum,ExtNum> getProp()
                {
                Trine<ExtNum,ExtNum,ExtNum> ans = new Trine<ExtNum,ExtNum,ExtNum>();
                ans.first(new ExtNum(this.base));
                ans.second(new ExtNum(this.lenght_fr));
                ans.third(new ExtNum(this.lenght_int));
                return ans;
                }
            
            private boolean theSameClass(ExtFixedPointNumber q)
                {
                boolean ans;
                Trine<ExtNum,ExtNum,ExtNum> trt= this.getProp(),trth=q.getTheClass().getProp();
                /*
                ans =
                        (ExtNumCalc.cmp(trt.first(), trth.first())==3) 
                                &&
                        (ExtNumCalc.cmp(trt.second(), trth.second())==3)
                                &&
                        (ExtNumCalc.cmp(trt.third(), trth.third())==3);
                */
                
                /*
                if(ExtNumCalc.cmp(trt.first(), trth.first())!=3)
                    ans=false;
                else
                    if(ExtNumCalc.cmp(trt.second(), trth.second())!=3)
                        ans=false;
                    else
                        if(ExtNumCalc.cmp(trt.third(), trth.third())!=3)
                            ans=false;
                        else ans=true;
                */
                
                if(
                        (ExtNumCalc.cmp(trt.first(), trth.first())==3)
                        &&
                        (ExtNumCalc.cmp(trt.second(), trth.second())==3)
                        &&
                        (ExtNumCalc.cmp(trt.third(), trth.third())==3)
                  )
                    ans=true;
                else
                    ans=false;
                
                
                return ans;
                }
            
            
            
            public final class ExtFixedPointNumber
                {
                
                private int s;
                private ChainStack<ExtNum> st;
                
                /*
                public Trine<ExtNum,ExtNum,ExtNum> getProp()
                    {
                        return ExtFixedPointNumberClass.this.getProp();
                    }
                */
                
                public ExtFixedPointNumberClass getTheClass()
                        {
                        return ExtFixedPointNumberClass.this;
                        }
                
                public ExtFixedPointNumber()
                    {
                    ChainStack<ExtNum> st;
                    ExtNum l,e;
                    l = ExtFixedPointNumberClass.this.lenght;
                    e = ExtPointedNumber.UNITY;
                    st = new ChainStack<>();
                    st.set(ExtPointedNumber.ZERO);
                    this.st=st;
                    l = ExtNumCalc.sub(l,e);
                    while(!l.zero())
                        {
                        l = ExtNumCalc.sub(l,e);
                        st.next(new ChainStack<>());
                        st=st.next();
                        st.set(ExtPointedNumber.ZERO);
                        }
                    }
                
                
                
                public ExtFixedPointNumber(ExtNum a)
                        {
                        this.init_(a);
                        }
                
                public ExtFixedPointNumber(ExtFixedPointNumber a)
                        {
                        
                        }
                
                
                private void init_(ExtNum a)
                    {
                    ChainStack<ExtNum> st1,st2,st3;
                    int vsp;
                    Trine<ExtNum,ExtNum,ExtNum> tr=null;
                    ExtNum b,l,e,c;
                    if(a==null)
                        ExtFixedPointNumberClass.this.except(0);
                    //else
                    //    tr = ExtNumCalc.get_Trine(a);
                    e = ExtPointedNumber.UNITY;
                    l = ExtFixedPointNumberClass.this.lenght_int;
                    a = new ExtNum(a);
                    a.simp();
                    this.s=a.sign();
                    a.sign(0);
                    tr = ExtNumCalc.get_Trine(a);
                    a = tr.first();
                    b = tr.second();
                    c= tr.third();
                    tr = null;
                    if(l.zero())
                        {
                        st1=null;
                        st2=null;
                        st3=null;
                        }
                    else
                        if(a.zero())
                            {
                            st1 = new ChainStack<>();
                            st1.set(ExtNumCalc.NULL);
                            st2=st1;
                            l = ExtNumCalc.sub(l,e);
                            while(!l.zero())
                                {
                                l = ExtNumCalc.sub(l,e);
                                st2.next(new ChainStack<>());
                                st2=st2.next();
                                st2.set(ExtNumCalc.NULL);
                                }
                            }
                        else
                            {
                            st1 = new ChainStack <> () ;
                            tr = ExtNumCalc.get_Trine(a, ExtFixedPointNumberClass.this.base);
                            st1.set(tr.second());
                            st2=st1;
                            l = ExtNumCalc.sub(l,e);
                            while(!l.zero())
                                {
                                st2.next(new ChainStack<>());
                                st2=st2.next();
                                
                                l = ExtNumCalc.sub(l,e);
                                if(tr.first().zero())
                                    st2.set(ExtNumCalc.NULL);
                                else
                                    {
                                    tr = ExtNumCalc.get_Trine(tr.first(), ExtFixedPointNumberClass.this.base);
                                    st2.set(tr.second());
                                    }
                                }
                            }
                    l = ExtFixedPointNumberClass.this.lenght_fr;
                    if(!l.zero())
                        if(b.zero())
                                {
                            
                                while(!l.zero())
                                  {
                                   l = ExtNumCalc.sub(l,e);
                                    st2=new ChainStack<>();
                                    st2.set(ExtNumCalc.NULL);
                                    st2.next(st1);
                                    st1=st2;
                                    }
                                }
                        else
                                {
                                a = null;
                                tr = null;
                                b = ExtNumCalc.div(b,c);
                                
                                c=null;
                                while(!l.zero())
                                    if(!b.zero())
                                        {
                                        l = ExtNumCalc.sub(l,e);
                                        st2=new ChainStack<>();
                                        st2.next(st1);
                                        b = ExtNumCalc.prod(ExtFixedPointNumberClass.this.base, b);
                                        tr = ExtNumCalc.getTrine(b);
                                        st2.set(tr.first());
                                        b = ExtNumCalc.div(tr.second(), tr.third());
                                        //tr = ExtNumCalc.get_Trine(b);
                                        st1=st2;
                                        }
                                    else
                                        {
                                        l = ExtNumCalc.sub(l,e);
                                        st2=new ChainStack<>();
                                        st2.next(st1);
                                        st2.set(ExtNumCalc.NULL);
                                        st1=st2;
                                        }
                                b=null;
                                tr = null;
                                }
                    this.st = st1;
                    }
                
                public ExtNum toExtNum()
                        {
                        ExtNum s,ans=ExtNumCalc.NULL,l,b;
                        ChainStack<ExtNum> st=this.st;
                        s=ans;
                        l=ExtFixedPointNumberClass.this.lenght_fr;
                        b = ExtFixedPointNumberClass.this.base;
                        
                        while(!l.zero())
                            {
                            l = ExtNumCalc.sub(l,ExtNumCalc.E);
                            s = ExtNumCalc.sum(ExtNumCalc.div(s,b), st.get());
                            st=st.next();
                            }
                        s = ExtNumCalc.div(s,b);
                        b = ExtNumCalc.E;
                        while(st!=null)
                            {
                            s = ExtNumCalc.sum(s,ExtNumCalc.prod(b, st.get()));
                            st=st.next();
                            b = ExtNumCalc.prod(b,ExtFixedPointNumberClass.this.base);
                            }
                        ans=s;
                        ans.sign(this.s);
                        return ans;
                        }
                
                
                }
            
            
            
            }
        
    
}
