/**
 * 
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import Controller.JSONSupport;
import Model.User;

/**
 * @author Garrett Lahmann
 *
 */
public class DisplayPanel extends JPanel implements Observer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1809848172144535006L;

	/**
	 * 
	 */
	private static final int SCALE = 20;
	
	/**
	 * 
	 */
	private User myUser;
	
	/**
	 * 
	 */
	public DisplayPanel() {
		super();
		myUser = new User("No User", " ");
	}
	
	/**
     * Paints shapes to the canvas.
     * 
     * @param theGraphic    the graphic.
     */
    @Override
    public void paintComponent(final Graphics theGraphic) {
        super.paintComponent(theGraphic);
        final Graphics2D g2d = (Graphics2D) theGraphic;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                               RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setFont(new Font("TimesRoman", Font.BOLD, SCALE));
        g2d.setPaint(Color.BLACK);
        
        g2d.drawString("Username: " + myUser.getName(), 0, SCALE);
        g2d.drawString("Email: " + myUser.getEmail(), 0, SCALE * 2);
    } 
	
	// TODO fixfixfixfixfix bad coupling
    public void updatePanel(String theEmail) {
    	File userFile = new File(theEmail + ".json");
    	if (userFile.exists()) {
    		myUser = JSONSupport.readJSON(userFile);
        	repaint();
    	}
    }
    
    
	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

}
