
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
		super("Pizza", "Tomate - Mozzarella - Jambon", 8, 10);


		tabQuestion[0] = "Met 300g de farine";
		tabQuestion[1] = "Rajoute 2 œufs";
		tabQuestion[2] = "Rajoute 10g sucre";
		tabQuestion[3] = "Rajoute 15g sel";
		tabQuestion[4] = "Laisse reposer 1h sachant qu’il est 17h59";
		tabQuestion[5] = "Cuire la pâte pendant 20 minutes";
		tabQuestion[6] = "Chauffe 220g de sauce tomate";
		tabQuestion[7] = "Coupe  125g de mozzarella en 10 parts égales";

		createQuestion(0, CHEMIN_QUESTION + "Q1R1.png", CHEMIN_QUESTION + "Q1R2.png", CHEMIN_QUESTION + "Q1R3.png", CHEMIN_QUESTION + "Q1R4.png");
		createQuestion(1, CHEMIN_QUESTION + "Q2R1.png", CHEMIN_QUESTION + "Q2R2.png", CHEMIN_QUESTION + "Q2R3.png", CHEMIN_QUESTION + "Q2R4.png");
		createQuestion(2, CHEMIN_QUESTION + "Q3R1.png", CHEMIN_QUESTION + "Q3R2.png", CHEMIN_QUESTION + "Q3R3.png", CHEMIN_QUESTION + "Q3R4.png");
		createQuestion(3, "4", "4", "4", "4");
		createQuestion(4, "5", "5", "5", "5");
		createQuestion(5, CHEMIN_QUESTION + "Q6R1.png", CHEMIN_QUESTION + "Q6R2.png", CHEMIN_QUESTION + "Q6R3.png", CHEMIN_QUESTION + "Q6R4.png");
		createQuestion(6, "7", "7", "7", "7");
		createQuestion(7, "8", "8", "8", "8");

		tabSolution[0] = 4;
		tabSolution[1] = 1;
		tabSolution[2] = 3;
		tabSolution[3] = 2;
		tabSolution[4] = 2;
		tabSolution[5] = 1;
		tabSolution[6] = 3;
		tabSolution[7] = 2;

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

		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*@Override
	public void ordreRecette(JFrameRecette parent, JPanelJeu panelJeu)
		{
		new JDialogOrdreRecette(parent, this, panelJeu);
		}*/

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
