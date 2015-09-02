
package mathmarecette.jeu.Recette;

import javax.swing.ImageIcon;

import mathmarecette.Tools;
import mathmarecette.jeu.ingredient.IngredientOrdre;

public class Spaghetti extends Recette
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Spaghetti()
		{
		super("Spaghetti", "Nature", 3, 5, 400);

		tabQuestion[0] = "Il faut 2*1 bouteille d’ 1 litre <i>(Un récipient plein = 1L)</i>";
		tabQuestion[1] = "On a besoin de 15g de sel (1 cuillère = 5g)";
		tabQuestion[2] = "Le paquet de pâte contient 500g laisse 300g dans le paquet et prend le reste";

		createQuestion(0, CHEMIN_QUESTION + "Q1R1.png", CHEMIN_QUESTION + "Q1R2.png", CHEMIN_QUESTION + "Q1R3.png", CHEMIN_QUESTION + "Q1R4.png");
		createQuestion(1, CHEMIN_QUESTION + "Q2R1.png", CHEMIN_QUESTION + "Q2R2.png", CHEMIN_QUESTION + "Q2R3.png", CHEMIN_QUESTION + "Q2R4.png");
		createQuestion(2, CHEMIN_QUESTION + "Q3R1.png", CHEMIN_QUESTION + "Q3R2.png", CHEMIN_QUESTION + "Q3R3.png", CHEMIN_QUESTION + "Q3R4.png");

		tabSolution[0] = 1;
		tabSolution[1] = 2;
		tabSolution[2] = 4;

		this.tabIngredientOrdre = new IngredientOrdre[5];
		tabIngredientOrdre[0] = new IngredientOrdre(CHEMIN_ORDRE + "eau.png", "Mettre de l'eau");
		tabIngredientOrdre[1] = new IngredientOrdre(CHEMIN_ORDRE + "sel.png", "Ajouter le sel");
		tabIngredientOrdre[2] = new IngredientOrdre(CHEMIN_ORDRE + "pate.png", "Mettre les pâtes");
		tabIngredientOrdre[3] = new IngredientOrdre(CHEMIN_ORDRE + "casserole.png", "Cuisson");
		tabIngredientOrdre[4] = new IngredientOrdre(CHEMIN_ORDRE + "huile.png", "Mettre l'huile d'olive");

		this.tabOrdreIndice = new int[5];
		tabOrdreIndice[0] = 0;
		tabOrdreIndice[1] = 1;
		tabOrdreIndice[2] = 2;
		tabOrdreIndice[3] = 3;
		tabOrdreIndice[4] = 4;

		this.tabOrdreReponse = new int[5];
		tabOrdreIndice[0] = 0;
		tabOrdreIndice[1] = 1;
		tabOrdreIndice[2] = 2;
		tabOrdreIndice[3] = 3;
		tabOrdreIndice[4] = 4;

		imageRecette = new ImageIcon(".//image//splach/splachSpaghetti.png");
		imageTitre = new ImageIcon(CHEMIN_TITRE + "titre_spaghetti.png");

		this.questionBonus = "Il est 15h37, les pâtes doivent cuire 6min, à quelle heure seront-elle prêtes ?";
		this.reponseBonus = "15h43";
		this.music = "./Son/spaghetti.wav";
		this.printImage = Tools.RECETTE_SPAGHETTI_IMAGE;
		this.printPdf = Tools.RECETTE_SPAGHETTI;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void setMedaille()
		{
		int score = getScore();

		if (score >= scoreMax - 200)
			{
			if (score >= scoreMax - 50)
				{
				medaille = Tools.M_SPAGH_3;
				}
			else
				{
				medaille = Tools.M_SPAGH_2;
				}
			}
		else
			{
			medaille = Tools.M_SPAGH_1;
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
	private final String CHEMIN_QUESTION = ".\\image\\ingredient\\spaghetti\\";
	private final String CHEMIN_ORDRE = ".\\image\\ingredient\\spaghetti\\ordre\\";
	}
