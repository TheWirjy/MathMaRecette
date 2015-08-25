
package mathmarecette.jeu.Recette;

import javax.swing.ImageIcon;

import mathmarecette.jeu.ingredient.IngredientOrdre;
import mathmarecette.jeu.ordre.JFrameOrdreRecette;

public class Spaghetti extends Recette
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Spaghetti()
		{
		super("Spaghetti", "Nature", 4);

		tabQuestion[0] = "Verse 2*1 bouteille d� 1 litre dans la casserole";
		tabQuestion[1] = "Ajoute 1 premi�re cuill�re de sel et ensuite ajoute en deux";
		tabQuestion[2] = "Le paquet de pate contient 500g laisse 300g dans le paquet et ajoute le reste dans la casserole";
		tabQuestion[3] = "Il est 15h35, les pates doivent cuire 8min, � quelle heure seront-elle pr�te ?";

		createQuestion(0, ".\\image\\ingredient\\Q1R1_.png", ".\\image\\ingredient\\Q1R2_.png", ".\\image\\ingredient\\Q1R3_.png", ".\\image\\ingredient\\Q1R4_.png");
		createQuestion(1, ".\\image\\ingredient\\Q2R1.png", ".\\image\\ingredient\\Q2R2.png", ".\\image\\ingredient\\Q2R3.png", ".\\image\\ingredient\\Q2R4.png");
		createQuestion(2, ".\\image\\ingredient\\Q3R1.png", ".\\image\\ingredient\\Q3R2.png", ".\\image\\ingredient\\Q3R3.png", ".\\image\\ingredient\\Q3R4.png");
		createQuestion(3, ".\\image\\ingredient\\Q4R1.png", ".\\image\\ingredient\\Q4R2.png", ".\\image\\ingredient\\Q4R3.png", ".\\image\\ingredient\\Q4R4.png");

		tabSolution[0] = 1;
		tabSolution[1] = 2;
		tabSolution[2] = 4;
		tabSolution[3] = 3;

		this.tabIngredientOrdre = new IngredientOrdre[3];
		tabIngredientOrdre[0] = new IngredientOrdre(".\\image\\ingredient\\Q1R1_.png", "Eau");
		tabIngredientOrdre[1] = new IngredientOrdre(".\\image\\ingredient\\Q2R2.png", "Sel");
		tabIngredientOrdre[2] = new IngredientOrdre(".\\image\\ingredient\\Q3R4.png", "P�tes");

		imageRecette = new ImageIcon("");

		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void ordreRecette()
		{
			new JFrameOrdreRecette(this);
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
