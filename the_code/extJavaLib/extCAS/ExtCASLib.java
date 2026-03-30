package extJavaLib.extCAS;

        
        
        
import extJavaLib.extStringLib.ExtString;
import extJavaLib.extJavaLibExceptions.ExtJavaLibExceptions.ExtJavaLibBaseException;

import extJavaLib.extNumLib.Ariphmetical;


import extJavaLib.extStructLib.BaseExtStructs.*;
import extJavaLib.baseBlockLib.ChainStack;
import extJavaLib.baseBlockLib.Trine;


import extJavaLib.Interfaces.Basics.*;

public class ExtCASLib
{
    private static final String[] errs;
    static
        {
        String[] tmp = new String[10];
        tmp[0] = "Argument is null.";
        tmp[1] = "Empty ExtString.";
        tmp[2] = "There are two inunique symbols.";
        
        errs=tmp;
        }
    private static ExtJavaLibBaseException excpt(int i)
        {
        return excpt(errs[i]);
        }
    private static ExtJavaLibBaseException excpt(String s){return new ExtJavaLibBaseException(s);}
    public static final class ExtCASSym
        {
        private ExtString s;
        
        public ExtCASSym(){this.s=new ExtString();}
        public ExtCASSym(ExtString st)
            {
            if(st==null)
                throw excpt(0);
            s = new ExtString(st);
            }
        public ExtCASSym(String st)
            {
            if(st==null)
                throw excpt(0);
            s = new ExtString(st);
            }
        public ExtCASSym(char st)
            {
            char[] tmp = new char[1];
            tmp[0]=st;
            s = new ExtString(new String(tmp));
            }
        public ExtString toExtString()
            {
            return new ExtString(this.s);
            }
        public String toString()
            {
            return this.s.toString();
            }
        
        public boolean equivs(ExtCASSym a)
            {
            if(a==null)
                throw excpt(0);
            if(a==this)
                return true;
            else
            return (ExtString.cmp(a.toExtString(),this.s)==3);
            }
        }
    
    public static final class CayleyTable<T extends Basing>
        {
            
            
        }
    
    
}
