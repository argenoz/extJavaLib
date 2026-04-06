package extJavaLib.extStructLib;

        

import extJavaLib.extNumLib.Ariphmetical;

import extJavaLib.extStringLib.ExtString;
import extJavaLib.extJavaLibExceptions.ExtJavaLibExceptions.ExtJavaLibBaseException;
import extJavaLib.extStructLib.BaseExtStructs.ExtList;
import extJavaLib.extStructLib.BaseExtStructs.ExtStack;
import extJavaLib.extStructLib.BaseExtStructs.ExtTuple;
import extJavaLib.extStructLib.BaseExtStructs.ExtPair;
import extJavaLib.extStructLib.BaseExtStructs.ExtTrine;
public class EJLLogicalStructs
{
    private static final String[] errs;
        static
        {
        errs = new String[5];
        errs[0] = "Null argument.";
        errs[1] = "Subtype of Ariphmetical is not 8 or 9.";
        errs[2] = "First argument is null.";
        errs[3] = "Second argument is null.";
        }
    
    private static ExtJavaLibBaseException getExcpt(String s)
        {
        return new ExtJavaLibBaseException(s);
        }
    
    private static ExtJavaLibBaseException getExcpt(int i)
        {
        if(i<0 || i>= errs.length)
            return getExcpt(errs[i]);
        else
            throw getExcpt("Out of bounds of messages");
        }
    
    
    
    /**
     * realization of JSON in ExtJavaLib
     * EJLJSON has subtypes classes (EJLJSON_sybtypes_classes):
     * 0 - literal(bool or null);
     *      8 - null
     *      9 - true
     *      10 - false
     * 1 - EJLJSON_Number, Ariphmetical (8) @link extJavaLib.extNumLib.Ariphmetical;
     * 2 - EJLJSON_String, ExtString;
     * 3 - EJLJSON_List, ExtList;
     * 4 - EJLJSON_Dict, type of an inner class of this class;
     * 5 - EJLJSON_Array, ExtTuple;
     */
    public static class EJLJSON
        {
        
       
        
        private static final Workable pushnuum;
        static
            {
            pushnuum = new Workable()
                                {
                                public ExtPair<Character,ExtPair<Object,Object>> newPart(Character i,Object a, Object b)
                                    {
                                    ExtPair<Character,ExtPair<Object,Object>> ans = new ExtPair<Character,ExtPair<Object,Object>>();
                                    ans.first(i);
                                    ExtPair<Object,Object> vsp = ans.second();
                                    vsp.first(a);
                                    vsp.second(b);
                                    return ans;
                                    }
                                public ExtStack<ExtPair<Character,ExtPair<Object,Object>>> push(ExtStack<ExtPair<Character,ExtPair<Object,Object>>>s,Character i, Object a, Object b)
                                    {
                                    s.push(newPart(i,a,b));
                                    return s;
                                    }
                                };
            
            }
        
        public static boolean cmp(EJLJSON a, EJLJSON b)
            {
            int ai,bi;
            boolean ans = false;
            ExtStack<ExtPair<Character,ExtPair<Object,Object>>> st;
                        // Integer has bitwise flags.
                        // if Integer is null, than its time for us to getsubtypes
                        // of 
            Workable f = pushnuum;
            if(a==null)
                throw getExcpt(2);
            if(b==null)
                throw getExcpt(3);
            
            
            ETTO:
            {
            ai = a.getType();
            bi = b.getType();
            if(ai!=bi)
                break ETTO;
                if(ai<3)
                    {
                    switch(ai)
                        {
                        case 0:
                            {
                            ans = (
                            ((EJLJSON_Literal)a.main).subtype()
                                    ==
                            ((EJLJSON_Literal)b.main).subtype()
                                    );
                            break;
                            }
                        case 1:
                            {
                            ans=(
            Ariphmetical.cmp(
                ((EJLJSON_Number)a.main).getValue()
                    ,
                ((EJLJSON_Number)b.main).getValue()
            )
            ==
            3);
                            break;
                            }
                        case 2:
                            {
                            ans=(
            ExtString.cmp(
                ((EJLJSON_String)a.main).getValue()
                    ,
                ((EJLJSON_String)b.main).getValue()
            )
            ==
            3);
                            break;
                            }
                        }//end of quick end's switch
                    
                    break ETTO;
                    }//end of quick end
                
            }
            
            return ans;
            }
        
        private typeGiver main;
        
        
        public EJLJSON()
                {
                this.main = null;
                }
        
        public int getType()
            {
            return this.main.type();
            }
        
        ///////////////////////////////// subclasses
                private static class typeGiver
                    {
                    public int type(){return -1;}
                    }
                
                private static class EJLJSON_Literal extends typeGiver
                    {
                        private int lit;
                        @Override
                        public int type()
                            {
                            return 0;
                            }
                        public int subtype()
                            {
                            return lit;
                            }
                        public EJLJSON_Literal()
                            {
                            lit = 8;
                            }
                        public EJLJSON_Literal(Object t)
                            {
                            if(t==null)
                                lit = 8;
                            else
                                if(t instanceof Boolean)
                                    lit = ((Boolean)t)?9:10;
                                else
                                    throw getExcpt("Bad type of Object argument.");
                            }
                        
                        public EJLJSON_Literal(Boolean t)
                            {
                                if(t==null)
                                lit = 8;
                                else
                                    lit = t?9:10;
                            }
                        
                        private Boolean giveBool()
                            {
                            if(lit!=8)
                            return (lit==9);
                            else
                                throw getExcpt("Bad subtype of EJLJSON_Literal(not boolean).");
                            }
                        
                    }
                
