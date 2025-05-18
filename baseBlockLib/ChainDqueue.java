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
public class ChainDqueue<T> extends Block<T>
{
/**
 * n and b is "next" and "before". Or next or previous
 */
protected ChainDqueue<T> n,b;
/**
 * Base constructor for ChainDqueue
 */
public ChainDqueue(){super(); this.n=null; this.b=null;}
/**
 * It gives next ChainDqueue object
 * @return 
 */
public ChainDqueue<T>next(){return this.n;}
/**
 * It gives previous ChainDqueue object
 * @return 
 */
public ChainDqueue<T>before(){return this.b;}
/**
 * It sets next ChainDqueue object
 * @return 
 */
public ChainDqueue<T> next(ChainDqueue<T>n){this.n=n; return this.n;}
/**
 * It sets previous ChainDqueue object
 * @return 
 */
public ChainDqueue<T> before(ChainDqueue<T>b){this.b=b;return this.b;}
}
