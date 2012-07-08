 

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class About extends JPanel
{   
    private JPanel panelVersion, panelCenter,panelBottom;
    //private JLabel labelVersion, label thanks, labelLastUpdate;
    public void About()
    {
        //super("About mp3 Player");
        
    }
    public void load()
    {
        JOptionPane.showMessageDialog(null,"Developed by Ayush and Anvesh");
    }
}
