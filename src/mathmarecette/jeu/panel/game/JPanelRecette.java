
package mathmarecette.jeu.panel.game;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import mathmarecette.Tools;
import mathmarecette.jeu.Recette.Recette;
import mathmarecette.jeu.panel.game.composant.JPanelInfoBar;
import mathmarecette.jeu.panel.game.composant.JPanelJeu;
import mathmarecette.jeu.panel.game.composant.composant.JPanelBarEtat;
import mathmarecette.jeu.panel.horloge.JPanelJeuHorloge;
import mathmarecette.jeu.panel.score.JPanelScore;
import mathmarecette.menu.JFrameMenu;

public class JPanelRecette extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 * panel principal du jeu contenant une recette
	 */
	private static final long serialVersionUID = 4325091777849076584L;

	public JPanelRecette(JFrameMenu _parent)
		{
		this.parent = _parent;
		geometry();
		control();
		appearance();

		panelBarResult = panelJeu.getJPanelBarResult();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	//mute le son (synchro des image)
	public void setMute(boolean mute)
		{
		panelMenu.setMute(mute);
		}

	//quitte la recette lorsque on presse sur le bouton continuer du panel score
	public void retourScore()
		{
		parent.quitRecette();
		}

	//demarre la question de l horloge
	public void startQuestionBonus()
		{
		this.remove(panelJeu);
		this.add(panelJeuHorloge);
		panelJeuHorloge.startFade();
		repaint();
		}

	//affiche le score de la recette, joue un son
	public void afficheScore()
		{
		this.recette.setMedaille();
		Tools.playBruitage("./Son/victoire.wav");
		this.panelMenu.stop();
		recette.setTime(panelMenu.getTime());
		panelScore.setTime(recette.getTime() + "");
		this.remove(panelJeuHorloge);
		this.add(panelScore);
		panelScore.startFade();
		repaint();
		}

	//initialisation de la recette, remise a zero des composant, variable, enleve tout les panel present sur la frame et place les bon panel
	//affiche l image d'intro (splash) de la recette
	public void init(Recette recette)
		{
		removeAll();
		add(panelMenu);
		add(panelJeu);
		this.recette = recette;
		this.recette.initialisation();
		panelMenu.initialisation();
		panelJeuHorloge.initialisation();
		panelJeu.initialisation();
		panelJeu.setSplash(recette.getImageRecette());
		repaint();
		this.recette.playSon();
		}

	//demarre la recette : start le chrono, enleve le splash, affiche la premiere question et set les case reponse, affiche le titre de la recette dans le panel menu
	public void startRecette()
		{
		panelJeuHorloge.setQuestion(recette.getQuestionBonus());
		panelBarResult.initialisation(recette.getNbQuestion());
		panelJeu.setQuestion(recette.getQuestion());
		panelJeu.setIngredient(recette.getReponse());
		panelMenu.setTitre(recette.getImageTitre());
		panelMenu.start();
		}

	//validation d une reponse QCM
	public void reponseValider(int _id, ImageIcon icon, int x, int y)
		{
		//regarde si l indice de la case choisi correspond a la bonne reponse
		boolean bJuste = recette.verificationReponse(_id);

		//si oui, on ajoute 50pts a la recette, maj le score sur le frigo
		if (bJuste)
			{
			recette.addScore(50);
			panelJeu.setScore(recette.getScore());
			}
		else
			//sinon ajoute 0pts
			{
			recette.addScore(0);
			}

		//maj les voyant vert (suivi des questions)
		panelBarResult.next(recette.getCptQuestion());
		//ajoute l ingredient sur la table
		panelJeu.addIngr(icon, recette.getCptQuestion(), x, y);

		//si il existe une question suivante, on l affiche et set les nouveaux choix de reponse
		if (recette.next())
			{
			panelJeu.getLabelQuestion().setText("<html><body><p align=\"center\">" + recette.getQuestion() + "</p></body></html>");
			panelJeu.setIngredient(recette.getReponse());
			}
		else
			//sinon on affiche le mini jeu (cache tout se qui a sur la table, le score et affiche l image cuisine flou)
			{
			panelJeu.hideForMiniJeu();
			recette.ordreRecette(parent);
			}
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	//set la recette
	public void setRecette(Recette _recette)
		{
		this.recette = _recette;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public JPanelJeu getJPanelJeu()
		{
		return panelJeu;
		}

	public JFrame getJFrame()
		{
		return parent;
		}

	public Recette getRecette()
		{
		return recette;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		// JComponent : Instanciation
		panelMenu = new JPanelInfoBar(parent);
		panelJeu = new JPanelJeu(this);
		panelJeuHorloge = new JPanelJeuHorloge(this);
		panelScore = new JPanelScore(this);

		setLayout(null);
		}

	private void control()
		{
		}

	private void appearance()
		{
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	protected JPanelJeu panelJeu;
	protected JPanelInfoBar panelMenu;
	protected Recette recette;
	protected JPanelBarEtat panelBarResult;
	protected JPanelJeuHorloge panelJeuHorloge;
	protected JPanelScore panelScore;
	protected JFrameMenu parent;
	}
