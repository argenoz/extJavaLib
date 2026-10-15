
package extJavaLib.extNumLib;

import extJavaLib.extJavaLibExceptions.ExtJavaLibExceptions.ExtJavaLibBaseException;
        


import extJavaLib.extStructLib.BaseExtStructs.ExtArray;


public class EJLLinearAlgebra {
    
    private static ExtJavaLibBaseException except(String st)
    {
    return new ExtJavaLibBaseException(st);
    }
    
    
    
    public static class EJLMatrix
        {
            public static final Ariphmetical default_C,default_R;
            static
                {
                default_R=default_C = (new Ariphmetical(10)).cast(8);
                }
            
            private final Ariphmetical C,R;
            private ExtArray<ExtArray<Ariphmetical>> cells;
            public Ariphmetical[] get_RC()
                {
                Ariphmetical[] ans = new Ariphmetical[2];
                ans[0] = this.R;
                ans[1] = this.C;
                return ans;
                }
            public Ariphmetical get_R()
                {
                return this.R;
                }
            public Ariphmetical get_C()
                {
                return this.C;
                }
            
            private void set()
                {
                Ariphmetical i = this.R,
                        E = Ariphmetical.E8,
                        N = Ariphmetical.N8,j;
                cells = new ExtArray<ExtArray<Ariphmetical>>(i);
                do
                    {
                     i = Ariphmetical.sub(i, E);
                     j = this.C;
                    ExtArray<Ariphmetical> row = new ExtArray<Ariphmetical>(j);
                    cells.set(i, row);
                    do
                    {
                        j = Ariphmetical.sub(j,E);
                        row.set(j,N);
                        if(j.zero()) break;
                        continue;
                    }
                    while(true);
                    if(i.zero()) break;
                    continue;
                    }
                while(true);
                
                }
            
            public Ariphmetical get(Ariphmetical i, Ariphmetical j)
                {
                if(j==null || i == null)
                    throw except("Null argument is forbidden.");
                try
                    {
                    return this.cells.get(i).get(j);
                    }
                catch(ExtJavaLibBaseException e)
                    {
                        throw except(e.getMessage());
                    }
                
                }
            
            public void set(Ariphmetical i, Ariphmetical j, Ariphmetical a)
                {
                if(j==null || i == null || a == null)
                    throw except("Null argument is forbidden.");
                try
                    {
                    this.cells.get(i).set(j,a);
                    }
                catch(ExtJavaLibBaseException e)
                    {
                        throw except(e.getMessage());
                    }
                }
            
            
            
            
            public EJLMatrix(Ariphmetical RC)
               {
               if(RC==null)
                    throw except("null argument is forbidden.");
               if(RC.type()!=8)
                   throw except("Bad sybtype of arguments.");
               C = R = RC;
               this.set();
               }
            
            public EJLMatrix(Ariphmetical R, Ariphmetical C)
                {
                if(R == null || C == null)
                    throw except("null argument is forbidden.");
                if(R.type()!=8 || C.type()!=8)
                    throw except("Bad sybtype of arguments.");
                this.R = R;
                this.C = C;
                this.set();
                }
            
            public EJLMatrix()
                {
                this.C = default_C;
                this.R = default_R;
                this.set();
                }
            
            
        }
}
