package extJavaLib.extNumLib;


import extJavaLib.baseBlockLib.Pair;
        
import extJavaLib.extNumLib.ariph.ExtInteger.ExtChar;
import extJavaLib.extNumLib.ExtNum;
import extJavaLib.extNumLib.ExtNumCalc;
import extJavaLib.extNumLib.ariph.*;
import extJavaLib.extJavaLibExceptions.ExtJavaLibExceptions.AriphmeticalException;



public final class Ariphmetical {
    private Byte B;//1
    private Short S;//3
    private ExtChar C;//2
    private Integer I;//4
    private Long L;//5
    private Float F;//6
    private Double D;//7
    private ExtNum EN;//8 - unsigned int
                        // 9 - signed int
                        // 10 -- racio

    
    
    public static final Ariphmetical N=new Ariphmetical((byte)0),E=new Ariphmetical((byte)1);
    
    private void nullify()
    {
    this.EN=null;
    this.D=null;
    this.F=null;
    this.L=null;
    this.I=null;
    this.C=null;
    this.S=null;
    this.C=null;
    this.B=null;

    }
    
    public Ariphmetical()
                    {
                    this.nullify();
                    this.B=new Byte((byte)0);
                    }
    
    public Ariphmetical(byte a)
    {
    this.nullify();
    this.B=new Byte(a);
    }
    
    
    public Ariphmetical(char a)
    {
    this.nullify();
    this.C=new ExtChar(a);
    }
    
    public Ariphmetical(short a)
    {
    this.nullify();
    this.S=new Short(a);
    }
    
    public Ariphmetical(int a)
    {
    this.nullify();
    this.I=new Integer(a);
    }
    
    public Ariphmetical(long a)
    {
    this.nullify();
    this.L=new Long(a);
    }
    
    public Ariphmetical(float a)
    {
    this.nullify();
    this.F=new Float(a);
    }
    
    public Ariphmetical(double a)
    {
    this.nullify();
    this.D=new Double(a);
    }
    
    
    public Ariphmetical(Byte a)
    {
    //this();
    //if(a!=null)
    this(a.byteValue());
    }
    
    
    
    
    public Ariphmetical(ExtChar a)
    {
    this(a.charValue());
    }
    
    public Ariphmetical(Short a)
    {
    this(a.shortValue());
    }
    
    
    public Ariphmetical(Integer a)
    {
    this(a.intValue());
    }
    
    public Ariphmetical(Float a)
    {
    this(a.floatValue());
    }
    
    public Ariphmetical(Double a)
    {
    this(a.doubleValue());
    }
    
    public Ariphmetical(ExtNum a)
    {
    this.nullify();
    this.EN=new ExtNum(a);
    }
    
    public Ariphmetical(byte a, byte b)
    {
    this(new ExtNum(new Racio((int)a,(int)b)));
    }
    
    public Ariphmetical(char a, char b)
    {
    this(new ExtNum(new Racio(a,b)));
    }
    
    public Ariphmetical(int a, int b)
    {
    this(new ExtNum(new Racio((int)a,(int)b)));
    }
    
    public Ariphmetical(long a, long b)
    {
    this(new ExtNum(new Racio(a,b)));
    }
    
    public Ariphmetical(int a, long b)
    {
    this(new ExtNum(new Racio(a,b)));
    }
    
    public Ariphmetical(long a, int b)
    {
    this(new ExtNum(new Racio(a,b)));
    }
    
    public Ariphmetical(Ariphmetical a)
    {
    //this.nullify();
    this();
    //if(a!=null)
        switch(a.type())
        {
            case 1:
                {
                    this.nullify();
                    this.B=a.toByte();
                    break;
                }
            case 2:
                {
                    this.nullify();
                    this.C=a.toExtChar();
                    break;
                }
            case 3:
                {
                    this.nullify();
                    this.S=a.toShort();
                    break;
                }
            case 4:
                {
                    this.nullify();
                    this.I=a.toInteger();
                    break;
                }
            case 5:
                {
                    this.nullify();
                    this.L=a.toLong();
                    break;
                }
            case 6:
                {
                    this.nullify();
                    this.F=a.toFloat();
                    break;
                }
            case 7:
                {
                    this.nullify();
                    this.D=a.toDouble();
                    break;
                }
            case 8: case 9: case 10:
                {
                this.nullify();
                this.EN=a.toExtNum();
                break;
                }
            default:
                {
                break;
                }
        }
    
    }
    
   
    
