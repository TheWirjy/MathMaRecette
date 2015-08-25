
package mathmarecette.jeu.Recette;

import javax.swing.ImageIcon;



public class Salade extends Recette
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Salade()
		{
			super("Salade", "Sauce - Tomate - Concombre", 7);

			tabQuestion[0] = "Ajoute une cuillère à soupe de moutarde et le double de mayonnaise au bol";
			tabQuestion[1] = "Ajoute une cuillère à café d’huile et une de vinaigre au bol";
			tabQuestion[2] = "Ajoute trois pincées d’herbe de Provence au bol et ajoute trois fois moins de pincées de sel";
			tabQuestion[3] = "Ajoute trois grandes feuilles de salade au plat";
			tabQuestion[4] = "Ajouter ¼ de tomate au plat";
			tabQuestion[5] = "Ajoute 1/6 de concombre au plat";
			tabQuestion[6] = "Verse 0,1l de la sauce faite dans le plat";

			createQuestion(0, "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q1R1.png", "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q1R2.png",  "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q1R3.png", "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q1R4.png");
			createQuestion(1, "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q2R1.png", "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q2R2.png",  "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q2R3.png", "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q2R4.png");
			createQuestion(2, "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q3R1.png",  "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q3R2.png",  "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q3R3.png", "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q3R4.png");
			createQuestion(3,  "4", "4",  "4",  "4");
			createQuestion(4, "5", "5", "5", "5");
			createQuestion(5, "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q6R1.png", "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q6R2.png", "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q6R3.png", "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q6R4.png");
			createQuestion(6, "7", "7", "7","7");

			tabSolution[0] = 3;
			tabSolution[1] = 2;
			tabSolution[2] = 3;//a voir
			tabSolution[3] = 4;
			tabSolution[4] = 2;
			tabSolution[5] = 2;
			tabSolution[6] = 1;

			imageRecette = new ImageIcon("");

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
	}

