package extJavaLib.extNumLib.vspomo;

import extJavaLib.extNumLib.Ariphmetical;
import extJavaLib.extNumLib.ExtNum;


import extJavaLib.extStructLib.BaseExtStructs.ExtArray;

import extJavaLib.extJavaLibExceptions.ExtJavaLibExceptions.ExtJavaLibBaseException;
import extJavaLib.extJavaLibExceptions.ExtJavaLibExceptions;

        
public class EJLLinearAlgebra {
    
    
    public static ExtJavaLibBaseException except(String s)
        {
        return ((ExtJavaLibBaseException)
                ((Throwable)ExtJavaLibExceptions.except(s)).
                        fillInStackTrace());
        }
    
    public static class Matrix
        {
        private static final String[] errs;
        private static final Ariphmetical N,E,baseR,baseC;
        static
            {
            N = Ariphmetical.N8;
            E = Ariphmetical.E8;
            baseR = (new Ariphmetical(10)).cast(8);
            baseC = (new Ariphmetical(10)).cast(8);
            errs=new String[5];
            errs[0]="Null argument is forbidden.";
            errs[1] = "Bad subtype of argument.";
            errs[2] = "Bounds can be only greater than zero and only integer.";
            errs[3] = "qwe";
            }    
        private ExtArray<ExtArray<Ariphmetical>> cells;
        private  Ariphmetical r,c;
        
        private void init(Ariphmetical r, Ariphmetical c)
            {
            if(r==null || c == null)
                throw except(errs[0]);
            else
            if(r.type()!=8 || c.type()!=8)
                throw except(errs[1]);
            else
            if(Ariphmetical.cmp(r,N)!=2 && Ariphmetical.cmp(c,N)!=2)
                throw except(errs[2]);
            else
                {
                this.r = r;
                this.c = c;
                this.init();
                }
            }
        private void init()
            {
            Ariphmetical i,j;
            ExtArray<Ariphmetical> ro;
            i = N;
            cells = new ExtArray<>(r);
            while(Ariphmetical.cmp(i,r)!=3)
                {
                j = N;
                cells.set(i, ro=new ExtArray<>(c) );
                i = Ariphmetical.sum(E, i);
                while(Ariphmetical.cmp(j,c)!=3)
                    {
                    ro.set(j, N);
                    j = Ariphmetical.sum(E, j);
                    }
                }
            }
        public Matrix(Ariphmetical r, Ariphmetical c)
            {
            try
               {
                   this.init(r,c);
               }
            catch(ExtJavaLibBaseException e)
                {
                throw ((ExtJavaLibBaseException)e.fillInStackTrace());
                }
            }
        public Matrix(Ariphmetical rc)
            {
            try
               {
                   this.init(rc,rc);
               }
            catch(ExtJavaLibBaseException e)
                {
                throw ((ExtJavaLibBaseException)e.fillInStackTrace());
                }
            }
        public Matrix()
            {
            this.init(baseR,baseC);
            }
        
        public Matrix(Matrix qwe)
            {
            if(qwe==null)
                throw except("Null argument is forbidden.");
            Ariphmetical[] rc = qwe.shape();
            Ariphmetical i,j,E=Ariphmetical.E8,c;
            this.init(i=rc[0], c=rc[1]);
            while(true)
                {
                i = Ariphmetical.sub(i,E);
                j = c;
                ExtArray<Ariphmetical> row = this.cells.get(i);
                while(true)
                    {
                    j = Ariphmetical.sub(j,E);
                    row.set(j, qwe.get(i,j));
                    if(j.zero()) break;
                    }
                if(i.zero()) break;
                }
            }
        
        public Matrix castT()
            {
            Matrix m = this.clone();
            Ariphmetical[] rc = m.shape();
            Ariphmetical i,j,c,E;
            E = Ariphmetical.E8;
            i = rc[0];
            c = rc[1];
            while(true)
                {
                i = Ariphmetical.sub(i,E);
                j = c;
                while(true)
                    {
                    j = Ariphmetical.sub(j,E);
                    Ariphmetical a =m.get(i, j);
                    int alpha = a.type();
                    if(alpha<8||alpha>10)
                        {
                        if(alpha<6)
                            (a = a.cast(9)).simp();
                        else
                        if(alpha<8)
                            (a = a.cast(10)).simp();
                        ////////////////////////
                        m.set(i,j,a);
                        ////////////////////////
                        }
                    if(j.zero()) break;
                    }
                if(i.zero()) break;
                }
            return m;
            }
        
        @Override
        public Matrix clone()
            {
            return new Matrix(this);
            }
        
        public Ariphmetical[] shape()
            {
            return new Ariphmetical[]{r,c};
            }
        
        public void set(Ariphmetical i, Ariphmetical j, Ariphmetical a)
            {
            ExtArray<Ariphmetical> qwe=null;
            try
                {
                qwe=this.cells.get(i);
                qwe.set(j, a);
                }
            catch(ExtJavaLibBaseException e)
                {
                String ans=e.getMessage();
                if(e.getI()==5)
                    ans=ans+" The shape is ("+
                            r.toString()+","+c.toString()
                            +").";
                e = null;
                throw ((ExtJavaLibBaseException)except(ans).fillInStackTrace());
                }
            }
        
        public Ariphmetical get(Ariphmetical i, Ariphmetical j)
            {
            ExtArray<Ariphmetical> qwe=null;
            try
                {
                qwe=this.cells.get(i);
                return qwe.get(j);
                }
            catch(ExtJavaLibBaseException e)
                {
                String ans=e.getMessage();
                if(e.getI()==5)
                    ans=ans+" The shape is ("+
                            r.toString()+","+c.toString()
                            +").";
                e = null;
                throw ((ExtJavaLibBaseException)except(ans).fillInStackTrace());
                }
            }
        /*
        public Matrix
        
        public Ariphmetical det()
            {
            Ariphmetical i,j,N;
            }
        
        */
        
        
        
        }///////////////qweqweqwe
    
    
}
