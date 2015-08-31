package mathmarecette.jeu.ordre;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;

import mathmarecette.jeu.Recette.Recette;
import mathmarecette.menu.JFrameMenu;

public class JDialogOrdreRecette extends JDialog {

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 * 
	 */
	private static final long serialVersionUID = 1455793839848303622L;
	public JDialogOrdreRecette(JFrameMenu parent, Recette recette) {
		super(parent, recette.getNom(), true);
		this.parent = parent;
		this.recette = recette;
		geometry();
		control();
		appearance();
	}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry() {
		panelOrdreRecette = new JPanelOrdreRecette(recette, this,
				parent.getPanelRecette());
		setLayout(new BorderLayout());
		add(panelOrdreRecette, BorderLayout.CENTER);
	}

	private void control() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				parent.quitRecette();
			}
		});
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private void appearance() {
		// setPreferredSize(new Dimension(400, 300));
		pack();
		setLocationRelativeTo(null); // frame centrer
		setVisible(true); // last!

	}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private Recette recette;
	private JPanelOrdreRecette panelOrdreRecette;
	private JFrameMenu parent;
}
