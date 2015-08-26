
package mathmarecette.jeu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import mathmarecette.Tools;

public class JPanelIngredients extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelIngredients(JPanelRecette _panelRecette)
		{
		this.labelIngredient = new JLabelIngredient[4];
		this.panelRecette = _panelRecette;
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void setIngredient(ImageIcon[] ingredient)
		{
		for(int i = 0; i < ingredient.length; i++)
			{
			labelIngredient[i].setIngredient(ingredient[i]);
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

	private void geometry()
		{
		// JComponent : Instanciation
		for(int i = 0; i < labelIngredient.length; i++)
			{
			labelIngredient[i] = new JLabelIngredient(panelRecette, i + 1);
			labelIngredient[i].setOpaque(false);
			}

			// Layout : Specification
			{
			FlowLayout flowlayout = new FlowLayout(FlowLayout.CENTER);
			setLayout(flowlayout);
			}

		setSize(new Dimension(600, 130));
		setLocation(0, 580);

		// JComponent : add
		for(int i = 0; i < labelIngredient.length; i++)
			{
			add(labelIngredient[i]);
			}
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		setBackground(Tools.COLOR_PANEL_INGREDIENT);
		setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JLabelIngredient[] labelIngredient;
	private JPanelRecette panelRecette;
	}
