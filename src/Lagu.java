import javax.swing.*;
import java.io.File;
import java.net.URL;
public class Lagu
{
    private File song;
    
    //constructor to Class Lagu
    public Lagu()
    {
        new Lagu(song);
    }
    public Lagu(File a)
    {
        song = a;
    }
    
    //return the name of the file
    public String getName()
    {
        return song.getName();
    }
    public File getFile()
    {
        return song;
    }
    
    //return address for the song
    public URL getLink()
    {
        URL a = null;
        try
        {
          a =  song.toURL();
        }
        catch(Exception murle)
        {
            System.out.println("Error : " + murle.getMessage());
        }
        return a;
    }
    
    public boolean exist()
    {
        if(song.exists() == true)
            return true;
        else
            return false;
    }
    
    public boolean isMp3()
    {
        if(song.isFile() == true)
            return true;
            else
                return false;
    }
        
}
