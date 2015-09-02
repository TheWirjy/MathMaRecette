
package mathmarecette.jeu.Recette;

import javax.swing.ImageIcon;

import mathmarecette.Tools;
import mathmarecette.menu.JFrameMenu;

public class Salade extends Recette
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public Salade()
		{
		super("Salade", "Sauce - Tomate - Concombre", 6, 7, 350);

		this.miniJeu = false;

		tabQuestion[0] = "Prépare une cuillère de moutarde et le double de mayonnaise au bol";
		tabQuestion[1] = "Prépare une cuillère d’huile et une de vinaigre au bol";
		tabQuestion[2] = "Prépare 3x une demi cuillère à café d’herbe de Provence et 3x moins de sel";
		tabQuestion[3] = "Mets sur la table trois grandes feuilles de salade";
		tabQuestion[4] = "Prépare ¼ de tomate";
		tabQuestion[5] = "Mets 1/6 de concombre sur la table";

		createQuestion(0, CHEMIN_QUESTION + "Q1R1.png", CHEMIN_QUESTION + "Q1R2.png", CHEMIN_QUESTION + "Q1R3.png", CHEMIN_QUESTION + "Q1R4.png");
		createQuestion(1, CHEMIN_QUESTION + "Q2R1.png", CHEMIN_QUESTION + "Q2R2.png", CHEMIN_QUESTION + "Q2R3.png", CHEMIN_QUESTION + "Q2R4.png");
		createQuestion(2, CHEMIN_QUESTION + "Q3R1.png", CHEMIN_QUESTION + "Q3R2.png", CHEMIN_QUESTION + "Q3R3.png", CHEMIN_QUESTION + "Q3R4.png");
		createQuestion(3, CHEMIN_QUESTION + "Q4R1.png", CHEMIN_QUESTION + "Q4R2.png", CHEMIN_QUESTION + "Q4R3.png", CHEMIN_QUESTION + "Q4R4.png");
		createQuestion(4, CHEMIN_QUESTION + "Q5R1.png", CHEMIN_QUESTION + "Q5R2.png", CHEMIN_QUESTION + "Q5R3.png", CHEMIN_QUESTION + "Q5R4.png");
		createQuestion(5, CHEMIN_QUESTION + "Q6R1.png", CHEMIN_QUESTION + "Q6R2.png", CHEMIN_QUESTION + "Q6R3.png", CHEMIN_QUESTION + "Q6R4.png");

		tabSolution[0] = 2;
		tabSolution[1] = 2;
		tabSolution[2] = 2;
		tabSolution[3] = 4;
		tabSolution[4] = 2;
		tabSolution[5] = 3;

		imageRecette = new ImageIcon(".//image//splach/splachSalade.png");
		imageTitre = new ImageIcon(CHEMIN_TITRE + "titre_salade.png");

		this.questionBonus = "Il est 11h53, le temps de préparation est de 8min, à quelle heure la salade sera prête?";
		this.reponseBonus = "12h01";

		music = "./Son/salade.wav";
		this.printImage = Tools.RECETTE_SALADE_IMAGE;
		this.printPdf = Tools.RECETTE_SALADE;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void ordreRecette(JFrameMenu parent)
		{
		parent.questionBonus();
		}

	@Override
	public void setMedaille()
		{
		int score = getScore();

		if (score >= scoreMax - 200) //>=150 au moins 3/7 reponse correct 42% juste = moyen
			{
			if (score >= scoreMax - 50) //>=300 au moins 6/7 reponse correct 85% juste = tres bien
				{
				medaille = Tools.M_SALADE_3;
				}
			else
				{
				medaille = Tools.M_SALADE_2;
				}
			}
		else
			// -42% juste
			{
			medaille = Tools.M_SALADE_1;
			}
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
