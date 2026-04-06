package extJavaLib.baseBlockLib;
import extJavaLib.baseBlockLib.Block;


/**
 * 
 * It is ordered Pair.
 * @param <A>
 * @param <B> 
 */
public class Pair<A,B> extends Block<A>
{
/**
 * Second pair element.
 */
protected B b;
/**
 * Base constructor
 */
public Pair(){super();this.b=null;}
/**
 * It returns int number. 
 * If first element of the pair is null, first bit is 0. Else first bit is 1.
 * If second element of the pair is null, second bit is 0. Else second bit is 1.
 * @return int
 */
public int nutshell() 
{
int otvet=0;
otvet=super.nutshell();

if(this.b!=null)
	otvet=(otvet|2);
		
return otvet;
}

/**
 getter for first element 
 */
@Override
public A first(){return this.a;}

/**
 getter for second element 
 */
public B second() {return this.b;}

/**
 setter for first element 
 */
public void first(A a) {this.a=a;}

/**
 setter for second element 
 */
public void second(B b) {this.b=b;}

/**
 * set pair to (null,null)
 */
public void setEmpty(){this.a=null; this.b=null;}

/**
 * if a and b null it returns true. Else it returns false.
 * @return 
 */
public boolean ifEmpty(){return this.nutshell()==0;}

}
