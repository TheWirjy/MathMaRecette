
package mathmarecette.jeu;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import mathmarecette.jeu.Recette.Recette;

public class JPanelRecette extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelRecette(JFrame jframe, Recette recette)
		{
		this.jframe = jframe;
		this.recette = recette;
		geometry();
		control();
		appearance();

		//panelMenu.setTitre(recette.getNom());
		panelJeu.setQuestion(recette.getQuestion());
		jpanelIngredients.setIngredient(recette.getReponse());
		panelBarResult = panelJeu.getJPanelBarResult();

		panelBarResult.initialisation(recette.getNbQuestion());

		new JDialogAfficheRecette(jframe, new ImageIcon(".\\image\\SpaghettiRecette.png"));

		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void reponseValider(int _id)
		{
		boolean bJuste = recette.verificationReponse(_id);

		panelBarResult.setResultat(recette.getCptQuestion(), bJuste);

		/*if (bJuste)
			{
			System.out.println("Correct");
			}
		else
			{
			System.out.println("Faux");
			}*/

		if (recette.next())
			{
			panelJeu.getLabelQuestion().setText("<html><body><p align=\"center\">" + recette.getQuestion() + "</p></body></html>");
			//panelJeu.getLabelCasserole().setText(labelQuantite.getText());
			jpanelIngredients.setIngredient(recette.getReponse());
			}
		else
			{
			//http://www.spagety.net/wp-content/uploads/2015/03/%C5%A1pagety.png
			//new JDialogAfficheRecette(jframe, new ImageIcon("D:\\Desktop\\imgMMR\\SpaghettiRecette.png"));
			recette.getMiniJeu(jframe);
			}

		/*switch(numQuestion)
			{
			case 4:
				new JDialogAnnonceRecette(jframe, "Crêpes", "4 questions");
				break;
			case 8:
				new JDialogAnnonceRecette(jframe, "Cake au citron", "5 questions");
				break;
			case 12:
				new JDialogAnnonceRecette(jframe, "Pizza", "7 questions");
				break;
			case 20:
				new JDialogAnnonceRecette(jframe, "Salade", "7 questions");
				break;
			}*/
		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public JPanelJeu getJPanelJeu()
		{
		return panelJeu;
		}

	public JFrame getJFrame()
		{
		return jframe;
		}

	public Recette getRecette()
		{
		return recette;
		}

	public JPanelIngredients getPanelIngredients()
		{
		return jpanelIngredients;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		// JComponent : Instanciation
		jpanelIngredients = new JPanelIngredients(this);
		panelMenu = new JPanelInfoBar();
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
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JPanelIngredients jpanelIngredients;
	private JPanelJeu panelJeu;
	private JPanelInfoBar panelMenu;
	private JFrame jframe;
	private Recette recette;
	private JPanelBarResult panelBarResult;
	}
