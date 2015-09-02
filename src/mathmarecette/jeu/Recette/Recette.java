
package mathmarecette.jeu.Recette;

import javax.swing.ImageIcon;

import mathmarecette.Tools;
import mathmarecette.jeu.ingredient.IngredientOrdre;
import mathmarecette.jeu.ordre.JDialogOrdreRecette;
import mathmarecette.jeu.ordre.JPanelIngredientOrdre;
import mathmarecette.menu.JFrameMenu;

public class Recette
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 *
	 * @param _nom : nom de la recette
	 * @param _descr : description de la recette
	 * @param _nbQuestion : nombre de question a choix multiple
	 * @param _nbScore : nombre de score, = nombre de qcm + 1 ou 0 mini jeu + 1 ou 0 horloge
	 * @param _scoreMax : score max de la recette, 50 par question, 200 max au mini jeu
	 */
	public Recette(String _nom, String _descr, int _nbQuestion, int _nbScore, int _scoreMax)
		{
		this.nom = _nom;
		this.description = _descr;
		this.nbQuestion = _nbQuestion;
		this.nbScore = _nbScore;
		this.scoreMax = _scoreMax;
		this.miniJeu = true;
		//tableau des question (qcm) ingredient
		this.tabQuestion = new String[nbQuestion];
		//tableau des image reponse au qcm 4 reponse pour chaque question
		this.tabReponse = new ImageIcon[nbQuestion][];
		//tableau des score obtenu pour chaque reponse / mini jeu
		this.tabScore = new int[nbScore];

		//initialise le tableau
		for(int i = 0; i < nbQuestion; i++)
			{
			tabReponse[i] = new ImageIcon[4];
			}

		//tableau des solution au qcm
		this.tabSolution = new int[nbQuestion];

		//image de la medaille (vide par defaut, cercle noir)
		medaille = Tools.MEDAILLE_VIDE;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	//initialisation de la recette
	//remet les indice de parcours a 0
	//remet les score a 0
	public void initialisation()
		{
		this.cptQuestion = 0;
		this.indiceTabScore = 0;
		for(int i = 0; i < nbScore; i++)
			{
			tabScore[i] = 0;
			}
		}

	//si il existe une question suivante au QCM alors on incremente l indice de parcours
	//retourne vrai si une question existe, faux s'il y en a plus
	public boolean next()
		{
		if (cptQuestion < tabQuestion.length - 1)
			{
			cptQuestion++;
			return true;
			}
		else
			{
			return false;
			}
		}

	//recupere une reponse au qcm (1 reponse = 4 choix)
	public ImageIcon[] getReponse()
		{
		return tabReponse[cptQuestion];
		}

	//recupere la question a poser
	public String getQuestion()
		{
		return tabQuestion[cptQuestion];
		}

	//si la reponse donner est correct, retourne vrai sinon faux
	public boolean verificationReponse(int _id)
		{
		if (_id == tabSolution[cptQuestion])
			{
			return true;
			}
		else
			{
			return false;
			}
		}

	//creation des 4 choix de reponse avec les image des ingredient
	protected void createQuestion(int numQuestion, String img1, String img2, String img3, String img4)
		{
		tabReponse[numQuestion][0] = new ImageIcon(img1);
		tabReponse[numQuestion][1] = new ImageIcon(img2);
		tabReponse[numQuestion][2] = new ImageIcon(img3);
		tabReponse[numQuestion][3] = new ImageIcon(img4);
		}

	//ajout du score
	public void addScore(int pts)
		{
		tabScore[indiceTabScore] = pts;
		indiceTabScore++;
		}

	//verifie si la reponse a la question de l horloge est juste, ajoute le score en fonction
	public void verificationBonus(String reponse)
		{
		if (reponse.equals(reponseBonus))
			{
			tabScore[indiceTabScore] = 50;
			}
		indiceTabScore++;
		}

	//joue le son de la recette
	public void playSon()
		{
		Tools.playSon(music);
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	//set le temps en seconde que le joueur a fait pour finir la recette
	public void setTime(int time)
		{
		this.time = time;
		}

	//set la medaille obtenue
	public void setMedaille()
		{
		this.medaille = Tools.MEDAILLE_VIDE;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	//recupere le temps sous format texte hh:mm
	public String getTime()
		{
		int m = (int)(time / 60.0);
		double reste = time / 60.0 - m;
		int s = (int)(reste * 60);
		return m + ":" + s;
		}

	//recupere le fichier music
	public String getMusic()
		{
		return music;
		}

	//si la recette a un mini jeu
	public boolean aUnMiniJeu()
		{
		return miniJeu;
		}

	//recupere la question de l horloge
	public String getQuestionBonus()
		{
		return questionBonus;
		}

	//recupere la reponse a la question de l horloge
	public String getReponseBonus()
		{
		return reponseBonus;
		}

	//recupere le score tot de la recette
	public int getScore()
		{
		int score = 0;
		for(int i = 0; i < tabScore.length; i++)
			{
			score += tabScore[i];
			}

		return score;
		}

	//recupere le nom
	public String getNom()
		{
		return this.nom;
		}

	//recupere la description
	public String getDescription()
		{
		return this.description;
		}

	public int getNbQuestion()
		{
		return this.nbQuestion;
		}

	//recupere l indice a de la question courrante
	public int getCptQuestion()
		{
		return this.cptQuestion;
		}

	//recupere le splash d intro de la recette
	public ImageIcon getImageRecette()
		{
		return this.imageRecette;
		}

	//recupere le titre de la recette sous forme d image pour le panel menu
	public ImageIcon getImageTitre()
		{
		return this.imageTitre;
		}

	public String[] getTabQuestion()
		{
		return tabQuestion;
		}

	public int[] getTabSolution()
		{
		return tabSolution;
		}

	public int[] getTabScore()
		{
		return tabScore;
		}

	public ImageIcon[][] getTabReponse()
		{
		return tabReponse;
		}

	public IngredientOrdre[] getTabIngredientOrdre()
		{
		return tabIngredientOrdre;
		}

	//demarre le mini jeu d ordre
	public void ordreRecette(JFrameMenu parent)
		{
		new JDialogOrdreRecette(parent, this);
		}

	//regarde si la reponse du mini jeu d ordre est juste ou non selon les indice de position defini dans chaque recette (compare avec le tableau de carte)
	public int checkReponseOrdre(JPanelIngredientOrdre[] ingr)
		{
		int cptBonneRep = 0;
		for(int i = 0; i < ingr.length; i++)
			{
			if (ingr[i].getID_ordre() == tabOrdreIndice[i])
				{
				cptBonneRep++;
				}
			}
		return cptBonneRep;
		}

	public int[] getTabOrdreIndice()
		{
		return tabOrdreIndice;
		}

	public ImageIcon getMedaille()
		{
		return medaille;
		}

	public int getScoreMax()
		{
		return scoreMax;
		}

	public ImageIcon getPrintImage()
		{
		return printImage;
		}

	public String getPrintPdf()
		{
		return printPdf;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private String nom;
	private String description;
	private int nbQuestion;
	private int cptQuestion;
	private int nbScore;
	protected ImageIcon medaille;
	protected String[] tabQuestion;
	protected ImageIcon[][] tabReponse;
	protected int[] tabSolution;
	protected ImageIcon imageRecette;
	protected IngredientOrdre[] tabIngredientOrdre;
	protected int[] tabOrdreIndice;
	protected final String CHEMIN_TITRE = ".\\image\\titre\\";
	protected ImageIcon imageTitre;

	protected String questionBonus;
	protected String reponseBonus;

	protected int[] tabScore;
	protected int indiceTabScore;

	protected boolean miniJeu;

	protected String music;

	protected int time;
	protected int scoreMax;

	protected ImageIcon printImage;
	protected String printPdf;
	}
