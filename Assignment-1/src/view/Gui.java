package view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import net.miginfocom.layout.LC;
import net.miginfocom.swing.MigLayout;

/**
 * User Interface for application.
 * 
 * @author Donald Muffler
 * @author 
 * @author
 * @version 20170516
 */
final public class Gui extends JFrame implements Observer{

    /**
	 * Generated Serial ID.
	 */
	private static final long serialVersionUID = -2373129258052117658L;

	/** 
     * ToolKit. 
     */
    private static final Toolkit KIT = Toolkit.getDefaultToolkit();
    
    /** 
     * Dimensions of the screen.
     */
    private static final Dimension SCREEN_SIZE = KIT.getScreenSize();
    
    /**
     * Home button size.
     */
    private static final Dimension HOME_BUTTON_SIZE = new Dimension(200, 200);
    
    /**
     * Size of email text field.
     */
    private static final int TEXT_FIELD_SIZE = 15;
	
	/**
	 * Menu bar that contains File.
	 */
	private final JMenuBar myMenu;
	
	/**
	 * Main panel. TODO Change.
	 */
	private DisplayPanel myCenterPanel;
	
	/**
	 * Constructor for Gui.
	 */
	public Gui() {
		setPreferredSize(new Dimension(1000, 1000));
		//myCenterPanel = new DisplayPanel(); 	// TODO Maybe not necessary.
		myMenu = new JMenuBar();
	}
	
	/**
	 * Creates the Gui and its components.
	 */
	public final void start() {
		login();
		buildFileMenu();
		homePage();
		
		setJMenuBar(myMenu);
		//add(myCenterPanel, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setCentered();
		setVisible(true);
	}
	
	/**
	 * Creates the login menu.
	 */
	private final void login() {
		
		final JPanel loginPanel = new JPanel(new MigLayout());
		loginPanel.add(new JLabel("Email"));
		final JTextField emailText = new JTextField(TEXT_FIELD_SIZE);
		loginPanel.add(emailText);
		final JButton newUserButton = new JButton("New User?");
		loginPanel.add(newUserButton, "cell 1 1");
		
		newUserButton.setBorderPainted(false);
		newUserButton.setContentAreaFilled(false);
		newUserButton.setForeground(Color.BLUE);
		
		final Action newUserAction = new SetupPane(this);
		newUserButton.addActionListener(newUserAction);
		
		JOptionPane.showMessageDialog(this, loginPanel);
	}
	
	/**
	 * Builds the file menu.
	 */
	private final void buildFileMenu() {
		final JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');
		
		// Make login option
		final Action loginAction = new LoginPane(this);
		final JMenuItem loginMenuItem = new JMenuItem(loginAction);
		loginMenuItem.setMnemonic('L');
		fileMenu.add(loginMenuItem);
		
		// Make setup option
		final Action setupAction = new SetupPane(this);
		final JMenuItem setupMenuItem = new JMenuItem(setupAction);
		setupMenuItem.setMnemonic('S');
		fileMenu.add(setupMenuItem);
		
		// Make about option
		final Action aboutAction = new AboutPane(this);
		final JMenuItem aboutMenuItem = new JMenuItem(aboutAction);
		aboutMenuItem.setMnemonic('A');
		fileMenu.add(aboutMenuItem);	
		
		myMenu.add(fileMenu);
	}
	
	/**
	 * Creates the home page.
	 */
	private final void homePage() {
		final JPanel homePanel = new JPanel(new MigLayout(new LC().align("center", "center")));
		final JPanel homeButtonPanel = new JPanel(new MigLayout(new LC().wrapAfter(3)));
		final Action homeAction = new HomeActions();
		
		homePanel.setBackground(Color.GREEN);
		homeButtonPanel.setBackground(Color.ORANGE);
		
		addHomeButtons("Create Project", homeAction, homeButtonPanel);
		addHomeButtons("Open Project", homeAction, homeButtonPanel);
		addHomeButtons("Manage Projects", homeAction, homeButtonPanel);
		addHomeButtons("Manage Residences", homeAction, homeButtonPanel);
		addHomeButtons("Change Residence", homeAction, homeButtonPanel);
		addHomeButtons("Exit/Save", homeAction, homeButtonPanel);
		
		homePanel.add(homeButtonPanel);
		add(homePanel);
	}
	
	/**
	 * Adds buttons to the home button panel.
	 * @param theString name of the button.
	 * @param theAction connects button to action.
	 * @param thePanel the button panel.
	 * @return JButton representing the newly created home button.
	 */
	private final JButton addHomeButtons(final String theString, final Action theAction, final JPanel thePanel) {
		
		final JButton homeButton = new JButton(theString);
		homeButton.setPreferredSize(HOME_BUTTON_SIZE);
		homeButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		homeButton.addActionListener(theAction);
		thePanel.add(homeButton);
		return homeButton;
	}
	
	/**
	 * Centers the frame on the screen.
	 */
    private void setCentered() {
        
        setLocation(SCREEN_SIZE.width / 2 - getWidth() / 2, 
        		SCREEN_SIZE.height / 2 - getHeight() / 2);
    }

    // TODO fix badbadbadbad coupling
    public void updateDisplay(String theEmail) {
    	myCenterPanel.updatePanel(theEmail);
    }
    
    /**
     * 
     */
	@Override
	public void update(Observable theO, Object theArg) {
		// TODO Auto-generated method stub
		
	}   
}