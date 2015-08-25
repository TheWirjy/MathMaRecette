
package mathmarecette.jeu.Recette;

import javax.swing.ImageIcon;



public class Pizza extends Recette
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Pizza()
	{
		super("Pizza", "Tomate - Mozzarella - Jambon", 8);

		tabQuestion[0] = "Met 300g de farine";
		tabQuestion[1] = "Rajoute 2 œufs";
		tabQuestion[2] = "Rajoute 10g sucre";
		tabQuestion[3] = "Rajoute 15g sel";
		tabQuestion[4] = "Laisse reposer 1h sachant qu’il est 17h59";
		tabQuestion[5] = "Cuire la pâte pendant 20 minutes";
		tabQuestion[6] = "Chauffe 220g de sauce tomate";
		tabQuestion[7] = "Coupe  125g de mozzarella en 10 parts égales";

		createQuestion(0, "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q1R1.png", "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q1R2.png",  "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q1R3.png", "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q1R4.png");
		createQuestion(1, "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q2R1.png", "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q2R2.png",  "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q2R3.png", "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q2R4.png");
		createQuestion(2, "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q3R1.png",  "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q3R2.png",  "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q3R3.png", "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q3R4.png");
		createQuestion(3,  "4", "4",  "4", "4");
		createQuestion(4, "5", "5", "5", "5");
		createQuestion(5, "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q6R1.png", "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q6R2.png", "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q6R3.png", "C:\\Users\\jeremy.wirth\\Desktop\\imgMMR\\Q6R4.png");
		createQuestion(6, "7", "7", "7","7");
		createQuestion(7, "8", "8","8","8");

		tabSolution[0] = 4;
		tabSolution[1] = 1;
		tabSolution[2] = 3;
		tabSolution[3] = 2;
		tabSolution[4] = 2;
		tabSolution[5] = 1;
		tabSolution[6] = 3;
		tabSolution[7] = 2;

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

