
package mathmarecette.jeu.ordre;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import mathmarecette.jeu.Recette.Recette;

public class JFrameOrdreRecette extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JFrameOrdreRecette(Recette recette)
		{
		this.recette = recette;
		label = new JPanelOrdre[recette.getTabIngredientOrdre().length];

		/*ordre = new int[4];
		ordre[0] = 2;
		ordre[1] = 0;
		ordre[2] = 3;
		ordre[3] = 1;*/

		for(int i = 0; i < label.length; i++)
			{

			JPanelOrdre newPanel = new JPanelOrdre(i, SIZE_PANEL * i + i * 2, new ImageIcon(recette.getTabIngredientOrdre()[i].getImage()), recette.getTabIngredientOrdre()[i].getNom());
			newPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			label[i] = newPanel;
			label[i].addMouseMotionListener(new MouseMotionAdapter()
				{

					@Override
					public void mouseDragged(MouseEvent e)
						{
						// TODO Auto-generated method stub

						JPanelOrdre panelDrag = (JPanelOrdre)e.getComponent();

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
						getContentPane().setComponentZOrder(e.getComponent(), 0);
						}

					@Override
					public void mouseReleased(MouseEvent e)
						{
						JPanelOrdre panelDrag = (JPanelOrdre)e.getComponent();
						panelDrag.setLocation(panelDrag.getPositionX(), 0);
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
		label[i2].setLocation(label[i1].getPositionX(), 0);

		int tmp = label[i2].getID_pos();
		label[i2].setID_pos(label[i1].getID_pos());
		label[i1].setID_pos(tmp);

		tmp = label[i2].getPositionX();
		label[i2].setPositionX(label[i1].getPositionX());
		label[i1].setPositionX(tmp);

		JPanelOrdre temp = label[i1];
		label[i1] = label[i2];
		label[i2] = temp;
		}

	public void checkOrdre()
		{
		String txt = "";
		for(JPanelOrdre jLabelOrdre:label)
			{
			txt += jLabelOrdre.getID() + " ";
			}

		boolean bOrdrer = true;
		/*for(int i = 0; i < label.length; i++)
			{
			if (label[i].getID() != ordre[i])
				{
				bOrdrer = false;
				}
			}*/

		labelReponse.setText(txt + " " + bOrdrer);
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

		setLayout(null);

		for(int i = 0; i < recette.getTabIngredientOrdre().length; i++)
			{
			add(label[i]);
			getContentPane().setComponentZOrder(label[i], i);
			}
		}

	private void control()
		{
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}

	private void appearance()
		{
		int nbElement = recette.getTabIngredientOrdre().length;
		getContentPane().setSize(nbElement*100, 160);
		setSize(nbElement*110, 200);
		setLocationRelativeTo(null); // frame centrer
		setVisible(true); // last!
		getContentPane().setBackground(new Color(204,204,204));
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools

	private JPanelOrdre[] label;
	private int[] ordre;
	private int xSourisClick;
	private JLabel labelReponse;
	private Recette recette;

	private final int SIZE_PANEL = 100;
	private final int M_SIZE_PANEL = 50;
	}
