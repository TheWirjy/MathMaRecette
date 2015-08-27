
package mathmarecette.jeu;

import javax.swing.JFrame;
import javax.swing.JPanel;

import mathmarecette.jeu.Recette.Recette;

public class JPanelRecette extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelRecette(JFrameRecette jframe, Recette recette)
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
		panelJeu.setSplash(recette.getImageRecette());
		//new JDialogAfficheRecette(jframe, new ImageIcon(".\\image\\SpaghettiRecette.png"));

		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void reponseValider(int _id)
		{
		boolean bJuste = recette.verificationReponse(_id);

		if (bJuste)
			{
			recette.addScore(50);
			panelJeu.setScore(recette.getScore());
			}

		panelBarResult.setResultat(recette.getCptQuestion(), bJuste);


		if (recette.next())
			{
			panelJeu.getLabelQuestion().setText("<html><body><p align=\"center\">" + recette.getQuestion() + "</p></body></html>");
			jpanelIngredients.setIngredient(recette.getReponse());
			}
		else
			{
			//http://www.spagety.net/wp-content/uploads/2015/03/%C5%A1pagety.png
			//new JDialogAfficheRecette(jframe, new ImageIcon("D:\\Desktop\\imgMMR\\SpaghettiRecette.png"));
			recette.ordreRecette(jframe);
			}

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
	private JFrameRecette jframe;
	private Recette recette;
	private JPanelBarEtat panelBarResult;
	}
