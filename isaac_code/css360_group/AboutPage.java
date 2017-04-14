package css360_group;

import javax.swing.JOptionPane;
/*
 * Displays About window with authors' names.
 */
//4-14-17
public class AboutPage extends JOptionPane {

	String authors = "Zira Cook\nGarrett Lahmann\nDonald Muffler\n" + 
			"Yaro Salo\nIsaac Seemann";
	public AboutPage() {
		// TODO Auto-generated constructor stub
		AboutPage.showMessageDialog(getParent(), authors, "About", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void main(String[] args){
		new AboutPage();
	}

}
