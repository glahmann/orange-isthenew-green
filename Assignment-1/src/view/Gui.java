package view;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import net.miginfocom.layout.LC;
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
     * Home button size.
     */
    private static final Dimension HOME_BUTTON_SIZE = new Dimension(200, 200);

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

	private JButton myCreateProjectButton;

	private JButton myOpenProjectButton;

	private JButton myManageProjectButton;

	private JButton myManageResidenceButton;

	private JButton myChangeResidenceButton;

	private JButton myExitSaveButton;
	
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
		final JPanel homePanel = new JPanel(new MigLayout(new LC().align("center", "center")));
		final JPanel homeButtonPanel = new JPanel(new MigLayout(new LC().wrapAfter(3)));
		final Action homeAction = new HomeActions();

		List<JButton> buttonList = new ArrayList<>();

		myCreateProjectButton = new JButton("Create Project");
		buttonList.add(myCreateProjectButton);

		myOpenProjectButton = new JButton("Open Project");
		buttonList.add(myOpenProjectButton);

		myManageProjectButton = new JButton("Manage Projects");
		buttonList.add(myManageProjectButton);

		myManageResidenceButton = new JButton("Manage Residences");
		buttonList.add(myManageResidenceButton);

		myChangeResidenceButton = new JButton("Change Residences");
		buttonList.add(myChangeResidenceButton);

		myExitSaveButton = new JButton("Exit/Save");
		buttonList.add(myExitSaveButton);

		for (JButton homeButton: buttonList) {
			homeButton.setPreferredSize(HOME_BUTTON_SIZE);
			homeButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
			homeButton.addActionListener(new HomeButtonListener());
			homeButtonPanel.add(homeButton);
		}

		homePanel.setBackground(Color.GREEN);
		homeButtonPanel.setBackground(Color.ORANGE);

		/*
		addHomeButtons("Create Project", homeAction, homeButtonPanel);
		addHomeButtons("Open Project", homeAction, homeButtonPanel);
		addHomeButtons("Manage Projects", homeAction, homeButtonPanel);
		addHomeButtons("Manage Residences", homeAction, homeButtonPanel);
		addHomeButtons("Change Residence", homeAction, homeButtonPanel);
		addHomeButtons("Exit/Save", homeAction, homeButtonPanel);
		*/

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

	/**
	 * Assigns behavior to home screen buttons.
	 */
	class HomeButtonListener implements ActionListener {

		@Override
		public void actionPerformed(final ActionEvent theEvent) {

			if (theEvent.getSource() == myCreateProjectButton) {
				int correct = createProject();

			}

			if (theEvent.getSource() == myOpenProjectButton) {

			}

			if (theEvent.getSource() == myManageProjectButton) {

			}

			if (theEvent.getSource() == myManageResidenceButton) {

			}

			if (theEvent.getSource() == myChangeResidenceButton) {

			}

			if (theEvent.getSource() == myExitSaveButton) {
				int exit = JOptionPane.showConfirmDialog(Gui.this, "Would you like to exit?", "Leaving so soon?",
						JOptionPane.YES_NO_OPTION);

				//Close the program if "yes" option is picked
				if (exit == 0) {
					System.exit(0);
				}
			}


		}

		/**
		 * Creates a new project.
		 * @return 0 for a successful creation, 1 if there was a user error.
         */
		public int createProject() {
			//Setup for new project screen
			final JPanel newProjectPanel = new JPanel(new MigLayout());
			newProjectPanel.add(new JLabel("Project Name: "));

			final JTextField projectNameBox = new JTextField(TEXT_FIELD_SIZE);
			newProjectPanel.add(projectNameBox);
			final JButton enterBillButton = new JButton("Enter an Energy Bill?");
			newProjectPanel.add(enterBillButton, "cell 1 1");

			enterBillButton.setBorderPainted(false);
			enterBillButton.setContentAreaFilled(false);
			enterBillButton.setForeground(Color.BLUE);

			//If user wants to enter an energy bill
			final Action newUserAction = new BillPane(Gui.this);
			enterBillButton.addActionListener(newUserAction);

			JOptionPane.showMessageDialog(Gui.this, newProjectPanel);

			final String enteredProjectName = projectNameBox.getText();

			if(enteredProjectName.equals("")) {
				return 1;
			}

			return 0;
		}
	}

}