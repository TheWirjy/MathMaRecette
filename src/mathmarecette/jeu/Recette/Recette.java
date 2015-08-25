
package mathmarecette.jeu.Recette;

import javax.swing.ImageIcon;

import mathmarecette.jeu.ingredient.IngredientOrdre;

public class Recette
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Recette(String _nom, String _descr, int _nbQuestion)
		{
		this.nom = _nom;
		this.description = _descr;
		this.nbQuestion = _nbQuestion;
		this.cptQuestion = 0;
		this.tabQuestion = new String[nbQuestion];
		this.tabReponse = new ImageIcon[nbQuestion][];

		for(int i = 0; i < nbQuestion; i++)
			{
			tabReponse[i] = new ImageIcon[4];
			}

		this.tabSolution = new int[nbQuestion];
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

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

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

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

	public String[] getTabQuestion()
		{
		return tabQuestion;
		}

	public int[] getTabSolution()
		{
		return tabSolution;
		}

	public ImageIcon[][] getTabReponse()
		{
		return tabReponse;
		}

	public IngredientOrdre[] getTabIngredientOrdre()
		{
		return tabIngredientOrdre;
		}

	public void ordreRecette()
	{

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
	protected String[] tabQuestion;
	protected ImageIcon[][] tabReponse;
	protected int[] tabSolution;
	protected ImageIcon imageRecette;
	protected IngredientOrdre[] tabIngredientOrdre;
	}