    public int type()
    {
    int ans=0;
    if(this.B!=null)
        ans=1;
    else if(this.C!=null)
        ans=2;
    else if(this.S!=null)
        ans=3;
    else if(this.I!=null)
            ans=4;
    else if(this.L!=null)
        ans=5;
    else if(this.F!=null)
        ans=6;
    else if(this.D!=null)
        ans=7;
    else
           if(this.EN!=null)
           ans=8+this.EN.type();
      /*     else
               if(FP!=null)
               ans=11;
    */
    //else ans=-1;
    return ans;
    }
    
    public int type_()
    {
    int ans=0;
    ans=this.type();
    if(ans!=0)
        ans=((1)<<(ans-1));
    return ans;
    }
    
    public String toString()
    {
    String ans=null;
    int vsp;
    switch(this.type())
    {
        case 2:
            {
            ans=this.C.toString();
            break;
            }
        case 1:
            {
            ans=this.B.toString();
            break;
            }
        case 3:
            {
            ans=this.S.toString();
            break;
            }
        case 4:
            {
            ans=this.I.toString();
            break;
            }
        case 5:
            {
            ans=this.L.toString();
            break;
            }
        case 6:
            {
            ans=this.F.toString();
            break;
            }
        case 7:
            {
            ans=this.D.toString();
            break;
            }
        case 8:case 9:case 10:
            {
            ans=this.EN.toString();
            break;
            }
        case -1:
            {
            ans=null;
            break;
            }
        default:
            {
            ans=new String();
            break;
            }
    
    
    }
    
    return ans;
    }
    
    public Byte toByte()
    {
    Byte ans=null;
    if(this.type()==1)
        ans=new Byte(this.B);
    else ans=this.cast(1).toByte();
    return ans;
    }
    
   
    
    
    
    public ExtChar toExtChar()
    {
    ExtChar ans=null;
    if(this.type()==2)
        ans=new ExtChar(this.C);
    else ans=this.cast(2).toExtChar();
    return ans;
    }
    
    public Short toShort()
    {
    Short ans=null;
    if(this.type()==3)
        ans=new Short(this.S);
    else ans=this.cast(3).toShort();
    return ans;
    }
    
    public Integer toInteger()
    {
    Integer ans=null;
    if(this.type()==4)
        ans=new Integer(this.I);
    else ans=this.cast(4).toInteger();
    return ans;
    }
    
    public Long toLong()
    {
    Long ans=null;
    if(this.type()==5)
        ans=new Long(this.L);
    else ans=this.cast(5).toLong();
    return ans;
    }
    
    public Float toFloat()
    {
    Float ans=null;
    if(this.type()==6)
        ans=new Float(this.F);
    else ans=this.cast(6).toFloat();
    return ans;
    }
    
    public Double toDouble()
    {
    Double ans=null;
    if(this.type()==7)
        ans=new Double(this.D);
    else ans=this.cast(7).toDouble();
    return ans;
    }
    
    public ExtNum toExtNum()
    {
    ExtNum ans=null;
    int t=this.type();
    //if(t>=8 && t<=10)
    if(t==8 || t==10||t==9)
                {
        ans=new ExtNum(this.EN);}
    else if(t==10)
         ans=this.cast(10).toExtNum();
    else if(t==9)
         ans=this.cast(9).toExtNum();
        else ans=this.cast(8).toExtNum();
    return ans;
    }
    
    public boolean zero()
    {
    boolean ans=false;
    //ans=(Ariphmetical.cmp(this, Ariphmetical.N)==3);
    
    switch(this.type())
        {
        case 1:
            {
            //ans=(this.toByte().byteValue()==0);
            ans = this.B==0;
            break;
            }
        case 2:
            {
            //ans=(this.toExtChar().charValue()==0);
            ans = (this.C.charValue()==0);
            break;
            }
        case 3:
            {
            //ans=(this.toShort().shortValue()==0);
            ans = this.S == 0;
            break;
            }
        case 4:
            {
            //ans=(this.toInteger().intValue()==0);
            ans = this.I==0;
            break;
            }
        case 5:
            {
            //ans=(this.toLong().longValue()==0);
            ans = this.L == 0;
            break;
            }
        case 6:
            {
            //ans=(this.toFloat().floatValue()==0);
            ans = this.F == 0;
            break;
            }
        case 7:
            {
            //ans=(this.toDouble().doubleValue()==0);
            ans = this.D==0;
            break;
            }
        case 8: case 9: case 10:
            {
            //ans=this.toExtNum().zero();
            ans = this.EN.zero();
            break;
            }
        }
    /**/
    return ans;    
    }
    
