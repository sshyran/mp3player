import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.List;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Jump extends JFrame implements ActionListener,KeyListener
{
    private ArrayList lagu = new ArrayList();
    private JButton btPlay = new JButton();
    private JTextField jtSearch;
    private List listSelect = new List(20);
    private JPanel panelFn, panelList;
    private action a = new action();
    private mp3Gui mp3;
    private int indexSelected = 0;
    private String cariLagu;
    
    
    public Jump(ArrayList ar)
    {
        super("Search Song(s)");
        lagu = ar;
        btPlay.setText("Play");
        jtSearch = new JTextField(20);
        panelFn = new JPanel(new FlowLayout());
        panelList = new JPanel(new BorderLayout());
        
        panelFn.add(jtSearch);
        panelFn.add(btPlay);
        panelList.add(listSelect);
        
        panelFn.setBorder(new TitledBorder(new EtchedBorder()));
        panelList.setBorder(new TitledBorder(new EtchedBorder()));
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add( panelFn, BorderLayout.NORTH   );
        getContentPane().add( panelList, BorderLayout.CENTER );
        
        btPlay.addActionListener(this);
        jtSearch.addKeyListener(this);
        
        for(int i =0; i < lagu.size(); i++)
        {
            listSelect.add(((Lagu)lagu.get(i)).getName(),i);

        }
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == btPlay)
        {
            play();
        }
    }
    
 
    public void keyPressed(KeyEvent e) 
    {}
    public void keyReleased(KeyEvent e)
    
    {
        listSelect.removeAll();
       cariLagu = jtSearch.getText();
       
       for(int i =0; i < lagu.size(); i++)
        {
            if(((((Lagu)lagu.get(i)).getName()).substring(0, cariLagu.length())).equalsIgnoreCase(cariLagu))
            {
                listSelect.add(((Lagu)lagu.get(i)).getName(),i);
            }
        }
    }
    
    public void keyTyped(KeyEvent e)
    {}
    
    public void play()
    {
        //System.out.println("bolejh hohohoh laa");
            action act = new action();
                      
            int ind = listSelect.getSelectedIndex();
            //System.out.println(ind);
            
            String st = (String)listSelect.getItem(ind);
            //System.out.println(st);
            
            //System.out.println(lagu.size());
            
            for(int i =0; i < lagu.size(); i++)
            {
                Lagu lgTmp = (Lagu)lagu.get(i);
                String tmp = (String)lgTmp.getName();
                if(tmp.equalsIgnoreCase(st))
                {
                    //mp3.selectList(i);
                    //a.play(i);
                }
            }
    }
    public void list()
    {
        
    }
}
