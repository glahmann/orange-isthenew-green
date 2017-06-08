package controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;

import model.Item;
import model.Project;
import model.User;
import view.CartPane;
import view.CustomOptionFrame;
import view.Gui;

/**
 * Action controller for cart pane and cart model.
 * 
 * @author Isaac Seemann
 * @author Garrett Lahmann
 * @version 6/6/2017
 */
public class CartActions extends AbstractAction{


	/**Serial ID*/
	private static final long serialVersionUID = 2594837122483831137L;

	/**
	 * The user.
	 */
	private final User myUser;


	/**Cart gui*/
	private final CartPane myCartPanel;

	/**
	 * Constructs the action.
	 * @param theUser the user.
	 */
	public CartActions(final User theUser)  {
		myUser = theUser;
		myCartPanel = CartPane.getInstance();
	}

	/**
	 * Performs an action based on which button was pressed.
	 * @param  theEvent The action event.
	 */
	@Override
	public void actionPerformed(final ActionEvent theEvent) {
		final String whichButton = theEvent.getActionCommand();
		final Project project = myUser.getCurrentResidence().getCurrentProject();
		switch(whichButton) {

		case "Cancel":
			CustomOptionFrame.getInstance().dispose();
			break;
		case "Remove":
			ArrayList<Item> projItems = project.getItems();
			int removalIndex = myCartPanel.getSelectedItemIndex();
			System.out.println(removalIndex);
			//System.out.println("Remove " + projItems.get(removalIndex) + "-> " + project.getItems().size());
			if(removalIndex >= 0){
				project.removeItem(projItems.get(removalIndex));
				myCartPanel.buildItemList(project.getItems());
				myCartPanel.displayItemSummary(-1);
				myCartPanel.repaint();
			}
			break;
		case "OK":
			Gui.getInstance().displayPanel("Manage Projects");
			CustomOptionFrame.getInstance().dispose();
		}
	}
}