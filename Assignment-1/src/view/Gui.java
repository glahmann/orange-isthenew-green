package view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

/**
 * User Interface for application.
 * 
 * @author Donald Muffler
 * @author Zira Cook
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
	 * Initial size for home screen.
	 */
	private Dimension myHomeScreenSize;
    
    /**
     * Size of email text field.
     */
    private static final int TEXT_FIELD_SIZE = 15;
	
	/**
	 * Menu bar that contains File.
	 */
	private final JMenuBar myMenu;

	/**
	 * Menu item that displays the current user email.
	 */
	private JMenuItem myUserMenuItem;
	
	/**
	 * Constructor for Gui.
	 */
	public Gui() {
		//Set up home screen
		double screenSizeX = SCREEN_SIZE.getWidth() / 2;
		double screenSizeY = SCREEN_SIZE.getHeight() / 1.5;
		myHomeScreenSize = new Dimension((int)screenSizeX, (int)screenSizeY);
		setPreferredSize(myHomeScreenSize);
		//myCenterPanel = new DisplayPanel(); 	// TODO Maybe not necessary.

		//Set up menu bar
		myMenu = new JMenuBar();
		myUserMenuItem = new JMenuItem("Defualt");
		myUserMenuItem.setEnabled(false);
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

		final String enteredEmail = emailText.getText();

		if(!enteredEmail.equals("")) {
			myUserMenuItem.setText(enteredEmail);
		}
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

		final JMenu userMenu = new JMenu("User");
		userMenu.setMnemonic('U');
		userMenu.add(myUserMenuItem);

		myMenu.add(fileMenu);
		myMenu.add(userMenu);
	}
	
	/**
	 * Creates the home page.
	 */
	private final void homePage() {
		add(HomeScreen.getInstance());
	}
	
	/**
	 * Centers the frame on the screen.
	 */
    private void setCentered() {
        
        setLocation(SCREEN_SIZE.width / 2 - getWidth() / 2, 
        		SCREEN_SIZE.height / 2 - getHeight() / 2);
    }

	/**
	 * Updates the name of the user, in the User menu item.
	 * @param theEmail
     */
    public void updateDisplay(String theEmail) {
		myUserMenuItem.setText(theEmail);
    }
    
    /**
     * 
     */
	@Override
	public void update(Observable theO, Object theArg) {
		// TODO Auto-generated method stub
		
	}
}