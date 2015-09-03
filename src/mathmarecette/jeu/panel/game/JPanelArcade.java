
package mathmarecette.jeu.panel.game;

import mathmarecette.jeu.Recette.Cake;
import mathmarecette.jeu.Recette.Crepe;
import mathmarecette.jeu.Recette.Pizza;
import mathmarecette.jeu.Recette.Recette;
import mathmarecette.jeu.Recette.Salade;
import mathmarecette.jeu.Recette.Spaghetti;
import mathmarecette.jeu.panel.score.JPanelScoreFinal;
import mathmarecette.menu.JFrameMenu;

public class JPanelArcade extends JPanelRecette
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/*
	 * herite de panelRecette, modifie se que l on a besoin afin d enchainer les recette
	 */
	public JPanelArcade(JFrameMenu _parent)
		{
		super(_parent);
		//defini un tableau avec les 5 recettes
		this.recettes = new Recette[5];
		this.recettes[0] = new Salade();
		this.recettes[1] = new Spaghetti();
		this.recettes[2] = new Crepe();
		this.recettes[3] = new Cake();
		this.recettes[4] = new Pizza();
		indiceRecette = 0;
		panelScoreF = new JPanelScoreFinal(this);

		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	//affiche la question de l horloge
	@Override
	public void startQuestionBonus()
		{
		remove(panelJeu);
		add(panelJeuHorloge);
		panelJeuHorloge.startFade();
		repaint();
		}

	//initialisation, remove tout les panel et ajoute les bon, defini la premiere recette, affiche le splash d intro...
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
		this.recette.playSon();
		}

	//recette suivante, augmente l indice pour passer a la recette suivante, set la nouvelle recette, initialise le panel/jeu
	public void nextRecette()
		{
		//Tools.stopSon();
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
		this.recette.playSon();
		}

	//lorsque on clique sur continer depuis le tableau des score, on regarde s il existe une recette suivant, si oui on commence la nouvelle recette
	//sinon on affiche le resumé du mode arcade
	@Override
	public void retourScore()
		{
		if (indiceRecette >= recettes.length - 1)
			{
			afficheScoreTot();
			}
		else
			{
			nextRecette();
			}
		}

	private String transformTime(int time)
		{
		int m = (int)(time / 60.0);
		double reste = time / 60.0 - m;
		int s = (int)(reste * 60);
		String strM = m + "";
		String strS = s + "";
		if (m < 10)
			{
			strM = "0" + m;
			}
		if (s < 10)
			{
			strS = "0" + s;
			}

		return strM + ":" + strS;
		}

	//affiche le resumé du mode arcade (les scores finaux, medaille, toque)
	public void afficheScoreTot()
		{

		panelScoreF.setTime(transformTime(panelMenu.getTimeFinal()));
		this.remove(panelScore);
		this.add(panelScoreF);
		panelScoreF.startFade();
		revalidate();
		repaint();
		}

	//quitter arcade pour revenir au menu
	public void quitArcade()
		{
		parent.quitRecette();
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	//recupere le tableau des recette
	public Recette[] getRecettes()
		{
		return this.recettes;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private Recette[] recettes;
	private int indiceRecette;
	private JPanelScoreFinal panelScoreF;
	}
