
package mathmarecette.jeu.Recette;

import javax.swing.ImageIcon;

import mathmarecette.jeu.JFrameRecette;
import mathmarecette.jeu.ingredient.IngredientOrdre;
import mathmarecette.jeu.ordre.JDialogOrdreRecette;

public class Spaghetti extends Recette
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Spaghetti()
		{
		super("Spaghetti", "Nature", 4);

		tabQuestion[0] = "Il faut 2*1 bouteille d’ 1 litre <i>(Un récipient plein = 1L)</i>";
		tabQuestion[1] = "On a besoin de 15g de sel (1 cuillère = 5g)";
		tabQuestion[2] = "Le paquet de pâte contient 500g laisse 300g dans le paquet et prend le reste";
		tabQuestion[3] = "Il est 15h37, les pâtes doivent cuire 6min, à quelle heure seront-elle prête ?";

		createQuestion(0, CHEMIN_QUESTION + "Q1R1.png", CHEMIN_QUESTION + "Q1R2.png", CHEMIN_QUESTION + "Q1R3.png", CHEMIN_QUESTION + "Q1R4.png");
		createQuestion(1, CHEMIN_QUESTION + "Q2R1.png", CHEMIN_QUESTION + "Q2R2.png", CHEMIN_QUESTION + "Q2R3.png", CHEMIN_QUESTION + "Q2R4.png");
		createQuestion(2, CHEMIN_QUESTION + "Q3R1.png", CHEMIN_QUESTION + "Q3R2.png", CHEMIN_QUESTION + "Q3R3.png", CHEMIN_QUESTION + "Q3R4.png");
		createQuestion(3, CHEMIN_QUESTION + "Q4R1.png", CHEMIN_QUESTION + "Q4R2.png", CHEMIN_QUESTION + "Q4R3.png", CHEMIN_QUESTION + "Q4R4.png");

		tabSolution[0] = 1;
		tabSolution[1] = 2;
		tabSolution[2] = 4;
		tabSolution[3] = 3;

		this.tabIngredientOrdre = new IngredientOrdre[5];
		tabIngredientOrdre[0] = new IngredientOrdre(CHEMIN_ORDRE + "eau.png", "Eau");
		tabIngredientOrdre[1] = new IngredientOrdre(CHEMIN_ORDRE + "sel.png", "Sel");
		tabIngredientOrdre[2] = new IngredientOrdre(CHEMIN_ORDRE + "pate.png", "Pâtes");
		tabIngredientOrdre[3] = new IngredientOrdre(CHEMIN_ORDRE + "casserole.png", "Cuisson");
		tabIngredientOrdre[4] = new IngredientOrdre(CHEMIN_ORDRE + "huile.png", "Huile d'olive");

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
	private final String CHEMIN_QUESTION = ".\\image\\ingredient\\spaghetti\\";
	private final String CHEMIN_ORDRE = ".\\image\\ingredient\\spaghetti\\ordre\\";
	}
