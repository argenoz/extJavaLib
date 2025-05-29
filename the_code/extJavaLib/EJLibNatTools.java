
package extJavaLib;
import extJavaLib.extStringLib.ExtString;
public class EJLibNatTools {
    public  void load(String w)
    {
    //System.loadLibrary(w);
    System.load(w);
    }
    
    public  void load(ExtString w)
    {
    this.load(new ExtString(w).toString());
    }
    
}
