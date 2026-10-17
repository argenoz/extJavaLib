package extJavaLib.extNumLib;

        
import extJavaLib.extJavaLibExceptions.ExtJavaLibExceptions.ExtJavaLibBaseException;


import extJavaLib.extStructLib.BaseExtStructs.ExtArray;

public class EJLSuppClass {
    private static final String[] ERRS;
    static
        {
        ERRS = new String[5];
        ERRS[0] = "Null argument is forbidden.";
        ERRS[1] = "Bad subtype of dimentional argument.";
        }
    private static ExtJavaLibBaseException except(String s)
        {
        return new ExtJavaLibBaseException(s);
        }
    
    public static class EJLLinearAgebra
    {
        
        public static boolean sameMatrixDomain(EJLMatrixRing a,EJLMatrixRing b)
            {
            if(a==null || b == null)
                throw except(ERRS[0]);
            
            if(a==b)
                return true;
            else
            {
            Ariphmetical[]
                    rc1 = a.getRC(),
                    rc2 = b.getRC();
            return (
                    (Ariphmetical.cmp(rc1[0], rc2[0])==3)
                    &&
            (Ariphmetical.cmp(rc1[1], rc2[1])==3)
                    );
            }
            }
        
        public static class EJLMatrixRing
            {
            private static final Ariphmetical Default_R,Default_C,N,E;
            static
                {
                Default_C=Default_R = new Ariphmetical(10);
                E = Ariphmetical.E8;
                N = Ariphmetical.N8;
                }
            private Ariphmetical R,C;
            private void set(Ariphmetical r,Ariphmetical c)
                {
                if(r == null || c==null)
                    throw except(ERRS[0]);
                if(r.type()!=8 && c.type()!=8)
                    throw except(ERRS[1]);
                R = new Ariphmetical(r);
                C = new Ariphmetical(c);
                }
            
            public EJLMatrixRing(Ariphmetical r,Ariphmetical c)
                {
                try
                    {
                        this.set(r,c);
                    }
                catch(ExtJavaLibBaseException e)
                    {
                        throw e;
                    }
                }
            public EJLMatrixRing(Ariphmetical rc)
                {
                try
                    {
                        this.set(rc,rc);
                    }
                catch(ExtJavaLibBaseException e)
                    {
                        throw e;
                    }
                }
            public EJLMatrixRing()
                {
                try
                    {
                        this.set(Default_R,Default_C);
                    }
                catch(ExtJavaLibBaseException e)
                    {
                        throw e;
                    }
                }
            
            public  Ariphmetical[] getRC()
                {
                Ariphmetical[] ans = new Ariphmetical[2];
                ans[0] = R;
                ans[1] = C;
                return ans;
                }
            
            
            public boolean ifTheSame(EJLMatrixRing q)
                {
                try{
                return EJLLinearAgebra.sameMatrixDomain(this, q);
                }
                catch(ExtJavaLibBaseException e)
                    {
                        throw e;
                    }
                }
            
            
            public  class EJLMatrix 
                {
                    
                    public EJLMatrixRing getDomain()
                        {
                        return EJLMatrixRing.this;
                        }
                    private final 
                            ExtArray<ExtArray<Ariphmetical>> members;
                    public EJLMatrix()
                        {
                            Ariphmetical i;
                            members = new ExtArray<>(i=R);
                            do
                                {
                                    i = Ariphmetical.sub(i,E);
                                    Ariphmetical j = C;
                                    ExtArray<Ariphmetical> row =
                                            new ExtArray<Ariphmetical>(j);
                                    members.set(i, row);
                                    do
                                        {
                                            j = Ariphmetical.sub(j,E);
                                            row.set(j, N);
                                            if(j.zero()) break;
                                            continue;
                                        }
                                    while(true);
                                    if(i.zero()) break;
                                    continue;
                                }
                            while(true);
                        }
                    
                }
            }
    }

    
}