    private Object convert(int t)
    {
    Object ans=null;
    int tt=this.type();
    switch(t)
    {
        case 1:
        {//convert this to Byte
        switch(tt)
        {
            case 1:
            {
            ans=this.toByte();
            break;
            }
            case 2:
            {
            ans=new Byte((byte)this.C.charValue());
            break;
            }
            case 3:
            {
            ans=new Byte((byte)this.S.shortValue());
            break;
            }
            case 4:
            {
            ans=new Byte((byte)this.I.intValue());
            break;
            }
            case 5:
            {
            ans=new Byte((byte)this.L.longValue());
            break;
            }
            case 6:
            {
            ans=new Byte((byte)this.F.floatValue());
            break;
            }
            case 7:
            {
            ans=new Byte((byte)this.D.doubleValue());
            break;
            }
            case 8:case 9:case 10:
            {
            ans=new Byte((byte)this.EN.to_double());
            break;
            }
        }
        break;
        }
        case 2:
        {//convert this to ExtChar/char
        switch(tt)
        {
            case 1:
            {
            //ans=this.toByte();
            ans=new ExtChar((char)this.B.byteValue());
            break;
            }
            case 2:
            {
            //ans=new ExtChar(this.C);
            ans=this.toExtChar();
            break;
            }
            case 3:
            {
            ans=new ExtChar((char)this.S.shortValue());
            break;
            }
            case 4:
            {
            ans=new ExtChar((char)this.I.intValue());
            break;
            }
            case 5:
            {
            ans=new ExtChar((char)this.L.longValue());
            break;
            }
            case 6:
            {
            ans=new ExtChar((char)this.F.floatValue());
            break;
            }
            case 7:
            {
            ans=new ExtChar((char)this.D.doubleValue());
            break;
            }
            case 8:case 9:case 10:
            {
            ans=new ExtChar((char)this.EN.to_double());
            break;
            }
        }
        break;
        }
        case 3:
        {//convert this to Short
        switch(tt)
        {
            case 1:
            {
            //ans=this.toByte();
            ans=new Short((short)this.B.byteValue());
            break;
            }
            case 2:
            {
            ans=new Short((short)this.C.charValue());
            break;
            }
            case 3:
            {
            ans=this.toShort();
            break;
            }
            case 4:
            {
            ans=new Short((short)this.I.intValue());
            break;
            }
            case 5:
            {
            ans=new Short((short)this.L.longValue());
            break;
            }
            case 6:
            {
            ans=new Short((short)this.F.floatValue());
            break;
            }
            case 7:
            {
            ans=new Short((short)this.D.doubleValue());
            break;
            }
            case 8:case 9:case 10:
            {
            ans=new Short((short)this.EN.to_double());
            break;
            }
        }
        break;
        }
        case 4:
        {//convert this to Integer
        switch(tt)
        {
            case 1:
            {
            //ans=this.toByte();
            ans=new Integer((int)this.B.byteValue());
            break;
            }
            case 2:
            {
            ans=new Integer((int)this.C.charValue());
            break;
            }
            case 3:
            {
            ans=new Integer((int)this.S.shortValue());
            break;
            }
            case 4:
            {
            //ans=new Short((short)this.I.intValue());
            ans=this.toInteger();
            break;
            }
            case 5:
            {
            ans=new Integer((int)this.L.longValue());
            break;
            }
            case 6:
            {
            ans=new Integer((int)this.F.floatValue());
            break;
            }
            case 7:
            {
            ans=new Integer((int)this.D.doubleValue());
            break;
            }
            case 8:case 9:case 10:
            {
            ans=new Integer((int)this.EN.to_double());
            break;
            }
        }
        break;
        }
        case 5:
        {//convert this to Long
        switch(tt)
        {
            case 1:
            {
            //ans=this.toByte();
            ans=new Long((long)this.B.byteValue());
            break;
            }
            case 2:
            {
            ans=new Long((long)this.C.charValue());
            break;
            }
            case 3:
            {
            ans=new Long((long)this.S.shortValue());
            break;
            }
            case 4:
            {
            ans=new Long((long)this.I.intValue());
            break;
            }
            case 5:
            {
            //ans=new Integer((int)this.L.longValue());
            ans=this.toLong();
            break;
            }
            case 6:
            {
            ans=new Long((long)this.F.floatValue());
            break;
            }
            case 7:
            {
            ans=new Long((long)this.D.doubleValue());
            break;
            }
            case 8:case 9:case 10:
            {
            ans=new Long((long)this.EN.to_double());
            break;
            }
        }
        break;
        }
        case 6:
        {//convert this to Float
        switch(tt)
        {
            case 1:
            {
            //ans=this.toByte();
            ans=new Float((float)this.B.byteValue());
            break;
            }
            case 2:
            {
            ans=new Float((float)this.C.charValue());
            break;
            }
            case 3:
            {
            ans=new Float((float)this.S.shortValue());
            break;
            }
            case 4:
            {
            ans=new Float((float)this.I.intValue());
            break;
            }
            case 5:
            {
            ans=new Float((float)this.L.longValue());
            break;
            }
            case 6:
            {
            //ans=new Long((long)this.F.floatValue());
            ans=this.toFloat();
            break;
            }
            case 7:
            {
            ans=new Float((float)this.D.doubleValue());
            break;
            }
            case 8:case 9:case 10:
            {
            ans=new Float((float)this.EN.to_double());
            break;
            }
        }
        break;
        }
        case 7:
        {//convert this to Double
        switch(tt)
        {
            case 1:
            {
            //ans=this.toByte();
            ans=new Double((double)this.B.byteValue());
            break;
            }
            case 2:
            {
            ans=new Double((double)this.C.charValue());
            break;
            }
            case 3:
            {
            ans=new Double((double)this.S.shortValue());
            break;
            }
            case 4:
            {
            ans=new Double((double)this.I.intValue());
            break;
            }
            case 5:
            {
            ans=new Double((double)this.L.longValue());
            break;
            }
            case 6:
            {
            ans=new Double((double)this.F.floatValue());
            break;
            }
            case 7:
            {
            //ans=new Float((float)this.D.doubleValue());
            ans=this.toDouble();
            break;
            }
            case 8:case 9:case 10:
            {
            ans=new Double((double)this.EN.to_double());
            break;
            }
        }
        break;
        }
        case 8:
        {//convert this to ExtNum(ExtInteger)
        switch(tt)
        {
            case 1:
            {
            //ans=this.toByte();
            ans=new ExtNum(new ExtInteger((long)this.B.byteValue()));
            break;
            }
            case 2:
            {
            ans=new ExtNum(new ExtInteger((long)this.C.charValue()));
            break;
            }
            case 3:
            {
            ans=new ExtNum(new ExtInteger((long)this.S.shortValue()));
            break;
            }
            case 4:
            {
            ans=new ExtNum(new ExtInteger((long)this.I.intValue()));
            break;
            }
            case 5:
            {
            ans=new ExtNum(new ExtInteger((long)this.L.longValue()));
            break;
            }
            case 6:
            {
            ans=new ExtNum(new ExtInteger((long)this.F.floatValue()));
            break;
            }
            case 7:
            {
            ans=new ExtNum(new ExtInteger((long)this.D.doubleValue()));
            break;
            }
            case 8:
            {
            ans=new ExtNum(this.EN.main().first());
            break;
            }
            case 9:
            {
            ans=new ExtNum(new ExtInteger(this.EN.main().second().chains()));
            break;
            }
            case 10:
            {
            //ExtSInteger[] qwe=new ExtSInteger[2];
            ans=new ExtNum(new ExtInteger(ExtSInteger.QR(this.EN.main().third().chains().first(),this.EN.main().third().chains().second())[0].chains()));
            break;
            }
        }
        break;
        }
        case 9:
        {//convert this to ExtNum(ExtSInteger)
        switch(tt)
        {
            case 1:
            {
            //ans=this.toByte();
            ans=new ExtNum(new ExtSInteger((long)this.B.byteValue()));
            break;
            }
            case 2:
            {
            ans=new ExtNum(new ExtSInteger((long)this.C.charValue()));
            break;
            }
            case 3:
            {
            ans=new ExtNum(new ExtSInteger((long)this.S.shortValue()));
            break;
            }
            case 4:
            {
            ans=new ExtNum(new ExtSInteger((long)this.I.intValue()));
            break;
            }
            case 5:
            {
            ans=new ExtNum(new ExtSInteger((long)this.L.longValue()));
            break;
            }
            case 6:
            {
            ans=new ExtNum(new ExtSInteger((long)this.F.floatValue()));
            break;
            }
            case 7:
            {
            ans=new ExtNum(new ExtSInteger((long)this.D.doubleValue()));
            break;
            }
            case 8:
            {
            ans=new ExtNum(new ExtSInteger(this.EN.main().first()));
            break;
            }
            case 9:
            {
            ans=new ExtNum(new ExtSInteger(this.EN.main().second()));
            break;
            }
            case 10:
            {
            //ExtSInteger[] qwe=new ExtSInteger[2];
            //nuzhnoe
            //ans=new ExtNum(new ExtSInteger(ExtSInteger.QR(this.EN.main().third().chains().first(),this.EN.main().third().chains().second())[0]));
            ans=this.EN.main().third();
            ans=ExtSInteger.QR(((Racio)ans).chains().first(),((Racio)ans).chains().second())[0];
            ans=new ExtNum((ExtSInteger) ans);
            break;
            }
        }
        break;
        }
        case 10:
        {//convert this to ExtNum(Racio)
        switch(tt)
        {
            case 1:
            {
            //ans=this.toByte();
            ans=new ExtNum(new Racio(new ExtSInteger((long)this.B.byteValue())));
            break;
            }
            case 2:
            {
           ans=new ExtNum(new Racio(new ExtSInteger((long)this.C.charValue())));
            break;
            }
            case 3:
            {
            ans=new ExtNum(new Racio(new ExtSInteger((long)this.S.shortValue())));
            break;
            }
            case 4:
            {
            ans=new ExtNum(new Racio(new ExtSInteger((long)this.I.intValue())));
            break;
            }
            case 5:
            {
            ans=new ExtNum(new Racio(new ExtSInteger((long)this.L.longValue())));
            break;
            }
            case 6:
            {
            //ans=new ExtNum(new Racio(new ExtSInteger((long)this.F.floatValue())));
            ans=new ExtNum(new Racio(this.F.floatValue()));
            break;
            }
            case 7:
            {
            //ans=new ExtNum(new Racio(new ExtSInteger((long)this.D.doubleValue())));
            ans=new ExtNum(new Racio(this.D.doubleValue()));
            break;
            }
            case 8:
            {
            ans=new ExtNum(new ExtSInteger(this.EN.main().first()),new ExtInteger(1));
            
            break;
            }
            case 9:
            {
            ans=new ExtNum(new ExtSInteger(this.EN.main().second()),new ExtInteger(1));
            break;
            }
            case 10:
            {
            ans=new ExtNum(new Racio(this.EN.main().third()));
            break;
            }
        }
        break;
        }
    
    
    
    }
    
    
    return ans;
    }
  
