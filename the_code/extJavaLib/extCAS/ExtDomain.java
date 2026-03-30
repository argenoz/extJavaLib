package extJavaLib.extCAS;

public class ExtDomain<T>
{
    public  interface Operation<T>
        {
        public T calculate();
        }
    
    
    public class Operand
        {
        private T o;
        public Operand(){this.o=null;}
        
        }
    
}
