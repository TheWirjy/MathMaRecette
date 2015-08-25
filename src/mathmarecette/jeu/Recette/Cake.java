
package mathmarecette.jeu.Recette;

import javax.swing.ImageIcon;



public class Cake extends Recette
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Cake()
		{
			super("Cake au citron", "Citron - sirop", 5);

			tabQuestion[0] = "Il faut 4 blancs d��uf + 4 jaunes d��uf";
			tabQuestion[1] = "Pr�pare 10 carr�es de 10g de beurre et le double de sucre";
			tabQuestion[2] = "Il nous faut autant de farine que de sucre et � paquet de levure";
			tabQuestion[3] = "Le cake sera pr�t � 17h25 et la cuisson dure 35min. Quelle heure est-il ?";
			tabQuestion[4] = "Ajoute 5*4 morceaux de sucre dans la casserole";

			createQuestion(0, ".\\image\\ingredient\\Q1R1.png", "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q1R2.png",  "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q1R3.png", "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q1R4.png");
			createQuestion(1, "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q2R1.png", "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q2R2.png",  "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q2R3.png", "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q2R4.png");
			createQuestion(2, "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q3R1.png",  "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q3R2.png",  "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q3R3.png", "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q3R4.png");
			createQuestion(3,  "4", "4",  "4",  "4");
			createQuestion(4, "5", "5", "5", "5");

			tabSolution[0] = 1;
			tabSolution[1] = 3;
			tabSolution[2] = 1;
			tabSolution[3] = 4;
			tabSolution[4] = 1;

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