    public Ariphmetical cast(int i)
    {
    Ariphmetical ans=null;
    Object obj=this.convert(i);
    switch(i)
    {
        case 1:
        {
        ans=new Ariphmetical((Byte)obj);
        break;
        }
        case 2:
        {
        ans=new Ariphmetical((ExtChar)obj);
        break;
        }
        case 3:
        {
        ans=new Ariphmetical((Short)obj);
        break;
        }
        case 4:
        {
        ans=new Ariphmetical((Integer)obj);
        break;
        }
        case 5:
        {
        ans=new Ariphmetical((Long)obj);
        break;
        }
        case 6:
        {
        ans=new Ariphmetical((Float)obj);
        break;
        }
        case 7:
        {
        ans=new Ariphmetical((Double)obj);
        break;
        }
        case 8:case 9:case 10:
        {
        ans=new Ariphmetical((ExtNum)obj);
        break;
        }
    }
    
    return ans;
    }
    public void simp()
        {
        int i=this.type();
        if(i>=8)
            this.EN.simp();
        }
    
    
    public static Ariphmetical sum(Ariphmetical a,Ariphmetical b)
    {
    
    Ariphmetical[] tmp_ar=Ariphmetical.cast(a, b);
    switch(tmp_ar[0].type())
        {
        case 1:
            {
            tmp_ar[0]=new Ariphmetical((short)(tmp_ar[0].toByte().byteValue()+tmp_ar[1].toByte().byteValue()));
            break;
            }
        case 2:
            {
            tmp_ar[0]=new Ariphmetical((char)(tmp_ar[0].toExtChar().charValue()+tmp_ar[1].toExtChar().charValue()));
            break;
            }
        case 3:
            {
            tmp_ar[0]=new Ariphmetical((short)(tmp_ar[0].toShort().shortValue()+tmp_ar[1].toShort().shortValue()));
            break;
            }
        case 4:
            {
            tmp_ar[0]=new Ariphmetical((int)(tmp_ar[0].toInteger().intValue()+tmp_ar[1].toInteger().intValue()));
            break;
            }
        case 5:
            {
            tmp_ar[0]=new Ariphmetical((long)(tmp_ar[0].toLong().longValue()+tmp_ar[1].toLong().longValue()));
            break;
            }
        case 6:
            {
            tmp_ar[0]=new Ariphmetical((float)(tmp_ar[0].toFloat().floatValue()+tmp_ar[1].toFloat().floatValue()));
            break;
            }
        case 7:
            {
            tmp_ar[0]=new Ariphmetical((double)(tmp_ar[0].toDouble().doubleValue()+tmp_ar[1].toDouble().doubleValue()));
            break;
            }
        case 8:case 9:case 10:
            {
            tmp_ar[0]=new Ariphmetical(ExtNumCalc.sum(tmp_ar[0].toExtNum(),tmp_ar[1].toExtNum()));
            break;
            }
    
        }
    
    return tmp_ar[0];
    }
    
