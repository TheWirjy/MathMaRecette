package mathmarecette.jeu.panel.game.composant.composant;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mathmarecette.jeu.panel.game.composant.JPanelJeu;

public class JPanelIntroRecette extends JPanel {

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 * 
	 */
	private static final long serialVersionUID = 3732205656497898409L;
	public JPanelIntroRecette(JPanelJeu jeu) {
		this.panelJeu = jeu;
		geometry();
		control();
		appearance();
	}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void setSplash(ImageIcon image) {
		labelSplash.setIcon(image);
		labelSplash.setVisible(true);
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

	private void geometry() {
		// JComponent : Instanciation
		labelSplash = new JLabel();
		buttonValider = new JLabel();

		setLayout(null);

		// JComponent : add
		add(buttonValider);
		setComponentZOrder(buttonValider, 0);
		add(labelSplash);
		setComponentZOrder(labelSplash, 1);

	}

	private void control() {
		buttonValider.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if (click && dessus) {
					setVisible(false);
					panelJeu.startRecette();
				}
				click = false;
				buttonValider.setIcon(BOUTON);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				buttonValider.setIcon(BOUTON_CLICK);
				click = true;
				dessus = true;
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				dessus = false;
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				dessus = true;
			}
		});
	}

	private void appearance() {
		Dimension dim = new Dimension(600, 500);

		setPreferredSize(dim);
		setSize(dim);
		setLocation(0, 15);
		setOpaque(false);

		labelSplash.setPreferredSize(dim);
		labelSplash.setSize(dim);
		labelSplash.setLocation(0, 0);

		Dimension dim2 = new Dimension(150, 100);
		buttonValider.setPreferredSize(dim2);
		buttonValider.setSize(dim2);
		buttonValider.setLocation(getWidth() / 2 - dim2.width / 2, 290);
		buttonValider.setIcon(BOUTON);
	}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JLabel labelSplash;
	private JLabel buttonValider;
	private JPanelJeu panelJeu;
	private final ImageIcon BOUTON = new ImageIcon(
			".\\image\\splach\\bouton.png");
	private final ImageIcon BOUTON_CLICK = new ImageIcon(
			".\\image\\splach\\bouton_click.png");
	private boolean click = false;
	private boolean dessus = false;
}
