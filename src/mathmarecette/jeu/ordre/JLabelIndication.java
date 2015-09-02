
package mathmarecette.jeu.ordre;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import mathmarecette.Tools;

public class JLabelIndication extends JLabel
	{

	/**
	 * label representant un cadre qui permet d'afficher le but du mini jeu
	 */
	private static final long serialVersionUID = -396919816700923212L;

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JLabelIndication()
		{
		this.labelText = new JLabel("<html><body><p align=\"center\"> Met dans l'ordre les actions ci-dessous pour obtenir la marche � suivre de la recette</p></body></html>");
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

	//set font
	public void setFontLabel(Font f)
		{
		labelText.setFont(f);
		}

	//set la question a afficher dans le label
	public void setQuestion(String text)
		{
		labelText.setText(text);
		}

	//Un label qui contient un label, donc lorsque on resize le label extern, on augmente celui si de +10 pour donner une marge entre le label extern et interne
	@Override
	public void setSize(int width, int height)
		{
		super.setSize(width + 10, height + 10);
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
