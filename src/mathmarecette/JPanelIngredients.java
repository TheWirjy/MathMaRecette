
package mathmarecette;

import java.awt.FlowLayout;

import javax.swing.JPanel;

public class JPanelIngredients extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelIngredients()
		{
		labelIngredient = new JLabelIngredient[4];

		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void setIngredient(Ingredient[] ingredient)
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
			labelIngredient[i] = new JLabelIngredient();
			}

			// Layout : Specification
			{
			FlowLayout flowlayout = new FlowLayout(FlowLayout.CENTER);
			setLayout(flowlayout);
			}

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
		// rien
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JLabelIngredient[] labelIngredient;
	}
