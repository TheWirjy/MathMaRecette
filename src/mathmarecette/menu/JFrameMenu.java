
package mathmarecette.menu;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import mathmarecette.jeu.JPanelRecette;
import mathmarecette.jeu.Recette.Recette;
import mathmarecette.jeu.Recette.Spaghetti;

public class JFrameMenu extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 * 
	 */
	private static final long serialVersionUID = 2051497550641079298L;
	public JFrameMenu()
		{
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void recette(Recette _recette)
		{
		panelRecette.init(_recette);
		remove(panelLevel);
		add(panelRecette);
		revalidate();
		repaint();
		}

	public void quitRecette()
		{
		remove(panelRecette);
		add(panelMenu);
		repaint();
		}

	public void arcade()
		{

		}

	public void level()
		{
		remove(panelMenu);
		add(panelLevel);
		repaint();
		}

	public void tuto()
		{
		remove(panelMenu);
		add(panelTuto);
		repaint();
		}

	public void credit()
		{
		remove(panelMenu);
		add(panelCredit);
		repaint();
		}

	public void menu(JPanel panel)
		{
		remove(panel);
		add(panelMenu);
		repaint();
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public JPanelRecette getPanelRecette()
		{
		return panelRecette;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		// JComponent : Instanciation
		panelMenu = new JPanelMenu(this);
		panelCredit = new JPanelCredits(this);
		panelLevel = new JPanelLevel(this);
		panelRecette = new JPanelRecette(this, new Spaghetti());
		panelTuto = new JPanelTuto(this);

		// JComponent : Layout
		setLayout(new BorderLayout());

		add(panelMenu, BorderLayout.CENTER);

		}

	private void control()
		{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		}

	private void appearance()
		{
		/*Dimension dim = new Dimension(600, 700);
		setPreferredSize(dim);
		setSize(dim);
		setMaximumSize(dim);*/
		pack();
		setResizable(false);
		setLocationRelativeTo(null); // frame centrer
		setVisible(true); // last!
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JPanelMenu panelMenu;
	private JPanelLevel panelLevel;
	private JPanelCredits panelCredit;
	private JPanelRecette panelRecette;
	private JPanelTuto panelTuto;
	}