    public static Ariphmetical sub(Ariphmetical a,Ariphmetical b)
    {
    Ariphmetical[] tmp_ar=Ariphmetical.cast(a, b);
    switch(tmp_ar[0].type())
    {
        case 1:
            {
            tmp_ar[0]=new Ariphmetical(new Byte((byte)(tmp_ar[0].toByte().byteValue()-tmp_ar[1].toByte().byteValue())));
            break;
            }
        case 2:
            {
            tmp_ar[0]=new Ariphmetical(new ExtChar((char)(tmp_ar[0].toExtChar().charValue()-tmp_ar[1].toExtChar().charValue())));
            break;
            }
        case 3:
            {
            tmp_ar[0]=new Ariphmetical(new Short((short)(tmp_ar[0].toShort().shortValue()-tmp_ar[1].toShort().shortValue())));
            break;
            } 
        case 4:
            {
            tmp_ar[0]=new Ariphmetical(new Integer((int)(tmp_ar[0].toInteger().intValue()-tmp_ar[1].toInteger().intValue())));
            break;
            }
        case 5:
            {
            tmp_ar[0]=new Ariphmetical(new Long((long)(tmp_ar[0].toLong().longValue()-tmp_ar[1].toLong().longValue())));
            break;
            }
        case 6:
            {
            tmp_ar[0]=new Ariphmetical(new Float((float)(tmp_ar[0].toFloat().floatValue()-tmp_ar[1].toFloat().floatValue())));
            break;
            }
        case 7:
            {
            tmp_ar[0]=new Ariphmetical(new Double((float)(tmp_ar[0].toDouble().doubleValue()-tmp_ar[1].toDouble().doubleValue())));
            break;
            }
        case 8:case 9: case 10:
            {
            tmp_ar[0]=new Ariphmetical(ExtNumCalc.sub(tmp_ar[0].toExtNum(), tmp_ar[1].toExtNum()));
            break;
            }
        default:
        {
        tmp_ar[0]=null;
        break;
        }
    }
    return tmp_ar[0];
    }
    
