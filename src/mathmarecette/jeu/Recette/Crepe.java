
package mathmarecette.jeu.Recette;

import javax.swing.ImageIcon;

import mathmarecette.jeu.JFrameRecette;
import mathmarecette.jeu.ingredient.IngredientOrdre;
import mathmarecette.jeu.ordre.JDialogOrdreRecette;

public class Crepe extends Recette
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Crepe()
		{
		super("Crêpes", "Pâte à crêpe nature", 4);

		tabQuestion[0] = "Ajoute 2* 125g de farine";
		tabQuestion[1] = "Avec une boite de 6 œufs on fait 3 pâtes à crêpes, combien t'en faut-il pour en faire une";
		tabQuestion[2] = "Ajoute à quantité égal de l’eau et du lait pour un total de 0.5l";
		tabQuestion[3] = "Ajoute [(5+3)/4] cuillère à soupe d’huile";

		createQuestion(0, CHEMIN_QUESTION + "Q1R1.png", CHEMIN_QUESTION + "Q1R2.png", CHEMIN_QUESTION + "Q1R3.png", CHEMIN_QUESTION + "Q1R4.png");
		createQuestion(1, CHEMIN_QUESTION + "Q2R1.png", CHEMIN_QUESTION + "Q2R2.png", CHEMIN_QUESTION + "Q2R3.png", CHEMIN_QUESTION + "Q2R4.png");
		createQuestion(2, CHEMIN_QUESTION + "Q3R1.png", CHEMIN_QUESTION + "Q3R2.png", CHEMIN_QUESTION + "Q3R3.png", CHEMIN_QUESTION + "Q3R4.png");
		createQuestion(3, CHEMIN_QUESTION + "Q4R1.png", CHEMIN_QUESTION + "Q4R2.png", CHEMIN_QUESTION + "Q4R3.png", CHEMIN_QUESTION + "Q4R4.png");

		tabSolution[0] = 2;
		tabSolution[1] = 4;
		tabSolution[2] = 1;
		tabSolution[3] = 4;

		// http://www.marmiton.org/recettes/recette_pate-a-crepes_12372.aspx
		this.tabIngredientOrdre = new IngredientOrdre[10];
		tabIngredientOrdre[0] = new IngredientOrdre(CHEMIN_ORDRE + "bol.png", "Sortir Saladier");
		tabIngredientOrdre[1] = new IngredientOrdre(CHEMIN_ORDRE + "farine.png", "Ajouter farine");
		tabIngredientOrdre[2] = new IngredientOrdre(CHEMIN_ORDRE + "oeuf.png", "Ajouter oeufs");
		tabIngredientOrdre[3] = new IngredientOrdre(CHEMIN_ORDRE + "sucre.png", "Ajouter sucre");
		tabIngredientOrdre[4] = new IngredientOrdre(CHEMIN_ORDRE + "huile.png", "Ajouter Huile");
		tabIngredientOrdre[5] = new IngredientOrdre(CHEMIN_ORDRE + "beurre_fondu.png", "Ajouter beurre fondu");
		tabIngredientOrdre[6] = new IngredientOrdre(CHEMIN_ORDRE + "lait.png", "Ajouter le lait");
		tabIngredientOrdre[7] = new IngredientOrdre(CHEMIN_ORDRE + "melange.png", "Mélanger");
		tabIngredientOrdre[8] = new IngredientOrdre(CHEMIN_ORDRE + "huiler.png", "Huiler plaque");
		tabIngredientOrdre[9] = new IngredientOrdre(CHEMIN_ORDRE + "casserole.png", "Cuisson");

		imageRecette = new ImageIcon("");

		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void ordreRecette(JFrameRecette parent)
		{
		new JDialogOrdreRecette(parent, this);
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
	private final String CHEMIN_QUESTION = ".\\image\\ingredient\\crepe\\";
	private final String CHEMIN_ORDRE = ".\\image\\ingredient\\crepe\\ordre\\";
	}
