
package mathmarecette.jeu.Recette;

import javax.swing.ImageIcon;

import mathmarecette.jeu.JFrameRecette;
import mathmarecette.jeu.ingredient.IngredientOrdre;
import mathmarecette.jeu.ordre.JDialogOrdreRecette;



public class Cake extends Recette
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Cake()
		{
			super("Cake au citron", "Citron - sirop", 5);

			tabQuestion[0] = "Il faut 4 blancs d’œuf + 4 jaunes d’œuf";
			tabQuestion[1] = "Prépare 10 carrées de 10g de beurre et le double de sucre";
			tabQuestion[2] = "Il nous faut autant de farine que de sucre et ½ paquet de levure";
			tabQuestion[3] = "Le cake sera prêt à 17h25 et la cuisson dure 35min. Quelle heure est-il ?";
			tabQuestion[4] = "Ajoute 5x4 morceaux de sucre dans la casserole (un morceau = 5g) et 4x le jus d un demi citron";

			createQuestion(0, CHEMIN_QUESTION+"Q1R1.png", CHEMIN_QUESTION+"Q1R2.png",  CHEMIN_QUESTION+"Q1R3.png", CHEMIN_QUESTION+"Q1R4.png");
			createQuestion(1, CHEMIN_QUESTION+"Q2R1.png", CHEMIN_QUESTION+"Q2R2.png",  CHEMIN_QUESTION+"Q2R3.png", CHEMIN_QUESTION+"Q2R4.png");
			createQuestion(2, CHEMIN_QUESTION+"Q3R1.png",  CHEMIN_QUESTION+"Q3R2.png",  CHEMIN_QUESTION+"Q3R3.png", CHEMIN_QUESTION+"Q3R4.png");
			createQuestion(3, CHEMIN_QUESTION+"Q3R1.png",  CHEMIN_QUESTION+"Q3R2.png",  CHEMIN_QUESTION+"Q3R3.png", CHEMIN_QUESTION+"Q3R4.png");
			createQuestion(4, CHEMIN_QUESTION+"Q3R1.png",  CHEMIN_QUESTION+"Q3R2.png",  CHEMIN_QUESTION+"Q3R3.png", CHEMIN_QUESTION+"Q3R4.png");

			tabSolution[0] = 1;
			tabSolution[1] = 3;
			tabSolution[2] = 1;
			tabSolution[3] = 4;
			tabSolution[4] = 1;

			// http://www.marmiton.org/recettes/recette_cake-au-citron_11391.aspx
			this.tabIngredientOrdre = new IngredientOrdre[12];
			tabIngredientOrdre[0] = new IngredientOrdre(CHEMIN_ORDRE + "oeuf.png", "Séparer blanc/jaune");
			tabIngredientOrdre[1] = new IngredientOrdre(CHEMIN_ORDRE + "beurre.png", "Fondre le beurre");
			tabIngredientOrdre[2] = new IngredientOrdre(CHEMIN_ORDRE + "citron.png", "Râper le citron");
			tabIngredientOrdre[3] = new IngredientOrdre(CHEMIN_ORDRE + "neige.png", "Monter blancs en neige");
			tabIngredientOrdre[4] = new IngredientOrdre(CHEMIN_ORDRE + "jaune_sucre.png", "Mélanger jaune + sucre");
			tabIngredientOrdre[5] = new IngredientOrdre(CHEMIN_ORDRE + "zeste.png", "Ajouter citron râpé");
			tabIngredientOrdre[6] = new IngredientOrdre(CHEMIN_ORDRE + "farine.png", "Ajouter farine");
			tabIngredientOrdre[7] = new IngredientOrdre(CHEMIN_ORDRE + "levure.png", "Ajouter levure");
			tabIngredientOrdre[8] = new IngredientOrdre(CHEMIN_ORDRE + "beurre_fondu.png", "Ajouter beurre fondue");
			tabIngredientOrdre[9] = new IngredientOrdre(CHEMIN_ORDRE + "blanc_neige.png", "Ajouter blanc neige");
			tabIngredientOrdre[10] = new IngredientOrdre(CHEMIN_ORDRE + "four.png", "Cuisson");
			tabIngredientOrdre[11] = new IngredientOrdre(CHEMIN_ORDRE + "sirop.png", "Faire le sirop");

			//this.tab = new IngredientOrdre[12];

			imageRecette = new ImageIcon(".//image//splach/splachCake.png");

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
	private final String CHEMIN_QUESTION = ".\\image\\ingredient\\cake\\";
	private final String CHEMIN_ORDRE = ".\\image\\ingredient\\cake\\ordre\\";
	}