    public static Ariphmetical prod(Ariphmetical a,Ariphmetical b)
    {
    Ariphmetical[] tmp_ar=Ariphmetical.cast(a, b);
    switch(tmp_ar[0].type())
    {
        case 1:
            {
            tmp_ar[0]=new Ariphmetical(new Byte((byte)(tmp_ar[0].toByte().byteValue()*tmp_ar[1].toByte().byteValue())));
            break;
            }
        case 2:
            {
            tmp_ar[0]=new Ariphmetical(new ExtChar((char)(tmp_ar[0].toExtChar().charValue()*tmp_ar[1].toExtChar().charValue())));
            break;
            }
        case 3:
            {
            tmp_ar[0]=new Ariphmetical(new Short((short)(tmp_ar[0].toShort().shortValue()*tmp_ar[1].toShort().shortValue())));
            break;
            } 
        case 4:
            {
            tmp_ar[0]=new Ariphmetical(new Integer((int)(tmp_ar[0].toInteger().intValue()*tmp_ar[1].toInteger().intValue())));
            break;
            }
        case 5:
            {
            tmp_ar[0]=new Ariphmetical(new Long((long)(tmp_ar[0].toLong().longValue()*tmp_ar[1].toLong().longValue())));
            break;
            }
        case 6:
            {
            tmp_ar[0]=new Ariphmetical(new Float((float)(tmp_ar[0].toFloat().floatValue()*tmp_ar[1].toFloat().floatValue())));
            break;
            }
        case 7:
            {
            tmp_ar[0]=new Ariphmetical(new Double((float)(tmp_ar[0].toDouble().doubleValue()*tmp_ar[1].toDouble().doubleValue())));
            break;
            }
        case 8:case 9: case 10:
            {
            tmp_ar[0]=new Ariphmetical(ExtNumCalc.prod(tmp_ar[0].toExtNum(), tmp_ar[1].toExtNum()));
            break;
            }
        default:
        {
        tmp_ar[0]=null;
        break;
        }
    }
    return tmp_ar[0];
    }
    
