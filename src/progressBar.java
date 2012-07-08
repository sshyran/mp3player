import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JProgressBar;
import javax.swing.LayoutStyle.ComponentPlacement;


public class progressBar extends JPanel {
	private int nMinPos;
	private int nMaxPos;
	private int nCurPos;
	private JSlider slider;
	
	public progressBar ( int nMin, int nMax ) {
	super ();
	nMinPos = nMin;
	nMaxPos = nMax;
	if ( nMaxPos <= nMinPos )
	nMaxPos = nMinPos + 1;
	nCurPos = nMinPos;
	this.setBackground ( UIManager.getColor("Button.background") );
	
	slider = new JSlider(nMin, nMax);
	slider.setValue(0);
	GroupLayout groupLayout = new GroupLayout(this);
	groupLayout.setHorizontalGroup(
		groupLayout.createParallelGroup(Alignment.LEADING)
			.addGroup(groupLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(slider, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
				.addContainerGap())
	);
	groupLayout.setVerticalGroup(
		groupLayout.createParallelGroup(Alignment.LEADING)
			.addGroup(groupLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(266, Short.MAX_VALUE))
	);
	setLayout(groupLayout);
	}
	
	
	public int getMinPos () {
	return ( nMinPos );
	}
	
	
	public int getMaxPos () {
	return ( nMaxPos );
	}
	
	
	public int getCurPos () {
	return ( nCurPos );
	}
	
	
	public void setCurPos ( int nPos ){
	nCurPos = nPos;
	if ( nCurPos > nMaxPos )
	nCurPos = nMaxPos;
	if ( nCurPos < nMinPos )
	nCurPos = nMinPos;
	slider.setValue(nCurPos);
	}
		
	
	public int getCurPercent () {
		return ( 100 * (nCurPos - nMinPos) / (nMaxPos - nMinPos) );
	}
	
}
