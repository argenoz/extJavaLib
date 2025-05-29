package extJavaLib.baseBlockLib;
import extJavaLib.baseBlockLib.Block;

/**
 base class for Dqueue. It has contains 3 fields:
 *              1) n - next ChainDqueue object pointer.
 *              2) b - previous ChainDqueue object pointer.
 *              3) a - the pointer of parametric T object.
 * 
 * @param <T> 
 */
public class ChainStack<T> //extends Block <T>
{
    private T t;
    public T get(){return this.t;}
    public void set(T tt){this.t=tt;}
 /**
 * n is "next".
 */
protected ChainStack<T> n;
/**
 * Base constructor for ChainStack
 */
public ChainStack(){super();this.n=null;}
/**
 * It gives next ChainDqueue object
 * @return 
 */
public ChainStack<T> next(){return this.n;}
/**
 * It sets next ChainDqueue object
 * @return 
 */
public ChainStack<T>next(ChainStack<T>n){this.n=n;return this.n;}

//public T get(return this.t);

}

