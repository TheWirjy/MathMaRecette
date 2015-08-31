
package mathmarecette.jeu.ordre;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import mathmarecette.Tools;
import mathmarecette.jeu.JPanelRecette;
import mathmarecette.jeu.Recette.Recette;

public class JPanelOrdreRecette extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/**
	 * 
	 */
	private static final long serialVersionUID = 8641894428622130919L;
	public JPanelOrdreRecette(Recette recette, JDialog dialog, JPanelRecette panelRecette)
		{
		this.recette = recette;
		this.dialog = dialog;
		this.panelRecette = panelRecette;
		label = new JPanelIngredientOrdre[recette.getTabIngredientOrdre().length];
		int[] tabOrdreIndice = recette.getTabOrdreIndice();

		for(int i = 0; i < label.length; i++)
			{

			JPanelIngredientOrdre newPanel = new JPanelIngredientOrdre(i, tabOrdreIndice[i], 10 + SIZE_PANEL * i + i * 2, recette.getTabIngredientOrdre()[i].getImage(), recette.getTabIngredientOrdre()[i].getNom());
			newPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			label[i] = newPanel;
			label[i].addMouseMotionListener(new MouseMotionAdapter()
				{

					@Override
					public void mouseDragged(MouseEvent e)
						{
						// TODO Auto-generated method stub

						JPanelIngredientOrdre panelDrag = (JPanelIngredientOrdre)e.getComponent();

						panelDrag.setLocation(panelDrag.getX() + e.getX() - xSourisClick, panelDrag.getY());

						if ((panelDrag.getX() - panelDrag.getPositionX()) > M_SIZE_PANEL)
							{
							if (panelDrag.getID_pos() + 1 < label.length)
								{
								swapLabel(panelDrag.getID_pos(), panelDrag.getID_pos() + 1);
								}
							}

						if ((panelDrag.getX() - panelDrag.getPositionX()) < -M_SIZE_PANEL)
							{
							if (panelDrag.getID_pos() - 1 > -1)
								{
								swapLabel(panelDrag.getID_pos(), panelDrag.getID_pos() - 1);
								}
							}
						}
				});

			label[i].addMouseListener(new MouseAdapter()
				{

					@Override
					public void mousePressed(MouseEvent e)
						{
						xSourisClick = e.getX();
						setComponentZOrder(e.getComponent(), 0);
						}

					@Override
					public void mouseReleased(MouseEvent e)
						{
						JPanelIngredientOrdre panelDrag = (JPanelIngredientOrdre)e.getComponent();
						panelDrag.setLocation(panelDrag.getPositionX(), posIngr);
						}
				});
			}

		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void swapLabel(int i1, int i2)
		{
		label[i2].setLocation(label[i1].getPositionX(), posIngr);

		int tmp = label[i2].getID_pos();
		label[i2].setID_pos(label[i1].getID_pos());
		label[i1].setID_pos(tmp);

		tmp = label[i2].getPositionX();
		label[i2].setPositionX(label[i1].getPositionX());
		label[i1].setPositionX(tmp);

		JPanelIngredientOrdre temp = label[i1];
		label[i1] = label[i2];
		label[i2] = temp;
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

	private void geometry()
		{
		// JComponent : Instanciation
		buttonValider = new JButton("Valider");
		labelResultat = new JLabel("5 �ssais restants");

		labelIndication = new JLabelIndication();

		setLayout(null);

		for(int i = 0; i < recette.getTabIngredientOrdre().length; i++)
			{
			add(label[i]);
			setComponentZOrder(label[i], i);
			}

		Random gen = new Random();
		for(int i = 0; i < label.length; i++)
			{
			int rand = gen.nextInt(label.length - 1);

			swapLabel(i, rand);
			label[rand].setLocation(label[rand].getPositionX(), posIngr);
			}

		add(buttonValider);
		add(labelIndication);
		add(labelResultat);

		}

	private void control()
		{
		// rien
		buttonValider.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e)
					{
					// TODO Auto-generated method stub
					if (!fini)
						{
						if (nbEssai > 0)
							{
							nbEssai--;
							cptBonneRep = recette.checkReponseOrdre(label);

							if (cptBonneRep == label.length)
								{
								recette.addScore(50*(nbEssai+1));
								labelResultat.setText("Tu as r�ussi!! Clique sur continuer pour passer � la suite");
								buttonValider.setText("Continuer");
								fini = true;
								}
							else
								{
								labelResultat.setText(cptBonneRep + "/" + label.length + " Bonne r�ponse - plus que " + nbEssai + "essai(s)");
								}
							cptBonneRep = 0;
							}
						else
							{
							recette.addScore(0);
							labelResultat.setText("Tu n'as plus d'essai. Clique sur continuer pour passer � la suite");
							buttonValider.setText("Continuer");
							fini = true;
							}
						}
					else
						{
						dialog.dispose();
						panelRecette.startQuestionBonus();
						}
					}
			});
		}

	private void appearance()
		{
		int nbElement = recette.getTabIngredientOrdre().length;
		setPreferredSize(new Dimension(18 + SIZE_PANEL * nbElement + nbElement * 2, 330));
		setSize(new Dimension(8 + SIZE_PANEL * nbElement + nbElement * 2, 300));
		setBackground(Tools.COLOR_MUR);

		if (this.getWidth() > 600)
			{
			labelIndication.setSize(600, 50);
			labelIndication.setLocation(this.getWidth() / 2 - labelIndication.getWidth() / 2, 20);
			}
		else
			{
			labelIndication.setSize(this.getWidth() - 20, 50);
			labelIndication.setLocation(10, 20);
			}

		labelResultat.setSize(this.getWidth() - 20, 50);
		labelResultat.setLocation(10, 80);
		labelResultat.setForeground(Tools.COLOR_BLEU);
		labelResultat.setFont(new Font("Verdana", Font.BOLD, 14));
		labelResultat.setHorizontalAlignment(SwingConstants.CENTER);
		labelResultat.setVerticalAlignment(SwingConstants.CENTER);

		buttonValider.setBackground(Tools.COLOR_CASE_INGREDIENT);
		buttonValider.setFont(new Font("Arial", 1, 14));
		buttonValider.setSize(150, 30);
		buttonValider.setLocation(this.getWidth() / 2 - buttonValider.getWidth() / 2, 290);
		buttonValider.setHorizontalAlignment(SwingConstants.CENTER);
		buttonValider.setVerticalAlignment(SwingConstants.CENTER);
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JPanelIngredientOrdre[] label;
	private int xSourisClick;
	private Recette recette;

	private JButton buttonValider;

	private final int SIZE_PANEL = 100;
	private final int M_SIZE_PANEL = 50;

	private int posIngr = 130;

	private int cptBonneRep = 0;
	private int nbEssai = 4;
	private JLabelIndication labelIndication;
	private JLabel labelResultat;

	private boolean fini = false;
	private JDialog dialog;
	private JPanelRecette panelRecette;
	}
