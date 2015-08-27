
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

	public JPanelRecette(JFrameRecette jframe, Recette recette)
		{
		this.jframe = jframe;
		this.recette = recette;
		geometry();
		control();
		appearance();

		panelBarResult = panelJeu.getJPanelBarResult();
		panelJeu.setSplash(recette.getImageRecette());

		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void startRecette()
		{
		panelBarResult.initialisation(recette.getNbQuestion());
		panelJeu.setQuestion(recette.getQuestion());
		panelJeu.setIngredient(recette.getReponse());
		panelMenu.setTitre(recette.getImageTitre());
		//panelJeu.remplirTable(recette.getIngredientTable());
		panelMenu.start();
		}

	public void reponseValider(int _id, ImageIcon icon, int x, int y)
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
			panelJeu.setIngredient(recette.getReponse());
			panelJeu.addIngr(icon, recette.getCptQuestion() - 1, x,y);
			//panelJeu.removeIngr(recette.getCptQuestion()-1, (ImageIcon)icon);
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

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		// JComponent : Instanciation
		panelMenu = new JPanelInfoBar(jframe);
		panelJeu = new JPanelJeu(this);

		setLayout(null);

		// JComponent : add
		add(panelMenu);
		add(panelJeu);
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

	private JPanelJeu panelJeu;
	private JPanelInfoBar panelMenu;
	private JFrameRecette jframe;
	private Recette recette;
	private JPanelBarEtat panelBarResult;
	}
