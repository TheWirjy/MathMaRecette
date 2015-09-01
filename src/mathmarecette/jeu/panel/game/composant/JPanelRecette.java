
package mathmarecette.jeu.panel.game.composant;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import mathmarecette.Tools;
import mathmarecette.jeu.Recette.Recette;
import mathmarecette.jeu.panel.game.JPanelInfoBar;
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
	 *
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

	public void setMute(boolean mute)
		{
		panelMenu.setMute(mute);
		}

	public void retourScore()
		{
		parent.quitRecette();
		}

	public void startQuestionBonus()
		{
		this.remove(panelJeu);
		this.add(panelJeuHorloge);
		panelJeuHorloge.startFade();
		repaint();
		}

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

	public void startRecette()
		{
		panelJeuHorloge.setQuestion(recette.getQuestionBonus());
		panelBarResult.initialisation(recette.getNbQuestion());
		panelJeu.setQuestion(recette.getQuestion());
		panelJeu.setIngredient(recette.getReponse());
		panelMenu.setTitre(recette.getImageTitre());
		panelMenu.start();
		}

	public void reponseValider(int _id, ImageIcon icon, int x, int y)
		{
		boolean bJuste = recette.verificationReponse(_id);

		if (bJuste)
			{
			recette.addScore(50);
			panelJeu.setScore(recette.getScore());
			}
		else
			{
			recette.addScore(0);
			}

		panelBarResult.next(recette.getCptQuestion());
		panelJeu.addIngr(icon, recette.getCptQuestion(), x, y);

		if (recette.next())
			{
			panelJeu.getLabelQuestion().setText("<html><body><p align=\"center\">" + recette.getQuestion() + "</p></body></html>");
			panelJeu.setIngredient(recette.getReponse());
			}
		else
			{
			panelJeu.hideForMiniJeu();
			recette.ordreRecette(parent);
			}
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

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
