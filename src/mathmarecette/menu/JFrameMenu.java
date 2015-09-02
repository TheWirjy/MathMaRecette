
package mathmarecette.menu;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import mathmarecette.Tools;
import mathmarecette.jeu.Recette.Recette;
import mathmarecette.jeu.panel.game.JPanelArcade;
import mathmarecette.jeu.panel.game.JPanelRecette;

public class JFrameMenu extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 * JFrame menu Frame principal
	 */
	private static final long serialVersionUID = 2051497550641079298L;

	public JFrameMenu()
		{
		arcade = false;
		geometry();
		control();
		appearance();
		Tools.playSon("./Son/menu.wav");

		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	//mute le son
	//synchronisation des icone
	public void setMute(boolean mute)
		{
		panelMenu.setMute(mute);
		panelRecette.setMute(mute);
		panelArcade.setMute(mute);
		}

	//start la question de l horloge
	public void questionBonus()
		{
		if (arcade)
			{
			panelArcade.startQuestionBonus();
			}
		else
			{
			panelRecette.startQuestionBonus();
			}
		}

	//lance une recette passer en parametre
	public void recette(Recette _recette)
		{
		arcade = false;
		panelRecette.init(_recette);
		remove(panelLevel);
		add(panelRecette);
		revalidate();
		repaint();
		}

	//lorsque on quitte une recette, on revient sur le menu principal
	public void quitRecette()
		{
		if (arcade)
			{
			remove(panelArcade);
			}
		else
			{
			remove(panelRecette);
			}
		add(panelMenu);
		revalidate();
		repaint();
		Tools.playSon("./Son/menu.wav");
		}

	//lance le mode arcade
	public void arcade()
		{
		arcade = true;
		panelArcade.init();
		remove(panelMenu);
		add(panelArcade);
		revalidate();
		repaint();
		}

	//affiche le menu ou l on choisi une recette a jouer
	public void level()
		{
		remove(panelMenu);
		add(panelLevel);
		repaint();
		}

	//affiche le tutoriel
	public void tuto()
		{
		remove(panelMenu);
		add(panelTuto);
		repaint();
		}

	//affiche la page a propos
	public void credit()
		{
		remove(panelMenu);
		add(panelCredit);
		repaint();
		}

	//retour au menu (depuis les credit, choix recette par exemple)
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

	//recupere le panel de jeu
	public JPanelRecette getPanelRecette()
		{
		return panelRecette;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	//definition des panel
	private void geometry()
		{
		// JComponent : Instanciation
		panelMenu = new JPanelMenu(this);
		panelCredit = new JPanelCredits(this);
		panelLevel = new JPanelLevel(this);
		panelRecette = new JPanelRecette(this);
		panelTuto = new JPanelTuto(this);
		panelArcade = new JPanelArcade(this);

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
	private JPanelArcade panelArcade;
	private boolean arcade;
	}
