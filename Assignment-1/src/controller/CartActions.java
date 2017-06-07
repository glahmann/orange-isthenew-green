package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.Project;
import model.User;
import view.CartPane;

public class CartActions extends AbstractAction{
	
	
	/**Serial ID*/
	private static final long serialVersionUID = 2594837122483831137L;
	/**Project cart is modifying*/
	private final User myUser;
	
	private final CartPane myCartPanel;
	
	public CartActions(final User theUser)  {
		myUser = theUser;
	    myProject = theProject;
		myCartPanel = new CartPane();
	}

	@Override
	public void actionPerformed(final ActionEvent theEvent) {
		theEvent.getActionCommand();
		
	}

}
