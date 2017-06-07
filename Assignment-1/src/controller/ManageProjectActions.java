package controller;

import java.awt.event.ActionEvent;
import java.util.HashMap;

import javax.swing.AbstractAction;
import javax.swing.JCheckBox;

import model.Project;
import model.User;
import view.CreateProject;
import view.CustomOptionFrame;
import view.Gui;
import view.ManageProjectScreen;

/**
 * Actions for the manage residence screen.
 * 
 * @author Donald Muffler
 * @version 20170525
 */
public final class ManageProjectActions extends AbstractAction{

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
	 * @param theAction
	 */
	public ManageProjectActions(final User theUser) {
		myUser = theUser;
	}
	
	@Override
	public void actionPerformed(final ActionEvent theEvent) {
		
		final String whichButton = theEvent.getActionCommand();
		
		switch(whichButton) {
			case "Back":
				myUser.updateInfo();
				Gui.getInstance().displayPanel("Manage Residences");
				break;
			case "Delete Project":
			case "Open Project":
				HashMap<String, JCheckBox> tempMap = ManageProjectScreen.getInstance().checkSelected();
				for (String proName: tempMap.keySet()) {
					if (tempMap.get(proName).isSelected()) {
						if (whichButton.equals("Delete Project")) {
							myUser.getCurrentResidence().removeProject(proName);
						} else {
							myUser.setCurrentResidence(proName);
							Gui.getInstance().displayPanel("Market");
						}
					}
				}
				break;
			case "Create Project":
				CustomOptionFrame.getInstance().displayPanel("Create Project");
				break;
			case "Create": // for create project pane.
				final Project pro = new Project(CreateProject.getInstance().getProjectNameField().getText());
				myUser.getCurrentResidence().addProject(pro);
                CustomOptionFrame.getInstance().dispose();
                break;
		}
	}
}