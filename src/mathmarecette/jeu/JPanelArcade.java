
package mathmarecette.jeu;

import mathmarecette.jeu.Recette.Cake;
import mathmarecette.jeu.Recette.Crepe;
import mathmarecette.jeu.Recette.Pizza;
import mathmarecette.jeu.Recette.Recette;
import mathmarecette.jeu.Recette.Salade;
import mathmarecette.jeu.Recette.Spaghetti;
import mathmarecette.menu.JFrameMenu;

public class JPanelArcade extends JPanelRecette
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelArcade(JFrameMenu _parent)
		{
		super(_parent);
		this.recettes = new Recette[5];
		this.recettes[0] = new Salade();
		this.recettes[1] = new Spaghetti();
		this.recettes[2] = new Crepe();
		this.recettes[3] = new Cake();
		this.recettes[4] = new Pizza();
		indiceRecette = 0;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void startQuestionBonus()
		{
		remove(panelJeu);
		add(panelJeuHorloge);
		panelJeuHorloge.startFade();
		repaint();
		}

	public void init()
		{
		removeAll();
		add(panelMenu);
		add(panelJeu);
		indiceRecette = 0;
		this.recette = recettes[indiceRecette];
		this.recette.initialisation();
		panelMenu.initialisation();
		panelJeuHorloge.initialisation();
		panelJeu.initialisation();
		panelJeu.setSplash(recette.getImageRecette());
		repaint();
		}

	public void nextRecette()
		{
		indiceRecette++;
		removeAll();
		add(panelMenu);
		add(panelJeu);
		this.recette = recettes[indiceRecette];
		this.recette.initialisation();
		panelJeuHorloge.initialisation();
		panelJeu.initialisation();
		panelJeu.setSplash(recette.getImageRecette());
		repaint();
		}

	@Override
	public void retourScore()
		{
		if (indiceRecette >= recettes.length - 1)
			{
			parent.menu(this);
			}
		else
			{
			nextRecette();
			}
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

	private Recette[] recettes;
	private int indiceRecette;
	}