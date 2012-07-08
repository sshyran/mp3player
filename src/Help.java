import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Help extends JFrame 
{
    JLabel mp3Name;
    
    public Help(String str)
    {
        super(str);

    }
    
    public void paint(Graphics gh)
    {
        super.paint(gh);
        
        gh.setColor(new Color(255,255,0));
        gh.fillRect(25,25,90,200);
        gh.setColor(new Color(0,0,255));
        gh.setFont(new Font("Serif",Font.ITALIC,14));
        gh.drawString("Do you have any problem?",120,65);
        gh.drawString("Please e-mail us : ",120,80);
        gh.setFont(new Font("Courier New",Font.PLAIN,12));
        gh.drawString("intelli7@hotmail.com",120,95);
        gh.drawString("alfi_fastriey@yahoo.com",120,110);
    }
}
