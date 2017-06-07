package controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;

import model.Item;
import model.Project;
import model.User;
import view.CartPane;
import view.CustomOptionFrame;

/**
 * Action controller for cart pane and cart model.
 * 
 * @author Isaac Seemann
 * @version 6/6/2017
 */
public class CartActions extends AbstractAction{


	/**Serial ID*/
	private static final long serialVersionUID = 2594837122483831137L;

	private final User myUser;
	/**Project that cart is modifying*/
	private Project myProject = null;
	/**Cart gui*/
	private CartPane myCartPanel = null;
	
	/**Cart controller constructor*/
	public CartActions(final User user)  {
		myUser = user;
	}

	@Override
	public void actionPerformed(final ActionEvent theEvent) {
		final String whichButton = theEvent.getActionCommand();

		switch(whichButton) {
		    case "VIEW CART":
		    	myProject = myUser.getCurrentResidence().getCurrentProject();
		    	myCartPanel = new CartPane();
			case "Cancel":
				CustomOptionFrame.getInstance().dispose();
				break;
			case "Remove":
				ArrayList<Item> projItems = myProject.getItems();
				int[] removalIndices = myCartPanel.getSelectedItemIndices();
				for(int idx : removalIndices){
					myProject.removeItem(projItems.get(idx));
				}
				break;
				
		}
	}

}
