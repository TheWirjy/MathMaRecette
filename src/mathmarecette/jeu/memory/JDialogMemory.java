
package mathmarecette.jeu.memory;

import javax.swing.JDialog;
import javax.swing.JFrame;

import mathmarecette.jeu.JPanelRecette;

public class JDialogMemory extends JDialog
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JDialogMemory(final JFrame parent)
		{
		super(parent, "Spaghetti", true);
		this.parent = parent;

		panelMemory = new JPanelMemory(this);

		panelInfo = new JPanelInfo(this);
		getContentPane().add(panelInfo);



		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		setLocation(parent.getX() + parent.getWidth() / 2 - panelInfo.getWidth() / 2, parent.getY() + parent.getHeight() / 2 - panelInfo.getHeight() / 2);
		setVisible(true);

		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void switchPanel()
		{
		getContentPane().remove(panelInfo);
		getContentPane().add(panelMemory);
		/*repaint();
		revalidate();*/
		pack();
		setLocation(parent.getX() + parent.getWidth() / 2 - panelMemory.getWidth() / 2, parent.getY() + parent.getHeight() / 2 - panelMemory.getWidth() / 2);
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	private JPanelMemory panelMemory;
	private JPanelInfo panelInfo;
	private JFrame parent;
	private JPanelRecette panelSave;
	}
