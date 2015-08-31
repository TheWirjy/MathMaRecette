
package mathmarecette.jeu.Recette;

import javax.swing.ImageIcon;

import mathmarecette.jeu.ingredient.IngredientOrdre;

public class Spaghetti extends Recette
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Spaghetti()
		{
		super("Spaghetti", "Nature", 3, 5);

		tabQuestion[0] = "Il faut 2*1 bouteille d� 1 litre <i>(Un r�cipient plein = 1L)</i>";
		tabQuestion[1] = "On a besoin de 15g de sel (1 cuill�re = 5g)";
		tabQuestion[2] = "Le paquet de p�te contient 500g laisse 300g dans le paquet et prend le reste";

		createQuestion(0, CHEMIN_QUESTION + "Q1R1.png", CHEMIN_QUESTION + "Q1R2.png", CHEMIN_QUESTION + "Q1R3.png", CHEMIN_QUESTION + "Q1R4.png");
		createQuestion(1, CHEMIN_QUESTION + "Q2R1.png", CHEMIN_QUESTION + "Q2R2.png", CHEMIN_QUESTION + "Q2R3.png", CHEMIN_QUESTION + "Q2R4.png");
		createQuestion(2, CHEMIN_QUESTION + "Q3R1.png", CHEMIN_QUESTION + "Q3R2.png", CHEMIN_QUESTION + "Q3R3.png", CHEMIN_QUESTION + "Q3R4.png");

		tabSolution[0] = 1;
		tabSolution[1] = 2;
		tabSolution[2] = 4;

		this.tabIngredientOrdre = new IngredientOrdre[5];
		tabIngredientOrdre[0] = new IngredientOrdre(CHEMIN_ORDRE + "eau.png", "Eau");
		tabIngredientOrdre[1] = new IngredientOrdre(CHEMIN_ORDRE + "sel.png", "Sel");
		tabIngredientOrdre[2] = new IngredientOrdre(CHEMIN_ORDRE + "pate.png", "P�tes");
		tabIngredientOrdre[3] = new IngredientOrdre(CHEMIN_ORDRE + "casserole.png", "Cuisson");
		tabIngredientOrdre[4] = new IngredientOrdre(CHEMIN_ORDRE + "huile.png", "Huile d'olive");

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

		this.questionBonus = "Il est 15h37, les p�tes doivent cuire 6min, � quelle heure seront-elle pr�te ?";
		this.reponseBonus = "15h43";
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
	private final String CHEMIN_QUESTION = ".\\image\\ingredient\\spaghetti\\";
	private final String CHEMIN_ORDRE = ".\\image\\ingredient\\spaghetti\\ordre\\";
	}
