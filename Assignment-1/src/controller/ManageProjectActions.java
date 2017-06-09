package controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.AbstractAction;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import model.Bill;
import model.Calc;
import model.Item;
import model.Market;
import model.Project;
import model.User;
import view.BillPane;
import view.CartPane;
import view.CreateProject;
import view.CreateResidenceScreen;
import view.CustomOptionFrame;
import view.Gui;
import view.ManageProjectScreen;
import view.ProjectMarket;

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
	 * @param theUser the currently signed in user
	 */
	public ManageProjectActions(final User theUser) {
		myUser = theUser;
	}
	
	/**
	 * Performs an action based on which button was pressed.
	 * 
	 * @author Donald Muffler
	 * @author Garrett Lahmann
	 */
	@Override
	public void actionPerformed(final ActionEvent theEvent) {
		
		final String whichButton = theEvent.getActionCommand();
		switch(whichButton) {
			case "Back":
				myUser.updateInfo();
				Gui.getInstance().displayPanel("Manage Residences");
				break;
			case "Back To Projects":
				myUser.getCurrentResidence().updateInfo();
				Gui.getInstance().displayPanel("Manage Projects");
				break;
			case "Delete Project":
			case "Open Project":
				HashMap<String, JCheckBox> tempMap = ManageProjectScreen.getInstance().checkSelected();
				for (String proName: tempMap.keySet()) {
					if (tempMap.get(proName).isSelected()) {
						if (whichButton.equals("Delete Project")) {
							myUser.getCurrentResidence().removeProject(proName);
						} else {
							myUser.getCurrentResidence().setCurrentProject(proName);
							Gui.getInstance().displayPanel("Market");
						}
					}
				}
				break;
			case "Create Project":
				CustomOptionFrame.getInstance().displayPanel("Create Project");
				break;
			case "Create": // for create project pane.
				boolean similarPro = false;
				for (Project currentPro: myUser.getCurrentResidence().getProjects()) {
					if (currentPro.getName().equals(CreateProject.getInstance().getProjectName())) {
						similarPro = true;
					}
				}
				if (similarPro) {
			    	JOptionPane.showMessageDialog(null,"Project " + CreateProject.getInstance().getProjectName() 
			    			+ " already exists!", "Unable to Create Project", JOptionPane.ERROR_MESSAGE);
					CustomOptionFrame.getInstance().displayPanel("Create Project");
				} else {
					final Project pro = new Project(CreateProject.getInstance().getProjectName());
					myUser.getCurrentResidence().addProject(pro);
					myUser.getCurrentResidence().setCurrentProject(pro.getName());
	                CustomOptionFrame.getInstance().dispose();
					Gui.getInstance().displayPanel("Market");	
				}
				break;
			case "Enter an Energy Bill?":
			case "Add Energy Bill" :
				CustomOptionFrame.getInstance().displayPanel("Bill Pane");
				break;
			case "Cancel":
				CustomOptionFrame.getInstance().dispose();
			break;
			case "Add Bill" :
				CustomOptionFrame.getInstance().dispose();
				final Bill bill = new Bill(BillPane.getInstance().getBillCost(),
						BillPane.getInstance().getStartMonth(),
						BillPane.getInstance().getStarYear(),
						BillPane.getInstance().getEndMonth(),
						BillPane.getInstance().getEndYear(),
						BillPane.getInstance().getEnergyUsage());
				myUser.getCurrentResidence().addBill(bill);
				break;
			case "ADD TO PROJECT":
			    final Market market = ProjectMarket.getInstance().getMarket();
			    final ArrayList<Item> selected = market.getSelected();
			    final Project projectUp = myUser.getCurrentResidence().getCurrentProject();
			    projectUp.addToSavings(Calc.calculate(new ArrayList<Item>(selected)) * 1.1);
			    for (Item i: selected) {
			        projectUp.addItem(i);
			        projectUp.addToCost(i.getCost());
			    }
			    market.resetDropDowns(); 
			    break;
			case "VIEW PROJECT ITEMS":
			    CartPane.getInstance().buildItemList(myUser.getCurrentResidence().getCurrentProject().getItems());
			    CustomOptionFrame.getInstance().displayPanel("Inventory");
			    break;
            
		}
	}
}