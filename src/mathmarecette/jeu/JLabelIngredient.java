
package mathmarecette.jeu;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JLabelIngredient extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JLabelIngredient(JPanelRecette _panelRecette, int _id)
		{
		this.panelRecette = _panelRecette;
		this.id = _id;
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	public void setIngredient(Ingredient ingr)
		{
		this.labelImage.setIcon(new ImageIcon(ingr.getImage()));
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		// JComponent : Instanciation
		labelImage = new JLabel("");

		Box boxV = Box.createVerticalBox();
		boxV.add(labelImage);
		//boxV.add(Box.createVerticalStrut(5));
		//boxV.add(labelQuantite);

		FlowLayout flowlayout = new FlowLayout(FlowLayout.CENTER);
		setLayout(flowlayout);

		// JComponent : add
		add(boxV);
		}

	private void control()
		{
		// rien
		addMouseListener(new MouseAdapter()
			{

				@Override
				public void mouseClicked(MouseEvent e)
					{
					// TODO Auto-generated method stub
					panelRecette.reponseValider(id);
					}

				@Override
				public void mousePressed(MouseEvent arg0)
					{
					// TODO Auto-generated method stub
						labelImage.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
					}

				@Override
				public void mouseReleased(MouseEvent arg0)
					{
					// TODO Auto-generated method stub
						labelImage.setBorder(null);
					}
			});
		}

	private void appearance()
		{
		// rien
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JLabel labelImage;
	private JPanelRecette panelRecette;
	private int id;
	}
