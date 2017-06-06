package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;

import model.Item;

import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.awt.GridLayout;

/**
 * Cart of items in current project
 * @author Isaac
 * @version 6/1/17
 */
public class CartPane extends JPanel implements Observer{
	
	private static CartPane myCart = null;

	private JTextArea myCartSumText;
	
	private JButton myRemoveButton;
	
	private JLabel myCartTitleLabel;
	
	private JList<String> myItemList;
	
	private JScrollPane myItemScrollPane;
	
	private JButton myConfirmButton;
	
	/**
	 * Create the panel.
	 */
	public CartPane() {
		
		myCartSumText = new JTextArea();
		myRemoveButton = new JButton("Remove Item");
		myConfirmButton = new JButton("OK");
		myItemList = new JList<>();
		myCartTitleLabel = new JLabel("Project Items");
		myItemScrollPane = new JScrollPane(myItemList);
		buildCart();
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
		myCartSumText.setFont(new Font("Monospaced", Font.PLAIN, 18));
		
		myConfirmButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		setLayout(new MigLayout("", "[150px][150px][150px]", "[75px][75px][75px][75px]"));
		
		
		myCartTitleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		add(myCartTitleLabel, "flowy,cell 1 0,growx");
		
		myRemoveButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(myItemScrollPane, "cell 0 1,grow,span 2 2");
		add(myCartSumText, "cell 2 1,grow,spany 2");
		add(myRemoveButton, "cell 2 3,growx");
		add(myConfirmButton, "cell 1 3,growx");
		
		
		
		
		

    }
    /**
     * Build cart item list from Project Item content.
     * @param theItemList
     */
    public final void buildItemList(ArrayList<Item> theItemList){
    	String[] newItemList = new String[theItemList.size()];
    	
    	for(int i = 0; i < theItemList.size(); i++){
    		newItemList[i] = theItemList.get(i).toString();
    	}
    	myItemList.setListData(newItemList);
    	myItemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    	myItemList.clearSelection();
    	myRemoveButton.setEnabled(false);
    }
    
    public final void buildCartSummary(){
    	
    }
    
    public final void setAction(final Action theAction) {
    	myRemoveButton.addActionListener(theAction);
    	myConfirmButton.addActionListener(theAction);
    	myItemList.addListSelectionListener(arg0);
    }

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}
