package mathmarecette.jeu;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import mathmarecette.jeu.Recette.Recette;
import mathmarecette.jeu.score.JPanelScore;
import mathmarecette.menu.JFrameMenu;

public class JPanelRecette extends JPanel {

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 * 
	 */
	private static final long serialVersionUID = 4325091777849076584L;
	public JPanelRecette(JFrameMenu _parent, Recette recette) {
		this.parent = _parent;
		this.recette = recette;
		geometry();
		control();
		appearance();

		panelBarResult = panelJeu.getJPanelBarResult();
	}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void retourScore() {
		parent.menu(this);
	}

	public void startQuestionBonus() {
		this.remove(panelJeu);
		this.add(panelJeuHorloge);
		panelJeuHorloge.startFade();
		repaint();
	}

	public void afficheScore() {
		this.panelMenu.stop();
		recette.setTime(panelMenu.getTime());
		panelScore.setTime(panelMenu.getTime());
		this.remove(panelJeuHorloge);
		this.add(panelScore);
		panelScore.startFade();
		repaint();
	}

	public void init(Recette recette) {
		removeAll();
		add(panelMenu);
		add(panelJeu);
		this.recette = recette;
		this.recette.initialisation();
		panelMenu.initialisation();
		panelJeuHorloge.setQuestion("");
		panelJeu.initialisation();
		panelJeu.setSplash(recette.getImageRecette());
		repaint();
	}

	public void startRecette() {
		panelJeuHorloge.setQuestion(recette.getQuestionBonus());
		panelBarResult.initialisation(recette.getNbQuestion());
		panelJeu.setQuestion(recette.getQuestion());
		panelJeu.setIngredient(recette.getReponse());
		panelMenu.setTitre(recette.getImageTitre());
		panelMenu.start();
	}

	public void reponseValider(int _id, ImageIcon icon, int x, int y) {
		boolean bJuste = recette.verificationReponse(_id);

		if (bJuste) {
			recette.addScore(50);
			panelJeu.setScore(recette.getScore());
		} else {
			recette.addScore(0);
		}

		panelBarResult.next(recette.getCptQuestion());
		panelJeu.addIngr(icon, recette.getCptQuestion(), x, y);

		if (recette.next()) {
			panelJeu.getLabelQuestion().setText(
					"<html><body><p align=\"center\">" + recette.getQuestion()
							+ "</p></body></html>");
			panelJeu.setIngredient(recette.getReponse());
		} else {
			panelJeu.hideForMiniJeu();
			recette.ordreRecette(parent);
		}

	}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	public void setRecette(Recette _recette) {
		this.recette = _recette;
	}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public JPanelJeu getJPanelJeu() {
		return panelJeu;
	}

	public JFrame getJFrame() {
		return parent;
	}

	public Recette getRecette() {
		return recette;
	}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry() {
		// JComponent : Instanciation
		panelMenu = new JPanelInfoBar(parent);
		panelJeu = new JPanelJeu(this);
		panelJeuHorloge = new JPanelJeuHorloge(this);
		panelScore = new JPanelScore(this);

		setLayout(null);

		// JComponent : add

		// add(panelScore);
		// add(panelJeuHorloge);
	}

	private void control() {
		// rien
	}

	private void appearance() {
	}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private JPanelJeu panelJeu;
	private JPanelInfoBar panelMenu;
	private Recette recette;
	private JPanelBarEtat panelBarResult;
	private JPanelJeuHorloge panelJeuHorloge;
	private JPanelScore panelScore;
	private JFrameMenu parent;
}
