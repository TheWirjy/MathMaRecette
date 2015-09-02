
package mathmarecette.jeu.Recette;

import javax.swing.ImageIcon;

import mathmarecette.Tools;
import mathmarecette.jeu.ingredient.IngredientOrdre;
import mathmarecette.jeu.ordre.JPanelIngredientOrdre;

public class Cake extends Recette
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Cake()
		{

		super("Cake au citron", "Citron - sirop", 4, 6, 450);

		//definition des question
		tabQuestion[0] = "Il faut 4 blancs d’œuf + 4 jaunes d’œuf";
		tabQuestion[1] = "Prépare 10 carrées de 10g de beurre et le double de sucre <i>(1 plaque de beurre = 200g)</i>";
		tabQuestion[2] = "Il nous faut autant de farine que de sucre et ½ carré de levure";
		tabQuestion[3] = "Ajoute 5x4 morceaux de sucre dans la casserole (un morceau = 5g) et 4x le jus d un demi citron";

		//definition des reponse au question QCM
		createQuestion(0, CHEMIN_QUESTION + "Q1R1.png", CHEMIN_QUESTION + "Q1R2.png", CHEMIN_QUESTION + "Q1R3.png", CHEMIN_QUESTION + "Q1R4.png");
		createQuestion(1, CHEMIN_QUESTION + "Q2R1.png", CHEMIN_QUESTION + "Q2R2.png", CHEMIN_QUESTION + "Q2R3.png", CHEMIN_QUESTION + "Q2R4.png");
		createQuestion(2, CHEMIN_QUESTION + "Q3R1.png", CHEMIN_QUESTION + "Q3R2.png", CHEMIN_QUESTION + "Q3R3.png", CHEMIN_QUESTION + "Q3R4.png");
		createQuestion(3, CHEMIN_QUESTION + "Q5R1.png", CHEMIN_QUESTION + "Q5R2.png", CHEMIN_QUESTION + "Q5R3.png", CHEMIN_QUESTION + "Q5R4.png");

		//definition des solution au qcm
		tabSolution[0] = 2;
		tabSolution[1] = 1;
		tabSolution[2] = 3;
		tabSolution[3] = 4;

		//tableau de carte pour le mini jeu
		// http://www.marmiton.org/recettes/recette_cake-au-citron_11391.aspx
		this.tabIngredientOrdre = new IngredientOrdre[13];
		tabIngredientOrdre[0] = new IngredientOrdre(CHEMIN_ORDRE + "bol.png", "Sortir bol");
		tabIngredientOrdre[1] = new IngredientOrdre(CHEMIN_ORDRE + "oeuf.png", "Séparer blanc/jaune");
		tabIngredientOrdre[2] = new IngredientOrdre(CHEMIN_ORDRE + "beurre.png", "Fondre le beurre");
		tabIngredientOrdre[3] = new IngredientOrdre(CHEMIN_ORDRE + "citron.png", "Râper le citron");
		tabIngredientOrdre[4] = new IngredientOrdre(CHEMIN_ORDRE + "neige.png", "Monter blancs en neige");
		tabIngredientOrdre[5] = new IngredientOrdre(CHEMIN_ORDRE + "jaune_sucre.png", "Mélanger jaune + sucre");
		tabIngredientOrdre[6] = new IngredientOrdre(CHEMIN_ORDRE + "zeste.png", "Ajouter citron râpé");
		tabIngredientOrdre[7] = new IngredientOrdre(CHEMIN_ORDRE + "farine.png", "Ajouter farine");
		tabIngredientOrdre[8] = new IngredientOrdre(CHEMIN_ORDRE + "levure.png", "Ajouter levure");
		tabIngredientOrdre[9] = new IngredientOrdre(CHEMIN_ORDRE + "beurre_fondu.png", "Ajouter beurre fondue");
		tabIngredientOrdre[10] = new IngredientOrdre(CHEMIN_ORDRE + "blanc_neige.png", "Ajouter blanc neige");
		tabIngredientOrdre[11] = new IngredientOrdre(CHEMIN_ORDRE + "four.png", "Cuisson");
		tabIngredientOrdre[12] = new IngredientOrdre(CHEMIN_ORDRE + "sirop.png", "Faire le sirop");

		//definition des indice de position pour le mini jeu d ordre (lié au tableau ci dessus)
		this.tabOrdreIndice = new int[13];
		tabOrdreIndice[0] = 0;
		tabOrdreIndice[1] = 1;
		tabOrdreIndice[2] = 2;
		tabOrdreIndice[3] = 3;
		tabOrdreIndice[4] = 4;
		tabOrdreIndice[5] = 5;
		tabOrdreIndice[6] = 6;
		tabOrdreIndice[7] = 6;
		tabOrdreIndice[8] = 6;
		tabOrdreIndice[9] = 6;
		tabOrdreIndice[10] = 7;
		tabOrdreIndice[11] = 8;
		tabOrdreIndice[12] = 9;

		//image d intro de la recette (Splash)
		imageRecette = new ImageIcon(".//image//splach/splachCake.png");
		//image du titre pour le panel menu
		imageTitre = new ImageIcon(CHEMIN_TITRE + "titre_cake.png");

		//question + reponse a la question de l horloge
		this.questionBonus = "Il faut 3 quarts d'heure pour faire le cake. Actuellement il est 17h13, indique à quelle heure tu pourras le déguster.";
		this.reponseBonus = "17h58";

		//definition du son de la recette
		music = "./Son/cake.wav";
		//definition du pdf a imprimer et de l image preview de cette recette
		this.printImage = Tools.RECETTE_CAKE_IMAGE;
		this.printPdf = Tools.RECETTE_CAKE;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	//set la medaille en fonction des point obtenu
	@Override
	public void setMedaille()
		{
		int score = getScore();

		if (score >= scoreMax - 200)
			{
			if (score >= scoreMax - 50)
				{
				medaille = Tools.M_CAKE_3;
				}
			else
				{
				medaille = Tools.M_CAKE_2;
				}
			}
		else
			{
			medaille = Tools.M_CAKE_1;
			}
		}

	//le cake est different des autre car 4 carte sont au meme niveau (l ordre n importe pas donc) mais parmi ces 4, 2 d entre elle doit suivre un certain ordre
	@Override
	public int checkReponseOrdre(JPanelIngredientOrdre[] ingr)
		{
		int cptBonneRep = 0;
		int posNeige = 0;
		int posOeuf = 0;

		for(int i = 0; i < ingr.length; i++)
			{

			if (ingr[i].getID_ordre() == 4)
				{
				posNeige = ingr[i].getID_pos();
				}
			else if (ingr[i].getID_ordre() == 1)
				{
				posOeuf = ingr[i].getID_pos();
				}

			if (i > 0 && i < 5)
				{
				if (ingr[i].getID_ordre() == 1 || ingr[i].getID_ordre() == 2 || ingr[i].getID_ordre() == 3 || ingr[i].getID_ordre() == 4)
					{
					cptBonneRep++;
					}
				}
			else
				{
				if (ingr[i].getID_ordre() == tabOrdreIndice[i])
					{
					cptBonneRep++;
					}
				}
			}

		if (posOeuf < 5 && posOeuf > 0 && posNeige < 5 && posNeige > 0 && posOeuf > posNeige)
			{
			cptBonneRep -= 2;
			}

		return cptBonneRep;
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

	//definition des chemin pour les images
	private final String CHEMIN_QUESTION = ".\\image\\ingredient\\cake\\";
	private final String CHEMIN_ORDRE = ".\\image\\ingredient\\cake\\ordre\\";
	}