                private static class EJLJSON_Number extends typeGiver 
                    {
                        private final Ariphmetical a;
                        @Override
                        public int type()
                            {
                            return 1;
                            }
                        
                        public EJLJSON_Number()
                            {
                            a = Ariphmetical.E8;
                            }
                        
                        public EJLJSON_Number(Ariphmetical ar)
                            {
                            if(ar==null)
                                throw getExcpt(0);
                            else
                                {
                                    int i = ar.type();
                                    if(i<8 || i>9)
                                        throw getExcpt("Subtype of Ariphmetical is not 8 or 9.");
                                }
                            a = ar.clone();
                            }
                        
                        public EJLJSON_Number(EJLJSON_Number ar)
                            {
                                if(ar==null)
                                    throw getExcpt(0);
                                else
                                    a = ar.getValue();
                            }
                        
                        @Override
                        public EJLJSON_Number clone()
                            {
                            return new EJLJSON_Number(this);
                            }
                        
                        public Ariphmetical getValue()
                            {
                            return this.a.clone();
                            }
                        
                        public boolean equals(EJLJSON_Number ar)
                            {
                            if(ar!=null)
                                return (3==Ariphmetical.cmp(this.a, ar.getValue()));
                            else
                                throw getExcpt(0);
                            }
                        
                        @Override
                        public boolean equals(Object ar)
                            {
                            if(ar==null)
                                throw getExcpt(0);
                            else
                            if(ar instanceof EJLJSON_Number)
                                return equals((EJLJSON_Number) ar);
                            else
                                return false;
                            }
                        
                        @Override
                        public String toString()
                            {
                            return this.a.toString();
                            }
                        
                        
                        
                    } // end of EJLJSON_Number 
                
                private static class EJLJSON_String extends typeGiver
                    {
                        private final ExtString s;
                        public int type()
                            {
                            return 2;
                            }
                        
                        public EJLJSON_String()
                            {
                            s = new ExtString();
                            }
                        
                        
                        public EJLJSON_String(ExtString st)
                            {
                                if(st == null)
                                    throw getExcpt(0);
                                s = new ExtString(st);
                            }
                        
                        public EJLJSON_String(EJLJSON_String st)
                            {
                                if(st == null)
                                    throw getExcpt(0);
                                s = st.getValue();
                            }
                        
                        
                        
                        public ExtString getValue()
                            {
                            return new ExtString(this.s);
                            }
                        
                        
                        public EJLJSON_String clone()
                            {
                            return new EJLJSON_String(this);
                            }
                        
                    
                    }//end of EJLJSON_String
                
                private static class EJLJSON_list extends typeGiver
                    {
                        
                        private  final ExtList_for_EJLJSON_list_and_dict<EJLJSON> l=
                                new ExtList_for_EJLJSON_list_and_dict<EJLJSON>(); 
                        @Override
                        public int type(){return 3;}
                        
                        public EJLJSON_list()
                            {
                            
                            }
                        
                        public Ariphmetical len()
                            {
                            return this.l.len();
                            }
                        
                        public void pushBack(EJLJSON q)
                            {
                            if(q!=null)
                            this.l.pushBack(q);
                            else throw getExcpt(0);
                            }
                        
                         public void pushFront(EJLJSON q)
                            {
                            if(q!=null)
                            this.l.pushFront(q);
                            else throw getExcpt(0);
                            }
                        
                        public EJLJSON popFront()
                            {
                            if(this.len().zero())
                                throw getExcpt("EJLJSON_list is empty");
                            else
                                return this.l.popFront();
                            }
                        
                        public EJLJSON popBack()
                            {
                            if(this.len().zero())
                                throw getExcpt("EJLJSON_list is empty");
                            else
                                return this.l.popBack();
                            }
                        
                        public EJLJSON get(Ariphmetical i)
                            {
                            try
                                {
                                    return this.l.get(i);
                                }
                            catch(extJavaLib.extJavaLibExceptions.ExtJavaLibExceptions.ExtJavaLibBaseException e)
                                {
                                    throw getExcpt(e.getMessage());
                                }
                            }
                        public void set(EJLJSON j,Ariphmetical i)
                            {
                            try
                                {
                                     this.l.set(i,j);
                                }
                            catch(extJavaLib.extJavaLibExceptions.ExtJavaLibExceptions.ExtJavaLibBaseException e)
                                {
                                    throw getExcpt(e.getMessage());
                                }
                            }
                        
                        
                        public Object[] getHT()
                            {
                            return this.l.getHT();
                            }
                    }// end of EJLJSON_list
                    
                
                public static class EJLJSON_dict extends typeGiver
                    {
                    public final ExtList_for_EJLJSON_list_and_dict<ExtPair<EJLJSON,EJLJSON>> l
                            = new ExtList_for_EJLJSON_list_and_dict();
                    @Override
                    public int type(){return 4;}
                    public EJLJSON_dict(){}
                    public Object[] getHT()
                            {
                            return this.l.getHT();
                            }
                    
                    }// end of EJLJSON_dict
                
                
                private static final class ExtList_for_EJLJSON_list_and_dict<T> extends ExtList<T>
                            {
                            public Object[] getHT()
                                {
                                Object[] ans = new Object[2];
                                ans[0] = this.dh;
                                ans[1] = this.dt;
                                return ans;
                                }
                            
                            }//end of ExtList_for_EJLJSON_list_and_dict
                    
                
       
        private static interface Workable
            {
            //public Object work(Object o);
            }
        
        }//end of EJLJSON
}
