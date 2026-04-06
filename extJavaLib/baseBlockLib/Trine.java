package extJavaLib.baseBlockLib;

import extJavaLib.baseBlockLib.Pair;

/**
 * 
 * Ordered Trine.
 * @link extJavaLib.baseBlockLib.Pair
 * @param <T1>
 * @param <T2>
 * @param <T3> 
 */
public class Trine<T1,T2,T3> extends Pair<T1,T2>
{

	protected T3 c;
	public Trine(){super();this.c=null;}
	
	public void third(T3 c) {this.c=c;}
	public T3 third(){return this.c;}
@Override
	public int nutshell()
	{
	int otvet=0;
	if(this.c!=null)
		otvet=4;
	return (otvet|super.nutshell());
	}
@Override
	public  boolean ifEmpty()
	{return this.nutshell()==0;}
	
	

}


