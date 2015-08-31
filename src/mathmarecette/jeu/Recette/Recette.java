
package mathmarecette.jeu.Recette;

import javax.swing.ImageIcon;

import mathmarecette.jeu.ingredient.IngredientOrdre;
import mathmarecette.jeu.ordre.JDialogOrdreRecette;
import mathmarecette.jeu.ordre.JPanelIngredientOrdre;
import mathmarecette.menu.JFrameMenu;

public class Recette
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Recette(String _nom, String _descr, int _nbQuestion, int nbScore)
		{
		this.nom = _nom;
		this.description = _descr;
		this.nbQuestion = _nbQuestion;
		this.nbScore = nbScore;
		this.miniJeu = true;
		this.tabQuestion = new String[nbQuestion];
		this.tabReponse = new ImageIcon[nbQuestion][];
		this.music = ".\\Son\\recette.mp3";
		this.tabScore = new int[nbScore];

		for(int i = 0; i < nbQuestion; i++)
			{
			tabReponse[i] = new ImageIcon[4];
			}

		this.tabSolution = new int[nbQuestion];
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void initialisation()
	{
	this.cptQuestion = 0;
	this.indiceTabScore = 0;
	for(int i = 0; i < nbScore; i++)
		{
		tabScore[i] = 0;
		}

	}

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

	public ImageIcon[] getReponse()
		{
		return tabReponse[cptQuestion];
		}

	public String getQuestion()
		{
		return tabQuestion[cptQuestion];
		}

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

	protected void createQuestion(int numQuestion, String img1, String img2, String img3, String img4)
		{
		tabReponse[numQuestion][0] = new ImageIcon(img1);
		tabReponse[numQuestion][1] = new ImageIcon(img2);
		tabReponse[numQuestion][2] = new ImageIcon(img3);
		tabReponse[numQuestion][3] = new ImageIcon(img4);
		}

	public void addScore(int pts)
		{
		tabScore[indiceTabScore] = pts;
		indiceTabScore++;
		}

	public void verificationBonus(String reponse)
		{
		if (reponse.equals(reponseBonus))
			{
			tabScore[indiceTabScore] = 50;
			}
		indiceTabScore++;
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	public void setTime(String time)
		{
		this.time = time;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public String getMusic()
		{
		return music;
		}

	public boolean aUnMiniJeu()
		{
		return miniJeu;
		}

	public String getQuestionBonus()
		{
		return questionBonus;
		}

	public String getReponseBonus()
		{
		return reponseBonus;
		}

	public int getScore()
		{
		int score = 0;
		for(int i = 0; i < tabScore.length; i++)
			{
			score += tabScore[i];
			}

		return score;
		}

	public String getNom()
		{
		return this.nom;
		}

	public String getDescription()
		{
		return this.description;
		}

	public int getNbQuestion()
		{
		return this.nbQuestion;
		}

	public int getCptQuestion()
		{
		return this.cptQuestion;
		}

	public ImageIcon getImageRecette()
		{
		return this.imageRecette;
		}

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

	public void ordreRecette(@SuppressWarnings("unused") JFrameMenu parent)
		{
		new JDialogOrdreRecette(parent, this);
		}

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
	protected String[] tabQuestion;
	protected ImageIcon[][] tabReponse;
	protected int[] tabSolution;
	protected ImageIcon imageRecette;
	protected IngredientOrdre[] tabIngredientOrdre;
	protected int[] tabOrdreReponse;
	protected int[] tabOrdreIndice;
	//private int score;
	protected final String CHEMIN_TITRE = ".\\image\\titre\\";
	protected ImageIcon imageTitre;

	protected String questionBonus;
	protected String reponseBonus;

	protected int[] tabScore;
	protected int indiceTabScore;

	protected boolean miniJeu;

	protected String music;

	protected String time;

	}
