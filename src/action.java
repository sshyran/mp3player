import javax.media.Player;
import javax.media.Manager;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.io.File;
import javax.swing.JMenuItem;
import javax.swing.JFileChooser;
import javax.media.Time;
import javax.media.Controller;
import javax.media.Duration;

public class action implements Runnable
{
    private Player MyPlayer;
    private mp3Gui Mp3;
    private Lagu a ;
    private ArrayList ar = new ArrayList();
    public int index = 0;
    private boolean statusPlay = false, statusPause = false;
    private Time mp3,pauseT;
    private IOObject op = new IOObject();
	private progressBar progressbar;
	private Thread thd;
    
    public void setAr(ArrayList ar)
    {
        this.ar = ar;
    }
    public action(){
    	thd= new Thread(this);
    }
    
    public void remove(int i)
    {
        ar.remove(i);
        index--;
    }

    public void pause(){
    	        if(statusPause){
    	            MyPlayer.setMediaTime(pauseT);
    	            MyPlayer.start();
    	            statusPause = false;
    	        } else {
    	            pauseT = MyPlayer.getMediaTime();
    	            MyPlayer.stop();
    	            statusPause = true;
    	        }
    	    }

    
    public boolean getPause()
    {
        return statusPause;
    }
    
    public Time getDuration()
    {
        if(MyPlayer != null)
            return MyPlayer.getDuration();
        else
            return Duration.DURATION_UNKNOWN;
    }
    public float getRate()
    {
        if(MyPlayer != null)
            return MyPlayer.getRate();
        else
            return 0.0F;
    }
    public Time getMediaTime()
    {
        if(MyPlayer != null)
            return MyPlayer.getMediaTime();
        else
            return Controller.LATENCY_UNKNOWN;
    }
    public void realize()
    {
        if(MyPlayer != null)
            MyPlayer.realize();
        else
            return;
    }

    public void prefetch()
    {
        if(MyPlayer != null)
            MyPlayer.prefetch();
        else
            return;
    }

    public void deallocate()
    {
        if(MyPlayer != null)
        {
            MyPlayer.deallocate();
        } else
        {
            return;
        }
    }
    public int getSize()
    {
        return ar.size();
    }
    public boolean exist()
    {
        if(ar.size() != 0)
            return true;
        else
            return false;
    }
    public boolean getStatusPlay()
    {
        return statusPlay;
    }
    public int getIndex()
    {
        return index;
    }
    public void stop()
    {
        
            try{
                MyPlayer.stop();
            }
            catch(Exception m)
            {}
            statusPlay = false;
    }
    
    
    public void play(int ind)
    {
        
        if(statusPlay == true)
        {
            
            try{
                MyPlayer.stop();
                statusPlay = false;
            }
            catch(Exception m)
            {}
        }
        if(statusPlay == false)
        {
                try
                {
                    Lagu tmp = (Lagu)ar.get(ind);
                    
                    MyPlayer = Manager.createPlayer(((File)tmp.getFile()).toURL());
                    MyPlayer.start();                
                    statusPlay = true;
                    index=ind;
                    thd.start();
                }
                catch(Exception murle)
                {
                    System.out.println("error in play" + murle.getMessage());
                }
            
            
             
        }
    }
    public String getName()
    {
        return ((Lagu)ar.get(index)).getName();
    }
    public void openFile(JMenuItem JMOpen)
    {
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fc.showOpenDialog(JMOpen);
        if(result == JFileChooser.APPROVE_OPTION)
        {
            a = new Lagu(fc.getSelectedFile());
            if(a.exist() == true && a.isMp3() == true)
            {
                ar.add(a);
            }
        }
    }
    public ArrayList getArrayList()
    {
        return ar;
    }
    public ArrayList geta()
    {
        return ar;
    }
    
    public void readList()
    {
        ar = (ArrayList)op.readObject(ar);
    }
    public void saveList()
    {
        op.saveObject(ar);
    }
    public void resetIndex()
    {
        index = -1;
    }
    
    public void setPrgressBar(progressBar prgbr){
    	progressbar=prgbr;
    }
    
    public void run(){
    	while(this.getMediaTime().getSeconds()<=this.getDuration().getSeconds()){
    		progressbar.setCurPos((int)this.getMediaTime().getSeconds());
    		System.out.println((int)this.getMediaTime().getSeconds());
    	}
    }
}
