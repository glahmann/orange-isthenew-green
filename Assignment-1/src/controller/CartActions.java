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
 * @version 6/6/2017
 */
public class CartActions extends AbstractAction{


	/**Serial ID*/
	private static final long serialVersionUID = 2594837122483831137L;

	private final User myUser;
	/**Project cart is modifying*/
	private final Project myProject;

	private final CartPane myCartPanel;

	public CartActions(final User user)  {
		myUser = user;
		myProject = user.getCurrentResidence().getCurrentProject();
		myCartPanel = new CartPane();
	}

	@Override
	public void actionPerformed(final ActionEvent theEvent) {
		final String whichButton = theEvent.getActionCommand();

		switch(whichButton) {

			case "Cancel":
				CustomOptionFrame.getInstance().dispose();
				break;
			case "Remove":
				
				break;
				
		}
	}

}
