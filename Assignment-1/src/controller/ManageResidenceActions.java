package controller;

import java.awt.event.ActionEvent;
import java.util.HashMap;

import javax.swing.AbstractAction;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import model.HousingType;
import model.Residence;
import model.User;
import view.CreateResidenceScreen;
import view.CustomOptionFrame;
import view.Gui;
import view.ManageProjectScreen;
import view.ManageResidenceScreen;

/**
 * Actions for the manage residence screen.
 * 
 * @author Donald Muffler
 * @version 20170525
 */
public final class ManageResidenceActions extends AbstractAction{

	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = -2588766063534303043L;

	/**
	 * User.
	 */
	private final User myUser;
	
	/**
	 * 
	 * @param theUser
	 */
	public ManageResidenceActions(final User theUser) {
		myUser = theUser;
	}
	
	/**
	 * Performs an action based on which button was pressed.
	 * 
	 * @author Donald Muffler
	 */
	@Override
	public void actionPerformed(final ActionEvent theEvent) {
		
		final String whichButton = theEvent.getActionCommand();
		
		switch(whichButton) {
			case "Back":
				Gui.getInstance().displayPanel("Home");
				break;
			case "Delete Residence":
			case "Choose Residence":
				HashMap<String, JCheckBox> tempMap1 = ManageResidenceScreen.getInstance().checkSelected();
				for (String resName: tempMap1.keySet()) {
					if (tempMap1.get(resName).isSelected()) {
						if (whichButton.equals("Delete Residence")) {
							myUser.removeResidence(resName);
						} else { // create
							myUser.setCurrentResidence(resName);
							myUser.getCurrentResidence().updateInfo();
							
							Gui.getInstance().displayPanel("Manage Projects");
						}
					}
				}
				break;
			case "Create Residence":
				CustomOptionFrame.getInstance().displayPanel("Create Residence");
				break;
			case "Create": // for create residence pane.
				boolean similarRes = false;
				for (Residence currentRes: myUser.getResidences()) {
					if (CreateResidenceScreen.getInstance().getResName().equals(currentRes.getName())) {
						similarRes = true;
					}
				}
				if (similarRes) {
			    	JOptionPane.showMessageDialog(null,"Residence " + CreateResidenceScreen.getInstance().getResName() 
			    			+ " already exists!", "Unable to Create Residence", JOptionPane.ERROR_MESSAGE);
					CustomOptionFrame.getInstance().displayPanel("Create Residence");
				} else {
					final Residence res = new Residence(CreateResidenceScreen.getInstance().getResName(),
							(HousingType) CreateResidenceScreen.getInstance().getResSelection().getSelectedItem());
					res.addObserver(ManageProjectScreen.getInstance());
					myUser.addResidence(res);
					myUser.setCurrentResidence(res.getName());
					myUser.getCurrentResidence().updateInfo();;
					CustomOptionFrame.getInstance().dispose();
					Gui.getInstance().displayPanel("Manage Projects");
				}
				break;
			case "Cancel": // for create residence pane.
				CustomOptionFrame.getInstance().dispose();
			break;
		}
	}
}