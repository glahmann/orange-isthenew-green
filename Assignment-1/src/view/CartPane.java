package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.Action;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Item;

import java.awt.Font;
import javax.swing.JTextArea;
import java.util.ArrayList;

/**
 * Cart of items in current project
 * @author Isaac Seemann
 * @version 6/1/17
 */
public class CartPane extends JPanel{

	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = -2485671318578007289L;

	/**
	 * Singleton for the cart.
	 */
	private static CartPane myCart = null;

	/**
	 * Item summary.
	 */
	private JTextArea myItemSummaryArea;

	/**
	 * Confirm button.
	 */
	private JButton myConfirmButton;

	/**
	 * Remove button.
	 */
	private JButton myRemoveButton;

	/**
	 * Cancel button.
	 */
	private JButton myCancelButton;

	/**
	 * Cart title label.
	 */
	private JLabel myCartTitleLabel;

	/**
	 * Item list.
	 */
	private JList<String> myItemList;

	/**
	 * Item scroll pane.
	 */
	private JScrollPane myItemScrollPane;

	/**
	 * Item array.
	 */
	private ArrayList<Item> myItemArray;

	/**
	 * Create the panel.
	 */
	public CartPane() {

		myItemSummaryArea = new JTextArea();
		myRemoveButton = new JButton("Remove");
		myConfirmButton = new JButton("OK");
		myCancelButton = new JButton("Cancel");
		myItemList = new JList<>();
		myCartTitleLabel = new JLabel("Project Items");
		myItemScrollPane = new JScrollPane(myItemList);
		buildCart();
		setListListener();
	}

	/**
	 * Getter for the cart panel.
	 * @return the cart.
	 */
	public final static CartPane getInstance() {
		if (myCart == null) {
			myCart = new CartPane();
		}
		return myCart;
	}

	/**
	 * Add GUI components to the cart JPanel.
	 */
	private final void buildCart() {
		this.setBackground(Color.GREEN);
		myItemScrollPane.setPreferredSize(getPreferredSize());
		myItemSummaryArea.setFont(new Font("Monospaced", Font.PLAIN, 18));

		setLayout(new MigLayout("", "[150px][150px][150px]", "[75px][75px][75px][75px]"));

		myCartTitleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		add(myCartTitleLabel, "flowy,cell 1 0,growx");

		myConfirmButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		myRemoveButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		myCancelButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(myItemScrollPane, "cell 0 1,grow,span 2 2");
		add(myItemSummaryArea, "cell 2 1,grow,spany 2");
		add(myCancelButton, "cell 0 3");
		add(myRemoveButton, "cell 2 3");
		add(myConfirmButton, "cell 1 3");	

	}

	/**
	 * Build cart item list from Project Item content.
	 * @param theItemList
	 */
	public final void buildItemList(ArrayList<Item> theItemList){
		myItemArray = theItemList;
		String[] newItemList = new String[theItemList.size()];

		for(int i = 0; i < theItemList.size(); i++){
			newItemList[i] = theItemList.get(i).getName();
		}
		myItemList.setListData(newItemList);
		myItemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		myItemList.clearSelection();
		myRemoveButton.setEnabled(false);
	}
	/**
	 * Update JTextArea with summary of selected item
	 * @param index of item in cart list
	 */
	public final void displayItemSummary(int theItemIndex){
		if(theItemIndex == -1){
			myItemSummaryArea.setText("");
		}
		else{
			Item displayItem = myItemArray.get(theItemIndex);
			String summary = displayItem.toString();
			myItemSummaryArea.setText(summary);
		}
	}
	/**
	 * Get Index values of items user has selected for removal
	 * @return Array of indices
	 */
	public final int getSelectedItemIndex(){
		return myItemList.getSelectedIndex();
	}
	/**
	 * Add actionListeners to buttons
	 * @param Cart controller passed from Main
	 */
	public final void setAction(final Action theAction) {
		myRemoveButton.addActionListener(theAction);
		myConfirmButton.addActionListener(theAction);
		myCancelButton.addActionListener(theAction);
	}
	/**
	 * Add ListSelectionListener to list of items
	 */
	public final void setListListener(){
		myItemList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent listAction) {
				if (!listAction.getValueIsAdjusting()) {
					if(myItemList.isSelectionEmpty()){
						myRemoveButton.setEnabled(false);
					}
					else{
						System.out.println(myItemList.getSelectedIndex());
						myRemoveButton.setEnabled(true);
						displayItemSummary(myItemList.getSelectedIndex());
					}	
				}
			}
		});
	}
}