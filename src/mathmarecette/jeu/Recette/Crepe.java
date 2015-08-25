
package mathmarecette.jeu.Recette;

import javax.swing.ImageIcon;



public class Crepe extends Recette
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Crepe()
		{
			super("Cr�pes", "P�te � cr�pe nature", 4);

			tabQuestion[0] = "Ajoute 2* 125g de farine";
			tabQuestion[1] = "Avec une boite de 6 �ufs on fait 3 p�tes � cr�pes, combien t'en faut-il pour en faire une";
			tabQuestion[2] = "Ajoute � quantit� �gal de l�eau et du lait pour un total de 0.5l";
			tabQuestion[3] = "Ajoute [(5+3)/4] cuill�re � soupe d�huile";

			createQuestion(0, ".\\image\\ingredient\\crepe\\Q1R1.png" , ".\\image\\ingredient\\crepe\\Q1R2.png",  ".\\image\\ingredient\\crepe\\Q1R3.png", ".\\image\\ingredient\\crepe\\Q1R4.png");
			createQuestion(1, ".\\image\\ingredient\\crepe\\Q2R1.png", ".\\image\\ingredient\\crepe\\Q2R2.png",  ".\\image\\ingredient\\crepe\\Q2R3.png", ".\\image\\ingredient\\crepe\\Q2R4.png");
			createQuestion(2, ".\\image\\ingredient\\crepe\\Q3R1.png",  ".\\image\\ingredient\\crepe\\Q3R2.png",  ".\\image\\ingredient\\crepe\\Q3R3.png", ".\\image\\ingredient\\crepe\\Q3R4.png");
			createQuestion(3,  ".\\image\\ingredient\\crepe\\Q4R1.png", ".\\image\\ingredient\\crepe\\Q4R2.png",  ".\\image\\ingredient\\crepe\\Q4R3.png", ".\\image\\ingredient\\crepe\\Q4R4.png");

			tabSolution[0] = 2;
			tabSolution[1] = 4;
			tabSolution[2] = 1;
			tabSolution[3] = 4;

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

