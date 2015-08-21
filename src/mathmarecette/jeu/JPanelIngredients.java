
package mathmarecette.jeu;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JPanelIngredients extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelIngredients(JPanelRecette _panelRecette, JFrame jframe)
		{
		this.labelIngredient = new JLabelIngredient[4];
		this.panelRecette = _panelRecette;
		this.jframe = jframe;
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
			labelIngredient[i] = new JLabelIngredient(panelRecette, this, jframe, i+1);
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
		//setBackground(new Color(255,246,213));
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JLabelIngredient[] labelIngredient;
	private JPanelRecette panelRecette;
	private JFrame jframe;
	}
