package extJavaLib.baseBlockLib;


/**
 The general class in argenizLib
	Block has three and no more that three missions:
       1) to be
	2) to have a link to something of T Class
 	3) to give a link to something of T Class
        It contains something pointer.

@version 1.0	
*/
public class Block<T>
{
/**
 * pointer of T element
 */
protected T a;
/**
 * Base constructor
 */
public Block(){this.a=null; }

/**
 * Getter
 * @return 
 */
public T get(){return this.a;}

/**
 * Setter
 *  
 */
public void set(T w){this.a=w;}

/**
 * Alternate version of getter.
 * @return a
 */
public T first(){return this.a;}
/**
 * Alternate version of setter.
 * @param w 
 */
public void first(T w){this.a=w;}

/**
 * return  returns 0 if a is null, else it returns 1.
 * @return  
 */
public int nutshell()
	{
	int i=0;
	if(this.a!=null) i=1;
	return i;
	}
}
