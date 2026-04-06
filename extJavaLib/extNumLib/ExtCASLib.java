package extJavaLib.extNumLib;

        
        
        
import extJavaLib.extStringLib.ExtString;
import extJavaLib.extNumLib.Ariphmetical;
import extJavaLib.extJavaLibExceptions.ExtJavaLibExceptions.ExtJavaLibBaseException;
import java.lang.Cloneable;
import java.lang.Comparable;
        
public class ExtCASLib
{
    public static final class ExtCASSym
        {
            private static ExtJavaLibBaseException excpt(String s){return new ExtJavaLibBaseException(s);}
            private ExtString s;
            ExtCASSym(){this.s=null; throw  excpt("must be an argument in constructor");}
            public ExtCASSym(ExtString ss){if(ss==null){this.s=null; throw  excpt("must be an argument in constructor");} else this.s=new ExtString(ss);}
            public ExtCASSym(ExtCASSym a)
                {
                if(a==null)
                    {
                    this.s=null;
                    throw  excpt("Null argument is forbidden.");
                    }
                else
                    this.s=a.toExtString();
                }
            @Override
            public String toString(){return this.s.toString();}
            public ExtString toExtString(){return new ExtString(this.s);}
            @Override
            public ExtCASSym clone(){return new ExtCASSym(this.toExtString());}
            public static int cmp(ExtCASSym a, ExtCASSym b)
                {
                if(a!=null && b!=null)
                return ExtString.cmp(a.toExtString(), b.toExtString());
                else
                throw excpt("One of arguments is null pointer.");
                }
            public boolean ifEquiv(ExtCASSym a)
                {
                boolean ans = false;
                try
                    {
                    ans = (cmp(this,a)==3);
                    }
                catch(ExtJavaLibBaseException e)
                    {
                    throw excpt("Argument is null.");
                    }
                return ans;
                }
            
            
            
            
        }
}
