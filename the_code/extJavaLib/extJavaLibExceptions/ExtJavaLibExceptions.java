

package extJavaLib.extJavaLibExceptions;
import extJavaLib.extNumLib.ExtNum;
import java.lang.Exception;

public class ExtJavaLibExceptions
{

    public static class AriphmeticalException extends EJLBE
    {
        public AriphmeticalException(){super();}
        public AriphmeticalException(String e){super(e);}
        
    }
    
    
    
    
    
public static class ExtJavaLibNatException extends EJLBE
{
    public ExtJavaLibNatException()
    {
    super();
    this.error="Beda!";
    }
}

public static class ExtJavaLibBaseException extends RuntimeException//Exception
{
	protected String error;
        protected int n;
        protected long err_c;
        @Override
        public String getMessage()
            {
            return new String(this.error);
            }
        @Override
        public String toString()
            {
            return new String(this.getMessage());
            }
	public ExtJavaLibBaseException()
	{
	this.error=null;
	}
        public ExtJavaLibBaseException(String w)
	{
        this();
        this.n=-1;
        if(w!=null)
	this.error=new String(w);
	}
        public ExtJavaLibBaseException(String w,int n)
        {
        this(w);
        this.n=n;
        }
	public String getString(){
	if(this.error==null) return null;
	else return new String(this.error);
	}
        
        public int getI(){return this.n;}

	public void print()
	{
	if(this.error!=null)
		System.out.print(this.error+"\n");
	else System.out.print("NULL Exception\n");
	}

}

public static class ExtCASLibExceptions{
public static class ExtCASLibException extends EJLBE
    {
    public ExtCASLibException(){super();}
    public ExtCASLibException(String w){super(w);}
    public ExtCASLibException(String w, int nn){super(w); this.n=nn;}
    }



}



public static class NullArgumentException extends ExtJavaLibBaseException
	{
	public NullArgumentException(String w)
		{
		this.error=new String(w);
		}
	}


public static class ExtNumLibExceptions
	{
        
        public static class ExtNumLibException extends ExtJavaLibBaseException
                {
                public ExtNumLibException(String i)
                        {
                        super(i);
                        }
                
                public ExtNumLibException(String s, int i)
                        {
                        super(s,i);
                        }
                
                public ExtNumLibException()
                        {
                        this.error="";
                        this.n=0;
                        }
                }
        
        public static class ExtNumNullPointerException extends ExtJavaLibBaseException
			{
			public ExtNumNullPointerException()
				{
				this.error="Null value pointer for ExtNum";
				}
			}
	}





public static class ExtStructLibExceptions{
/*
 *For vectors ans lists
 *
 *
 */
    public static class ExtArrayException extends EJLBE
        {
        public ExtArrayException(){super();}
        public ExtArrayException(String w){super(w);}
        public ExtArrayException(String w, int n){super(w,n);}
        }
    public static class ExtStackException extends EJLBE
        {
        public ExtStackException(){super();}
        public ExtStackException(String w){super(w);}
        public ExtStackException(String w, int n){super(w,n);}
        }
    public static class ExtVectorException extends EJLBE
        {
        public ExtVectorException(){super();}
        public ExtVectorException(String w){super(w);}
        public ExtVectorException(String w, int n){super(w,n);}
        }
    public static class LogicalStructsExceptions
            {
            public static class ExtJSONException extends EJLBE
                        {
                        public ExtJSONException(){super();}
                        public ExtJSONException(String w){super(w);}
                        public ExtJSONException(String w, int n){super(w,n);}
                        public ExtJSONException(ExtArrayException e)
                                    {
                                    super(e.toString(),e.getI());
                                    }
                        }
            }
}//end of ExtStructLibExceptions


public static class ExtStringExceptions
		{
		public static class NullStringFoundException extends ExtJavaLibBaseException
				{
				public NullStringFoundException()
					{
					this.error="Null String ref is found."
					;}
				}
		public static class NullExtStringException extends ExtJavaLibBaseException
				{
				public NullExtStringException()
					{
					this.error=new String("Null ExtString ref.");
					}
				}
		}//end of ExtStringExceptions

public static class LogicalStructsExceptions
		{
		public static class ExtTagLibExceptions
			{
                        
                        public static class NoPropsException extends EJLBE
                            {
                            NoPropsException()
                            {
                            this.error="This ExtTag hos no property.";
                            }
                            }
			public static class NoExtTagParentException extends ExtJavaLibBaseException
				{
				public NoExtTagParentException()
					{
					this.error="This ExtTag object has no parent.";
					} 
				}
			public static class NoExtTagChildrenFoundException extends EJLBE
					{
					public NoExtTagChildrenFoundException(){
					this.error="This ExtTag object has no child.";
                                                                                }
					}
			public static class ExtTagPropNotFoundException extends EJLBE
					{
					public ExtTagPropNotFoundException(){
					this.error="This ExtTag object has no property.";
										}
					}
			public static class PropIsNotDefinedException extends EJLBE
					{
					public PropIsNotDefinedException(String w)
						{
						this.error=new String(w);
                                                this.error="Property named of \""+this.error+"\" is not defined.";
						}
					}
			}//end of ExtTagLibExceptions
		}

}

class EJLBE extends ExtJavaLibExceptions.ExtJavaLibBaseException
	{
	public EJLBE(){}
        public EJLBE(String s){super(s);}
        public EJLBE(String s, int n){super(s,n);}
	}

