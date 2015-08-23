
package mathmarecette.jeu.Recette;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import mathmarecette.jeu.Ingredient;

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
		this.tabReponse = new Ingredient[nbQuestion][];
		for(int i = 0; i < nbQuestion; i++)
			{
			tabReponse[i] = new Ingredient[4];
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

	public Ingredient[] getReponse()
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

	protected void createQuestion(int numQuestion, String img1, String img2, String img3, String img4, String q1, String q2, String q3, String q4)
		{
		tabReponse[numQuestion][0] = new Ingredient(img1, q1);
		tabReponse[numQuestion][1] = new Ingredient(img2, q2);
		tabReponse[numQuestion][2] = new Ingredient(img3, q3);
		tabReponse[numQuestion][3] = new Ingredient(img4, q4);
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

	public Ingredient[][] getTabReponse()
		{
		return tabReponse;
		}

	public void getMiniJeu(@SuppressWarnings("unused") JFrame jframe)
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
	protected Ingredient[][] tabReponse;
	protected int[] tabSolution;
	protected ImageIcon imageRecette;
	}
