
package mathmarecette.jeu.ordre;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import mathmarecette.Tools;

public class JLabelIndication extends JLabel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/
	public JLabelIndication()
		{
		this.labelText = new JLabel("<html><body><p align=\"center\"> Met dans l'ordre les actions ci-dessous pour obtenir la marche à suivre de la recette</p></body></html>");
		this.labelText.setFont(new Font("Arial", 1, 12));
		this.labelText.setVerticalAlignment(SwingConstants.CENTER);
		this.labelText.setHorizontalAlignment(SwingConstants.CENTER);
		this.labelText.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		this.labelText.setOpaque(true);
		this.labelText.setBackground(Color.WHITE);
		this.labelText.setLocation(5, 5);

		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		setOpaque(true);
		setBackground(Tools.COLOR_CASE_CLICK_INGREDIENT);
		add(labelText);
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void setSize(int width, int height)
		{
			super.setSize(width+10, height+10);
			this.labelText.setSize(width, height);
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

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private JLabel labelText;
	}
