import java.awt.Dimension;
import java.awt.Toolkit;
public class mp3app
{
    private static String gambar = new String("a.jpeg");
    public static void main(String[] args)
    {
       Splash ap = new Splash();
       try{
           Thread.sleep(5000);
        }
        catch(Exception e)
        {}
       ap.setVisible(false);
       mp3Gui ab = new mp3Gui("myMp3 Player");
       ab.setIconImage(ab.getToolkit().getImage("jmp3.gif"));
       ab.setSize(500,490);
       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = ab.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        ab.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
       
       ab.setVisible(true);
       ab.setResizable(false); 
       
       
       WindowQuitter wquit = new WindowQuitter();
       ab.addWindowListener(wquit);
       ap.addWindowListener(wquit);
      
    }
}