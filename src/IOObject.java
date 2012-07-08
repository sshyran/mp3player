import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.lang.ClassNotFoundException;
import java.io.EOFException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.File;
public class IOObject
{
    private Lagu ac;
    private ArrayList ar = new ArrayList();
    private FileInputStream fis;
    private ObjectInputStream ois; 
    private FileOutputStream fos;
    private ObjectOutputStream oos = null;
    public IOObject()
    {
        
    }
    
    public ArrayList readObject(ArrayList a)
    {   
        ar = a;
        try{
            fis = new FileInputStream("list.pl");
        	ois = new ObjectInputStream(fis);

        	File tmp;   
        	while((tmp = (File)ois.readObject()) !=  null)
        	{
            	
            	//ar.add(tmp);            
            	ac = new Lagu(tmp);
            	ar.add(ac);
            	
            }
            ois.close();
      }catch(IOException iox)
      {  }
      catch(ClassNotFoundException iox)
      {  System.out.println("Problem: " + iox.getMessage());   }
//       catch(EOFException eo)
//       {  }
      return ar;
    }
    
    public void saveObject(ArrayList a)
    {
        try{
            fos = new FileOutputStream("list.pl");
        	oos = new ObjectOutputStream(fos);
        	      
//         	Lagu tmp = (Lagu)a.get(0);
//         	oos.writeObject(tmp);      
        	for(int i =0; i < a.size(); i++)
        	{
        	    Lagu tmp = (Lagu)a.get(i);
        	    oos.writeObject(tmp.getFile());
        	}
        	
            oos.close();
      }
      catch(IOException iox)
      {  System.out.println("Problem23: " + iox.getMessage());   }
      
      
    }
}