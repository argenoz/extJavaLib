package extJavaLib.Interfaces;


        
        
        
public class Basics 
{
    public static interface Based<byT extends Basing>
        {
        public boolean ifEquiv(Based<byT> a);
        public byT getBase();
        
        }
    
    public static interface Basing<theT extends Based>
        {
        public boolean cmp(theT a, theT b);
        public boolean ifPart(theT a);
        }
    
    
}
