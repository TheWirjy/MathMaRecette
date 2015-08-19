
package mathmarecette;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class JPanelRecette extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelRecette()
		{
		tabReponse = new Ingredient[26][];
		listQuestion = new ArrayList<String>();

		for(int i = 0; i < tabReponse.length; i++)
			{
			tabReponse[i] = new Ingredient[4];
			}

		createTableauReponse();
		createTableauQuestion();

		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	private void createTableauQuestion()
		{
		listQuestion.add("Verse 2*1 bouteille d’ 1 litre dans la casserole");
		listQuestion.add("Ajoute 1 première cuillère de sel et ensuite ajoute en deux");
		listQuestion.add("Le paquet de pate contient 500g laisse 300g dans le paquet et ajoute le reste dans la casserole");
		listQuestion.add("Il est 15h35, les pates doivent cuire 8min, à quelle heure seront-elle prête ?");
		listQuestion.add("Ajoute 2* 125g de farine");
		listQuestion.add("Avec une boite de 6 œufs on fait 3 pâtes à crêpes, combien t'en faut-il pour en faire une");
		listQuestion.add("Ajoute à quantité égal de l’eau et du lait pour un total de 0.5l");
		listQuestion.add("Ajoute [(5+3)/4] cuillère à soupe d’huile");
		listQuestion.add("Il faut 4 blancs d’œuf + 4 jaunes d’œuf");
		listQuestion.add("Prépare 10 carrées de 10g de beurre et le double de sucre");
		listQuestion.add("Il nous faut autant de farine que de sucre et ½ paquet de levure");
		listQuestion.add("Le cake sera prêt à 17h25 et la cuisson dure 35min. Quelle heure est-il ?");
		listQuestion.add("Ajoute 5*4 morceaux de sucre dans la casserole");
		listQuestion.add("Met 300g de farine");
		listQuestion.add("Rajoute 2 œufs");
		listQuestion.add("Rajoute 10g sucre");
		listQuestion.add("Rajoute 15g sel");
		listQuestion.add("Laisse reposer 1h sachant qu’il est 17h59");
		listQuestion.add("Cuire la pâte pendant 20 minutes");
		listQuestion.add("Chauffe 220g de sauce tomate");
		listQuestion.add("Coupe  125g de mozzarella en 10 parts égales");
		listQuestion.add("Ajoute une cuillère à soupe de moutarde et le double de mayonnaise au bol");
		listQuestion.add("Ajoute une cuillère à café d’huile et une de vinaigre au bol");
		listQuestion.add("Ajoute trois pincées d’herbe de Provence au bol et ajoute trois fois moins de pincées de sel ");
		listQuestion.add("Ajoute trois grandes feuilles de salade au plat");
		listQuestion.add("Ajoute 1/6 de concombre au plat ");
		listQuestion.add("Verser 0,1l de la sauce faite dans le plat ");
		}

	private void createTableauReponse()
		{
		createQuestion(0, "D:\\Desktop\\apple.png", "1", "D:\\Desktop\\apple.png", "1", "D:\\Desktop\\apple.png", "1", "D:\\Desktop\\apple.png", "1");
		createQuestion(1, "*", "2", "*", "2", "*", "2", "*", "2");
		createQuestion(2, "*", "3", "*", "3", "*", "3", "*", "3");
		createQuestion(3, "*", "4", "*", "4", "*", "4", "*", "4");
		createQuestion(4, "*", "5", "*", "5", "*", "5", "*", "5");
		createQuestion(5, "*", "6", "*", "6", "*", "6", "*", "6");
		createQuestion(6, "*", "7", "*", "7", "*", "7", "*", "7");
		createQuestion(7, "*", "8", "*", "8", "*", "8", "*", "8");
		createQuestion(8, "*", "9", "*", "9", "*", "9", "*", "9");
		createQuestion(9, "*", "10", "*", "10", "*", "10", "*", "10");
		createQuestion(10, "*", "11", "*", "11", "*", "11", "*", "11");
		createQuestion(11, "*", "12", "*", "12", "*", "12", "*", "12");
		createQuestion(12, "*", "13", "*", "13", "*", "13", "*", "13");
		createQuestion(13, "*", "14", "*", "14", "*", "14", "*", "14");
		createQuestion(14, "*", "15", "*", "15", "*", "15", "*", "15");
		createQuestion(15, "*", "16", "*", "16", "*", "16", "*", "16");
		createQuestion(16, "*", "17", "*", "17", "*", "17", "*", "17");
		createQuestion(17, "*", "18", "*", "18", "*", "18", "*", "18");
		createQuestion(18, "*", "19", "*", "19", "*", "19", "*", "19");
		createQuestion(19, "*", "20", "*", "20", "*", "20", "*", "20");
		createQuestion(20, "*", "21", "*", "21", "*", "21", "*", "21");
		createQuestion(21, "*", "22", "*", "22", "*", "22", "*", "22");
		createQuestion(22, "*", "23", "*", "23", "*", "23", "*", "23");
		createQuestion(23, "*", "24", "*", "24", "*", "24", "*", "24");
		createQuestion(24, "*", "25", "*", "25", "*", "25", "*", "25");
		createQuestion(25, "*", "26", "*", "26", "*", "26", "*", "26");
		}

	private void createQuestion(int numQuestion, String img1, String q1, String img2, String q2, String img3, String q3, String img4, String q4)
		{
		tabReponse[numQuestion][0] = new Ingredient(img1, q1);
		tabReponse[numQuestion][1] = new Ingredient(img2, q2);
		tabReponse[numQuestion][2] = new Ingredient(img3, q3);
		tabReponse[numQuestion][3] = new Ingredient(img4, q4);
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public List<String> getListQuestion()
	{
		return listQuestion;
	}

	public Ingredient[][] gettabReponse()
	{
		return tabReponse;
	}

	public JPanelJeu getJPanelJeu()
		{
			return panelJeu;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		// JComponent : Instanciation
		jpanelIngredients = new JPanelIngredients(this);
		panelMenu = new JPanelMenu();
		panelJeu = new JPanelJeu();

		setLayout(null);

		// JComponent : add
		add(panelMenu);
		add(panelJeu);
		add(jpanelIngredients);
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		// rien
		jpanelIngredients.setIngredient(tabReponse[0]);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JPanelIngredients jpanelIngredients;
	private Ingredient[][] tabReponse;
	private List<String> listQuestion;
	private JPanelJeu panelJeu;
	private JPanelMenu panelMenu;

	}
