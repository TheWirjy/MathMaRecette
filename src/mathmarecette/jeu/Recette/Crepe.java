
package mathmarecette.jeu.Recette;

import javax.swing.ImageIcon;



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

			createQuestion(0, "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q1R1.png", "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q1R2.png",  "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q1R3.png", "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q1R4.png","1","1","1","1");
			createQuestion(1, "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q2R1.png", "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q2R2.png",  "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q2R3.png", "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q2R4.png","2","2","2","2");
			createQuestion(2, "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q3R1.png",  "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q3R2.png",  "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q3R3.png", "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q3R4.png","3","3","3","3");
			createQuestion(3,  "4", "4",  "4",  "4",  "4", "4",  "4",  "4");

			tabSolution[0] = 2;
			tabSolution[1] = 4;
			tabSolution[2] = 1;
			tabSolution[3] = 2;

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

