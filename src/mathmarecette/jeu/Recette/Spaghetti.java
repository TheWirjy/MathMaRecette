
package mathmarecette.jeu.Recette;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import mathmarecette.jeu.memory.JDialogMemory;

public class Spaghetti extends Recette
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Spaghetti()
		{
		super("Spaghetti", "Nature", 4);

		tabQuestion[0] = "Verse 2*1 bouteille d’ 1 litre dans la casserole";
		tabQuestion[1] = "Ajoute 1 première cuillère de sel et ensuite ajoute en deux";
		tabQuestion[2] = "Le paquet de pate contient 500g laisse 300g dans le paquet et ajoute le reste dans la casserole";
		tabQuestion[3] = "Il est 15h35, les pates doivent cuire 8min, à quelle heure seront-elle prête ?";

		createQuestion(0, ".\\image\\ingredient\\Q1R1_.png", ".\\image\\ingredient\\Q1R2_.png", ".\\image\\ingredient\\Q1R3_.png", ".\\image\\ingredient\\Q1R4_.png", "1", "1", "1", "1");
		createQuestion(1, ".\\image\\ingredient\\Q2R1.png", ".\\image\\ingredient\\Q2R2.png", ".\\image\\ingredient\\Q2R3.png", ".\\image\\ingredient\\Q2R4.png", "2", "2", "2", "2");
		createQuestion(2, ".\\image\\ingredient\\Q3R1.png", ".\\image\\ingredient\\Q3R2.png", ".\\image\\ingredient\\Q3R3.png", ".\\image\\ingredient\\Q3R4.png", "3", "3", "3", "3");
		createQuestion(3, ".\\image\\ingredient\\Q4R1.png", ".\\image\\ingredient\\Q4R2.png", ".\\image\\ingredient\\Q4R3.png", ".\\image\\ingredient\\Q4R4.png", "4", "4", "4", "4");

		tabSolution[0] = 1;
		tabSolution[1] = 2;
		tabSolution[2] = 4;
		tabSolution[3] = 3;

		imageRecette = new ImageIcon("");

		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void getMiniJeu(JFrame jframe)
		{
			new JDialogMemory(jframe);
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
	}
