package mathmarecette.menu;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mathmarecette.Tools;
import mathmarecette.jeu.Recette.Cake;
import mathmarecette.jeu.Recette.Crepe;
import mathmarecette.jeu.Recette.Pizza;
import mathmarecette.jeu.Recette.Recette;
import mathmarecette.jeu.Recette.Salade;
import mathmarecette.jeu.Recette.Spaghetti;

public class JPanelLevel extends JPanel {

	/*------------------------------------------------------------------*\
		|*							Constructeurs							*|
		\*------------------------------------------------------------------*/

	/**
	 * 
	 */
	private static final long serialVersionUID = 2066725686365442599L;

	public JPanelLevel(JFrameMenu _parent) {
		this.parent = _parent;
		geometry();
		control();
		appearance();
	}

	/*------------------------------------------------------------------*\
		|*							Methodes Private						*|
		\*------------------------------------------------------------------*/

	private void geometry() {
		// JComponent : Instanciation

		spaghetti = new JLabel();
		crepe = new JLabel();
		cake = new JLabel();
		salade = new JLabel();
		pizza = new JLabel();

		pictures = new JLabel();
		labelRetour = new JLabel();

		// JComponent : Adaptation

		try {
			current = new java.io.File(".").getCanonicalPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String filename = current + "/Son/ClickJump.mp3";
		mp3 = new MP3(filename);

		iconSpaghetti = new ImageIcon(current + "\\Image\\BTNSpaghetti.png");
		spaghetti.setIcon(iconSpaghetti);

		iconPate = new ImageIcon(current + "\\Image\\BTNPate.png");
		crepe.setIcon(iconPate);

		iconCake = new ImageIcon(current + "\\Image\\BTNCake.png");
		cake.setIcon(iconCake);

		iconSalade = new ImageIcon(current + "\\Image\\BTNSalade.png");
		salade.setIcon(iconSalade);

		iconPizza = new ImageIcon(current + "\\Image\\BTNPizza.png");
		pizza.setIcon(iconPizza);

		ImageIcon iconPictures = new ImageIcon(current
				+ "\\Image\\font-niveau.png");
		pictures.setIcon(iconPictures);

		// JComponent : Layout

		setLayout(null);
		add(labelRetour);
		add(pictures);
		add(spaghetti);
		add(crepe);
		add(cake);
		add(salade);
		add(pizza);

	}

	private MouseAdapter monMouseListener(final JLabel level,
			final Recette recette) {
		return new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				level.setLocation(level.getX(), level.getY() + 10);
				if (click && dessus) {
					parent.recette(recette);
				}
				click = false;
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				click = true;
				dessus = true;
				level.setLocation(level.getX(), level.getY() - 10);
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
		};
	}

	private void control() {
		spaghetti
				.addMouseListener(monMouseListener(spaghetti, new Spaghetti()));
		crepe.addMouseListener(monMouseListener(crepe, new Crepe()));
		cake.addMouseListener(monMouseListener(cake, new Cake()));
		salade.addMouseListener(monMouseListener(salade, new Salade()));
		pizza.addMouseListener(monMouseListener(pizza, new Pizza()));

		labelRetour.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				labelRetour.setIcon(Tools.BOUTON_RETOUR);
				if (click && dessus) {
					parent.menu(JPanelLevel.this);
				}
				click = false;
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				click = true;
				dessus = true;
				labelRetour.setIcon(Tools.BOUTON_RETOUR_CLICK);
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
		Dimension panelD = new Dimension(600, 700);
		this.setSize(panelD);
		this.setPreferredSize(panelD);
		this.setMaximumSize(panelD);

		setBackground(Tools.COLOR_MENU);

		pictures.setSize(500, 155);
		pictures.setLocation(50, 500);

		labelRetour.setIcon(Tools.BOUTON_RETOUR);
		labelRetour.setSize(35, 35);
		labelRetour.setLocation(10, 10);

		Dimension dim = new Dimension(550, 107);

		salade.setPreferredSize(dim);
		salade.setSize(dim);
		salade.setLocation(getWidth() / 2 - dim.width / 2, 10);

		spaghetti.setPreferredSize(dim);
		spaghetti.setSize(dim);
		spaghetti.setLocation(getWidth() / 2 - dim.width / 2, 100);

		crepe.setPreferredSize(dim);
		crepe.setSize(dim);
		crepe.setLocation(getWidth() / 2 - dim.width / 2, 190);

		cake.setPreferredSize(dim);
		cake.setSize(dim);
		cake.setLocation(getWidth() / 2 - dim.width / 2, 280);

		pizza.setPreferredSize(dim);
		pizza.setSize(dim);
		pizza.setLocation(getWidth() / 2 - dim.width / 2, 370);
	}

	/*------------------------------------------------------------------*\
		|*							Attributs Private						*|
		\*------------------------------------------------------------------*/

	// Tools
	private JLabel spaghetti;
	private JLabel crepe;
	private JLabel cake;
	private JLabel salade;
	private JLabel pizza;
	private ImageIcon iconSpaghetti;
	private ImageIcon iconPate;
	private ImageIcon iconCake;
	private ImageIcon iconSalade;
	private ImageIcon iconPizza;
	private MP3 mp3;
	private String current;
	private boolean click = false;
	private boolean dessus = false;
	private JLabel pictures;
	private JFrameMenu parent;

	private JLabel labelRetour;

}