    public static Ariphmetical div(Ariphmetical a,Ariphmetical b)
    {
    
    Ariphmetical[] tmp_ar=Ariphmetical.cast(a, b);
    double tmp_d;
    float tmp_f;
    ExtNum tmp_en;
    if(tmp_ar[1].zero())
        throw new AriphmeticalException("Devision by zero.");
    if(tmp_ar[1].type()<=7)
        {
        switch(tmp_ar[1].type())
            {
            case 6:
                {
                tmp_f=tmp_ar[0].toFloat().floatValue()/tmp_ar[1].toFloat().floatValue();
                tmp_ar[0]=new Ariphmetical(tmp_f);
                break;
                }
            case 7:
                {
                tmp_d=tmp_ar[0].toDouble().doubleValue()/tmp_ar[1].toDouble().doubleValue();
                tmp_ar[0]=new Ariphmetical(tmp_d);
                break;
                }
            default:
                {
                tmp_ar[0]=Ariphmetical.div(tmp_ar[0].cast(6),tmp_ar[1].cast(6));
                break;
                }
            }
        }
    else
        {
        tmp_en=ExtNumCalc.div(tmp_ar[0].toExtNum(), tmp_ar[1].toExtNum());
        tmp_ar[0]=new Ariphmetical(tmp_en);
        }
    return tmp_ar[0];
    }
    
    
    public static Ariphmetical[] QR(Ariphmetical i1, Ariphmetical i2)
    {
     
     Ariphmetical[] tmp_ar=null;
     String e1="Only integer types can be given to QR.",e2="Undefined types.";
     byte b=0;
     char c=0;
     short s=0;
     int i=0;
     long l=0;
     ExtNum[] en=null;
     i=i1.type();
     
     if(i==6||i==7||i==10)
         throw new AriphmeticalException(e1);
     
     i=i2.type();
     if(i==6||i==7||i==10)
         throw new AriphmeticalException(e1);
     i=0;
     tmp_ar=Ariphmetical.cast(i1, i2);
    switch(tmp_ar[0].type())
        {
        case 1:
            {
            b=tmp_ar[0].toByte().byteValue();
            tmp_ar[0]=new Ariphmetical((byte)(b/tmp_ar[1].toByte().byteValue()));
            tmp_ar[1]=new Ariphmetical((byte)(b%tmp_ar[1].toByte().byteValue()));
            break;
            }
        case 2:
            {
            c=tmp_ar[0].toExtChar().charValue();
            tmp_ar[0]=new Ariphmetical((char)(c/tmp_ar[1].toExtChar().charValue()));
            tmp_ar[1]=new Ariphmetical((char)(c%tmp_ar[1].toExtChar().charValue()));
            break;
            }
        case 3:
            {
            s=tmp_ar[0].toShort().shortValue();
            tmp_ar[0]=new Ariphmetical((short)(s/tmp_ar[1].toShort().shortValue()));
            tmp_ar[1]=new Ariphmetical((short)(s%tmp_ar[1].toShort().shortValue()));
            break;
            }
        case 4:
            {
            i=tmp_ar[0].toInteger().intValue();
            tmp_ar[0]=new Ariphmetical((int)(i/tmp_ar[1].toInteger().intValue()));
            tmp_ar[1]=new Ariphmetical((int)(i%tmp_ar[1].toInteger().intValue()));
            break;
            }
        case 5:
            {
            l=tmp_ar[0].toLong().longValue();
            tmp_ar[0]=new Ariphmetical((long)(l/tmp_ar[1].toLong().longValue()));
            tmp_ar[1]=new Ariphmetical((long)(l%tmp_ar[1].toLong().longValue()));
            break;
            }
            /*
        case 6: case 7: case 10:
            {
            throw (new AriphmeticalException(e1));
            }
            */
        case 8: case 9:
            {
            en=ExtNumCalc.QR(tmp_ar[0].toExtNum(), tmp_ar[1].toExtNum());
            tmp_ar[0]=new Ariphmetical(en[0]);
            tmp_ar[1]=new Ariphmetical(en[1]);
            
            break;
            }
        default:
            {
            throw new AriphmeticalException(e2);
            }
        
        
        
        }
     
     return tmp_ar;
    }
    /**
     * if i1>i2 - > 2
     * if i1<i2 -> 1
     * if i1==i2 -> 3
     * @param i1
     * @param i2
     * @return 
     */
   public static int cmp(Ariphmetical i1, Ariphmetical i2)
   {
       
   int ans=0,in1,in2;
   
   long l1,l2;
   byte b1,b2;
   short s1,s2;
   char c1,c2;
   float f1,f2;
   double d1,d2;
   Ariphmetical[] tmp=Ariphmetical.cast(i1, i2);
   switch(tmp[0].type())
    {
       case 10: case 8: case 9:
            {
            ans=ExtNumCalc.cmp(tmp[0].toExtNum(), tmp[1].toExtNum());
            break;
            }
       case 1:
            {
            b1=tmp[0].toByte().byteValue();
             b2=tmp[1].toByte().byteValue();
            if(b1>b2)
                ans=2;
            else if(b1==b2) ans=3;
            else ans=1;
                
            break;
            }
        case 2:
            {
            c1=tmp[0].toExtChar().charValue();
             c2=tmp[1].toExtChar().charValue();
            if(c1>c2)
                ans=2;
            else if(c1==c2) ans=3;
            else ans=1;
                
            break;
            }
        case 3:
            {
            s1=tmp[0].toShort().shortValue();
             s2=tmp[1].toShort().shortValue();
            if(s1>s2)
                ans=2;
            else if(s1==s2) ans=3;
            else ans=1;
                
            break;
            }
        case 4:
            {
            in1=tmp[0].toInteger().intValue();
             in2=tmp[1].toInteger().intValue();
            if(in1>in2)
                ans=2;
            else if(in1==in2) ans=3;
            else ans=1;
                
            break;
            }
        case 5:
            {
            l1=tmp[0].toLong().longValue();
             l2=tmp[1].toLong().longValue();
            if(l1>l2)
                ans=2;
            else if(l1==l2) ans=3;
            else ans=1;
            break;
            }
        case 6:
            {
            f1=tmp[0].toFloat().floatValue();
             f2=tmp[1].toFloat().floatValue();
            if(f1>f2)
                ans=2;
            else if(f1==f2) ans=3;
            else ans=1;
            break;
            }
        case 7:
            {
            d1=tmp[0].toDouble().doubleValue();
             d2=tmp[1].toDouble().doubleValue();
            if(d1>d2)
                ans=2;
            else if(d1==d2) ans=3;
            else ans=1;
            break;
            }
   }
   
   return ans;
   }
    
    
    
