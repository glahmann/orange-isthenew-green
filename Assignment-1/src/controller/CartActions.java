package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.Project;
import model.User;
import view.CartPane;
import view.CustomOptionFrame;

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

	private final User myUser;

	private final CartPane myCartPanel;

	public CartActions(final User theUser)  {
		myUser = theUser;
		myCartPanel = new CartPane();
	}

	/**
	 * 
	 */
	@Override
	public void actionPerformed(final ActionEvent theEvent) {
		final String whichButton = theEvent.getActionCommand();
		
		switch(whichButton) {
		    case "Complete":
		        final Project project = myUser.getCurrentResidence().getCurrentProject();
		        break;
			case "Cancel":
				CustomOptionFrame.getInstance().dispose();
				break;
			case "Remove":
				
				break;
				
		}
	}

}
