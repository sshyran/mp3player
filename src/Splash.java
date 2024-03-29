import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Container;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class Splash extends JWindow
{
	private Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

	public Splash() 
	{
	    Container c = getContentPane();
		JLabel lImage = new JLabel(new ImageIcon((mp3Gui.class.getResource("/icon/melody-songs.png"))));
		Color borderColor = new Color(0, 0, 0);
		lImage.setBorder(new LineBorder(borderColor, 1));

		c.add (lImage, BorderLayout.CENTER);
		pack();

		setSize(getSize().width, getSize().height);
		setLocation(d.width / 2 - getWidth() / 2, d.height / 2 - getHeight() / 2);
		
		setVisible (true);
	}
	
	public void close()
	{
	    setVisible(false);
    	dispose();
    }
}
