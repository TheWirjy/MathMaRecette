
package mathmarecette.jeu.Recette;

import javax.swing.ImageIcon;

import mathmarecette.menu.JFrameMenu;

public class Salade extends Recette
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Salade()
		{
		super("Salade", "Sauce - Tomate - Concombre", 6, 7);

		this.miniJeu = false;

		tabQuestion[0] = "Ajoute une cuillère à soupe de moutarde et le double de mayonnaise au bol";
		tabQuestion[1] = "Ajoute une cuillère à café d’huile et une de vinaigre au bol";
		tabQuestion[2] = "Ajoute trois pincées d’herbe de Provence au bol et ajoute trois fois moins de pincées de sel";
		tabQuestion[3] = "Ajoute trois grandes feuilles de salade au plat";
		tabQuestion[4] = "Ajouter ¼ de tomate au plat";
		tabQuestion[5] = "Ajoute 1/6 de concombre au plat";

		createQuestion(0, CHEMIN_QUESTION + "Q1R1.png", CHEMIN_QUESTION + "Q1R2.png", CHEMIN_QUESTION + "Q1R3.png", CHEMIN_QUESTION + "Q1R4.png");
		createQuestion(1, CHEMIN_QUESTION + "Q2R1.png", CHEMIN_QUESTION + "Q2R2.png", CHEMIN_QUESTION + "Q2R3.png", CHEMIN_QUESTION + "Q2R4.png");
		createQuestion(2, CHEMIN_QUESTION + "Q3R1.png", CHEMIN_QUESTION + "Q3R2.png", CHEMIN_QUESTION + "Q3R3.png", CHEMIN_QUESTION + "Q3R4.png");
		createQuestion(3, CHEMIN_QUESTION + "Q4R1.png", CHEMIN_QUESTION + "Q4R2.png", CHEMIN_QUESTION + "Q4R3.png", CHEMIN_QUESTION + "Q4R4.png");
		createQuestion(4, CHEMIN_QUESTION + "Q5R1.png", CHEMIN_QUESTION + "Q5R2.png", CHEMIN_QUESTION + "Q5R3.png", CHEMIN_QUESTION + "Q5R4.png");
		createQuestion(5, CHEMIN_QUESTION + "Q6R1.png", CHEMIN_QUESTION + "Q6R2.png", CHEMIN_QUESTION + "Q6R3.png", CHEMIN_QUESTION + "Q6R4.png");

		tabSolution[0] = 3;
		tabSolution[1] = 2;
		tabSolution[2] = 3;//a voir
		tabSolution[3] = 4;
		tabSolution[4] = 2;
		tabSolution[5] = 2;

		imageRecette = new ImageIcon(".//image//splach/splachSalade.png");
		imageTitre = new ImageIcon(CHEMIN_TITRE + "titre_salade.png");
		music = "./Son/salade.wav";
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void ordreRecette(JFrameMenu parent)
		{
		parent.questionBonus();
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
	private final String CHEMIN_QUESTION = ".\\image\\ingredient\\salade\\";
	}