  public static Ariphmetical[] cast(Ariphmetical a, Ariphmetical b)
  {
  Ariphmetical[] ans=new Ariphmetical[2];
  int vsp;
  vsp=a.type();
  vsp=vsp-b.type();
  if(vsp>0)
    {
    ans[0]=new Ariphmetical(a);
    vsp=ans[0].type();
    ans[1]=b.cast(vsp);
    }
    else if(vsp<0)
            {
            ans[1]=new Ariphmetical(b);
            vsp=ans[1].type();
            ans[0]=a.cast(vsp);
            }
        else
            {
            ans[1]=new Ariphmetical(b);
            ans[0]=new Ariphmetical(a);
            vsp=a.type();
            }

  return ans;
  }
  
  
  /**
   * 
   * @param a
   * @param x
   * @return A^x
   */
  public static Ariphmetical pow(Ariphmetical a, Ariphmetical x )
        {
        Ariphmetical ans=Ariphmetical.N;
        ExtNum tmp1,tmp2;
        int i;
        i=a.type();
        if(i>=8)
            {
            i=x.type();
            if(i>=8)
                {
                tmp1=a.toExtNum();
                tmp2=x.toExtNum();
                tmp1=ExtNumCalc.pow(tmp1,tmp2);
                ans=new Ariphmetical(tmp1);
                }
            }
        return ans;
        }
  
  public static Ariphmetical abs(Ariphmetical ar)
    {
    Ariphmetical ans=null;
    Byte b;
    ExtChar extC;
    Short s;
    Integer i;
    Long l;
    Float f;
    Double d;
    ExtNum extN;
    
    ExtInteger extI;
    ExtSInteger extSI;
    Pair<ExtSInteger, ExtInteger> p;
    
    if(ar==null)
        ans=Ariphmetical.N;
    else
    if(ar.zero())
        ans=Ariphmetical.N;
    else
    switch(ar.type())
        {
        case 1:
            {
            b=ar.toByte();
            if(b<0)
                b=(byte)(-b);
            ans=new Ariphmetical(b);
            break;
            }
        case 2:
            {
            ans=new Ariphmetical(ar);
            break;
            }
        case 3:
            {
            s=ar.toShort();
            if(s<0)
                s=(short)(-s);
            ans=new Ariphmetical(s);
            break;
            }
        case 4:
            {
            i=ar.toInteger();
            if(i<0)
                i=(int)(-i);
            ans=new Ariphmetical(i);
            break;
            }
        case 5:
            {
            l=ar.toLong();
            if(l<0)
                l=(long)(-l);
            ans=new Ariphmetical(l);
            break;
            }
        case 6:
            {
            f=ar.toFloat();
            if(f<0)
                f=(float)(-f);
            ans=new Ariphmetical(f);
            break;
            }
        case 7:
            {
            d=ar.toDouble();
            if(d<0)
                d=(double)(-d);
            ans=new Ariphmetical(d);
            break;
            }
        case 8:
        case 9:
        case 10:
            {
            extN=ar.toExtNum();
            switch(extN.type())
                {
                case 0:
                    {
                    break;
                    }
                case 1:
                    {
                    extSI=extN.main().second();
                    extSI.sign(0);
                    extN=new ExtNum(extSI);
                    break;
                    }
                case 2:
                    {
                    p=extN.main().third().chains();
                    p.first().sign(0);
                    extN=new ExtNum(p.first(),p.second());
                    break;
                    }
                }
            ans=new Ariphmetical(extN);
            break;
            }
            
        }
    
    
    return ans;
    }
  
 
  
          
  
  
}
