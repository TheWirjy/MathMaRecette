package mathmarecette.jeu;

import java.awt.Dimension;

import javax.swing.JFrame;

public class JFrameRecette extends JFrame {

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 * 
	 */
	private static final long serialVersionUID = 2955508403338773778L;

	public JFrameRecette() {
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

	public JPanelRecette getPanelRecette() {
		return panelRecette;
	}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry() {
		// JComponent : Instanciation
		// panelRecette = new JPanelRecette(this, recette);
		panelRecette.setPreferredSize(new Dimension(590, 690));

		// JComponent : add
		setContentPane(panelRecette);
	}

	private void control() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void appearance() {
		pack();
		setTitle("Math ma recette");
		setResizable(false);
		setLocationRelativeTo(null); // frame centrer
		setVisible(true);
	}

	/*------------------------------------------------------------------*\
		|*							Attributs Private						*|
		\*------------------------------------------------------------------*/

	// Tools
	private JPanelRecette panelRecette;

}
