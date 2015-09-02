
package mathmarecette.jeu.ingredient;

import javax.swing.ImageIcon;

public class IngredientOrdre
	{

	/*
	 * Classe pour les "carte" du jeu d'ordre de la recette. Une carte est constituer d un titre et d une image en dessous
	 */
	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public IngredientOrdre(String _image, String _nom)
		{
		image = new ImageIcon(_image);
		nom = _nom;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	public ImageIcon getImage()
		{
		return this.image;
		}

	public String getNom()
		{
		return this.nom;
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	private ImageIcon image;
	private String nom;

	}
