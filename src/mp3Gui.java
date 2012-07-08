/**
 * Final Project : csc258:Data Structure
 * 
 * @author (Mohd Azrul Amir Bin Muhamad Tajudin) 
 * @id (2003425945)
 * @lecturer (En Azizian)
 * @group (DCS04B)
 * @group member : Mohd Azrul Amir Bin Muhamad Tajudin
 *                 Mohd Fikri Bin Yahya
 */


import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.List;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;

public class mp3Gui extends JFrame implements ActionListener
{
    private JButton btAdd,btSave,btJump,btQueue,btFirst,btLast,btRem;
    private JMenuItem JMOpen, JMExit, JMAbout, JMHelp;
    private JMenu File, Help;
    private JMenuBar JMB;
    private List listSong = new List();
    private JPanel panelTop,panelCenter, panelButtonMp3, panelButtonFn, panelStatus, panelList;
    private JLabel lbStatus,lbBanner;
    private action a = new action();
    private Jump jp;
    private JButton btnPrevious;
    private JButton btnStop;
    private JButton btnNext;
    private JButton btnPause_1;
    private boolean playOrPause;
    private int previous_song;
    private progressBar progressbar;
    
    public mp3Gui(String title){
        super.setTitle(title);
        lbBanner = new JLabel("-------------------------------");
        File = new JMenu("File");
        Help = new JMenu("Help");
        JMOpen = new JMenuItem("Add mp3");
        JMExit = new JMenuItem("Quit Application");
        JMAbout = new JMenuItem("About");
        JMHelp = new JMenuItem("Help");
        playOrPause = false;
        previous_song = -1;
        JMB = new JMenuBar();
        File.add(JMOpen);
        File.add(JMExit);
        Help.add(JMAbout);
        Help.add(JMHelp);
        JMB.add(File);
        JMB.add(Help);
        
        btFirst = new JButton("first");
        btLast = new JButton("last");
        
        
        btQueue = new JButton("Qu");
        btQueue.setBackground(Color.pink);
        listSong.setBounds(10, 10, 463, 114);
        
        listSong.setBackground(Color.WHITE);
        panelList = new JPanel(new BorderLayout());
        panelTop = new JPanel(new BorderLayout());
        panelCenter = new JPanel();
        panelTop.add(lbBanner);
        
        panelTop.setBorder(new TitledBorder(new EtchedBorder()));
        
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add( panelCenter, BorderLayout.CENTER );
        
        super.setJMenuBar(JMB);
        
        
        
        JMOpen.addActionListener(this);
        JMExit.addActionListener(this);
        JMAbout.addActionListener(this);
        JMHelp.addActionListener(this);
        btQueue.addActionListener(this);
        btQueue.setEnabled(false);
        btFirst.setEnabled(false);
        
        btAdd = new JButton("Add");
        btAdd.setBackground(Color.WHITE);
        btRem = new JButton("Rem");
        btRem.setBackground(Color.WHITE);
        btSave = new JButton("Sort");
        btSave.setBackground(Color.WHITE);
        btJump = new JButton("Jump");
        btJump.setBackground(Color.WHITE);
        panelButtonFn = new JPanel(new FlowLayout());
        panelButtonFn.setBounds(10, 269, 463, 50);
        panelButtonFn.add(btAdd);
        panelButtonFn.add(btSave);
        panelButtonFn.add(btRem);
        panelButtonFn.add(btJump);
        panelButtonFn.setBorder(new TitledBorder(new EtchedBorder()));
        btJump.addActionListener(this);
        btAdd.addActionListener(this);
        btRem.addActionListener(this);
        btSave.addActionListener(this);
        
        btSave.setEnabled(false);
        btJump.setEnabled(false);
        btRem.setEnabled(false);
        panelButtonMp3 = new JPanel();
        panelButtonMp3.setBounds(10, 201, 463, 57);
        lbStatus = new JLabel("Now Playing ...");
        panelStatus = new JPanel(new FlowLayout());
        panelStatus.setBounds(10, 330, 463, 37);
        panelStatus.add(lbStatus);
        panelStatus.setBorder(new TitledBorder(new EtchedBorder()));
                
        btnPrevious = new JButton("Previous");
        btnPrevious.setBounds(21, 11, 101, 33);
        btnPrevious.setIcon(new ImageIcon(mp3Gui.class.getResource("/icon/NX2-Previous-icon.png")));
        btnPrevious.addActionListener(this);
        
        btnStop = new JButton("Stop");
        btnStop.setBounds(241, 11, 99, 33);
        btnStop.setIcon(new ImageIcon(mp3Gui.class.getResource("/icon/NX2-Stop-icon.png")));
        btnStop.addActionListener(this);
        
        btnNext = new JButton("Next");
        btnNext.setBounds(350, 11, 93, 33);
        btnNext.setIcon(new ImageIcon(mp3Gui.class.getResource("/icon/NX2-Next-icon.png")));
        btnNext.addActionListener(this);
        
        btnPause_1 = new JButton("Play");
        btnPause_1.setBounds(132, 11, 99, 33);
        btnPause_1.setIcon(new ImageIcon(mp3Gui.class.getResource("/icon/NX2-Play-icon.png")));
        btnPause_1.addActionListener(this);
        panelCenter.setLayout(null);
        panelCenter.add(listSong);
        panelCenter.add(panelStatus);
        panelCenter.add(panelButtonFn);
        panelCenter.add(panelButtonMp3);
        panelButtonMp3.setLayout(null);
        panelButtonMp3.add(btnPrevious);
        panelButtonMp3.add(btnPause_1);
        panelButtonMp3.add(btnStop);
        panelButtonMp3.add(btnNext);
        
        progressbar = new progressBar(0, 0);
        progressbar.setBounds(10, 130, 465, 60);
        panelCenter.add(progressbar);
        
        a.readList();
        clearList();
        updateList();
        setButton();
        
    }
    
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == JMOpen)
        {
            a.openFile(JMOpen);
            clearList();
            updateList();
            setButton();
        }
        else if(e.getSource() == btAdd)
        {
            a.openFile(JMOpen);
            clearList();
            updateList();
            setButton();
            
        }
        else if(e.getSource() == JMExit)
        {
            closeMp3();
        }
        else if(e.getSource() == JMAbout)
        {
            About abou = new About();
            abou.load();
        }
        else if(e.getSource() == JMHelp)
        {
            Help hp;
            hp = new Help("HELP");
            hp.setVisible(true);
            hp.setLocation(350,300);
            hp.setSize(300,200);
            
            hp.setResizable(true);
        }
        else if(e.getSource() == btnPause_1)
        {
        	if(!playOrPause){
        		if(previous_song==listSong.getSelectedIndex()){
        			int indexSong = a.getIndex();
                    a.pause();
                    lbStatus.setText("Now Playing : " + a.getName());
                    setButton();
                    listSong.select(indexSong +1);
                    if(!playOrPause){
                    	btnPause_1.setIcon(new ImageIcon(mp3Gui.class.getResource("/icon/NX2-Pause-icon.png")));
                        btnPause_1.setText("Pause");
                        btnPause_1.updateUI();
                        playOrPause = true;
                    }
                    else{
                    	btnPause_1.setIcon(new ImageIcon(mp3Gui.class.getResource("/icon/NX2-Play-icon.png")));
                        btnPause_1.setText("Play");
                        btnPause_1.updateUI();
                        playOrPause = false;
                    }
        		}
        		else{
        			progressbar=new progressBar(0, (int)a.getDuration().getSeconds());
        			a.setPrgressBar(progressbar);
        			int indexSong = listSong.getSelectedIndex();
                    a.play(indexSong);
                    previous_song = indexSong;
                    lbStatus.setText("Now Playing : " + a.getName());
                    setButton();
                    listSong.select(indexSong);
                    btnPause_1.setIcon(new ImageIcon(mp3Gui.class.getResource("/icon/NX2-Pause-icon.png")));
                    btnPause_1.setText("Pause");
                    btnPause_1.updateUI();
                    playOrPause = true;
        		}
        	}
        	else{
        		int indexSong = a.getIndex();
                a.pause();
                lbStatus.setText("Now Playing : " + a.getName() + " Paused");
                setButton();
                listSong.select(indexSong +1);
                btnPause_1.setIcon(new ImageIcon(mp3Gui.class.getResource("/icon/NX2-Play-icon.png")));
                btnPause_1.setText("Play");
                btnPause_1.updateUI();
                playOrPause = false;
        	}
        }
        else if(e.getSource() == btnStop)
        {
            a.stop();
            btnPause_1.setIcon(new ImageIcon(mp3Gui.class.getResource("/icon/NX2-Play-icon.png")));
            btnPause_1.setText("Play");
            btnPause_1.updateUI();
        }
        else if(e.getSource() == btnPrevious)
        {
            int indexSong = a.getIndex();
            a.play(indexSong-1);
            
            lbStatus.setText("Now Playing : " + a.getName());
            setButton();
            listSong.select(indexSong -1);
        }
        else if(e.getSource() == btnNext)
        {
            int indexSong = a.getIndex();
            a.play(indexSong+1);
            
            lbStatus.setText("Now Playing : " + a.getName());
            setButton();
            listSong.select(indexSong +1);
        }
        else if(e.getSource() == btRem)
        {
            int indexSong = listSong.getSelectedIndex();
            a.remove(indexSong);
            clearList();
            updateList();
            setButton();
            listSong.select(indexSong);
            
        }
        else if(e.getSource() == btJump)
        {
            jp = new Jump(a.getArrayList());
       
           jp.setSize(330,300);
           Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Dimension frameSize = jp.getSize();
            if (frameSize.height > screenSize.height) {
                frameSize.height = screenSize.height;
            }
            if (frameSize.width > screenSize.width) {
                frameSize.width = screenSize.width;
            }
            jp.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
           
           jp.setVisible(true);
        }
        else if(e.getSource() == btSave)
        {
            ArrayList tmp = a.getArrayList();
            tmp = Quicksort.quickSort(tmp,0,tmp.size()-1);
            a.resetIndex();
            clearList();
            a.setAr(tmp);
            updateList();
            listSong.select(0);
            
        }
            
    }
    
    
    public void setButton()
    {
        if(a.exist())
        {   
            listSong.select(0);
            btSave.setEnabled(true);
            btJump.setEnabled(true);
            btQueue.setEnabled(true);
            btnStop.setEnabled(true);
            btRem.setEnabled(true);
            
            if(a.getIndex() == 0)
            {
                btnPrevious.setEnabled(false);
            }
            else
            {
                btnPrevious.setEnabled(true);
            }
            
            if(a.getIndex() == a.getSize()-1)
            {
                btnNext.setEnabled(false);
            }
            else
            {
                btnNext.setEnabled(true);
            }
        }
        
    }
    public void updateList()
    {   
        ArrayList ar = (ArrayList)a.getArrayList();
        for(int i =0; i<ar.size();i++)
        {
            listSong.add((i+1) + ")" + ((Lagu)ar.get(i)).getName(),i);
        }
         a.saveList();
    }
    public void clearList()
    {
        listSong.removeAll();
    }
    public void closeMp3()
    {
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.dispose();
        System.exit(0);
    }
    public void play(int ind)
    {
        a.play(ind);
    }
    public void selectList(int in)
    {
        listSong.select(in);
    }
}
