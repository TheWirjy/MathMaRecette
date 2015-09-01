
package mathmarecette.jeu.Recette;

import javax.swing.ImageIcon;

import mathmarecette.jeu.ingredient.IngredientOrdre;

public class Pizza extends Recette
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Pizza()
		{
		super("Pizza", "Tomate - Mozzarella - Jambon", 6, 8);

		tabQuestion[0] = "Prépare 350 gramme de farine ";
		tabQuestion[1] = "Prépare 10 gramme de sel <i>(sachant qu’une cuillère à café fait 5 gramme)</i>";
		tabQuestion[2] = "Prépare 20 gramme de levure <i>(sachant que 1 carré de levure fait 40 gramme)</i>";
		tabQuestion[3] = "Prépare 2 fois plus de cuillère à café d’huile que de sel";
		tabQuestion[4] = "Prépare 0,25l d’eau chaude";
		tabQuestion[5] = "Préparer 200g de coulis de tomate et la moitié de mozzarella (une mozzarella entière = 300g)";

		createQuestion(0, CHEMIN_QUESTION + "Q1R1.png", CHEMIN_QUESTION + "Q1R2.png", CHEMIN_QUESTION + "Q1R3.png", CHEMIN_QUESTION + "Q1R4.png");
		createQuestion(1, CHEMIN_QUESTION + "Q2R1.png", CHEMIN_QUESTION + "Q2R2.png", CHEMIN_QUESTION + "Q2R3.png", CHEMIN_QUESTION + "Q2R4.png");
		createQuestion(2, CHEMIN_QUESTION + "Q3R1.png", CHEMIN_QUESTION + "Q3R2.png", CHEMIN_QUESTION + "Q3R3.png", CHEMIN_QUESTION + "Q3R4.png");
		createQuestion(3, CHEMIN_QUESTION + "Q4R1.png", CHEMIN_QUESTION + "Q4R2.png", CHEMIN_QUESTION + "Q4R3.png", CHEMIN_QUESTION + "Q4R4.png");
		createQuestion(4, CHEMIN_QUESTION + "Q5R1.png", CHEMIN_QUESTION + "Q5R2.png", CHEMIN_QUESTION + "Q5R3.png", CHEMIN_QUESTION + "Q5R4.png");
		createQuestion(5, CHEMIN_QUESTION + "Q7R1.png", CHEMIN_QUESTION + "Q7R2.png", CHEMIN_QUESTION + "Q7R3.png", CHEMIN_QUESTION + "Q7R4.png");

		tabSolution[0] = 4;
		tabSolution[1] = 2;
		tabSolution[2] = 1;
		tabSolution[3] = 4;
		tabSolution[4] = 2;
		tabSolution[5] = 1;

		// http://www.marmiton.org/recettes/recette_pate-a-pizza-epaisse-et-moelleuse_58761.aspx
		this.tabIngredientOrdre = new IngredientOrdre[15];
		tabIngredientOrdre[0] = new IngredientOrdre(CHEMIN_ORDRE + "bol.png", "Sortir Saladier");
		tabIngredientOrdre[1] = new IngredientOrdre(CHEMIN_ORDRE + "farine.png", "Ajouter farine");
		tabIngredientOrdre[2] = new IngredientOrdre(CHEMIN_ORDRE + "sel.png", "Ajouter sel");
		tabIngredientOrdre[3] = new IngredientOrdre(CHEMIN_ORDRE + "levure.png", "Ajouter levure");
		tabIngredientOrdre[4] = new IngredientOrdre(CHEMIN_ORDRE + "huile.png", "Ajouter Huile olive");
		tabIngredientOrdre[5] = new IngredientOrdre(CHEMIN_ORDRE + "eau.png", "Ajouter eau");
		tabIngredientOrdre[6] = new IngredientOrdre(CHEMIN_ORDRE + "melange.png", "Mélanger");
		tabIngredientOrdre[7] = new IngredientOrdre(CHEMIN_ORDRE + "petrir.png", "Pétrir pâte");
		tabIngredientOrdre[8] = new IngredientOrdre(CHEMIN_ORDRE + "serviette.png", "Couvrir pâte");
		tabIngredientOrdre[9] = new IngredientOrdre(CHEMIN_ORDRE + "repos.png", "Pâte au repos 1h");
		tabIngredientOrdre[10] = new IngredientOrdre(CHEMIN_ORDRE + "etaler.png", "Etaler pâte");
		tabIngredientOrdre[11] = new IngredientOrdre(CHEMIN_ORDRE + "tomate.png", "Mettre sauce tomate");
		tabIngredientOrdre[12] = new IngredientOrdre(CHEMIN_ORDRE + "mozza.png", "Ajouter mozzarella");
		tabIngredientOrdre[13] = new IngredientOrdre(CHEMIN_ORDRE + "jambon.png", "Ajouter jambon");
		tabIngredientOrdre[14] = new IngredientOrdre(CHEMIN_ORDRE + "four.png", "Cuisson");

		this.tabOrdreIndice = new int[15];
		tabOrdreIndice[0] = 0;
		tabOrdreIndice[1] = 1;
		tabOrdreIndice[2] = 2;
		tabOrdreIndice[3] = 2;
		tabOrdreIndice[4] = 2;
		tabOrdreIndice[5] = 3;
		tabOrdreIndice[6] = 4;
		tabOrdreIndice[7] = 5;
		tabOrdreIndice[8] = 6;
		tabOrdreIndice[9] = 7;
		tabOrdreIndice[10] = 8;
		tabOrdreIndice[11] = 9;
		tabOrdreIndice[12] = 10;
		tabOrdreIndice[13] = 11;
		tabOrdreIndice[14] = 12;

		this.tabOrdreReponse = new int[15];
		for(int i = 0; i < 15; i++)
			{
			tabOrdreReponse[i] = tabOrdreIndice[i];
			}

		imageRecette = new ImageIcon(".//image//splach/splachPizza.png");
		imageTitre = new ImageIcon(CHEMIN_TITRE + "titre_pizza.png");

		this.questionBonus = "Pour cette pizza, il faut 20min de préparation, 1h de repos pour la pâte et enfin, 15min de cuisson. Sachant qu'il est 19h21, à quelle heure tu mets ta pizza au four?";
		this.reponseBonus = "20h41";

		music = "./Son/pizza.wav";

		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

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
	private final String CHEMIN_QUESTION = ".\\image\\ingredient\\pizza\\";
	private final String CHEMIN_ORDRE = ".\\image\\ingredient\\pizza\\ordre\\";
	}
